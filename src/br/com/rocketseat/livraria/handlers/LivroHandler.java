package br.com.rocketseat.livraria.handlers;

import br.com.rocketseat.livraria.Autor;
import br.com.rocketseat.livraria.Biblioteca;
import br.com.rocketseat.livraria.Livro;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class LivroHandler {

    private final Biblioteca biblioteca;

    public LivroHandler(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    public void cadastrar() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("<-------- Dados do Livro -------->");
        System.out.println("Digite o título do livro:");
        String titulo = scanner.nextLine();

        System.out.println("<-------- Dados do Autor -------->");
        System.out.println("Digite o ID do autor:");
        Long autorId = scanner.nextLong();
        scanner.nextLine();

        System.out.println("Digite o nome do autor:");
        String autorNome = scanner.nextLine();

        System.out.println("Digite a data de nascimento do autor (dd/MM/yyyy):");
        String dataNascimentoStr = scanner.nextLine();
        LocalDate dataNascimento = LocalDate.parse(dataNascimentoStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        Autor autor = new Autor(autorId, autorNome, dataNascimento);

        Livro livro = new Livro(getUltimoIdMaisUm(), titulo, autor, true);
        System.out.println("Livro cadastrado com sucesso!");

        biblioteca.adicionarLivro(livro);
    }

    private Long getUltimoIdMaisUm() {
        return (long) biblioteca.getLivros().size() + 1;
    }

    public void listar() {
        System.out.println(String.format("%-10s %-30s %-20s %-15s", "ID", "Título", "Autor", "Disponível"));
        for (Livro livro : biblioteca.getLivros()) {
            System.out.println(String.format("%-10s %-30s %-20s %-15s", livro.getId(), livro.getTitulo(), livro.getAutor().getNome(), livro.isDisponivel()? "Sim" : "Não"));
        }
    }
}