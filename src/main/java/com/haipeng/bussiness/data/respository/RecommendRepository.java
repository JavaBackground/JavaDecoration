package com.haipeng.bussiness.data.respository;

import com.haipeng.bussiness.data.model.Recommend;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface RecommendRepository extends CrudRepository<Recommend,Long>{
    @Query(value = "select r.* from recommend r where r.unique_number =?1",nativeQuery = true)
    Recommend getRecommendByUniqueNumber(long uniqueNumber);
}
