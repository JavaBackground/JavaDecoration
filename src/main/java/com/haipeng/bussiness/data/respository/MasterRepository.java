package com.haipeng.bussiness.data.respository;

import com.haipeng.bussiness.data.model.Master;
import com.haipeng.bussiness.data.model.User;
import com.haipeng.bussiness.data.model.Vendor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface MasterRepository extends CrudRepository<Master,Long>{

    @Query(value = "select m.* from master m where m.unique_number =?1 limit 0,1",nativeQuery = true)
    Master getMasterByUniqueNumber(long uniqueNumber);
}
