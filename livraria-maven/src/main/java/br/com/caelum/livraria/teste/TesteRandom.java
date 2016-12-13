package br.com.caelum.livraria.teste;

import java.util.Random;

public class TesteRandom {

	public static void main(String[] args) {
		long millis = System.currentTimeMillis();
		Random gerador = new Random(millis);
		
		int resultado1 = gerador.nextInt(10);
		System.out.println(resultado1);
		
		int resultado2 = gerador.nextInt(10);
		System.out.println(resultado2);
	}

}
