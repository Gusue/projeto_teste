import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conectar {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // Configuração da conexão
            String url = "jdbc:mysql://localhost:3306/principal";
            String username = "root";
            String password = "gusue";

            // Estabelece a conexão
            connection = DriverManager.getConnection(url, username, password);

            // Cria um Statement
            statement = connection.createStatement();

            // Executa uma consulta de teste
            String sql = "SELECT 1";
            resultSet = statement.executeQuery(sql);

            // Verifica se há resultados
            if (resultSet.next()) {
                int result = resultSet.getInt(1);
                System.out.println("Conexão bem-sucedida! Resultado: " + result);
            }

        } catch (SQLException e) {
            // Trate quaisquer erros de conexão aqui
            e.printStackTrace();
        } finally {
            // Certifique-se de fechar a conexão, o Statement e o ResultSet quando terminar de usá-los
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
