package com.loans.emprestimo.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ClienteRequisicaoDTO(@NotNull int age, @NotNull double income, @NotBlank String location,@NotBlank String name,@NotBlank String  cpf) {

}
