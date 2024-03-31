package SQLdatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Connect {
	private static Connection connection = null;
	private static PreparedStatement preparedStatement = null;

	public static Connection connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/qazsaygaci", "root", "5001301ferhad");
		} catch (SQLException e) {
			System.out.println("baqlanti ugursuz oldu");
			e.printStackTrace();
		}

		return connection;
	}

	public static void ayrilmaq(Connection connection, PreparedStatement preparedStatement) {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				System.out.println("baqlanti ugursuz oldu");
				e.printStackTrace();
			}
		if(preparedStatement!= null) {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		}
	}
}
