package com.example.agatha.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.agatha.model.Cliente;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> { // CrudRepository é uma biblioteca do Spring 

}

//funções de CRUD