package domain;

import java.io.Serializable;

public class Pessoa implements Serializable{
	
	
			private long id;
		private String nome;
		private String sobrenome;
		
		public  Pessoa(){}

		public Pessoa(String nome) {
			super();
			this.nome = nome;
		}

		public long getId() {
			return id;
		}


		public void setId(long id) {
			this.id = id;
		}


		public String getNome() {
			return nome;
		}


		public void setNome(String nome) {
			this.nome = nome;
		}


		public String getSobrenome() {
			return sobrenome;
		}


		public Pessoa(long id, String nome, String sobrenome) {
			super();
			this.id = id;
			this.nome = nome;
			this.sobrenome = sobrenome;
		}


		public void setSobrenome(String sobrenome) {
			this.sobrenome = sobrenome;
		}


		@Override
		public String toString() {
			return "Pessoa [id=" + id + ", nome=" + nome + ", sobrenome=" + sobrenome + "]";
		}


		public Pessoa(String nome, String sobrenome) {
			super();
			this.nome = nome;
			this.sobrenome = sobrenome;
		}

		
	

	
	}

