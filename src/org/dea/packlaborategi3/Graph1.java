package org.dea.packlaborategi3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Graph1 {

	HashMap<String, ArrayList<String>> g;
	static Graph1 nireGraph1 = null;
	
	private Graph1(ArrayList<Aktore> lA){
		g = new HashMap<String, ArrayList<String>>();
		grafoaSortu(lA);
	}
	
	public static synchronized Graph1 getGraph1(ArrayList<Aktore> lA){
		if(nireGraph1==null){
			nireGraph1 = new Graph1(lA);
		}
		return nireGraph1;
	}
	

	public void grafoaSortu(ArrayList<Aktore> lAktoreak){
	// Post: aktoreen zerrendatik grafoa sortzen du
	//       Adabegiak aktoreen izenak eta pelikulen izenburuak dira 
        
            for(Aktore a: lAktoreak){
            	ArrayList<String> stringListaPeli = new ArrayList<String>();
            	for(Pelikula p : a.getListaP()){
            		stringListaPeli.add(p.getIzenburua());
            		if(!g.containsKey(p.getIzenburua())){
            			ArrayList<String> stringListaAktore = new ArrayList<String>();
            			for(Aktore a2 : p.getListaAktore()){
            				stringListaAktore.add(a2.getIzena());
            			}
            			g.put(p.getIzenburua(), stringListaAktore);
            		}
            	}
            	
            	g.put(a.getIzena(), stringListaPeli);
            } 	
     
            System.out.println("");
	}
	
	public void print(){
		int i = 1;
		for (String s: g.keySet()){
			System.out.print("Element: " + i++ + " " + s + " --> ");
			for (String k: g.get(s)){
				System.out.print(k + " ### ");
			}
			System.out.println();
		}
	}
	
	public boolean aktoreaBadago(String pIzen1, String pIzen2){
	    boolean badago = false;
	    if(g.containsKey(pIzen1) && g.containsKey(pIzen2)){
	   		badago = true;
	   	}
	   	return badago;
	 }
	
	public boolean konektatuta(String a1, String a2){
		boolean konektatuak = false;
		String aztertzeko;
		Queue<String> aztertuGabeak = new LinkedList<String>();
		HashMap<String, Boolean> aztertuak = new HashMap<String, Boolean>();
		aztertuGabeak.add(a1);
    	aztertuak.put(a1, true);
        while(!konektatuak && !aztertuGabeak.isEmpty()){
        	aztertzeko = aztertuGabeak.poll();
        	if(aztertzeko.equals(a2)){
        		konektatuak=true;
        	}
        	else{
        		ArrayList<String> listaBerria = g.get(aztertzeko);
        		for(String b : listaBerria){
        			if(!aztertuak.containsKey(b)){
        			aztertuGabeak.add(b);
                	aztertuak.put(b, true);
        			}
        		}      
        	}
        }
		return konektatuak;
	}
	
	public double erlazioenGradua(String i1, String i2){
		double batazBesteko=0;
		
		
		
		return batazBesteko;
	}
	
	public double zentralitatea(String i1, String i2){
		double zentralitate=0;
		
		
		
		return zentralitate;
	}
}
