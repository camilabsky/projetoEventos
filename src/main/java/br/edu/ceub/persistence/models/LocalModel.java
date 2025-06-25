package br.edu.ceub.persistence.models;

import jakarta.persistence.*;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "local")
public class LocalModel {
    
    @Id
    @Column(name="id", columnDefinition = "serial")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "descricao")
    String descricao;

    @Column(name = "rua", nullable = false)
    String rua;


    
        public int getId() {
            return id;
        }
    
        public void setId(int id) {
            this.id = id;
        }
    
        public String getDescricao() {
            return descricao;
        }
    
        public void setDescricao(String descricao) {
            this.descricao = descricao;
        }
    
        public String getRua() {
            return rua;
        }
    
        public void setRua(String rua) {
            this.rua = rua;
        }
}