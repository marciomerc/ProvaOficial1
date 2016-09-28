package teste.random;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import domain.Pessoa;

public class TestaRandom {
	public static void main(String[] args) {
		String[] nomes = {"Miguel ","Davi ", "Arthur "};  
		String[]  sobrenomes ={" Souza"," Silva"," Naumann"};
		int nrAleatorio;
		int	nrAleatorio2;
		Random ramdom = new Random(50);
		
		
		for(int i = 0; i < 10; i++){
			//escolhe uma posição de 0 a 6
			nrAleatorio = 0 + ramdom.nextInt(3);
			nrAleatorio2 = 0 + ramdom.nextInt(3);
			//imprime um resultado aleatório
			System.out.print( i + "[" + nomes[nrAleatorio]+ ","  + sobrenomes[nrAleatorio2] + "]\n ");
		}
	}
	
	
}