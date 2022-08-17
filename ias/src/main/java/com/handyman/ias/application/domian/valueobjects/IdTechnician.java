package com.handyman.ias.application.domian.valueobjects;

import lombok.Data;
import org.apache.commons.lang3.Validate;

@Data
public class IdTechnician {
    private String value;
    public IdTechnician(String value) {
        Validate.notNull(value, "El número de identificación no puede estar vacío");
        Validate.isTrue(value.length() == 8, "Número de identificación inválido");
        this.value = value;
    }
}
