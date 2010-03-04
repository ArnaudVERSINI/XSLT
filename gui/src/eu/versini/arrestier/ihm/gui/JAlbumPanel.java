package eu.versini.arrestier.ihm.gui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.event.ListDataListener;

import eu.versini.arrestier.ihm.metier.Album;
import eu.versini.arrestier.ihm.metier.Artiste;
import eu.versini.arrestier.ihm.metier.Piste;


public class JAlbumPanel extends JPanel implements IInterfaceSavable{
	
	private Album album;
	
	HashMap<String, Artiste> listeArtiste ;

	public JAlbumPanel(Album album, HashMap<String, Artiste> listeArtiste) {
		this.album = album;
		this.listeArtiste = listeArtiste ;
		final BoxLayout frameBoxLayout = new BoxLayout(this, BoxLayout.Y_AXIS);
		setLayout(frameBoxLayout);
		panneauEdition();
	}

	public JAlbumPanel() {
		// TODO Auto-generated constructor stub
		panneauEdition();
	}

	public void panneauEdition() {
		JPanel panneauEditionAlbum = new JPanel();
		final JPistesPanel panneauPistes = new JPistesPanel(album.getPistes());
		
		panneauEditionAlbum.setBorder(BorderFactory
				.createTitledBorder("Informations album"));

		JLabel titreLabel = new JLabel("Titre : ");
		final JTextField titreField = new JTextField(album.getTitre());
		titreField.addFocusListener(new FocusAdapter() {
		    String lastChange = "";
		    public void focusLost(FocusEvent evt) {
		        String currentText = titreField.getText();
		        if(!lastChange.equals(currentText) ){
		            album.setTitre(currentText);
		        }
		    }        
		});

		JLabel anneeLabel = new JLabel("Annee : ");
		final JTextField anneeField = new JTextField(album.getAnnee());
		anneeField.addFocusListener(new FocusAdapter() {
		    String lastChange = "";
		    public void focusLost(FocusEvent evt) {
		        String currentText = anneeField.getText();
		        if(!lastChange.equals(currentText) ){
		            album.setAnnee(currentText);
		        }
		    }        
		});
		
		// TODO FA combobox
		DefaultComboBoxModel modeleCombo = new DefaultComboBoxModel()  ;
		
		ArrayList<Artiste> lArtistes = new ArrayList<Artiste>(listeArtiste.values());
		modeleCombo.addElement(album.getNomArtiste()+ " " + album.getPrenomArtiste() );
		for (Artiste unArtiste : lArtistes) {
			if (unArtiste != null && unArtiste.getIdArtiste() != album.getIdArtiste()) {
				modeleCombo.addElement(unArtiste);
			}
		}
		
		
		
		JLabel artisteLabel = new JLabel("Artiste : ");
		//JTextField artisteField = new JTextField(album.getPrenomArtiste() + " " + album.getNomArtiste());
		JComboBox artisteField = new JComboBox(modeleCombo) ;

		JLabel supportLabel = new JLabel("Support : ");
		final JTextField supportField = new JTextField(album.getSupport());
		supportField.addFocusListener(new FocusAdapter() {
		    String lastChange = "";
		    public void focusLost(FocusEvent evt) {
		        String currentText = supportField.getText();
		        if(!lastChange.equals(currentText) ){
		            album.setSupport(currentText);
		        }
		    }        
		});
		
		
		JLabel prixLabel = new JLabel("Prix : ");
		final JTextField prixField = new JTextField(String.valueOf(album.getPrix()));
		prixField.addFocusListener(new FocusAdapter() {
		    String lastChange = "";
		    public void focusLost(FocusEvent evt) {
		        String currentText = prixField.getText();
		        if(!lastChange.equals(currentText) ){      
		            album.setPrix(Double.parseDouble(currentText));
		        }
		    }        
		});
		
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

		
		add(panneauPistes) ;
		
/*	JButton boutonSauver = new JButton("Enregistrer les modifications") ;
		boutonSauver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				album.setTitre(titreField.getText());
				album.setAnnee(anneeField.getText());
				album.setSupport(supportField.getText());
				album.setPrix(Double.parseDouble(prixField.getText()));
				
				List<Piste> pistes = panneauPistes.getModele().getPistes();
				panneauPistes.getModele().
				for (Piste unePiste : pistes) {
					album.getPistes().add(unePiste) ;
				}
				
			}
		});
		add(boutonSauver) ;*/

	}
	
	public void save() {
		
	}

	@Override
	public void saveObject() {
		
	}

	public Album getAlbum() {
		return album;
	}

}
