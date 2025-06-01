package com.loans.emprestimo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public record EmprestimoRespostaDTO(@NotBlank String type,@NotNull int interesRate) {
    public EmprestimoRespostaDTO(@NotBlank String type, @NotNull int interesRate) {
        this.type = type;
        this.interesRate = interesRate;
    }
}
