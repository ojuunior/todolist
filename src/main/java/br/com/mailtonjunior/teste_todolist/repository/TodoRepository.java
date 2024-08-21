package br.com.mailtonjunior.teste_todolist.repository;

import java.util.List;

import br.com.mailtonjunior.teste_todolist.model.Todo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
    List<Todo> findByStatus(Todo.Status status);
}
