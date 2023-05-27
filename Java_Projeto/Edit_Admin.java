import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Manga {
    private String titulo;
    private String sinopse;
    private int anoLancamento;
    private String editora;
    private double preco;
    private double avaliacao;
    private List<String> comentarios;

    public Manga(String titulo, String sinopse, int anoLancamento, String editora, double preco, double avaliacao) {
        this.titulo = titulo;
        this.sinopse = sinopse;
        this.anoLancamento = anoLancamento;
        this.editora = editora;
        this.preco = preco;
        this.avaliacao = avaliacao;
        this.comentarios = new ArrayList<>();
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(double avaliacao) {
        this.avaliacao = avaliacao;
    }

    public List<String> getComentarios() {
        return comentarios;
    }

    public void adicionarComentario(String comentario) {
        comentarios.add(comentario);
    }

    public void removerComentario(int indice) {
        if (indice >= 0 && indice < comentarios.size()) {
            comentarios.remove(indice);
        }
    }

    @Override
    public String toString() {
        return "Título: " + titulo + "\n" +
                "Sinopse: " + sinopse + "\n" +
                "Ano de Lançamento: " + anoLancamento + "\n" +
                "Editora: " + editora + "\n" +
                "Preço: R$" + preco + "\n" +
                "Avaliação: " + avaliacao + "\n" +
                "Comentários: " + comentarios + "\n";
    }
}

public class Edit_Admin {
    private static List<Manga> mangas = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Manga manga1 = new Manga("Manga 1", "Sinopse do Manga 1", 2021, "Editora A", 19.99, 4.5);
        Manga manga2 = new Manga("Manga 2", "Sinopse do Manga 2", 2022, "Editora B", 24.99, 4.2);

        mangas.add(manga1);
        mangas.add(manga2);

        boolean sair = false;

        while (!sair) {
            exibirMenu();

            System.out.print("Selecione uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1:
                    exibirMangas();
                    break;
                case 2:
                    adicionarManga(scanner);
                    break;
                case 3:
                    editarManga(scanner);
                    break;
                case 4:
                    excluirManga(scanner);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }

            System.out.println();
        }
    }

    private static void exibirMenu() {
        System.out.println("===== Menu =====");
        System.out.println("1. Exibir Mangás");
        System.out.println("2. Adicionar Mangá");
        System.out.println("3. Editar Mangá");
        System.out.println("4. Excluir Mangá");
        System.out.println("0. Sair");
    }

    private static void exibirMangas() {
        if (mangas.isEmpty()) {
            System.out.println("Não há mangás disponíveis.");
            return;
        }

        System.out.println("===== Mangás Disponíveis =====");
        for (int i = 0; i < mangas.size(); i++) {
            System.out.println("Mangá " + (i + 1) + ":");
            System.out.println(mangas.get(i));
        }
    }

    private static void adicionarManga(Scanner scanner) {
        System.out.println("===== Adicionar Mangá =====");

        System.out.print("Título: ");
        String titulo = scanner.nextLine();

        System.out.print("Sinopse: ");
        String sinopse = scanner.nextLine();

        System.out.print("Ano de Lançamento: ");
        int anoLancamento = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        System.out.print("Editora: ");
        String editora = scanner.nextLine();

        System.out.print("Preço: R$");
        double preco = scanner.nextDouble();
        scanner.nextLine(); // Limpar o buffer

        System.out.print("Avaliação: ");
        double avaliacao = scanner.nextDouble();
        scanner.nextLine(); // Limpar o buffer

        Manga novoManga = new Manga(titulo, sinopse, anoLancamento, editora, preco, avaliacao);
        mangas.add(novoManga);

        System.out.println("Mangá adicionado com sucesso!");
    }

    private static void editarManga(Scanner scanner) {
        if (mangas.isEmpty()) {
            System.out.println("Não há mangás disponíveis para editar.");
            return;
        }

        System.out.println("===== Editar Mangá =====");
        exibirMangas();

        System.out.print("Selecione o número do mangá que deseja editar: ");
        int indice = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        if (indice <= 0 || indice > mangas.size()) {
            System.out.println("Número de mangá inválido.");
            return;
        }

        Manga manga = mangas.get(indice - 1);

        System.out.print("Título [" + manga.getTitulo() + "]: ");
        String novoTitulo = scanner.nextLine();
        if (!novoTitulo.isEmpty()) {
            manga.setTitulo(novoTitulo);
        }

        System.out.print("Sinopse [" + manga.getSinopse() + "]: ");
        String novaSinopse = scanner.nextLine();
        if (!novaSinopse.isEmpty()) {
            manga.setSinopse(novaSinopse);
        }

        System.out.print("Ano de Lançamento [" + manga.getAnoLancamento() + "]: ");
        String novoAnoLancamentoStr = scanner.nextLine();
        if (!novoAnoLancamentoStr.isEmpty()) {
            int novoAnoLancamento = Integer.parseInt(novoAnoLancamentoStr);
            manga.setAnoLancamento(novoAnoLancamento);
        }

        System.out.print("Editora [" + manga.getEditora() + "]: ");
        String novaEditora = scanner.nextLine();
        if (!novaEditora.isEmpty()) {
            manga.setEditora(novaEditora);
        }

        System.out.print("Preço [R$" + manga.getPreco() + "]: ");
        String novoPrecoStr = scanner.nextLine();
        if (!novoPrecoStr.isEmpty()) {
            double novoPreco = Double.parseDouble(novoPrecoStr);
            manga.setPreco(novoPreco);
        }

        System.out.print("Avaliação [" + manga.getAvaliacao() + "]: ");
        String novaAvaliacaoStr = scanner.nextLine();
        if (!novaAvaliacaoStr.isEmpty()) {
            double novaAvaliacao = Double.parseDouble(novaAvaliacaoStr);
            manga.setAvaliacao(novaAvaliacao);
        }

        System.out.println("Mangá editado com sucesso!");
    }

    private static void excluirManga(Scanner scanner) {
        if (mangas.isEmpty()) {
            System.out.println("Não há mangás disponíveis para excluir.");
            return;
        }

        System.out.println("===== Excluir Mangá =====");
        exibirMangas();

        System.out.print("Selecione o número do mangá que deseja excluir: ");
        int indice = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        if (indice <= 0 || indice > mangas.size()) {
            System.out.println("Número de mangá inválido.");
            return;
        }

        Manga manga = mangas.get(indice - 1);
        mangas.remove(manga);

        System.out.println("Mangá excluído com sucesso!");
    }
}
