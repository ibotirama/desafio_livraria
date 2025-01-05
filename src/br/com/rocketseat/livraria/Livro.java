package br.com.rocketseat.livraria;

import java.time.LocalDate;

public class Livro {
    private Long id;
    private String titulo;
    private Autor autor;
    private boolean disponivel;
    private LocalDate dataCadastro;
    private LocalDate dataAtualização;

    public Livro(Long id, String titulo, Autor autor, boolean disponivel) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.disponivel = disponivel;
        this.dataCadastro = LocalDate.now();
    }

    public void atualizarDisponibilidade(boolean disponivel) {
        this.disponivel = disponivel;
        this.dataAtualização = LocalDate.now();
    }

    public void indisponibilizar() {
        this.disponivel = false;
        this.dataAtualização = LocalDate.now();
    }

    public void disponibilizar() {
        this.disponivel = true;
        this.dataAtualização = LocalDate.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public LocalDate getDataAtualização() {
        return dataAtualização;
    }
}
