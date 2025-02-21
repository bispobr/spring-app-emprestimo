package com.loans.emprestimo.controller;

import com.loans.emprestimo.dto.ClienteRequisicaoDTO;
import com.loans.emprestimo.dto.EmprestimoRespostaDTO;
import com.loans.emprestimo.services.EmprestimoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/customer-loans")
public class EmprestimoController {

    @Autowired
    private EmprestimoService emprestimoService;

    @PostMapping
    public Map<String, Object> getEmpretimoDisponivel(@RequestBody ClienteRequisicaoDTO clienteRequisicaoDTO){

        List<EmprestimoRespostaDTO> emprestimo = emprestimoService.definirEmprestimo(clienteRequisicaoDTO);

        Map<String,Object> resposta =  new HashMap<>();
        resposta.put("customer", clienteRequisicaoDTO.getName());
        resposta.put("loans",emprestimo);

        return resposta;
    }

}
