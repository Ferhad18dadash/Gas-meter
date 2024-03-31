package SQLdatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AbonentDataBase {
	static Connection connect = null;
	static PreparedStatement preparedStatement = null;
	static ResultSet resultSet = null;
	static String musteriparolu = null;
	static double musteriBorcu;

	public static String abonentParolYoxlama(int id) {
		connect = Connect.connect();
		String s = "SELECT password FROM musteri WHERE mId = ?";
		try {
			preparedStatement = connect.prepareStatement(s);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				
				musteriparolu = resultSet.getString("password");
			} else {
				System.out.println("ID'ye ugun abonent tapilmadi");
			}
		} catch (SQLException e) {
			System.err.println("AbonentDataBAse.SQL error_1");
			e.printStackTrace();
		}
		Connect.ayrilmaq(connect, preparedStatement);
		resultSet=null;
		return musteriparolu;
	}

	public static double abonentBorcu(int id) {
		connect = Connect.connect();
		String s = "SELECT cast FROM musteri WHERE mID = ?";
		try {
			preparedStatement = connect.prepareStatement(s);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				// İşçi adını alabiliriz
				musteriBorcu = resultSet.getDouble("cast");
			} else {
				System.out.println("ID'ye uygun musteri bulunamadi.");
			}
		} catch (SQLException e) {
			System.err.println("AbonentDataBAse.SQL error_2");
			e.printStackTrace();
		}

		return musteriBorcu;

	}

	public static void musteriParoluDeyis(int id, String password) {
		connect = Connect.connect();
		String s = "UPDATE musteri SET password=? WHERE mID =?";
		try {
			preparedStatement = connect.prepareStatement(s);
			preparedStatement.setString(1, password);
			preparedStatement.setInt(2, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.err.println("AbonentDataBAse.SQL error_3");
			e.printStackTrace();
		}
		Connect.ayrilmaq(connect, preparedStatement);

	}

}
