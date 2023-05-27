import java.util.Scanner;

public class Ao_vivo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("===== Reprodutor de V�deo =====");

        boolean reproduzindo = false;
        int tempoAtual = 0;

        while (true) {
            exibirVideo(tempoAtual);
            exibirOpcoes();

            System.out.print("Selecione uma op��o: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1:
                    reproduzindo = !reproduzindo;
                    if (reproduzindo) {
                        System.out.println("Reproduzindo o v�deo...");
                    } else {
                        System.out.println("V�deo pausado.");
                    }
                    break;
                case 2:
                    System.out.print("Digite o tempo (segundos): ");
                    int novoTempo = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer
                    if (novoTempo >= 0) {
                        tempoAtual = novoTempo;
                        System.out.println("V�deo avan�ado para o tempo " + novoTempo + " segundos.");
                    } else {
                        System.out.println("Tempo inv�lido.");
                    }
                    break;
                case 3:
                    exibirComentarios();
                    break;
                case 0:
                    System.out.println("Encerrando a aplica��o...");
                    return;
                default:
                    System.out.println("Op��o inv�lida. Tente novamente.");
                    break;
            }

            System.out.println();
        }
    }

    private static void exibirVideo(int tempoAtual) {
        System.out.println("===== V�deo =====");
        System.out.println("Tempo atual: " + tempoAtual + " segundos");
        // L�gica para exibir o v�deo em tempo real
        // Aqui voc� pode implementar a reprodu��o do v�deo ou exibir o quadro atual do v�deo
    }

    private static void exibirOpcoes() {
        System.out.println("===== Op��es =====");
        System.out.println("1. Pausar/Reproduzir");
        System.out.println("2. Selecionar tempo");
        System.out.println("3. Exibir coment�rios");
        System.out.println("0. Sair");
    }

    private static void exibirComentarios() {
        System.out.println("===== Coment�rios =====");
        // L�gica para exibir os coment�rios do v�deo
    }
}