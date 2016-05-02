package menjacnica.gui;

import java.awt.EventQueue;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

import menjacnica.Kurs;
import menjacnica.Menjacnica;

public class GUIKontroler {
	private static MenjacnicaGUI prozor;
	private static Menjacnica menjacnica;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menjacnica = new Menjacnica();
					prozor = new MenjacnicaGUI();
					prozor.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void ugasiAplikaciju() {
		int opcija = JOptionPane.showConfirmDialog(prozor.getContentPane(),
				"Da li zelite da zatvorite aplikaciju?", "Izlazak", JOptionPane.YES_NO_OPTION);

		if (opcija == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}
	
	public static void dodajKurs(Kurs k){
		menjacnica.dodajKurs(k);
		prozor.osveziTabelu();
		
	}
	
	public static LinkedList<Kurs> vratiListuKurseva(){
		return menjacnica.vratiKurseve();
	}
	
	public static void pokreniDodajKursGUIProzor(){
		DodajKursGUI prozor = new DodajKursGUI();
		prozor.setVisible(true);
		prozor.setLocationRelativeTo(null);
	}
	
	public static void pokreniIzvrsiIzmenuProzor(){
		IzvrsiZamenuGUI prozor = new IzvrsiZamenuGUI();
		prozor.setVisible(true);
		prozor.setLocationRelativeTo(null);
	}
	
	public static void upozoriDaBiraRed() {
		JOptionPane.showMessageDialog(prozor.getContentPane(), "Izaberite kurs za brisanje iz tabele!",
				"Greska", JOptionPane.ERROR_MESSAGE);
	}
	
	
	public static void obrisiKurs(Kurs k){
		menjacnica.izbrisiKurs(k);
		prozor.osveziTabelu();
	}
	
	public static void dodajUtextArea(String s){
		prozor.dodajUTextArea(s);
	}
	
}
