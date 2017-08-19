package com.haipeng.bussiness.data.respository;

import com.haipeng.bussiness.data.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long>{

    @Query(value = "select u.* from user u where u.name=?1 and u.password=?2",nativeQuery = true)
    User findUserByNameAndPassword(String name,String password);

    @Query(value = "select u.* from user u where u.unique_number=?1",nativeQuery = true)
    User findUserUserUniqueNumber(long uniqueNumber);
}
