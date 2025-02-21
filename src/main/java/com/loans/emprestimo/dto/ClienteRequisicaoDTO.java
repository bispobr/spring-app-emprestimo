package com.loans.emprestimo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClienteRequisicaoDTO {

    private int age;
    private double income ;
    private String localation ;
    private String name ;
    private String  cpf;
}
