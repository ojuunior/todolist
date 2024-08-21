package br.com.mailtonjunior.teste_todolist.model;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

public class TodoTest {

    @Test
    public void testDefaultConstructor() {
        Todo todo = new Todo();
        assertNotNull(todo);
        assertEquals(Todo.Status.PENDENTE, todo.getStatus());
        assertNull(todo.getCreatedDate());
        assertNull(todo.getCompletedDate());
    }

    @Test
    public void testParameterizedConstructor() {
        LocalDateTime futureDate = LocalDateTime.now().plusDays(1);
        Todo todo = new Todo("Test Title", "Test Description", futureDate, Todo.Status.EM_ANDAMENTO);
        
        assertEquals("Test Title", todo.getTitle());
        assertEquals("Test Description", todo.getDescription());
        assertEquals(futureDate, todo.getCompletedDate());
        assertEquals(Todo.Status.EM_ANDAMENTO, todo.getStatus());
    }

    @Test
    public void testSettersAndGetters() {
        Todo todo = new Todo();
        todo.setTitle("New Title");
        todo.setDescription("New Description");
        LocalDateTime futureDate = LocalDateTime.now().plusDays(2);
        todo.setCompletedDate(futureDate);
        todo.setStatus(Todo.Status.CONCLUIDO);
        
        assertEquals("New Title", todo.getTitle());
        assertEquals("New Description", todo.getDescription());
        assertEquals(futureDate, todo.getCompletedDate());
        assertEquals(Todo.Status.CONCLUIDO, todo.getStatus());
    }

    @Test
    public void testOnCreate() {
        Todo todo = new Todo();
        todo.onCreate();
        
        assertNotNull(todo.getCreatedDate());
    }
}
