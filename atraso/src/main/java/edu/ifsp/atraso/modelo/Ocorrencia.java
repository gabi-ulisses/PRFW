package edu.ifsp.atraso.modelo;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Ocorrencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer id;

    @Size(min = 5, message = "{cliente.nome.size}")
    private String nome_aluno;

    private LocalDateTime horario;

    @NotBlank(message = "A justificativa é obrigatória")
    private String justificativa;

    public Ocorrencia() {
    }

    @PrePersist
    protected void onCreate() {
        if (this.horario == null) {
            this.horario = LocalDateTime.now();
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome_aluno() {
        return nome_aluno;
    }

    public void setNome_aluno(String nome_aluno) {
        this.nome_aluno = nome_aluno;
    }

    public LocalDateTime getHorario() {
        return horario;
    }

    public String getJustificativa() {
        return justificativa;
    }

    public void setJustificativa(String justificativa) {
        this.justificativa = justificativa;
    }
}
