import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLConnection {
	
	private final String url = "jdbc:mysql://mysql.stud.ntnu.no:3306/glennchr_app";
	
	private final String user = "glennchr";
	private final String password = "mysql123";
	
	
	
	static Connection connection;
	
	public MySQLConnection() {
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			connection = DriverManager.getConnection(url, user, password);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
