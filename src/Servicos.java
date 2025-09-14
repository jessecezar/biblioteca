import java.util.ArrayList;
import java.util.Scanner;

public class Servicos {
    Scanner entrada = new Scanner(System.in);

    public int opcao() {
        System.out.println("\n--- Menu ---");
        System.out.println("[1] - Cadastrar Livro");
        System.out.println("[2] - Listar Livros");
        System.out.println("[3] - Buscar Livro");
        System.out.println("[4] - Atualizar Livro");
        System.out.println("[5] - Deletar Livro");
        System.out.println("[6] - Emprestar Livro");
        System.out.println("[7] - Devolver Livro");
        System.out.println("[8] - Parar");
        System.out.print("Escolha uma opção: ");
        int opcao = entrada.nextInt();
        entrada.nextLine();
        return opcao;
    }

    public Livro cadastrarLivro(int id_livro) {
        System.out.println("\n--- Cadastro de Livro ---");
        System.out.println("Qual o nome do livro?");
        String titulo = entrada.nextLine();
        System.out.println("Quem é o autor do livro?");
        String autor = entrada.nextLine();
        System.out.println("Qual o ano de publicação do livro?");
        int anoPublicacao = entrada.nextInt();
        entrada.nextLine();

        Livro livro = new Livro(id_livro, titulo, autor, anoPublicacao);
        System.out.println("Livro cadastrado com sucesso!");
        return livro;
    }

    public Livro buscarLivro(int id_livro, ArrayList<Livro> livros) {
        for (Livro livro : livros) {
            if (livro.getId_livro() == id_livro) {
                return livro;
            }
        }
        return null;
    }

    public Livro atualizarLivro(int id_livro, ArrayList<Livro> livros) {
        Livro livro = buscarLivro(id_livro, livros);
        if (livro != null) {
            System.out.println("\n--- Atualização de Livro ---");
            System.out.println("O que deseja atualizar?");
            System.out.println("[1] - Título");
            System.out.println("[2] - Autor");
            System.out.println("[3] - Ano de Publicação");
            System.out.print("Escolha uma opção: ");
            int opcao = entrada.nextInt();
            entrada.nextLine();

            switch (opcao) {
                case 1 -> {
                    System.out.print("Digite o novo título: ");
                    String novoTitulo = entrada.nextLine();
                    livro.setTitulo(novoTitulo);
                    System.out.println("Título atualizado com sucesso!");
                }
                case 2 -> {
                    System.out.print("Digite o novo autor: ");
                    String novoAutor = entrada.nextLine();
                    livro.setAutor(novoAutor);
                    System.out.println("Autor atualizado com sucesso!");
                }
                case 3 -> {
                    System.out.print("Digite o novo ano de publicação: ");
                    int novoAno = entrada.nextInt();
                    entrada.nextLine();
                    livro.setAnoPublicacao(novoAno);
                    System.out.println("Ano de publicação atualizado com sucesso!");
                }
                default -> System.out.println("Opção inválida!");
            }
            return livro;
        }
        return null;
    }

    public Livro deletarLivro (int id_livro, ArrayList<Livro> livros) {
        Livro livro = buscarLivro(id_livro, livros);
        if (livro != null) {
            System.out.println("Livro '" + livro.getTitulo() + "' deletado com sucesso!");
            livros.remove(livro);
            return livro;
        }
        else {
            System.out.println("Livro não encontrado!");
        }
        return null;
    }

    public Livro emprestarLivro(int id_livro, ArrayList<Livro> livros) {
        Livro livro = buscarLivro(id_livro, livros);
        if (livro != null) {
            if (livro.getDisponivel()) {
                livro.setDisponivel(false);
                System.out.println("Livro '" + livro.getTitulo() + "' emprestado com sucesso!");
                return livro;
            } else {
                System.out.println("Livro indisponível para empréstimo!");
            }
        } else {
            System.out.println("Livro não encontrado!");
        }
        return null;
    }

    public Livro devolverLivro(int id_livro, ArrayList<Livro> livros) {
        Livro livro = buscarLivro(id_livro, livros);
        if (livro != null) {
            if (!livro.getDisponivel()) {
                livro.setDisponivel(true);
                System.out.println("Livro '" + livro.getTitulo() + "' devolvido com sucesso!");
                return livro;
            } else {
                System.out.println("Este livro não está emprestado!");
            }
        } else {
            System.out.println("Livro não encontrado!");
        }
        return null;
    }
}
