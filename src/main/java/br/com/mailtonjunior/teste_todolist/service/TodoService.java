package br.com.mailtonjunior.teste_todolist.service;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.mailtonjunior.teste_todolist.model.Todo;
import br.com.mailtonjunior.teste_todolist.repository.TodoRepository;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> list() {
        Sort sort = Sort.by(Direction.DESC, "completedDate")
                .and(Sort.by(Direction.ASC, "completedDate"));
        return todoRepository.findAll(sort);
    }

    public List<Todo> create(Todo todo) {
        todoRepository.save(todo);
        return list();
    }

    public List<Todo> update(Todo todo) {
        todoRepository.save(todo);
        return list();
    }

    public List<Todo> delete(Long id) {
        todoRepository.deleteById(id);
        return list();
    }

    @GetMapping("/todos/status")
    public List<Todo> listByStatus(Todo.Status status) {
        return todoRepository.findByStatus(status);
    }

    // Método para buscar por ID
    public Todo getById(Long id) {
        return todoRepository.findById(id).orElse(null);
    }
}
