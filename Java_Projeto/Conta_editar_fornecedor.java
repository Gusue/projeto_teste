import java.util.Scanner;

class Usuario {
    private String nome;
    private String email;
    private String senha;

    public Usuario(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}

public class Conta_editar_fornecedor {
    public static void main(String[] args) {
        Usuario usuario = new Usuario("João", "joao@email.com", "senha");

        Scanner scanner = new Scanner(System.in);

        boolean sair = false;

        while (!sair) {
            exibirMenu();

            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (opcao) {
                case 1:
                    exibirInformacoesUsuario(usuario);
                    break;
                case 2:
                    editarNome(usuario, scanner);
                    break;
                case 3:
                    editarEmail(usuario, scanner);
                    break;
                case 4:
                    editarSenha(usuario, scanner);
                    break;
                case 0:
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

            System.out.println();
        }
    }

    private static void exibirMenu() {
        System.out.println("===== Edição de Usuário =====");
        System.out.println("1. Exibir informações do usuário");
        System.out.println("2. Editar nome");
        System.out.println("3. Editar email");
        System.out.println("4. Editar senha");
        System.out.println("0. Sair");
    }

    private static void exibirInformacoesUsuario(Usuario usuario) {
        System.out.println("===== Informações do Usuário =====");
        System.out.println("Nome: " + usuario.getNome());
        System.out.println("Email: " + usuario.getEmail());
        System.out.println("Senha: " + usuario.getSenha());
    }

    private static void editarNome(Usuario usuario, Scanner scanner) {
        System.out.print("Digite o novo nome: ");
        String novoNome = scanner.nextLine();
        usuario.setNome(novoNome);
        System.out.println("Nome atualizado com sucesso.");
    }

    private static void editarEmail(Usuario usuario, Scanner scanner) {
        System.out.print("Digite o novo email: ");
        String novoEmail = scanner.nextLine();
        usuario.setEmail(novoEmail);
        System.out.println("Email atualizado com sucesso.");
    }

    private static void editarSenha(Usuario usuario, Scanner scanner) {
        System.out.print("Digite a nova senha: ");
        String novaSenha = scanner.nextLine();
        usuario.setSenha(novaSenha);
        System.out.println("Senha atualizada com sucesso.");
    }
}
