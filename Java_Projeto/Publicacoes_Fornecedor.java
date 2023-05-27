import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Obra {
    private String titulo;
    private String editora;
    private int quantidadeAcessos;

    public Obra(String titulo, String editora, int quantidadeAcessos) {
        this.titulo = titulo;
        this.editora = editora;
        this.quantidadeAcessos = quantidadeAcessos;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getEditora() {
        return editora;
    }

    public int getQuantidadeAcessos() {
        return quantidadeAcessos;
    }

    public void incrementarAcesso() {
        quantidadeAcessos++;
    }
}

public class Publicacoes_Fornecedor {
    public static void main(String[] args) {
        List<Obra> obras = new ArrayList<>();
        obras.add(new Obra("Obra 1", "Editora A", 1000));
        obras.add(new Obra("Obra 2", "Editora B", 2000));
        obras.add(new Obra("Obra 3", "Editora C", 3000));

        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("===== Publicações do Fornecedor =====");
            for (int i = 0; i < obras.size(); i++) {
                System.out.println((i + 1) + ". " + obras.get(i).getTitulo());
            }
            System.out.println("0. Sair");

            System.out.print("Escolha uma obra para exibir a quantidade de acessos: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            if (opcao >= 1 && opcao <= obras.size()) {
                Obra obraSelecionada = obras.get(opcao - 1);
                obraSelecionada.incrementarAcesso();

                System.out.println("===== Detalhes da Obra =====");
                System.out.println("Título: " + obraSelecionada.getTitulo());
                System.out.println("Editora: " + obraSelecionada.getEditora());
                System.out.println("Quantidade de Acessos: " + obraSelecionada.getQuantidadeAcessos());
                System.out.println();
            } else if (opcao != 0) {
                System.out.println("Opção inválida. Tente novamente.");
                System.out.println();
            }
        } while (opcao != 0);
    }
}
