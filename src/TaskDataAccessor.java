import java.sql.Connection ;
import java.sql.DriverManager ;
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

    // other methods, eg. addPerson(...) etc
}