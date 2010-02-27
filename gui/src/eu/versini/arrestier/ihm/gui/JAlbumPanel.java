package eu.versini.arrestier.ihm.gui;
import java.util.Calendar;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.GroupLayout.Alignment;

import eu.versini.arrestier.ihm.metier.Album;
import eu.versini.arrestier.ihm.metier.Artiste;

public class JAlbumPanel extends JPanel implements IInterfaceSavable{
	
	private Album album;

	public JAlbumPanel(Album album) {
		this.album = album;
		final BoxLayout frameBoxLayout = new BoxLayout(this, BoxLayout.Y_AXIS);
		setLayout(frameBoxLayout);
		panneauEdition();
	}

	private void panneauEdition() {
		JPanel panneauEditionArtiste = new JPanel();
		panneauEditionArtiste.setBorder(BorderFactory
				.createTitledBorder("Gestion"));

		JLabel artisteNameLabel = new JLabel("Titre : ");
		JTextField artisteNameField = new JTextField(album.getTitre());
		
		JLabel artisteFirstNameLabel = new JLabel("Annee : ");
		JTextField artisteFirstNameField = new JTextField(album.getAnnee());

		JLabel genreLabel = new JLabel("Genre : ");
		JTextField genreField = new JTextField();
		

		GroupLayout layout = new GroupLayout(panneauEditionArtiste);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);

		panneauEditionArtiste.setLayout(layout);
		GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();
		hGroup.addGroup(layout.createParallelGroup()
				.addComponent(artisteNameLabel)
				.addComponent(artisteFirstNameLabel)
				.addComponent(genreLabel));
		hGroup.addGroup(layout.createParallelGroup()
				.addComponent(artisteNameField)
				.addComponent(artisteFirstNameField)
				.addComponent(genreField));
		
		layout.setHorizontalGroup(hGroup);

		GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();
		vGroup.addGroup(layout.createParallelGroup(Alignment.BASELINE)
				.addComponent(artisteNameLabel)
				.addComponent(artisteNameField));
		vGroup.addGroup(layout.createParallelGroup(Alignment.BASELINE)
				.addComponent(artisteFirstNameLabel)
				.addComponent(artisteFirstNameField));
		vGroup.addGroup(layout.createParallelGroup(Alignment.BASELINE)
				.addComponent(genreLabel)
				.addComponent(genreField));
		layout.setVerticalGroup(vGroup);

		add(panneauEditionArtiste);
	}
	
	public void save() {
		
	}

	@Override
	public void saveObject() {
		
	}

}
