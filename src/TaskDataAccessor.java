import java.sql.PreparedStatement;
import java.sql.SQLException ;
import java.sql.Statement ;
import java.sql.ResultSet ;

import java.util.List ;
import java.util.ArrayList ;

public class TaskDataAccessor {


    public static List<Task> getTaskList(Integer loggedInUserID) throws SQLException {
        try (
            Statement stmnt = MySQLConnection.connection.createStatement();
            ResultSet rs = stmnt.executeQuery("select * from glennchr_app.task " + "where user_id = " + loggedInUserID +";" );
        ){
            List<Task> taskList = new ArrayList<>();
            while (rs.next()) {
                int idtask = rs.getInt("idtask");
                int user_id = rs.getInt("user_id");
                String desc = rs.getString("desc");
                Task task = new Task(idtask, user_id, desc);
                taskList.add(task);
            }
            return taskList ;
        } 
    }
    
    public static void insertTask(Integer loggedInUserID, String desc) throws SQLException{
    	
    	String insertRowSQL = "INSERT INTO "
    			+"`glennchr_app`.`task` (`user_id`, `desc`) VALUES "
    			+"(?,?)";
    	
    	PreparedStatement preparedStatement = MySQLConnection.connection.prepareStatement(insertRowSQL);
    	
    	preparedStatement.setInt(1, loggedInUserID);
    	preparedStatement.setString(2, desc);
    	System.out.println(preparedStatement.toString());
    	
    	preparedStatement.executeUpdate();

    }
    	
    public static void deleteTask(Integer idtask) throws SQLException{
    	
    	String deleteRowSQL = "DELETE FROM "
    			+"`glennchr_app`.`task` WHERE "
    			+" `idtask`= ?;";
    	
    	PreparedStatement preparedStatement = MySQLConnection.connection.prepareStatement(deleteRowSQL);
    	
    	preparedStatement.setInt(1, idtask);
    	System.out.println(preparedStatement.toString());
 	
    	preparedStatement.executeUpdate();

    }
    
}