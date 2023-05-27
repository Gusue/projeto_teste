import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Tarefa {
    private String descricao;

    public Tarefa(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}

class Mensagem {
    private String remetente;
    private String destinatario;
    private String assunto;
    private String conteudo;

    public Mensagem(String remetente, String destinatario, String assunto, String conteudo) {
        this.remetente = remetente;
        this.destinatario = destinatario;
        this.assunto = assunto;
        this.conteudo = conteudo;
    }

    public String getRemetente() {
        return remetente;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public String getAssunto() {
        return assunto;
    }

    public String getConteudo() {
        return conteudo;
    }
}

public class inbox_admin {
    public static void main(String[] args) {
        List<Tarefa> tarefas = new ArrayList<>();
        tarefas.add(new Tarefa("Tarefa 1"));
        tarefas.add(new Tarefa("Tarefa 2"));
        tarefas.add(new Tarefa("Tarefa 3"));

        List<Mensagem> mensagensEnviadas = new ArrayList<>();
        List<Mensagem> mensagensRecebidas = new ArrayList<>();
        List<Mensagem> mensagensImportantes = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        boolean sair = false;

        while (!sair) {
            exibirMenu();

            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (opcao) {
                case 1:
                    exibirTarefas(tarefas);
                    break;
                case 2:
                    exibirMensagens(mensagensEnviadas, "Mensagens Enviadas");
                    break;
                case 3:
                    exibirMensagens(mensagensRecebidas, "Mensagens Recebidas");
                    break;
                case 4:
                    escreverMensagem(mensagensEnviadas, mensagensRecebidas);
                    break;
                case 5:
                    exibirMensagens(mensagensImportantes, "Mensagens Importantes");
                    break;
                case 6:
                    // Implemente o código para as outras opções aqui
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
        System.out.println("===== Aplicação de Tarefas e Mensagens =====");
        System.out.println("1. Ver Tarefas");
        System.out.println("2. Mensagens Enviadas");
        System.out.println("3. Mensagens Recebidas");
        System.out.println("4. Escrever uma Mensagem");
        System.out.println("5. Mensagens Importantes");
        System.out.println("6. Outras Opções");
        System.out.println("0. Sair");
    }

    private static void exibirTarefas(List<Tarefa> tarefas) {
        System.out.println("===== Tarefas Pendentes =====");
        for (int i = 0; i < tarefas.size(); i++) {
            System.out.println((i + 1) + ". " + tarefas.get(i).getDescricao());
        }
    }

    private static void exibirMensagens(List<Mensagem> mensagens, String titulo) {
        System.out.println("===== " + titulo + " =====");
        if (mensagens.isEmpty()) {
            System.out.println("Não há mensagens.");
        } else {
            for (int i = 0; i < mensagens.size(); i++) {
                Mensagem mensagem = mensagens.get(i);
                System.out.println("Mensagem " + (i + 1) + ":");
                System.out.println("Remetente: " + mensagem.getRemetente());
                System.out.println("Assunto: " + mensagem.getAssunto());
                System.out.println("Conteúdo: " + mensagem.getConteudo());
                System.out.println();
            }
        }
    }

    private static void escreverMensagem(List<Mensagem> mensagensEnviadas, List<Mensagem> mensagensRecebidas) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("===== Escrever Mensagem =====");
        System.out.print("Remetente: ");
        String remetente = scanner.nextLine();

        System.out.print("Destinatário: ");
        String destinatario = scanner.nextLine();

        System.out.print("Assunto: ");
        String assunto = scanner.nextLine();

        System.out.print("Conteúdo: ");
        String conteudo = scanner.nextLine();

        Mensagem mensagem = new Mensagem(remetente, destinatario, assunto, conteudo);
        mensagensEnviadas.add(mensagem);
        mensagensRecebidas.add(mensagem);

        System.out.println("Mensagem enviada com sucesso.");
    }
}
