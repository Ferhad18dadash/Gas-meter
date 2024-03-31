package BasicClasses;

import java.util.Scanner;

import SQLdatabase.IsciDataBase;

public class mainClassss {

	public static void main(String[] args) {
		System.out.println(IsciDataBase.limitYoxlama(15));
		Scanner scan = new Scanner(System.in);
		System.out.println("Sisteme xos gemisiniz musteri ucun 1 isci ucun 2 duymesini secin");
		int mi = scan.nextInt();
		if (mi == 1) {
			AbonentMetodlari.musteriGirisi();

		}

		if (mi == 2) {
			IsciMetodlari.isciGirisi();
		} else {
			System.out.println("sistemden cixdiniz");
		}

	}
}