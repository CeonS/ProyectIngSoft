package Controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class DBDetalleColaborador {

    public void AgregarDetalleColaborador(Connection con, int idColaborador, String descripcion, int idProyecto) {

        String SQLLogin = "insert into detallecolaborador (id_ColaboradorDetalle, estadoDetalleColaborador, descripcionColaborador, id_Proyecto_DetalleColaboradores) values(?,?,?,?)";

        try {
            PreparedStatement pst = con.prepareStatement(SQLLogin);

            pst.setInt(1, idColaborador);
            pst.setString(2, "Pendiente");
            pst.setString(3, descripcion);
            pst.setInt(4, idProyecto);

            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Se registró correctamente la asignación del proyecto!");

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Error de Registro1 " + e.getMessage());

        }
    }

    public static boolean aceptarDetalle = false;

    public void ValidarAceptacionDetalleColaborador(Connection con, int idColaborador) {

        String sql = "select * from detallecolaborador where estadoDetalleColaborador = 'Pendiente' and id_ColaboradorDetalle = "+idColaborador;
        int resultado = 0;
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                resultado = 1;

                if (resultado == 1) {
                    aceptarDetalle = true;
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"ErrorDetalle "+ e);
        }

    }

    public void ActualizarEstadoDetalleColaborador(Connection con, String estado, int idColaborador) {

        String sqlEstado = "UPDATE detallecolaborador SET estadoDetalleColaborador = '" + estado + "' where id_ColaboradorDetalle = "+idColaborador;

        try {

            PreparedStatement pps1 = con.prepareStatement(sqlEstado);
            pps1.executeUpdate();
            pps1.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de actualizacion " + e);
        }
    }
    
    
    
}
