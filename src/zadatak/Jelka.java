package zadatak;

import java.nio.file.Files;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Jelka {
	private int id;
	private int visinaJelke;
	private String nazivProizvodjaca;
	private int raspolozivaKolicina;
	private double cenaJelke;
	private String tipJelke;
	private String kategorija;
	
	public Jelka() {
		super();
	}
	public Jelka(int id, int visinaJelke, String nazivProizvodjaca, int raspolozivaKolicina, double cenaJelke,
			String tipJelke, String kategorija) {
		super();
		this.id = id;
		this.visinaJelke = visinaJelke;
		this.nazivProizvodjaca = nazivProizvodjaca;
		this.raspolozivaKolicina = raspolozivaKolicina;
		this.cenaJelke = cenaJelke;
		this.tipJelke = tipJelke;
		this.kategorija = kategorija;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getVisinaJelke() {
		return visinaJelke;
	}
	public void setVisinaJelke(int visinaJelke) {
		this.visinaJelke = visinaJelke;
	}
	public String getNazivProizvodjaca() {
		return nazivProizvodjaca;
	}
	public void setNazivProizvodjaca(String nazivProizvodjaca) {
		this.nazivProizvodjaca = nazivProizvodjaca;
	}
	public int getRaspolozivaKolicina() {
		return raspolozivaKolicina;
	}
	public void setRaspolozivaKolicina(int raspolozivaKolicina) {
		this.raspolozivaKolicina = raspolozivaKolicina;
	}
	public double getCenaJelke() {
		return cenaJelke;
	}
	public void setCenaJelke(double cenaJelke) {
		this.cenaJelke = cenaJelke;
	}
	public String getTipJelke() {
		return tipJelke;
	}
	public void setTipJelke(String tipJelke) {
		this.tipJelke = tipJelke;
	}
	public String getKategorija() {
		return kategorija;
	}
	public void setKategorija(String kategorija) {
		this.kategorija = kategorija;
	}
	public String toString() {
		String podaci = "";
		podaci += "ID: " + id + " | ";
		podaci += "Visina: " + visinaJelke + " | ";
		podaci += "Naziv proizvodjaca: " + nazivProizvodjaca + " | ";
		podaci += "Raspoloziva kolicina: " + raspolozivaKolicina + " | ";
		podaci += "Cena:" + cenaJelke + " | ";
		podaci += "Tip: " + tipJelke + " | ";
		podaci += "Kategorija: " + kategorija + "\n";
		return podaci;
	}
	//////////////////////////////////////////////////////////////////////////
	

	
	
}
