package application;

import backend.Perso;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class AfficherPersos extends VBox {
	
	private Label titre;

	public AfficherPersos() {
		super();
		super.getStyleClass().clear();
		super.getStyleClass().add("afficher-perso-box");
		
		titre = new Label("Afficher Les Personnages");
		
		this.getChildren().add(titre);
		
		for(Perso p : Main.persos) {
			this.getChildren().add(new PersoBox(p));
		}
		
	}
	
	

}
