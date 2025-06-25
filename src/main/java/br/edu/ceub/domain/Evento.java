package br.edu.ceub.domain;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.*;

@Entity
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(name = "data_evento", nullable = false)
    private LocalDate data;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "local_id")
    private Local local;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true) // Adicionando
    @JoinColumn(name = "evento_id")
    private List<Participante> participantes;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    public List<Participante> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(List<Participante> participantes) {
        this.participantes = participantes;
    }
}