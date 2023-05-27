import java.util.Scanner;

public class Contate_nos_Admin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        boolean sair = false;
        
        while (!sair) {
            exibirMenuContato();
            
            System.out.print("Escolha uma op��o: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha
            
            switch (opcao) {
                case 1:
                    System.out.println("Op��o selecionada: Ajuda");
                    // Implemente o c�digo para a op��o Ajuda aqui
                    break;
                case 2:
                    System.out.println("Op��o selecionada: Suporte T�cnico");
                    // Implemente o c�digo para a op��o Suporte T�cnico aqui
                    break;
                case 3:
                    System.out.println("Op��o selecionada: Suporte Financeiro");
                    // Implemente o c�digo para a op��o Suporte Financeiro aqui
                    break;
                case 4:
                    System.out.println("Op��o selecionada: Fale com um Administrador");
                    // Implemente o c�digo para a op��o Fale com um Administrador aqui
                    break;
                case 5:
                    System.out.println("Op��o selecionada: Feedback");
                    // Implemente o c�digo para a op��o Feedback aqui
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
    
    private static void exibirMenuContato() {
        System.out.println("===== Contate-nos =====");
        System.out.println("1. Ajuda");
        System.out.println("2. Suporte T�cnico");
        System.out.println("3. Suporte Financeiro");
        System.out.println("4. Fale com um Administrador");
        System.out.println("5. Feedback");
        System.out.println("0. Sair");
    }
}
