package br.com.rocketseat.livraria.handlers;

import br.com.rocketseat.livraria.Autor;
import br.com.rocketseat.livraria.Biblioteca;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class AutorHandler {

    private final String LIST_FORMAT = "%-10s %-20s %-15s";
    private final String[] LIST_TITLES = {"ID", "Nome", "Data de Nascimento"};
    private final Biblioteca biblioteca;

    public AutorHandler(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    public void cadastrar() {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Digite o nome do autor:");
        String nome = scanner.nextLine();

        System.out.println("Digite a data de nascimento do autor (dd/MM/yyyy):");
        String dataNascimentoStr = scanner.nextLine();
        LocalDate dataNascimento = LocalDate.parse(dataNascimentoStr, formatter);

        biblioteca.adicionarAutor(new Autor(getUltimoIdMaisUm(), nome, dataNascimento));
        System.out.println("Autor cadastrado com sucesso!");
    }

    private long getUltimoIdMaisUm() {
        return (long) biblioteca.getAutores().size() + 1;
    }

    public void listar() {
        System.out.println(String.format(LIST_FORMAT, LIST_TITLES));
        for (Autor autor : biblioteca.getAutores()) {
            System.out.println(String.format(LIST_FORMAT, autor.getId(), autor.getNome(), autor.getDataNascimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
        }
    }
}