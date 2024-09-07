package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testCreateUser() throws Exception {
        mockMvc.perform(post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"username\":\"user1\", \"email\":\"user1@example.com\"}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.username").value("user1"))
                .andExpect(jsonPath("$.email").value("user1@example.com"));
    }

    @Test
    public void testGetUser() throws Exception {
        // Create user first
        mockMvc.perform(post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"username\":\"user2\", \"email\":\"user2@example.com\"}"))
                .andExpect(status().isCreated());

        // Get user
        mockMvc.perform(get("/users/user2"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.username").value("user2"))
                .andExpect(jsonPath("$.email").value("user2@example.com"));
    }

    @Test
    public void testUpdateUser() throws Exception {
        // Create user first
        mockMvc.perform(post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"username\":\"user3\", \"email\":\"user3@example.com\"}"))
                .andExpect(status().isCreated());

        // Update user
        mockMvc.perform(put("/users/user3")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"username\":\"user3_updated\", \"email\":\"user3_updated@example.com\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.username").value("user3_updated"))
                .andExpect(jsonPath("$.email").value("user3_updated@example.com"));
    }

    @Test
    public void testDeleteUser() throws Exception {
        // Create user first
        mockMvc.perform(post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"username\":\"user4\", \"email\":\"user4@example.com\"}"))
                .andExpect(status().isCreated());

        // Delete user
        mockMvc.perform(delete("/users/user4"))
                .andExpect(status().isOk());

        // Try to get deleted user
        mockMvc.perform(get("/users/user4"))
                .andExpect(status().isNotFound());
    }
}
