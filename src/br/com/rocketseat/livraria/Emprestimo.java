package br.com.rocketseat.livraria;

import java.time.LocalDate;

public class Emprestimo {
    private Long id;
    private Livro livro;
    private Cliente cliente;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;
    private boolean devolvido;

    public Emprestimo(Long id, Livro livro, Cliente cliente) {
        this.id = id;
        this.livro = livro;
        this.cliente = cliente;
        this.dataEmprestimo = LocalDate.now();
        this.devolvido = false;
    }

    public void devolver() {
        this.dataDevolucao = LocalDate.now();
        this.livro.disponibilizar();
    }

    public Livro getLivro() {
        return this.livro;
    }

    public Long getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public boolean isDevolvido() {
        return this.dataDevolucao != null;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }
}
