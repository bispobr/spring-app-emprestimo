package com.loans.emprestimo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.loans.emprestimo.dto.ClienteRequisicaoDTO;
import com.loans.emprestimo.dto.DTO;
import com.loans.emprestimo.model.LoanType;
import com.loans.emprestimo.services.EmprestimoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import java.util.HashMap;
import java.util.List;
import java.util.Map;


import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class EmprestimoControllerTest {

    @Mock
    private EmprestimoService emprestimoService;

    @InjectMocks
    private EmprestimoController emprestimoController;
    private ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    MockMvc mockMvc;

    @BeforeEach
    void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(emprestimoController).build();
    }

    @Test
    public void getEmprestimoDisponivel_DadosValidos_DeveRetornar200() throws Exception {
        ClienteRequisicaoDTO requisicao = new ClienteRequisicaoDTO(30,2500.0,"RJ", "João", "00000000000");

        Map<String, Object> mockResposta = new HashMap<>();
        mockResposta.put("customer", "João");
        mockResposta.put("loans", List.of(new DTO(LoanType.PERSONAL, 4)));

        when(emprestimoService.definirEmprestimo(requisicao)).thenReturn(mockResposta);

        mockMvc.perform(post("/customer-loans")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(requisicao)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.customer").value("João"))
                .andExpect(jsonPath("$.loans[0].type").value("PERSONAL"))
                .andExpect(jsonPath("$.loans[0].interesRate").value(4));
    }

    @Test
    public void getEmprestimoDisponivel_DadosInvalidos_DeveRetornar400() throws Exception {
        ClienteRequisicaoDTO requisicao = new ClienteRequisicaoDTO(30,2500.0,"RJ", null, "00000000000");

        mockMvc.perform(post("/customer-loans")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(requisicao)))
                .andExpect(status().isBadRequest());
    }


}