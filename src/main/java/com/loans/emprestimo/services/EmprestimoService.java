package com.loans.emprestimo.services;


import com.loans.emprestimo.dto.ClienteRequisicaoDTO;
import com.loans.emprestimo.dto.EmprestimoRespostaDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class EmprestimoService {

    public List<EmprestimoRespostaDTO> definirEmprestimo(ClienteRequisicaoDTO clienteRequisicaoDTO){

        int age = clienteRequisicaoDTO.age();
        double income = clienteRequisicaoDTO.income();
        String location = clienteRequisicaoDTO.location();

        List<EmprestimoRespostaDTO> emprestimo =  new ArrayList<>();

        if (income <= 3000){
            emprestimo.add(new EmprestimoRespostaDTO("PERSONAL",4));
            emprestimo.add(new EmprestimoRespostaDTO("GUARANTEED",3));
        }

        if (income >= 5000){
            emprestimo.add(new EmprestimoRespostaDTO("CONSIGMENT",2));
        }

        if(income >= 3000 && income <= 5000 && age < 30 && "SP".equalsIgnoreCase(location)){
            emprestimo.add(new EmprestimoRespostaDTO("PERSONAL",4));
            emprestimo.add(new EmprestimoRespostaDTO("GUARANTEED",3));
        }
        log.info("modalidades de empréstimo definida");
        return  emprestimo;
    }
}
