package org.dea.packlaborategia4;

import java.util.*;

public class Probak {

	private static Probak nireProbak = null;
	
	private Probak(){
	}
	
	public static Probak getNireProbak(){
		if(nireProbak==null){
			nireProbak = new Probak();
		}
		return nireProbak;
	}
	
	public void probak(){
		
		//FITXATEGIA KARGATU
		System.out.println("PROBAK");
		System.out.println();
		System.out.println("–-––--------------------------------------------");
		System.out.println("FITXATEGIA KARGATU:");
		
		long startTime = System.nanoTime();
		
		Teklatua.getTeklatua().listaKargatu();
		System.out.println("FITXATEGIA KARGATU EGIN DA!");
		System.out.println();
		
		long endTime = System.nanoTime();
		long duration = (endTime - startTime);
		System.out.println("Ejekuzio denbora " + duration/1000000000+"seg");
		System.out.println("–-––--------------------------------------------");
		
		System.out.println();
		System.out.println();
		
		//PROBAK GRAPH1
		System.out.println("Probak Graph1-ekin:");
			//LEHENENGO PROBA
			System.out.println("–-––--------------------------------------------");
			System.out.println("LEHENENGO PROBA");
			System.out.println("Grafoa sortu:");
			System.out.println();
			
			startTime = System.nanoTime();
			
			Graph1.getGraph1(Teklatua.getTeklatua().getListaAktorea());

			endTime = System.nanoTime();
			duration = (endTime - startTime);
			System.out.println("Ejekuzio denbora " + duration/1000000000+"seg");
			System.out.println("–-––--------------------------------------------");
	}
	
}
