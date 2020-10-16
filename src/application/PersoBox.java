package application;

import java.util.Map;

import backend.Perso;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

//Classe qui permet l'affichage d'un perso lors de l'affichage des persos
public class PersoBox extends VBox {
	private Label nom;
	private Label description;
	private GridPane stats;
	
	
	@SuppressWarnings("rawtypes")
	public PersoBox(Perso p) {
		super();
			
		nom = new Label(p.getNom());
		description = new Label(p.getDescription());
		
		stats = new GridPane();
		
		int i = 0;
		
		//On met chaque stat mise dansle gridPane
		for (Map.Entry me : p.getStats().entrySet()) {			
			this.stats.add(new Label(me.getKey().toString()), i, 0);
			this.stats.add(new Label(me.getValue().toString()), i, 1);
			i++;
	    }
		
		this.getChildren().addAll(nom, description, stats);
		
	}
	
	
	
	
}
