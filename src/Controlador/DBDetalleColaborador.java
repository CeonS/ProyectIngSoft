
package Controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;


public class DBDetalleColaborador {
    
    public void AgregarDetalleColaborador(Connection con, int idColaborador, String descripcion, int idProyecto) {

        String SQLLogin = "insert into detallecolaborador (id_ColaboradorDetalle, estadoDetalleColaborador, descripcionColaborador, id_Proyecto_DetalleColaboradores) values(?,?,?,?)";

        try {
            PreparedStatement pst = con.prepareStatement(SQLLogin);

            pst.setInt(1, idColaborador);
            pst.setString(2, "Activo");
            pst.setString(3, descripcion);
            pst.setInt(4, idProyecto);
            

            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Se registró correctamente la asignación del proyecto!");

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Error de Registro1 " + e.getMessage());

        }
    }
}
