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
        String miMensaje = "Mi hola mundo";
        System.out.println(miMensaje);

        Persona persona = new Persona();
        persona.setEdad(45);
        persona.setNombre("Alfonso");
        System.out.println(persona);

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
        String sql;
        sql = "SELECT id, first, last, age FROM Employees";
        stmt.executeUpdate(
                "CREATE TABLE if not exists Employees ( id INT(11) PRIMARY KEY, first VARCHAR(256),  last VARCHAR(256),age INTEGER)");
        stmt.executeUpdate(
                "CREATE TABLE if not exists Empresas ( id INT(11) PRIMARY KEY, Nombre VARCHAR(256), Director VARCHAR(256) )");
        
        stmt.executeUpdate("INSERT ignore INTO Employees VALUES(1,'Jack','Smith', 100) ");
        stmt.executeUpdate("INSERT ignore INTO Employees VALUES(2,'Jose','Lazaro', 30) ");
        stmt.executeUpdate("INSERT ignore INTO Employees VALUES(3,'David','Cedeño', 39) ");
        stmt.executeUpdate("INSERT ignore INTO Employees VALUES(4,'Marcos','Calderon', 22) ");

        stmt.executeUpdate("INSERT ignore INTO Empresas VALUES(1,'Eulen','paquito') ");
       
       

        ResultSet rs = stmt.executeQuery(sql);

      // Extract data from result set
      while (rs.next()) {
        // Retrieve by column name
        

        int id = rs.getInt("id");
        int age = rs.getInt("age");
        String first = rs.getString("nombre=sc.nextLine()");
        String last = rs.getString("last");

        System.out.print("ID: " + id);
        System.out.print(", Age: " + age);
        System.out.print(", nombre=sc.nextLine(): " + first);
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
