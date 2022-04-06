package com.zitrus.repository;

import com.zitrus.model.Procedimentos;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProcedimentosRepo extends CrudRepository<Procedimentos, Long> {

}
