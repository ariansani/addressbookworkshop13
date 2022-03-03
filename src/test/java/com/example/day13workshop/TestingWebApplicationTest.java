package com.example.day13workshop;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class TestingWebApplicationTest {
    private Logger logger = Logger.getLogger(TestingWebApplicationTest.class.getName());
    
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void saveContactTest() throws Exception{
        Map<String, String> input = new HashMap<>();
        input.put("name","Ari");
        input.put("email","ari@a.com");
        input.put("phoneNumber","3245");
        logger.log(Level.INFO, ""+objectMapper.writeValueAsString(input));
        
        mockMvc.perform(post("/contact")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(input))
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isCreated());
    }
}
