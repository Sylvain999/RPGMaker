package application;

import backend.Stat;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class CreerPersoBox extends VBox {
	private Label titre;
	
	private TextField nom;
	private TextArea description;
	
	private GridPane stats;
	
//	private Label dexteriteLabel;
//	private TextField dexteriteField;
//	private Label forceLabel;
//	
//
//
//	private TextField forceField;
//	private Label sagesseLabel;
//	private TextField sagesseField; 
//	private Label intelligenceLabel;
//	private TextField intelligenceField;

	private Button bouton;
	
	public CreerPersoBox() {
		super();
		titre = new Label("Personnage");
		
		initNom();
		initDescription();
		initStats();
		initSubmit();
		
		super.setSpacing(20);
		
		super.getChildren().addAll(titre, nom, description, stats, bouton);	
		
		super.getStyleClass().clear();
		super.getStyleClass().add("creer-perso-box");
	}

	public Button getBouton() {
		return bouton;
	}
	
	public String getNom() {
		return nom.getText();
	}

	public String getDescription() {
		return description.getText();
	}
	
	public GridPane getStats() {
		return stats;
	}

//	public String getDexteriteField() {
//		return dexteriteField.getText();
//	}
//
//
//	public String getForceField() {
//		return forceField.getText();
//	}
//
//
//	public String getSagesseField() {
//		return sagesseField.getText();
//	}
//
//
//	public String getIntelligenceField() {
//		return intelligenceField.getText();
//	}

	private void initSubmit() {
		bouton = new Button("Créer le personnage");
	}

	private void initStats() {
		this.stats = new GridPane();
		
		int i = 0;
		
		for (Stat s : Main.stats) {
			this.stats.add(new Label(s.getSigle()), i , 0);
			this.stats.add(new TextField(), i, 1);
			i++;
		}
		
		
//		dexteriteLabel = new Label("Dex");
//		dexteriteField = new TextField();
//		stats.add(dexteriteLabel, 0, 0);
//		stats.add(dexteriteField, 0, 1);
//		
//		forceLabel = new Label("For");
//		forceField = new TextField();
//		stats.add(forceLabel, 1, 0);
//		stats.add(forceField, 1, 1);
//		
//		sagesseLabel = new Label("Sag");
//		sagesseField = new TextField();
//		stats.add(sagesseLabel, 2, 0);
//		stats.add(sagesseField, 2, 1);
//		
//		intelligenceLabel = new Label("Int");
//		intelligenceField = new TextField();
//		stats.add(intelligenceLabel, 3, 0);
//		stats.add(intelligenceField, 3, 1);
		
		
	}


	private void initNom() {
		nom = new TextField();
		nom.setPromptText("Nom du perso");
		nom.setMaxWidth(200);
	}
	
	private void initDescription() {
		description = new TextArea();
		description.setPromptText("Description du personnage");
		description.setPrefColumnCount(10);
		description.setWrapText(true);
		description.setPrefRowCount(5);
	}


	@SuppressWarnings("deprecation")
	public boolean erreurSaisie() {
		int i;
		boolean auMoinsUnChampVide = false;
		boolean statsInt = true;
		
		for(i=0; i< this.stats.impl_getRowCount(); i++) {
			auMoinsUnChampVide = auMoinsUnChampVide || "".equals(((TextField) this.getNodeByRowColumnIndex(i, 1, stats)).getText());
			
			statsInt = statsInt && this.isNumeric(((TextField) this.getNodeByRowColumnIndex(i, 1, stats)).getText());
		}
		
		return auMoinsUnChampVide || !statsInt;
	}
	
	

	private boolean isNumeric(String chaine) {
		try {
			Integer.parseInt(chaine);
		}catch(NumberFormatException e) {
			return false;
		}
		return true;
	}
	
	public Node getNodeByRowColumnIndex (final int column, final int row,  GridPane gridPane) {
	    Node result = null;
	    ObservableList<Node> childrens = gridPane.getChildren();

	    for (Node node : childrens) {
	        if(GridPane.getRowIndex(node) == row && GridPane.getColumnIndex(node) == column) {
	            result = node;
	            break;
	        }
	    }

	    return result;
	}
	
	

}
