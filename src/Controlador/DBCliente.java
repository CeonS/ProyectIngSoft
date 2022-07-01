package Controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class DBCliente {

    public static boolean bandValidaPersonaC = false;

    public void AgregarCliente(Connection con, int tipoCliente, int idPersona) {

        String SQLLogin = "insert into cliente (id_ParametroTipo_Cliente, id_PersonaC, estado_cliente) values(?,?,?)";

        try {
            PreparedStatement pst = con.prepareStatement(SQLLogin);

            pst.setInt(1, tipoCliente);
            pst.setInt(2, idPersona);
            pst.setString(3, "Activo");

            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Se registró correctamente el usuario!");

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Error de Registro1 " + e.getMessage());

        }
    }

    public ArrayList<Parametros> getTipoClientes(Connection con) {

        Statement stmt;
        ResultSet rs;
        ArrayList<Parametros> listaServicios = new ArrayList<>();
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM nivelparametro where tipoParameto = 'Tipo Cliente'");

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

    public int AsignarIDCliente(Connection con, String usuario) {

        int id = 0;
        int resultado = 0;
        String SQL = "select * from usuario u inner join persona p on u.idPersonaUsuario = p.idPersona\n"
                + "inner join cliente c on p.idPersona = c.id_PersonaC where u.Usuario = '" + usuario + "'";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SQL);

            if (rs.next()) {
                resultado = 1;

                if (resultado == 1) {

                    id = rs.getInt("c.idCliente");

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
