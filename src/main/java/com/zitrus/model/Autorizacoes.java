package com.zitrus.model;

import com.zitrus.enums.Sexo;
import com.zitrus.enums.SituacaoAutorizacao;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Autorizacoes {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_procedimento")
    private Procedimentos procedimento;

    private Long idade;

    private Sexo sexo;

    @Enumerated(EnumType.ORDINAL)
    private SituacaoAutorizacao situacao;
}