package com.TechnicalTest;

import com.TechnicalTest.Controllers.UserControllers;
import com.TechnicalTest.Models.UserEntity;
import com.TechnicalTest.Responses.DataResponse;
import com.TechnicalTest.Services.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.SpringVersion;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(UserControllers.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void testGetUsers() throws Exception{
        mvc.perform(get("/users/getAllUsers")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
