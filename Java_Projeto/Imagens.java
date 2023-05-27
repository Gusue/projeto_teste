import java.util.Scanner;

class Imagem {
    private String titulo;
    private String sinopse;
    private int anoLancamento;
    private String editora;
    private double preco;
    private double avaliacao;
    private String comentario;

    public Imagem(String titulo, String sinopse, int anoLancamento, String editora, double preco) {
        this.titulo = titulo;
        this.sinopse = sinopse;
        this.anoLancamento = anoLancamento;
        this.editora = editora;
        this.preco = preco;
        this.avaliacao = 0.0;
        this.comentario = "";
    }

    public String getTitulo() {
        return titulo;
    }

    public String getSinopse() {
        return sinopse;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public String getEditora() {
        return editora;
    }

    public double getPreco() {
        return preco;
    }

    public double getAvaliacao() {
        return avaliacao;
    }

    public String getComentario() {
        return comentario;
    }

    public void setAvaliacao(double avaliacao) {
        this.avaliacao = avaliacao;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}

public class Imagens {
    public static void main(String[] args) {
        Imagem imagem1 = new Imagem("Imagem 1", "Sinopse da Imagem 1", 2021, "Editora 1", 19.99);
        Imagem imagem2 = new Imagem("Imagem 2", "Sinopse da Imagem 2", 2022, "Editora 2", 29.99);

        Scanner scanner = new Scanner(System.in);

        boolean sair = false;

        while (!sair) {
            System.out.println("===== Aplicação de Imagens =====");
            System.out.println("1. Imagem 1");
            System.out.println("2. Imagem 2");
            System.out.println("0. Sair");

            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (opcao) {
                case 1:
                    exibirImagem(imagem1);
                    break;
                case 2:
                    exibirImagem(imagem2);
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

    private static void exibirImagem(Imagem imagem) {
        System.out.println("===== Detalhes da Imagem =====");
        System.out.println("Título: " + imagem.getTitulo());
        System.out.println("Sinopse: " + imagem.getSinopse());
        System.out.println("Ano de Lançamento: " + imagem.getAnoLancamento());
        System.out.println("Editora: " + imagem.getEditora());
        System.out.println("Preço: R$" + imagem.getPreco());
        System.out.println("Avaliação: " + imagem.getAvaliacao());
        System.out.println("Comentário: " + imagem.getComentario());

        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite uma avaliação (0-5): ");
        double avaliacao = scanner.nextDouble();
        scanner.nextLine(); // Consumir a quebra de linha

        System.out.print("Digite um comentário: ");
        String comentario = scanner.nextLine();

        imagem.setAvaliacao(avaliacao);
        imagem.setComentario(comentario);

        System.out.println("Avaliação e comentário registrados com sucesso!");
    }
}
