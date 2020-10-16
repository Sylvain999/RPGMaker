package backend;

public class Stat {
	
	String sigle;
	String nomComplet;
	String description;
	
	
	private Stat(String sigle, String nomComplet, String description) {
		super();
		this.sigle = sigle;
		this.nomComplet = nomComplet;
		this.description = description;
	}
	
	public Stat(String nomComplet) {
		this(nomComplet, "");
	}
	
	public Stat(String nomComplet, String description) {
		this(nomComplet.substring(0, 3).toUpperCase(), nomComplet, description);
	}

	
	
	
	public String getSigle() {
		return sigle;
	}

	public String getNomComplet() {
		return nomComplet;
	}

	public String getDescription() {
		return description;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Stat other = (Stat) obj;
		if (sigle == null) {
			if (other.sigle != null)
				return false;
		} else if (!sigle.equals(other.sigle))
			return false;
		return true;
	}

	public String toString() {
		return this.sigle;
	}

	public Stat genererMemeStat() {
		return new Stat(this.sigle, this.nomComplet, this.description);
	}
	
}
