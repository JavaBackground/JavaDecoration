package com.haipeng.bussiness.data.respository;

import com.haipeng.bussiness.data.model.User;
import org.springframework.data.repository.CrudRepository;

public interface MasterRepository extends CrudRepository<User,Long>{
}
