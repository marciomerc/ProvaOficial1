package data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import data.util.Conexao;
import domain.Pessoa;
import domain.Persistible;

public class ProvaDAO implements Persistible<Pessoa> {

	private Connection connection;
	private Conexao conexao;

	public ProvaDAO(Conexao conexao) {
		this.conexao = conexao;
		connection = conexao.abrir();
	}

	@Override
	public void save(Pessoa pessoa) {
		// introdução sql
		String sql = "Insert into pessoasem100 (nome, sobrenome)" + "values(?,?)";
		String sql2 = "Insert into pessoacom100 (nome, sobrenome)" + "values(?,?)";
		PreparedStatement pstmt;
		PreparedStatement pstmt2;
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt2 = connection.prepareStatement(sql2);
			// setar os parametros
			pstmt.setString(1, pessoa.getNome());
			pstmt.setString(2, pessoa.getSobrenome());
			pstmt2.setString(1, pessoa.getNome());
			pstmt2.setString(2, pessoa.getSobrenome());
			pstmt.execute();
			pstmt2.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public Pessoa getOne(long id) {
		Pessoa p = null;
		Statement sta;
		try {
			sta = connection.createStatement();
			ResultSet elements = sta.executeQuery("Select * from pessoacom100" + " where id = " + id);

			while (elements.next()) {
				p = new Pessoa(elements.getLong("id"), elements.getString("nome"), elements.getString("sobrenome"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			conexao.fechar();
		}
		return p;

	}

	public List<Pessoa> selectcomindex(String nome) {
		List<Pessoa> result = new ArrayList<Pessoa>();
		Pessoa p = null;
		Statement stmt;
		try {
			stmt = connection.createStatement();
			
			// atribui o resultado da consulta para o resultset
			ResultSet res = stmt.executeQuery("SELECT * FROM pessoacom100 USE INDEX (Indice_pessoacom100) WHERE nome = " + "\"" + nome + "\"");
			
			// enquanto existirem registros no recordset
			while (res.next()) {
				p = new Pessoa(res.getLong("id"), res.getString("nome"), res.getString("sobrenome"));
				
				//adiciona o objeto ao veto
				result.add(p);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			conexao.fechar();
		}
		return result;
	}

	public List<Pessoa> selectsemindex(String nome) {
		List<Pessoa> lista = new ArrayList<Pessoa>();
		Pessoa p = null;
		Statement stmt;
		try {
			stmt = connection.createStatement();
			// atribui o resultado da consulta para o resultset
			ResultSet res = stmt.executeQuery("SELECT * FROM pessoasem100  WHERE nome = " + "\"" + nome + "\"");
			// enquanto existirem registros no recordset
			while (res.next()) {
			 p = new Pessoa(res.getLong("id"), res.getString("nome"), res.getString("sobrenome"));

				// adiciona o objeto ao veto
				lista.add(p);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			conexao.fechar();
		}
		return lista;
	}

	@Override
	public List<Pessoa> getAll() {
		List<Pessoa> result = new ArrayList<Pessoa>();
		Pessoa p = null;
		Statement sta;
		try {
			sta = connection.createStatement();
			// atribui o resultado da consulta para o resultset
			ResultSet elements = sta.executeQuery("Select * from pessoacom100");

			// enquanto existirem registros no recordset
			while (elements.next()) {
				Pessoa l = new Pessoa();
				l.setId(elements.getInt("id"));
				l.setNome(elements.getString("nome"));
				l.setSobrenome(elements.getString("sobrenome"));

				// adiciona o objeto ao veto
				result.add(l);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			conexao.fechar();
		}
		return result;

	}

	@Override
	public void delete(Pessoa pessoa) {
		String sql = "delete from pessoacom100 where id = ?";
		PreparedStatement pstmt;

		try {
			pstmt = connection.prepareStatement(sql);
			// setar os parametros
			pstmt.setLong(1, pessoa.getId());
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			conexao.fechar();
		}

	}

	@Override
	public void update(Pessoa pessoa) {
		try {
			String sql = "update pessoacom100 set nome = ?,sobrenome = ?  where id = ? ";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, pessoa.getNome());
			pstmt.setString(2, pessoa.getSobrenome());
			pstmt.setLong(3, pessoa.getId());
			pstmt.execute();
		} catch (SQLException ex) {
			ex.printStackTrace();

		}

	}

	public void gerar() {
		String[] nomes = { "Miguel ", "Davi ", "Arthur ", "Pedro ", "Gabriel ", "Bernardo ", "Lucas ", "Matheus ",
				"Heitor ", "Rafael ", "Enzo ", "Guilherme ", "Nicolas ", "Lorenzo ", "Gustavo ", "Felipe ", "Samuel ",
				"João Pedro ", "Daniel ", "Vitor ", "Leonardo ", "Henrique ", "Theo ", "Murilo ", "Eduardo ", "Sophia ",
				"Alice ", "Julia ", "Isabella ", "Manuela ", "Laura ", "Luiza ", "Valentina ", "Giovanna ",
				"Maria Eduarda ", "Helena ", "Beatriz ", "Maria Luiza ", "Lara ", "Mariana ", "Nicole ", "Rafaela ",
				"Heloísa ", "Isadora ", "Lívia ", "Maria Clara ", "Ana Clara ", "Lorena ", "Gabriela ", "Yasmin " };
		String[] sobrenomes = { " Alves", " Monteiro", " Novaes", " Mendes", " Barros", " Freitas", " Barbosa",
				" Pinto", " Moura", " Cavalcanti", " Dias", " Castro", " Campos", " Cardoso", " Silva", " Souza",
				" Costa", " Santos", " Oliveira", " Pereira", " Rodrigues", " Almeida", " Nascimento", " Lima",
				" Araújo", " Fernandes", " Carvalho", " Gomes", " Martins", " Rocha", " Ribeiro", " Rezende", " Sales",
				" Peixoto", " Fogaça", " Porto", " Ribeiro", " Duarte", " Moraes", " Ramos", " Pereira", " Ferreira",
				" Silveira", " Moreira", " Teixeira", " Caldeira", " Vieira", " Nogueira", " da Rocha", " da Rocha" };
		int nrAleatorio;
		int nrAleatorio2;

		Random ramdom = new Random(100000);

		conexao.abrir();
		ProvaDAO pdao = new ProvaDAO(conexao);
		// faz o trabalho a ser medido

		for (int i = 0; i < 100000; i++) {
			// escolhe uma posição de 0 a 6
			nrAleatorio = 0 + ramdom.nextInt(50);
			nrAleatorio2 = 0 + ramdom.nextInt(50);
			// imprime um resultado aleatório
			//System.out.print(i + "[" + nomes[nrAleatorio] + "," + sobrenomes[nrAleatorio2] + "]\n ");
			Pessoa pessoa = new Pessoa(nomes[nrAleatorio], sobrenomes[nrAleatorio2]);
			pdao.save(pessoa);
		}

	}
}
