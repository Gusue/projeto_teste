import java.util.HashMap;
import java.util.Map;
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

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setAvaliacao(double avaliacao) {
        this.avaliacao = avaliacao;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}

public class Imagens_Admin {
    public static void main(String[] args) {
        Map<Integer, Imagem> imagens = new HashMap<>();
        imagens.put(1, new Imagem("Imagem 1", "Sinopse da Imagem 1", 2021, "Editora 1", 19.99));
        imagens.put(2, new Imagem("Imagem 2", "Sinopse da Imagem 2", 2022, "Editora 2", 29.99));

        Scanner scanner = new Scanner(System.in);

        boolean sair = false;

        while (!sair) {
            System.out.println("===== Aplicação de Imagens =====");
            System.out.println("1. Visualizar Imagem");
            System.out.println("2. Adicionar Imagem");
            System.out.println("3. Editar Imagem");
            System.out.println("4. Excluir Imagem");
            System.out.println("0. Sair");

            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (opcao) {
                case 1:
                    visualizarImagem(scanner, imagens);
                    break;
                case 2:
                    adicionarImagem(scanner, imagens);
                    break;
                case 3:
                    editarImagem(scanner, imagens);
                    break;
                case 4:
                    excluirImagem(scanner, imagens);
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

    private static void visualizarImagem(Scanner scanner, Map<Integer, Imagem> imagens) {
        System.out.println("===== Visualizar Imagem =====");
        exibirMenuImagens(imagens);

        System.out.print("Escolha o número da imagem: ");
        int numeroImagem = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha

        if (imagens.containsKey(numeroImagem)) {
            Imagem imagem = imagens.get(numeroImagem);
            exibirDetalhesImagem(imagem);
        } else {
            System.out.println("Imagem não encontrada.");
        }
    }

    private static void adicionarImagem(Scanner scanner, Map<Integer, Imagem> imagens) {
        System.out.println("===== Adicionar Imagem =====");
        System.out.print("Digite o título: ");
        String titulo = scanner.nextLine();

        System.out.print("Digite a sinopse: ");
        String sinopse = scanner.nextLine();

        System.out.print("Digite o ano de lançamento: ");
        int anoLancamento = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha

        System.out.print("Digite a editora: ");
        String editora = scanner.nextLine();

        System.out.print("Digite o preço: ");
        double preco = scanner.nextDouble();
        scanner.nextLine(); // Consumir a quebra de linha

        int novoNumeroImagem = imagens.size() + 1;
        Imagem novaImagem = new Imagem(titulo, sinopse, anoLancamento, editora, preco);
        imagens.put(novoNumeroImagem, novaImagem);

        System.out.println("Imagem adicionada com sucesso. Número da imagem: " + novoNumeroImagem);
    }

    private static void editarImagem(Scanner scanner, Map<Integer, Imagem> imagens) {
        System.out.println("===== Editar Imagem =====");
        exibirMenuImagens(imagens);

        System.out.print("Escolha o número da imagem: ");
        int numeroImagem = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha

        if (imagens.containsKey(numeroImagem)) {
            Imagem imagem = imagens.get(numeroImagem);
            exibirDetalhesImagem(imagem);

            System.out.print("Digite o novo título: ");
            String novoTitulo = scanner.nextLine();

            System.out.print("Digite a nova sinopse: ");
            String novaSinopse = scanner.nextLine();

            System.out.print("Digite o novo ano de lançamento: ");
            int novoAnoLancamento = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            System.out.print("Digite a nova editora: ");
            String novaEditora = scanner.nextLine();

            System.out.print("Digite o novo preço: ");
            double novoPreco = scanner.nextDouble();
            scanner.nextLine(); // Consumir a quebra de linha

            imagem.setTitulo(novoTitulo);
            imagem.setSinopse(novaSinopse);
            imagem.setAnoLancamento(novoAnoLancamento);
            imagem.setEditora(novaEditora);
            imagem.setPreco(novoPreco);

            System.out.println("Imagem editada com sucesso.");
        } else {
            System.out.println("Imagem não encontrada.");
        }
    }

    private static void excluirImagem(Scanner scanner, Map<Integer, Imagem> imagens) {
        System.out.println("===== Excluir Imagem =====");
        exibirMenuImagens(imagens);

        System.out.print("Escolha o número da imagem: ");
        int numeroImagem = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha

        if (imagens.containsKey(numeroImagem)) {
            Imagem imagem = imagens.get(numeroImagem);
            exibirDetalhesImagem(imagem);

            System.out.print("Deseja realmente excluir esta imagem? (S/N): ");
            String confirmacao = scanner.nextLine();

            if (confirmacao.equalsIgnoreCase("S")) {
                imagens.remove(numeroImagem);
                System.out.println("Imagem excluída com sucesso.");
            } else {
                System.out.println("Exclusão cancelada.");
            }
        } else {
            System.out.println("Imagem não encontrada.");
        }
    }

    private static void exibirMenuImagens(Map<Integer, Imagem> imagens) {
        System.out.println("===== Lista de Imagens =====");
        for (Map.Entry<Integer, Imagem> entry : imagens.entrySet()) {
            int numeroImagem = entry.getKey();
            Imagem imagem = entry.getValue();
            System.out.println(numeroImagem + ". " + imagem.getTitulo());
        }
    }

    private static void exibirDetalhesImagem(Imagem imagem) {
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
