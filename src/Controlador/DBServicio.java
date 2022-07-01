
package Controlador;

import static Controlador.DBPersona.bandAgregarPersona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class DBServicio {
    
      public void AgregarParametroServicio(Connection con, String descripcionParametro){
        
        
        String SQLLogin = "insert into nivelparametro (estadoParametro,descripcionParametro,tipoParameto) values(?,?,?)";
        
        try {
            PreparedStatement pst = con.prepareStatement(SQLLogin);
            
            pst.setString(1, "Activo");
            pst.setString(2, descripcionParametro);
            pst.setString(3, "Tipo Servicio");
          
            
            pst.executeUpdate();
            
            
            bandAgregarPersona = true;
        
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null,"Error de Registro "+e.getMessage());
            
        }
    }
      
    
      
    public void AgregarServicio(Connection con, String descripcionParametro, int tipoServicio, int monto){
        
        
        String SQLLogin = "insert into servicio (estadoServicio,descripcionServicio,idParametroTipoServicio, monto) values(?,?,?,?)";
        
        try {
            PreparedStatement pst = con.prepareStatement(SQLLogin);
            
            pst.setString(1, "Activo");
            pst.setString(2, descripcionParametro);
            pst.setInt(3, tipoServicio);
            pst.setInt(4, monto);
          
            
            pst.executeUpdate();
            
            
            bandAgregarPersona = true;
            JOptionPane.showMessageDialog(null,"Registro Exitoso");
        
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null,"Error de Registro "+e.getMessage());
            
        }
    }
    
 
    public int ValidarServicio(Connection con, String descripcionServicio){
        
        int id = 0;
        int resultado = 0;
        String SQL = "select * from servicio s "
                + " inner join nivelparametro np on s.idParametroTipoServicio = np.idParametro"
                + " where np.descripcionParametro like '" + descripcionServicio + "'";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SQL);

            if (rs.next()) {
                resultado = 1;

                if (resultado == 1) {

                    id = rs.getInt("IdServicio");

                }
            } else {
                JOptionPane.showMessageDialog(null, "Error no hay en la lista ese servicio!");
            }
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de Registro " + e.getMessage());
        }
    return id;
    
    }
     public ArrayList<Parametros> getServicioses(Connection con){
            
         Statement stmt;
         ResultSet rs;
         ArrayList<Parametros> listaServicios = new ArrayList<>();
         try {
             stmt = con.createStatement();
             rs = stmt.executeQuery("SELECT * FROM nivelparametro where tipoParameto = 'Tipo Servicio'");
             
             while(rs.next()){
                 Parametros servicio = new Parametros();
                 servicio.setIdParametro(rs.getInt("IdParametro"));
                 servicio.setDescripcionParametro(rs.getString("descripcionParametro"));
                 servicio.setTipoParametro(rs.getString("tipoParameto"));
                 servicio.setEstadoParametro(rs.getString("estadoParametro"));
                 listaServicios.add(servicio);
             }
         } catch (Exception e) {
             JOptionPane.showMessageDialog(null,"Problema: "+e);
         }
            return listaServicios;
        }
     
}
