package org.dea.packlaborategi3;

import java.util.*;

public class Pelikula {
	
	private String izenburua;
	private ArrayList<Aktore> listaA;
	
	public Pelikula(String pIzenburua){
		izenburua = pIzenburua;
		listaA = new ArrayList<Aktore>();
	}
	
	public String getIzenburua(){
		return izenburua;
	}
	
	public ArrayList<Aktore> getListaAktore(){
		return listaA;
	}
	
	public void geituAktore(Aktore pAktor){
		listaA.add(pAktor);
	}
}
