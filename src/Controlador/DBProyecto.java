package Controlador;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class DBProyecto {

    public void AgregarProyecto(Connection con, int idReunion, int idParametro,
            Date fechaInicial, Date fechaFinal,
            String zonaEjecucion, String observaciones) {

        String SQLLogin = "insert into proyecto (id_Reunion_Proy, id_Parametro_Sector_Proy,"
                + " fecha_Inicial_Proyecto, fecha_Final_Proyecto, zonaEjecucionProy,"
                + " estado_proyecto, observacionesProy) values(?,?,?,?,?,?,?)";

        try {
            PreparedStatement pst = con.prepareStatement(SQLLogin);

            pst.setInt(1, idReunion);
            pst.setInt(2, idParametro);
            pst.setDate(3,fechaInicial );
            pst.setDate(4, fechaFinal);
            pst.setString(5, zonaEjecucion);
            pst.setString(6, "Pendiente");
            pst.setString(7, observaciones);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se registró correctamente el Proyecto");
            con.close();
            pst.close();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Error de Registro " + e.getMessage());

        }
    }

}
