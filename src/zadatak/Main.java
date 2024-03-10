package zadatak;

import java.util.Scanner;

public class Main {
	
	public static Scanner sc = new Scanner(System.in);
	public static boolean novaRadnja(Radnja prodavnica) {
		try {
			String ime;
			do {
				System.out.println("Unesite ime radnje:");
				ime = sc.nextLine();
			} while (ime.equals(""));
			String adresa;
			do {
				System.out.println("Unesite adresu radnje:");
				adresa = sc.nextLine();
			} while (adresa.equals(""));
			String broj;
			do {
				System.out.println("Unesite broj telefona radnje:");
				broj = sc.nextLine();
			} while (broj.equals("")); 
			prodavnica.setNazivRadnje(ime);
			prodavnica.setAdresaRadnje(adresa);
			prodavnica.setBrojTelefona(broj);
			System.out.println("Uspesno kreirana radnja.");
			return true;
		} catch (Exception e) {
			System.err.println("Neuspesno kreirana radnja");
			e.printStackTrace();
			return false;
		}

	}
	public static boolean isNumber(String string) {

		try {
			Long.parseLong(string);
			return true;
		} catch (Exception e) {
			return false;
		}

	}
	public static boolean proveraTipa(String string) {
		if(string.equalsIgnoreCase("posecena")) {
			return true;
		}
		else if(string.equalsIgnoreCase("sa busenom")) {
			return true;

		}
		else if(string.equalsIgnoreCase("plasticna")) {
			return true;

		}
		else if(string.equalsIgnoreCase("plasticna-bela")) {
			return true;
		}
		else {
			return false;
		}
	}
	public static boolean proveraKategorije(String string) {
		if(string.equalsIgnoreCase("standard")) {
			return true;
		}
		else if(string.equalsIgnoreCase("lux")) {
			return true;

		}
		else if(string.equalsIgnoreCase("premium")) {
			return true;
		}
		else {
			return false;
		}
	}
	public static boolean unosNoveJelke(Radnja prodavnica) {
		String visina;
		String naziv;
		double cena;
		String tip;
		String kategorija;
		
		String id2;
		do {
			System.out.println("Unesite id jelke:");
			id2 = sc.nextLine();
		} while (!isNumber(id2));
		int id = Integer.parseInt(id2);
		do {
			System.out.println("Unesite visinu jelke:");
			visina = sc.nextLine();
		} while (!isNumber(visina));
		int visina2 = Integer.parseInt(visina);
		
		System.out.println("Unesite naziv proizvodjaca: ");
		naziv = sc.nextLine();
		String kolicina;
		do {
			System.out.println("Unesite kolicinu:");
			kolicina = sc.nextLine();
		} while (!isNumber(kolicina));
		int kolicina2 = Integer.parseInt(kolicina);
		String cena2;
		do {
			System.out.println("Unesite cenu jelke:");
			cena2 = sc.nextLine();
		} while (!isNumber(cena2) && !(cena2.length()>3));
		cena = Double.parseDouble(cena2);
		do {
			System.out.println("Unesite tip jelke:");
			tip = sc.nextLine();
		} while (!proveraTipa(tip));
		do {
			System.out.println("Unesite kategoriju jelke:");
			kategorija = sc.nextLine();
		} while (!proveraKategorije(kategorija));
		try {
			Jelka nova = new Jelka(id,visina2,naziv,kolicina2,cena,tip,kategorija);
			prodavnica.dodavanjeJelki(nova);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static void main(String[] args) {
		Radnja prodavnica = new Radnja();
		String opcija;
		do {
			System.out.println("~~~~~~~~~~~MENI~~~~~~~~~~~");
			System.out.println("1. Unos podataka o novoj radnji");
			System.out.println("2. Unos nove jelke");
			System.out.println("3. Ispis podataka o radnji");
			System.out.println("4. Izmena podataka o jelci");
			System.out.println("5. Brisanje jelke");
			System.out.println("6. Pretraga jelki po proizvodjacu");
			System.out.println("7. Pretraga jelki po visini i ceni");
			System.out.println("8. Prosecna cena jelke odredjenog tipa i kategorije");
			System.out.println("9. Pretraga jelki skupljih od prosecne cene jelke odredjenog tipa i kategorije");
			System.out.println("10. Ispis podataka o radnji");
			System.out.println("101. Save");
			System.out.println("404. Load");
			System.out.println("x. Exit");
			System.out.print("Izaberite opciju: ");
			opcija = sc.nextLine();
			switch (opcija) {
			case "1":
				novaRadnja(prodavnica);
				break;
			case "2":
				unosNoveJelke(prodavnica);
				break;
			case "3":
				prodavnica.ispisJelki();
				break;
			case "4":
				String idd;
				do {
					System.out.println("Unesite ID jelke koju zelite da izmenite:");
					idd = sc.nextLine();
				} while (!isNumber(idd));
				int idd2 = Integer.parseInt(idd);
				prodavnica.izmenaJelke(idd2);
				break;
			case "5":
				String iddd;
				do {
					System.out.println("Unesite ID jelke koju zelite da izbrisete:");
					iddd = sc.nextLine();
				} while (!isNumber(iddd));
				int iddd2 = Integer.parseInt(iddd);
				prodavnica.brisanjeJelke(iddd2);
				break;
			case "6":
				System.out.println("Unesite ime proizvodjaca:");
				String tekst = sc.nextLine();
				prodavnica.pretragaJelkiPoProizvodjacu(tekst);
				break;
			case "7":
				String visina1;
				do {
					System.out.println("Unesite minimalnu visinu");
					visina1 = sc.nextLine();
				} while (!isNumber(visina1));
				int visinaINT = Integer.parseInt(visina1);
				String visina2;
				do {
					System.out.println("Unesite maximalnu visinu");
					visina2 = sc.nextLine();
				} while (!isNumber(visina2));
				int visina2INT = Integer.parseInt(visina2);
				String cena1;
				do {
					System.out.println("Unesite minimalnu cenu");
					cena1 = sc.nextLine();
				} while (!isNumber(cena1));
				double cenaINT = Double.parseDouble(cena1);
				String cena2;
				do {
					System.out.println("Unesite maximalnu cenu");
					cena2 = sc.nextLine();
				} while (!isNumber(cena2));
				int cena2INT = Integer.parseInt(cena2);
				prodavnica.pretragaJelki7(visinaINT, visina2INT, cenaINT, cena2INT);
				break;
			case "8":
				String tip;
				do {
					System.out.println("Unesite tip jelke:");
					tip = sc.nextLine();
				} while (!proveraTipa(tip));
				String kat;
				do {
					System.out.println("Unesite kategoriju:");
					kat = sc.nextLine();
				} while (!proveraKategorije(kat));
				prodavnica.prosecnaJelka(tip, kat);
				break;
			case "9":
				String tip2;
				do {
					System.out.println("Unesite tip jelke:");
					tip2 = sc.nextLine();
				} while (!proveraTipa(tip2));
				String kat2;
				do {
					System.out.println("Unesite kategoriju:");
					kat2 = sc.nextLine();
				} while (!proveraKategorije(kat2));
				prodavnica.pretraga9(tip2, kat2);
				break;
			case "10":
				String tekstt = "";
				tekstt +="Naziv radnje: "+ prodavnica.getNazivRadnje() + "\n";
				tekstt +="Adresa radnje: "+ prodavnica.getAdresaRadnje() + "\n";
				tekstt +="Broj telefona radnje: "+ prodavnica.getBrojTelefona() + "\n";

				System.out.println(tekstt);
				prodavnica.ukupnaVrednost();
				break;
			case "101":
				prodavnica.save("radnja.txt");
				break;
			case "404":
				prodavnica.load("radnja.txt");
				break;
			default:
				break;
			}
			
			
		}while(!opcija.equals("x"));
		
		
		sc.close();

	}

}
