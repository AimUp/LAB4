package org.dea.packlaborategi3;

import java.util.*;

public class ListaPelikulak {

	private HashMap<String, Pelikula> hashP;
	
	public ListaPelikulak(){
		hashP = new HashMap<String, Pelikula>();
	}
	
	public boolean contains(String pKey){
		return hashP.containsKey(pKey);
	}
	
	public Pelikula getPeli(String pKey){
		return hashP.get(pKey);
	}
	
	public void addHash(String pKey, Pelikula pPeli){
		hashP.put(pKey, pPeli);
	}
	
	public void pelikulaKendu (String pIzen){
		if(hashP.containsKey(pIzen)){
			hashP.remove(pIzen);
		}
		else{
			System.out.println("Pelikula hau ez dago zerrendan.");
		}
	}
	
}
