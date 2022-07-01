package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DBConexion {

    private static String Driver = "com.mysql.cj.jdbc.Driver";
    private static String Usuario = "mysqluser";
    private static String Password = "mysql@123";
    private static String URL = "jdbc:mysql://localhost:3306/proyectoingsoftware";

    static {
        try {

            Class.forName(Driver);
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "ERROR EN EL DRIVER:" + e);
        }
    }

    public Connection getConnetion() {

        Connection con = null;
        try {
            con = DriverManager.getConnection(URL, Usuario, Password);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la Conexion" + e);
        } 
        return con;
    }
    
}
