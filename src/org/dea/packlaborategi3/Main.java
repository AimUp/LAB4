package org.dea.packlaborategi3;

public class Main {
	
	public static void main(String[] args){
		System.out.println("Programa honen bidez bi aktore haien artean, nolabai, konektaturik dauden jakin ahalko duzu.");
		System.out.println("Lehenengo eta behin aktoreen datu basea kargatu egingo da.");
		System.out.println();
		Teklatua nireTeklatua;
		nireTeklatua = Teklatua.getTeklatua();
		nireTeklatua.listaKargatu();
		System.out.println();
		System.out.println("DATUAK ONGI KARGATU DIRA.");
		nireTeklatua.menua();
	}
	
}
