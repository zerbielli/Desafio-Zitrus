package com.zitrus.repository;

import com.zitrus.model.Procedimentos;
import com.zitrus.model.ProcedimentosRegras;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IProcedimentosRegrasRepo extends CrudRepository<ProcedimentosRegras, Long> {

    @Query("SELECT 1 FROM ProcedimentosRegras pr " +
            "WHERE pr.procedimento = :procedimento " +
            "and pr.idade = :idade " +
            "and pr.sexo = :sexo "
    )
    Optional<Long> findAutorizacaoProcedimento(
            @Param("procedimento") Procedimentos procedimento,
            @Param("idade") Long idade,
            @Param("sexo") String sexo
    );

}
