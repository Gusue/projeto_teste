import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Noticias_Admin {
    private static List<Noticia> noticias = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean sair = false;

        System.out.println("===== Gerenciador de Notícias =====");

        while (!sair) {
            exibirMenu();

            System.out.print("Selecione uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1:
                    exibirNoticias();
                    break;
                case 2:
                    adicionarNoticia(scanner);
                    break;
                case 3:
                    editarNoticia(scanner);
                    break;
                case 4:
                    excluirNoticia(scanner);
                    break;
                case 0:
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
        System.out.println("1. Exibir Notícias");
        System.out.println("2. Adicionar Notícia");
        System.out.println("3. Editar Notícia");
        System.out.println("4. Excluir Notícia");
        System.out.println("0. Sair");
    }

    private static void exibirNoticias() {
        System.out.println("===== Notícias =====");

        if (noticias.isEmpty()) {
            System.out.println("Nenhuma notícia cadastrada.");
        } else {
            for (Noticia noticia : noticias) {
                System.out.println(noticia);
            }
        }
    }

    private static void adicionarNoticia(Scanner scanner) {
        System.out.println("===== Adicionar Notícia =====");

        System.out.print("Título: ");
        String titulo = scanner.nextLine();

        System.out.print("Conteúdo: ");
        String conteudo = scanner.nextLine();

        Noticia novaNoticia = new Noticia(titulo, conteudo);
        noticias.add(novaNoticia);

        System.out.println("Notícia adicionada com sucesso!");
    }

    private static void editarNoticia(Scanner scanner) {
        System.out.println("===== Editar Notícia =====");

        exibirNoticias();

        System.out.print("Selecione o número da notícia que deseja editar: ");
        int numeroNoticia = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        if (numeroNoticia < 1 || numeroNoticia > noticias.size()) {
            System.out.println("Número de notícia inválido.");
            return;
        }

        Noticia noticia = noticias.get(numeroNoticia - 1);

        System.out.print("Novo Título: ");
        String novoTitulo = scanner.nextLine();

        System.out.print("Novo Conteúdo: ");
        String novoConteudo = scanner.nextLine();

        noticia.setTitulo(novoTitulo);
        noticia.setConteudo(novoConteudo);

        System.out.println("Notícia editada com sucesso!");
    }

    private static void excluirNoticia(Scanner scanner) {
        System.out.println("===== Excluir Notícia =====");

        exibirNoticias();

        System.out.print("Selecione o número da notícia que deseja excluir: ");
        int numeroNoticia = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        if (numeroNoticia < 1 || numeroNoticia > noticias.size()) {
            System.out.println("Número de notícia inválido.");
            return;
        }

        noticias.remove(numeroNoticia - 1);

        System.out.println("Notícia excluída com sucesso!");
    }

    private static class Noticia {
        private String titulo;
        private String conteudo;

        public Noticia(String titulo, String conteudo) {
            this.titulo = titulo;
            this.conteudo = conteudo;
        }

        public String getTitulo() {
            return titulo;
        }

        public void setTitulo(String titulo) {
            this.titulo = titulo;
        }

        public String getConteudo() {
            return conteudo;
        }

        public void setConteudo(String conteudo) {
            this.conteudo = conteudo;
        }

        @Override
        public String toString() {
            return "Título: " + titulo + "\nConteúdo: " + conteudo + "\n";
        }
    }
}
