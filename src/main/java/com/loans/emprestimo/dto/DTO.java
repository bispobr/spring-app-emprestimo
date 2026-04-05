package com.loans.emprestimo.dto;

import com.loans.emprestimo.model.LoanType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public record DTO(@NotBlank LoanType type, @NotNull int interesRate) {
    public DTO(@NotBlank LoanType type, @NotNull int interesRate) {
        this.type = type;
        this.interesRate = interesRate;
    }
}
