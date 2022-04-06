package com.zitrus.repository;

import com.zitrus.model.Autorizacoes;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAutorizacoesRepo extends JpaRepository<Autorizacoes, Long> {

    default List<Autorizacoes> findAllOrderId() {
        return this.findAll(Sort.by(Sort.Order.desc("id")));
    }

}
