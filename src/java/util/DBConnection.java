package util;

import java.sql.*;

public class DBConnection {

    public Connection connect(){
        Connection c = null;

        try {
            Class.forName("org.mariadb.jdbc.Driver").newInstance();
            c = DriverManager.getConnection("jdbc:mariadb://localhost:3306/kitapsatis?user=root&password=password");

        } catch (IllegalAccessException | InstantiationException | SQLException | ClassNotFoundException e) {
        }
        return c;
    }

}
