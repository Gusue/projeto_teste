import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class login {

    private static Map<String, String> credenciais = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Registrar usu�rios (apenas para fins de demonstra��o)
        registrarUsuario("usuario1", "123");
        registrarUsuario("usuario2", "senha123");

        System.out.print("Digite o nome de usu�rio: ");
        String nomeUsuario = scanner.nextLine();

        System.out.print("Digite a senha: ");
        String senha = scanner.nextLine();
        scanner.close();

        if (autenticar(nomeUsuario, senha)) {
            System.out.println("Login bem-sucedido!");
        } else {
            System.out.println("Credenciais inv�lidas. Login falhou.");
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