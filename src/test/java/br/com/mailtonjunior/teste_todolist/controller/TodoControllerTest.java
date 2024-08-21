package br.com.mailtonjunior.teste_todolist.controller;

import br.com.mailtonjunior.teste_todolist.service.TodoService;
import br.com.mailtonjunior.teste_todolist.model.Todo;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(TodoController.class)
public class TodoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TodoService todoService;

    @Test
    public void testList() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/todos"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void testGetById() throws Exception {
        // Implemente o teste para o endpoint /todos/{id}
    }

    @Test
    public void testCreate() throws Exception {
        // Implemente o teste para o endpoint /todos
    }

    @Test
    public void testUpdate() throws Exception {
        // Implemente o teste para o endpoint /todos/{id}
    }

    @Test
    public void testDelete() throws Exception {
        // Implemente o teste para o endpoint /todos/{id}
    }

    @Test
    public void testListByStatus() throws Exception {
        // Implemente o teste para o endpoint /todos/status
    }
}
