package menjacnica;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class Kurs {
	private GregorianCalendar datumKursa;
	private int sifra;
	private String naziv;
	private String skraceniNaziv;
	private double prodajniKurs;
	private double kupovniKurs;
	private double srednjiKurs;	
	
	public Kurs(GregorianCalendar datumKursa, int sifra, String naziv, String skraceniNaziv, double prodajniKurs,
			double kupovniKurs, double srednjiKurs) {
		super();
		this.datumKursa = datumKursa;
		this.sifra = sifra;
		this.naziv = naziv;
		this.skraceniNaziv = skraceniNaziv;
		this.prodajniKurs = prodajniKurs;
		this.kupovniKurs = kupovniKurs;
		this.srednjiKurs = srednjiKurs;
	}

	public Kurs(){		
	}
	
	public GregorianCalendar getDatumKursa() {
		return datumKursa;
	}
	public void setDatumKursa(GregorianCalendar datumKursa) {
		if(datumKursa == null){
			throw new RuntimeException("Datum kursa ne sme biti null!");
		}
		if(datumKursa.before(new GregorianCalendar())){
			throw new RuntimeException("Datum kursa ne sme biti pre danasnjeg!");
		}
		this.datumKursa = datumKursa;
	}
	public double getProdajniKurs() {
		return prodajniKurs;
	}
	public void setProdajniKurs(double prodajniKurs) {
		if(prodajniKurs < 0){
			throw new RuntimeException("Prodajni kurs mora biti veci od nule!");
		}
		this.prodajniKurs = prodajniKurs;
	}
	public double getKupovniKurs() {
		return kupovniKurs;
	}
	public void setKupovniKurs(double kupovniKurs) {
		if(kupovniKurs < 0){
			throw new RuntimeException("Kupovni kurs mora biti veci od nule!");
		}
		this.kupovniKurs = kupovniKurs;
	}
	public double getSrednjiKurs() {
		return srednjiKurs;
	}
	public void setSrednjiKurs(double srednjiKurs) {
		if(srednjiKurs < 0){
			throw new RuntimeException("Srednji kurs mora biti veci od nule!");
		}
		this.srednjiKurs = srednjiKurs;
	}
	
	public int getSifra() {
		return sifra;
	}

	public void setSifra(int sifra) {
		this.sifra = sifra;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getSkraceniNaziv() {
		return skraceniNaziv;
	}

	public void setSkraceniNaziv(String skraceniNaziv) {
		this.skraceniNaziv = skraceniNaziv;
	}

	@Override
	public String toString() {
		return "Datum kursa: " + new SimpleDateFormat("dd. MMM yyyy.").format(datumKursa) + "\nProdajni kurs: " + prodajniKurs
				+ ("\nKupovni kurs: ") + kupovniKurs + "\nSrednji kurs: " + srednjiKurs;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((datumKursa == null) ? 0 : datumKursa.hashCode());
		long temp;
		temp = Double.doubleToLongBits(kupovniKurs);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(prodajniKurs);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(srednjiKurs);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Kurs other = (Kurs) obj;
		if (datumKursa == null) {
			if (other.datumKursa != null)
				return false;
		} else if (!datumKursa.equals(other.datumKursa))
			return false;
		if (Double.doubleToLongBits(kupovniKurs) != Double.doubleToLongBits(other.kupovniKurs))
			return false;
		if (Double.doubleToLongBits(prodajniKurs) != Double.doubleToLongBits(other.prodajniKurs))
			return false;
		if (Double.doubleToLongBits(srednjiKurs) != Double.doubleToLongBits(other.srednjiKurs))
			return false;
		return true;
	}
	
	
	
}
