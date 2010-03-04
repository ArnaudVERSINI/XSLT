package eu.versini.arrestier.ihm.metier;


public class Artiste {
	
	private int idArtiste;

	private String nom;

	private String prenom;
	
	public Artiste(int idArtiste, String nom, String prenom) {
		this.idArtiste = idArtiste;
		this.nom = nom;
		this.prenom = prenom;
	}
	
	public Artiste(int idArtiste) {
		this.idArtiste = idArtiste;
	}

	public int getIdArtiste() {
		return idArtiste;
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	@Override
	public String toString() {
		return nom + " " + prenom;
	}
}

