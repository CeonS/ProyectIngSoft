package Controlador;

import static Controlador.DBPersona.bandAgregarPersona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class DBNivelParametros {

    public int Validar(Connection con, String descripcion) {

        int id = 0;
        int resultado = 0;
        String SQL = "select idParametro from nivelparametro where descripcionParametro like '" + descripcion + "'";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SQL);

            if (rs.next()) {
                resultado = 1;

                if (resultado == 1) {

                    id = rs.getInt("idParametro");

                }
            } else {
                JOptionPane.showMessageDialog(null, "Error no hay en la lista ese parametro");
            }
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de Registro " + e.getMessage());
        }
    return id;
    }
    
          
}
