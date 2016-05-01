package menjacnica.gui.model;

import java.util.LinkedList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import menjacnica.Kurs;

public class ModelMenjacnicaGui extends AbstractTableModel {
	private final String [] kolone = new String [] {"Sifra", "Skraceni naziv", "Prodajni", "Kupovni", "Naziv"};
	private List<Kurs> kursevi;
	
	
	public ModelMenjacnicaGui(List<Kurs> kursevi) {
		this.kursevi = kursevi;
	}

	public ModelMenjacnicaGui() {
	}
	
	@Override
	public int getColumnCount() {
		return kolone.length;
	}

	@Override
	public int getRowCount() {
		return kursevi.size();
	}

	@Override
	public Object getValueAt(int row, int column) {
		Kurs k = kursevi.get(row);
		switch(column){
			case 0: return k.getSifra();
			case 1: return k.getSkraceniNaziv();
			case 2:	return k.getProdajniKurs();
			case 3: return k.getKupovniKurs();
			case 4: return k.getNaziv();
			
			default: return "NN";
		}
	}

	@Override
	public String getColumnName(int arg0) {
		return kolone[arg0];
	}
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}
	
	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		if(kursevi.get(rowIndex) == null){
			kursevi.add(rowIndex, new Kurs());
		}
		Kurs k = kursevi.get(rowIndex);
		switch (columnIndex) {
		case 0: k.setSifra((int) aValue);
			break;
		case 1: k.setSkraceniNaziv((String) aValue); 
			break;
		case 2:	k.setProdajniKurs((double) aValue);
			break;
		case 3: k.setKupovniKurs((double) aValue);
			break;
		case 4: k.setNaziv((String) aValue);
			break;

		default:
			break;
		}
	}

	public void staviSveKurseveUModel(LinkedList<Kurs> kursevi) {
		this.kursevi=kursevi;
		fireTableDataChanged();		
	}
	
	public Kurs vratiKurs(int indeks){
		return kursevi.get(indeks);
	}
	
}
