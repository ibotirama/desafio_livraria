package br.com.rocketseat.livraria.handlers;

import br.com.rocketseat.livraria.Biblioteca;
import br.com.rocketseat.livraria.Cliente;
import br.com.rocketseat.livraria.Emprestimo;
import br.com.rocketseat.livraria.Livro;

import java.util.Optional;
import java.util.Scanner;

public class EmprestimoHandler {
    private Biblioteca biblioteca;

    public EmprestimoHandler(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    public void cadastrar() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o código do livro:");
        Long livroId = scanner.nextLong();
        scanner.nextLine(); // Consumir a nova linha

        Optional<Livro> livro = biblioteca.buscarLivroPorId(livroId);
        if (livro.isEmpty()) {
            System.out.println("Livro não encontrado.");
            return;
        }

        if (!livro.get().isDisponivel()) {
            System.out.println("Livro não está disponível para empréstimo.");
            return;
        }
        System.out.println(livro.get().getTitulo());

        System.out.println("Digite o código do cliente:");
        Long clienteId = scanner.nextLong();
        scanner.nextLine();

        Optional<Cliente> cliente = biblioteca.buscarClientePorId(clienteId);
        if (cliente.isEmpty()) {
            System.out.println("Cliente não encontrado.");
            return;
        }
        System.out.println(cliente.get().getNome());

        Emprestimo emprestimo = new Emprestimo(getUltimoIdMaisUm(), livro.get(), cliente.get());
        biblioteca.adicionarEmprestimo(emprestimo);
        livro.get().setDisponivel(false);

        System.out.println("Empréstimo realizado com sucesso!");
    }

    private long getUltimoIdMaisUm() {
        return (long) biblioteca.getEmprestimos().size() + 1;
    }

    public void devolver() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o código do livro:");
        Long livroId = scanner.nextLong();
        scanner.nextLine();

        Optional<Livro> livro = biblioteca.buscarLivroPorId(livroId);
        if (livro.isEmpty()) {
            System.out.println("Livro não encontrado.");
            return;
        }

        if (livro.get().isDisponivel()) {
            System.out.println("Livro já está disponível.");
            return;
        }

        System.out.println(livro.get().getTitulo());

        Optional<Emprestimo> emprestimo = biblioteca.buscarEmprestimoPorLivro(livro.get());
        if (emprestimo.isEmpty()) {
            System.out.println("Livro não está emprestado.");
            return;
        }

        biblioteca.devolverEmprestimo(emprestimo);

        System.out.println("Livro devolvido com sucesso!");
    }

    public void listar() {
        System.out.println(String.format("%-10s %-30s %-20s %-15s %-15s %-15s", "ID", "Livro", "Cliente", "Emprestimo", "Devolução", "Devolvido"));
        for (Emprestimo emprestimo : biblioteca.getEmprestimos()) {
            System.out.println(String.format("%-10s %-30s %-20s %-15s %-15s %-15s",
                    emprestimo.getId(),
                    emprestimo.getLivro().getTitulo(),
                    emprestimo.getCliente().getNome(),
                    emprestimo.getDataEmprestimo(),
                    emprestimo.getDataDevolucao(),
                    emprestimo.isDevolvido() ? "Sim" : "Não"));
        }
    }
}