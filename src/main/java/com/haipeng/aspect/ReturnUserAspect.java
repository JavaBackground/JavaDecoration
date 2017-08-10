package com.haipeng.aspect;

import com.haipeng.Application;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Aspect
@Component
@ComponentScan(basePackageClasses = Application.class, useDefaultFilters = true)
public class ReturnUserAspect {

//    @Pointcut("execution(public * com.haipeng.bussiness..*.*(..))")
//    @Pointcut("(execution(* com.haipeng.bussiness.data.service.UserService.*(..)))||(execution(* com.haipeng.bussiness.data.controller.UserController.*(..)))")
//    @Pointcut("execution(* com.haipeng.bussiness.data.service.UserService.getAllSuperUser())") //AOP就是动态绑定，需要方法是接口方法

    @Pointcut("execution(* com.haipeng.bussiness.data.service.implement.UserServiceImpl.clone())") // 无效的路径
    public void recordLog() {

    }

    @Before("recordLog()")
    public void before() {
        this.printLog("已经记录下操作日志@Before 方法执行前");
    }

    @Around("recordLog()")
    public void around(ProceedingJoinPoint pjp) throws Throwable {
        this.printLog("已经记录下操作日志@Around 方法执行前");
        Object object = pjp.proceed();
        this.printLog("已经记录下操作日志@Around 方法执行后");
    }

    @After("recordLog()")
    public void after() {
        this.printLog("已经记录下操作日志@After 方法执行后");
    }

    private void printLog(String str) {
        System.out.println(str);
    }
}
