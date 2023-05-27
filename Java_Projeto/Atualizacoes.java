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
}

public class Atualizacoes {
    public static void main(String[] args) {
        Atualizacao atualizacao1 = new Atualizacao("Atualização 1", "Descrição da Atualização 1");
        Atualizacao atualizacao2 = new Atualizacao("Atualização 2", "Descrição da Atualização 2");
        Atualizacao atualizacao3 = new Atualizacao("Atualização 3", "Descrição da Atualização 3");

        Scanner scanner = new Scanner(System.in);

        boolean sair = false;
        int opcao = 0;

        while (!sair) {
            System.out.println("===== Aplicação de Atualizações =====");
            System.out.println("1. Atualização 1");
            System.out.println("2. Atualização 2");
            System.out.println("3. Atualização 3");
            System.out.println("0. Sair");

            System.out.print("Escolha uma atualização: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (opcao) {
                case 1:
                    exibirAtualizacao(atualizacao1);
                    break;
                case 2:
                    exibirAtualizacao(atualizacao2);
                    break;
                case 3:
                    exibirAtualizacao(atualizacao3);
                    break;
                case 0:
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

            System.out.println();
        }
    }

    private static void exibirAtualizacao(Atualizacao atualizacao) {
        System.out.println("===== Detalhes da Atualização =====");
        System.out.println("Título: " + atualizacao.getTitulo());
        System.out.println("Descrição: " + atualizacao.getDescricao());
    }
}
