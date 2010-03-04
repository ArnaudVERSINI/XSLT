package eu.versini.arrestier.ihm.metier;

import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Album implements Comparable<Album>{
	
	private Integer id ;
	
	private String titre ;
	
	private String annee ;
	
	private String couverture ; // TODO FA à transformer en URL ou autre
	
	private int idArtiste ;
	
	private String nomArtiste ;
	
	private String prenomArtiste ;
	
	private String support ;
	
	private double prix ;
	
	private ArrayList<Piste> pistes = new ArrayList<Piste>();
	
	public Album(Integer _id) {
		this.id = _id ;
	}
	
	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getAnnee() {
		return annee;
	}

	public void setAnnee(String annee) {
		this.annee = annee;
	}

	public String getCouverture() {
		return couverture;
	}

	public void setCouverture(String couverture) {
		this.couverture = couverture;
	}

	public int getIdArtiste() {
		return idArtiste;
	}

	public void setIdArtiste(int idArtiste) {
		this.idArtiste = idArtiste;
	}

	public String getNomArtiste() {
		return nomArtiste;
	}

	public void setNomArtiste(String nomArtiste) {
		this.nomArtiste = nomArtiste;
	}

	public String getPrenomArtiste() {
		return prenomArtiste;
	}

	public void setPrenomArtiste(String prenomArtiste) {
		this.prenomArtiste = prenomArtiste;
	}

	public String getSupport() {
		return support;
	}

	public void setSupport(String support) {
		this.support = support;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public ArrayList<Piste> getPistes() {
		return pistes;
	}

	public void setPistes(ArrayList<Piste> pistes) {
		this.pistes = pistes;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String affiche() {
		String retour ;
		retour = this.getTitre() + " " + this.getAnnee() + "\n";
			for (Piste unePiste : this.getPistes()) {
				retour += "\t" + unePiste + "\n";
			}
		return retour;
		
	}
	
	public String toString() {
		return getTitre();
		
	}
	@Override
	public int compareTo(Album autreAlbum) {
		// TODO Auto-generated method stub
		return  ((Integer) autreAlbum.getId()).compareTo(getId());
	}
}

