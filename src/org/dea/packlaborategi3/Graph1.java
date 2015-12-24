package org.dea.packlaborategi3;

import java.util.*;

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
	
	
	private double distantzia(int e, String a1, String a2){
		double dBB = 0;
		for(int x=0; x < e; x++){
			double d=0;
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
	        		d++;
	        		ArrayList<String> listaBerria = g.get(aztertzeko);
	        		for(String b : listaBerria){
	        			if(!aztertuak.containsKey(b)){
	        			aztertuGabeak.add(b);
	                	aztertuak.put(b, true);
	        			}
	        		}      
	        	}
	        }
	        dBB = d/2;
		}
		return dBB/e;
	}
	
	private String randomAtera(ArrayList<String> pIK){
		Random random = new Random();
		String a1 = pIK.get(random.nextInt(g.size()));
		return a1;
	}
	
	public void erlazioenGradua(){
		ArrayList<String> izenKeys = new ArrayList<String>(g.keySet());
		double error=1000;
		int probak = 10;
		String a1 = randomAtera(izenKeys);
		String a2 = randomAtera(izenKeys);
		double aurrekoa = distantzia(probak,a1,a2);
		double d = 0;
		while(error>1){
			a1 = randomAtera(izenKeys);
			a2 = randomAtera(izenKeys);
			d = distantzia(probak,a1,a2);
			probak=probak*2;
			error = d - aurrekoa;
			aurrekoa = d;
		}
		System.out.println(error + "-eko errorearekin lortutako erlazio gradua " + (aurrekoa+d)/2 + " da.");
	}
	
	public double zentralitatea(String i1, String i2){
		double zentralitate=0;
		
		
		
		return zentralitate;
	}
}
