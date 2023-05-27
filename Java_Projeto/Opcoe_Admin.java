import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class CartaoCredito {
    private String nome;
    private String numero;
    private String dataVencimento;
    private String cvc;

    public CartaoCredito(String nome, String numero, String dataVencimento, String cvc) {
        this.nome = nome;
        this.numero = numero;
        this.dataVencimento = dataVencimento;
        this.cvc = cvc;
    }

    public String getNome() {
        return nome;
    }

    public String getNumero() {
        return numero;
    }

    public String getDataVencimento() {
        return dataVencimento;
    }

    public String getCVC() {
        return cvc;
    }
}

class Opcoes {
    private String nome;
    private String email;
    private String senha;
    private String foto;
    private List<CartaoCredito> cartoes;

    public Opcoes(String nome, String email, String senha, String foto) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.foto = foto;
        this.cartoes = new ArrayList<>();
    }

    public void editarFoto(String novaFoto) {
        this.foto = novaFoto;
        System.out.println("Foto atualizada com sucesso!");
    }

    public void editarEmail(String novoEmail) {
        this.email = novoEmail;
        System.out.println("E-mail atualizado com sucesso!");
    }

    public void editarSenha(String novaSenha) {
        this.senha = novaSenha;
        System.out.println("Senha atualizada com sucesso!");
    }

    public void adicionarCartao(String nome, String numero, String dataVencimento, String cvc) {
        CartaoCredito cartao = new CartaoCredito(nome, numero, dataVencimento, cvc);
        cartoes.add(cartao);
        System.out.println("Cartão adicionado com sucesso!");
    }

    public void listarCartoes() {
        System.out.println("===== Cartões de Crédito =====");
        if (cartoes.isEmpty()) {
            System.out.println("Nenhum cartão cadastrado.");
        } else {
            for (CartaoCredito cartao : cartoes) {
                System.out.println("Nome: " + cartao.getNome());
                System.out.println("Número: " + cartao.getNumero());
                System.out.println("Data de Vencimento: " + cartao.getDataVencimento());
                System.out.println("CVC: " + cartao.getCVC());
                System.out.println("---------------------------");
            }
        }
    }

    public void exibirOpcoes() {
        Scanner scanner = new Scanner(System.in);

        boolean sair = false;
        while (!sair) {
            System.out.println("===== Minha Conta =====");
            System.out.println("1. Editar Foto");
            System.out.println("2. Editar E-mail");
            System.out.println("3. Editar Senha");
            System.out.println("4. Adicionar Cartão de Crédito");
            System.out.println("5. Listar Cartões de Crédito");
            System.out.println("0. Sair");

            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (opcao) {
                case 1:
                    System.out.print("Digite a nova foto: ");
                    String novaFoto = scanner.nextLine();
                    editarFoto(novaFoto);
                    break;
                case 2:
                    System.out.print("Digite o novo e-mail: ");
                    String novoEmail = scanner.nextLine();
                    editarEmail(novoEmail);
                    break;
                case 3:
                    System.out.print("Digite a nova senha: ");
                    String novaSenha = scanner.nextLine();
                    editarSenha(novaSenha);
                    break;
                case 4:
                    System.out.print("Digite o nome do cartão: ");
                    String nomeCartao = scanner.nextLine();
                    System.out.print("Digite o número do cartão: ");
                    String numeroCartao = scanner.nextLine();
                    System.out.print("Digite a data de vencimento do cartão: ");
                    String dataVencimentoCartao = scanner.nextLine();
                    System.out.print("Digite o CVC do cartão: ");
                    String cvcCartao = scanner.nextLine();
                    adicionarCartao(nomeCartao, numeroCartao, dataVencimentoCartao, cvcCartao);
                    break;
                case 5:
                    listarCartoes();
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
}

public class Opcoe_Admin{
    public static void main(String[] args) {
        Opcoes opcoes = new Opcoes("Nome", "email@example.com", "senha", "foto.jpg");
        opcoes.exibirOpcoes();
    }
}
