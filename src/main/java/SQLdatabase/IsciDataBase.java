package SQLdatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import BasicClasses.Isci;

public class IsciDataBase {
	static Connection connect = null;
	static PreparedStatement preparedStatement = null;
	static ResultSet resultSet = null;
	static String isciParolu;
	static int musteriLimiti;

	public static void isciYukle(Isci isci) {
		connect = Connect.connect();
		String s = "INSERT INTO isci(isciId,nameSurname,password) VALUES(?,?,?)";
		try {
			preparedStatement = connect.prepareStatement(s);
			preparedStatement.setInt(1, isci.getIsciId());
			preparedStatement.setString(2, isci.getName());
			preparedStatement.setString(3, isci.getPassword());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.err.println("IsciDataBAse.SQL error_1");
			e.printStackTrace();
		}
		Connect.ayrilmaq(connect, preparedStatement);
	}

	public static String isciParolYoxlama(int id) {
		connect = Connect.connect();
		String s = "SELECT password FROM isci WHERE isciId = ?";
		try {
			preparedStatement = connect.prepareStatement(s);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				
				isciParolu = resultSet.getString("password");
			} else {
				System.out.println("ID'ye uygun isci bulunamadi.");
			}
		} catch (SQLException e) {
			System.err.println("IsciDataBAse.SQL error_2");
			e.printStackTrace();
		}
		Connect.ayrilmaq(connect, preparedStatement);
		resultSet = null;
		return isciParolu;
	}

	public static void borcYazma(int id, double cem) {
		connect = Connect.connect();
		String s = "UPDATE musteri SET cast = ? WHERE mId = ?";
		try {
			preparedStatement = connect.prepareStatement(s);
			preparedStatement.setDouble(1, cem);
			preparedStatement.setInt(2, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.err.println("IsciDataBAse.SQL error_3");
			e.printStackTrace();
		}
		Connect.ayrilmaq(connect, preparedStatement);

	}

	public static void AbonentiYukle(String name, String password, Double cast) {
		connect = Connect.connect();
		String s = "INSERT INTO musteri(nameSurname,password,cast) VALUES(?,?,?)";
		try {
			preparedStatement = connect.prepareStatement(s);
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, password);
			preparedStatement.setDouble(3, cast);

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.err.println("IsciDataBAse.SQL error_4");
			e.printStackTrace();
		}
		
		Connect.ayrilmaq(connect, preparedStatement);
	}

	public static int limitYoxlama(int id) {
		connect = Connect.connect();
		String s = "SELECT limits FROM musteri WHERE mId = ?";//SELECT password FROM isci WHERE isciId = ?
		try {
			preparedStatement = connect.prepareStatement(s);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				// İşçi adını alabiliriz
				musteriLimiti = resultSet.getInt("limits");
			} else {
				System.out.println("ID'ye uygun isci bulunamadi.");
			}
		} catch (SQLException e) {
			System.err.println("IsciDataBAse.SQL error_4");
			e.printStackTrace();
		}
		Connect.ayrilmaq(connect, preparedStatement);
        resultSet =null;
		return musteriLimiti;
	}
	public static void limitArtir(int newLimit,int id) {
		connect =Connect.connect();
		String s ="UPDATE musteri SET limits = ? WHERE mId = ?";
		try {
			preparedStatement=connect.prepareStatement(s);
			preparedStatement.setInt(1, newLimit);
			preparedStatement.setInt(2, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.err.println("IsciDataBAse.SQL error_5");
			e.printStackTrace();
		}
		
		
		
		
	}

}
