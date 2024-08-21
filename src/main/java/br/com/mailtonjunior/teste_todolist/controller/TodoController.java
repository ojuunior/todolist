package br.com.mailtonjunior.teste_todolist.controller;

import br.com.mailtonjunior.teste_todolist.model.Todo;
import br.com.mailtonjunior.teste_todolist.service.TodoService;

import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todos")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public List<Todo> list() {
        return todoService.list();
    }

    @GetMapping("/{id}")
    public Todo getById(@PathVariable Long id) {
        return todoService.getById(id);
    }
    
    @PostMapping
    public List<Todo> create(@RequestBody Todo todo) {
        return todoService.create(todo);
    }

    @PutMapping("/{id}")
    public List<Todo> update(@PathVariable Long id, @RequestBody Todo todo) {
        return todoService.update(todo);
    }

    @DeleteMapping("/{id}")
    public List<Todo> delete(@PathVariable Long id) {
        return todoService.delete(id);
    }

    @GetMapping("/status")
    public List<Todo> listByStatus(@RequestParam("status") Todo.Status status) {
        return todoService.listByStatus(status);
    }

    
}
