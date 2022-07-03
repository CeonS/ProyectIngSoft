package Vista;

import Controlador.DBNivelParametros;
import Controlador.DBServicio;
import Modelo.probarConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ListadoServicios extends javax.swing.JFrame {

    public ListadoServicios() {
        initComponents();
        this.setLocationRelativeTo(null);
        mostrarTabla();
    }

    DefaultTableModel modelo = new DefaultTableModel();
    probarConexionDB pcDB = new probarConexionDB();
    public static String tipoServicio;

    void mostrarTabla() {

        modelo.addColumn("ID");
        modelo.addColumn("Tipo Servicio");
        modelo.addColumn("Descripcion");
        modelo.addColumn("Monto");
        modelo.addColumn("Estado");

        tablaServicios.setModel(modelo);

        String sql = "select s.*, np.descripcionParametro from servicio s\n"
                + " inner join nivelparametro np on s.idParametroTipoServicio = np.idParametro"
                + " where np.tipoParameto = 'Tipo Servicio'";

        String datos[] = new String[5];
        Statement st;
        try {
            st = pcDB.connection2().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(6);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(2);
                datos[4] = rs.getString(5);
                modelo.addRow(datos);
            }
            tablaServicios.setModel(modelo);
        } catch (Exception e) {
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaServicios = new javax.swing.JTable();
        btnactualizar = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtEstado = new javax.swing.JTextField();
        txtMonto = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtADescripcion = new javax.swing.JTextArea();
        txtTipoServicio = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1763, 834));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaServicios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Descripción", "Tipo servicio", "Monto", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tablaServicios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaServiciosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaServicios);
        if (tablaServicios.getColumnModel().getColumnCount() > 0) {
            tablaServicios.getColumnModel().getColumn(0).setResizable(false);
            tablaServicios.getColumnModel().getColumn(1).setResizable(false);
            tablaServicios.getColumnModel().getColumn(2).setResizable(false);
            tablaServicios.getColumnModel().getColumn(3).setResizable(false);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 1430, 300));

        btnactualizar.setFont(new java.awt.Font("Open Sans", 1, 14)); // NOI18N
        btnactualizar.setText("ACTUALIZAR");
        btnactualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnactualizarActionPerformed(evt);
            }
        });
        getContentPane().add(btnactualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, 640, 140, 50));

        jButton4.setFont(new java.awt.Font("Open Sans", 1, 14)); // NOI18N
        jButton4.setText("SALIR");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1490, 640, 140, 50));

        jLabel8.setFont(new java.awt.Font("Bludhaven", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Estado");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 590, -1, -1));

        jLabel5.setFont(new java.awt.Font("Bludhaven", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Monto");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 530, -1, -1));

        txtEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEstadoActionPerformed(evt);
            }
        });
        getContentPane().add(txtEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 590, 230, -1));

        txtMonto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMontoActionPerformed(evt);
            }
        });
        getContentPane().add(txtMonto, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 530, 230, -1));

        jLabel1.setFont(new java.awt.Font("Bludhaven", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Descripción");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 530, -1, -1));

        jLabel3.setFont(new java.awt.Font("Bludhaven", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Tipo de Servicio");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 650, -1, -1));

        txtADescripcion.setColumns(20);
        txtADescripcion.setRows(5);
        jScrollPane2.setViewportView(txtADescripcion);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 530, 250, -1));
        getContentPane().add(txtTipoServicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 650, 250, -1));

        jLabel2.setFont(new java.awt.Font("Signatra DEMO", 1, 60)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Lista de servicios");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 60, 360, 60));

        txtnombre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondolista.png"))); // NOI18N
        getContentPane().add(txtnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 1720, 834));

        jLabel7.setFont(new java.awt.Font("Hack Nerd Font", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Servicio");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 360, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnactualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnactualizarActionPerformed

        DBServicio s = new DBServicio();
        DBNivelParametros np = new DBNivelParametros();
        String validar = txtTipoServicio.getText();
        if (validar.equals("")) {
            JOptionPane.showMessageDialog(null, "Seleccione primero una fila!! ");
        } else {
            String[] datosU = new String[4];
            datosU[0] = txtTipoServicio.getText();
            datosU[1] = txtADescripcion.getText();
            datosU[2] = txtMonto.getText();
            datosU[3] = txtEstado.getText();

            String sqlServicio = "UPDATE servicio SET descripcionServicio = '" + datosU[1] + "', monto = '" + datosU[2] + "',"
                    + " estadoServicio = '" + datosU[3] + "' where idParametroTipoServicio = "+ np.Validar(pcDB.connection2(), tipoServicio) ;

            String sqlParametro = "UPDATE nivelparametro SET descripcionParametro = '" + datosU[0] + "' where idParametro =" + np.Validar(pcDB.connection2(), tipoServicio);

            try {
                PreparedStatement pps1 = pcDB.connection2().prepareStatement(sqlServicio);
                pps1.executeUpdate();
                pps1.close();

                PreparedStatement pps2 = pcDB.connection2().prepareStatement(sqlParametro);
                pps2.executeUpdate();
                pps2.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error de actualizacion " + e);
            }

            int fila = tablaServicios.getRowCount();
            for (int i = fila - 1; i >= 0; i--) {
                modelo.removeRow(i);
            }
             String sql = "select s.*, np.descripcionParametro from servicio s\n"
                + " inner join nivelparametro np on s.idParametroTipoServicio = np.idParametro"
                + " where np.tipoParameto = 'Tipo Servicio'";

        String datos[] = new String[5];
        Statement st;
        try {
            st = pcDB.connection2().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(6);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(2);
                datos[4] = rs.getString(5);
                modelo.addRow(datos);
            }
            tablaServicios.setModel(modelo);
        } catch (Exception e) {
        }
        }
    }//GEN-LAST:event_btnactualizarActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        FormEmpleado fe = new FormEmpleado();
        fe.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void txtMontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMontoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMontoActionPerformed

    private void txtEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEstadoActionPerformed

    private void tablaServiciosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaServiciosMouseClicked

        int filaSeleccionada = tablaServicios.rowAtPoint(evt.getPoint());
        txtTipoServicio.setText(tablaServicios.getValueAt(filaSeleccionada, 1).toString());
        tipoServicio = tablaServicios.getValueAt(filaSeleccionada, 1).toString();
        txtADescripcion.setText(tablaServicios.getValueAt(filaSeleccionada, 2).toString());
        txtMonto.setText(tablaServicios.getValueAt(filaSeleccionada, 3).toString());
        txtEstado.setText(tablaServicios.getValueAt(filaSeleccionada, 4).toString());
    }//GEN-LAST:event_tablaServiciosMouseClicked

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
            java.util.logging.Logger.getLogger(ListadoServicios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListadoServicios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListadoServicios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListadoServicios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListadoServicios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnactualizar;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablaServicios;
    private javax.swing.JTextArea txtADescripcion;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtMonto;
    private javax.swing.JTextField txtTipoServicio;
    private javax.swing.JLabel txtnombre;
    // End of variables declaration//GEN-END:variables
}
