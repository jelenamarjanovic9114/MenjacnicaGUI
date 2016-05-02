package menjacnica.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class IzvrsiZamenuGUI extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblKupovniKurs;
	private JTextField kupovniKursTextField;
	private JComboBox valutaComboBox;
	private JLabel lblProdajniKurs;
	private JTextField prodajniKursTextField;
	private JLabel lblIznos;
	private JTextField iznosTextField;
	private JLabel lblVrstaTransakcije;
	private JRadioButton rdbtnKupovina;
	private JRadioButton rdbtnProdaja;
	private JSlider slider;
	private JButton btnIzvrsiIzmenu;
	private JButton btnOdustani;
	private final ButtonGroup buttonGroup = new ButtonGroup();


	/**
	 * Create the frame.
	 */
	public IzvrsiZamenuGUI() {
		setResizable(false);
		setTitle("Izvrsi zamenu");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 423, 305);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getPanel(), BorderLayout.CENTER);
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(null);
			panel.add(getLblKupovniKurs());
			panel.add(getKupovniKursTextField());
			panel.add(getValutaComboBox());
			panel.add(getLblProdajniKurs());
			panel.add(getProdajniKursTextField());
			panel.add(getLblIznos());
			panel.add(getIznosTextField());
			panel.add(getLblVrstaTransakcije());
			panel.add(getRdbtnKupovina());
			panel.add(getRdbtnProdaja());
			panel.add(getSlider());
			panel.add(getBtnIzvrsiIzmenu());
			panel.add(getBtnOdustani());
		}
		return panel;
	}
	private JLabel getLblKupovniKurs() {
		if (lblKupovniKurs == null) {
			lblKupovniKurs = new JLabel("Kupovni kurs");
			lblKupovniKurs.setBounds(10, 13, 84, 14);
		}
		return lblKupovniKurs;
	}
	private JTextField getKupovniKursTextField() {
		if (kupovniKursTextField == null) {
			kupovniKursTextField = new JTextField();
			kupovniKursTextField.setEditable(false);
			kupovniKursTextField.setBounds(10, 36, 86, 20);
			kupovniKursTextField.setColumns(10);
		}
		return kupovniKursTextField;
	}
	private JComboBox getValutaComboBox() {
		if (valutaComboBox == null) {
			valutaComboBox = new JComboBox();
			valutaComboBox.setModel(new DefaultComboBoxModel(new String[] {"EUR", "USD", "CHF"}));
			valutaComboBox.setSelectedIndex(0);
			valutaComboBox.setBounds(152, 36, 71, 20);
		}
		return valutaComboBox;
	}
	private JLabel getLblProdajniKurs() {
		if (lblProdajniKurs == null) {
			lblProdajniKurs = new JLabel("Prodajni kurs");
			lblProdajniKurs.setBounds(286, 13, 84, 14);
		}
		return lblProdajniKurs;
	}
	private JTextField getProdajniKursTextField() {
		if (prodajniKursTextField == null) {
			prodajniKursTextField = new JTextField();
			prodajniKursTextField.setEditable(false);
			prodajniKursTextField.setColumns(10);
			prodajniKursTextField.setBounds(281, 36, 86, 20);
		}
		return prodajniKursTextField;
	}
	private JLabel getLblIznos() {
		if (lblIznos == null) {
			lblIznos = new JLabel("Iznos");
			lblIznos.setBounds(10, 97, 46, 14);
		}
		return lblIznos;
	}
	private JTextField getIznosTextField() {
		if (iznosTextField == null) {
			iznosTextField = new JTextField();
			iznosTextField.setBounds(10, 122, 86, 20);
			iznosTextField.setColumns(10);
		}
		return iznosTextField;
	}
	private JLabel getLblVrstaTransakcije() {
		if (lblVrstaTransakcije == null) {
			lblVrstaTransakcije = new JLabel("Vrsta transakcije");
			lblVrstaTransakcije.setBounds(216, 67, 101, 14);
		}
		return lblVrstaTransakcije;
	}
	private JRadioButton getRdbtnKupovina() {
		if (rdbtnKupovina == null) {
			rdbtnKupovina = new JRadioButton("Kupovina");
			buttonGroup.add(rdbtnKupovina);
			rdbtnKupovina.setBounds(205, 90, 109, 23);
		}
		return rdbtnKupovina;
	}
	private JRadioButton getRdbtnProdaja() {
		if (rdbtnProdaja == null) {
			rdbtnProdaja = new JRadioButton("Prodaja");
			buttonGroup.add(rdbtnProdaja);
			rdbtnProdaja.setBounds(205, 119, 109, 23);
		}
		return rdbtnProdaja;
	}
	private JSlider getSlider() {
		if (slider == null) {
			slider = new JSlider();
			slider.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent arg0) {
					String s = Integer.toString(slider.getValue());
					iznosTextField.setText(s);
				}
			});
			slider.setBounds(10, 190, 369, 26);
			slider.setMaximum(100);
		}
		return slider;
	}
	private JButton getBtnIzvrsiIzmenu() {
		if (btnIzvrsiIzmenu == null) {
			btnIzvrsiIzmenu = new JButton("Izvrsi izmenu");
			btnIzvrsiIzmenu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIKontroler.dodajUtextArea(vratiInfo());
				}
			});
			btnIzvrsiIzmenu.setPreferredSize(new Dimension(130, 30));
			btnIzvrsiIzmenu.setBounds(50, 227, 130, 23);
		}
		return btnIzvrsiIzmenu;
	}
	private JButton getBtnOdustani() {
		if (btnOdustani == null) {
			btnOdustani = new JButton("Odustani");
			btnOdustani.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnOdustani.setPreferredSize(new Dimension(130, 30));
			btnOdustani.setBounds(228, 227, 125, 23);
		}
		return btnOdustani;
	}
	
	private String vratiInfo(){
		String nazivValute = valutaComboBox.getSelectedItem().toString();
		String iznos = iznosTextField.getText();
		String kupovniProdajni;
		if(rdbtnKupovina.isSelected()){
			kupovniProdajni = "Kupovni";
		}else if(rdbtnProdaja.isSelected()){
			kupovniProdajni = "Prodajni";
		}else kupovniProdajni = "NN";
		return nazivValute + ": Iznos " + iznos + "\t" + kupovniProdajni;
	}
}
