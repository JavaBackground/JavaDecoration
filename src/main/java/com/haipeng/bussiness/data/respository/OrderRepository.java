package com.haipeng.bussiness.data.respository;

import com.haipeng.bussiness.data.model.Order;
import com.haipeng.bussiness.data.model.User;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order,Long>{
}
