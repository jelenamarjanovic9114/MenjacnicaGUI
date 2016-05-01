package menjacnica;

import java.util.LinkedList;
import java.util.List;

public class Menjacnica {
	private List<Kurs> kursevi;
	
	public Menjacnica(List<Kurs> k){
		kursevi = k;
	}
	
	public Menjacnica(){
		kursevi = new LinkedList<>();
	}
	
	public LinkedList<Kurs> vratiKurseve(){
		return (LinkedList<Kurs>) kursevi;
	}
	
	public void dodajKurs(Kurs k){
		kursevi.add(k);
	}
}
