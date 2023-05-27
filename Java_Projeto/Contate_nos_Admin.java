import java.util.Scanner;

public class Contate_nos_Admin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        boolean sair = false;
        
        while (!sair) {
            exibirMenuContato();
            
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha
            
            switch (opcao) {
                case 1:
                    System.out.println("Opção selecionada: Ajuda");
                    // Implemente o código para a opção Ajuda aqui
                    break;
                case 2:
                    System.out.println("Opção selecionada: Suporte Técnico");
                    // Implemente o código para a opção Suporte Técnico aqui
                    break;
                case 3:
                    System.out.println("Opção selecionada: Suporte Financeiro");
                    // Implemente o código para a opção Suporte Financeiro aqui
                    break;
                case 4:
                    System.out.println("Opção selecionada: Fale com um Administrador");
                    // Implemente o código para a opção Fale com um Administrador aqui
                    break;
                case 5:
                    System.out.println("Opção selecionada: Feedback");
                    // Implemente o código para a opção Feedback aqui
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
    
    private static void exibirMenuContato() {
        System.out.println("===== Contate-nos =====");
        System.out.println("1. Ajuda");
        System.out.println("2. Suporte Técnico");
        System.out.println("3. Suporte Financeiro");
        System.out.println("4. Fale com um Administrador");
        System.out.println("5. Feedback");
        System.out.println("0. Sair");
    }
}
