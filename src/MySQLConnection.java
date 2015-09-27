import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class MySQLConnection {
	
	//Connection URL til MySQL databasen
	private final String url = "jdbc:mysql://mysql.stud.ntnu.no:3306/glennchr_app";
	
	//Felles MySQL brueker
	private final String user = "glennchr";
	private final String password = "mysql123";
	
	///**
	// * @VALUES ID, Demotekst, tall
	// * @ID Tall mellom 1-10
	// * @Demotekst Tekst
	// * @tall Tall mellom 1-8
	// */
	//public static final String TABLE_DEMO = "Demo";
	//public static final String TABLE_USERDETAIL = "userdetail";
	
	
	static Connection connection;
	//PreparedStatement preparedStatement;
	
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
