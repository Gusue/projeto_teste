import java.util.Scanner;

public class registro {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("===== Registro de Usuário =====");

        System.out.print("Primeiro nome: ");
        String primeiroNome = scanner.nextLine();

        System.out.print("Último nome: ");
        String ultimoNome = scanner.nextLine();

        System.out.print("Telefone celular: ");
        String telefone = scanner.nextLine();

        System.out.print("E-mail: ");
        String email = scanner.nextLine();

        String senha;
        String confirmarSenha;

        do {
            System.out.print("Senha: ");
            senha = scanner.nextLine();

            System.out.print("Confirmar senha: ");
            confirmarSenha = scanner.nextLine();

            if (senha.equals(confirmarSenha)) {
                // Processar o registro do usuário
                System.out.println("Registro bem-sucedido!");
                System.out.println("Dados do usuário:");
                System.out.println("Nome completo: " + primeiroNome + " " + ultimoNome);
                System.out.println("Telefone celular: " + telefone);
                System.out.println("E-mail: " + email);
            } else {
                System.out.println("As senhas não coincidem. Registro falhou.");
            }
        } while (!senha.equals(confirmarSenha));
    }
}