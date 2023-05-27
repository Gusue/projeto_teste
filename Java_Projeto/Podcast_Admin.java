import java.util.Scanner;

public class Podcast_Admin {
    private static String video;
    private static int espectadores;
    private static int inscritos;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean sair = false;

        System.out.println("===== Live Streaming App =====");

        while (!sair) {
            exibirMenu();

            System.out.print("Selecione uma op��o: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1:
                    exibirDetalhes();
                    break;
                case 2:
                    editarVideo(scanner);
                    break;
                case 3:
                    exibirEspectadores();
                    break;
                case 4:
                    exibirInscritos();
                    break;
                case 5:
                    encerrarLive();
                    sair = true;
                    break;
                default:
                    System.out.println("Op��o inv�lida. Tente novamente.");
                    break;
            }

            System.out.println();
        }
    }

    private static void exibirMenu() {
        System.out.println("===== Menu =====");
        System.out.println("1. Exibir Detalhes");
        System.out.println("2. Editar V�deo");
        System.out.println("3. Exibir N�mero de Espectadores");
        System.out.println("4. Exibir N�mero de Inscritos");
        System.out.println("5. Encerrar Live");
    }

    private static void exibirDetalhes() {
        System.out.println("===== Detalhes da Live =====");
        System.out.println("V�deo: " + video);
        System.out.println("Espectadores: " + espectadores);
        System.out.println("Inscritos: " + inscritos);
    }

    private static void editarVideo(Scanner scanner) {
        System.out.println("===== Editar V�deo =====");

        System.out.print("Novo V�deo: ");
        video = scanner.nextLine();

        System.out.println("V�deo alterado com sucesso!");
    }

    private static void exibirEspectadores() {
        System.out.println("Espectadores: " + espectadores);
    }

    private static void exibirInscritos() {
        System.out.println("Inscritos: " + inscritos);
    }

    private static void encerrarLive() {
        System.out.println("Live encerrada!");
    }
}
