package eu.versini.arrestier.ihm.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

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

import org.jdom.JDOMException;

import eu.versini.arrestier.ihm.metier.Album;
import eu.versini.arrestier.ihm.metier.AlbumDocumentCreator;


public class JFramePrincipale extends JFrame {

	private JTree globalTree = new JTree();
	
	JFileChooser chooser;
	
	String choosertitle;


	public JFramePrincipale() {
		initMenu();
		initmachin();
		setPreferredSize(new Dimension(600, 400));
		
	}

	public void maMethodeAArgument(String arg1, int arg2, double ar3) {
		System.out.println(arg1 + arg2 + ar3);
	}

	public void maMethodeAArgument(String arg1, int arg2) {
		maMethodeAArgument(arg1, arg2, 10.0);
	}

	private void initMenu() {
		final JMenuBar menuBar = new JMenuBar();

		final JMenu menuFile = new JMenu("File");
		JMenuItem menuItemNew = new JMenuItem("New");
		menuFile.add(menuItemNew);

		JMenuItem menuItemOpen = new JMenuItem("Open");
		menuFile.add(menuItemOpen);
		menuItemOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				chooser = new JFileChooser(); 
			    chooser.setCurrentDirectory(new java.io.File("."));
			    chooser.setDialogTitle(choosertitle);
			    chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			    //
			    // disable the "All files" option.
			    //
			    chooser.setAcceptAllFileFilterUsed(false);
			    //    
			    if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) { 
			      System.out.println("getCurrentDirectory(): " 
			         +  chooser.getCurrentDirectory());
			      System.out.println("getSelectedFile() : " 
			         +  chooser.getSelectedFile());
			      try {
					chargerModele(chooser.getSelectedFile().toString()) ;
				} catch (JDOMException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			      }
			    else {
			      System.out.println("No Selection ");
			      }

			}
		});

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
				DefaultMutableTreeNode treenode = (DefaultMutableTreeNode) path
						.getLastPathComponent();
				Object obj = treenode.getUserObject();
				if (obj.getClass() == Album.class) {
					Album album = (Album) obj;
					panneauDroite.removeAll();
					panneauDroite.add(new JAlbumPanel(album));
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
	
	public void chargerModele(String repertoire) throws JDOMException, IOException {
		
		AlbumDocumentCreator albums = new AlbumDocumentCreator(repertoire +System.getProperty("file.separator") +"Albums.xml" , repertoire + System.getProperty("file.separator") +"Artistes.xml");
		ModeleFichierAlbum modele = new ModeleFichierAlbum();
		
		ArrayList<Album> listeAlbums = new ArrayList<Album>(albums.getAlbumsCharges().values());
		Collections.sort(listeAlbums);
		Collections.reverse(listeAlbums);
		
		for (Album album : listeAlbums) {
			modele.addAlbum(album);
		}

		initModel(modele);
	}
}
