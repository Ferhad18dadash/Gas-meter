package BasicClasses;

import java.util.Scanner;

public class Musteri {
	private int mId;
	private String nameSurname;
	private String password;
	private double cast;

	public Musteri(String nameSurname) {
		this.nameSurname = nameSurname;
	}

	public int getId() {
		return mId;
	}

	public void setId(int id) {
		this.mId = id;
	}

	public String getNameSurname() {
		return nameSurname;
	}

	public void setNameSurname(String nameSurname) {
		this.nameSurname = nameSurname;
	}

	public double getCast() {
		return cast;
	}

	public void setCast(double cast) {
		this.cast = cast;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

}
