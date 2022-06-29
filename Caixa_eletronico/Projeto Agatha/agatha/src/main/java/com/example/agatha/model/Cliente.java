package com.example.agatha.model;
//essa é a MODEL
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
//essa é a MODEL

@Entity
@Table(name = "CLIENTE") //table //JPA
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto-incremento //JPA 
    private long id;

    @Column(name = "nome") //JPA
    private String nome;

    @Column(name = "saldo") //JPA
    private Double saldo;

    public Cliente() {
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

}
