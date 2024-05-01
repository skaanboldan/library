package com.project.library;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.library.model.Transaction;
import com.project.library.controller.TransactionController;
import com.project.library.service.TransactionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class TransactionControllerTest {

    private MockMvc mockMvc;

    @Mock
    private TransactionService transactionService;

    @InjectMocks
    private TransactionController transactionController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(transactionController).build();
    }

    @Test
    public void testAddTransaction() throws Exception {
        Transaction transaction = new Transaction(); // Create your transaction object here
        when(transactionService.addTransaction(any(Transaction.class))).thenReturn(transaction);

        mockMvc.perform(post("/transaction/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(transaction)))
                .andExpect(status().isOk());

        verify(transactionService, times(1)).addTransaction(any(Transaction.class));
    }

    @Test
    public void testListAllTransaction() throws Exception {
        List<Transaction> transactionList = new ArrayList<>(); // Add your transaction objects to the list
        when(transactionService.listAllTransaction()).thenReturn(transactionList);

        mockMvc.perform(get("/transaction/list"))
                .andExpect(status().isOk());

        verify(transactionService, times(1)).listAllTransaction();
    }

    @Test
    public void testFindUserById() throws Exception {
        long id = 2L; // Provide the ID for testing
        Transaction transaction = new Transaction(); // Create a transaction object to return
        when(transactionService.listTransactionById(id)).thenReturn(transaction);

        mockMvc.perform(get("/user/id/{id}", id))
                .andExpect(status().isOk());

        verify(transactionService, times(1)).listTransactionById(id);
    }

    // Helper method to convert objects to JSON string
    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
