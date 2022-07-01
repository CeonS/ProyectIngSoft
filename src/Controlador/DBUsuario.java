package Controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class DBUsuario {

    public static int resultadoT = 0;

    public void TipoUsuario(Connection con, String usu) {

        try {
            String SQLCliente = "select * from usuario"
                    + " where idParametroUsuario = 3 and Usuario like '" + usu + "'";
            Statement st = con.createStatement();
            ResultSet rsCliente = st.executeQuery(SQLCliente);

            if (rsCliente.next()) {
                resultadoT = 3;
            } else {
                if (resultadoT == 0) {
                    String SQLEmpleado = "select * from usuario"
                            + " where idParametroUsuario = 2 and Usuario like '" + usu + "'";
                    ResultSet rsEmpleado = st.executeQuery(SQLEmpleado);
                    if (rsEmpleado.next()) {
                        resultadoT = 2;

                    } else {
                        if (resultadoT == 0) {
                         String SQLColaborador = "select * from usuario"
                          + " where idParametroUsuario = 4 and Usuario like '" + usu + "'";
                         ResultSet rsColaborador = st.executeQuery(SQLColaborador);
                            if (rsColaborador.next()) {
                                resultadoT = 4;

                            } else {
                                JOptionPane.showMessageDialog(null, "Error de Acceso, Usuario No Registrado");
                            }
                        }
                    }
                }
                con.close();
                st.close();
            }
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de Registro " + e.getMessage());
        }
        }

    public static boolean bandAgregarUsuario = false;

    public void AgregarUsuarioA(Connection con, String usuario, int persona, int tipoUsuario) {

        String SQLUsuario = "insert into usuario (estado_usuario, fechaRegistro"
                + ", idParametroUsuario, idPersonaUsuario, Usuario) values(?,?,?,?,?)";

        try {
            PreparedStatement pst = con.prepareStatement(SQLUsuario);

            pst.setString(1, "Activo");
            pst.setString(2, fechaActual());
            pst.setInt(3, tipoUsuario);
            pst.setInt(4, persona);
            pst.setString(5, usuario);

            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Registro Exitoso");
            bandAgregarUsuario = true;

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Error de Registro " + e.getMessage());

        }
    }
    
     public void AgregarUsuarioCliente(Connection con, int persona, String nombre, String dni) {

        String SQLUsuario = "insert into usuario (estado_usuario, fechaRegistro"
                + ", idParametroUsuario, idPersonaUsuario, Usuario) values(?,?,?,?,?)";

        try {
            PreparedStatement pst = con.prepareStatement(SQLUsuario);

            pst.setString(1, "Activo");
            pst.setString(2, fechaActual());
            pst.setInt(3, 3);
            pst.setInt(4, persona);
            pst.setString(5, nombre+dni);
 
            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Registro Exitoso");
            bandAgregarUsuario = true;

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Error de Registro4 " + e.getMessage());

        }
    }

    public static String fechaActual() {

        Date fecha = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("YYYY-MM-dd");

        return formatoFecha.format(fecha);

    }
    
    

    public String AsignarUsuario(Connection con, String descripcion) {

        String id = "";
        int resultado = 0;
        String SQL = "select * from login_usuario where Usuario = '" + descripcion + "'";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SQL);

            if (rs.next()) {
                resultado = 1;

                if (resultado == 1) {

                    id = rs.getString("Usuario");

                }
            } else {
                
                JOptionPane.showMessageDialog(null, "Error de Acceso, Usuario No Registrado");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de Registro " + e.getMessage());
        }
        return id;
    }
    public static boolean ExisteUsuario = false;
    public void ExisteUsuario(Connection con, String descripcion) {

        String id = "";
        int resultado = 0;
        String SQL = "select * from login_usuario where Usuario = '" + descripcion + "'";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SQL);

            if (rs.next()) {
                resultado = 1;

                if (resultado == 1) {

                    id = rs.getString("Usuario");
                    ExisteUsuario = true;

                }
            } else {
                ExisteUsuario = false;
               JOptionPane.showMessageDialog(null, "Se creará un usuario para el cliente!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de Registro " + e.getMessage());
        }
   
    }

}
