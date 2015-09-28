import java.sql.PreparedStatement;
import java.sql.SQLException ;
import java.sql.Statement ;
import java.sql.ResultSet ;

import java.util.List ;
import java.util.ArrayList ;

public class signUpUsersDB {


    
    
    public static void insertUser(Integer loggedInUserID, String desc) throws SQLException{
    	
    	String insertRowSQL = "INSERT INTO "
    			+"`glennchr_app`.`task` (`user_id`, `desc`) VALUES "
    			+"(?,?)";
    	
    	PreparedStatement preparedStatement = MySQLConnection.connection.prepareStatement(insertRowSQL);
    	
    	preparedStatement.setInt(1, loggedInUserID);
    	preparedStatement.setString(2, desc);
    	//System.out.println(preparedStatement.toString());
    	
    	preparedStatement.executeUpdate();

    }
    	
    public static void deleteUser(Integer idtask) throws SQLException{
    	
    	String deleteRowSQL = "DELETE FROM "
    			+"`glennchr_app`.`task` WHERE "
    			+" `idtask`= ?;";
    	
    	PreparedStatement preparedStatement = MySQLConnection.connection.prepareStatement(deleteRowSQL);
    	
    	preparedStatement.setInt(1, idtask);
    	//System.out.println(preparedStatement.toString());
 	
    	preparedStatement.executeUpdate();

    }
    
}