package Controlador;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
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
            pst.setDate(3, fechaInicial);
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

    public static boolean Presupuesto = false;

    public void ValidarPresupuesto(Connection con, int idCliente) {
        Presupuesto = false;
        String sql = "select s.monto from proyecto p inner join reunion r on p.id_Reunion_Proy = r.idReunion \n"
                + "                    inner join servicio s on r.IdServicioReunion = s.IdServicio\n"
                + "                    inner join detallecolaborador dc on p.idProyecto = dc.id_Proyecto_DetalleColaboradores where dc.estadoDetalleColaborador = 'Aceptado' \n"
                + "                    and r.idClienteReu = " + idCliente;
        int resultado = 0;
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                resultado = 1;

                if (resultado == 1) {
                    Presupuesto = true;
                }
            }
        } catch (Exception e) {
        }

    }

    public void ActualizarEstadoProyecto(Connection con, String estado, int idProyecto) {

        String sqlEstado = "UPDATE proyecto SET estado_proyecto = '" + estado + "' where idProyecto = " + idProyecto;

        try {

            PreparedStatement pps1 = con.prepareStatement(sqlEstado);
            pps1.executeUpdate();
            pps1.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de actualizacion " + e);
        }
    }

}
