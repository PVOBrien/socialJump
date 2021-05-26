package com.pvobrien.socialJump;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class RestTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Testing for a Successful username and password")
    public void testAuthentication() throws Exception {
        // Test for a correct pass

        this.mockMvc.perform(MockMvcRequestBuilders.post("/login")
                .content("{\"username\":\"socialJUser\", \"password\":\"socialJPVO\"}"))
                .andDo(print()).andExpect(status().isOk()); // https://howtodoinjava.com/spring-boot2/testing/spring-boot-mockmvc-example/#:~:text=MockMVC%20class%20is%20part%20of%20Spring%20MVC%20test,methods%20written%20for%20Spring%20boot%202%20hateoas%20example.
    }

    @Test
    @DisplayName("Testing for a (successful) failure")
    public void testFailAuthentication() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.post("/login")
        .content("{\"username\":\"socialJUser\", \"password\":\"FAIL\"}"))
                .andDo(print()).andExpect(status().is4xxClientError());
    }
}
