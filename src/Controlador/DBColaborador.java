
package Controlador;

import static Controlador.DBPersona.bandAgregarPersona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
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
    
     public ArrayList<Parametros> getTipoColaborador(Connection con) {

        Statement stmt;
        ResultSet rs;
        ArrayList<Parametros> listaColaboradoresTipo = new ArrayList<>();
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM nivelparametro where tipoParameto = 'Tipo Colaborador'");

            while (rs.next()) {
                Parametros servicio = new Parametros();
                servicio.setIdParametro(rs.getInt("IdParametro"));
                servicio.setDescripcionParametro(rs.getString("descripcionParametro"));
                servicio.setTipoParametro(rs.getString("tipoParameto"));
                servicio.setEstadoParametro(rs.getString("estadoParametro"));
                listaColaboradoresTipo.add(servicio);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Problema: " + e);
        }
        return listaColaboradoresTipo;
    }
   
     public int hallarIDColaboradorIdPersona(Connection con, int idPersona){
         
         
        int id = 0;
        int resultado = 0;
        String SQL = "select * from colaborador c inner join persona p on c.id_Persona_Tec = p.idPersona "
                + "where p.idPersona = " + idPersona;
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SQL);

            if (rs.next()) {
                resultado = 1;

                if (resultado == 1) {

                    id = rs.getInt("c.idColaborador");

                }
            } else {
                JOptionPane.showMessageDialog(null, "Error de Acceso, Usuario No Registrado");
            }
            con.close();
            st.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de Registro3 " + e.getMessage());
        }
        return id;
         
     }
     
     
}
