import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {

        String url = "jdbc:mysql://localhost:3306/company";
        String username = "root";
        String password = "root";
        String query = "Update employee set salary=50000 where id=2";

        try{
            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println("Connection established successfully");
            Statement stmt = con.createStatement();
            int rowsAffected = stmt.executeUpdate(query);
            if(rowsAffected > 0){
            System.out.println(rowsAffected+" rows affected.");
            }else{
                System.err.println("Failed.");
            }

            stmt.close();
            con.close();

        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
