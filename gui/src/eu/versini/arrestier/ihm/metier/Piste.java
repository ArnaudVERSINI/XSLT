package eu.versini.arrestier.ihm.metier;

public class Piste {
	public int numero;
	public String duree;
	public String titre;

	public Piste() {
	}

	public Piste(int numeroDePiste, String titrePiste, String dureePiste) {
		this.numero = numeroDePiste ;
		this.titre = titrePiste;
		this.duree = dureePiste ;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getDuree() {
		return duree;
	}

	public void setDuree(String duree) {
		this.duree = duree;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}
}