
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

class conta{
    
}
class Imagem {
    private String titulo;
    private String sinopse;
    private int anoLancamento;
    private String editora;
    private double preco;
    private double avaliacao;
    private String comentario;

    public Imagem(String titulo, String sinopse, int anoLancamento, String editora, double preco) {
        this.titulo = titulo;
        this.sinopse = sinopse;
        this.anoLancamento = anoLancamento;
        this.editora = editora;
        this.preco = preco;
        this.avaliacao = 0.0;
        this.comentario = "";
    }

    public String getTitulo() {
        return titulo;
    }

    public String getSinopse() {
        return sinopse;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public String getEditora() {
        return editora;
    }

    public double getPreco() {
        return preco;
    }

    public double getAvaliacao() {
        return avaliacao;
    }

    public String getComentario() {
        return comentario;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setAvaliacao(double avaliacao) {
        this.avaliacao = avaliacao;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}


class Atualizacao {
    private String titulo;
    private String descricao;

    public Atualizacao(String titulo, String descricao) {
        this.titulo = titulo;
        this.descricao = descricao;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}

public class Codigo {


    
    private static List<Noticia> noticias = new ArrayList<>();
    private static Map<String, String> anuncios = new HashMap<>();
    private static Map<String, String> credenciais = new HashMap<>();
    private static boolean assinaturaAtiva = false;
    private static String usuarioLogado = "";
    private static String nomeCompleto = "";
    private static String email = "";
    private static String telefone = "";
    private static String senha = "";
    private static boolean admin1 = false;
    private static boolean forn1 = false;
    private static String video;
    private static int espectadores;
    private static int inscritos;
    private static String termoDeUso = "";

    static {
        credenciais.put("admin", "admin");
        credenciais.put("fornecedor", "fornecedor");
    }

    public static void main(String[] args) {



        Connection connection = null;

try {

    String url = "jdbc:mysql://localhost:3306/gusue";
    String username = "root";
    String password = "gusue";
    
  connection = DriverManager.getConnection(url, username, password);
    

    
} catch (SQLException e) {

    e.printStackTrace();
} finally {
  
    if (connection != null) {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}



        anuncios.put("Pagina inicial", "Esta e a pagina principal do painel de administracao...");
        anuncios.put("Podcast", "Acesse a pagina de Podcast para gerenciar seus episodios...");
        anuncios.put("Eventos ao vivo", "Se voce realiza transmissoes ao vivo de eventos relacionados a HQs...");
        anuncios.put("Categorias",
                "A pagina de Categorias permite organizar seus quadrinhos em diferentes categorias...");
        anuncios.put("Opcoes",
                "Nesta pagina, voce encontrara uma variedade de configuracoes para personalizar o funcionamento do site...");

        Scanner menu = new Scanner(System.in);
        Scanner not_ = new Scanner(System.in);
        boolean executando = true;

        while (executando) {
            exibirMenuPrincipal();

            int opcao = menu.nextInt();
            menu.nextLine();

            switch (opcao) {
                case 1:
                    fazerLogin(menu);
                    break;
                case 2:
                    registrar(menu);
                    break;
                case 0:
                    executando = false;
                    break;
                default:
                    System.out.println("Opcao invalida. Tente novamente.");
                    break;
            }
        }
    }

    private static void exibirMenuPrincipal() {
        
        clearScreen();
        System.out.println("========== Menu Principal ==========");
        System.out.println("1. Fazer login");
        System.out.println("2. Registrar");
        System.out.println("0. Sair");
        System.out.print("Selecione uma opcao: ");
    }

    private static void fazerLogin(Scanner login) {
        System.out.println("== Opcao: Fazer login ==");

        System.out.print("Digite o nome de usuario: ");
        String nomeUsuario = login.nextLine();

        System.out.print("Digite a senha: ");
        String senha = login.nextLine();

        if (autenticar(nomeUsuario, senha)) {
            usuarioLogado = nomeUsuario;
            System.out.println("Login bem-sucedido! Bem-vindo, " + usuarioLogado + "!");

            if (nomeUsuario.equals("fornecedor")) {
                forn1 = true;

            } else {
                forn1 = false;
            }
            if (nomeUsuario.equals("admin")) {
                admin1 = true;

            } else {
                admin1 = false;
            }

            Scanner menuLogado = new Scanner(System.in);
            boolean logado = true;
            Scanner ao_vivo = new Scanner(System.in);

            while (logado) {
                exibirMenuLogado();

                int opcaoLogado = menuLogado.nextInt();
                menuLogado.nextLine(); // Limpar o buffer de entrada

                switch (opcaoLogado) {
                    case 1:
                        fazerAssinatura();
                        break;
                    case 2:
                        System.out.println("opcao: Home/guia");
                        home_();

                        break;
                    case 3:
                        System.out.println("opcao: Ao vivo");
                        aoVivo(ao_vivo);
                        break;
                    case 4:
                        System.out.println("opcao: Podcast");
                        Podcast_();
                        break;
                    case 5:
                        System.out.println("opcao: Noticias");
                        Noticias_Admin();
                        break;
                    case 6:
                        System.out.println("opcao: Categorias");
                        Categoria_Admin();
                        break;
                    case 7:
                        System.out.println("opcao: Opcoes");
                        exibirOpcoes_();
                        break;
                    case 8:
                        System.out.println("opcao: Imagens");
                        Imagens_();
                        break;
                    case 9:
                        System.out.println("opcao: Contate-nos");
                        botzim();
                        break;
                    case 10:
                        System.out.println("opcao: Atualizacoes");
                        atualizacoes_();
                        break;
                    case 11:
                        System.out.println("opcao: Recursos");
                        Recursos_Admin();
                        break;
                    case 0:
                        logado = false;
                        break;
                    default:
                        System.out.println("opcao invalida. Tente novamente.");
                        break;
                }
            }
        } else {
            System.out.println("Credenciais invalidas. Login falhou.");
        }
    }

    private static void registrar(Scanner registrar) {
        System.out.println("== opcao: Fazer assinatura ==");
        
        Scanner registrar_ = new Scanner(System.in);
        

        System.out.println("===== Registro de Usuario =====");

        System.out.print("Primeiro nome: ");
        String primeiroNome = registrar_.nextLine();

        System.out.print("Ultimo nome: ");
        String ultimoNome = registrar_.nextLine();

        nomeCompleto = primeiroNome + " " + ultimoNome;

        System.out.print("Telefone celular: ");
        String telefone = registrar_.nextLine();

        System.out.print("E-mail: ");
        String email = registrar_.nextLine();

        System.out.print("Nome de Usuario: ");
        String nomeUsuario = registrar_.nextLine();
        String senha;
        String confirmarSenha;

        do {
            System.out.print("Senha: ");
            senha = registrar_.nextLine();

            System.out.print("Confirmar senha: ");
            confirmarSenha = registrar_.nextLine();

            if (senha.equals(confirmarSenha)) {
                registrarUsuario(nomeUsuario, senha);
                System.out.println("Registro bem-sucedido!");
                System.out.println("Dados do usuario:");
                System.out.println("Usuario: " + nomeUsuario);
                System.out.println("Nome completo: " + nomeCompleto);
                System.out.println("Telefone celular: " + telefone);
                System.out.println("E-mail: " + email);
                System.out.print("Deseja fazer uma assinatura? (S/N): ");
                String resposta = registrar_.nextLine();
                if (resposta.equalsIgnoreCase("S")) {
                    fazerAssinatura();
                }
            } else {
                System.out.println("As senhas nao coincidem. Registro falhou.");
            }
        } while (!senha.equals(confirmarSenha));
    }

    private static void fazerAssinatura() {
        if (assinaturaAtiva) {
            System.out.println("Voce ja possui uma assinatura ativa.");
        } else {
            Scanner assinaturaScanner = new Scanner(System.in);
            System.out.println(nomeCompleto + "Voce deseja realizar a Assinatura pro por R$1000,00 por ano");
            System.out.print("Digite o nUmero do cartao de credito: ");
            String numeroCartao = assinaturaScanner.nextLine();
            System.out.print("Digite a validade do cartao: ");
            String validadeCartao = assinaturaScanner.nextLine();
            System.out.print("Digite o CVV do cartao: ");
            String cvvCartao = assinaturaScanner.nextLine();
            System.out.println("Pagamento realizado com sucesso!");
            System.out.println("Assinatura ativada para " + nomeCompleto + ".");
            assinaturaAtiva = true;
        }
    }

    private static boolean autenticar(String nomeUsuario, String senha) {
        if (credenciais.containsKey(nomeUsuario)) {
            String senhaArmazenada = credenciais.get(nomeUsuario);
            return senha.equals(senhaArmazenada);
        }
        return false;
    }

    private static void registrarUsuario(String nomeUsuario, String senha) {
        credenciais.put(nomeUsuario, senha);
    }

    private static void exibirMenuLogado() {
        
        System.out.println("========== Bem-vindo, " + usuarioLogado + " ==========");
        System.out.println("1. Fazer assinatura");
        System.out.println("2. Home");
        System.out.println("3. Ao vivo");
        System.out.println("4. Podcast");
        System.out.println("5. Noticias");
        System.out.println("6. Categorias");
        System.out.println("7. Opcoes");
        System.out.println("8. Imagens");
        System.out.println("9. Contate-nos");
        System.out.println("10. Atualizacoes");
        System.out.println("11. Recursos");
        System.out.println("0. LogOut");
        System.out.print("Selecione uma opcao: ");
    }

    private static void aoVivo(Scanner ao_vivo) {
        
        System.out.println("===== Reprodutor de Video =====");

        boolean reproduzindo = false;
        int tempoAtual = 0;

        while (true) {
            exibirVideo(tempoAtual);
            exibirOpcoes();

            System.out.print("Selecione uma opcao: ");
            int opcao = ao_vivo.nextInt();
            ao_vivo.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1:
                    reproduzindo = !reproduzindo;
                    if (reproduzindo) {
                        System.out.println("Reproduzindo o video...");
                    } else {
                        System.out.println("Video pausado.");
                    }
                    break;
                case 2:
                    System.out.print("Digite o tempo (segundos): ");
                    int novoTempo = ao_vivo.nextInt();
                    ao_vivo.nextLine(); // Limpar o buffer
                    if (novoTempo >= 0) {
                        tempoAtual = novoTempo;
                        System.out.println("Video avancado para o tempo " + novoTempo + " segundos.");
                    } else {
                        System.out.println("Tempo invalido.");
                    }
                    break;
                case 3:
                    exibirComentarios();
                    break;
                case 0:
                    System.out.println("Encerrando a aplicacao...");
                    return;
                default:
                    System.out.println("opcao invalida. Tente novamente.");
                    break;
            }

            System.out.println();
        }
    }

    private static void exibirVideo(int tempoAtual) {
        
        System.out.println("===== Video =====");
        System.out.println("Tempo atual: " + tempoAtual + " segundos");
        // Logica para exibir o video em tempo real
        // Aqui voce pode implementar a reproducao do video ou exibir o quadro atual do
        // video
    }

    private static void exibirOpcoes() {
        
        System.out.println("===== Opcoes =====");
        System.out.println("1. Pausar/Reproduzir");
        System.out.println("2. Selecionar tempo");
        System.out.println("3. Exibir comentarios");
        System.out.println("0. Sair");
    }

    private static void exibirComentarios() {
        
        System.out.println("===== Comentarios =====");
        // Logica para exibir os comentarios do video em tempo real
    }

    private static void atualizacoes_() {
        
        List<Atualizacao> atualizacoes = new ArrayList<>();
        atualizacoes.add(new Atualizacao("Atualizacao 1", "Descricao da Atualizacao 1"));
        atualizacoes.add(new Atualizacao("Atualizacao 2", "Descricao da Atualizacao 2"));
        atualizacoes.add(new Atualizacao("Atualizacao 3", "Descricao da Atualizacao 3"));

        Scanner scanner = new Scanner(System.in);

        boolean sair = false;
        int opcao = 0;

        while (!sair) {
            
            System.out.println("===== Aplicacao de Atualizacoes =====");
            System.out.println("1. Listar Atualizacoes");
            if (admin1 == true) {
                System.out.println("2. Adicionar Atualizacao");
                System.out.println("3. Editar Atualizacao");
                System.out.println("4. Remover Atualizacao");
            }
            System.out.println("0. Sair");

            System.out.print("Escolha uma opcao: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (opcao) {
                case 0:
                    sair = true;
                    break;
                case 1:
                    listarAtualizacoes(atualizacoes);
                    break;
                case 2:
                    if (admin1 == true) {
                        adicionarAtualizacao(scanner, atualizacoes);
                    } else {
                        System.out.println("Voce nao tem permissao para adicionar atualizacoes.");
                    }
                    break;
                case 3:
                    if (admin1 == true) {
                        editarAtualizacao(scanner, atualizacoes);
                    } else {
                        System.out.println("Voce nao tem permissao para editar atualizacoes.");
                    }
                    break;
                case 4:
                    if (admin1 == true) {
                        removerAtualizacao(scanner, atualizacoes);
                    } else {
                        System.out.println("Voce nao tem permissao para remover atualizacoes.");
                    }
                    break;
                default:
                    System.out.println("opcao invalida. Tente novamente.");
            }

            System.out.println();
        }
    }

    private static void listarAtualizacoes(List<Atualizacao> atualizacoes) {
        
        System.out.println("===== Lista de Atualizacoes =====");
        for (int i = 0; i < atualizacoes.size(); i++) {
            Atualizacao atualizacao = atualizacoes.get(i);
            System.out.println((i + 1) + ". " + atualizacao.getTitulo());
        }
    }

    private static void adicionarAtualizacao(Scanner scanner, List<Atualizacao> atualizacoes) {
        
        System.out.print("Digite o titulo da atualizacao: ");
        String titulo = scanner.nextLine();

        System.out.print("Digite a descricao da atualizacao: ");
        String descricao = scanner.nextLine();

        Atualizacao novaAtualizacao = new Atualizacao(titulo, descricao);
        atualizacoes.add(novaAtualizacao);

        System.out.println("Nova atualizacao adicionada com sucesso!");
    }

    private static void editarAtualizacao(Scanner scanner, List<Atualizacao> atualizacoes) {
        
        System.out.print("Digite o nUmero da atualizacao que deseja editar: ");
        int numeroAtualizacao = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha

        if (numeroAtualizacao >= 1 && numeroAtualizacao <= atualizacoes.size()) {
            Atualizacao atualizacao = atualizacoes.get(numeroAtualizacao - 1);

            System.out.print("Digite o novo titulo da atualizacao: ");
            String novoTitulo = scanner.nextLine();

            System.out.print("Digite a nova descricao da atualizacao: ");
            String novaDescricao = scanner.nextLine();

            atualizacao.setTitulo(novoTitulo);
            atualizacao.setDescricao(novaDescricao);

            System.out.println("Atualizacao editada com sucesso!");
        } else {
            System.out.println("NUmero de atualizacao invalido.");
        }
    }

    private static void removerAtualizacao(Scanner scanner, List<Atualizacao> atualizacoes) {
        
        System.out.print("Digite o nUmero da atualizacao que deseja remover: ");
        int numeroAtualizacao = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha

        if (numeroAtualizacao >= 1 && numeroAtualizacao <= atualizacoes.size()) {
            Atualizacao atualizacaoRemovida = atualizacoes.remove(numeroAtualizacao - 1);
            System.out.println("Atualizacao removida: " + atualizacaoRemovida.getTitulo());
        } else {
            System.out.println("NUmero de atualizacao invalido.");
        }
    }

    private static void Podcast_() {
        
        Scanner pdcst = new Scanner(System.in);

        boolean sair = false;

        System.out.println("===== Live Streaming App =====");

        while (!sair) {
            
            exibirMenu();

            System.out.print("Selecione uma opcao: ");
            int opcao = pdcst.nextInt();
            pdcst.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1:
                    exibirDetalhes();
                    break;
                case 2:
                    editarVideo(pdcst);
                    break;
                case 3:
                    exibirEspectadores();
                    break;
                case 4:
                    exibirInscritos();
                    break;
                case 5:
                    encerrarLive(pdcst);
                    sair = true;
                    break;
                default:
                    System.out.println("opcao invalida. Tente novamente.");
                    break;
            }

            System.out.println();
        }
    }

    private static void exibirMenu() {
        
        System.out.println("===== Menu =====");
        System.out.println("1. Exibir Detalhes");
        System.out.println("2. Editar Video");
        System.out.println("3. Exibir NUmero de Espectadores");
        System.out.println("4. Exibir NUmero de Inscritos");
        System.out.println("5. Encerrar Live");
    }

    private static void exibirDetalhes() {
        
        System.out.println("===== Detalhes da Live =====");
        System.out.println("Video: " + video);
        System.out.println("Espectadores: " + espectadores);
        System.out.println("Inscritos: " + inscritos);
    }

    private static void editarVideo(Scanner scanner) {
        
        System.out.println("===== Editar Video =====");

        if (admin1 == true) {
            System.out.print("Novo Video: ");
            video = scanner.nextLine();

            System.out.println("Video alterado com sucesso!");
        } else {
            System.out.println("Apenas o usuario admin pode editar o video.");
        }
    }

    private static void exibirEspectadores() {
        
        System.out.println("Espectadores: " + espectadores);
    }

    private static void exibirInscritos() {
        
        System.out.println("Inscritos: " + inscritos);
    }

    private static void encerrarLive(Scanner scanner) {
        
        System.out.println("===== Encerrar Live =====");

        if (admin1 == true) {
            System.out.println("Live encerrada!");
        } else {
            System.out.println("Apenas o usuario admin pode encerrar a live.");
        }
    }

    private static void Noticias_Admin() {
        
        Scanner not_ = new Scanner(System.in);
        boolean sair = false;
        System.out.println("===== Gerenciador de Noticias =====");

        while (!sair) {
            exibirMenu1();
            
            System.out.print("Selecione uma opcao: ");
            int opcao = not_.nextInt();
            not_.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1:
                    exibirNoticias();
                    break;
                case 2:
                    if (admin1 == true) {
                        adicionarNoticia(not_);
                    } else {
                        System.out.println("Voce nao tem permissao para fazer isso.");
                    }

                    break;
                case 3:
                    if (admin1 == true) {
                        editarNoticia(not_);
                    } else {
                        System.out.println("Voce nao tem permissao para fazer isso.");
                    }

                    break;
                case 4:
                    if (admin1 == true) {
                        excluirNoticia(not_);
                    } else {
                        System.out.println("Voce nao tem permissao para fazer isso.");
                    }

                    break;
                case 0:
                    sair = true;
                    break;
                default:
                    System.out.println("opcao invalida. Tente novamente.");
                    break;
            }

            System.out.println();
        }
    }

    private static void exibirMenu1() {
        
        System.out.println("===== Menu =====");
        System.out.println("1. Exibir Noticias");
        System.out.println("2. Adicionar Noticia");
        System.out.println("3. Editar Noticia");
        System.out.println("4. Excluir Noticia");
        System.out.println("0. Sair");
    }

    private static void exibirNoticias() {
        
        System.out.println("===== Noticias =====");

        if (noticias.isEmpty()) {
            System.out.println("Nenhuma noticia cadastrada.");
        } else {
            for (Noticia noticia : noticias) {
                System.out.println(noticia);
            }
        }
    }

    private static void adicionarNoticia(Scanner scanner) {
        
        System.out.println("===== Adicionar Noticia =====");

        System.out.print("Titulo: ");
        String titulo = scanner.nextLine();

        System.out.print("ConteUdo: ");
        String conteudo = scanner.nextLine();

        Noticia novaNoticia = new Noticia(titulo, conteudo);
        noticias.add(novaNoticia);

        System.out.println("Noticia adicionada com sucesso!");
    }

    private static void editarNoticia(Scanner scanner) {
        
        System.out.println("===== Editar Noticia =====");

        exibirNoticias();

        System.out.print("Selecione o nUmero da noticia que deseja editar: ");

        int numeroNoticia = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        if (numeroNoticia < 1 || numeroNoticia > noticias.size()) {
            System.out.println("NUmero de noticia invalido.");
            return;
        }

        Noticia noticia = noticias.get(numeroNoticia - 1);

        System.out.print("Novo Titulo: ");
        String novoTitulo = scanner.nextLine();

        System.out.print("Novo ConteUdo: ");
        String novoConteudo = scanner.nextLine();

        noticia.setTitulo(novoTitulo);
        noticia.setConteudo(novoConteudo);

        System.out.println("Noticia editada com sucesso!");
    }

    private static void excluirNoticia(Scanner scanner) {
        
        System.out.println("===== Excluir Noticia =====");

        exibirNoticias();

        System.out.print("Selecione o nUmero da noticia que deseja excluir: ");
        int numeroNoticia = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        if (numeroNoticia < 1 || numeroNoticia > noticias.size()) {
            System.out.println("NUmero de noticia invalido.");
            return;
        }

        noticias.remove(numeroNoticia - 1);

        System.out.println("Noticia excluida com sucesso!");
    }

    private static class Noticia {
        private String titulo;
        private String conteudo;

        public Noticia(String titulo, String conteudo) {
            this.titulo = titulo;
            this.conteudo = conteudo;
        }

        public String getTitulo() {
            return titulo;
        }

        public void setTitulo(String titulo) {
            this.titulo = titulo;
        }

        public String getConteudo() {
            return conteudo;
        }

        public void setConteudo(String conteudo) {
            this.conteudo = conteudo;
        }

        @Override
        public String toString() {
            return "Titulo: " + titulo + "\nConteUdo: " + conteudo + "\n";
        }
    }

    private static void Categoria_Admin() {
        

        Map<Integer, String[]> mangasPorCategoria = new HashMap<>();
        mangasPorCategoria.put(1, new String[] { "Manga1A", "Manga1B" });
        mangasPorCategoria.put(2, new String[] { "Manga2A", "Manga2B" });
        mangasPorCategoria.put(3, new String[] { "Manga3A", "Manga3B" });
        mangasPorCategoria.put(4, new String[] { "Manga4A", "Manga4B" });
        mangasPorCategoria.put(5, new String[] { "Manga5A", "Manga5B" });

        Scanner categoria_ = new Scanner(System.in);

        System.out.println("===== Aplicacao de Mangas =====");

        boolean sair = false;

        while (!sair) {
            exibirMenuCategorias();

            System.out.print("Selecione uma opcao: ");
            int opcao = categoria_.nextInt();
            categoria_.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1:
                    exibirCategorias(mangasPorCategoria);
                    break;
                case 2:
                    if (admin1 == true) {
                        adicionarCategoria(categoria_, mangasPorCategoria);
                    } else {
                        System.out.println("Voce nao tem permissao para fazer isso.");
                    }

                    break;
                case 3:
                    if (admin1 == true) {
                        editarCategoria(categoria_, mangasPorCategoria);
                    } else {
                        System.out.println("Voce nao tem permissao para fazer isso.");
                    }

                    break;
                case 4:
                    if (admin1 == true) {
                        excluirCategoria(categoria_, mangasPorCategoria);
                    } else {
                        System.out.println("Voce nao tem permissao para fazer isso.");
                    }

                    break;
                case 0:
                    sair = true;
                    break;
                default:
                    System.out.println("opcao invalida. Tente novamente.");
                    break;
            }

            System.out.println();
        }
    }

    private static void exibirMenuCategorias() {
        
        System.out.println("===== Menu =====");
        System.out.println("1. Exibir Categorias");
        System.out.println("2. Adicionar Categoria");
        System.out.println("3. Editar Categoria");
        System.out.println("4. Excluir Categoria");
        System.out.println("0. Sair");
    }

    private static void exibirCategorias(Map<Integer, String[]> mangasPorCategoria) {
        
        System.out.println("===== Categorias de Mangas =====");
        for (Map.Entry<Integer, String[]> entry : mangasPorCategoria.entrySet()) {
            int categoria = entry.getKey();
            String[] mangas = entry.getValue();
            System.out.println("Categoria " + categoria + ":");
            for (String manga : mangas) {
                System.out.println(manga);
            }
            System.out.println();
        }
    }

    private static void adicionarCategoria(Scanner scanner, Map<Integer, String[]> mangasPorCategoria) {
        
        System.out.println("===== Adicionar Categoria =====");

        System.out.print("NUmero da categoria: ");
        int numeroCategoria = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        if (mangasPorCategoria.containsKey(numeroCategoria)) {
            System.out.println("Categoria ja existe.");
            return;
        }

        System.out.print("Quantidade de mangas: ");
        int quantidadeMangas = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        String[] mangas = new String[quantidadeMangas];
        for (int i = 0; i < quantidadeMangas; i++) {
            System.out.print("Nome do manga " + (i + 1) + ": ");
            mangas[i] = scanner.nextLine();
        }

        mangasPorCategoria.put(numeroCategoria, mangas);
        System.out.println("Categoria adicionada com sucesso!");
    }

    private static void editarCategoria(Scanner scanner, Map<Integer, String[]> mangasPorCategoria) {
        
        System.out.println("===== Editar Categoria =====");

        System.out.print("NUmero da categoria: ");
        int numeroCategoria = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        if (!mangasPorCategoria.containsKey(numeroCategoria)) {
            System.out.println("Categoria nao encontrada.");
            return;
        }

        String[] mangas = mangasPorCategoria.get(numeroCategoria);

        System.out.println("Mangas da categoria " + numeroCategoria + ":");
        for (int i = 0; i < mangas.length; i++) {
            System.out.println((i + 1) + ". " + mangas[i]);
        }

        System.out.print("Selecione o nUmero do manga para editar: ");
        int numeroManga = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        if (numeroManga < 1 || numeroManga > mangas.length) {
            System.out.println("NUmero de manga invalido.");
            return;
        }

        System.out.print("Novo nome do manga: ");
        String novoNomeManga = scanner.nextLine();

        mangas[numeroManga - 1] = novoNomeManga;
        System.out.println("Manga editado com sucesso!");
    }

    private static void excluirCategoria(Scanner scanner, Map<Integer, String[]> mangasPorCategoria) {
        
        System.out.println("===== Excluir Categoria =====");

        System.out.print("NUmero da categoria: ");
        int numeroCategoria = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        if (!mangasPorCategoria.containsKey(numeroCategoria)) {
            System.out.println("Categoria nao encontrada.");
            return;
        }

        mangasPorCategoria.remove(numeroCategoria);
        System.out.println("Categoria excluida com sucesso!");
    }

    private static void botzim() {
        
        Scanner bots = new Scanner(System.in);

        boolean sair = false;

        while (!sair) {
            exibirMenuContato();

            System.out.print("Escolha uma opcao: ");
            int opcao4 = bots.nextInt();
            bots.nextLine(); // Consumir a quebra de linha

            switch (opcao4) {
                case 1:
                    System.out.println("opcao selecionada: Ajuda");
                    responderAjuda();
                    break;
                case 2:
                    System.out.println("opcao selecionada: Suporte Tecnico");
                    responderSuporteTecnico();
                    break;
                case 3:
                    System.out.println("opcao selecionada: Suporte Financeiro");
                    responderSuporteFinanceiro();
                    break;
                case 4:
                    System.out.println("opcao selecionada: Fale com um Administrador");
                    responderFaleComAdministrador();
                    break;
                case 5:
                    System.out.println("opcao selecionada: Feedback");
                    responderFeedback();
                    break;
                case 0:
                    sair = true;
                    break;
                default:
                    System.out.println("opcao invalida. Tente novamente.");
            }

            System.out.println();
        }
    }

    private static void exibirMenuContato() {
        
        System.out.println("===== Contate-nos =====");
        System.out.println("1. Ajuda");
        System.out.println("2. Suporte Tecnico");
        System.out.println("3. Suporte Financeiro");
        System.out.println("4. Fale com um Administrador");
        System.out.println("5. Feedback");
        System.out.println("0. Sair");
    }

    private static void responderAjuda() {
        
        System.out.println("Se voce precisa de ajuda, entre em contato com o nosso suporte.");
        System.out.println("Voce pode enviar um email para suporte@exemplo.com ou ligar para o nUmero (XX) XXXX-XXXX.");
    }

    private static void responderSuporteTecnico() {
        
        System.out.println("Para suporte tecnico, por favor, envie um email para suporte@exemplo.com");
        System.out.println(
                "Descreva o problema que voce esta enfrentando e entraremos em contato o mais rapido possivel.");
    }

    private static void responderSuporteFinanceiro() {
        
        System.out.println("Para suporte financeiro, entre em contato com o nosso setor de financas.");
        System.out.println(
                "Voce pode enviar um email para financeiro@exemplo.com ou ligar para o nUmero (XX) XXXX-XXXX.");
    }

    private static void responderFaleComAdministrador() {
        
        
        System.out.println("Se voce precisa falar com um administrador, envie um email para administrador@exemplo.com");
        System.out.println("Explique a sua necessidade e um administrador entrara em contato com voce em breve.");
    }

    private static void responderFeedback() {
        
        System.out.println("Agradecemos pelo seu feedback! Sua opiniao e importante para nos.");
        System.out.println("Seu feedback sera encaminhado para a equipe responsavel para analise e consideracao.");
    }

    //
    //
    private static void Recursos_Admin() {
        

        Scanner term_ = new Scanner(System.in);

        boolean aceitarTermo = false;

        while (!aceitarTermo) {
            exibirMenu_();

            System.out.print("Escolha uma opcao: ");
            int opcao_ = term_.nextInt();
            term_.nextLine(); // Consumir a quebra de linha

            switch (opcao_) {
                case 1:
                    visualizarTermoDeUso();
                    break;
                case 2:
                    aceitarTermo = true;
                    System.out.println("Termo de Uso aceito. Continue com a aplicacao.");
                    break;
                case 3:
                    System.out.println("Voce escolheu nao aceitar o Termo de Uso. A aplicacao sera encerrada.");
                    System.exit(0);
                    break;
                case 4:
                    if (admin1 == true) {
                        editarTermoDeUso(term_);
                    } else {
                        System.out.println("Voce nao tem permissao para fazer isso.");
                    }

                    break;
                case 5:
                    if (admin1 == true) {
                        removerTermoDeUso();
                    } else {
                        System.out.println("Voce nao tem permissao para fazer isso.");
                    }

                    break;
                case 6:
                    if (admin1 == true) {
                        adicionarTermoDeUso(term_);
                    } else {
                        System.out.println("Voce nao tem permissao para fazer isso.");
                    }

                    break;
                default:
                    System.out.println("opcao invalida. Tente novamente.");
            }

            System.out.println();
        }

    }

    private static void exibirMenu_() {
        
        System.out.println("===== Termo de Uso =====");
        System.out.println("1. Visualizar Termo de Uso");
        System.out.println("2. Aceitar Termo de Uso e continuar");
        System.out.println("3. Nao aceitar Termo de Uso e sair");
        System.out.println("4. Editar Termo de Uso");
        System.out.println("5. Remover Termo de Uso");
        System.out.println("6. Adicionar Termo de Uso");
    }

    private static void visualizarTermoDeUso() {
        
        if (!termoDeUso.isEmpty()) {
            System.out.println("===== Termo de Uso =====");
            System.out.println(termoDeUso);
        } else {
            System.out.println("Termo de Uso nao definido.");
        }
    }

    private static void editarTermoDeUso(Scanner scanner) {
        
        if (!termoDeUso.isEmpty()) {
            System.out.print("Digite o novo texto do Termo de Uso: ");
            String novoTermoDeUso = scanner.nextLine();
            termoDeUso = novoTermoDeUso;
            System.out.println("Termo de Uso editado com sucesso.");
        } else {
            System.out.println("Termo de Uso nao definido. Use a opcao 'Adicionar Termo de Uso'.");
        }
    }

    private static void removerTermoDeUso() {
        
        termoDeUso = "";
        System.out.println("Termo de Uso removido.");
    }

    private static void adicionarTermoDeUso(Scanner scanner) {
        
        System.out.print("Digite o texto do Termo de Uso: ");
        String novoTermoDeUso = scanner.nextLine();
        termoDeUso = novoTermoDeUso;
        System.out.println("Termo de Uso adicionado com sucesso.");
    }

    private static void home_() {
        

        Scanner hom_ = new Scanner(System.in);

        boolean sair = false;

        System.out.println("Bem-vindo ao painel do site de HQs!");

        while (!sair) {
            exibirMenuu();
            System.out.print("Selecione uma opcao: ");
            int opcao = hom_.nextInt();
            hom_.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1:
                    exibirAnuncios();
                    break;
                case 2:

                    if (admin1 == true) {
                        adicionarAnuncio(hom_);
                    } else {
                        System.out.println("Voce nao tem permissao para adicionar atualizacoes.");
                    }

                    break;
                case 3:
                    if (admin1 == true) {
                        editarAnuncio(hom_);
                    } else {
                        System.out.println("Voce nao tem permissao para adicionar atualizacoes.");
                    }

                    break;
                case 4:
                    if (admin1 == true) {
                        apagarAnuncio(hom_);
                    } else {
                        System.out.println("Voce nao tem permissao para adicionar atualizacoes.");
                    }

                    break;
                case 5:
                    sair = true;
                    break;
                default:
                    System.out.println("opcao invalida. Tente novamente.");
                    break;
            }

            System.out.println();
        }
    }

    private static void exibirMenuu() {
        
        System.out.println("===== Menu =====");
        System.out.println("1. Exibir AnUncios");
        System.out.println("2. Adicionar AnUncio");
        System.out.println("3. Editar AnUncio");
        System.out.println("4. Apagar AnUncio");
        System.out.println("5. Sair");
    }

    private static void exibirAnuncios() {
        System.out.println("===== AnUncios =====");
        for (Map.Entry<String, String> entry : anuncios.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    private static void adicionarAnuncio(Scanner scanner) {
        
        System.out.println("===== Adicionar AnUncio =====");

        System.out.print("Chave do AnUncio: ");
        String chave = scanner.nextLine();

        System.out.print("Texto do AnUncio: ");
        String texto = scanner.nextLine();

        anuncios.put(chave, texto);

        System.out.println("AnUncio adicionado com sucesso!");
    }

    private static void editarAnuncio(Scanner scanner) {
        
        System.out.println("===== Editar AnUncio =====");

        System.out.print("Chave do AnUncio: ");
        String chave = scanner.nextLine();

        if (anuncios.containsKey(chave)) {
            System.out.print("Novo Texto do AnUncio: ");
            String novoTexto = scanner.nextLine();

            anuncios.put(chave, novoTexto);

            System.out.println("AnUncio editado com sucesso!");
        } else {
            System.out.println("Chave do anUncio nao encontrada.");
        }
    }

    private static void apagarAnuncio(Scanner scanner) {
        
        System.out.println("===== Apagar AnUncio =====");

        System.out.print("Chave do AnUncio: ");
        String chave = scanner.nextLine();

        if (anuncios.containsKey(chave)) {
            anuncios.remove(chave);

            System.out.println("AnUncio apagado com sucesso!");
        } else {
            System.out.println("Chave do anUncio nao encontrada.");
        }
    }
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    //

    //


private static void Imagens_() {
    
        Map<Integer, Imagem> imagens = new HashMap<>();
        imagens.put(1, new Imagem("Imagem 1", "Sinopse da Imagem 1", 2021, "Editora 1", 19.99));
        imagens.put(2, new Imagem("Imagem 2", "Sinopse da Imagem 2", 2022, "Editora 2", 29.99));

        Scanner imgin = new Scanner(System.in);

        boolean sair = false;

        while (!sair) {
            System.out.println("===== Aplicação de Imagens =====");
            System.out.println("1. Visualizar Imagem");
            System.out.println("2. Adicionar Imagem");
            System.out.println("3. Editar Imagem");
            System.out.println("4. Excluir Imagem");
            System.out.println("0. Sair");

            System.out.print("Escolha uma opção: ");
            int opcao = imgin.nextInt();
            imgin.nextLine(); // Consumir a quebra de linha

            switch (opcao) {
                case 1:
                    visualizarImagem(imgin, imagens);
                    break;
                case 2:
                if (admin1 == true || forn1 == true ) {
                    adicionarImagem(imgin, imagens);
                } else {
                    System.out.println("Voce nao tem permissao para isso.");
                }
                    
                    break;
                case 3:
                if (admin1 == true || forn1 == true ) {
                    editarImagem(imgin, imagens);
                } else {
                    System.out.println("Voce nao tem permissao para isso.");
                }
                    
                    break;
                case 4:
                if (admin1 == true || forn1 == true ) {
                    excluirImagem(imgin, imagens);
                } else {
                    System.out.println("Voce nao tem permissao para isso.");
                }
                    
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

    private static void visualizarImagem(Scanner scanner, Map<Integer, Imagem> imagens) {
        
        System.out.println("===== Visualizar Imagem =====");
        exibirMenuImagens(imagens);

        System.out.print("Escolha o número da imagem: ");
        int numeroImagem = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha

        if (imagens.containsKey(numeroImagem)) {
            Imagem imagem = imagens.get(numeroImagem);
            exibirDetalhesImagem(imagem);
        } else {
            System.out.println("Imagem não encontrada.");
        }
    }

    private static void adicionarImagem(Scanner scanner, Map<Integer, Imagem> imagens) {
        
        System.out.println("===== Adicionar Imagem =====");
        System.out.print("Digite o título: ");
        String titulo = scanner.nextLine();

        System.out.print("Digite a sinopse: ");
        String sinopse = scanner.nextLine();

        System.out.print("Digite o ano de lançamento: ");
        int anoLancamento = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha

        System.out.print("Digite a editora: ");
        String editora = scanner.nextLine();

        System.out.print("Digite o preço: ");
        double preco = scanner.nextDouble();
        scanner.nextLine(); // Consumir a quebra de linha

        int novoNumeroImagem = imagens.size() + 1;
        Imagem novaImagem = new Imagem(titulo, sinopse, anoLancamento, editora, preco);
        imagens.put(novoNumeroImagem, novaImagem);

        System.out.println("Imagem adicionada com sucesso. Número da imagem: " + novoNumeroImagem);
    }

    private static void editarImagem(Scanner scanner, Map<Integer, Imagem> imagens) {
        
        System.out.println("===== Editar Imagem =====");
        exibirMenuImagens(imagens);

        System.out.print("Escolha o número da imagem: ");
        int numeroImagem = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha

        if (imagens.containsKey(numeroImagem)) {
            Imagem imagem = imagens.get(numeroImagem);
            exibirDetalhesImagem(imagem);

            System.out.print("Digite o novo título: ");
            String novoTitulo = scanner.nextLine();

            System.out.print("Digite a nova sinopse: ");
            String novaSinopse = scanner.nextLine();

            System.out.print("Digite o novo ano de lançamento: ");
            int novoAnoLancamento = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            System.out.print("Digite a nova editora: ");
            String novaEditora = scanner.nextLine();

            System.out.print("Digite o novo preço: ");
            double novoPreco = scanner.nextDouble();
            scanner.nextLine(); // Consumir a quebra de linha

            imagem.setTitulo(novoTitulo);
            imagem.setSinopse(novaSinopse);
            imagem.setAnoLancamento(novoAnoLancamento);
            imagem.setEditora(novaEditora);
            imagem.setPreco(novoPreco);

            System.out.println("Imagem editada com sucesso.");
        } else {
            System.out.println("Imagem não encontrada.");
        }
    }

    private static void excluirImagem(Scanner scanner, Map<Integer, Imagem> imagens) {
        
        System.out.println("===== Excluir Imagem =====");
        exibirMenuImagens(imagens);

        System.out.print("Escolha o número da imagem: ");
        int numeroImagem = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha

        if (imagens.containsKey(numeroImagem)) {
            Imagem imagem = imagens.get(numeroImagem);
            exibirDetalhesImagem(imagem);

            System.out.print("Deseja realmente excluir esta imagem? (S/N): ");
            String confirmacao = scanner.nextLine();

            if (confirmacao.equalsIgnoreCase("S")) {
                imagens.remove(numeroImagem);
                System.out.println("Imagem excluída com sucesso.");
            } else {
                System.out.println("Exclusão cancelada.");
            }
        } else {
            System.out.println("Imagem não encontrada.");
        }
    }

    private static void exibirMenuImagens(Map<Integer, Imagem> imagens) {
        
        System.out.println("===== Lista de Imagens =====");
        for (Map.Entry<Integer, Imagem> entry : imagens.entrySet()) {
            int numeroImagem = entry.getKey();
            Imagem imagem = entry.getValue();
            System.out.println(numeroImagem + ". " + imagem.getTitulo());
        }
    }

    private static void exibirDetalhesImagem(Imagem imagem) {
        
        System.out.println("===== Detalhes da Imagem =====");
        System.out.println("Título: " + imagem.getTitulo());
        System.out.println("Sinopse: " + imagem.getSinopse());
        System.out.println("Ano de Lançamento: " + imagem.getAnoLancamento());
        System.out.println("Editora: " + imagem.getEditora());
        System.out.println("Preço: R$" + imagem.getPreco());
        System.out.println("Avaliação: " + imagem.getAvaliacao());
        System.out.println("Comentário: " + imagem.getComentario());

        Scanner im_ = new Scanner(System.in);

        System.out.print("Digite uma avaliação (0-5): ");
        double avaliacao = im_.nextDouble();
        im_.nextLine(); // Consumir a quebra de linha

        System.out.print("Digite um comentário: ");
        String comentario = im_.nextLine();

        imagem.setAvaliacao(avaliacao);
        imagem.setComentario(comentario);

        System.out.println("Avaliação e comentário registrados com sucesso!");
    }


//
//

    private static void exibirOpcoes_() {
        System.out.println("== Opção: Opções ==");
        Scanner nami = new Scanner(System.in);

        while (true) {
            exibirMenuOpcoes();

            int opcuao = nami.nextInt();
            nami.nextLine(); // Limpar o buffer de entrada

            switch (opcuao) {
                case 1:
                    alterarNome(nami);
                    break;
                case 2:
                    alterarEmail(nami);
                    break;
                case 3:
                    alterarTelefone(nami);
                    break;
                case 4:
                    excluirConta(nami);
                    return;
                case 5:
                    alterarSenha(nami);
                    System.out.println("Pressione Enter para continuar...");
                    nami.nextLine();
                    break;

                    case 6:
                    exibirDadosUsuario();
                    System.out.println("Pressione Enter para continuar...");
                    nami.nextLine();
                    break;    
                case 0:
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }

    private static void exibirMenuOpcoes() {
        
        System.out.println("========== Opções ==========");
        System.out.println("1. Alterar nome");
        System.out.println("2. Alterar e-mail");
        System.out.println("3. Alterar telefone");
        System.out.println("4. Excluir conta");
        System.out.println("5. Alterar Senha");
        System.out.println("6. Mostrar dados");
        System.out.println("0. Voltar");
        System.out.print("Selecione uma opção: ");
    }

    private static void alterarNome(Scanner nami) {
        System.out.println("== Opção: Alterar nome ==");
        System.out.print("Digite o novo nome: ");
        String novoNome = nami.nextLine();
        System.out.println("Nome alterado com sucesso para: " + novoNome);

        nomeCompleto = novoNome;
    }

    private static void alterarEmail(Scanner nami) {
        System.out.println("== Opção: Alterar e-mail ==");

        System.out.print("Digite o novo e-mail: ");
        String novoEmail = nami.nextLine();
        System.out.println("E-mail alterado com sucesso para: " + novoEmail);
        email = novoEmail;
        
    }

    private static void alterarTelefone(Scanner nami) {
        System.out.println("== Opção: Alterar telefone ==");

        System.out.print("Digite o novo telefone: ");
        String novoTelefone = nami.nextLine();
        System.out.println("Telefone alterado com sucesso para: " + novoTelefone);
        telefone = novoTelefone;

    }

    private static void alterarSenha(Scanner nami){
        System.out.println("== Opção: Alterar Senha ==");

        System.out.print("Digite a nova Senha: ");
        String novoSenha = nami.nextLine();
        System.out.println("Senha alterado com sucesso para: " + novoSenha);
        senha = novoSenha;
        credenciais.put(usuarioLogado,novoSenha);
    }

    private static void excluirConta(Scanner nami) {
        System.out.println("== Opção: Excluir conta ==");

        System.out.print("Tem certeza que deseja excluir sua conta? (S/N): ");
        String resposta = nami.nextLine();

        if (resposta.equalsIgnoreCase("S")) {
            credenciais.remove(usuarioLogado);
            System.out.println("Conta excluída com sucesso. Obrigado por usar nosso sistema!");
            usuarioLogado = null;
            nomeCompleto = null;
            assinaturaAtiva = false;
        }
    }

    private static void exibirDadosUsuario() {
        System.out.println("== Opção: Mostrar dados ==");
        System.out.println("Dados do usuário:");
        System.out.println("Nome completo: " + nomeCompleto);
        System.out.println("Usuário: " + usuarioLogado);
        System.out.println("e-mail: " + email);
        System.out.println("Telefone: " + telefone);
        System.out.println("Senha: " + senha);
        
    }
}
