package com.TechnicalTest;

import com.TechnicalTest.Controllers.UserControllers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(UserControllers.class)
@SpringBootTest
public class TransactionHistoryServiceTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void testGetTransType() throws Exception{
        mvc.perform(get("/transaction-history/getAllTransactionHistory")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
