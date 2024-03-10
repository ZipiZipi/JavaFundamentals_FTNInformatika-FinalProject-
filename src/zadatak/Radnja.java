package zadatak;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Radnja {
	private String nazivRadnje;
	private String adresaRadnje;
	private String brojTelefona;
	public ArrayList<Jelka> spisakJelki = new ArrayList<Jelka>();
	public Radnja() {
		nazivRadnje = "";
		adresaRadnje = "";
		brojTelefona = "";
	}
	public Radnja(String nazivRadnje, String adresaRadnje, String brojTelefona) {
		this.nazivRadnje = nazivRadnje;
		this.adresaRadnje = adresaRadnje;
		this.brojTelefona = brojTelefona;
	}
	
	public Radnja(String nazivRadnje, String adresaRadnje, String brojTelefona, ArrayList<Jelka> spisakJelki) {
		this.nazivRadnje = nazivRadnje;
		this.adresaRadnje = adresaRadnje;
		this.brojTelefona = brojTelefona;
		this.spisakJelki = spisakJelki;
	}
	public String getNazivRadnje() {
		return nazivRadnje;
	}
	public void setNazivRadnje(String nazivRadnje) {
		this.nazivRadnje = nazivRadnje;
	}
	public String getAdresaRadnje() {
		return adresaRadnje;
	}
	public void setAdresaRadnje(String adresaRadnje) {
		this.adresaRadnje = adresaRadnje;
	}
	public String getBrojTelefona() {
		return brojTelefona;
	}
	public void setBrojTelefona(String brojTelefona) {
		this.brojTelefona = brojTelefona;
	}
	public ArrayList<Jelka> getSpisakJelki() {
		return spisakJelki;
	}
	public void setSpisakJelki(ArrayList<Jelka> spisakJelki) {
		this.spisakJelki = spisakJelki;
	}
	@Override
	public String toString() {
		String podaci = "";
		podaci += "Naziv radnje: " + getNazivRadnje() + "\n";
		podaci += "Adresa suda: " + getAdresaRadnje() + "\n";
		podaci += "Broj: " + getBrojTelefona() + "\n";
		podaci += "\n";
		podaci += "Spisak jelki:\n";
		for (int i = 0; i < getSpisakJelki().size(); i++) {
			podaci+= i+1 + ". " + spisakJelki.get(i) + "\n";
		}
		return podaci;
	}
	///////////////////////////////////////////////////////// save i load
	public static String nazivFajla = "radnja.txt";
	public static Scanner sc = new Scanner(System.in);
	
	public boolean load(String path) {
	
	List<String> listaPredmeta;
	
	try {
		listaPredmeta = Files.readAllLines(Paths.get(path),Charset.defaultCharset());
		
		for (int i = 0; i < listaPredmeta.size(); i++) {
		
		if (i==0) {
			setNazivRadnje(listaPredmeta.get(i));
			}
		else if(i==1){
			setAdresaRadnje(listaPredmeta.get(i));;
			}
		else if(i==2){
			setBrojTelefona(listaPredmeta.get(i));
			}
		else if(i>2) {
			String predmet = listaPredmeta.get(i);
			String splits[] = predmet.split(";");
			int id = Integer.parseInt(splits[0]);
			int visinaJelke = Integer.parseInt(splits[1]);
			String nazivProizvodjaca = splits[2];
			int kolicina = Integer.parseInt(splits[3]);
			double cena = Double.parseDouble(splits[4]);
			String tip = splits[5];
			String kategorija = splits[6];
			Jelka nova = new Jelka(id, visinaJelke,nazivProizvodjaca,kolicina,cena,tip,kategorija);
			spisakJelki.add(nova);
			}
		}
	} catch (Exception e) {
		System.err.println("SYS: Failed load!");
		e.printStackTrace();
		return false;
	}
		System.err.println("SYS: Loaded!");
		return true;
	}
	
	public boolean save(String path) {

		List<String> listaPredmeta = new ArrayList<String>();
		try {
			listaPredmeta.add(getNazivRadnje());
			listaPredmeta.add(getAdresaRadnje());
			listaPredmeta.add(getBrojTelefona());
			String line = "";
			
			for (int i = 0; i < getSpisakJelki().size(); i++) {	
				line = String.valueOf(spisakJelki.get(i).getId()) + ";";
				line += String.valueOf(spisakJelki.get(i).getVisinaJelke()) + ";";
				line += spisakJelki.get(i).getNazivProizvodjaca() + ";";
				line += String.valueOf(spisakJelki.get(i).getRaspolozivaKolicina()) + ";";
				line += String.valueOf(spisakJelki.get(i).getCenaJelke()) + ";";
				line += spisakJelki.get(i).getTipJelke() + ";";
				line += spisakJelki.get(i).getKategorija() + ";";
				listaPredmeta.add(line);
				//System.out.println(line);
			}
			Files.write(Paths.get(path), listaPredmeta);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("SYS: Failed save!");
			return false;
		}
		System.err.println("SYS: Saved.");
		return true;
	}
	//////////////////////////////////////////////////////////////////
	public boolean dodavanjeJelki(Jelka jelka) {
		try {
			spisakJelki.add(jelka);
			System.err.println("Uspesno dodata jelka.");
			return true;
		} catch (Exception e) {
			System.err.println("Neuspesno dodata jelka!");
			return false;
		}
	}
	public boolean izmenaJelke(int id) {
		for (int i = 0; i < getSpisakJelki().size(); i++) {
			if(spisakJelki.get(i).getId() == id) {
				String visina;
				String naziv;
				double cena;
				String tip;
				String kategorija;
				
				String id2;
				do {
					System.out.println("Unesite id jelke:");
					id2 = sc.nextLine();
				} while (!Main.isNumber(id2));
				int id3 = Integer.parseInt(id2);
				do {
					System.out.println("Unesite visinu jelke:");
					visina = sc.nextLine();
				} while (!Main.isNumber(visina));
				int visina2 = Integer.parseInt(visina);
				
				System.out.println("Unesite naziv proizvodjaca: ");
				naziv = sc.nextLine();
				String kolicina;
				do {
					System.out.println("Unesite kolicinu:");
					kolicina = sc.nextLine();
				} while (!Main.isNumber(kolicina));
				int kolicina2 = Integer.parseInt(kolicina);
				String cena2;
				do {
					System.out.println("Unesite cenu jelke:");
					cena2 = sc.nextLine();
				} while (!Main.isNumber(cena2) && !(cena2.length()>3));
				cena = Double.parseDouble(cena2);
				do {
					System.out.println("Unesite tip jelke:");
					tip = sc.nextLine();
				} while (!Main.proveraTipa(tip));
				do {
					System.out.println("Unesite kategoriju jelke:");
					kategorija = sc.nextLine();
				} while (!Main.proveraKategorije(kategorija));
					spisakJelki.get(i).setId(id3);
					spisakJelki.get(i).setVisinaJelke(visina2);
					spisakJelki.get(i).setNazivProizvodjaca(naziv);
					spisakJelki.get(i).setRaspolozivaKolicina(kolicina2);
					spisakJelki.get(i).setCenaJelke(cena);
					spisakJelki.get(i).setTipJelke(tip);
					spisakJelki.get(i).setKategorija(kategorija);
					System.err.println("Uspesno promenjene informacije.");
					return true;
			}
		}
		return false;
	}
	public boolean brisanjeJelke(int id) {
		boolean ima = false;
		for (int i = 0; i < getSpisakJelki().size(); i++) {
			if(spisakJelki.get(i).getId() == id) {
				ima = true;
				try {
					spisakJelki.remove(i);
					System.err.println("Uspesno obrisana jelka");
					return true;
				} catch (Exception e) {
					System.out.println("Neuspesno brisanje.");
					return false;
					
				}
			}
			
		}
		if(ima == false) {
			System.err.println("Ne postoji jelka sa zadatim IDom.");
			return false;
		}
		return false;
	}
	public boolean pretragaJelkiPoProizvodjacu(String proizvodjac) {
		boolean ima = false;
		for (int i = 0; i < getSpisakJelki().size(); i++) {
			if(spisakJelki.get(i).getNazivProizvodjaca().equalsIgnoreCase(proizvodjac)) {
				System.out.println(spisakJelki.get(i));
				ima = true;
			}
			
		}
		if(ima == false) {
			System.err.println("Nema jelki od zadatok proizvodjaca");
			return false;
		}
		else {
			return true;
		}
	}
	public boolean pretragaJelki7(int visina1, int visina2, double cena1, double cena2) {
		boolean ima = false;
		for (int i = 0; i < getSpisakJelki().size(); i++) {
			if((spisakJelki.get(i).getVisinaJelke() >= visina1 
					&& spisakJelki.get(i).getVisinaJelke() <= visina2) ||
					(spisakJelki.get(i).getCenaJelke() >= cena1 
					&& spisakJelki.get(i).getCenaJelke() <= cena2)) {
				System.out.println(spisakJelki.get(i));
				ima = true;
			}
		}
		if(ima == false) {					
			System.out.println("Nema jelki u zadatim opsezima.");
			return false;
		}else {
			return true;
		}
	}
	public boolean prosecnaJelka(String tip, String kategorija) {
		boolean ima = false;
		int broj = 0;
		double suma = 0;
		double prosecnaCena = 0;
		for (int i = 0; i < getSpisakJelki().size(); i++) {
			if(spisakJelki.get(i).getTipJelke().equals(tip) 
					&& spisakJelki.get(i).getKategorija().equals(kategorija)) {
				ima = true;
				broj++;
				suma += spisakJelki.get(i).getCenaJelke();
			}
			
		}
		if(ima == false) {
			System.out.println("Nema jelki u zadatom tipu i kategoriji");
			return false;
		}else{
			prosecnaCena = suma/broj;
			System.out.println("Prosecna cena jelki zadatog tipa i kategorije je: "+prosecnaCena);
			return true;
		}
	}
	public boolean pretraga9(String tip, String kategorija) {
		boolean ima = false;
		int broj = 0;
		double suma = 0;
		double prosecnaCena = 0;
		for (int i = 0; i < getSpisakJelki().size(); i++) {
			if(spisakJelki.get(i).getTipJelke().equals(tip) 
					&& spisakJelki.get(i).getKategorija().equals(kategorija)) {
				ima = true;
				broj++;
				suma += spisakJelki.get(i).getCenaJelke();
			}
		}
		if(ima == false) {
			System.out.println("Nema jelki u zadatom tipu i kategoriji");
			return false;
		}else{
			prosecnaCena = suma/broj;
			for (int i = 0; i < getSpisakJelki().size(); i++) {
				if(spisakJelki.get(i).getCenaJelke()>prosecnaCena) {
					System.out.println(spisakJelki.get(i));
				}
				
			}
			return true;
		}
	}
	public boolean ukupnaVrednost() {
		boolean ima = false;
		double sumaa = 0;
		for (int i = 0; i < getSpisakJelki().size(); i++) {
			sumaa += spisakJelki.get(i).getCenaJelke() * spisakJelki.get(i).getRaspolozivaKolicina();
			ima = true;
		}
		if(ima == false) {
			System.out.println("Nema jelki u prodavnici.");
			return false;
		}
		else {
			System.out.println("Ukupna vrednost jelki u radnji: "+ sumaa);
			return true;
		}
		
	}
	public boolean ispisJelki() {
		boolean ima = false;
		for (int i = 0; i < getSpisakJelki().size(); i++) {
			ima = true;
			System.out.println(spisakJelki.get(i));
		}
		if(ima == false) {
			System.out.println("Nema jelki u radnji");
			return false;
		}else {
			return true;
		}
	}
}
