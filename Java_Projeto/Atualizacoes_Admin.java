import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Atualizacao {
    private String titulo;
    private String descricao;

    public Atualizacao(String titulo, String descricao) {
        this.titulo = titulo;
        this.descricao = descricao;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}

public class Atualizacoes_Admin {
    public static void main(String[] args) {
        List<Atualizacao> atualizacoes = new ArrayList<>();
        atualizacoes.add(new Atualizacao("Atualiza��o 1", "Descri��o da Atualiza��o 1"));
        atualizacoes.add(new Atualizacao("Atualiza��o 2", "Descri��o da Atualiza��o 2"));
        atualizacoes.add(new Atualizacao("Atualiza��o 3", "Descri��o da Atualiza��o 3"));

        Scanner scanner = new Scanner(System.in);

        boolean sair = false;
        int opcao = 0;

        while (!sair) {
            System.out.println("===== Aplica��o de Atualiza��es =====");
            System.out.println("1. Listar Atualiza��es");
            System.out.println("2. Adicionar Atualiza��o");
            System.out.println("3. Editar Atualiza��o");
            System.out.println("4. Remover Atualiza��o");
            System.out.println("0. Sair");

            System.out.print("Escolha uma op��o: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (opcao) {
                case 0:
                    sair = true;
                    break;
                case 1:
                    listarAtualizacoes(atualizacoes);
                    break;
                case 2:
                    adicionarAtualizacao(scanner, atualizacoes);
                    break;
                case 3:
                    editarAtualizacao(scanner, atualizacoes);
                    break;
                case 4:
                    removerAtualizacao(scanner, atualizacoes);
                    break;
                default:
                    System.out.println("Op��o inv�lida. Tente novamente.");
            }

            System.out.println();
        }
    }

    private static void listarAtualizacoes(List<Atualizacao> atualizacoes) {
        System.out.println("===== Lista de Atualiza��es =====");
        for (int i = 0; i < atualizacoes.size(); i++) {
            Atualizacao atualizacao = atualizacoes.get(i);
            System.out.println((i + 1) + ". " + atualizacao.getTitulo());
        }
    }

    private static void adicionarAtualizacao(Scanner scanner, List<Atualizacao> atualizacoes) {
        System.out.print("Digite o t�tulo da atualiza��o: ");
        String titulo = scanner.nextLine();

        System.out.print("Digite a descri��o da atualiza��o: ");
        String descricao = scanner.nextLine();

        Atualizacao novaAtualizacao = new Atualizacao(titulo, descricao);
        atualizacoes.add(novaAtualizacao);

        System.out.println("Nova atualiza��o adicionada com sucesso!");
    }

    private static void editarAtualizacao(Scanner scanner, List<Atualizacao> atualizacoes) {
        System.out.print("Digite o n�mero da atualiza��o que deseja editar: ");
        int numeroAtualizacao = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha

        if (numeroAtualizacao >= 1 && numeroAtualizacao <= atualizacoes.size()) {
            Atualizacao atualizacao = atualizacoes.get(numeroAtualizacao - 1);

            System.out.print("Digite o novo t�tulo da atualiza��o: ");
            String novoTitulo = scanner.nextLine();

            System.out.print("Digite a nova descri��o da atualiza��o: ");
            String novaDescricao = scanner.nextLine();

            atualizacao.setTitulo(novoTitulo);
            atualizacao.setDescricao(novaDescricao);

            System.out.println("Atualiza��o editada com sucesso!");
        } else {
            System.out.println("N�mero de atualiza��o inv�lido.");
        }
    }

    private static void removerAtualizacao(Scanner scanner, List<Atualizacao> atualizacoes) {
        System.out.print("Digite o n�mero da atualiza��o que deseja remover: ");
        int numeroAtualizacao = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha

        if (numeroAtualizacao >= 1 && numeroAtualizacao <= atualizacoes.size()) {
            Atualizacao atualizacaoRemovida = atualizacoes.remove(numeroAtualizacao - 1);
            System.out.println("Atualiza��o removida: " + atualizacaoRemovida.getTitulo());
        } else {
            System.out.println("N�mero de atualiza��o inv�lido.");
        }
    }
}
