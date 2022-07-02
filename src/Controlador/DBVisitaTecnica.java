
package Controlador;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class DBVisitaTecnica {
    
    public void AgregarVisitaTecnica(Connection con, int idProyecto,
            Date fechaVisitaTecnica) {

        String SQLLogin = "insert into visitastecnicas (id_Proyecto_VT, fechaVisitasTecnicas, estado_visitastecnicas) values(?,?,?)";

        try {
            PreparedStatement pst = con.prepareStatement(SQLLogin);

            pst.setInt(1, idProyecto);
            pst.setDate(2, fechaVisitaTecnica);
            pst.setString(3, "Activa");

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se registró correctamente la Visita Técnica");
            con.close();
            pst.close();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Error de Registro " + e.getMessage());

        }
    }
}
