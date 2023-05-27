import java.util.Scanner;

public class comprar_assinatura {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("===== Compra de Assinatura =====");

        System.out.print("E-mail: ");
        String email = scanner.nextLine();

        System.out.println("Selecione o tipo de cart�o:");
        System.out.println("1. Visa");
        System.out.println("2. MasterCard");
        System.out.println("3. American Express");
        System.out.println("4. Diners Club");
        System.out.print("Op��o: ");
        int tipoCartao = scanner.nextInt();

        scanner.nextLine(); // Limpar o buffer

        System.out.print("Data de validade (MM/AA): ");
        String dataValidade = scanner.nextLine();

        System.out.print("CVV: ");
        String cvv = scanner.nextLine();

        double valorAssinatura = 100.00;

        System.out.println("\nResumo da Compra:");
        System.out.println("E-mail: " + email);
        System.out.println("Tipo de cart�o: " + obterNomeTipoCartao(tipoCartao));
        System.out.println("Data de validade: " + dataValidade);
        System.out.println("CVV: " + cvv);
        System.out.println("Valor da assinatura: R$" + valorAssinatura);

        // Simula��o de processamento de pagamento
        System.out.println("\nProcessando pagamento...");

        // C�digo de processamento de pagamento aqui...

        System.out.println("Pagamento realizado com sucesso! Assinatura ativada.");
    }

    private static String obterNomeTipoCartao(int tipoCartao) {
        switch (tipoCartao) {
            case 1:
                return "Visa";
            case 2:
                return "MasterCard";
            case 3:
                return "American Express";
            case 4:
                return "Diners Club";
            default:
                return "Desconhecido";
        }
    }
}
