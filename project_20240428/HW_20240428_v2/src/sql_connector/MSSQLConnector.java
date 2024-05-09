package sql_connector;

import java.sql.*;

public class MSSQLConnector {
    public static void main(String[] args) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String dburl = "jdbc:sqlserver://localhost;databasename=GrosseryStore;integratedSecurity=true";

            Connection connection = DriverManager.getConnection(dburl);

            Statement statement = connection.createStatement();

            String query = "SELECT * FROM Products";

            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                System.out.println(
                        "ID " + resultSet.getString(1) + "; " +
                                "Name: " + resultSet.getString(2) + "; " +
                                "Price: " + resultSet.getString(3) + ".");
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
