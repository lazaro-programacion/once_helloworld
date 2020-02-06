package es.taes;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner; 
/**
 * Hello world!
 *
 */
public class App {

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.jdbc2.optional.MysqlDataSource";
    static final String DB_URL = "jdbc:mysql://iprocuratio.com:3333/lazaro";

    // Database credentials
    static final String USER = "root";
    static final String PASS = "once012020";

    public static void main(String[] args) throws Exception {

        Connection conn = null;
        Statement stmt = null;

        // Register JDBC driver
        Class.forName(JDBC_DRIVER);

        // Open a connection
        System.out.println("Connecting to database...");
        conn = DriverManager.getConnection(DB_URL, USER, PASS);

        // Execute a query
        System.out.println("Creating statement...");
        stmt = conn.createStatement();
   
//        stmt.executeUpdate("INSERT ignore INTO Empresas VALUES(1,'Eulen','paquito') ");
       
Scanner sc = new Scanner(System.in);
System.out.print("Introduce tu nombre ");
String nombre = sc.nextLine();
System.out.println(nombre);

Scanner sd = new Scanner(System.in);
System.out.print("Introduce tu apellido ");
String apellido = sd.nextLine();
System.out.println(apellido);

Scanner sa = new Scanner(System.in);
System.out.print("dime tu edad  ");
String edad = sa.nextLine();
System.out.println(edad);



stmt.executeUpdate("INSERT ignore INTO Employees(first, last, age) VALUES('"+ nombre+"','"+ apellido+"','"+ edad+"') ");


sc.close();
sa.close();
sd.close();

        ResultSet rs = stmt.executeQuery("SELECT id, first, last, age FROM Employees");

      // Extract data from result set
      while (rs.next()) {
        // Retrieve by column name
        

        int id = rs.getInt("id");
        int age = rs.getInt("age");
        String first = rs.getString("first");
        String last = rs.getString("last");

        System.out.print("ID: " + id);
        System.out.print(", Age: " + age);
        System.out.print(", Nombre : " + first);
        System.out.println(", Last: " + last);
      }

       rs = stmt.executeQuery("SELECT * FROM Empresas");

      // Extract data from result set
      while (rs.next()) {
        // Retrieve by column name
        int id = rs.getInt("id");
        String Nombre = rs.getString("Nombre");
        String Director = rs.getString("Director");
       
        System.out.print("ID: " + id);
        System.out.print(", Nombre: " + Nombre);
        System.out.println(", Director: " + Director);
      }



        // Clean-up environment
      rs.close();
      stmt.close();
      conn.close();
    }
    
  }
