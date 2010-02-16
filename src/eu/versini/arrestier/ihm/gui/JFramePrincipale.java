package eu.versini.arrestier.ihm.gui;
import java.awt.BorderLayout;
import java.util.Date;

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

import eu.versini.arrestier.ihm.metier.Artiste;

public class JFramePrincipale extends JFrame {
	
	private JTree globalTree = new JTree();

	public JFramePrincipale() {
		initMenu();
		initmachin();
		ModeleFichierArtiste modele = new ModeleFichierArtiste();
		modele.addArtiste(new Artiste(12, "Toto", "Tata", new Date()));
		modele.addArtiste(new Artiste(13, "Titi", "Tutu", new Date()));

		modele.addArtiste(new Artiste(14, "Toto", "Tata", new Date()));
		modele.addArtiste(new Artiste(15, "Toto", "Tata", new Date()));
		modele.addArtiste(new Artiste(16, "Toto", "Tata", new Date()));
		initModel(modele);
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

		JMenuItem menuItemExit = new JMenuItem("Exit");
		menuFile.add(menuItemExit);

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
		globalTree.getSelectionModel().setSelectionMode
        (TreeSelectionModel.SINGLE_TREE_SELECTION);
		globalTree.addTreeSelectionListener(new TreeSelectionListener() {
			
			@Override
			public void valueChanged(TreeSelectionEvent event) {
				TreePath path = event.getNewLeadSelectionPath();
				DefaultMutableTreeNode treenode = (DefaultMutableTreeNode) path.getLastPathComponent();
				Object obj = treenode.getUserObject();
				if (obj.getClass() == Artiste.class) {
					Artiste artiste = (Artiste) obj;
					panneauDroite.removeAll();
					panneauDroite.add(new JArtistePanel(artiste));
				}
			}
		});
	}
	
	public void initModel(ModeleFichierArtiste modele) {
		globalTree.setRootVisible(false);
		DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode("Root Node");
		DefaultTreeModel treeModel = new DefaultTreeModel(rootNode);
		
		for(Artiste artiste : modele) {
			rootNode.add(new DefaultMutableTreeNode(artiste));
		}

		globalTree.setModel(treeModel);
	}
}
