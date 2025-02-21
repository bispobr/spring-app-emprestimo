package com.loans.emprestimo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class EmprestimoRespostaDTO {
    private String type;
    private int interesRate;
}
