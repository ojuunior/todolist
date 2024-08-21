package br.com.mailtonjunior.teste_todolist.controller;

import br.com.mailtonjunior.teste_todolist.model.Todo;
import br.com.mailtonjunior.teste_todolist.service.TodoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @Operation(summary = "Listar Tarefas", description = "Recuperar uma lista de todas as Tarefas")
    @GetMapping
    public List<Todo> list() {
        return todoService.list();
    }

    @Operation(summary = "Obter Tarefa por ID", description = "Recuperar uma Tarefa específica pelo seu ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tarefa encontrada", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Todo.class))),
            @ApiResponse(responseCode = "404", description = "Tarefa não encontrada")
    })
    @GetMapping("/{id}")
    public Todo getById(@PathVariable Long id) {
        return todoService.getById(id);
    }

    @Operation(summary = "Criar um nova Tarefa", description = "Criar um nova item Tarefa")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tarefa criado", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Todo.class)))
    })
    @PostMapping
    public List<Todo> create(@RequestBody Todo todo) {
        return todoService.create(todo);
    }

    @Operation(summary = "Atualizar uma Tarefa existente", description = "Atualizar um Tarefa específica pelo seu ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tarefa atualizada", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Todo.class))),
            @ApiResponse(responseCode = "404", description = "Tarefa não encontrada")
    })
    @PutMapping("/{id}")
    public List<Todo> update(@PathVariable Long id, @RequestBody Todo todo) {
        return todoService.update(todo);
    }

    @Operation(summary = "Deletar uma Tarefa", description = "Deletar uma Tarefa específica pelo seu ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tarefa deletada"),
            @ApiResponse(responseCode = "404", description = "Tarefa não encontrada")
    })
    @DeleteMapping("/{id}")
    public List<Todo> delete(@PathVariable Long id) {
        return todoService.delete(id);
    }

    @Operation(summary = "Listar Tarefas por status", description = "Recuperar uma lista de Tarefas filtrados pelo status")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tarefas encontradas", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Todo.class)))
    })
    @GetMapping("/status")
    public List<Todo> listByStatus(@RequestParam("status") Todo.Status status) {
        return todoService.listByStatus(status);
    }
}
