package backend;

public class Capacite {
	
	private String description;
	private Stat stat;
	
	public Capacite(String description, Stat stat) {
		super();
		this.description = description;
		this.stat = stat;
	}

	public String getDescription() {
		return description;
	}

	public Stat getStat() {
		return stat;
	}

}
