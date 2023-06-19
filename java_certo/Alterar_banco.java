import java.sql.*;

public class Alterar_banco {
    public static void main(String[] args) {
        // Configurações do banco de dados
        String url = "jdbc:mysql://localhost:3306/trabalho";
        String username = "root";
        String password = "gusue";

        // Estabelecendo a conexão com o banco de dados
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            // Criação da tabela (caso ela não exista)
            String createTableQuery = "CREATE TABLE IF NOT EXISTS clientes (id INT AUTO_INCREMENT PRIMARY KEY, nome VARCHAR(100), idade INT)";
            try (Statement statement = connection.createStatement()) {
                statement.executeUpdate(createTableQuery);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            // Inserção de dados na tabela
            String insertQuery = "INSERT INTO clientes (nome, idade) VALUES (?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                preparedStatement.setString(1, "João");
                preparedStatement.setInt(2, 30);
                preparedStatement.executeUpdate();
                System.out.println("Dados inseridos com sucesso.");
            } catch (SQLException e) {
                e.printStackTrace();
            }

            // Consulta de dados na tabela
            String selectQuery = "SELECT * FROM clientes";
            try (Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery(selectQuery);
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String nome = resultSet.getString("nome");
                    int idade = resultSet.getInt("idade");
                    System.out.println("ID: " + id + ", Nome: " + nome + ", Idade: " + idade);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
