package practise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class JDBC1 {
	public static void main(String[] args) throws SQLException {

		Driver driverref = new Driver();
		DriverManager.registerDriver(driverref);
		Connection con = DriverManager.getConnection("jdbc:mysql://49.249.28.218:3307/ninza_hrm", "root@%", "root");
		Statement stmt = con.createStatement();
		ResultSet resultSet = stmt.executeQuery("select * from project");

		while (resultSet.next()) {
			System.out.println(resultSet.getString(1));
		}

		con.close();
	}

}
