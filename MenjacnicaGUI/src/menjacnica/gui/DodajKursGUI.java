package menjacnica.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import menjacnica.Kurs;
import menjacnica.gui.model.ModelMenjacnicaGui;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DodajKursGUI extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblSifra;
	private JLabel lblNaziv;
	private JLabel lblProdajniKurs;
	private JLabel lblKupovniKurs;
	private JLabel lblSrednjiKurs;
	private JLabel lblSkraceniNaziv;
	private JTextField sifraTextField;
	private JTextField nazivTextField;
	private JTextField kupovniTextField;
	private JTextField prodajniTextField;
	private JTextField srednjiTextField;
	private JTextField skraceniNazivTextField;
	private JButton btnDodaj;
	private JButton btnOdustani;

	

	/**
	 * Create the frame.
	 */
	public DodajKursGUI() {
		setTitle("Dodaj kurs");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 368, 273);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getPanel(), BorderLayout.CENTER);
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBorder(new EmptyBorder(0, 0, 0, 0));
			panel.setLayout(new GridLayout(7, 2, 10 , 5));
			panel.add(getLblSifra());
			panel.add(getLblNaziv());
			panel.add(getSifraTextField());
			panel.add(getNazivTextField());
			panel.add(getLblProdajniKurs());
			panel.add(getLblKupovniKurs());
			panel.add(getProdajniTextField());
			panel.add(getKupovniTextField());
			panel.add(getLblSrednjiKurs());
			panel.add(getLblSkraceniNaziv());
			panel.add(getSrednjiTextField());
			panel.add(getSkraceniNazivTextField());
			panel.add(getBtnDodaj());
			panel.add(getBtnOdustani());
		}
		return panel;
	}
	private JLabel getLblSifra() {
		if (lblSifra == null) {
			lblSifra = new JLabel("Sifra");
		}
		return lblSifra;
	}
	private JLabel getLblNaziv() {
		if (lblNaziv == null) {
			lblNaziv = new JLabel("Naziv");
		}
		return lblNaziv;
	}
	private JLabel getLblProdajniKurs() {
		if (lblProdajniKurs == null) {
			lblProdajniKurs = new JLabel("Prodajni kurs");
		}
		return lblProdajniKurs;
	}
	private JLabel getLblKupovniKurs() {
		if (lblKupovniKurs == null) {
			lblKupovniKurs = new JLabel("Kupovni kurs");
		}
		return lblKupovniKurs;
	}
	private JLabel getLblSrednjiKurs() {
		if (lblSrednjiKurs == null) {
			lblSrednjiKurs = new JLabel("Srednji kurs");
		}
		return lblSrednjiKurs;
	}
	private JLabel getLblSkraceniNaziv() {
		if (lblSkraceniNaziv == null) {
			lblSkraceniNaziv = new JLabel("Skraceni naziv");
		}
		return lblSkraceniNaziv;
	}
	private JTextField getSifraTextField() {
		if (sifraTextField == null) {
			sifraTextField = new JTextField();
			sifraTextField.setPreferredSize(new Dimension(120, 10));
			sifraTextField.setColumns(10);
		}
		return sifraTextField;
	}
	private JTextField getNazivTextField() {
		if (nazivTextField == null) {
			nazivTextField = new JTextField();
			nazivTextField.setPreferredSize(new Dimension(120, 10));
			nazivTextField.setColumns(10);
		}
		return nazivTextField;
	}
	private JTextField getKupovniTextField() {
		if (kupovniTextField == null) {
			kupovniTextField = new JTextField();
			kupovniTextField.setPreferredSize(new Dimension(120, 10));
			kupovniTextField.setColumns(10);
		}
		return kupovniTextField;
	}
	private JTextField getProdajniTextField() {
		if (prodajniTextField == null) {
			prodajniTextField = new JTextField();
			prodajniTextField.setPreferredSize(new Dimension(120, 10));
			prodajniTextField.setColumns(10);
		}
		return prodajniTextField;
	}
	private JTextField getSrednjiTextField() {
		if (srednjiTextField == null) {
			srednjiTextField = new JTextField();
			srednjiTextField.setPreferredSize(new Dimension(120, 10));
			srednjiTextField.setColumns(10);
		}
		return srednjiTextField;
	}
	private JTextField getSkraceniNazivTextField() {
		if (skraceniNazivTextField == null) {
			skraceniNazivTextField = new JTextField();
			skraceniNazivTextField.setPreferredSize(new Dimension(120, 10));
			skraceniNazivTextField.setColumns(10);
		}
		return skraceniNazivTextField;
	}
	private JButton getBtnDodaj() {
		if (btnDodaj == null) {
			btnDodaj = new JButton("Dodaj");
			btnDodaj.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					MenjacnicaGUI.vratiTextArea().append(vratiKurs());
					Kurs k = new Kurs(Integer.parseInt(sifraTextField.getText()), nazivTextField.getText(), skraceniNazivTextField.getText(),
							Double.parseDouble(prodajniTextField.getText()), Double.parseDouble(kupovniTextField.getText())
							, Double.parseDouble(srednjiTextField.getText()));
					GUIKontroler.dodajKurs(k);
					
				}
			});
		}
		return btnDodaj;
	}
	private JButton getBtnOdustani() {
		if (btnOdustani == null) {
			btnOdustani = new JButton("Odustani");
			btnOdustani.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
				}
			});
		}
		return btnOdustani;
	}
	
	private String vratiKurs(){
		String kurs;
		String naziv = nazivTextField.getText().trim();
		String sifra = sifraTextField.getText().trim();
		String prodajniKurs = prodajniTextField.getText().trim();
		String kupovni = kupovniTextField.getText().trim();
		String srednji = srednjiTextField.getText().trim();
		String skraceniNaziv = skraceniNazivTextField.getText().trim();
		if(naziv != null && sifra !=null && prodajniKurs != null && kupovni != null
				&& srednji != null && skraceniNaziv != null && 
				!naziv.isEmpty() && !sifra.isEmpty() && !prodajniKurs.isEmpty() && !kupovni.isEmpty()
				&& !srednji.isEmpty() && !skraceniNaziv.isEmpty()){
			kurs = sifra + "; " + naziv + "; \nProdajni kurs: " + prodajniKurs + "; \nKupovni kurs: " + kupovni + 
					";\nSrednji kurs: " + srednji + ";\nSkraceni naziv: " + skraceniNaziv;
			
			return kurs;
		} else{
			JOptionPane.showMessageDialog(null, "Text field ne sme biti null!", "Greska", JOptionPane.ERROR_MESSAGE);
			throw new RuntimeException("Text field je null!");
		}
	}
}
