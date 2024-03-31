package BasicClasses;

import java.util.Scanner;

public class Isci {
	private int isciId;
	private String name;
	private String password;

	public Isci(String name, String password) {
		System.out.println("parol yaradin");
		this.password = password;
		this.name = name;

	}

	public int getIsciId() {
		return isciId;
	}

	public void setIsciId(String isciId) {
		isciId = isciId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static void hesabla(Musteri musteri) {
		Scanner scan = new Scanner(System.in);
		double t = 0;
		System.out.println("miqdari girin");
		t = scan.nextInt();
		double task = t * 0.12;
		musteri.setCast(task);
	}
}
