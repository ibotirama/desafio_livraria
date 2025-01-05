package br.com.rocketseat.livraria.handlers;

import br.com.rocketseat.livraria.Biblioteca;
import br.com.rocketseat.livraria.Cliente;

import java.util.Scanner;

public class ClienteHandler {
    private final Biblioteca biblioteca;

    public ClienteHandler(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    public void cadastrar() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome do cliente:");
        String nome = scanner.nextLine();

        System.out.println("Digite o email do cliente:");
        String email = scanner.nextLine();

        Cliente cliente = new Cliente(getUltimoIdMaisUm(), nome, email);
        System.out.println("Cliente cadastrado com sucesso!");

        biblioteca.adicionarCliente(cliente);
    }

    private Long getUltimoIdMaisUm() {
        return (long) biblioteca.getClientes().size() + 1;
    }

    public void listar() {
        System.out.println(String.format("%-10s %-20s %-30s", "ID", "Nome", "Email"));
        for (Cliente cliente : biblioteca.getClientes()) {
            System.out.println(String.format("%-10s %-20s %-30s", cliente.getId(), cliente.getNome(), cliente.getEmail()));
        }
    }
}
