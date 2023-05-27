import java.util.Scanner;

public class Recursos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        boolean aceitarTermo = false;
        
        while (!aceitarTermo) {
            exibirMenu();
            
            System.out.print("Escolha uma op��o: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha
            
            switch (opcao) {
                case 1:
                    visualizarTermoDeUso();
                    break;
                case 2:
                    aceitarTermo = true;
                    System.out.println("Termo de Uso aceito. Continue com a aplica��o.");
                    break;
                case 3:
                    System.out.println("Voc� escolheu n�o aceitar o Termo de Uso. A aplica��o ser� encerrada.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Op��o inv�lida. Tente novamente.");
            }
            
            System.out.println();
        }
        
        // Resto da aplica��o continua aqui ap�s o usu�rio aceitar o Termo de Uso
        // ...
    }
    
    private static void exibirMenu() {
        System.out.println("===== Termo de Uso =====");
        System.out.println("1. Visualizar Termo de Uso");
        System.out.println("2. Aceitar Termo de Uso e continuar");
        System.out.println("3. N�o aceitar Termo de Uso e sair");
    }
    
    private static void visualizarTermoDeUso() {
        // C�digo para exibir o Termo de Uso ou Contrato de Licen�a (EULA)
        System.out.println("===== Termo de Uso =====");
        System.out.println("Texto do Termo de Uso ou Contrato de Licen�a");
        System.out.println("Lorem ipsum dolor sit amet, consectetur adipiscing elit...");
    }
}
