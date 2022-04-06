package com.zitrus.enums;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SexoTest {

    @Test
    void getValue() {
        String masculino = Sexo.valueOf("MASCULINO").getValue();
        assertEquals("M", masculino);
        String feminino = Sexo.valueOf("FEMININO").getValue();
        assertEquals("F", feminino);
    }

    @Test
    void getDescricao() {
        String masculino = Sexo.valueOf("MASCULINO").getDescricao();
        assertEquals("Masculino", masculino);
        String feminino = Sexo.valueOf("FEMININO").getDescricao();
        assertEquals("Feminino", feminino);
    }
}