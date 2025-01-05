package br.com.rocketseat.livraria;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Biblioteca {
    private List<Livro> livros;
    private List<Autor> autores;
    private List<Cliente> clientes;
    private List<Emprestimo> emprestimos;

    public Biblioteca() {
        this.livros = new ArrayList<>();
        this.autores = new ArrayList<>();
        this.emprestimos = new ArrayList<>();
        this.clientes = new ArrayList<>();
    }

    public void adicionarLivro(Livro livro) {
        this.livros.add(livro);
        if (livro.getAutor() != null && encontrarAutor(livro.getAutor()).isEmpty()) {
            this.autores.add(livro.getAutor());
        }
    }

    private Optional<Autor> encontrarAutor(Autor autor) {
        return getAutores().stream()
                .filter(a -> a.equals(autor))
                .findFirst();
    }

    public void adicionarAutor(Autor autor) {
        if (encontrarAutor(autor).isEmpty()) {
            autor.setId((long) (getAutores().size() + 1));
            this.autores.add(autor);
        }
        else {
            System.out.println("Autor já cadastrado!");
        }
    }

    public void adicionarEmprestimo(Emprestimo emprestimo) {
        this.emprestimos.add(emprestimo);
    }

    public void adicionarCliente(Cliente cliente) {
        if(getClientes().stream().anyMatch(c -> c.getEmail().equals(cliente.getEmail()))) {
            System.out.println("Cliente já cadastrado!");
            return;
        }
        cliente.setId((long) (getClientes().size() + 1));
        this.clientes.add(cliente);
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public Optional<Livro> buscarLivroPorId(Long livroId) {
        return getLivros().stream()
                .filter(l -> l.getId().equals(livroId))
                .findFirst();
    }

    public Optional<Cliente> buscarClientePorId(Long clienteId) {
        return getClientes().stream()
                .filter(c -> c.getId().equals(clienteId))
                .findFirst();
    }

    public Optional<Emprestimo> buscarEmprestimoPorLivro(Livro livro) {
        return getEmprestimos().stream()
                .filter(e -> !e.isDevolvido() && e.getLivro().equals(livro))
                .findFirst();
    }

    public void devolverEmprestimo(Optional<Emprestimo> emprestimo) {
        emprestimo.ifPresent(Emprestimo::devolver);
    }
}
