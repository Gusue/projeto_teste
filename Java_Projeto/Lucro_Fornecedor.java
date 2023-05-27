import java.util.ArrayList;
import java.util.List;

class Publicacao {
    private String titulo;
    private int quantidadeAcessos;
    private int quantidadeGostei;
    private double lucro;
    private String editora;

    public Publicacao(String titulo, int quantidadeAcessos, int quantidadeGostei, double lucro, String editora) {
        this.titulo = titulo;
        this.quantidadeAcessos = quantidadeAcessos;
        this.quantidadeGostei = quantidadeGostei;
        this.lucro = lucro;
        this.editora = editora;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getQuantidadeAcessos() {
        return quantidadeAcessos;
    }

    public int getQuantidadeGostei() {
        return quantidadeGostei;
    }

    public double getLucro() {
        return lucro;
    }

    public String getEditora() {
        return editora;
    }
}

public class Lucro_Fornecedor {
    public static void main(String[] args) {
        List<Publicacao> publicacoes = new ArrayList<>();
        publicacoes.add(new Publicacao("Livro 1", 1000, 500, 1000.0, "Editora A"));
        publicacoes.add(new Publicacao("Livro 2", 2000, 800, 1500.0, "Editora B"));
        publicacoes.add(new Publicacao("Livro 3", 3000, 1200, 2000.0, "Editora C"));

        System.out.println("===== Publicações do Fornecedor =====");
        for (Publicacao publicacao : publicacoes) {
            System.out.println("Título: " + publicacao.getTitulo());
            System.out.println("Quantidade de Acessos: " + publicacao.getQuantidadeAcessos());
            System.out.println("Quantidade de Gostei: " + publicacao.getQuantidadeGostei());
            System.out.println("Lucro: R$" + publicacao.getLucro());
            System.out.println("Editora: " + publicacao.getEditora());
            System.out.println();
        }
    }
}
