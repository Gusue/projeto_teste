import java.util.Scanner;

class Conta {
    private double saldo;

    public Conta(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        saldo += valor;
        System.out.println("Dep�sito realizado com sucesso. Novo saldo: R$" + saldo);
    }

    public void sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
            System.out.println("Saque realizado com sucesso. Novo saldo: R$" + saldo);
        } else {
            System.out.println("Saldo insuficiente. Saque n�o realizado.");
        }
    }

    public void transferir(double valor, String tipoTransferencia) {
        if (tipoTransferencia.equalsIgnoreCase("conta bancaria")) {
            System.out.println("Transfer�ncia via conta banc�ria realizada. Valor: R$" + valor);
        } else if (tipoTransferencia.equalsIgnoreCase("pix")) {
            System.out.println("Transfer�ncia via PIX realizada. Valor: R$" + valor);
        } else {
            System.out.println("Tipo de transfer�ncia inv�lido.");
        }
    }

    public void pagar(String email, String numeroCartao, String dataValidade, String cvv) {
        System.out.println("Pagamento realizado com sucesso.");
        System.out.println("Detalhes do pagamento:");
        System.out.println("Email: " + email);
        System.out.println("N�mero do cart�o: " + numeroCartao);
        System.out.println("Data de validade: " + dataValidade);
        System.out.println("CVV: " + cvv);
    }
}

public class Conta_Fornecedor {
    public static void main(String[] args) {
        Conta conta = new Conta(5000.0);
        Scanner scanner = new Scanner(System.in);

        boolean sair = false;

        while (!sair) {
            exibirMenu();
            System.out.print("Escolha uma op��o: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (opcao) {
                case 1:
                    System.out.println("Saldo: R$" + conta.getSaldo());
                    break;
                case 2:
                    System.out.print("Digite o valor do dep�sito: ");
                    double valorDeposito = scanner.nextDouble();
                    scanner.nextLine(); // Consumir a quebra de linha
                    conta.depositar(valorDeposito);
                    break;
                case 3:
                    System.out.print("Digite o valor do saque: ");
                    double valorSaque = scanner.nextDouble();
                    scanner.nextLine(); // Consumir a quebra de linha
                    conta.sacar(valorSaque);
                    break;
                case 4:
                    System.out.print("Digite o valor da transfer�ncia: ");
                    double valorTransferencia = scanner.nextDouble();
                    scanner.nextLine(); // Consumir a quebra de linha
                    System.out.print("Digite o tipo de transfer�ncia (Conta Banc�ria ou PIX): ");
                    String tipoTransferencia = scanner.nextLine();
                    conta.transferir(valorTransferencia, tipoTransferencia);
                    break;
                case 5:
                    System.out.print("Digite o email para pagamento: ");
                    String emailPagamento = scanner.nextLine();
                    System.out.print("Digite o n�mero do cart�o: ");
                    String numeroCartao = scanner.nextLine();
                    System.out.print("Digite a data de validade do cart�o: ");
                    String dataValidade = scanner.nextLine();
                    System.out.print("Digite o CVV do cart�o: ");
                    String cvv = scanner.nextLine();
                    conta.pagar(emailPagamento, numeroCartao, dataValidade, cvv);
                    break;
                case 0:
                    sair = true;
                    break;
                default:
                    System.out.println("Op��o inv�lida. Tente novamente.");
            }

            System.out.println();
        }
    }

    private static void exibirMenu() {
        System.out.println("===== Aplica��o de Conta Banc�ria =====");
        System.out.println("1. Verificar Saldo");
        System.out.println("2. Realizar Dep�sito");
        System.out.println("3. Realizar Saque");
        System.out.println("4. Realizar Transfer�ncia");
        System.out.println("5. Realizar Pagamento");
        System.out.println("0. Sair");
    }
}
