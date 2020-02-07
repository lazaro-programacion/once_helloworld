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

    // defino variables
    int opcion = 2;
    int edad;
    String nombre, nombre1;
    String apellidos;
    String Director1;
    String code_empl;

    // usamos scanner con menu de opciones
    // Mientras enpleado<>o O empresa <>0
    // pedir empleado( datos nombre, apellidos, edad,codigo empresa)
    // pedir empresa(datos ...)
    // cambio empleado a 0
    // ¿Nueva empresa o nuevo empleado o salir?
    // finMientras

    Scanner scan = new Scanner(System.in);
    while (opcion != 0) {
      System.out.println("1.-Introducir Empleado");
      System.out.println("2.-Introducir Empresa");
      System.out.println("0.-Salir");
      opcion = Integer.parseInt(scan.nextLine());
      if (opcion == 1) {
        System.out.print("Introduce nombre: ");
        nombre = scan.nextLine();
        System.out.print("Introduce apellidos: ");
        apellidos = scan.nextLine();
        System.out.print("Introduce edad: ");
        edad = Integer.parseInt(scan.nextLine());

        stmt.executeUpdate(
            "INSERT INTO `Employees`(first,last,age) VALUE ('" + nombre + "','" + apellidos + "','" + edad + "')");
      }
      if (opcion == 2) {
        System.out.print(" Nombre de la Empresa: ");
        nombre1 = scan.nextLine();
        System.out.print(" Nombre del Director: ");
        Director1 = (scan.nextLine());
        System.out.print(" Codigo de Empresa: ");
        code_empl = (scan.nextLine());

        stmt.executeUpdate("INSERT INTO `Empresas`(Nombre, Director, Codigo ) VALUE ('" + nombre1 + "','" + Director1 + "','" + code_empl + "')");

      }

      // grabo a piñon

      /*
       * Scanner scan1 = new Scanner(System.in); Scanner scan2 = new
       * Scanner(System.in); while (opcion != 0) {
       * System.out.println("1.-Introducir empresa"); System.out.println("0.-Salir");
       * opcion = Integer.parseInt(scan1.nextLine()); if (opcion == 1) {
       * System.out.print("Nombre de la Empresa: "); nombre1 = scan.nextLine();
       * System.out.print("Nombre del Director: "); Director1 = (scan1.nextLine());
       * System.out.print("Codigo de Empresa: "); code_empl = (scan2.nextLine());
       */

      // grabo a piñon

      System.out.println("Registrado correctamente");
      break;
      //opcion = Integer.parseInt(scan.nextLine());
      //opcion = 0;

      

    }

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
      System.out.print(", first : " + first);
      System.out.println(", Last: " + last);
    }
    ResultSet re = stmt.executeQuery("SELECT id, Nombre, Director,Codigo FROM Empresas");

    // Extract data from result set
    while (re.next()) {
      // Retrieve by column name
      int id = re.getInt("id");
      String Nombre = re.getString("Nombre");
      String Director = re.getString("Director");
      String Codigo = re.getString("Codigo");

      System.out.print("ID: " + id);
      System.out.print(", Nombre: " + Nombre);
      System.out.println(", Director: " + Director);
      System.out.print(" Codigo: " + Codigo);
    }

    // Clean-up environment
    rs.close();
    re.close();
    stmt.close();
    conn.close();
    scan.close();
    // scan1.close();
    // scan2.close();
  }
  // }
}
// }
