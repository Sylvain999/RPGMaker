package backend;

import java.util.ArrayList;
import java.util.HashMap;

public class Perso {
	
	String nom;
	String description;
	String cheminImage;
	HashMap<Stat, Integer> stats;
	ArrayList<Capacite> capacites;
	
	
	public Perso(String nom, String description, String cheminImage, HashMap<Stat, Integer> stats, ArrayList<Capacite> capacites) {
		super();
		this.nom = nom;
		this.description = description;
		this.stats = stats;
		this.capacites = capacites;
		this.cheminImage = cheminImage;
	}
	
	public Perso() {
		this("", "", "", new HashMap<>(), new ArrayList<Capacite>());
	}


	public String getNom() {
		return nom;
	}


	public String getDescription() {
		return description;
	}


	public String getCheminImage() {
		return cheminImage;
	}


	public HashMap<Stat, Integer> getStats() {
		return stats;
	}


	public ArrayList<Capacite> getCapacites() {
		return capacites;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setCheminImage(String cheminImage) {
		this.cheminImage = cheminImage;
	}

	public void setStats(HashMap<Stat, Integer> stats) {
		this.stats = stats;
	}

	public void setCapacites(ArrayList<Capacite> capacites) {
		this.capacites = capacites;
	}
	
}
