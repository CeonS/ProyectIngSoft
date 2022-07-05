package Vista;

import Modelo.probarConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ListadoVisitasTecnicas extends javax.swing.JFrame {

    public ListadoVisitasTecnicas() {
        initComponents();
        this.setLocationRelativeTo(null);
        mostrarTabla();
    }
    DefaultTableModel modelo = new DefaultTableModel();
    probarConexionDB pcDB = new probarConexionDB();
    public static int idVisita;

    void mostrarTabla() {

        modelo.addColumn("ID");
        modelo.addColumn("ID Proyecto");
        modelo.addColumn("Fecha");
        modelo.addColumn("Estado");

        tablaVisitaTecnica.setModel(modelo);

        String sql = "select * from visitastecnicas";

        String datos[] = new String[4];
        Statement st;
        try {
            st = pcDB.connection2().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);

                modelo.addRow(datos);
            }
            tablaVisitaTecnica.setModel(modelo);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error listar: " + e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaVisitaTecnica = new javax.swing.JTable();
        btnactualizar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtDniCliente = new javax.swing.JTextField();
        txtEmpleado = new javax.swing.JTextField();
        txtDniEmpleado = new javax.swing.JTextField();
        txtProyecto = new javax.swing.JTextField();
        txtServicio = new javax.swing.JTextField();
        txtUbicacion = new javax.swing.JTextField();
        txtCliente = new javax.swing.JTextField();
        txtEstado = new javax.swing.JTextField();
        DateCFecha = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaVisitaTecnica.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Cliente", "Dni Cliente", "Empleado", "Dni Empleado", "Servicio", "Proyecto", "Ubicación", "Fecha", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tablaVisitaTecnica.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaVisitaTecnicaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaVisitaTecnica);
        if (tablaVisitaTecnica.getColumnModel().getColumnCount() > 0) {
            tablaVisitaTecnica.getColumnModel().getColumn(0).setResizable(false);
            tablaVisitaTecnica.getColumnModel().getColumn(1).setResizable(false);
            tablaVisitaTecnica.getColumnModel().getColumn(5).setResizable(false);
            tablaVisitaTecnica.getColumnModel().getColumn(8).setResizable(false);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 1450, 330));

        btnactualizar.setFont(new java.awt.Font("Open Sans", 1, 14)); // NOI18N
        btnactualizar.setText("ACTUALIZAR");
        btnactualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnactualizarActionPerformed(evt);
            }
        });
        getContentPane().add(btnactualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 620, 140, 50));

        btnSalir.setFont(new java.awt.Font("Open Sans", 1, 14)); // NOI18N
        btnSalir.setText("SALIR");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(1430, 620, 140, 50));

        jLabel9.setFont(new java.awt.Font("Bludhaven", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Cliente");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 500, -1, -1));

        jLabel10.setFont(new java.awt.Font("Bludhaven", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("DNI Cliente");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 540, -1, -1));

        jLabel11.setFont(new java.awt.Font("Bludhaven", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Empleado");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 580, -1, -1));

        jLabel12.setFont(new java.awt.Font("Bludhaven", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("DNI Empleado");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 620, -1, -1));

        jLabel3.setFont(new java.awt.Font("Bludhaven", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Ubicación");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 620, -1, 20));

        jLabel5.setFont(new java.awt.Font("Bludhaven", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Servicio");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 580, -1, 20));

        jLabel1.setFont(new java.awt.Font("Bludhaven", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Proyecto");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 540, -1, 20));

        jLabel8.setFont(new java.awt.Font("Bludhaven", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Fecha");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 500, -1, 20));

        jLabel4.setFont(new java.awt.Font("Bludhaven", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Estado");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 690, -1, -1));
        getContentPane().add(txtDniCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 540, 220, -1));
        getContentPane().add(txtEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 580, 220, -1));
        getContentPane().add(txtDniEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 620, 220, -1));
        getContentPane().add(txtProyecto, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 540, 220, -1));
        getContentPane().add(txtServicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 580, 220, -1));
        getContentPane().add(txtUbicacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 620, 220, -1));
        getContentPane().add(txtCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 500, 220, -1));
        getContentPane().add(txtEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 690, 170, -1));

        DateCFecha.setDateFormatString("yyyy-MM-dd");
        getContentPane().add(DateCFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 500, 130, -1));

        jLabel2.setFont(new java.awt.Font("Signatra DEMO", 1, 60)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Lista de visitas tecnicas");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 30, 470, 60));

        txtnombre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondolista.png"))); // NOI18N
        getContentPane().add(txtnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1720, 830));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnactualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnactualizarActionPerformed

        String validar = txtEstado.getText();
        if (validar.equals("")) {
            JOptionPane.showMessageDialog(null, "Escoja una fila primero!");
        } else {

            String Estado = txtEstado.getText();

            Date fechaI = DateCFecha.getDate();
            long dI = fechaI.getTime();
            java.sql.Date fechaIN = new java.sql.Date(dI);

            String sqlVisita = "UPDATE visitastecnicas SET fechaVisitasTecnicas = '" + fechaIN + "', estado_visitastecnicas = '" + Estado + "'"
                    + "   where idVisitasTecnicas = '" + idVisita + "'";

            try {

                PreparedStatement pps = pcDB.connection2().prepareStatement(sqlVisita);
                pps.executeUpdate();
                pps.close();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error de actualizacion " + e);
            }
        }

        int fila = tablaVisitaTecnica.getRowCount();
        for (int i = fila - 1; i >= 0; i--) {
            modelo.removeRow(i);
        }

        String sql = "select * from visitastecnicas";

        String datos[] = new String[4];
        Statement st;
        try {
            st = pcDB.connection2().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);

                modelo.addRow(datos);
            }
            tablaVisitaTecnica.setModel(modelo);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error listar: " + e);
        }

    }//GEN-LAST:event_btnactualizarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        if (Login.colaboradorForm == true) {
            FormColaborador fc = new FormColaborador();
            fc.setVisible(true);
            this.dispose();
        } else {
            FormEmpleado fe = new FormEmpleado();
            fe.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnSalirActionPerformed

    private void tablaVisitaTecnicaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaVisitaTecnicaMouseClicked
        int filaSeleccionada = tablaVisitaTecnica.rowAtPoint(evt.getPoint());
        DateCFecha.setDate(java.sql.Date.valueOf(tablaVisitaTecnica.getModel().getValueAt(filaSeleccionada, 2).toString()));
        txtEstado.setText(tablaVisitaTecnica.getValueAt(filaSeleccionada, 3).toString());
        idVisita = Integer.parseInt(tablaVisitaTecnica.getValueAt(filaSeleccionada, 0).toString());


    }//GEN-LAST:event_tablaVisitaTecnicaMouseClicked

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
            java.util.logging.Logger.getLogger(ListadoVisitasTecnicas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListadoVisitasTecnicas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListadoVisitasTecnicas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListadoVisitasTecnicas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new ListadoVisitasTecnicas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser DateCFecha;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnactualizar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaVisitaTecnica;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JTextField txtDniCliente;
    private javax.swing.JTextField txtDniEmpleado;
    private javax.swing.JTextField txtEmpleado;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtProyecto;
    private javax.swing.JTextField txtServicio;
    private javax.swing.JTextField txtUbicacion;
    private javax.swing.JLabel txtnombre;
    // End of variables declaration//GEN-END:variables
}
