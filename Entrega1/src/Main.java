import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws SQLException {

        //AgregameEstoaLaDB();

        LectorCSV csv = new LectorCSV();
    }

    public static void AgregameEstoaLaDB() throws SQLException {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://sql10.freemysqlhosting.net:3306/sql10614022", "sql10614022", "W3YI6xDvYY");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Pronostico");
            while (rs.next())
                System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4) + " " + rs.getString(5) + " " + rs.getString(6) + " " + rs.getString(7));

            stmt.close();
        } catch (SQLException e) {
            System.out.println(e);
        }

    }
}


