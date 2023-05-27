import java.util.Scanner;

public class Home_Admin {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean sair = false;
        boolean isAdmin = false;

        System.out.println("===== P�gina Inicial =====");

        while (!sair) {
            exibirMenu();

            System.out.print("Selecione uma op��o: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1:
                    System.out.println("Voc� selecionou: Home");
                    // L�gica para exibir a p�gina Home
                    break;
                case 2:
                    System.out.println("Voc� selecionou: Ao vivo");
                    // L�gica para exibir a p�gina Ao vivo
                    break;
                case 3:
                    System.out.println("Voc� selecionou: Podcast");
                    // L�gica para exibir a p�gina Podcast
                    break;
                case 4:
                    System.out.println("Voc� selecionou: Not�cias");
                    // L�gica para exibir a p�gina Not�cias
                    break;
                case 5:
                    System.out.println("Voc� selecionou: Categoria");
                    // L�gica para exibir a p�gina Categoria
                    break;
                case 6:
                    System.out.println("Voc� selecionou: Op��es");
                    // L�gica para exibir a p�gina Op��es
                    break;
                case 7:
                    System.out.println("Voc� selecionou: Imagens");
                    
                        exibirOpcoesAdministrativas();
                        int opcaoAdmin = scanner.nextInt();
                        scanner.nextLine(); // Limpar o buffer

                        switch (opcaoAdmin) {
                            case 1:
                                System.out.println("Voc� selecionou: Editar Imagem");
                                // L�gica para editar a imagem
                                break;
                            case 2:
                                System.out.println("Voc� selecionou: Publicar Nova Imagem");
                                // L�gica para publicar nova imagem
                                break;
                            default:
                                System.out.println("Op��o inv�lida. Tente novamente.");
                                break;
                        }
                   
                    break;
                case 8:
                    System.out.println("Voc� selecionou: Contate-nos");
                    // L�gica para exibir a p�gina Contate-nos
                    break;
                case 9:
                    System.out.println("Voc� selecionou: Atualiza��es");
                    // L�gica para exibir a p�gina Atualiza��es
                    break;
                case 10:
                    System.out.println("Voc� selecionou: Recursos");
                    // L�gica para exibir a p�gina Recursos
                    break;
                case 0:
                    System.out.println("Saindo...");
                    sair = true;
                    break;
                default:
                    System.out.println("Op��o inv�lida. Tente novamente.");
                    break;
            }

            System.out.println();
        }
    }

    private static void exibirMenu() {
        System.out.println("===== Menu =====");
        System.out.println("1. Home");
        System.out.println("2. Ao vivo");
        System.out.println("3. Podcast");
        System.out.println("4. Not�cias");
        System.out.println("5. Categoria");
        System.out.println("6. Op��es");
        System.out.println("7. Imagens");
        System.out.println("8. Contate-nos");
        System.out.println("9. Atualiza��es");
        System.out.println("10. Recursos");
        System.out.println("0. Sair");
    }

    private static void exibirOpcoesAdministrativas() {
        System.out.println("===== Op��es Administrativas =====");
        System.out.println("1. Editar Imagem");
        System.out.println("2. Publicar Nova Imagem");
    }
}
