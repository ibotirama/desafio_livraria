import br.com.rocketseat.livraria.*;
import br.com.rocketseat.livraria.handlers.AutorHandler;
import br.com.rocketseat.livraria.handlers.ClienteHandler;
import br.com.rocketseat.livraria.handlers.EmprestimoHandler;
import br.com.rocketseat.livraria.handlers.LivroHandler;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();
        boolean running = true;

        while (running) {
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Cadastrar um livro");
            System.out.println("2 - Listar livros");
            System.out.println("3 - Cadastrar um autor");
            System.out.println("4 - Listar autores");
            System.out.println("5 - Cadastrar um cliente");
            System.out.println("6 - Listar clientes");
            System.out.println("7 - Realizar um empréstimo");
            System.out.println("8 - Devolver um livro");
            System.out.println("9 - Listar emprestimos");
            System.out.println("10 - Sair");
            System.out.println("Opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            switch (opcao) {
                case 1:
                    // Lógica para cadastrar um livro
                    new LivroHandler(biblioteca).cadastrar();
                    System.out.println("<--------------------------------------->");

                    break;
                case 2:
                    new LivroHandler(biblioteca).listar();
                    System.out.println("<--------------------------------------->");
                    break;
                case 3:
                    // Lógica para cadastrar um autor
                    new AutorHandler(biblioteca).cadastrar();
                    System.out.println("<--------------------------------------->");
                    break;
                case 4:
                    new AutorHandler(biblioteca).listar();
                    System.out.println("<--------------------------------------->");
                    break;
                case 5:
                    // Lógica para cadastrar um cliente
                    new ClienteHandler(biblioteca).cadastrar();
                    System.out.println("<--------------------------------------->");
                    break;
                case 6:
                    new ClienteHandler(biblioteca).listar();
                    System.out.println("<--------------------------------------->");
                    break;
                case 7:
                    // Lógica para realizar um empréstimo
                    new EmprestimoHandler(biblioteca).cadastrar();
                    break;
                case 8:
                    new EmprestimoHandler(biblioteca).devolver();
                    break;
                case 9:
                    new EmprestimoHandler(biblioteca).listar();
                    break;
                case 10:
                    running = false;
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }

        scanner.close();
    }
}