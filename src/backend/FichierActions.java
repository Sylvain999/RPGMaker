package backend;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Scanner;
import application.Main;

public class FichierActions {
	
	@SuppressWarnings("rawtypes")
	public static boolean sauvegarder() {
		
		String aAjouter = ""; //String qui sera écrite dans le fichier
		try {
			BufferedWriter scribe = new BufferedWriter(new FileWriter(Constantes.CHEMIN_FICHIER_PERSOS));
			PrintWriter writer = new PrintWriter(scribe);
			for(Perso p : Main.persos) {
				aAjouter = p.getNom() + " |END " + p.getDescription() + " |END " + p.getCheminImage() +
						"|END "; //on ajoute les noms/description/cheminImage
				for (Map.Entry m : p.getStats().entrySet()) { //on ajoute les stats
		            aAjouter += m.getKey()+" "+m.getValue() + " ";
		        }
				
				writer.println(aAjouter); // on écrit la ligne à ajouter
			}
			writer.close();
			
			scribe.close();
			return true;
		}catch (Exception e) { // Probleme lors de l'écriture
			return false;
		}
		
	}
	
	@SuppressWarnings("resource")
	public static boolean charger() {
		BufferedReader fichierPersos;
		Scanner scannerFichier;
		Perso tempPerso;
		String tempChaine;
		String verifChaine;
		Stat tempStat;
		
		try {
			fichierPersos = new BufferedReader(new FileReader(Constantes.CHEMIN_FICHIER_PERSOS));
			scannerFichier = new Scanner(fichierPersos);
			
			while(scannerFichier.hasNext()) { //tant qu'il y a un perso
				
				tempPerso = new Perso();
				tempChaine = "";
				
				//Nom
				verifChaine = scannerFichier.next();
				while (!verifChaine.equals("|END")) {
					tempChaine += verifChaine;
					verifChaine = scannerFichier.next();
				}
				
				tempPerso.setNom(tempChaine);
				tempChaine = "";
				
				
				//Description
				verifChaine = scannerFichier.next();
				while (!verifChaine.equals("|END")) {
					tempChaine += verifChaine;
					verifChaine = scannerFichier.next();
				}
				
				tempPerso.setDescription(tempChaine);
				tempChaine = "";
				
				
				//CheminImage
				verifChaine = scannerFichier.next();
				while (!verifChaine.equals("|END")) {
					tempChaine += verifChaine;
					verifChaine = scannerFichier.next();
				}
				
				tempPerso.setCheminImage(tempChaine);
				tempChaine = "";
				
				
				//Stats
				for (Stat s : Main.stats) {
					tempChaine = scannerFichier.next();
					tempStat = null;
					
					for (Stat s2 : Main.stats) {
						if (tempChaine.equals(s2.getSigle())) {
							tempStat = s2.genererMemeStat();
						}
					}
					
					if (tempStat == null) {
						tempStat = Constantes.UNDEFINED_STAT.genererMemeStat();
					}
					
					
					tempPerso.stats.put(tempStat, scannerFichier.nextInt());
				}				
				
				//Capacites
				
				//Ajout du perso à la liste des persos
				Main.persos.add(tempPerso);
			}
			
			
		} catch (IOException e) {//probleme lors de lecture
			e.printStackTrace();
			return false;
		}
		return true;		
	}
	
	

}
