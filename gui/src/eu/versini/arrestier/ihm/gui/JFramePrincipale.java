package eu.versini.arrestier.ihm.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

import org.jdom.DocType;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

import eu.versini.arrestier.ihm.metier.Album;
import eu.versini.arrestier.ihm.metier.AlbumDocumentCreator;
import eu.versini.arrestier.ihm.metier.Artiste;
import eu.versini.arrestier.ihm.metier.Piste;

public class JFramePrincipale extends JFrame {

	private JTree globalTree = new JTree();

	JFileChooser chooser;

	String choosertitle;

	ModeleFichierAlbum modele;
	
	HashMap<String, Artiste> listeArtiste ;

	public JFramePrincipale() {
		chooser = new JFileChooser();
		chooser.setCurrentDirectory(new java.io.File("."));
		chooser.setDialogTitle(new String(
				"Choisissez l'emplacement des fichiers XML"));
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		//
		// disable the "All files" option.
		//
		chooser.setAcceptAllFileFilterUsed(false);
		//    
		if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			System.out.println("getCurrentDirectory(): "
					+ chooser.getCurrentDirectory());
			System.out.println("getSelectedFile() : "
					+ chooser.getSelectedFile());
			try {
				chargerModele(chooser.getSelectedFile().toString());
			} catch (JDOMException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.exit(-1);
		}
		setTitle("DiscoWeb - Editeur de discographie");
		initMenu();
		initmachin();
		setPreferredSize(new Dimension(600, 400));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void maMethodeAArgument(String arg1, int arg2, double ar3) {
		System.out.println(arg1 + arg2 + ar3);
	}

	public void maMethodeAArgument(String arg1, int arg2) {
		maMethodeAArgument(arg1, arg2, 10.0);
	}

	private void initMenu() {
		final JMenuBar menuBar = new JMenuBar();

		final JMenu menuFile = new JMenu("Fichier");
		
		JMenuItem menuItemNew = new JMenuItem("Ajouter album");
		menuFile.add(menuItemNew);
		menuItemNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				globalTree.isSelectionEmpty() ;
				Album alb = new Album(modele.listeAlbums.size()+1) ;
				alb.setTitre("Nouvel Album") ;
				modele.addAlbum(alb ) ;
				initModel(modele);
				
			}
		}); 

		JMenuItem menuItemOpen = new JMenuItem("Ouvrir");
		menuFile.add(menuItemOpen);

		JMenuItem menuItemExport = new JMenuItem("Exporter");
		menuItemExport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				try {
					Exporter();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		menuFile.add(menuItemExport);

		JMenuItem menuItemExit = new JMenuItem("Exit");
		menuFile.add(menuItemExit);
		menuItemExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}
		});

		final JMenu menuHelp = new JMenu("Help");

		JMenuItem menuItemAbout = new JMenuItem("About");
		menuHelp.add(menuItemAbout);

		menuBar.add(menuFile);
		menuBar.add(menuHelp);

		this.setJMenuBar(menuBar);
	}

	protected void Exporter() throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		
		
		for (Album unAlbum : modele) {
			System.out.println(unAlbum.affiche());
		}

		Element root = new Element("Albums");

		for (Album unAlbum : modele) {
			root.addContent(convertAlbumToElement(unAlbum));
		}

		Document document = new Document(root);
		document.setDocType(new DocType("Albums", "Albums.dtd"));
		XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
		sortie.output(document, new FileOutputStream(new File("sortie.xml")));

	}

	private Element convertAlbumToElement(Album unAlbum) {
		Element albumElement = new Element("album");
		albumElement.setAttribute("id", String.valueOf(unAlbum.getId()));

		Element titre = new Element("Titre");
		titre.setText(unAlbum.getTitre());
		albumElement.addContent(titre);

		Element annee = new Element("Annee");
		annee.setText(unAlbum.getAnnee());
		albumElement.addContent(annee);

		Element couverture = new Element("Couverture");
		couverture.setAttribute("fichier", unAlbum.getCouverture());
		albumElement.addContent(couverture);
		
		Element support = new Element("Support");
		Element type = new Element("Type");
		type.setText(unAlbum.getSupport());
		support.addContent(type) ;
		
		Element prix = new Element("Prix");
		prix.setText(String.valueOf(unAlbum.getPrix()));
		support.addContent(prix) ;
		albumElement.addContent(support) ;
		
		Element pistes = new Element("Pistes") ;
		for (Piste unePiste : unAlbum.getPistes()) {
			Element piste = new Element("Piste");
			
			Element numero = new Element("No");
			numero.setText(String.valueOf(unePiste.getNumero()));
			piste.addContent(numero) ;
			Element titrePiste = new Element("Titre");
			titrePiste.setText(unePiste.getTitre());
			piste.addContent(titrePiste) ;
			Element duree = new Element("Duree");
			duree.setText(unePiste.getDuree());
			piste.addContent(duree) ;
			
			pistes.addContent(piste);
			
		}
	 albumElement.addContent(pistes);
		return albumElement;
	}

	public void initmachin() {
		JSplitPane splitPane = new JSplitPane();

		getContentPane().add(splitPane, BorderLayout.CENTER);
		splitPane.add(globalTree, JSplitPane.LEFT);

		final JPanel panneauDroite = new JPanel();
		panneauDroite.setLayout(new BorderLayout());

		splitPane.add(panneauDroite, JSplitPane.RIGHT);
		globalTree.getSelectionModel().setSelectionMode(
				TreeSelectionModel.SINGLE_TREE_SELECTION);
		globalTree.addTreeSelectionListener(new TreeSelectionListener() {

			@Override
			public void valueChanged(TreeSelectionEvent event) {
				TreePath path = event.getNewLeadSelectionPath();
				if (path == null)
					return;
				DefaultMutableTreeNode treenode = (DefaultMutableTreeNode) path
						.getLastPathComponent();
				Object obj = treenode.getUserObject();
				if (obj.getClass() == Album.class) {
					Album album = (Album) obj;
					panneauDroite.removeAll();
					panneauDroite.add(new JAlbumPanel(album , listeArtiste));
				}
			}
		});
	}

	public void initModel(ModeleFichierAlbum modele) {
		globalTree.setRootVisible(false);
		DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode(
				"Root Node");
		DefaultTreeModel treeModel = new DefaultTreeModel(rootNode);

		for (Album album : modele) {
			rootNode.add(new DefaultMutableTreeNode(album));

		}

		globalTree.setModel(treeModel);
	}

	public void chargerModele(String repertoire) throws JDOMException,
			IOException {

		AlbumDocumentCreator albums = new AlbumDocumentCreator(repertoire
				+ System.getProperty("file.separator") + "Albums.xml",
				repertoire + System.getProperty("file.separator")
						+ "Artistes.xml");
		listeArtiste = albums.getArtistesCharges();
		modele = new ModeleFichierAlbum();

		ArrayList<Album> listeAlbums = new ArrayList<Album>(albums
				.getAlbumsCharges().values());
		Collections.sort(listeAlbums);
		Collections.reverse(listeAlbums);

		for (Album album : listeAlbums) {
			modele.addAlbum(album);
		}

		initModel(modele);
	}
}
