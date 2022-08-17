package com.sicredi.exercicio2.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Erro {

    private String msgUser;
    private String msgDev;
}
