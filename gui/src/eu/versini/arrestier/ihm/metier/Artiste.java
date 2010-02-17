package eu.versini.arrestier.ihm.metier;
import java.net.URL;
import java.util.Date;

public class Artiste {
	private String dateNaissance;
	
	private String lieuNaissance;

	public String getLieuNaissance() {
		return lieuNaissance;
	}

	public void setLieuNaissance(String lieuNaissance) {
		this.lieuNaissance = lieuNaissance;
	}

	private int idArtiste;

	private String infoBiographie;

	private String nom;

	private String pays;

	private URL photo;

	private String prenom;
	
	public Artiste(int idArtiste, String nom, String prenom, String dateNaissance) {
		this.idArtiste = idArtiste;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
	}
	
	public Artiste(int idArtiste) {
		this.idArtiste = idArtiste;
	}

	public String getDateNaissance() {
		return dateNaissance;
	}

	public int getIdArtiste() {
		return idArtiste;
	}

	public String getInfoBiographie() {
		return infoBiographie;
	}

	public String getNom() {
		return nom;
	}

	public String getPays() {
		return pays;
	}

	public URL getPhoto() {
		return photo;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public void setIdArtiste(int idArtiste) {
		this.idArtiste = idArtiste;
	}

	public void setInfoBiographie(String infoBiographie) {
		this.infoBiographie = infoBiographie;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public void setPhoto(URL photo) {
		this.photo = photo;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	@Override
	public String toString() {
		return nom + " " + prenom;
	}
}

