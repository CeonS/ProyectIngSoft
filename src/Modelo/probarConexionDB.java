
package Modelo;

import Controlador.DBConexion;
import java.sql.Connection;

public class probarConexionDB {
    
    public Connection connection2 () {
        DBConexion db = new DBConexion();
        db.getConnetion();
        
       
       return db.getConnetion(); 
    }
    
}
