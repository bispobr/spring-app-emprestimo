package com.loans.emprestimo.controller;

import com.loans.emprestimo.dto.ClienteRequisicaoDTO;
import com.loans.emprestimo.dto.EmprestimoRespostaDTO;
import com.loans.emprestimo.services.EmprestimoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/customer-loans")
public class EmprestimoController {

    @Autowired
    private EmprestimoService emprestimoService;

    @PostMapping
    @Operation(description = "Endpoint responsável por determinar as modalidades de empréstimos disponíveis")
    @ApiResponse(responseCode = "200", description = "modalidades de empréstimos com sucesso")
    @ApiResponse(responseCode = "400", description = "Erro de Requisição, dados enviados não atendem os requisitos")
    @ApiResponse(responseCode = "500", description = "Erro interno")
    public Map<String, Object> getEmpretimoDisponivel(@Valid @RequestBody ClienteRequisicaoDTO clienteRequisicaoDTO){
        log.info("requisição para definir novo emprestimo recebida cliente:" + clienteRequisicaoDTO.name());
        List<EmprestimoRespostaDTO> emprestimo = emprestimoService.definirEmprestimo(clienteRequisicaoDTO);

        Map<String,Object> resposta =  new HashMap<>();
        resposta.put("customer", clienteRequisicaoDTO.name());
        resposta.put("loans",emprestimo);

        return resposta;
    }

}
