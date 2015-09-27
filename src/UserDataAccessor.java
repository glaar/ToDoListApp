import java.sql.Connection ;
import java.sql.DriverManager ;
import java.sql.SQLException ;
import java.sql.Statement ;
import java.sql.ResultSet ;

import java.util.List ;
import java.util.ArrayList ;

public class UserDataAccessor {

    // in real life, use a connection pool....
    //private Connection connection ;

    //public UserDataAccessor(String driverClassName, String dbURL, String user, String password) throws SQLException, ClassNotFoundException {
    //    Class.forName(driverClassName);
    //    connection = DriverManager.getConnection(dbURL, user, password);
    //}

    //public void shutdown() throws SQLException {
    //    if (connection != null) {
    //        connection.close();
    //    }
    //}

    public static List<User> getUserList() throws SQLException {
        try (
            Statement stmnt = MySQLConnection.connection.createStatement();
            ResultSet rs = stmnt.executeQuery("select * from glennchr_app.users");
        ){
            List<User> userList = new ArrayList<>();
            while (rs.next()) {
                String username = rs.getString("username");
                int password = rs.getInt("password");
                User user = new User(username, password);
                userList.add(user);
            }
            return userList ;
        } 
    }

    // other methods, eg. addPerson(...) etc
}