package Controlador;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class DBLogin {

    public static boolean bandValidarUsuario = false;

    @SuppressWarnings("deprecation")
    public void ValidarUsuario(Connection con, String usu, String pass) {

        int resultado = 0;
        String SQL = "select * from login_usuario where Usuario='" + usu + "' and Contraseña='" + pass + "' and EstadoLogin= 'Activo'";

        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            if (rs.next()) {
                resultado = 1;
                if (resultado == 1) {
                    bandValidarUsuario = true;
                }

            } else {
                JOptionPane.showMessageDialog(null, "Error de acceso, usuario no registrado!");
                bandValidarUsuario = false;
            }
            con.close();
            st.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de Registro " + e.getMessage());
        }

    }

    public int AsignarIDPersona(Connection con, String descripcion) {

        int id = 0;
        int resultado = 0;
        String SQL = "select idPersona from persona "
                + "inner join  where dni = " + descripcion;
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SQL);

            if (rs.next()) {
                resultado = 1;

                if (resultado == 1) {

                    id = rs.getInt("idPersona");

                }
            } else {
                JOptionPane.showMessageDialog(null, "Error de Acceso, Usuario No Registrado");
            }
            con.close();
            st.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de Registro2 " + e.getMessage());
        }
        return id;
    }
}
