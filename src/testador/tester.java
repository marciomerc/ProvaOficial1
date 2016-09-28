package testador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.sql.Connection;

import data.dao.ProvaDAO;
import data.util.Conexao;
import domain.Pessoa;

public class tester {

	public static void main(String[] args) {
		Conexao conexao = new Conexao();
		ProvaDAO pdao = new ProvaDAO(conexao);
		Pessoa p = new Pessoa();
		conexao.abrir();
		
		System.out.println("começou");
		long comecou = System.currentTimeMillis();
		// faz o trabalho a ser medido
		pdao.selectcomindex("Sophia");
		long terminou = System.currentTimeMillis() - comecou;
		System.out.println("duração com index é de:" + terminou + "milisegundos. Ou :"+ terminou/1000+"segundos");
		System.out.println("terminou");
		
		long comecou2 = System.currentTimeMillis();
		// faz o trabalho a ser medido
		pdao.selectsemindex("Sophia");
		long terminou2 = System.currentTimeMillis() - comecou2;
		System.out.println("duração sem index é de:" + terminou2 + "milisegundos. Ou :"+ terminou2/1000+"segundos");
		System.out.println("terminou");
		
		//GERAR E INSERIR OS REGISTRO.
		/*long comecou3 = System.currentTimeMillis();
		pdao.gerar();
		long terminou3 = System.currentTimeMillis() - comecou3;
		System.out.println("duração sem index é de:" + terminou3 + "milisegundos. Ou :"+ terminou3/1000+"segundos");*/
		
		//passo 2 
		// como deletar um registro;
		// p.setId(2);
		// pdao.delete(p);
		
		//passo 3;
		//para listar todos os registros
		//System.out.println(pdao.getAll());
		
		//passo 4
		//para pegar apenas um registro.
		
		//System.out.println(pdao.getOne(94531));
		
		//passo 5
		//obs: quando for fazer update usar // no Pessoa p = new Pessoa(); que se encontra la no
		//começo e liebrar esse aki
		//para o metodo update nao gerar acusar erro.
		//Pessoa p = new Pessoa("jaque","gatinha");
		//p.setId(1);
		//pdao.update(p);

		conexao.fechar();
		
		// System.out.println(ldao.getAll());

	}

}
