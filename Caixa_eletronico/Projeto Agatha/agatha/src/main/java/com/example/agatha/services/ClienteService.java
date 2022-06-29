package com.example.agatha.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.agatha.model.Cliente;
import com.example.agatha.repositories.ClienteRepository;

@Service //aqui é a parte business ou 
public class ClienteService {

    @Autowired //o spring injeta o clienteRepository nesta classe, não instanciando toda hora
    ClienteRepository clienteRepository;

    public Cliente Inserir(Cliente cliente) { //
        cliente = clienteRepository.save(cliente);//aqui salva no banco de dados
        return cliente;
    }

    public Cliente findById(Long id) { //procurando ID
        Optional<Cliente> cliente = clienteRepository.findById(id); //achou o Id e salvou no cliente
        return cliente.get();
    }

    public void depositar(Cliente cliente, String saldo) { //para depositar
        cliente.setSaldo(cliente.getSaldo() + Double.parseDouble(saldo)); 
        clienteRepository.save(cliente);
    }

    public void sacar(Cliente cliente, String saldo) throws Exception {
        double result = cliente.getSaldo() - Double.parseDouble(saldo); //verificação de saldo
        if (result > 0) {
            cliente.setSaldo(result);
            clienteRepository.save(cliente);
        } else {
            throw new Exception("valor de saque incorreto");//se ficar negativo, não será executado
        }

    }

}
