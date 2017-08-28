package com.haipeng.bussiness.data.respository;

import com.haipeng.bussiness.data.model.Template;
import com.haipeng.bussiness.data.model.Template;
import com.haipeng.bussiness.data.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface TemplateRepository extends CrudRepository<Template,Long>{

    @Query(value = "select t.* from template t where t.unique_number =?1",nativeQuery = true)
    Template getTemplateByUniqueNumber(long uniqueNumber);
}
