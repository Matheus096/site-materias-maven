package ifgoiano.edu.br.repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ifgoiano.edu.br.entidades.Materias;
import ifgoiano.edu.br.entidades.Usuario;
import ifgoiano.edu.br.exceptions.DataBaseException;

public class Repositorio {
	
	public void inserir(Usuario usuario) throws DataBaseException {
		String sql = "INSERT INTO USUARIOS (NOME, EMAIL, SENHA, DATA, ID) VALUES (?, ?, ?, ?, ?)";
		Connection conn = FabricaDeConexao.getConnection();
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, usuario.getNome());
			psmt.setString(2, usuario.getEmail());
			psmt.setString(3, usuario.getSenha());
			psmt.setString(4, usuario.getData());
			psmt.setInt(5, usuario.getId());
			psmt.execute();
			psmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void inserirMateria(Materias materia) throws DataBaseException {
		String sql = "INSERT INTO MATERIAS (TITULO, DESCRICAO, ID, USUARIO_ID, CONCLUIDO) VALUES (?, ?, ?, ?, ?)";
		Connection conn = FabricaDeConexao.getConnection();
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, materia.getTitulo());
			psmt.setString(2, materia.getDescricao());
			psmt.setInt(3, materia.getId());
			psmt.setInt(4, materia.getUsuario_id());
			psmt.setBoolean(5, materia.getConcluido());
			psmt.execute();
			psmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void atualizar(Usuario usuario) throws DataBaseException {
		String sql = "UPDATE USUARIOS SET EMAIL = ?, SENHA = ? WHERE NOME = ?";
		Connection conn = FabricaDeConexao.getConnection();
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, usuario.getEmail());
			psmt.setString(2, usuario.getSenha());
			psmt.setString(3, usuario.getNome());
			psmt.execute();
			psmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//Edita matéria por titulo
	public void editarMateria(Materias materia) throws DataBaseException {
		String sql = "UPDATE MATERIAS SET DESCRICAO = ? WHERE TITULO = ?";
		Connection conn = FabricaDeConexao.getConnection();
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, materia.getDescricao());
			psmt.setString(2, materia.getTitulo());
			psmt.execute();
			psmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//Edita matéria por id
	public void editarMateriaID(Materias materia) throws DataBaseException {
		String sql = "UPDATE MATERIAS SET DESCRICAO = ?, TITULO = ? WHERE ID = ?";
		Connection conn = FabricaDeConexao.getConnection();
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, materia.getDescricao());
			psmt.setString(2, materia.getTitulo());
			psmt.setInt(3, materia.getId());
			psmt.execute();
			psmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deletar(String nome) throws DataBaseException {
		String sql = "DELETE FROM USUARIOS WHERE NOME = ?";
		Connection conn = FabricaDeConexao.getConnection();
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, nome);
			psmt.execute();
			psmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deletarMateria(String titulo) throws DataBaseException {
		String sql = "DELETE FROM MATERIAS WHERE TITULO = ?";
		Connection conn = FabricaDeConexao.getConnection();
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, titulo);
			psmt.execute();
			psmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Usuario pegarUsuario(String email, String senha) throws DataBaseException {
		String sql = "SELECT * FROM USUARIOS WHERE EMAIL = ? AND SENHA = ?";
		Usuario usuario = null;
		Connection conn = FabricaDeConexao.getConnection();
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, email);
			psmt.setString(2, senha);
			ResultSet result = psmt.executeQuery();
			while(result.next()) {
				usuario = new Usuario();
				usuario.setNome(result.getString("NOME"));
				usuario.setEmail(result.getString("EMAIL"));
				usuario.setSenha(result.getString("SENHA"));
				usuario.setData(result.getString("DATA"));
			}
			result.close();
			psmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuario;
	}
	
	//pega ususario por nome
	public Usuario pegarPorNome(String nome) throws DataBaseException {
		String sql = "SELECT * FROM USUARIOS WHERE NOME = ?";
		Usuario usuario = null;
		Connection conn = FabricaDeConexao.getConnection();
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, nome);
			ResultSet result = psmt.executeQuery();
			while(result.next()) {
				usuario = new Usuario();
				usuario.setNome(result.getString("NOME"));
				usuario.setEmail(result.getString("EMAIL"));
				usuario.setSenha(result.getString("SENHA"));
				usuario.setData(result.getString("DATA"));
			}
			result.close();
			psmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuario;
	}
	
	//Pega materia por titulo
	public Materias pegarPorTitulo(String titulo) throws DataBaseException {
		String sql = "SELECT * FROM MATERIAS WHERE TITULO = ?";
		Materias materia = null;
		Connection conn = FabricaDeConexao.getConnection();
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, titulo);
			ResultSet result = psmt.executeQuery();
			while(result.next()) {
				materia = new Materias();
				materia.setTitulo(result.getString("titulo"));
				materia.setDescricao(result.getString("descricao"));
			}
			result.close();
			psmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return materia;
	}
	
	//Pega materia por id
	public Materias pegarPorID(Integer id) throws DataBaseException {
		String sql = "SELECT * FROM MATERIAS WHERE ID = ?";
		Materias materia = null;
		Connection conn = FabricaDeConexao.getConnection();
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setInt(1, id);
			ResultSet result = psmt.executeQuery();
			while(result.next()) {
				materia = new Materias();
				materia.setTitulo(result.getString("titulo"));
				materia.setDescricao(result.getString("descricao"));
			}
			result.close();
			psmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return materia;
	}
	
	public List<Usuario> pegarTodos() throws DataBaseException{
		String sql = "SELECT * FROM USUARIOS";
		List<Usuario> usuarios = new ArrayList<Usuario>();
		Connection conn = FabricaDeConexao.getConnection();
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			ResultSet result = psmt.executeQuery();
			while(result.next()) {
				Usuario usuario = new Usuario();
				usuario.setNome(result.getString("NOME"));
				usuario.setEmail(result.getString("EMAIL"));
				usuario.setSenha(result.getString("SENHA"));
				usuario.setData(result.getString("DATA"));
				usuarios.add(usuario);
			}
			result.close();
			psmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuarios;
	}
	
	public List<Materias> pegarTodasMaterias() throws DataBaseException{
		String sql = "SELECT * FROM MATERIAS";
		List<Materias> lista_materias = new ArrayList<Materias>();
		Connection conn = FabricaDeConexao.getConnection();
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			ResultSet result = psmt.executeQuery();
			while(result.next()) {
				Materias materias = new Materias();
				materias.setTitulo(result.getString("TITULO"));
				materias.setDescricao(result.getString("DESCRICAO"));
				materias.setId(result.getInt("ID"));
				materias.setUsuario_id(result.getInt("USUARIO_ID"));
				materias.setConcluido(result.getBoolean("CONCLUIDO"));
				lista_materias.add(materias);
			}
			result.close();
			psmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista_materias;
	}
	
	public Integer pegarNovoId(String nomeTabela) throws DataBaseException {
		
		String sql = "SELECT ID FROM " + nomeTabela + " ORDER BY ID"; // => SELECT ID FROM MATERIAS/USUARIOS ORDER BY ID
		
		List<Integer> id = new ArrayList<Integer>();
		
		try(Connection conn = FabricaDeConexao.getConnection();
			PreparedStatement psmt = conn.prepareStatement(sql);){
			
			ResultSet result = psmt.executeQuery();
			while(result.next()) {
				id.add(result.getInt("ID"));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		if(id.size() == 0) {
			return 1;
		}
		
		return (id.get(id.size() - 1 ) ) + 1;
	}
	
	public Integer pegarIdUsuario(String email) throws DataBaseException {
		String sql = "SELECT ID FROM USUARIOS WHERE EMAIL = ?";
		int id = 0;
		try(Connection conn = FabricaDeConexao.getConnection();
			PreparedStatement psmt = conn.prepareStatement(sql);){
			
			psmt.setString(1, email);
			
			ResultSet result = psmt.executeQuery();
			while(result.next()) {
				id = result.getInt("ID");
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return id;
	}
	
	public List<Materias> pegarMPorUsuario(int id) throws DataBaseException{
		String sql = "SELECT * FROM MATERIAS WHERE USUARIO_ID = ?";
		List<Materias> lista_materias = new ArrayList<Materias>();
		Connection conn = FabricaDeConexao.getConnection();
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			
			psmt.setInt(1, id);
			
			ResultSet result = psmt.executeQuery();
			while(result.next()) {
				Materias materias = new Materias();
				materias.setTitulo(result.getString("TITULO"));
				materias.setDescricao(result.getString("DESCRICAO"));
				materias.setId(result.getInt("ID"));
				materias.setUsuario_id(result.getInt("USUARIO_ID"));
				materias.setConcluido(result.getBoolean("CONCLUIDO"));
				
				lista_materias.add(materias);
			}
			
			result.close();
			psmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lista_materias;
	}
}
