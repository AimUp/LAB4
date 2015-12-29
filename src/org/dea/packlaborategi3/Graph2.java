package org.dea.packlaborategi3;

import java.util.*;

public class Graph2 {
      private HashMap<String, Integer> th;
      private String[] keys;
      private ArrayList<Integer>[] adjList;
      private static Graph2 nireGrafoa = null;
      
   private Graph2(ArrayList<Aktore> pL){
	   grafoaSortu(pL);
   }
      
   public static synchronized Graph2 getNireGrapfoa(ArrayList<Aktore> pL){
	   if(nireGrafoa == null){
		   nireGrafoa = new Graph2(pL);
	   }
	   return nireGrafoa;
   }
   
    public boolean aktoreaBadago(String pIzen1, String pIzen2){
    	boolean badago = false;
    	if(th.containsKey(pIzen1) && th.containsKey(pIzen2)){
    		badago = true;
    	}
    	return badago;
    }
      
	private void grafoaSortu(ArrayList<Aktore> lAktoreak){
		// Post: aktoreen zerrendatik grafoa sortzen du
		//       Adabegiak aktoreen izenak eta pelikulen izenburuak dira 
		
		// 1. pausoa: th bete
		System.out.println("GRAFOA KARGATZEN DAGO. ITXARON MESEDEZ...");
		System.out.println("");
	
		int x=0;
		th = new HashMap<String, Integer>();
		for(Aktore a : lAktoreak){
			th.put(a.getIzena(), x++);
			for(Pelikula p : a.getListaP()){
				if(!th.containsKey(p.getIzenburua())){
					th.put(p.getIzenburua(), x++);				
				}
			}
		}
		
        // 2. pausoa: keys bete
		keys = new String[x];
		for(String k: th.keySet()) keys[th.get(k)] = k;
		
        // 3. pausoa: adjLista bete
		adjList = (ArrayList<Integer>[])new ArrayList[x];
		for(int i=0; i<x; i++){
			adjList[i] = new ArrayList<Integer>();
		}
		for(Aktore a :lAktoreak){
			ArrayList<Pelikula> nireListaP = a.getListaP();
			int aktoreZenb = th.get(a.getIzena());
			for(Pelikula p:nireListaP){
				int pelikulaZenb = th.get(p.getIzenburua());
				adjList[aktoreZenb].add(pelikulaZenb);
				adjList[pelikulaZenb].add(aktoreZenb);
			}
		}
		System.out.println("Grafoa kargatu egin da.");
		System.out.println("");
	}
	
	
	public void print(){
	   for (int i = 0; i < adjList.length; i++){
		System.out.print("Element: " + i + " " + keys[i] + " --> ");
		for (int k: adjList[i])  System.out.print(keys[k] + " ### ");
		
		System.out.println();
	   }
	}
	
	public boolean konektaturikDaude(String a1, String a2){
		boolean aurkitua = false;
		Queue<Integer> aztertuGabeak = new LinkedList<Integer>();
		HashMap<Integer, Boolean> aztertuak = new HashMap<Integer,Boolean>();
		int hunekoa = th.get(a1);
		int pos2 = th.get(a2);
		aztertuGabeak.add(hunekoa);
		aztertuak.put(hunekoa,true);
		while(!aurkitua && !aztertuGabeak.isEmpty()){
			hunekoa = aztertuGabeak.remove();
			if(hunekoa == pos2){
				aurkitua = true;
			}
			else{
				for(int x=0; x<adjList[hunekoa].size(); x++){
					if(!aztertuak.containsKey(adjList[hunekoa].get(x))){
						aztertuGabeak.add(adjList[hunekoa].get(x));
						aztertuak.put(adjList[hunekoa].get(x),true);
					}
				}
				
			}
		}
		return aurkitua;
	}
	private double distantzia(Integer a1, Integer a2){
		double d = 0;
		boolean konektatuak = false;
		Queue<Integer> aztertuGabeak = new LinkedList<Integer>();
		HashMap<Integer, Boolean> aztertuak = new HashMap<Integer, Boolean>();
		int hunekoa = a1;
		int pos2 = a2;
		aztertuGabeak.add(hunekoa);
		aztertuak.put(hunekoa,true);
		HashMap<Integer, Integer> bidea = new HashMap<Integer, Integer>();
		aztertuGabeak.add(hunekoa);
    	aztertuak.put(hunekoa, true);
    	int aurrekoa;
        while(!konektatuak && !aztertuGabeak.isEmpty()){
	        aurrekoa = hunekoa;
        	hunekoa = aztertuGabeak.remove();
	       	if(hunekoa==pos2){
	       		konektatuak=true;
	       		bidea.put(hunekoa, aurrekoa);
	       	}
	       	else{
	       		for(int x=0; x<adjList[hunekoa].size(); x++){
	       			if(!aztertuak.containsKey(adjList[hunekoa].get(x))){
		       			bidea.put(adjList[hunekoa].get(x), hunekoa);
	        			aztertuGabeak.add(adjList[hunekoa].get(x));
	                	aztertuak.put(adjList[hunekoa].get(x), true);
	        		}
	        	}      
	       	}
        }
	    if(!konektatuak){
	    	d=-1;
	    }
	    else{
	    	hunekoa = bidea.get(a2);
	    	d++;
	    	while(hunekoa != a1){
	    		d++;
	    		hunekoa = bidea.get(hunekoa);
	    	}
	    }
		return d;
	}
	
	public void erlazioenGradua(double errorea){
		Random random = new Random();
		System.out.println("KALKULATZEN...");
		System.out.println("");
		int probak=10, a1, a2;
		double error=0.5, totala=-1, d=0, gehiketa=0, probaTot=10;
		while(error>errorea || error==-1){
			for(int x = 0; x<probak; x++){
				a1 = random.nextInt(th.size());
				a2 = random.nextInt(th.size());
				d = distantzia(a1,a2);
				if(d==-1){
					x--;
				}
				else{
					gehiketa = gehiketa + d;
				}
			}
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
	
	
	public double zentralitatea(){
		double zentralitate=0;
		
		
		
		return zentralitate;
	}
}