package com.loans.emprestimo.services;


import com.loans.emprestimo.dto.ClienteRequisicaoDTO;
import com.loans.emprestimo.dto.DTO;
import com.loans.emprestimo.mapper.CustomerMapper;
import com.loans.emprestimo.model.Customer;
import com.loans.emprestimo.model.LoanType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class EmprestimoService {

    @Autowired
    private CustomerMapper customerMapper;

    public Map<String,Object> definirEmprestimo(ClienteRequisicaoDTO clienteRequisicaoDTO){

        Customer cliente = customerMapper.paraCustomer(clienteRequisicaoDTO);

        List<DTO> emprestimo = new ArrayList<>();

        List<DTO> resultados = modalidades(cliente,emprestimo);

        Map<String,Object> emprestimosConcedidos = new HashMap<>();
        emprestimosConcedidos.put("loans",resultados);
        emprestimosConcedidos.put("customer", clienteRequisicaoDTO.name());
        log.info("modalidades de empréstimo definida"); return emprestimosConcedidos;
    }

    public List<DTO> modalidades (Customer cliente, List<DTO> emprestimo ){
        if (cliente.getIncome() > 0 & cliente.getIncome() <= 3000){
            emprestimo.add(new DTO(LoanType.PERSONAL,4));
            emprestimo.add(new DTO(LoanType.GUARANTEED,3));
        }
        if (cliente.getIncome() >= 5000){
            emprestimo.add(new DTO(LoanType.CONSIGNMENT,2));
        }

        if(cliente.getIncome() >= 3000 && cliente.getIncome() <= 5000 && cliente.getAge() < 30 && "SP".equalsIgnoreCase(cliente.getLocation())){
            emprestimo.add(new DTO(LoanType.PERSONAL,4));
            emprestimo.add(new DTO(LoanType.GUARANTEED,3));
        }

        if (emprestimo.isEmpty()){
            emprestimo.add(new DTO(LoanType.NENHUM,0));
            return emprestimo;
        }
        return emprestimo;
    }
}
