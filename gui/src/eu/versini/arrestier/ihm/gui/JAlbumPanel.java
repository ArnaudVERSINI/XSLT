package eu.versini.arrestier.ihm.gui;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;

import eu.versini.arrestier.ihm.metier.Album;


public class JAlbumPanel extends JPanel implements IInterfaceSavable{
	
	private Album album;

	public JAlbumPanel(Album album) {
		this.album = album;
		final BoxLayout frameBoxLayout = new BoxLayout(this, BoxLayout.Y_AXIS);
		setLayout(frameBoxLayout);
		panneauEdition();
	}

	private void panneauEdition() {
		JPanel panneauEditionAlbum = new JPanel();
		panneauEditionAlbum.setBorder(BorderFactory
				.createTitledBorder("Informations album"));

		JLabel titreLabel = new JLabel("Titre : ");
		JTextField titreField = new JTextField(album.getTitre());
		
		JLabel anneeLabel = new JLabel("Annee : ");
		JTextField anneeField = new JTextField(album.getAnnee());

		JLabel artisteLabel = new JLabel("Artiste : ");
		JTextField artisteField = new JTextField(album.getPrenomArtiste() + " " + album.getNomArtiste());
		
		JLabel supportLabel = new JLabel("Support : ");
		JTextField supportField = new JTextField(album.getSupport());
		
		JLabel prixLabel = new JLabel("Prix : ");
		JTextField prixField = new JTextField(String.valueOf(album.getPrix()));

		GroupLayout layout = new GroupLayout(panneauEditionAlbum);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);

		panneauEditionAlbum.setLayout(layout);
		GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();
		hGroup.addGroup(layout.createParallelGroup()
				.addComponent(titreLabel)
				.addComponent(anneeLabel)
				.addComponent(artisteLabel)
				.addComponent(supportLabel)
				.addComponent(prixLabel));
		hGroup.addGroup(layout.createParallelGroup()
				.addComponent(titreField)
				.addComponent(anneeField)
				.addComponent(artisteField)
				.addComponent(supportField)
				.addComponent(prixField));
		
		layout.setHorizontalGroup(hGroup);

		GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();
		vGroup.addGroup(layout.createParallelGroup(Alignment.BASELINE)
				.addComponent(titreLabel)
				.addComponent(titreField));
		vGroup.addGroup(layout.createParallelGroup(Alignment.BASELINE)
				.addComponent(anneeLabel)
				.addComponent(anneeField));
		vGroup.addGroup(layout.createParallelGroup(Alignment.BASELINE)
				.addComponent(artisteLabel)
				.addComponent(artisteField));
		vGroup.addGroup(layout.createParallelGroup(Alignment.BASELINE)
				.addComponent(supportLabel)
				.addComponent(supportField));
		vGroup.addGroup(layout.createParallelGroup(Alignment.BASELINE)
				.addComponent(prixLabel)
				.addComponent(prixField));
		layout.setVerticalGroup(vGroup);

		add(panneauEditionAlbum);
		
		JPanel panneauEditionPistes = new JPanel();
		panneauEditionPistes.setBorder(BorderFactory
				.createTitledBorder("Informations album"));
		
		add(new JTableBasiqueAvecModeleDynamiqueObjet(album.getPistes()));
	}
	
	public void save() {
		
	}

	@Override
	public void saveObject() {
		
	}

}
