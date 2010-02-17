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

import eu.versini.arrestier.ihm.metier.Artiste;

public class JArtistePanel extends JPanel implements IInterfaceSavable{
	
	private Artiste artiste;

	public JArtistePanel(Artiste artiste) {
		this.artiste = artiste;
		final BoxLayout frameBoxLayout = new BoxLayout(this, BoxLayout.Y_AXIS);
		setLayout(frameBoxLayout);
		panneauEdition();
	}

	private void panneauEdition() {
		JPanel panneauEditionArtiste = new JPanel();
		panneauEditionArtiste.setBorder(BorderFactory
				.createTitledBorder("Gestion"));

		JLabel artisteNameLabel = new JLabel("Nom : ");
		JTextField artisteNameField = new JTextField(artiste.getNom());
		
		JLabel artisteFirstNameLabel = new JLabel("Prenom : ");
		JTextField artisteFirstNameField = new JTextField(artiste.getPrenom());

		JLabel genreLabel = new JLabel("Genre : ");
		JTextField genreField = new JTextField();
		
		JLabel dateNaissanceLabel = new JLabel("Date de naissance");
		SpinnerDateModel model = new SpinnerDateModel(artiste.getDateNaissance(), new Date(-1000, 1, 1), new Date(1000, 1, 1), Calendar.DAY_OF_YEAR);
		JSpinner dateNaissance = new JSpinner(model);
		dateNaissance.setEditor(new JSpinner.DateEditor(dateNaissance, "MM/dd/yy"));

		GroupLayout layout = new GroupLayout(panneauEditionArtiste);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);

		panneauEditionArtiste.setLayout(layout);
		GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();
		hGroup.addGroup(layout.createParallelGroup()
				.addComponent(artisteNameLabel)
				.addComponent(artisteFirstNameLabel)
				.addComponent(genreLabel)
				.addComponent(dateNaissanceLabel));
		hGroup.addGroup(layout.createParallelGroup()
				.addComponent(artisteNameField)
				.addComponent(artisteFirstNameField)
				.addComponent(genreField)
				.addComponent(dateNaissance));
		
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
		vGroup.addGroup(layout.createParallelGroup(Alignment.BASELINE)
				.addComponent(dateNaissanceLabel)
				.addComponent(dateNaissance));
		layout.setVerticalGroup(vGroup);

		add(panneauEditionArtiste);
	}
	
	public void save() {
		
	}

	@Override
	public void saveObject() {
		
	}

}
