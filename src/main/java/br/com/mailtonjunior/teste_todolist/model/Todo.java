package br.com.mailtonjunior.teste_todolist.model;

import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "todo")
public class Todo {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull(message = "O título é obrigatório.")
  @Size(min = 3, max = 100, message = "O título deve ter entre 3 e 100 caracteres.")
  private String title;

  @Size(max = 500, message = "A descrição deve ter no máximo 500 caracteres.")
  private String description;

  @Column(name = "created_date", updatable = false)
  private LocalDateTime createdDate;

  @Future(message = "A data de conclusão deve ser uma data futura.")
  private LocalDateTime completedDate;

  @Enumerated(EnumType.STRING)
  @NotNull(message = "O status é obrigatório.") // Adiciona validação para status
  private Status status;

  public Todo() {
    this.status = Status.PENDENTE; // Define o status padrão como pendente
  }

  public Todo(String title, String description, LocalDateTime completedDate, Status status) {
    this.title = title;
    this.description = description;
    this.completedDate = completedDate;
    this.status = status;
  }

  // Getters e Setters

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public LocalDateTime getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(LocalDateTime createdDate) {
    this.createdDate = createdDate;
  }

  public LocalDateTime getCompletedDate() {
    return completedDate;
  }

  public void setCompletedDate(LocalDateTime completedDate) {
    this.completedDate = completedDate;
  }

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  @PrePersist
  protected void onCreate() {
    this.createdDate = LocalDateTime.now();
  }

  @Override
  public String toString() {
    return "Todo{" +
        "id=" + id +
        ", title='" + title + '\'' +
        ", description='" + description + '\'' +
        ", createdDate=" + createdDate +
        ", completedDate=" + completedDate +
        ", status=" + status +
        '}';
  }

  public enum Status {
    PENDENTE,
    EM_ANDAMENTO,
    CONCLUIDO
  }
}
