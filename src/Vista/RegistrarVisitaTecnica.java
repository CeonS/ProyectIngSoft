package Vista;

import Controlador.DBVisitaTecnica;
import Modelo.probarConexionDB;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class RegistrarVisitaTecnica extends javax.swing.JFrame {

    public RegistrarVisitaTecnica() {
        initComponents();
        this.setLocationRelativeTo(null);
        panelTabla.setVisible(false);
    }

    probarConexionDB pcDB = new probarConexionDB();
    DefaultTableModel modelo = new DefaultTableModel();
    public String proyecto;

    void crearTablaProyecto() {
        modelo.addColumn("ID");
        modelo.addColumn("ID Reunión");
        modelo.addColumn("Fecha Inicial");
        modelo.addColumn("Fecha Final");
        modelo.addColumn("Zona Ejecución");
        modelo.addColumn("Sector");
        modelo.addColumn("Observaciones");
        modelo.addColumn("Estado");

        tablaProyecto.setModel(modelo);
    }
    
    void mostrarTabla() {
        proyecto = txtProyecto.getText();
        String sql = "select p.*, np.descripcionParametro from proyecto p inner join nivelparametro"
                + " np on p.id_Parametro_Sector_Proy = np.idParametro where p.idProyecto = " + proyecto;

        String datos[] = new String[8];
        Statement st;
        try {
            st = pcDB.connection2().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(4);
                datos[3] = rs.getString(5);
                datos[4] = rs.getString(6);
                datos[5] = rs.getString(9);
                datos[6] = rs.getString(8);
                datos[7] = rs.getString(7);
                modelo.addRow(datos);
            }
            tablaProyecto.setModel(modelo);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error listar: " + e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panelTabla = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaProyecto = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        DateCFecha = new com.toedter.calendar.JDateChooser();
        txtProyecto = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane2.setPreferredSize(new java.awt.Dimension(1000, 100));

        tablaProyecto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tablaProyecto);

        panelTabla.add(jScrollPane2);

        jPanel1.add(panelTabla, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 120, 1010, 120));

        jButton2.setFont(new java.awt.Font("Hack Nerd Font", 1, 12)); // NOI18N
        jButton2.setText("SALIR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 300, -1, 30));

        btnRegistrar.setFont(new java.awt.Font("Hack Nerd Font", 0, 12)); // NOI18N
        btnRegistrar.setText("REGISTRAR");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 300, -1, 30));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/blogging bw.png"))); // NOI18N
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 80, 500, 430));

        jLabel6.setFont(new java.awt.Font("Hack Nerd Font", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("REGISTRO DE VISITA TÉCNICA");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 630, 70));

        jLabel7.setFont(new java.awt.Font("Hack Nerd Font", 1, 22)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Proyecto");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, -1, -1));

        jLabel9.setFont(new java.awt.Font("Hack Nerd Font", 1, 22)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Fecha");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, -1, 30));

        DateCFecha.setDateFormatString("yyyy-MM-dd");
        jPanel1.add(DateCFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 160, 160, -1));

        txtProyecto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtProyectoFocusGained(evt);
            }
        });
        txtProyecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProyectoActionPerformed(evt);
            }
        });
        txtProyecto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtProyectoKeyReleased(evt);
            }
        });
        jPanel1.add(txtProyecto, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 120, 190, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/6.jpg"))); // NOI18N
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1490, 360));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtProyectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProyectoActionPerformed
      
    }//GEN-LAST:event_txtProyectoActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        FormEmpleado fe = new FormEmpleado();
        fe.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtProyectoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProyectoKeyReleased
       proyecto = txtProyecto.getText();
        crearTablaProyecto();
        int columna = tablaProyecto.getColumnCount();
        int fila = tablaProyecto.getRowCount();
        if (proyecto.equals("")) {
            panelTabla.setVisible(false);

            if (fila > 0) {
                modelo.removeRow(0);

            }
            if (columna > 8) {
                modelo.setColumnCount(0);
            }
        } else {
            if (columna > 8) {
                modelo.setColumnCount(0);

                if (fila > 0) {
                    modelo.removeRow(0);
                }
                crearTablaProyecto();
                mostrarTabla();
                panelTabla.setVisible(true);
            } else {
                mostrarTabla();
                panelTabla.setVisible(true);
            }

        }
    }//GEN-LAST:event_txtProyectoKeyReleased

    private void txtProyectoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtProyectoFocusGained
        proyecto = txtProyecto.getText();
        if (proyecto.equals("")) {

        } else {
            int columna = tablaProyecto.getColumnCount();
            int fila = tablaProyecto.getRowCount();
            if (columna > 8) {
                modelo.setColumnCount(0);

                if (fila > 0) {
                    modelo.removeRow(0);
                    crearTablaProyecto();
                    mostrarTabla();
                    panelTabla.setVisible(true);
                }

            } else {
                if (fila > 0) {

                } else {
                    mostrarTabla();
                    panelTabla.setVisible(true);
                }

            }
        }
    }//GEN-LAST:event_txtProyectoFocusGained

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
       int idProyecto = Integer.parseInt(txtProyecto.getText());
       Date fechaN = DateCFecha.getDate();
       long d = fechaN.getTime();
       java.sql.Date fecha = new java.sql.Date(d);
       
        DBVisitaTecnica vt = new DBVisitaTecnica();
        vt.AgregarVisitaTecnica(pcDB.connection2(), idProyecto, fecha);
    }//GEN-LAST:event_btnRegistrarActionPerformed

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
            java.util.logging.Logger.getLogger(RegistrarVisitaTecnica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrarVisitaTecnica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrarVisitaTecnica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrarVisitaTecnica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new RegistrarVisitaTecnica().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser DateCFecha;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel panelTabla;
    private javax.swing.JTable tablaProyecto;
    private javax.swing.JTextField txtProyecto;
    // End of variables declaration//GEN-END:variables
}
