import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Categoria {

    public static void main(String[] args) {
        Map<Integer, String[]> mangasPorCategoria = new HashMap<>();
        mangasPorCategoria.put(1, new String[]{"Manga1A", "Manga1B"});
        mangasPorCategoria.put(2, new String[]{"Manga2A", "Manga2B"});
        mangasPorCategoria.put(3, new String[]{"Manga3A", "Manga3B"});
        mangasPorCategoria.put(4, new String[]{"Manga4A", "Manga4B"});
        mangasPorCategoria.put(5, new String[]{"Manga5A", "Manga5B"});

        Scanner scanner = new Scanner(System.in);

        System.out.println("===== Aplica��o de Mang�s =====");

        boolean sair = false;

        while (!sair) {
            exibirMenuCategorias();

            System.out.print("Selecione uma categoria (1-5) ou digite 0 para sair: ");
            String opcaoCategoriaStr = scanner.nextLine();

            if (opcaoCategoriaStr.equals("0")) {
                System.out.println("Encerrando a aplica��o...");
                sair = true;
            } else {
                try {
                    int opcaoCategoria = Integer.parseInt(opcaoCategoriaStr);
                    if (mangasPorCategoria.containsKey(opcaoCategoria)) {
                        String categoria = obterCategoria(opcaoCategoria);
                        String[] mangas = mangasPorCategoria.get(opcaoCategoria);
                        exibirMangasDaCategoria(categoria, mangas);
                    } else {
                        System.out.println("Categoria inv�lida. Tente novamente.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Entrada inv�lida. Tente novamente.");
                }
            }
            System.out.println();
        }
    }

    private static void exibirMenuCategorias() {
        System.out.println("===== Categorias de Mang�s =====");
        System.out.println("1. Aventura");
        System.out.println("2. Com�dia");
        System.out.println("3. Drama");
        System.out.println("4. Terror");
        System.out.println("5. Romance");
        System.out.println("Digite 0 para sair");
    }

    private static String obterCategoria(int opcaoCategoria) {
        switch (opcaoCategoria) {
            case 1:
                return "Aventura";
            case 2:
                return "Com�dia";
            case 3:
                return "Drama";
            case 4:
                return "Terror";
            case 5:
                return "Romance";
            default:
                return "";
        }
    }

    private static void exibirMangasDaCategoria(String categoria, String[] mangas) {
        System.out.println("===== Mang�s da Categoria " + categoria + " =====");
        for (String manga : mangas) {
            System.out.println(manga);
        }
    }
}
