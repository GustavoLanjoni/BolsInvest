import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Usuario {

    public boolean login(String email, String senha) {
        Connection conexao = null;
        PreparedStatement stmt = null;
        ResultSet resultado = null;

        try {
            // Conexão com o banco de dados
            conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_user", "root", "root");

            // Consulta SQL
            String sql = "SELECT * FROM usuario WHERE email = ? AND senha = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.setString(2, senha); // Certifique-se de que a senha foi tratada com hashing ao inserir no banco
            
            // Executa a consulta
            resultado = stmt.executeQuery();

            if (resultado.next()) {
                // Verifique se a senha inserida corresponde ao hash da senha no banco
                // Exemplo de como fazer isso depende da técnica de hashing usada.
                // Por exemplo, se estiver usando bcrypt:
                // String hashedPassword = resultado.getString("senha");
                // if (BCrypt.checkpw(senha, hashedPassword)) { return true; }
                
                // A senha foi validada com sucesso, e o usuário está autenticado
                return true;
            } else {
                return false; // Email ou senha incorretos
            }
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            return false;
        } finally {
            try {
                if (resultado != null) resultado.close();
                if (stmt != null) stmt.close();
                if (conexao != null) conexao.close();
            } catch (SQLException e) {
                System.out.println("Erro ao fechar recursos: " + e.getMessage());
            }
        }
    }
}
