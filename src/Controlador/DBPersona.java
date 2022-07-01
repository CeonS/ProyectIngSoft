package Controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class DBPersona {

    public static boolean bandValidaPersona = false;
    public static boolean bandAgregarPersona = false;

    public void AgregarPersona(Connection con, String nombres, String apellidos,
            String correo, String direccion, String dni, String telefono, int genero) {

        String SQLLogin = "insert into persona (nombres,apellidos,correo, direccion, dni, telefono"
                + ",estado_persona, id_ParametroGenero) values(?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement pst = con.prepareStatement(SQLLogin);

            pst.setString(1, nombres);
            pst.setString(2, apellidos);
            pst.setString(3, correo);
            pst.setString(4, direccion);
            pst.setString(5, dni);
            pst.setString(6, telefono);
            pst.setString(7, "Activo");
            pst.setInt(8, genero);

            pst.executeUpdate();

            bandAgregarPersona = true;

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Error de Registro " + e.getMessage());

        }
    }

    public void ValidarPersona(Connection con, String usu, String pass) {

        int resultado = 0;
        String SQL = "select * from usuario u inner join login_usuario lu on u.Usuario = lu.Usuario"
                + " where u.Usuario='" + usu + "'";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SQL);

            if (rs.next()) {
                resultado = 1;
                if (resultado == 1) {
                    bandValidaPersona = true;
                }

            } else {
                JOptionPane.showMessageDialog(null, "Debe registrar sus datos primero!");
                bandValidaPersona = false;
            }
            con.close();
            st.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de Registro6 " + e.getMessage());
        }
    }

    public int AsignarIDPersona(Connection con, String descripcion) {

        int id = 0;
        int resultado = 0;
        String SQL = "select idPersona from persona where dni = " + descripcion;
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
            JOptionPane.showMessageDialog(null, "Error de Registro3 " + e.getMessage());
        }
        return id;
    }

    public int AsignarIDPersonaConIdUsuario(Connection con, int descripcion) {

        int id = 0;
        int resultado = 0;
        String SQL = "select id_PersonaC from cliente c inner join persona p on c.id_PersonaC = p.idPersona "
                + "where p.nombre = " + descripcion;
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
            JOptionPane.showMessageDialog(null, "Error de Registro3 " + e.getMessage());
        }
        return id;
    }
    
     public String AsignarPersonaIdCliente(Connection con, int descripcion) {

        String correo = "";
        int resultado = 0;
        String SQL = "select p.correo from cliente c inner join persona p on c.id_PersonaC = p.idPersona "
                + "where c.idCliente = " + descripcion;
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SQL);

            if (rs.next()) {
                resultado = 1;

                if (resultado == 1) {

                    correo = rs.getString("p.correo");

                }
            } else {
                JOptionPane.showMessageDialog(null, "Error de Acceso, Usuario No Registrado");
            }
            con.close();
            st.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de Registro3 " + e.getMessage());
        }
        return correo;
    }
}
