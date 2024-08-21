package br.com.mailtonjunior.teste_todolist.repository;

import br.com.mailtonjunior.teste_todolist.model.Todo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class TodoRepositoryTest {

    @Autowired
    private TodoRepository todoRepository;

    @BeforeEach
    public void setUp() {
        todoRepository.deleteAll(); // Limpa os dados antes de cada teste
    }

    @Test
    public void testFindByStatus() {
        // Arrange
        Todo todo1 = new Todo("Task 1", "Description 1", LocalDateTime.now().plusDays(1), Todo.Status.PENDENTE);
        Todo todo2 = new Todo("Task 2", "Description 2", LocalDateTime.now().plusDays(2), Todo.Status.CONCLUIDO);
        todoRepository.save(todo1);
        todoRepository.save(todo2);

        // Act
        List<Todo> pendingTodos = todoRepository.findByStatus(Todo.Status.PENDENTE);
        List<Todo> completedTodos = todoRepository.findByStatus(Todo.Status.CONCLUIDO);

        // Assert
        assertEquals(1, pendingTodos.size());
        assertEquals("Task 1", pendingTodos.get(0).getTitle());
        assertEquals(1, completedTodos.size());
        assertEquals("Task 2", completedTodos.get(0).getTitle());
    }

    @Test
    public void testFindByStatusEmpty() {
        // Act
        List<Todo> todos = todoRepository.findByStatus(Todo.Status.PENDENTE);

        // Assert
        assertTrue(todos.isEmpty());
    }
}
