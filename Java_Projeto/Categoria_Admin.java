import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Categoria_Admin {

    public static void main(String[] args) {
        Map<Integer, String[]> mangasPorCategoria = new HashMap<>();
        mangasPorCategoria.put(1, new String[]{"Manga1A", "Manga1B"});
        mangasPorCategoria.put(2, new String[]{"Manga2A", "Manga2B"});
        mangasPorCategoria.put(3, new String[]{"Manga3A", "Manga3B"});
        mangasPorCategoria.put(4, new String[]{"Manga4A", "Manga4B"});
        mangasPorCategoria.put(5, new String[]{"Manga5A", "Manga5B"});

        Scanner scanner = new Scanner(System.in);

        System.out.println("===== Aplicação de Mangás =====");

        boolean sair = false;

        while (!sair) {
            exibirMenuCategorias();

            System.out.print("Selecione uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1:
                    exibirCategorias(mangasPorCategoria);
                    break;
                case 2:
                    adicionarCategoria(scanner, mangasPorCategoria);
                    break;
                case 3:
                    editarCategoria(scanner, mangasPorCategoria);
                    break;
                case 4:
                    excluirCategoria(scanner, mangasPorCategoria);
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

    private static void exibirMenuCategorias() {
        System.out.println("===== Menu =====");
        System.out.println("1. Exibir Categorias");
        System.out.println("2. Adicionar Categoria");
        System.out.println("3. Editar Categoria");
        System.out.println("4. Excluir Categoria");
        System.out.println("0. Sair");
    }

    private static void exibirCategorias(Map<Integer, String[]> mangasPorCategoria) {
        System.out.println("===== Categorias de Mangás =====");
        for (Map.Entry<Integer, String[]> entry : mangasPorCategoria.entrySet()) {
            int categoria = entry.getKey();
            String[] mangas = entry.getValue();
            System.out.println("Categoria " + categoria + ":");
            for (String manga : mangas) {
                System.out.println(manga);
            }
            System.out.println();
        }
    }

    private static void adicionarCategoria(Scanner scanner, Map<Integer, String[]> mangasPorCategoria) {
        System.out.println("===== Adicionar Categoria =====");

        System.out.print("Número da categoria: ");
        int numeroCategoria = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        if (mangasPorCategoria.containsKey(numeroCategoria)) {
            System.out.println("Categoria já existe.");
            return;
        }

        System.out.print("Quantidade de mangás: ");
        int quantidadeMangas = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        String[] mangas = new String[quantidadeMangas];
        for (int i = 0; i < quantidadeMangas; i++) {
            System.out.print("Nome do manga " + (i + 1) + ": ");
            mangas[i] = scanner.nextLine();
        }

        mangasPorCategoria.put(numeroCategoria, mangas);
        System.out.println("Categoria adicionada com sucesso!");
    }

    private static void editarCategoria(Scanner scanner, Map<Integer, String[]> mangasPorCategoria) {
        System.out.println("===== Editar Categoria =====");

        System.out.print("Número da categoria: ");
        int numeroCategoria = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        if (!mangasPorCategoria.containsKey(numeroCategoria)) {
            System.out.println("Categoria não encontrada.");
            return;
        }

        String[] mangas = mangasPorCategoria.get(numeroCategoria);

        System.out.println("Mangás da categoria " + numeroCategoria + ":");
        for (int i = 0; i < mangas.length; i++) {
            System.out.println((i + 1) + ". " + mangas[i]);
        }

        System.out.print("Selecione o número do manga para editar: ");
        int numeroManga = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        if (numeroManga < 1 || numeroManga > mangas.length) {
            System.out.println("Número de manga inválido.");
            return;
        }

        System.out.print("Novo nome do manga: ");
        String novoNomeManga = scanner.nextLine();

        mangas[numeroManga - 1] = novoNomeManga;
        System.out.println("Manga editado com sucesso!");
    }

    private static void excluirCategoria(Scanner scanner, Map<Integer, String[]> mangasPorCategoria) {
        System.out.println("===== Excluir Categoria =====");

        System.out.print("Número da categoria: ");
        int numeroCategoria = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        if (!mangasPorCategoria.containsKey(numeroCategoria)) {
            System.out.println("Categoria não encontrada.");
            return;
        }

        mangasPorCategoria.remove(numeroCategoria);
        System.out.println("Categoria excluída com sucesso!");
    }
}
