package com.zitrus.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class ProcedimentosRegras {
    @Id
    @Column(nullable = false)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_procedimento")
    private Procedimentos procedimento;
    private Long idade;
    private String sexo;

}