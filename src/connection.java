import java.sql.*;

public class connection {
	public static Connection cn;

	public static Connection mycon() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3307/billing", "root", "root");
		} catch (Exception e) {
			System.out.println(e);
		}
		return cn;
	}

}
