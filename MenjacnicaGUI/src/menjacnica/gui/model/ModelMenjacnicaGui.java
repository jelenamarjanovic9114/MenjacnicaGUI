package menjacnica.gui.model;

import javax.swing.table.AbstractTableModel;

public class ModelMenjacnicaGui extends AbstractTableModel {
	private String [] kolone = new String [] {"Sifra", "Skraceni naziv", "Prodajni", "Kupovni", "Naziv"};
	
	public ModelMenjacnicaGui() {
	}
	
	@Override
	public int getColumnCount() {
		return kolone.length;
	}

	@Override
	public int getRowCount() {
		return 0;
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getColumnName(int arg0) {
		return kolone[arg0];
	}
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}
	
	
}
