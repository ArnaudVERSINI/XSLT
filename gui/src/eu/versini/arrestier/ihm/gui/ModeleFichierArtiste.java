package eu.versini.arrestier.ihm.gui;
import java.util.HashMap;
import java.util.Iterator;

import eu.versini.arrestier.ihm.metier.Artiste;


public class ModeleFichierArtiste implements Iterable<Artiste> {
	
	public HashMap<Integer, Artiste> listeArtistes = new HashMap<Integer, Artiste>();

	@Override
	public Iterator<Artiste> iterator() {
		return listeArtistes.values().iterator();
	}
	
	public void addArtiste(Artiste artiste) {
		if(listeArtistes.containsKey(artiste.getIdArtiste())) {
			throw new RuntimeException();
		}
		
		listeArtistes.put(artiste.getIdArtiste(), artiste);
	}
	
	public void removeArtiste(int idArtiste) {
		listeArtistes.remove(idArtiste);
	}
}
