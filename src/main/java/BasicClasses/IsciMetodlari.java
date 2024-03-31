package BasicClasses;

import java.util.Scanner;

import SQLdatabase.IsciDataBase;

public class IsciMetodlari {
	static Scanner scan = new Scanner(System.in);

	public static void isciGirisi() {

		System.out.println(
				"Yeni isci ucun qeydiyyatdan kecmekden otru 1,movcud iscinin hesabina daxil olmaq ucun  2 duymesini secin");
		int yM = scan.nextInt();
		if (yM == 1) {
			isciYarat();
		}
		if (yM == 2) {
			isciMetods();
		}

	}

	public static void isciYarat() {
		System.out.println("adinizi daxil  edin");
		String adSoyad = scan.next();
		System.out.println("Parol yaradin");
		String parol = scan.next();
		Isci isci = new Isci(adSoyad, parol);
		IsciDataBase.isciYukle(isci);
	}

	public static void abonentYukle() {
		System.out.println("abonentin melumatlarin girin adisoyadi,parol,borcu\n ara boslugu olmaz!");
		String adi = scan.next();
		String parol = scan.next();
		Double cast = scan.nextDouble();

		IsciDataBase.AbonentiYukle(adi, parol, cast);
	}

	public static void abonentBorcu() {
		while (true) {
			System.out.println("Abonentin id-sin girin");
			int ids = scan.nextInt();
			System.out.println("Abonentin isdifade etdiyi qazin hecmini girin girin");
			int cast = scan.nextInt();

			IsciDataBase.borcYazma(ids, borcHesablama(ids, cast));
			System.out.println("sisteme ugurla qeyd olundu ,cixmaq ucun 1,davam ucun 2 secin");
			int cd = scan.nextInt();
			if (cd == 1) {
				break;
			}
		}
	}

	public static void isciMetods() {
		System.out.println("Sisteme xos geldiniz\n id nomrenizi girin");
		int id = scan.nextInt();
		int i = 0;
		System.out.println("Parolu girin");
		while (true) {
			String prl = scan.next();
			if (prl.equals(IsciDataBase.isciParolYoxlama(id))) {
				System.out.println("abonenti yaratmag ucun 1,cek yazmaq ucun 2 secin");
				int my = scan.nextInt();
				if (my == 1) {
					abonentYukle();
					break;
				}
				if (my == 2) {
					abonentBorcu();
					break;
				}

			}
			if (i == 2) {
				System.out.println("parolu sehf yazma limitini kecdiniz");
				break;
			} else {
				System.out.println("ad ve yaxud parol yanlisdir\n yeniden cehd edin");
				i++;

			}

		}
		System.out.println("prossesler qeyd olundu");

	}

	public static double borcHesablama(int id, int cast2) {
		int limit = IsciDataBase.limitYoxlama(id);
		double cast;
		if (limit < 1200) {
			cast = cast2 * 0.12;
		} else if (1200 < limit && limit < 2500) {
			cast = cast2 * 0.20;
		} else {
			cast = cast2 * 0.25;
		}
		int cast3 = limit + cast2;
		IsciDataBase.limitArtir(cast3, id);
		return cast;

	}

}
