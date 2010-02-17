package eu.versini.arrestier.ihm.metier;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Album {
	
	private String titre ;
	
	private String annee ;
	
	private URL couverture ;
	
	private int idArtiste ;
	
	private String nomArtiste ;
	
	private String prenomArtiste ;
	
	private String support ;
	
	private double prix ;
	
	private ArrayList<Piste> pistes = new ArrayList<Piste>();
	
	private class Piste {
		
		private int numero ;
		
		private String duree ;
		
		private String titre ;
		
		public Piste (int _numero , String _duree , String _titre) {
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
}
