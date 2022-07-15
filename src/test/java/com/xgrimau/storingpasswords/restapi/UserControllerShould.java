package com.xgrimau.storingpasswords.restapi;

import com.xgrimau.storingpasswords.repository.UserRepository;
import com.xgrimau.storingpasswords.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class UserControllerShould {

    @Autowired
    public MockMvc mockMvc;

    @MockBean
    private UserRepository userRepository;

    @MockBean
    public UserService userService;

    @Test
    void register_user() throws Exception {
        mockMvc.perform(post("/api/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                    "username":"aUserName",
                                    "password":"aPlainPassword"
                                }
                                """)
                )
                .andExpect(status().isOk());

        verify(userService).registerUser("aUserName","aPlainPassword");
    }
}