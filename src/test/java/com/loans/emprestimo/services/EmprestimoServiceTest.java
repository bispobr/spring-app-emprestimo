package com.loans.emprestimo.services;

import com.loans.emprestimo.dto.ClienteRequisicaoDTO;
import com.loans.emprestimo.dto.DTO;
import com.loans.emprestimo.mapper.CustomerMapper;
import com.loans.emprestimo.model.Customer;
import com.loans.emprestimo.model.LoanType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EmprestimoServiceTest {

    @Mock
    private CustomerMapper customerMapper;

    @InjectMocks
    private EmprestimoService service;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void definirEmprestimo_RendaBaixa_DeveRetornarPersonalEGarantido() {
        ClienteRequisicaoDTO requisicao = new ClienteRequisicaoDTO(35,2500.0,"RJ", "João", "00000000000");
        Customer cliente = new Customer(35,2500.0,"RJ","João", "00000000000");

        when(customerMapper.paraCustomer(requisicao)).thenReturn(cliente);

        Map<String, Object> resultado = service.definirEmprestimo(requisicao);

        assertEquals("João", resultado.get("customer"));

        List<DTO> emprestimos = (List<DTO>) resultado.get("loans");
        assertTrue(emprestimos.contains(new DTO(LoanType.PERSONAL, 4)));
        assertTrue(emprestimos.contains(new DTO(LoanType.GUARANTEED, 3)));
    }

    @Test
    public void definirEmprestimo_RendaAlta_DeveRetornarConsignado() {
        ClienteRequisicaoDTO requisicao = new ClienteRequisicaoDTO(40, 6000.0, "SP", "Maria","11111111111");
        Customer cliente = new Customer(40,6000.0,"SP","Maria","11111111111");

        when(customerMapper.paraCustomer(requisicao)).thenReturn(cliente);

        Map<String, Object> resultado = service.definirEmprestimo(requisicao);

        List<DTO> emprestimos = (List<DTO>) resultado.get("loans");
        assertEquals(1, emprestimos.size());
        assertEquals(LoanType.CONSIGNMENT, emprestimos.get(0).type());
    }

    @Test
    public void definirEmprestimo_RendaMediaJovemSP_DeveRetornarPersonalEGarantido() {
        ClienteRequisicaoDTO requisicao = new  ClienteRequisicaoDTO(25, 4000.0, "SP", "Carlos","11111111100");
        Customer cliente = new Customer(25,4000.0,"SP","Carlos","11111111100");

        when(customerMapper.paraCustomer(requisicao)).thenReturn(cliente);

        Map<String, Object> resultado = service.definirEmprestimo(requisicao);

        List<DTO> emprestimos = (List<DTO>) resultado.get("loans");

        assertTrue(emprestimos.contains(new DTO(LoanType.PERSONAL, 4)));
        assertTrue(emprestimos.contains(new DTO(LoanType.GUARANTEED, 3)));
    }

    @Test
    public void definirEmprestimo_SemEmprestimoPossivel_DeveRetornarNenhum() {
        ClienteRequisicaoDTO requisicao = new ClienteRequisicaoDTO(50, 0.0, "MG", "Ana","11111111199");
        Customer cliente = new Customer(50,0.0,"MG","Ana","11111111199");

        when(customerMapper.paraCustomer(requisicao)).thenReturn(cliente);

        Map<String, Object> resultado = service.definirEmprestimo(requisicao);

        List<DTO> emprestimos = (List<DTO>) resultado.get("loans");

        assertEquals(1, emprestimos.size());
        assertEquals(LoanType.NENHUM, emprestimos.get(0).type());
    }

}