package Controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class DBRegistraCuenta {
    
    public static boolean bandRegistro = true;
      public void AgregarLoginUsuario(Connection con, String usu, String pass){
        
        
        String SQLLogin = "insert into login_usuario (Usuario,Contraseña,EstadoLogin) values(?,?,?)";
        
        try {
            PreparedStatement pst = con.prepareStatement(SQLLogin);
            
            pst.setString(1, usu);
            pst.setString(2, pass);
            pst.setString(3, "Activo");
            
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Registro Exitoso");
            
        
            con.close();
            pst.close();
        } catch (Exception e) {
            bandRegistro = false;
            JOptionPane.showMessageDialog(null,"Error de Registro "+e.getMessage());
            
        }
    }

}
