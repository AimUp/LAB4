package org.dea.packlaborategia4;

import java.util.*;

public class Aktore {
	
	private String izena;
	private ArrayList<Pelikula> listaP;
	
	public Aktore(String pIzena){
		izena = pIzena;	
		listaP = new ArrayList<Pelikula>();
	}
	
	
	public String getIzena(){
		return izena;
	}
	
	public ArrayList<Pelikula> getListaP(){
		return listaP;
	}
	
	public void gehituPelikula(Pelikula pPeli){
		listaP.add(pPeli);
	}
}
