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
        Atualizacao atualizacao1 = new Atualizacao("Atualiza��o 1", "Descri��o da Atualiza��o 1");
        Atualizacao atualizacao2 = new Atualizacao("Atualiza��o 2", "Descri��o da Atualiza��o 2");
        Atualizacao atualizacao3 = new Atualizacao("Atualiza��o 3", "Descri��o da Atualiza��o 3");

        Scanner scanner = new Scanner(System.in);

        boolean sair = false;
        int opcao = 0;

        while (!sair) {
            System.out.println("===== Aplica��o de Atualiza��es =====");
            System.out.println("1. Atualiza��o 1");
            System.out.println("2. Atualiza��o 2");
            System.out.println("3. Atualiza��o 3");
            System.out.println("0. Sair");

            System.out.print("Escolha uma atualiza��o: ");
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
                    System.out.println("Op��o inv�lida. Tente novamente.");
            }

            System.out.println();
        }
    }

    private static void exibirAtualizacao(Atualizacao atualizacao) {
        System.out.println("===== Detalhes da Atualiza��o =====");
        System.out.println("T�tulo: " + atualizacao.getTitulo());
        System.out.println("Descri��o: " + atualizacao.getDescricao());
    }
}
