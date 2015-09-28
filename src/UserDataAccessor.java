import java.sql.Connection ;
import java.sql.DriverManager ;
import java.sql.SQLException ;
import java.sql.Statement ;
import java.sql.ResultSet ;

import java.util.List ;
import java.util.ArrayList ;

public class UserDataAccessor {


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

    // other methods, eg. addPerson(...) etc
}