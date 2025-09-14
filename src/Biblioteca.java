import java.util.ArrayList;

public class Biblioteca {
    public static void main(String[] args) throws Exception {
        ArrayList<Livro> livros = new ArrayList<>();

        livros.add(new Livro(1, "O Senhor dos Anéis", "J.R.R. Tolkien", 1954));
        livros.add(new Livro(2, "1984", "George Orwell", 1949));

        Servicos servicos = new Servicos();
        boolean parar = false;
        int id_livro = 3;
        do {
            int opcao = servicos.opcao();

            switch (opcao) {
                case 1 -> {
                    livros.add(servicos.cadastrarLivro(id_livro));
                    id_livro++;
                }
                case 2 -> {
                    System.out.println("\n--- Lista de Livros ---");
                    if (livros.isEmpty()) {
                        System.out.println("Nenhum livro cadastrado!");
                    } else {
                        for (Livro livro : livros) {
                            System.out.println(livro);
                        }
                    }
                }
                case 3 -> {
                    System.out.print("\nDigite o ID do livro:");
                    int idBusca = servicos.entrada.nextInt();
                    servicos.entrada.nextLine();
                    Livro livroEncontrado = servicos.buscarLivro(idBusca, livros);
                    if (livroEncontrado != null) {
                        System.out.println("\n---- Livro Encontrado ----\n" + livroEncontrado);
                    }
                    else {
                        System.out.println("Livro não encontrado!");
                    }
                }
                case 4 -> {
                    System.out.print("\nDigite o ID do livro que deseja atualizar: ");
                    int idAtualiza = servicos.entrada.nextInt();
                    servicos.entrada.nextLine();
                    Livro livroAtualizado = servicos.atualizarLivro(idAtualiza, livros);
                    if (livroAtualizado != null) {
                        System.out.println("\n---- Livro Atualizado ----\n" + livroAtualizado);
                    } else {
                        System.out.println("Livro não encontrado!");
                    }
                }
                case 5 -> {
                    System.out.print("\nDigite o ID do livro que deseja deletar: ");
                    int idDeleta = servicos.entrada.nextInt();
                    servicos.entrada.nextLine();
                    servicos.deletarLivro(idDeleta, livros);
                }
                case 6 -> {
                    System.out.print("\nDigite o ID do livro que deseja emprestar: ");
                    int idEmpresta = servicos.entrada.nextInt();
                    servicos.entrada.nextLine();
                    servicos.emprestarLivro(idEmpresta, livros);
                }
                case 7 -> {
                    System.out.print("\nDigite o ID do livro que deseja devolver: ");
                    int idDevolve = servicos.entrada.nextInt();
                    servicos.entrada.nextLine();
                    servicos.devolverLivro(idDevolve, livros);
                }
                case 8 -> {
                    parar = true;
                    System.out.println("\nPrograma encerrando...\n");
                }
            }

        } while (parar == false);

    }
}
