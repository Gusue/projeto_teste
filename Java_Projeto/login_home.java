import java.util.Scanner;

public class login_home {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean executando = true;

        while (executando) {
            exibirMenu();

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer de entrada

            switch (opcao) {
                case 1:
                    fazerLogin(scanner);
                    break;
                case 2:
                    Registrar(scanner);
                    break;
                case 3:
                    pesquisarAlgo(scanner);
                    break;
                case 4:
                    executando = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }

    private static void exibirMenu() {
        System.out.println("========== Menu ==========");
        System.out.println("1. Fazer login");
        System.out.println("2. Registrar");
        System.out.println("3. Pesquisar algo");
        System.out.println("4. Sair");
        System.out.print("Selecione uma opção: ");
    }

    private static void fazerLogin(Scanner scanner) {
        System.out.println("== Opção: Fazer login ==");
        // Lógica de login aqui
    }

    private static void Registrar(Scanner scanner) {
        System.out.println("== Opção: Fazer assinatura ==");
        // Lógica de assinatura aqui
    }

    private static void pesquisarAlgo(Scanner scanner) {
        System.out.println("== Opção: Pesquisar algo ==");
        // Lógica de pesquisa aqui
    }
}