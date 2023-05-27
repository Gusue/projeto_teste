import java.util.Scanner;

public class Ao_vivo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("===== Reprodutor de Vídeo =====");

        boolean reproduzindo = false;
        int tempoAtual = 0;

        while (true) {
            exibirVideo(tempoAtual);
            exibirOpcoes();

            System.out.print("Selecione uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1:
                    reproduzindo = !reproduzindo;
                    if (reproduzindo) {
                        System.out.println("Reproduzindo o vídeo...");
                    } else {
                        System.out.println("Vídeo pausado.");
                    }
                    break;
                case 2:
                    System.out.print("Digite o tempo (segundos): ");
                    int novoTempo = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer
                    if (novoTempo >= 0) {
                        tempoAtual = novoTempo;
                        System.out.println("Vídeo avançado para o tempo " + novoTempo + " segundos.");
                    } else {
                        System.out.println("Tempo inválido.");
                    }
                    break;
                case 3:
                    exibirComentarios();
                    break;
                case 0:
                    System.out.println("Encerrando a aplicação...");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }

            System.out.println();
        }
    }

    private static void exibirVideo(int tempoAtual) {
        System.out.println("===== Vídeo =====");
        System.out.println("Tempo atual: " + tempoAtual + " segundos");
        // Lógica para exibir o vídeo em tempo real
        // Aqui você pode implementar a reprodução do vídeo ou exibir o quadro atual do vídeo
    }

    private static void exibirOpcoes() {
        System.out.println("===== Opções =====");
        System.out.println("1. Pausar/Reproduzir");
        System.out.println("2. Selecionar tempo");
        System.out.println("3. Exibir comentários");
        System.out.println("0. Sair");
    }

    private static void exibirComentarios() {
        System.out.println("===== Comentários =====");
        // Lógica para exibir os comentários do vídeo
    }
}