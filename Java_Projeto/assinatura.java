import java.util.Scanner;

public class assinatura {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        

        System.out.println("Bem-vindo à aplicação de assinatura!");
        System.out.print("Você deseja fazer uma assinatura? (S/N): ");
        String resposta =  scanner.nextLine();
        scanner.close();

        if (resposta.equalsIgnoreCase("S")) {
            System.out.println("Ótimo! Você escolheu fazer uma assinatura.");
            // Lógica de assinatura aqui
        } else if (resposta.equalsIgnoreCase("N")) {
            System.out.println("Tudo bem! Você optou por não fazer uma assinatura.");
            // Lógica de não assinatura aqui
        } else {
            System.out.println("Opção inválida. Tente novamente.");
        }
    }
}