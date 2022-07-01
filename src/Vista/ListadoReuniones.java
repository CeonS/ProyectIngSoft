package Vista;

import Controlador.DBNivelParametros;
import Modelo.probarConexionDB;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ListadoReuniones extends javax.swing.JFrame {

    public ListadoReuniones() {
        initComponents();
        this.setLocationRelativeTo(null);
        mostrarTabla();
    }

    DefaultTableModel modelo = new DefaultTableModel();
    probarConexionDB pcDB = new probarConexionDB();
    public static String dniCliente, dniEmpleado, descripcionServicio, numeroContacto;
    public static java.sql.Date fecha;

    void mostrarTabla() {
        modelo.addColumn("ID");
        modelo.addColumn("Nombre Empleado");
        modelo.addColumn("DNI Empleado");
        modelo.addColumn("Nombre Cliente");
        modelo.addColumn("DNI Cliente");
        modelo.addColumn("Tipo Servicio");
        modelo.addColumn("Fecha Reunion");
        modelo.addColumn("Ubicación");
        modelo.addColumn("Número Contacto");
        modelo.addColumn("Estado");


       tablaReuniones.setModel(modelo);
        
        String sql = "select r.idReunion,np.descripcionParametro, pe.nombres as 'nombre empleado', pe.dni,\n"
                    + "p.nombres as 'nombre cliente',p.dni, r.fechaReunion, r.ubicacion, r.numeroContacto, r.estado_reunion from reunion r\n"
                    + "inner join servicio s on r.IdServicioReunion = s.IdServicio\n"
                    + "inner join nivelparametro np on s.idParametroTipoServicio = np.idParametro\n"
                    + "inner join usuario u on r.id_Usuario_Reu = u.idUsuario\n"
                    + "inner join persona pe on u.idPersonaUsuario = pe.idPersona\n"
                    + "inner join cliente c on r.idClienteReu = c.idCliente\n"
                    + "inner join persona p on c.id_PersonaC = p.idPersona;";

            String datos[] = new String[10];
            Statement st;
            try {
                st = pcDB.connection2().createStatement();
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    datos[0] = rs.getString(1);
                    datos[1] = rs.getString(3);
                    datos[2] = rs.getString(4);
                    datos[3] = rs.getString(5);
                    datos[4] = rs.getString(6);
                    datos[5] = rs.getString(2);
                    datos[6] = rs.getString(7);
                    datos[7] = rs.getString(8);
                    datos[8] = rs.getString(9);
                    datos[9] = rs.getString(10);
                    modelo.addRow(datos);
                }
                tablaReuniones.setModel(modelo);
                pcDB.connection2().close();
                st.close();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "error listar: " + e);
            }

        }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaReuniones = new javax.swing.JTable();
        btnactualizar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtEstado = new javax.swing.JTextField();
        txtUbicacion = new javax.swing.JTextField();
        txtServicio = new javax.swing.JTextField();
        txtNumeroContacto1 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txtDniCliente = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        DateCFecha = new com.toedter.calendar.JDateChooser();
        txtDniEmpleado = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtEmpleado = new javax.swing.JTextField();
        txtcliente = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaReuniones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Cliente", "Sector", "Fecha"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tablaReuniones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaReunionesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaReuniones);
        if (tablaReuniones.getColumnModel().getColumnCount() > 0) {
            tablaReuniones.getColumnModel().getColumn(0).setResizable(false);
            tablaReuniones.getColumnModel().getColumn(1).setResizable(false);
            tablaReuniones.getColumnModel().getColumn(2).setResizable(false);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 930, 250));

        btnactualizar.setBackground(new java.awt.Color(204, 204, 204));
        btnactualizar.setFont(new java.awt.Font("Hack Nerd Font", 1, 14)); // NOI18N
        btnactualizar.setForeground(new java.awt.Color(57, 73, 171));
        btnactualizar.setText("ACTUALIZAR");
        btnactualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnactualizarActionPerformed(evt);
            }
        });
        getContentPane().add(btnactualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 470, 150, 30));

        jLabel5.setFont(new java.awt.Font("Hack Nerd Font", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Fecha");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 350, -1, -1));
        getContentPane().add(txtEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 510, 170, -1));
        getContentPane().add(txtUbicacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 390, 170, -1));
        getContentPane().add(txtServicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 430, 170, -1));
        getContentPane().add(txtNumeroContacto1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 470, 170, -1));

        jButton4.setBackground(new java.awt.Color(204, 204, 204));
        jButton4.setFont(new java.awt.Font("Hack Nerd Font", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(57, 73, 171));
        jButton4.setText("SALIR");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 470, -1, 30));

        jLabel10.setFont(new java.awt.Font("Hack Nerd Font", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("DNI Cliente");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, -1, -1));
        getContentPane().add(txtDniCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 390, 170, -1));

        jLabel11.setFont(new java.awt.Font("Hack Nerd Font", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("DNI Empleado");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 480, -1, -1));

        DateCFecha.setDateFormatString("yyyy-MM-dd");
        getContentPane().add(DateCFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 350, 170, -1));
        getContentPane().add(txtDniEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 480, 170, -1));

        jLabel9.setFont(new java.awt.Font("Hack Nerd Font", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Estado");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 510, -1, -1));

        jLabel8.setFont(new java.awt.Font("Hack Nerd Font", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Numero Contacto");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 470, -1, -1));

        jLabel1.setFont(new java.awt.Font("Hack Nerd Font", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Servicio");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 430, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/support bw.png"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 20, 420, -1));

        jLabel7.setFont(new java.awt.Font("Hack Nerd Font", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Ubicacion");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 390, -1, -1));

        jLabel4.setFont(new java.awt.Font("Hack Nerd Font", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Empleado");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 440, -1, -1));
        getContentPane().add(txtEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 440, 170, -1));
        getContentPane().add(txtcliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 350, 170, -1));

        jLabel3.setFont(new java.awt.Font("Hack Nerd Font", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Cliente");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, -1, -1));

        jLabel2.setFont(new java.awt.Font("Hack Nerd Font", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("LISTA DE REUNIONES");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 20, 260, 60));

        txtnombre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Marks.png"))); // NOI18N
        txtnombre.setText("Proyecto");
        getContentPane().add(txtnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 970, 540));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnactualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnactualizarActionPerformed

        DBNivelParametros np = new DBNivelParametros();
        String validar = txtcliente.getText();
        if (validar.equals("")) {
            JOptionPane.showMessageDialog(null, "Escoja una fila primero!");
        } else {
            String datosU[] = new String[9];

            datosU[0] = txtcliente.getText();
            datosU[1] = txtDniCliente.getText();
            datosU[2] = txtEmpleado.getText();
            datosU[3] = txtDniEmpleado.getText();
            datosU[5] = txtUbicacion.getText();
            datosU[6] = txtServicio.getText();
            datosU[7] = txtNumeroContacto1.getText();
            datosU[8] = txtEstado.getText();

            Date fechaN = DateCFecha.getDate();
            long d = fechaN.getTime();
            java.sql.Date fecha2 = new java.sql.Date(d);

            String sqlCliente = "UPDATE persona SET nombres = '" + datosU[0] + "', dni = " + datosU[1] + " where dni =" + dniCliente;
            String sqlEmpleado = "UPDATE persona SET nombres = '" + datosU[2] + "', dni = " + datosU[3] + " where dni =" + dniEmpleado;
            String sqlServicio = "UPDATE nivelparametro SET descripcionParametro = '" + datosU[6] + "' where descripcionParametro = '" + descripcionServicio + "'";
            String sqlReunion = "UPDATE reunion SET fechaReunion = '" + fecha2 + "', ubicacion = '" + datosU[5] + "', numeroContacto =" + datosU[7] + ", estado_reunion = '" + datosU[8] + "' where"
                    + " fechaReunion = '" + fecha + "' and numeroContacto = " + numeroContacto;

            try {

                PreparedStatement pps1 = pcDB.connection2().prepareStatement(sqlCliente);
                pps1.executeUpdate();
                pps1.close();
                PreparedStatement pps2 = pcDB.connection2().prepareStatement(sqlEmpleado);
                pps2.executeUpdate();
                pps2.close();
                PreparedStatement pps3 = pcDB.connection2().prepareStatement(sqlServicio);
                pps3.executeUpdate();
                pps3.close();
                PreparedStatement pps4 = pcDB.connection2().prepareStatement(sqlReunion);
                pps4.executeUpdate();
                pps4.close();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error de actualizacion " + e);
            }

            int fila = tablaReuniones.getRowCount();
            for (int i = fila - 1; i >= 0; i--) {
                modelo.removeRow(i);
            }

            String sql = "select r.idReunion,np.descripcionParametro, pe.nombres as 'nombre empleado', pe.dni,\n"
                    + "p.nombres as 'nombre cliente',p.dni, r.fechaReunion, r.ubicacion, r.numeroContacto, r.estado_reunion from reunion r\n"
                    + "inner join servicio s on r.IdServicioReunion = s.IdServicio\n"
                    + "inner join nivelparametro np on s.idParametroTipoServicio = np.idParametro\n"
                    + "inner join usuario u on r.id_Usuario_Reu = u.idUsuario\n"
                    + "inner join persona pe on u.idPersonaUsuario = pe.idPersona\n"
                    + "inner join cliente c on r.idClienteReu = c.idCliente\n"
                    + "inner join persona p on c.id_PersonaC = p.idPersona;";

            String datos[] = new String[10];
            Statement st;
            try {
                st = pcDB.connection2().createStatement();
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    datos[0] = rs.getString(1);
                    datos[1] = rs.getString(3);
                    datos[2] = rs.getString(4);
                    datos[3] = rs.getString(5);
                    datos[4] = rs.getString(6);
                    datos[5] = rs.getString(2);
                    datos[6] = rs.getString(7);
                    datos[7] = rs.getString(8);
                    datos[8] = rs.getString(9);
                    datos[9] = rs.getString(10);
                    modelo.addRow(datos);
                }
                tablaReuniones.setModel(modelo);
                pcDB.connection2().close();
                st.close();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "error listar: " + e);
            }

        }
    
    }//GEN-LAST:event_btnactualizarActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        FormEmpleado fe = new FormEmpleado();
        FormColaborador fc = new FormColaborador();

        if (fc.colaboradorForm == true) {
            fc.setVisible(true);
            this.dispose();
        } else {

            fe.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void tablaReunionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaReunionesMouseClicked
        int filaSeleccionada = tablaReuniones.rowAtPoint(evt.getPoint());
        txtcliente.setText(tablaReuniones.getValueAt(filaSeleccionada, 1).toString());
        txtDniCliente.setText(tablaReuniones.getValueAt(filaSeleccionada, 2).toString());
        dniCliente = tablaReuniones.getValueAt(filaSeleccionada, 2).toString();
        txtEmpleado.setText(tablaReuniones.getValueAt(filaSeleccionada, 3).toString());
        txtDniEmpleado.setText(tablaReuniones.getValueAt(filaSeleccionada, 4).toString());
        dniEmpleado = tablaReuniones.getValueAt(filaSeleccionada, 4).toString();
        DateCFecha.setDate(java.sql.Date.valueOf(tablaReuniones.getModel().getValueAt(filaSeleccionada, 6).toString()));

        Date fechaReunion;
        fechaReunion = DateCFecha.getDate();
        long d = fechaReunion.getTime();
        fecha = new java.sql.Date(d);
        txtUbicacion.setText(tablaReuniones.getValueAt(filaSeleccionada, 7).toString());
        txtServicio.setText(tablaReuniones.getValueAt(filaSeleccionada, 5).toString());
        descripcionServicio = tablaReuniones.getValueAt(filaSeleccionada, 5).toString();
        txtNumeroContacto1.setText(tablaReuniones.getValueAt(filaSeleccionada, 8).toString());
        numeroContacto = tablaReuniones.getValueAt(filaSeleccionada, 8).toString();
        txtEstado.setText(tablaReuniones.getValueAt(filaSeleccionada, 9).toString());

    }//GEN-LAST:event_tablaReunionesMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ListadoReuniones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListadoReuniones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListadoReuniones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListadoReuniones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListadoReuniones().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser DateCFecha;
    private javax.swing.JButton btnactualizar;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaReuniones;
    private javax.swing.JTextField txtDniCliente;
    private javax.swing.JTextField txtDniEmpleado;
    private javax.swing.JTextField txtEmpleado;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtNumeroContacto1;
    private javax.swing.JTextField txtServicio;
    private javax.swing.JTextField txtUbicacion;
    private javax.swing.JTextField txtcliente;
    private javax.swing.JLabel txtnombre;
    // End of variables declaration//GEN-END:variables
}
