package eu.versini.arrestier.ihm.gui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import eu.versini.arrestier.ihm.metier.Piste;

public class JTableBasiqueAvecModeleDynamiqueObjet extends JPanel {
    private ModeleDynamiqueObjetPistes modele ;
    private JTable tableau;

    public JTableBasiqueAvecModeleDynamiqueObjet(ArrayList<Piste> _pistes) {
    	
    	this.setBorder(BorderFactory
				.createTitledBorder("Informations pistes"));
    	modele = new ModeleDynamiqueObjetPistes(_pistes) ;
		final BoxLayout frameBoxLayout = new BoxLayout(this, BoxLayout.Y_AXIS);
		setLayout(frameBoxLayout);

        tableau = new JTable(modele);
        
        add(new JScrollPane(tableau), BorderLayout.CENTER);

        JPanel boutons = new JPanel();

        boutons.add(new JButton(new AddAction()));
        boutons.add(new JButton(new RemoveAction()));

       add(boutons, BorderLayout.SOUTH);

    }

    private class AddAction extends AbstractAction {
        private AddAction() {
            super("Ajouter");
        }

        public void actionPerformed(ActionEvent e) {
            modele.addPiste(new Piste());
        }
    }

    private class RemoveAction extends AbstractAction {
        private RemoveAction() {
            super("Supprimmer");
        }

        public void actionPerformed(ActionEvent e) {
            int[] selection = tableau.getSelectedRows();
            
            for(int i = selection.length - 1; i >= 0; i--){
                modele.removePiste(selection[i]);
            }
        }
    }
}

