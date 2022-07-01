package Vista;

import Modelo.probarConexionDB;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class FormColaborador extends javax.swing.JFrame {

    public FormColaborador() {
        initComponents();
        this.setLocationRelativeTo(null);
        
    }

    public static boolean colaboradorForm = false;
     String datos [] = new String[9];

    public void RellenarPerfil() {
        Login l = new Login();
        probarConexionDB pcDB = new probarConexionDB();
        int id = 0;
        int resultado = 0;
        String SQL = "select * from persona p"
                + " inner join colaborador c on p.idPersona = c.id_Persona_Tec "
                + "where p.idPersona = " + l.personaPerfil;
        try {
            Statement st = pcDB.connection2().createStatement();
            ResultSet rs = st.executeQuery(SQL);

            if (rs.next()) {
                resultado = 1;

                if (resultado == 1) {

                    datos[0] = rs.getString("nombres");
                    datos[1] = rs.getString("p.apellidos");
                    datos[2] = rs.getString("p.direccion");
                    datos[3] = rs.getString("p.telefono");
                    datos[4] = rs.getString("p.dni");
                    datos[5] = rs.getString("p.correo");
                    datos[6] = rs.getString("p.id_ParametroGenero");
                    datos[7] = rs.getString("c.zonaLaboral");
                    datos[8] = rs.getString("id_Parametro_Tipo_Colaborador");
                    if(datos[6].equalsIgnoreCase("6")){
                        txtGenero.setText("Femenino");
                    }else{
                        txtGenero.setText("Masculino");
                    }
                    if(datos[8].equalsIgnoreCase("7")){
                        txtTipoColaborador.setText("Técnico");
                    }else if(datos[9].equalsIgnoreCase("8")){
                        txtTipoColaborador.setText("Ingeniero");
                    }else {
                        txtTipoColaborador.setText("Auxiliar Técnico");
                    }
                    txtNombres.setText(datos[0]);
                    txtApellidos.setText(datos[1]);
                    txtDireccion.setText(datos[2]);
                    txtTelefono.setText(datos[3]);
                    txtDNI.setText(datos[4]);
                    txtCorreo.setText(datos[5]);
                    txtZonaLaboral.setText(datos[7]);
             

                }
            } else {
                JOptionPane.showMessageDialog(null, "Error de Acceso, Usuario No Registrado");
            }
            pcDB.connection2().close();
            st.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de Registro " + e.getMessage());
        }
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtNombres = new javax.swing.JTextField();
        txtApellidos = new javax.swing.JTextField();
        txtDNI = new javax.swing.JTextField();
        txtZonaLaboral = new javax.swing.JTextField();
        txtTipoColaborador = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtGenero = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        btnCerrarSesion = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        btnvisualizarproyecto = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        btnvisualizarvisitatecnica = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        btnvisualizarclientes = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setForeground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(153, 204, 255));
        jPanel3.setMinimumSize(new java.awt.Dimension(790, 420));
        jPanel3.setPreferredSize(new java.awt.Dimension(790, 420));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Poe.png"))); // NOI18N
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, -10, 340, 350));

        jLabel2.setFont(new java.awt.Font("Hack Nerd Font", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 153));
        jLabel2.setText("BIENVENIDO A G2R SOLUTIONS");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        jLabel3.setFont(new java.awt.Font("Hack Nerd Font", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 102));
        jLabel3.setText("<html><h2>Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Etiam viverra arcu dui, ut eleifend eros eleifend et. Ut commodo congue augue, vitae scelerisque augue congue sit amet. </h2> ");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 390, 290));

        jTabbedPane1.addTab("Inicio", jPanel3);

        jPanel4.setBackground(new java.awt.Color(153, 204, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Background.png"))); // NOI18N
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        jLabel5.setFont(new java.awt.Font("Hack Nerd Font", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Colaborador");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        jLabel6.setFont(new java.awt.Font("Hack Nerd Font", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Nombres");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 90, -1, -1));

        jLabel7.setFont(new java.awt.Font("Hack Nerd Font", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Apellidos");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 130, -1, -1));

        jLabel8.setFont(new java.awt.Font("Hack Nerd Font", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("DNI");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 170, -1, -1));

        jLabel9.setFont(new java.awt.Font("Hack Nerd Font", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("Zona Laboral");
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 370, -1, -1));

        jLabel10.setFont(new java.awt.Font("Hack Nerd Font", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setText("Tipo Colaborador");
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 410, -1, -1));

        txtNombres.setEnabled(false);
        jPanel4.add(txtNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 90, 180, -1));

        txtApellidos.setEnabled(false);
        txtApellidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidosActionPerformed(evt);
            }
        });
        jPanel4.add(txtApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 130, 180, -1));

        txtDNI.setEnabled(false);
        jPanel4.add(txtDNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 170, 180, -1));

        txtZonaLaboral.setEnabled(false);
        jPanel4.add(txtZonaLaboral, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 370, 180, -1));

        txtTipoColaborador.setEnabled(false);
        jPanel4.add(txtTipoColaborador, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 410, 180, -1));

        jLabel11.setText("Desde enero del 2022");
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 160, 150, -1));

        jLabel12.setFont(new java.awt.Font("Hack Nerd Font", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 51, 51));
        jLabel12.setText("Género");
        jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 250, -1, -1));

        txtGenero.setEnabled(false);
        jPanel4.add(txtGenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 250, 180, -1));

        jLabel13.setFont(new java.awt.Font("Hack Nerd Font", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(51, 51, 51));
        jLabel13.setText("Datos generales del colaborador");
        jPanel4.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 50, -1, -1));

        jLabel21.setFont(new java.awt.Font("Hack Nerd Font", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(51, 51, 51));
        jLabel21.setText("Dirección");
        jPanel4.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 290, -1, -1));

        txtDireccion.setEnabled(false);
        jPanel4.add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 290, 180, -1));

        jLabel23.setFont(new java.awt.Font("Hack Nerd Font", 1, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(51, 51, 51));
        jLabel23.setText("Teléfono");
        jPanel4.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 330, -1, -1));

        txtTelefono.setEnabled(false);
        jPanel4.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 330, 180, -1));

        jLabel24.setFont(new java.awt.Font("Hack Nerd Font", 1, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(51, 51, 51));
        jLabel24.setText("Correo");
        jPanel4.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 210, -1, -1));

        txtCorreo.setEnabled(false);
        jPanel4.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 210, 180, -1));

        btnCerrarSesion.setText("Cerrar Sesión");
        btnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesionActionPerformed(evt);
            }
        });
        jPanel4.add(btnCerrarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 30, 140, 50));

        jTabbedPane1.addTab("Perfil", jPanel4);

        jPanel6.setBackground(new java.awt.Color(153, 204, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnvisualizarproyecto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/visualizacion.png"))); // NOI18N
        jPanel6.add(btnvisualizarproyecto, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 110, 140, -1));

        jLabel16.setFont(new java.awt.Font("Hack Nerd Font", 1, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 102, 153));
        jLabel16.setText("VISUALIZAR");
        jPanel6.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 60, -1, -1));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/gestion-de-proyectos.png"))); // NOI18N
        jPanel6.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, -30, -1, -1));

        jTabbedPane1.addTab("Proyecto", jPanel6);

        jPanel7.setBackground(new java.awt.Color(153, 204, 255));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnvisualizarvisitatecnica.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/visualizacion.png"))); // NOI18N
        btnvisualizarvisitatecnica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnvisualizarvisitatecnicaActionPerformed(evt);
            }
        });
        jPanel7.add(btnvisualizarvisitatecnica, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 120, 140, -1));

        jLabel20.setFont(new java.awt.Font("Hack Nerd Font", 1, 24)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 102, 153));
        jLabel20.setText("VISUALIZAR");
        jPanel7.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 70, -1, -1));

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/soporte-tecnico.png"))); // NOI18N
        jPanel7.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 0, -1, -1));

        jTabbedPane1.addTab("Visita Técnica", jPanel7);

        jPanel2.setBackground(new java.awt.Color(153, 204, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel22.setFont(new java.awt.Font("Hack Nerd Font", 1, 24)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 102, 153));
        jLabel22.setText("VISUALIZAR");
        jPanel2.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 100, -1, -1));

        btnvisualizarclientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/comentarios.png"))); // NOI18N
        btnvisualizarclientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnvisualizarclientesActionPerformed(evt);
            }
        });
        jPanel2.add(btnvisualizarclientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 150, 143, -1));

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/kyc.png"))); // NOI18N
        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 0, -1, -1));

        jTabbedPane1.addTab("Clientes", jPanel2);

        jPanel1.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, 620));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
        RellenarPerfil();
    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void btnvisualizarclientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnvisualizarclientesActionPerformed
        colaboradorForm = true;
        ListadoClientes lc = new ListadoClientes();
        lc.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnvisualizarclientesActionPerformed

    private void btnvisualizarvisitatecnicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnvisualizarvisitatecnicaActionPerformed
        colaboradorForm = true;
        ListadoVisitasTecnicas lvt = new ListadoVisitasTecnicas();
        lvt.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnvisualizarvisitatecnicaActionPerformed

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
        Login l = new Login();
        l.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCerrarSesionActionPerformed

    private void txtApellidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidosActionPerformed

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
            java.util.logging.Logger.getLogger(FormColaborador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormColaborador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormColaborador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormColaborador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new FormColaborador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnvisualizarclientes;
    private javax.swing.JButton btnvisualizarproyecto;
    private javax.swing.JButton btnvisualizarvisitatecnica;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDNI;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtGenero;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtTipoColaborador;
    private javax.swing.JTextField txtZonaLaboral;
    // End of variables declaration//GEN-END:variables
}
