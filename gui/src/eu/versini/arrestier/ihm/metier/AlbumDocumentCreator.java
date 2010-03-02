package eu.versini.arrestier.ihm.metier;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLStreamHandlerFactory;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

import eu.versini.arrestier.ihm.metier.Album.Piste;

@SuppressWarnings("unchecked")
public class AlbumDocumentCreator {
	HashMap<String, Album> albumsCharges = new HashMap<String, Album>();

	/**
	 * Constructeur pour charger les 2 arbres JDOM
	 * 
	 * @throws JDOMException
	 * @throws IOException
	 */
	public AlbumDocumentCreator(String _fichierAlbums , String _fichierArtistes )
			throws JDOMException, IOException {

		Document docAlbums = loadDocument(_fichierAlbums);
		extractFromAlbum(docAlbums);

		Document docArtistes = loadDocument(_fichierArtistes);
		extractFromArtistes(docArtistes);

	}

	private Document loadDocument(String fichierArticles) throws JDOMException,
			IOException {
		File fichierEntree = new File(fichierArticles);

		SAXBuilder sb = new SAXBuilder();
		Document doc;
		doc = sb.build(fichierEntree);
		return doc;
	}

	private void extractFromAlbum(Document doc) {
		Element root = doc.getRootElement();
		List<Element> elts = root.getChildren("Album");

		for (Element elt : elts) {
			Album album = albumFromElement(elt);
			albumsCharges.put(String.valueOf(album.getId()), album);
		}
	}

	private Album albumFromElement(Element albumElement) {

		String id = albumElement.getAttributeValue("id");
		Album album = new Album(Integer.parseInt(id));
		List<Element> listeInfoArtiste = albumElement.getChildren();

		for (Element infoAlbumElt : listeInfoArtiste) {
			//System.out.println("Element " + infoAlbumElt.toString());
			if (infoAlbumElt.getName().equals("Titre")) {
				album.setTitre(albumElement.getChildText("Titre"));
			} else if (infoAlbumElt.getName().equals("Annee")) {
				album.setAnnee(albumElement.getChildText("Annee"));
			} else if (infoAlbumElt.getName().equals("Couverture")) {
				album.setCouverture(albumElement.getChildText("Couverture"));
			} else if (infoAlbumElt.getName().equals("Artiste")) {
				album.setIdArtiste(Integer.parseInt(infoAlbumElt
						.getAttributeValue("ref")));
			} else if (infoAlbumElt.getName().equals("Support")) {

				// Recup des noeuds fils
				List<Element> elementSupport = infoAlbumElt.getChildren();
				for (Element infoSupport : elementSupport) {
					if (infoSupport.getName().equals("Type")) {
						album.setSupport(infoAlbumElt.getChildText("Type"));
					} else if (infoSupport.getName().equals("Prix")) {
						album.setPrix(Double.parseDouble(infoAlbumElt
								.getChildText("Prix")));
					}
				}
			} else if (infoAlbumElt.getName().equals("Pistes")) {
				System.out.println("Pistes");
				// Recup des noeuds fils
				List<Element> elementPiste = infoAlbumElt.getChildren();
				//System.out.println("Nb pistes : " + elementPiste.size());
				for (Element infosPiste : elementPiste) {
					if (infosPiste.getName().equals("Piste")) {
						
						List<Element> elementDeLaPiste = infosPiste.getChildren();
						//System.out.println("Nb piste : " + elementDeLaPiste.size());
						for (Element unePiste : elementDeLaPiste) {
							int numeroDePiste = 0 ;
							String titrePiste = new String();
							String dureePiste = new String();
							
							if (unePiste.getName().equals("No")) {
								//System.out.println(infoAlbumElt.getChildText("No"));
								numeroDePiste = Integer.parseInt(infosPiste.getChildText("No"));
							} else if (unePiste.getName().equals("Titre")) {
								titrePiste = infosPiste.getChildText("Titre");
							} else if (unePiste.getName().equals("Duree")) {
								dureePiste = infosPiste.getChildText("Duree");
							} else {
								//System.out.println(unePiste.getName());
							}
							//System.out.println(numeroDePiste + " " + titrePiste + " "  + dureePiste);
							
							album.getPistes().add(album.new Piste(numeroDePiste,titrePiste,dureePiste));
						}
						
					}
				}
			}
			// TODO Lecture des pistes

			
		}
		return album;
	}

	private void extractFromArtistes(Document doc) {
		Element root = doc.getRootElement();
		List<Element> elts = root.getChildren("Artiste");

		for (Element elt : elts) {
			artisteFromElement(elt);
		}
	}

	private void artisteFromElement(Element artisteElement) {

		String id = artisteElement.getAttributeValue("id");

		ArrayList<Album> listeAlbums = new ArrayList<Album>(this
				.getAlbumsCharges().values());

		List<Element> listeInfoArtiste = artisteElement.getChildren();

		for (Album album : listeAlbums) {
			for (Element infoAlbumElt : listeInfoArtiste) {
				//System.out.println("Element " + infoAlbumElt.toString());
				if (Integer.parseInt(id) == album.getIdArtiste()) {
					if (infoAlbumElt.getName().equals("Nom")) {
						album.setNomArtiste(artisteElement.getChildText("Nom"));
					} else if (infoAlbumElt.getName().equals("Prenom")) {
						album.setPrenomArtiste(artisteElement
								.getChildText("Prenom"));
					}

					
				}
			}
		}
	}


	public HashMap<String, Album> getAlbumsCharges() {
		return albumsCharges;
	}

	public void setAlbumsCharges(HashMap<String, Album> albumsCharges) {
		this.albumsCharges = albumsCharges;
	}
}
