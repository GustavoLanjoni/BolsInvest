import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class cadastro {
    public static void main(String[] args) {
        // Conexão com o banco de dados
        try (Connection conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db_user", "root", "root")) {
            // Verificar se o formulário foi submetido corretamente
            // (essa parte precisa ser adaptada para o seu framework de aplicação)
            String nome = "João"; // exemplo
            String sobrenome = "Silva"; // exemplo
            String email = "joao.silva@example.com"; // exemplo
            String celular = "11999999999"; // exemplo
            String senha = "minha_senha"; // exemplo

            // Verificação de senha
            if (senha.length() > 10) {
                System.out.println("Erro: senha deve ter no máximo 10 caracteres");
                return;
            }


            // Inserir dados no banco de dados
            try (PreparedStatement stmt = conexao.prepareStatement("INSERT INTO cadastro (nome, sobrenome, email, celular, senha) VALUES (?, ?, ?, ?, ?)")) {
                stmt.setString(1, nome);
                stmt.setString(2, sobrenome);
                stmt.setString(3, email);
                stmt.setString(4, celular);
                stmt.setString(5, senha);
                stmt.executeUpdate();

                if (stmt.getUpdateCount() > 0) {
                    // Cadastro bem-sucedido, redirecionar para página de destino
                    System.out.println("Cadastro realizado com sucesso!");
                } else {
                    System.out.println("Erro: não foi possível cadastrar o usuário");
                }
            } catch (SQLException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println("Erro: não foi possível conectar ao banco de dados");
        }
    }
}