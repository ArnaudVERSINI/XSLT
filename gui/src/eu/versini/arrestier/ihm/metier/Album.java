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
	
	
	
	private class Piste {
		
		private int numero ;
		
		private String duree ;
		
		private String titre ;
		
		public  Piste (int _numero , String _duree , String _titre) {
			this.numero = _numero ;
			this.duree = _duree ;
			this.titre = _titre ;
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

	@Override
	public int compareTo(Album autreAlbum) {
		// TODO Auto-generated method stub
		return  ((Integer) autreAlbum.getId()).compareTo(getId());
	}
}
