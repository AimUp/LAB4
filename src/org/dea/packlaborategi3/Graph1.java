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
		
		System.out.println("GRAFOA KARGATZEN DAGO. ITXARON MESEDEZ...");
		System.out.println("");
		
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
            System.out.println("Grafoa kargatu egin da.");
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
		ArrayList<String> listaBerria;
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
        		listaBerria = g.get(aztertzeko);
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
	
	
	private double distantzia(String a1, String a2){
		double d=0;
		ArrayList<String> listaBerria;
		boolean konektatuak = false;
		String aztertzeko = null, aurrekoa;
		HashMap<String, String> bidea = new HashMap<String, String>();
		Queue<String> aztertuGabeak = new LinkedList<String>();
		HashMap<String, Boolean> aztertuak = new HashMap<String, Boolean>();
		aztertuGabeak.add(a1);
    	aztertuak.put(a1, true);
        while(!konektatuak && !aztertuGabeak.isEmpty()){
	    	aurrekoa = aztertzeko;
        	aztertzeko = aztertuGabeak.poll();
	       	if(aztertzeko.equals(a2)){
	       		konektatuak=true;
	       		bidea.put(aztertzeko, aurrekoa);
	       	}
	       	else{
	       		listaBerria = g.get(aztertzeko);
	       		for(String b : listaBerria){
	       			if(!aztertuak.containsKey(b)){
	       			bidea.put(b, aztertzeko);
        			aztertuGabeak.add(b);
                	aztertuak.put(b, true);
	        		}
	        	}      
	       	}
        }
	    if(!konektatuak){
	    	d=-1;
	    }
	    else{
	    	aztertzeko = bidea.get(a2);
	    	d++;
	    	while(!aztertzeko.equals(a1)){
	    		d++;
	    		aztertzeko = bidea.get(aztertzeko);
	    	}
	    }
		return d;
	}
	
	public void erlazioenGradua(){
		Random random = new Random();
		System.out.println("KALKULATZEN...");
		System.out.println("");
		ArrayList<String> izenKeys = new ArrayList<String>(g.keySet());
		String a1, a2;
		int probak = 10;
		double d = 0, totala = -1, error = -1, gehiketa = 0, probaTot = 10;
		while(error>0.25 || error==-1){
			for(int x = 0; x<probak; x++){
				a1 = izenKeys.get(random.nextInt(g.size()));
				a2 = izenKeys.get(random.nextInt(g.size()));
				d = distantzia(a1,a2);
				System.out.print(x + " ");
				if(d==-1){
					x--;
				}
				else{
					gehiketa = gehiketa + d;
				}
			}
			System.out.println("bb  " + gehiketa/probaTot);
			if(totala == -1){
				totala=gehiketa/probaTot;
			}
			else{
				if(gehiketa/probaTot<totala){
					error=totala-gehiketa/probaTot;
				}
				else{
					error=gehiketa/probaTot-totala;
				}
			}
			totala = gehiketa/probaTot;
			probak=probak*2;
			probaTot=probaTot+probak;
			System.out.println(error);
		}
		System.out.println(error + "-eko errorearekin lortutako erlazio gradua " + totala + " da.");
	}
	
	public void zentralitatea(){
		String zentralitatea=null;
		int probak = 30;
		Random random = new Random();
		
		System.out.println("KALKULATZEN...");
		System.out.println("");
		
		HashMap<String, Integer> gZentral = new HashMap<String, Integer>();
		ArrayList<String> izenKeys = new ArrayList<String>(g.keySet());
		
		for(int x=0; x<probak; x++){

			String a1, a2;
			a1 = izenKeys.get(random.nextInt(g.size()));
			a2 = izenKeys.get(random.nextInt(g.size()));
			
			ArrayList<String> listaBerria;
			boolean konektatuak = false;
			String aztertzeko = null, aurrekoa;
			HashMap<String, String> bidea = new HashMap<String, String>();
			Queue<String> aztertuGabeak = new LinkedList<String>();
			HashMap<String, Boolean> aztertuak = new HashMap<String, Boolean>();
			aztertuGabeak.add(a1);
	    	aztertuak.put(a1, true);
	        while(!konektatuak && !aztertuGabeak.isEmpty()){
		    	aurrekoa = aztertzeko;
	        	aztertzeko = aztertuGabeak.poll();
		       	if(aztertzeko.equals(a2)){
		       		konektatuak=true;
		       		bidea.put(aztertzeko, aurrekoa);
		       	}
		       	else{
		       		listaBerria = g.get(aztertzeko);
		       		for(String b : listaBerria){
		       			if(!aztertuak.containsKey(b)){
		       			bidea.put(b, aztertzeko);
	        			aztertuGabeak.add(b);
	                	aztertuak.put(b, true);
		        		}
		        	}      
		       	}
	        }
		    if(!konektatuak){
		    	x--;
		    }
		    else{
		    	aztertzeko = bidea.get(a2);
			    gZentral.put(aztertzeko,1);
			    while(!aztertzeko.equals(a1)){
			    	aztertzeko = bidea.get(aztertzeko);
			    	if(gZentral.containsKey(aztertzeko)){
			    		gZentral.put(aztertzeko, gZentral.get(aztertzeko)+1);
			    	}
			    	else{
			    		gZentral.put(aztertzeko,1);
			    	}  	
			   	}
		    	
		    }
		}
		for(String s:gZentral.keySet()){
			if(zentralitatea==null){
				zentralitatea = s;
			}
			else if(gZentral.get(zentralitatea)<gZentral.get(s)){
				zentralitatea = s;
			}
		}
		System.out.println(probak + " bikote ausaz hartuz " + zentralitatea + " atera da nodo zentral modura " + gZentral.get(zentralitatea) + " konekziorekin.");
	}
}
