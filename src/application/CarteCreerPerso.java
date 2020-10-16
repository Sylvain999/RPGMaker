package application;

import java.util.HashMap;

import backend.Perso;
import backend.Stat;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class CarteCreerPerso implements EventHandler<MouseEvent> {
	private final int CREER_PERSO_MAX_LENGTH = 300;
	private final int CREER_PERSO_MAX_HEIGHT = 600;
	
	private CreerPersoBox root;
	private Scene scene;
	private Stage stage;
	
	public CarteCreerPerso() {
		super();
		this.root = new CreerPersoBox();
		this.scene = new Scene(root, CREER_PERSO_MAX_LENGTH, CREER_PERSO_MAX_HEIGHT);
		scene.getStylesheets().add(getClass().getResource("../application/application.css").toExternalForm());
		
		
		this.root.getBouton().setOnMouseClicked(this);
		
		stage = new Stage();
		
		stage.setScene(scene);
		stage.setResizable(false);
		stage.setAlwaysOnTop(true);
		stage.show();
	}

	@Override
	public void handle(MouseEvent event) {
		if (root.erreurSaisie()) {
			
		}else {
			int i =0;
			HashMap<Stat, Integer> stats = new HashMap<>();
			
			for (Stat s : Main.stats) {//attribution pour chaque stat su projet la valeur dans le TextField Correspondant
				stats.put(s, Integer.parseInt( ((TextField) root.getNodeByRowColumnIndex(i, 1, root.getStats())).getText()));
			}
			
			Main.persos.add(new Perso(root.getNom(), root.getDescription(), "", stats, null));
			stage.close();
		}		
	}
	
	
}
