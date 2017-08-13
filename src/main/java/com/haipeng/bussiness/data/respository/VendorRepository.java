package com.haipeng.bussiness.data.respository;

import com.haipeng.bussiness.data.model.User;
import com.haipeng.bussiness.data.model.Vendor;
import org.springframework.data.repository.CrudRepository;

public interface VendorRepository extends CrudRepository<Vendor,Long>{
}
