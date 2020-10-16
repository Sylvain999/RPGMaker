package application;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

public class MenuPrincipal extends MenuBar {
	
	private Menu persoMenu;
	private MenuItem creerPerso;
	private MenuItem afficherPerso;
	
	public MenuPrincipal(){
		this.persoMenu = createPersoMenu();
		
		super.getMenus().addAll(persoMenu);
	}
	
	public MenuItem getCreerPersoMenu() {
		return this.creerPerso;
	}
	
	public MenuItem getAfficherPersoMenu() {
		return this.afficherPerso;
	}

	private Menu createPersoMenu() {
		Menu menu = new Menu("Persos");
		
		creerPerso = new MenuItem("Créer nouveau perso");
		afficherPerso = new MenuItem("Afficher les persos");
		
		menu.getItems().addAll(creerPerso, afficherPerso);
		
		return menu;
	}

}
