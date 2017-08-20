package com.haipeng.bussiness.data.respository;

import com.haipeng.bussiness.data.model.UserOrder;
import org.springframework.data.repository.CrudRepository;

public interface UserOrderRepository extends CrudRepository<UserOrder,Long>{
}
