import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexao {
    String url = "jdbc:postgresql://localhost:5432/db_user"; // URL do banco de dados
    String usuario = "root"; // Usuário do banco de dados
    String senha = "root"; // Senha do banco de dados

    try (Connection conexao = DriverManager.getConnection(url, usuario, senha)) {
        if (conexao != null) {
            System.out.println("Conexão bem-sucedida!");
        } else {
            System.out.println("Falha na conexão.");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
