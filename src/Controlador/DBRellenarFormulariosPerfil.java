
package Controlador;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class DBRellenarFormulariosPerfil {
    
    public int AsignarPerfil(Connection con, String usu) {

        int id = 0;
        int resultado = 0;
        String SQL = "select * from persona p "
                + "inner join usuario u on p.idPersona = u.idPersonaUsuario"
                + " where u.Usuario like '" +usu+"'";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SQL);

            if (rs.next()) {
                resultado = 1;

                if (resultado == 1) {

                    id = rs.getInt("p.idPersona");
             

                }
            } else {
                JOptionPane.showMessageDialog(null, "Error de Acceso, Usuario No Registrado");
            }
            con.close();
            st.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de Registro5 " + e.getMessage());
        }
        return id;
    }
    
      
    
    
}
