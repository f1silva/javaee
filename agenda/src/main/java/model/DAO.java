package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
// TODO: Auto-generated Javadoc

/**
 * The Class DAO.
 */
public class DAO {
	
	/** The driver. */
	// Parametros de conexao
	String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	
	/** The connection url. */
	String connectionUrl = "jdbc:sqlserver://VIRUS-PC;databaseName=agenda;integratedSecurity=true";
	
	/**
	 * Conectar.
	 *
	 * @return the connection
	 */
	// Metodo de Conexao
	Connection conectar() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(connectionUrl);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	/**
	 * Iserir contato.
	 *
	 * @param contato the contato
	 */
	// Crud Create
	public void iserirContato(JavaBeans contato) {
		String inserir = "INSERT INTO contato (nome, telefone, email) VALUES (? ,? ,?)";
		try {
			// Abrir a conexão com o banco
			Connection con = conectar();
			// Preparar a query para execução no banco de dados
			PreparedStatement pst = con.prepareStatement(inserir);
			// Substituir os parametros(?) pelo conteúdo das variáveis
			pst.setString(1, contato.getNome());
			pst.setString(2, contato.getTelefone());
			pst.setString(3, contato.getEmail());
			// Executar a Query
			pst.executeUpdate();
			// Encerra conexão
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	/**
	 * Listar contatos.
	 *
	 * @return the array list
	 */
	// Crud Read
	public ArrayList<JavaBeans> listarContatos() {
		// Criando um objeto para acessar a classe JavaBeans
		ArrayList<JavaBeans> contatos = new ArrayList<>();
		String read = "SELECT * FROM contato order by nome";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			// O laço abaixo será executado enquanto houver contato
			while (rs.next()) {
				// Variáveis de apoio que recebem os dados do banco de dados
				String id = rs.getString(1);
				String nome = rs.getString(2);
				String telefone = rs.getString(3);
				String email = rs.getString(4);
				// Populando o ArrayList
				contatos.add(new JavaBeans(id, nome, telefone, email));
			}
			con.close();
			return contatos;
		} catch (Exception e) {
			System.out.println(e);
			return contatos;
		}

	}

	// Crud update
	/**
	 * Selecionar contato.
	 *
	 * @param contato the contato
	 */
	// Selecionar o contato
	public void selecionarContato(JavaBeans contato) {
		String read2 = "SELECT * FROM contato WHERE id = ?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read2);
			pst.setString(1, contato.getId());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				// Setar as variáveis JavaBeans
				contato.setId(rs.getString(1));
				contato.setNome(rs.getString(2));
				contato.setTelefone(rs.getString(3));
				contato.setEmail(rs.getString(4));
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	/**
	 * Alterar contato.
	 *
	 * @param contato the contato
	 */
	// Editar o contato
	public void alterarContato(JavaBeans contato) {
		String update = "UPDATE contato set nome=?,telefone=?,email=? WHERE id=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(update);
			pst.setString(1, contato.getNome());
			pst.setString(2, contato.getTelefone());
			pst.setString(3, contato.getEmail());
			pst.setString(4, contato.getId());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	/**
	 * Excluir contato.
	 *
	 * @param contato the contato
	 */
	// Crud Delete
	public void excluirContato(JavaBeans contato) {
		String delete = "delete from contato where id=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(delete);
			pst.setString(1, contato.getId());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
