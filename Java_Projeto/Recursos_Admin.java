import java.util.Scanner;

public class Recursos_Admin {
    private static String termoDeUso = ""; // Vari�vel para armazenar o termo de uso

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean aceitarTermo = false;

        while (!aceitarTermo) {
            exibirMenu();

            System.out.print("Escolha uma op��o: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (opcao) {
                case 1:
                    visualizarTermoDeUso();
                    break;
                case 2:
                    aceitarTermo = true;
                    System.out.println("Termo de Uso aceito. Continue com a aplica��o.");
                    break;
                case 3:
                    System.out.println("Voc� escolheu n�o aceitar o Termo de Uso. A aplica��o ser� encerrada.");
                    System.exit(0);
                    break;
                case 4:
                    editarTermoDeUso(scanner);
                    break;
                case 5:
                    removerTermoDeUso();
                    break;
                case 6:
                    adicionarTermoDeUso(scanner);
                    break;
                default:
                    System.out.println("Op��o inv�lida. Tente novamente.");
            }

            System.out.println();
        }

        // Resto da aplica��o continua aqui ap�s o usu�rio aceitar o Termo de Uso
        // ...
    }

    private static void exibirMenu() {
        System.out.println("===== Termo de Uso =====");
        System.out.println("1. Visualizar Termo de Uso");
        System.out.println("2. Aceitar Termo de Uso e continuar");
        System.out.println("3. N�o aceitar Termo de Uso e sair");
        System.out.println("4. Editar Termo de Uso");
        System.out.println("5. Remover Termo de Uso");
        System.out.println("6. Adicionar Termo de Uso");
    }

    private static void visualizarTermoDeUso() {
        if (!termoDeUso.isEmpty()) {
            System.out.println("===== Termo de Uso =====");
            System.out.println(termoDeUso);
        } else {
            System.out.println("Termo de Uso n�o definido.");
        }
    }

    private static void editarTermoDeUso(Scanner scanner) {
        if (!termoDeUso.isEmpty()) {
            System.out.print("Digite o novo texto do Termo de Uso: ");
            String novoTermoDeUso = scanner.nextLine();
            termoDeUso = novoTermoDeUso;
            System.out.println("Termo de Uso editado com sucesso.");
        } else {
            System.out.println("Termo de Uso n�o definido. Use a op��o 'Adicionar Termo de Uso'.");
        }
    }

    private static void removerTermoDeUso() {
        termoDeUso = "";
        System.out.println("Termo de Uso removido.");
    }

    private static void adicionarTermoDeUso(Scanner scanner) {
        System.out.print("Digite o texto do Termo de Uso: ");
        String novoTermoDeUso = scanner.nextLine();
        termoDeUso = novoTermoDeUso;
        System.out.println("Termo de Uso adicionado com sucesso.");
    }
}
