package org.dea.packlaborategia4;

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
		
		//PROBAK GRAPH1
		System.out.println("Probak Graph1-ekin:");
			//LEHENENGO PROBA
		System.out.println("–-––--------------------------------------------");
		System.out.println("LEHENENGO PROBA");
		System.out.println("–-––--------------------------------------------");
			
			System.out.println("Grafoa sortu:");
			System.out.println();
			
			long startTime = System.nanoTime();
			
			Graph1.getGraph1(Teklatua.getTeklatua().getListaAktorea());

			long endTime = System.nanoTime();
			long duration = (endTime - startTime);
			System.out.println("Ejekuzio denbora " + duration/1000000000+"seg");
			System.out.println("–-––--------------------------------------------");
			System.out.println("–-––--------------------------------------------");
			
			System.out.println();
			System.out.println();
			System.out.println();
			
			//BIGARREN PROBA
			System.out.println("–-––--------------------------------------------");
			System.out.println("BIGARREN PROBA");
			System.out.println("–-––--------------------------------------------");
			System.out.println("Konektaturik daude:");
			System.out.println();
			
			startTime = System.nanoTime();
			
			String a1 = "Kline, Giovanna";
			String a2 = "Williams, Jennifer (XI)";
			boolean kon = Graph1.getGraph1(Teklatua.getTeklatua().getListaAktorea()).konektatuta(a1, a2);
			System.out.println(a1 + " eta " + a2 + " aktoreak hartuz... ");
			if(kon){
				System.out.println("KONEKTATUTA DAUDE!");
			}
			
			endTime = System.nanoTime();
			duration = (endTime - startTime);
			System.out.println("Ejekuzio denbora " + duration/1000000000+"seg");
			System.out.println("–-––--------------------------------------------");
			System.out.println("–-––--------------------------------------------");
			
			System.out.println();
			System.out.println();
			System.out.println();
			
			//HIRUGARREN PROBA
			System.out.println("–-––--------------------------------------------");
			System.out.println("HIRUGARREN PROBA");
			System.out.println("–-––--------------------------------------------");
			System.out.println("Ez daude konektaturik:");
			System.out.println();
			
			startTime = System.nanoTime();
			a1="Moreno, Kiko";
			a2="Skliar, Diego";
			kon = Graph1.getGraph1(Teklatua.getTeklatua().getListaAktorea()).konektatuta(a1,a2 );
			System.out.println(a1 + " eta "+ a2 + " aktoreak artuz...");
			if(!kon){
				System.out.println("EZ DAUDE KONEKTATURIK!");
			}
			else{
				System.out.println("eeeeeeeeeeeeeeeeeee");
			}
			
			endTime = System.nanoTime();
			duration = (endTime - startTime);
			System.out.println("Ejekuzio denbora " + duration/1000000000+"seg");
			System.out.println("–-––--------------------------------------------");
			System.out.println("–-––--------------------------------------------");
			
			System.out.println();
			System.out.println();
			System.out.println();
			
			//LAUGARREN PROBA
			System.out.println("–-––--------------------------------------------");
			System.out.println("LAUGARREN PROBA");
			System.out.println("–-––--------------------------------------------");
			System.out.println("Erlazioen gradua (0.5):");
			System.out.println();
			
			startTime = System.nanoTime();
			double errore = 0.5;
			Graph1.getGraph1(Teklatua.getTeklatua().getListaAktorea()).erlazioenGradua(errore);;
			System.out.println(errore + "-eko errorea hartuz...");
			
			endTime = System.nanoTime();
			duration = (endTime - startTime);
			System.out.println("Ejekuzio denbora " + duration/1000000000+"seg");
			System.out.println("–-––--------------------------------------------");
			System.out.println("–-––--------------------------------------------");
			
			System.out.println();
			System.out.println();
			System.out.println();
			
			//BOSTGARREN PROBA
			System.out.println("–-––--------------------------------------------");
			System.out.println("BOSTGARREN PROBA");
			System.out.println("–-––--------------------------------------------");
			System.out.println("Erlazioen gradua (0.25):");
			System.out.println();
			
			startTime = System.nanoTime();
			errore = 0.25;
			Graph1.getGraph1(Teklatua.getTeklatua().getListaAktorea()).erlazioenGradua(errore);;
			System.out.println(errore + "-eko errorea hartuz...");
			
			endTime = System.nanoTime();
			duration = (endTime - startTime);
			System.out.println("Ejekuzio denbora " + duration/1000000000+"seg");
			System.out.println("–-––--------------------------------------------");
			System.out.println("–-––--------------------------------------------");
			
			System.out.println();
			System.out.println();
			System.out.println();
			
			//SEIGARREN PROBA
			System.out.println("–-––--------------------------------------------");
			System.out.println("SEIGARREN PROBA");
			System.out.println("–-––--------------------------------------------");
			System.out.println("Aktore baten zentralitatea:");
			System.out.println();
			
			startTime = System.nanoTime();
			a1 = "Trejo, Danny";
			int probak = 500;
			Graph1.getGraph1(Teklatua.getTeklatua().getListaAktorea()).zentralitateaAktore(probak, a1);;
			System.out.println(probak + " bikote hartuz eta " + a1 + " aktorearekin...");
			
			endTime = System.nanoTime();
			duration = (endTime - startTime);
			System.out.println("Ejekuzio denbora " + duration/1000000000+"seg");
			System.out.println("–-––--------------------------------------------");
			System.out.println("–-––--------------------------------------------");

			System.out.println();
			System.out.println();
			System.out.println();
			
			//ZAZPIGARREN PROBA
			System.out.println("–-––--------------------------------------------");
			System.out.println("ZAZPIGARREN PROBA");
			System.out.println("–-––--------------------------------------------");
			System.out.println("Zentralitate altueneko aktorea topatu:");
			System.out.println();
			probak = 500;
			startTime = System.nanoTime();
			Graph1.getGraph1(Teklatua.getTeklatua().getListaAktorea()).zentralitaHandiena(probak);;
			System.out.println(probak + " bikote hartuz...");
			
			endTime = System.nanoTime();
			duration = (endTime - startTime);
			System.out.println("Ejekuzio denbora " + duration/1000000000+"seg");
			System.out.println("–-––--------------------------------------------");
			System.out.println("–-––--------------------------------------------");
			
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			
			//PROBAK GRAPH2
			System.out.println("Probak Graph2-ekin:");
				//LEHENENGO PROBA
			System.out.println("–-––--------------------------------------------");
			System.out.println("LEHENENGO PROBA");
			System.out.println("–-––--------------------------------------------");
				
				System.out.println("Grafoa sortu:");
				System.out.println();
				
				startTime = System.nanoTime();
				
				Graph2.getNireGrapfoa(Teklatua.getTeklatua().getListaAktorea());

				endTime = System.nanoTime();
				duration = (endTime - startTime);
				System.out.println("Ejekuzio denbora " + duration/1000000000+"seg");
				System.out.println("–-––--------------------------------------------");
				System.out.println("–-––--------------------------------------------");
				
				System.out.println();
				System.out.println();
				System.out.println();
				
				//BIGARREN PROBA
				System.out.println("–-––--------------------------------------------");
				System.out.println("BIGARREN PROBA");
				System.out.println("–-––--------------------------------------------");
				System.out.println("Konektaturik daude:");
				System.out.println();
				
				startTime = System.nanoTime();
				
				a1 = "Kline, Giovanna";
				a2 = "Williams, Jennifer (XI)";
				kon = Graph2.getNireGrapfoa(Teklatua.getTeklatua().getListaAktorea()).konektaturikDaude(a1, a2);
				System.out.println(a1 + " eta " + a2 + " aktoreak hartuz... ");
				if(kon){
					System.out.println("KONEKTATUTA DAUDE!");
				}
				
				endTime = System.nanoTime();
				duration = (endTime - startTime);
				System.out.println("Ejekuzio denbora " + duration/1000000000+"seg");
				System.out.println("–-––--------------------------------------------");
				System.out.println("–-––--------------------------------------------");
				
				System.out.println();
				System.out.println();
				System.out.println();
				
				//HIRUGARREN PROBA
				System.out.println("–-––--------------------------------------------");
				System.out.println("HIRUGARREN PROBA");
				System.out.println("–-––--------------------------------------------");
				System.out.println("Ez daude konektaturik:");
				System.out.println();
				
				startTime = System.nanoTime();
				a1="Moreno, Kiko";
				a2="Skliar, Diego";
				kon = Graph2.getNireGrapfoa(Teklatua.getTeklatua().getListaAktorea()).konektaturikDaude(a1,a2 );
				System.out.println(a1 + " eta "+ a2 + " aktoreak artuz...");
				if(!kon){
					System.out.println("EZ DAUDE KONEKTATURIK!");
				}
				else{
					System.out.println("eeeeeeeeeeeeeeeeeee");
				}
				
				endTime = System.nanoTime();
				duration = (endTime - startTime);
				System.out.println("Ejekuzio denbora " + duration/1000000000+"seg");
				System.out.println("–-––--------------------------------------------");
				System.out.println("–-––--------------------------------------------");
				
				System.out.println();
				System.out.println();
				System.out.println();
				
				//LAUGARREN PROBA
				System.out.println("–-––--------------------------------------------");
				System.out.println("LAUGARREN PROBA");
				System.out.println("–-––--------------------------------------------");
				System.out.println("Erlazioen gradua (0.5:");
				System.out.println();
				
				startTime = System.nanoTime();
				errore = 0.5;
				Graph2.getNireGrapfoa(Teklatua.getTeklatua().getListaAktorea()).erlazioenGradua(errore);;
				System.out.println(errore + "-eko errorea hartuz...");
				
				endTime = System.nanoTime();
				duration = (endTime - startTime);
				System.out.println("Ejekuzio denbora " + duration/1000000000+"seg");
				System.out.println("–-––--------------------------------------------");
				System.out.println("–-––--------------------------------------------");
				
				System.out.println();
				System.out.println();
				System.out.println();
				
				//BOSTGARREN PROBA
				System.out.println("–-––--------------------------------------------");
				System.out.println("BOSTGARREN PROBA");
				System.out.println("–-––--------------------------------------------");
				System.out.println("Erlazioen gradua (0.25):");
				System.out.println();
				
				startTime = System.nanoTime();
				errore = 0.25;
				Graph2.getNireGrapfoa(Teklatua.getTeklatua().getListaAktorea()).erlazioenGradua(errore);;
				System.out.println(errore + "-eko errorea hartuz...");
				
				endTime = System.nanoTime();
				duration = (endTime - startTime);
				System.out.println("Ejekuzio denbora " + duration/1000000000+"seg");
				System.out.println("–-––--------------------------------------------");
				System.out.println("–-––--------------------------------------------");
				
				System.out.println();
				System.out.println();
				System.out.println();
				
				//SEIGARREN PROBA
				System.out.println("–-––--------------------------------------------");
				System.out.println("SEIGARREN PROBA");
				System.out.println("–-––--------------------------------------------");
				System.out.println("Aktore baten zentralitatea:");
				System.out.println();
				
				startTime = System.nanoTime();
				a1 = "Trejo, Danny";
				probak = 500;
				Graph2.getNireGrapfoa(Teklatua.getTeklatua().getListaAktorea()).zentralitateaAktore(probak, a1);;
				System.out.println(probak + " bikote hartuz eta " + a1 + " aktorearekin...");
				
				endTime = System.nanoTime();
				duration = (endTime - startTime);
				System.out.println("Ejekuzio denbora " + duration/1000000000+"seg");
				System.out.println("–-––--------------------------------------------");
				System.out.println("–-––--------------------------------------------");

				System.out.println();
				System.out.println();
				System.out.println();
				
				//ZAZPIGARREN PROBA
				System.out.println("–-––--------------------------------------------");
				System.out.println("ZAZPIGARREN PROBA");
				System.out.println("–-––--------------------------------------------");
				System.out.println("Zentralitate altueneko aktorea topatu:");
				System.out.println();
				probak = 500;
				startTime = System.nanoTime();
				Graph2.getNireGrapfoa(Teklatua.getTeklatua().getListaAktorea()).zentralitaHandiena(probak);;
				System.out.println(probak + " bikote hartuz...");
				
				endTime = System.nanoTime();
				duration = (endTime - startTime);
				System.out.println("Ejekuzio denbora " + duration/1000000000+"seg");
				System.out.println("–-––--------------------------------------------");
				System.out.println("–-––--------------------------------------------");
	}
	
}
