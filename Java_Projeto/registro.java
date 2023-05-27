import java.util.Scanner;

public class registro {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("===== Registro de Usu�rio =====");

        System.out.print("Primeiro nome: ");
        String primeiroNome = scanner.nextLine();

        System.out.print("�ltimo nome: ");
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
                // Processar o registro do usu�rio
                System.out.println("Registro bem-sucedido!");
                System.out.println("Dados do usu�rio:");
                System.out.println("Nome completo: " + primeiroNome + " " + ultimoNome);
                System.out.println("Telefone celular: " + telefone);
                System.out.println("E-mail: " + email);
            } else {
                System.out.println("As senhas n�o coincidem. Registro falhou.");
            }
        } while (!senha.equals(confirmarSenha));
    }
}