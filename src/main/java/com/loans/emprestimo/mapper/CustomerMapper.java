package com.loans.emprestimo.mapper;

import com.loans.emprestimo.dto.ClienteRequisicaoDTO;
import com.loans.emprestimo.model.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {
    public Customer paraCustomer (ClienteRequisicaoDTO dto){
        return new Customer(dto.age(), dto.income(), dto.location(), dto.name(), dto.cpf());
    }

}
