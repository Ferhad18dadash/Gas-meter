package BasicClasses;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import SQLdatabase.Connect;
import SQLdatabase.IsciDataBase;
import SQLdatabase.AbonentDataBase;

public class AbonentMetodlari {
	static Connection connect = null;
	static PreparedStatement preparedStatement = null;
	static Scanner scan = new Scanner(System.in);
	static ResultSet resultSet = null;
	public static double musteriBorcu;

	public static void musteriGirisi() {
		System.out.println("Sisteme xos geldiniz idni daxil edin");
		int musteriId = scan.nextInt();
		int i = 0;
		while (i <= 2) {
			System.out.println("parolunuzu daxil edin");
			String parol = scan.next();

			if (parol.equals(AbonentDataBase.abonentParolYoxlama(musteriId))) {
				musteriMetodlari(musteriId);
			}
			System.out.println("ad ve yaxud parol sehfdir duzeldin");
			i++;

		}
		System.out.println("parolu sehf yazma limitini kecdiniz");
	}

	public static void odenisEtmek(int musteriId) {
		System.out.println("odenis olunacaq meblegi girin:tam eded olmalidi.");
		double mebleg = scan.nextDouble();
		double yMebleg = AbonentDataBase.abonentBorcu(musteriId) - mebleg;

		IsciDataBase.borcYazma(musteriId, yMebleg);
		System.out.println("odenis ugurla yerine yetirildi");
		System.out.println("sizin hazirki borcunuz" + AbonentDataBase.abonentBorcu(musteriId));
	}

	public static void musteriMetodlari(int musteriId) {
		System.out.println("salam  xos gelmisiniz");
		System.out.println("Sizin hal hazirda borcunuz " + AbonentDataBase.abonentBorcu(musteriId) + "azn teskil edir");

		System.out.println("odenis etmek ucun 1, parolu deyismek ucun 2 u secin,cixmaq ucun 3 duymesine basin");
		int oec = scan.nextInt();
		if (oec == 1) {
			odenisEtmek(musteriId);
		}
		if (oec == 2) {
			System.out.println("parolunuzu girin");
			String nParol = scan.next();
			AbonentDataBase.musteriParoluDeyis(musteriId, nParol);
		}
		if (oec == 3) {
			System.out.println("saqolun");

		}
	}

}
