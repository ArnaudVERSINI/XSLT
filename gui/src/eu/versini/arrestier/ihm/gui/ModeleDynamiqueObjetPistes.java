package eu.versini.arrestier.ihm.gui;


import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;
import eu.versini.arrestier.ihm.metier.Piste;

public class ModeleDynamiqueObjetPistes extends AbstractTableModel {
    private List<Piste> pistes = new ArrayList<Piste>();

    private String[] entetes = {"Numéro", "Titre", "Durée"};

    public ModeleDynamiqueObjetPistes(ArrayList<Piste> _pistes) {
        super();
        this.pistes = _pistes ;
    }

    public int getRowCount() {
        return pistes.size();
    }

    public int getColumnCount() {
        return entetes.length;
    }

    public String getColumnName(int columnIndex) {
        return entetes[columnIndex];
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return pistes.get(rowIndex).getNumero();
            case 1:
                return pistes.get(rowIndex).getTitre();
            case 2:
                return pistes.get(rowIndex).getDuree();
            default:
            	return null; //Ne devrait jamais arriver
        }
    }

    public void addPiste(Piste piste) {
        pistes.add(piste);

        fireTableRowsInserted(pistes.size() -1, pistes.size() -1);
    }

    public void removePiste(int rowIndex) {
        pistes.remove(rowIndex);

        fireTableRowsDeleted(rowIndex, rowIndex);
    }
}
