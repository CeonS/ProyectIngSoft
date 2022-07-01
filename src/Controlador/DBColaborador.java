
package Controlador;

import static Controlador.DBPersona.bandAgregarPersona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class DBColaborador {
     public static boolean bandAgregarColaborador = false;

    public void AgregarColaborador(Connection con, int tipoColaborador, int idPersona,String zonaLaboral){
        
        
        String SQLLogin = "insert into colaborador (estado_Colaborador,id_Parametro_Tipo_Colaborador"
                + ", id_Persona_Tec, zonaLaboral) values(?,?,?,?)";
        
        try {
            PreparedStatement pst = con.prepareStatement(SQLLogin);
            
            pst.setString(1, "Activo");
            pst.setInt(2, tipoColaborador);
            pst.setInt(3, idPersona);
            pst.setString(4, zonaLaboral);

            
            pst.executeUpdate();
            
            
            bandAgregarColaborador = true;
        
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null,"Error de Registro "+e.getMessage());
            
        }
    }
    
   
}
