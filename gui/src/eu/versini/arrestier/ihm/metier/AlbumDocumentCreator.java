package eu.versini.arrestier.ihm.metier;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
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

@SuppressWarnings("unchecked")
public class AlbumDocumentCreator {
	private String fichierArtistes ;
	private String fichierAlbums;
	HashMap<String, Artiste> artistesCharges = new HashMap<String, Artiste>();

	
	/**
	 * Constructeur pour charger les 2 arbres JDOM
	 * @throws JDOMException
	 * @throws IOException
	 */
	AlbumDocumentCreator(String _fichierArtistes, String _fichierAlbums) throws JDOMException, IOException {

		Document docArtistes = loadDocument(AlbumDocumentCreator.class
				.getResource("/static/xml/Artistes.xml").getFile());
		extractFromArtiste(docArtistes);
		
		Document docAlbums = loadDocument(AlbumDocumentCreator.class
				.getResource("/static/xml/Albums.xml").getFile());
		//extractFromVentes(docAlbums);

		//enregistrementDocument();
	}

	/*private void enregistrementDocument() throws IOException {
		Element root = new Element("listeVenteParArticle");
		ArrayList<Article> articles = new ArrayList<Article>(artistesCharges
				.values());
		Collections.sort(articles);

		for (Article article : articles) {
			root.addContent(convertArticleToElement(article));
		}

		Document document = new Document(root);
		XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
		sortie.output(document, new FileOutputStream(new File("sortie.xml")));
	}*/

	/*private Element convertArtisteToElement(Artiste artiste) {
		Element artisteElement = new Element("article");
		artisteElement.setAttribute("id", article.getId());
		Element ca = new Element("CA");
		ca.setText(Double.toString(artiste.getChiffreAffaire()));
		artisteElement.addContent(ca);

		for (Type type : article) {
			Element typeElement = new Element("type");
			typeElement.setAttribute("taille", type.getTaille());

			Element qteElement = new Element("qte");
			qteElement.setText(Integer.toString(type.getQuantite()));
			typeElement.addContent(qteElement);
			articleElement.addContent(typeElement);
		}
		return articleElement;
	}*/

	private Document loadDocument(String fichierArticles) throws JDOMException,
			IOException {
		File fichierEntree = new File(fichierArticles);

		SAXBuilder sb = new SAXBuilder();
		Document doc;
		doc = sb.build(fichierEntree);
		return doc;
	}

	private void extractFromArtiste(Document doc) {
		Element root = doc.getRootElement();
		List<Element> elts = root.getChildren("Artiste");

		for (Element elt : elts) {
			Artiste artiste = artisteFromElement(elt);
			artistesCharges.put(String.valueOf(artiste.getIdArtiste()), artiste);
		}
	}

	private Artiste artisteFromElement(Element artisteElement) {
		
		String id = artisteElement.getAttributeValue("id");
		Artiste artiste = new Artiste(Integer.parseInt(id));
		List<Element> listeInfoArtiste = artisteElement.getChildren();
		
		for (Element infoArtisteElt :listeInfoArtiste) {
			if (infoArtisteElt.getName().equals("Nom")) {
				artiste.setNom(artisteElement.getChildText("Nom"));
			}
			else if (infoArtisteElt.getName().equals("Prenom")) {
				artiste.setPrenom(artisteElement.getChildText("Prenom"));
			}
			else if (infoArtisteElt.getName().equals("Date-naissance")) {
				artiste.setDateNaissance(artisteElement.getChildText("Date-naissance"));
			}
			else if (infoArtisteElt.getName().equals("Lieu-naissance")) {
				artiste.setLieuNaissance(artisteElement.getChildText("Lieu-naissance"));
			}
			else if (infoArtisteElt.getName().equals("Photo")) {
				//artiste.setPhoto(artisteElement.getAttributeValue("Photo"));
			}
			else if (infoArtisteElt.getName().equals("Info_Biographie")) {
				artiste.setInfoBiographie(artisteElement.getChildText("Info_Biographie"));
			}
			
			
			else if (infoArtisteElt.getName().equals("Pays")) {
				artiste.setPays(artisteElement.getChildText("Pays"));
			}
			
			else {
				System.err.println("Balise : " + infoArtisteElt.getName());
			}
		}
		return artiste;
	}

	/*private void extractFromVentes(Document doc) {
		Element root = doc.getRootElement();
		List<Element> elts = root.getChildren("client");

		for (Element eltClient : elts) {
			List<Element> articles = eltClient.getChildren("article");
			for (Element eltArtiste : articles) {
				String id = eltArtiste.getChildText("code");
				Artiste article = artistesCharges.get(id);

				List<Element> qteElements = eltArtiste.getChildren("qte");
				for (Element elt : qteElements) {
					article.addQuantite(elt.getAttributeValue("taille"),
							Integer.parseInt(elt.getText()));
				}
			}
		}
	}*/
	private String getFichierArtistes() {
		return fichierArtistes;
	}

	private void setFichierArtistes(String fichierArtistes) {
		this.fichierArtistes = fichierArtistes;
	}

	private String getFichierAlbums() {
		return fichierAlbums;
	}

	private void setFichierAlbums(String fichierAlbums) {
		this.fichierAlbums = fichierAlbums;
	}
	

	public HashMap<String, Artiste> getArtistesCharges() {
		return artistesCharges;
	}



	public void setArtistesCharges(HashMap<String, Artiste> artistesCharges) {
		this.artistesCharges = artistesCharges;
	}
}
