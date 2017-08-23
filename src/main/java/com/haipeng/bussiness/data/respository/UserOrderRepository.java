package com.haipeng.bussiness.data.respository;

import com.haipeng.bussiness.data.model.UserOrder;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserOrderRepository extends CrudRepository<UserOrder,Long>{

    @Query(value = "select o.* from user_order o where o.user_unique_number =?1",nativeQuery = true)
    List<UserOrder> getOrdersByUserUniqueNumnber(long uniqueNumber);

    @Query(value = "select o.* from user_order o where o.unique_number =?1",nativeQuery = true)
    UserOrder getOrderByUniqueNumber(long userUniqueNumber);
}
