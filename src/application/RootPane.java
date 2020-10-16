package application;

import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;

public class RootPane extends BorderPane {
	
	private MenuPrincipal menu;
	
	public RootPane() {
		this.menu = new MenuPrincipal();
		
		super.setTop(menu);
	}
	
	
	public MenuItem getCreerPersoMenu(){
		return this.menu.getCreerPersoMenu();
	}
	
	public MenuItem getAfficherPersoMenu(){
		return this.menu.getAfficherPersoMenu();
	}

}
