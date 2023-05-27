import java.util.Scanner;

public class noticias {

    private static final int TOTAL_NOTICIAS = 3;
    private static final int NOTA_MINIMA = 1;
    private static final int NOTA_MAXIMA = 5;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] noticias = {
                "Not�cia 1: Nova s�rie de mang� lan�ada!",
                "Not�cia 2: Entrevista com o autor de um mang� famoso",
                "Not�cia 3: Novo volume de mang� dispon�vel para pr�-venda"
        };

        int[] notas = new int[TOTAL_NOTICIAS];
        boolean[] noticiasVisualizadas = new boolean[TOTAL_NOTICIAS];

        System.out.println("===== Aplica��o de Not�cias sobre Mang� =====");

        boolean sair = false;

        while (!sair) {
            exibirMenuPrincipal();
            System.out.print("Selecione uma op��o: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1:
                    exibirNoticias(noticias, noticiasVisualizadas);
                    break;
                case 2:
                    if (exibirNoticiasVotar(noticias, notas, noticiasVisualizadas, scanner)) {
                        sair = true;
                    }
                    break;
                case 0:
                    System.out.println("Encerrando a aplica��o...");
                    sair = true;
                    break;
                default:
                    System.out.println("Op��o inv�lida. Tente novamente.");
                    break;
            }
            System.out.println();
        }
    }

    private static void exibirMenuPrincipal() {
        System.out.println("===== Menu Principal =====");
        System.out.println("1. Visualizar Not�cias");
        System.out.println("2. Visualizar e Votar em Not�cias");
        System.out.println("0. Sair");
    }

    private static void exibirNoticias(String[] noticias, boolean[] noticiasVisualizadas) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("===== Not�cias =====");
        for (int i = 0; i < TOTAL_NOTICIAS; i++) {
            if (!noticiasVisualizadas[i]) {
                System.out.println("Not�cia " + (i + 1) + ":");
                System.out.println(noticias[i]);
                System.out.println("Digite 'S' para abrir a not�cia ou qualquer outra tecla para continuar.");
                String opcao = scanner.nextLine();
                if (opcao.equalsIgnoreCase("S")) {
                    noticiasVisualizadas[i] = true;
                    exibirNoticia(noticias[i]);
                }
                System.out.println();
            }
        }
    }

    private static boolean exibirNoticiasVotar(String[] noticias, int[] notas, boolean[] noticiasVisualizadas, Scanner scanner) {
        System.out.println("===== Not�cias =====");
        for (int i = 0; i < TOTAL_NOTICIAS; i++) {
            System.out.println("Not�cia " + (i + 1) + ":");
            System.out.println(noticias[i]);
            System.out.println("Nota atual: " + notas[i]);
            System.out.println("Digite 'S' para votar nesta not�cia ou qualquer outra tecla para continuar.");
            String opcao = scanner.nextLine();
            if (opcao.equalsIgnoreCase("S")) {
                votarNoticia(i, notas, scanner);
            }
            System.out.println();
        }

        System.out.println("Deseja sair? (S/N)");
        String opcaoSair = scanner.nextLine();
        return opcaoSair.equalsIgnoreCase("S");
    }

    private static void exibirNoticia(String noticia) {
        System.out.println("===== Not�cia =====");
        System.out.println(noticia);
        System.out.println("Pressione Enter para voltar.");
        new Scanner(System.in).nextLine();
    }

    private static void votarNoticia(int indiceNoticia, int[] notas, Scanner scanner) {
        System.out.println("Digite uma nota de " + NOTA_MINIMA + " a " + NOTA_MAXIMA + " para esta not�cia: ");
        int nota = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        if (nota >= NOTA_MINIMA && nota <= NOTA_MAXIMA) {
            notas[indiceNoticia] = nota;
            System.out.println("Voto registrado com sucesso!");
        } else {
            System.out.println("Nota inv�lida. Voto n�o registrado.");
        }
    }
}
