import java.util.Scanner;

public class Home_Admin {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean sair = false;
        boolean isAdmin = false;

        System.out.println("===== Página Inicial =====");

        while (!sair) {
            exibirMenu();

            System.out.print("Selecione uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1:
                    System.out.println("Você selecionou: Home");
                    // Lógica para exibir a página Home
                    break;
                case 2:
                    System.out.println("Você selecionou: Ao vivo");
                    // Lógica para exibir a página Ao vivo
                    break;
                case 3:
                    System.out.println("Você selecionou: Podcast");
                    // Lógica para exibir a página Podcast
                    break;
                case 4:
                    System.out.println("Você selecionou: Notícias");
                    // Lógica para exibir a página Notícias
                    break;
                case 5:
                    System.out.println("Você selecionou: Categoria");
                    // Lógica para exibir a página Categoria
                    break;
                case 6:
                    System.out.println("Você selecionou: Opções");
                    // Lógica para exibir a página Opções
                    break;
                case 7:
                    System.out.println("Você selecionou: Imagens");
                    
                        exibirOpcoesAdministrativas();
                        int opcaoAdmin = scanner.nextInt();
                        scanner.nextLine(); // Limpar o buffer

                        switch (opcaoAdmin) {
                            case 1:
                                System.out.println("Você selecionou: Editar Imagem");
                                // Lógica para editar a imagem
                                break;
                            case 2:
                                System.out.println("Você selecionou: Publicar Nova Imagem");
                                // Lógica para publicar nova imagem
                                break;
                            default:
                                System.out.println("Opção inválida. Tente novamente.");
                                break;
                        }
                   
                    break;
                case 8:
                    System.out.println("Você selecionou: Contate-nos");
                    // Lógica para exibir a página Contate-nos
                    break;
                case 9:
                    System.out.println("Você selecionou: Atualizações");
                    // Lógica para exibir a página Atualizações
                    break;
                case 10:
                    System.out.println("Você selecionou: Recursos");
                    // Lógica para exibir a página Recursos
                    break;
                case 0:
                    System.out.println("Saindo...");
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
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
        System.out.println("4. Notícias");
        System.out.println("5. Categoria");
        System.out.println("6. Opções");
        System.out.println("7. Imagens");
        System.out.println("8. Contate-nos");
        System.out.println("9. Atualizações");
        System.out.println("10. Recursos");
        System.out.println("0. Sair");
    }

    private static void exibirOpcoesAdministrativas() {
        System.out.println("===== Opções Administrativas =====");
        System.out.println("1. Editar Imagem");
        System.out.println("2. Publicar Nova Imagem");
    }
}
