package com.loans.emprestimo.controller;

import com.loans.emprestimo.dto.ClienteRequisicaoDTO;
import com.loans.emprestimo.services.EmprestimoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/customer-loans")
public class EmprestimoController {

    @Autowired
    private EmprestimoService emprestimoService;

    @PostMapping
    @Operation(description = "Endpoint responsável por determinar as modalidades de empréstimos disponíveis")
    @ApiResponse(responseCode = "200", description = "modalidades de empréstimos definidos com sucesso")
    @ApiResponse(responseCode = "400", description = "Erro de Requisição, dados enviados não atendem os requisitos")
    @ApiResponse(responseCode = "500", description = "Erro interno")
    public ResponseEntity getEmpretimoDisponivel( @RequestBody @Valid ClienteRequisicaoDTO clienteRequisicaoDTO){
        log.info("requisição para definir novo emprestimo recebida cliente:" + clienteRequisicaoDTO.name());
        Map<String,Object> emprestimo = emprestimoService.definirEmprestimo(clienteRequisicaoDTO);
        return ResponseEntity.ok().body(emprestimo);
    }

}
