package com.zitrus.enums.converter;

import com.zitrus.enums.Sexo;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class SexoConverter implements AttributeConverter<Sexo, String> {

    @Override
    public String convertToDatabaseColumn(Sexo sexo) {
        if (sexo == null) return null;

        return sexo.getValue();
    }

    @Override
    public Sexo convertToEntityAttribute(String code) {
        if (code == null) return null;

        return Stream.of(Sexo.values())
                .filter(c -> c.getValue().equals(code))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}