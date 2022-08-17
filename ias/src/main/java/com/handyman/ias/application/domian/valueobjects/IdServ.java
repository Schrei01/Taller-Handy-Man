package com.handyman.ias.application.domian.valueobjects;

import lombok.Data;
import org.apache.commons.lang3.Validate;

@Data
public class IdServ {
    private String value;
    public IdServ(String value) {
        Validate.notNull(value, "El número de identificación del servicio no puede estar vacío");
        Validate.isTrue(value.length() == 10, "El número de identificación del servicio no es válido");
        this.value = value;
    }
}
