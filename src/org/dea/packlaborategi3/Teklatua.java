package org.dea.packlaborategi3;

import java.util.*;
import java.io.*;

public class Teklatua {

	private ListaPelikulak listaP;
	private ListaAktoreak listaA;
	private static Teklatua nireTeklatua = null;
	private Scanner sc;
	
	
	private Teklatua(){
		listaA = new ListaAktoreak();
		listaP = new ListaPelikulak();
		sc = new Scanner(System.in);
	}
	
	public static synchronized Teklatua getTeklatua(){
		if(nireTeklatua == null){
			nireTeklatua = new Teklatua();
		}
		return nireTeklatua;
	}
	
	private String fitxategiarenHelbidea(){
		String itzuli;
		System.out.println("Idatzi kargatu nahi den fitxategiaren helbidea:");
		System.out.println("Adibidez: C://Users/XXX/Documents/handia.txt edo /Users/AIMAR/Documents/handia.txt");
		Scanner helbidea = new Scanner(System.in);
		itzuli = helbidea.nextLine();
		return itzuli;	
	}
	
	public void listaKargatu(){
		try{
			Scanner fitxategia = new Scanner(new FileReader(fitxategiarenHelbidea()));
			String linea;
			System.out.println();
			System.out.println();
			System.out.println("Datuak kargatzen diren bitartean itxaron...");
			System.out.println("");
			while(fitxategia.hasNext()){
				linea = fitxategia.nextLine();
				String[] items = linea.split("\\s*###\\s*");
				Aktore nireAktorea = new Aktore(items[0]);
				for(int i=1; i < items.length; i++){
					if(!listaP.contains(items[i])){
						Pelikula nirePelikula = new Pelikula(items[i]);
						listaP.addHash(items[i], nirePelikula);
						nireAktorea.gehituPelikula(nirePelikula);
						nirePelikula.geituAktore(nireAktorea);
					}
					else{
						nireAktorea.gehituPelikula(listaP.getPeli(items[i]));
						listaP.getPeli(items[i]).geituAktore(nireAktorea);;
					}
				}
				listaA.gehituAktorea(nireAktorea);
			}
			fitxategia.close();
			
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	
	private String[] izenakEskatu(int pMetodo){
		String[] izenak = new String[2];
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Bi aktore konektatuta dauden jakiteko bi akotoreren izenak beharko ditugu.");
		System.out.println("Idatzi lehenengo aktorearen izena:");
		
		izenak[0] = sc.nextLine();
				
		System.out.println("Orain zartu bigarren aktorearen izena:");
		
		izenak[1] = sc.nextLine();
		if(pMetodo==1){
			if(!Graph1.getGraph1(listaA.getLista()).aktoreaBadago(izenak[0], izenak[1])){
				System.out.println("Aktoreetako bat gutxienez ez dago datu basean, idatzi izenak berriro:");
				izenak = izenakEskatu(pMetodo);
			}
		}
		else{
			if(!Graph2.getNireGrapfoa(listaA.getLista()).aktoreaBadago(izenak[0], izenak[1])){
				System.out.println("Aktoreetako bat gutxienez ez dago datu basean, idatzi izenak berriro:");
				izenak = izenakEskatu(pMetodo);
			}
		}
		return izenak;
	}
	
	private int zenbakiaSartu(int h, int b){
		int zenb;
		System.out.println("Sartu zenbakia:");
		zenb = sc.nextInt();
		if(h>zenb || b<zenb){
			System.out.println("Zenbaki okerra sartu da. Aukeratu menuko zenbaki bat:");
			zenb = zenbakiaSartu(h,b);
		}
		return zenb;
	}
	
	private void besteEragiketa(){
		String letra = null;
		sc = new Scanner(System.in);
		
		System.out.println();
		System.out.println();
		System.out.println("Beste eragiketarik egin nahi?");
		System.out.println("B-> Bai");
		System.out.println("E-> Ez");
		
		letra = sc.nextLine();
		
		if(letra.equals("B") || letra.equals("b")){
			nireTeklatua.menua();
		}
		else if(letra.equals("E") || letra.equals("e")){
				System.out.println("Programa bukatuko da.");
			}
			else{
				System.out.println("Letra ez egokia, berriro erantzun.");
				besteEragiketa();
			}
	}
	
	
	public void menua(){
		Scanner sc = new Scanner(System.in);
		int menuZenb;
		
		System.out.println("Aukeratu egin nahi duzun eragiketa:");
		System.out.println();
		System.out.println("1-> Bi aktore konektatuta dauden jakin.");
		System.out.println("2-> Grafoa imprimatu.");
		System.out.println("3-> Bi aktoreren erlazio gradua kalkulatu.");
		System.out.println("4-> Aktore baten zentralitatea kalkulatu.");
		
		System.out.println("0-> Irten.");
		menuZenb = zenbakiaSartu(0,4);
		
		if(menuZenb == 1){
			System.out.println("Aukeratu erabili nahi duzun metodoa:");
			System.out.println("(1-> Graph1; 2-> Graph2)");
			int metodoa = zenbakiaSartu(1,2);
			if(metodoa==1){
				Graph1.getGraph1(listaA.getLista());
			}
			else{
				Graph2.getNireGrapfoa(listaA.getLista());
			}
			boolean konektatuak = true;
			String[] izenak = new String[2];
			izenak = izenakEskatu(metodoa);
			if(metodoa==1){
				konektatuak = Graph1.getGraph1(listaA.getLista()).konektatuta(izenak[0], izenak[1]);
			}
			else{
				konektatuak = Graph2.getNireGrapfoa(listaA.getLista()).konektaturikDaude(izenak[0], izenak[1]);
			}
			if(konektatuak){
				System.out.println("AKTOREAK KONEKTATURIK DAUDE!");
			}
			else{
				System.out.println("AKTOREAK EZ DAUDE KONEKTATURIK!");
			}
		}
		
		if(menuZenb == 2){
			System.out.println("Aukeratu inprimitu nahi duzun metodoa:");
			System.out.println("(1-> Graph1; 2-> Graph2)");
			int metodoa = zenbakiaSartu(1,2);
			if(metodoa==1){
				
				Graph1.getGraph1(listaA.getLista()).print();
			}
			else{
				Graph2.getNireGrapfoa(listaA.getLista()).print();;
			}
		}
		
		if(menuZenb == 3){
			System.out.println("Aukeratu erabili nahi duzun metodoa:");
			System.out.println("(1-> Graph1; 2-> Graph2)");
			int metodoa = zenbakiaSartu(1,2);
			
			System.out.println();
			
			System.out.println("Zenbateko errorearearekin topatu nahi duzu erlazioa?");
			System.out.println("(GOMENDIOA: 0,25 edo 0,5)");
			double errorea = sc.nextDouble();
			
			System.out.println();
			System.out.println();
			
			
			if(metodoa==1){
				Graph1.getGraph1(listaA.getLista()).erlazioenGradua(errorea);
			}
			else{
				Graph2.getNireGrapfoa(listaA.getLista()).erlazioenGradua(errorea);
			}
		}
		
		if(menuZenb == 4){
			System.out.println("Aukeratu erabili nahi duzun metodoa:");
			System.out.println("(1-> Graph1; 2-> Graph2)");
			int metodoa = zenbakiaSartu(1,2);
			
			System.out.println();
			System.out.println();
			if(metodoa==1){
				Graph1.getGraph1(listaA.getLista()).zentralitatea();
			}
			else{
				Graph2.getNireGrapfoa(listaA.getLista()).zentralitatea();
			}
		}
		
		besteEragiketa();
		sc.close();
	}
}
