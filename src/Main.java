import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {

        String url = "jdbc:mysql://localhost:3306/company";
        String username = "root";
        String password = "root";

        try{
            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println("Connection established successfully");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from employee");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String salary = rs.getString("salary");
                System.out.println();
                System.out.println("ID: "+id);
                System.out.println("Name: "+name);
                System.out.println("Salary: "+salary);
                System.out.println();
            }
            rs.close();
            stmt.close();
            con.close();

        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
