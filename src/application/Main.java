package application;

import java.util.ArrayList;
import java.util.HashSet;

import backend.FichierActions;
import backend.Perso;
import backend.Stat;
import controllers.CarteCreerPersoHandler;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;


public class Main extends Application {
	
	public static ArrayList<Perso> persos;
	public static HashSet<Stat> stats;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			
			persos = new ArrayList<Perso>(); //la liste des persos dans le projet
			
			stats = new HashSet<Stat>(); //la liste des Stats qui sont utilisés dans le projet
			
			stats.add(new Stat("dexterite"));
			stats.add(new Stat("force"));
			stats.add(new Stat("sagesse"));
			stats.add(new Stat("intelligence"));
			
			
			FichierActions.charger(); // on charge dans persos tous les personnages enregistrés dans le fichier
		
			
			RootPane root = new RootPane();
			
			root.getCreerPersoMenu().setOnAction(new CarteCreerPersoHandler()); //Action créer perso
			
			root.getAfficherPersoMenu().setOnAction(new EventHandler<ActionEvent>() { //Action Afficher perso

				@Override
				public void handle(ActionEvent event) {
					root.setCenter(new AfficherPersos());	
				}
			});
			
			
			
			Scene scene = new Scene(root,700,500);
			
			
			scene.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() { // Les raccourcis claviers
				final KeyCombination sauvegarde = new KeyCodeCombination(KeyCode.S, KeyCombination.CONTROL_DOWN); // CTRL + S

				@Override
				public void handle(KeyEvent event) {
					if (sauvegarde.match(event)) {
						scene.setCursor(Cursor.WAIT);
						if (!FichierActions.sauvegarder()){ // sauvegarde CTRL + S
							System.err.println("Un probleme s'est occuré lors de la sauvegarde");
						}
						scene.setCursor(Cursor.DEFAULT);
					}
					
				}

			});
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			
			primaryStage.setScene(scene);
			//primaryStage.setMaximized(true);
			primaryStage.show();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
