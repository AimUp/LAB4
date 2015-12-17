package org.dea.packlaborategi3;

import java.util.*;

public class ListaAktoreak {
	
	private ArrayList<Aktore> listaA;
	
	public ListaAktoreak(){
		listaA = new ArrayList<Aktore>();
	}
	
	public void gehituAktorea(Aktore pAktor){
		listaA.add(pAktor);
	}
	
	public void gehituAktoreaIzenez(String pIzena){
		Aktore geitzekoAktore = new Aktore(pIzena);
		listaA.add(geitzekoAktore);
	}
	
	public void kenduAktorea(String pIzena){
		Aktore a = null;
		a = aktoreaBilatu(pIzena);
		if(a!=null){
			listaA.remove(a);
		}
		else{
			System.out.println("Aktore hau ez dago zerrendan.");
		}
	}
	
	public ArrayList<Aktore> getLista(){
		return listaA;
	}
	
	private Aktore aktoreaBilatu(String pIzena){
		Aktore hunekoAktorea = null;
		boolean bukatu = false;
		Iterator<Aktore> itr = getIteradorea();
		while(itr.hasNext() && !bukatu){
			hunekoAktorea = itr.next();
			if(pIzena.equals(hunekoAktorea.getIzena())){
				bukatu = true;
			}
		}
		if(bukatu == false){
			hunekoAktorea = null;
		}
		return hunekoAktorea;
	}
	
	private Iterator<Aktore> getIteradorea(){
		return listaA.iterator();
	}
}
