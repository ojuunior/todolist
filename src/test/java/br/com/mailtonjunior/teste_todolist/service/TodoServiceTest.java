package br.com.mailtonjunior.teste_todolist.service;

import br.com.mailtonjunior.teste_todolist.model.Todo;
import br.com.mailtonjunior.teste_todolist.repository.TodoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Sort;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

public class TodoServiceTest {

    @InjectMocks
    private TodoService todoService;

    @Mock
    private TodoRepository todoRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testList() {
        // Arrange
        Todo todo1 = new Todo("Task 1", "Description 1", LocalDateTime.now().plusDays(1), Todo.Status.PENDENTE);
        Todo todo2 = new Todo("Task 2", "Description 2", LocalDateTime.now().plusDays(2), Todo.Status.CONCLUIDO);
        List<Todo> todos = Arrays.asList(todo1, todo2);

        when(todoRepository.findAll(any(Sort.class))).thenReturn(todos);

        // Act
        List<Todo> result = todoService.list();

        // Assert
        assertEquals(2, result.size());
        assertEquals("Task 1", result.get(0).getTitle());
        assertEquals("Task 2", result.get(1).getTitle());
    }

    @Test
    public void testCreate() {
        // Arrange
        Todo todo = new Todo("New Task", "Description", LocalDateTime.now().plusDays(1), Todo.Status.PENDENTE);
        when(todoRepository.save(any(Todo.class))).thenReturn(todo);
        when(todoRepository.findAll(any(Sort.class))).thenReturn(Arrays.asList(todo));

        // Act
        List<Todo> result = todoService.create(todo);

        // Assert
        assertEquals(1, result.size());
        assertEquals("New Task", result.get(0).getTitle());
    }

    @Test
    public void testUpdate() {
        // Arrange
        Todo todo = new Todo("Updated Task", "Description", LocalDateTime.now().plusDays(1), Todo.Status.PENDENTE);
        when(todoRepository.save(any(Todo.class))).thenReturn(todo);
        when(todoRepository.findAll(any(Sort.class))).thenReturn(Arrays.asList(todo));

        // Act
        List<Todo> result = todoService.update(todo);

        // Assert
        assertEquals(1, result.size());
        assertEquals("Updated Task", result.get(0).getTitle());
    }

    @Test
    public void testDelete() {
        // Arrange
        Todo todo = new Todo("Task to Delete", "Description", LocalDateTime.now().plusDays(1), Todo.Status.PENDENTE);
        when(todoRepository.findAll(any(Sort.class))).thenReturn(Arrays.asList());

        // Act
        List<Todo> result = todoService.delete(1L);

        // Assert
        verify(todoRepository, times(1)).deleteById(anyLong());
        assertTrue(result.isEmpty());
    }

    @Test
    public void testGetById() {
        // Arrange
        Todo todo = new Todo();
        todo.setId(1L);
        todo.setTitle("Task 1");

        when(todoRepository.findById(anyLong())).thenReturn(Optional.of(todo));

        // Act
        Todo result = todoService.getById(1L);

        // Assert
        assertNotNull(result);
        assertEquals("Task 1", result.getTitle());
    }
}
