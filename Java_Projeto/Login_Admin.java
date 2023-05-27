import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Login_Admin {

    private static Map<String, String> credenciais = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Registrar usuários (apenas para fins de demonstração)
        registrarUsuario("admin", "admin");

        System.out.print("Digite o nome de usuário: ");
        String nomeUsuario = scanner.nextLine();

        System.out.print("Digite a senha: ");
        String senha = scanner.nextLine();
        scanner.close();

        if (autenticar(nomeUsuario, senha)) {
            System.out.println("Login bem-sucedido!");
        } else {
            System.out.println("Credenciais inválidas. Login falhou.");
        }
    }

    private static void registrarUsuario(String nomeUsuario, String senha) {
        credenciais.put(nomeUsuario, senha);
    }

    private static boolean autenticar(String nomeUsuario, String senha) {
        if (credenciais.containsKey(nomeUsuario)) {
            String senhaArmazenada = credenciais.get(nomeUsuario);
            return senha.equals(senhaArmazenada);
        }
        return false;
    }
}