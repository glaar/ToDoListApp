import java.sql.Connection ;
import java.sql.DriverManager ;
import java.sql.PreparedStatement;
import java.sql.SQLException ;
import java.sql.Statement ;
import java.sql.ResultSet ;

import java.util.List ;
import java.util.ArrayList ;

public class UserDataAccessor {

	private Integer password;
	
    public static List<User> getUserList() throws SQLException {
        try (
            Statement stmnt = MySQLConnection.connection.createStatement();
            ResultSet rs = stmnt.executeQuery("select * from glennchr_app.users");
        ){
            List<User> userList = new ArrayList<>();
            while (rs.next()) {
            	int idusers = rs.getInt("idusers");
                String username = rs.getString("username");
                int password = rs.getInt("password");
                User user = new User(idusers, username, password);
                userList.add(user);
            }
            return userList ;
        } 
    }
    
    public static void insertUser(String username, String password) throws SQLException{
    	
    	String insertRowSQL = "INSERT INTO "
    			+"`glennchr_app`.`users` (`username`, `password`) VALUES "
    			+"(?,?)";
    	
    	PreparedStatement preparedStatement = MySQLConnection.connection.prepareStatement(insertRowSQL);
    	
    	preparedStatement.setString(1, username);
    	preparedStatement.setString(2, password);
    	//System.out.println(preparedStatement.toString());
    	
    	preparedStatement.executeUpdate();

    }

    // other methods, eg. addPerson(...) etc
}