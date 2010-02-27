package eu.versini.arrestier.ihm.gui;
import java.util.HashMap;
import java.util.Iterator;

import eu.versini.arrestier.ihm.metier.Album;
import eu.versini.arrestier.ihm.metier.Artiste;


public class ModeleFichierAlbum implements Iterable<Album> {
	
	public HashMap<Integer, Album> listeAlbums = new HashMap<Integer, Album>();

	@Override
	public Iterator<Album> iterator() {
		return listeAlbums.values().iterator();
	}
	
	public void addAlbum(Album album) {
		if(listeAlbums.containsKey(album.getId())) {
			throw new RuntimeException();
		}
		
		listeAlbums.put(album.getId(), album);
	}
	
	public void removeAlbum(int idAlbum) {
		listeAlbums.remove(idAlbum);
	}
}
