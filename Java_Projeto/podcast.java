import java.util.Scanner;

public class podcast {

    private static final int TOTAL_PODCASTS = 3;
    private static final int NOTA_MINIMA = 1;
    private static final int NOTA_MAXIMA = 5;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] podcasts = {
                "Podcast 1: Título do Podcast 1",
                "Podcast 2: Título do Podcast 2",
                "Podcast 3: Título do Podcast 3"
        };

        int[] notas = new int[TOTAL_PODCASTS];
        boolean[] podcastsOuvidos = new boolean[TOTAL_PODCASTS];

        System.out.println("===== Aplicação de Podcasts =====");

        boolean sair = false;

        while (!sair) {
            exibirMenuPrincipal();
            System.out.print("Selecione uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1:
                    exibirPodcasts(podcasts, podcastsOuvidos);
                    break;
                case 2:
                    votarPodcasts(podcasts, notas, podcastsOuvidos, scanner);
                    break;
                case 3:
                    pausarPodcast(podcastsOuvidos);
                    break;
                case 0:
                    System.out.println("Encerrando a aplicação...");
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
            System.out.println();
        }
    }

    private static void exibirMenuPrincipal() {
        System.out.println("===== Menu Principal =====");
        System.out.println("1. Visualizar Podcasts");
        System.out.println("2. Votar em Podcasts");
        System.out.println("3. Pausar Podcast");
        System.out.println("0. Sair");
    }

    private static void exibirPodcasts(String[] podcasts, boolean[] podcastsOuvidos) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("===== Podcasts =====");
        for (int i = 0; i < TOTAL_PODCASTS; i++) {
            if (!podcastsOuvidos[i]) {
                System.out.println("Podcast " + (i + 1) + ":");
                System.out.println(podcasts[i]);
                System.out.println("Digite 'O' para ouvir o podcast ou qualquer outra tecla para continuar.");
                String opcao = scanner.nextLine();
                if (opcao.equalsIgnoreCase("O")) {
                    podcastsOuvidos[i] = true;
                    ouvirPodcast(podcasts[i]);
                }
                System.out.println();
            }
        }
    }

    private static void votarPodcasts(String[] podcasts, int[] notas, boolean[] podcastsOuvidos, Scanner scanner) {
        System.out.println("===== Votar em Podcasts =====");
        for (int i = 0; i < TOTAL_PODCASTS; i++) {
            if (podcastsOuvidos[i]) {
                System.out.println("Podcast " + (i + 1) + ":");
                System.out.println(podcasts[i]);
                System.out.println("Nota atual: " + notas[i]);
                System.out.println("Digite 'V' para votar neste podcast ou qualquer outra tecla para continuar.");
                String opcao = scanner.nextLine();
                if (opcao.equalsIgnoreCase("V")) {
                    votarPodcast(i, notas, scanner);
                }
                System.out.println();
            }
        }
    }

    private static void pausarPodcast(boolean[] podcastsOuvidos) {
        System.out.println("===== Pausar Podcast =====");
        for (int i = 0; i < TOTAL_PODCASTS; i++) {
            if (podcastsOuvidos[i]) {
                System.out.println("Podcast " + (i + 1) + ":");
                System.out.println("O podcast está pausado.");
                System.out.println();
            }
        }
    }

    private static void ouvirPodcast(String podcast) {
        System.out.println("===== Ouvindo Podcast =====");
        System.out.println(podcast);
        System.out.println("Pressione Enter para voltar.");
        new Scanner(System.in).nextLine();
    }

    private static void votarPodcast(int indicePodcast, int[] notas, Scanner scanner) {
        System.out.println("Digite uma nota de " + NOTA_MINIMA + " a " + NOTA_MAXIMA + " para este podcast: ");
        int nota = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        if (nota >= NOTA_MINIMA && nota <= NOTA_MAXIMA) {
            notas[indicePodcast] = nota;
            System.out.println("Voto registrado com sucesso!");
        } else {
            System.out.println("Nota inválida. Voto não registrado.");
        }
    }
}
