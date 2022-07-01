package Controlador;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class DBSector {

    public ArrayList<Parametros> getSectores(Connection con) {

        Statement stmt;
        ResultSet rs;
        ArrayList<Parametros> listaServicios = new ArrayList<>();
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM nivelparametro where tipoParameto = 'Sector'");

            while (rs.next()) {
                Parametros servicio = new Parametros();
                servicio.setIdParametro(rs.getInt("IdParametro"));
                servicio.setDescripcionParametro(rs.getString("descripcionParametro"));
                servicio.setTipoParametro(rs.getString("tipoParameto"));
                servicio.setEstadoParametro(rs.getString("estadoParametro"));
                listaServicios.add(servicio);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Problema: " + e);
        }
        return listaServicios;
    }

}
