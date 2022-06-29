package com.example.agatha.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.agatha.model.Cliente;
import com.example.agatha.services.ClienteService;

@Controller //Esse é o controller, que são os endpoints 
public class ClienteController {
    @Autowired//o spring injeta o ClienteService nesta classe, não instanciando toda hora
    ClienteService clienteService;

    @RequestMapping(value = "/") //esses são os caminhos 
    public String index(Cliente cliente) {
        return "principal";
    }

    @RequestMapping(path = "/cadastrar", method = RequestMethod.POST) //esses são os caminhos 
    public String cadastrar(Cliente cliente) throws Exception {
        try {
            clienteService.Inserir(cliente); //chama o metodo 
            return "principal";
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @RequestMapping(value = { "/consultar", "/consultar/{id}" }) //esses são os caminhos. Consultando por ID
    public String consultarCliente(Model model, @PathVariable("id") Optional<Long> id) throws Exception {
        try {
            Cliente clienteTela = clienteService.findById(id.get());
            model.addAttribute("cliente", clienteTela);
            return "telaCliente"; //retorna os valores lá na tela 
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }

    @RequestMapping(value = "/alterar", method = RequestMethod.POST) //esses são os caminhos 
    public String depositarSacarCliente(Cliente cliente,
            @RequestParam(value = "dinheiro", required = false) String saldo,
            @RequestParam(value = "action", required = true) String action) throws Exception {
        try {
            if (action.equals("depositar")) { //escolha da action
                clienteService.depositar(cliente, saldo);
            } else {
                clienteService.sacar(cliente, saldo);
            }
            return "redirect:/consultar/" + cliente.getId();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }
}
