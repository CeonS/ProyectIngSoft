package Controlador;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class DBReunion {

    public void AgregarReunion(Connection con, int idUsuario, Date fecha,
            String ubicacion, String numeroContacto, int idServicio,
            int idCliente) {

        String SQLLogin = "insert into reunion (id_Usuario_Reu, fechaReunion, ubicacion,"
                + " numeroContacto,estado_reunion, idServicioReunion, idClienteReu) values(?,?,?,?,?,?,?)";

        try {
            PreparedStatement pst = con.prepareStatement(SQLLogin);

            pst.setInt(1, idUsuario);
            pst.setDate(2, fecha);
            pst.setString(3, ubicacion);
            pst.setString(4, numeroContacto);
            pst.setString(5, "Pendiente");
            pst.setInt(6, idServicio);
            pst.setInt(7, idCliente);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se registró correctamente la reunión");
            con.close();
            pst.close();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Error de Registro " + e.getMessage());

        }
    }

    public void ActualizarEstadoReunion(Connection con, String estado) {

        String sqlEstado = "UPDATE reunion SET estado_reunion = '" + estado + "'";

        try {

            PreparedStatement pps1 = con.prepareStatement(sqlEstado);
            pps1.executeUpdate();
            pps1.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de actualizacion " + e);
        }
    }

    public static boolean aceptarReunion = false;
    public void ValidarAceptacionReunion(Connection con) {

        String sql = "select * from reunion where estado_reunion = 'Pendiente'";
        int resultado = 0;
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                resultado = 1;
                
                if(resultado ==1){
                    aceptarReunion = true;
                }
            }
        } catch (Exception e) {
        }

    }
}
