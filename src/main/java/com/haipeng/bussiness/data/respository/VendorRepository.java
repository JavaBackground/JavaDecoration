package com.haipeng.bussiness.data.respository;

import com.haipeng.bussiness.data.model.User;
import com.haipeng.bussiness.data.model.UserOrder;
import com.haipeng.bussiness.data.model.Vendor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VendorRepository extends CrudRepository<Vendor,Long>{

    @Query(value = "select v.* from vendor v where v.unique_number =?1",nativeQuery = true)
    Vendor getVendorByUniqueNumber(long uniqueNumber);
}
