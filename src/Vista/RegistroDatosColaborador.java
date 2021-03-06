package Vista;

import Controlador.DBColaborador;
import Controlador.DBNivelParametros;
import Controlador.DBPersona;
import Controlador.DBUsuario;
import javax.swing.JOptionPane;
import Modelo.probarConexionDB;
import static Vista.RegistroDatosEmpleado.usuario;

public class RegistroDatosColaborador extends javax.swing.JFrame {

    @SuppressWarnings("deprecation")

    public RegistroDatosColaborador() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    public static int idPersona;
    RegistrarCuenta rc = new RegistrarCuenta();

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        txtnombre = new javax.swing.JTextField();
        txtapellido = new javax.swing.JTextField();
        rbtnmasculino = new javax.swing.JRadioButton();
        rbtnfemenino = new javax.swing.JRadioButton();
        txtdni = new javax.swing.JTextField();
        btnenviar = new javax.swing.JButton();
        txtZonaLaboral = new javax.swing.JTextField();
        cboxTecnico = new javax.swing.JCheckBox();
        cboxIngeniero = new javax.swing.JCheckBox();
        cboxAuxiliarTecnico = new javax.swing.JCheckBox();
        txttelefono = new javax.swing.JTextField();
        btnVolver = new javax.swing.JButton();
        txtdireccion = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        jLabel4.setText("jLabel4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(23, 23, 23));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(txtnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 290, 240, -1));
        jPanel1.add(txtapellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 330, 240, -1));

        rbtnmasculino.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        rbtnmasculino.setForeground(new java.awt.Color(255, 255, 255));
        rbtnmasculino.setText("Masculino");
        rbtnmasculino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnmasculinoActionPerformed(evt);
            }
        });
        jPanel1.add(rbtnmasculino, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 490, -1, -1));

        rbtnfemenino.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        rbtnfemenino.setForeground(new java.awt.Color(255, 255, 255));
        rbtnfemenino.setText("Femenino");
        rbtnfemenino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnfemeninoActionPerformed(evt);
            }
        });
        jPanel1.add(rbtnfemenino, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 490, -1, -1));
        jPanel1.add(txtdni, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 370, 240, -1));

        btnenviar.setFont(new java.awt.Font("Open Sans", 1, 14)); // NOI18N
        btnenviar.setText("ENVIAR");
        btnenviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnenviarActionPerformed(evt);
            }
        });
        jPanel1.add(btnenviar, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 680, 140, 50));

        txtZonaLaboral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtZonaLaboralActionPerformed(evt);
            }
        });
        jPanel1.add(txtZonaLaboral, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 530, 240, -1));

        cboxTecnico.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        cboxTecnico.setForeground(new java.awt.Color(255, 255, 255));
        cboxTecnico.setText("T??cnico");
        jPanel1.add(cboxTecnico, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 570, -1, -1));

        cboxIngeniero.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        cboxIngeniero.setForeground(new java.awt.Color(255, 255, 255));
        cboxIngeniero.setText("Ingeniero");
        jPanel1.add(cboxIngeniero, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 570, -1, -1));

        cboxAuxiliarTecnico.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        cboxAuxiliarTecnico.setForeground(new java.awt.Color(255, 255, 255));
        cboxAuxiliarTecnico.setText("Auxiliar t??cnico");
        jPanel1.add(cboxAuxiliarTecnico, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 570, -1, -1));
        jPanel1.add(txttelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 450, 240, -1));

        btnVolver.setFont(new java.awt.Font("Open Sans", 1, 14)); // NOI18N
        btnVolver.setText("VOLVER");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        jPanel1.add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 680, 140, 50));

        txtdireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdireccionActionPerformed(evt);
            }
        });
        jPanel1.add(txtdireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 410, 240, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/register.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 590, 850));

        jLabel2.setFont(new java.awt.Font("Signatra DEMO", 1, 72)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Registro de datos colaborador");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 100, 670, 110));

        jLabel9.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(153, 153, 153));
        jLabel9.setText("Rellene sus datos correctamente.");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 220, 300, -1));

        jLabel3.setFont(new java.awt.Font("Bludhaven", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nombres");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 290, -1, -1));

        jLabel5.setFont(new java.awt.Font("Bludhaven", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Apellidos");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 330, -1, -1));

        jLabel7.setFont(new java.awt.Font("Bludhaven", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("DNI");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 370, -1, -1));

        jLabel13.setFont(new java.awt.Font("Bludhaven", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Direcci??n");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 410, -1, -1));

        jLabel14.setFont(new java.awt.Font("Bludhaven", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Tel??fono");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 450, -1, -1));

        jLabel6.setFont(new java.awt.Font("Bludhaven", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("G??nero");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 490, -1, -1));

        jLabel8.setFont(new java.awt.Font("Bludhaven", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Zona Laboral");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 530, -1, -1));

        jLabel12.setFont(new java.awt.Font("Bludhaven", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Tipo de Colaborador");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 570, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1285, 850));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rbtnmasculinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnmasculinoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtnmasculinoActionPerformed

    private void rbtnfemeninoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnfemeninoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtnfemeninoActionPerformed

    private void txtZonaLaboralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtZonaLaboralActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtZonaLaboralActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        Login l = new Login();
        l.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnenviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnenviarActionPerformed
        probarConexionDB pc = new probarConexionDB();
        String nombres = txtnombre.getText();
        String apellidos = txtapellido.getText();
        String dni = txtdni.getText();
        String direccion = txtdireccion.getText();
        String telefono = txttelefono.getText();
        String zonaLaboral = txtZonaLaboral.getText();
        int sexo = 0;
        int tipocolaborador = 0;
        int tipoUsuario;
        usuario = rc.usuarioDE;
        DBNivelParametros np = new DBNivelParametros();
        probarConexionDB pcDB = new probarConexionDB();
        if (rbtnfemenino.isSelected() == true) {
            sexo = np.Validar(pc.connection2(), rbtnfemenino.getLabel());

        } else if (rbtnmasculino.isSelected() == true) {
            sexo = np.Validar(pc.connection2(), rbtnmasculino.getLabel());
        } else {
            JOptionPane.showMessageDialog(null, "Debe ingresar un genero!");
        }
        DBPersona p = new DBPersona();
        DBColaborador c = new DBColaborador();
        RegistrarCuenta rc = new RegistrarCuenta();
        DBUsuario u = new DBUsuario();

        p.AgregarPersona(pc.connection2(), nombres, apellidos, rc.correo, direccion, dni, telefono, sexo);
        if (p.bandAgregarPersona == true) {
            tipoUsuario = np.Validar(pc.connection2(), "Colaborador");
            idPersona = p.AsignarIDPersona(pc.connection2(), dni);
            u.AgregarUsuarioA(pc.connection2(), usuario, idPersona, tipoUsuario);
            if (u.bandAgregarUsuario == true) {
                Login l = new Login();
                l.setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Error no se pudo crear el Usuario!");
            }

            if (cboxTecnico.isSelected() == true) {
                tipocolaborador = np.Validar(pc.connection2(), cboxTecnico.getLabel());

            } else if (cboxIngeniero.isSelected() == true) {
                tipocolaborador = np.Validar(pc.connection2(), cboxIngeniero.getLabel());
            } else if (cboxAuxiliarTecnico.isSelected() == true) {
                tipocolaborador = np.Validar(pc.connection2(), cboxAuxiliarTecnico.getLabel());
            } else {
                JOptionPane.showMessageDialog(null, "Debe ingresar el tipo de colaborador!");
            }
            c.AgregarColaborador(pc.connection2(), tipocolaborador, p.AsignarIDPersona(pc.connection2(), dni), zonaLaboral);
            if (c.bandAgregarColaborador == true) {
                Login l = new Login();
                l.setVisible(true);
                this.dispose();
            }

        }
    }//GEN-LAST:event_btnenviarActionPerformed

    private void txtdireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdireccionActionPerformed

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
            java.util.logging.Logger.getLogger(RegistroDatosColaborador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistroDatosColaborador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistroDatosColaborador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroDatosColaborador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistroDatosColaborador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVolver;
    private javax.swing.JButton btnenviar;
    private javax.swing.JCheckBox cboxAuxiliarTecnico;
    private javax.swing.JCheckBox cboxIngeniero;
    private javax.swing.JCheckBox cboxTecnico;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JRadioButton rbtnfemenino;
    private javax.swing.JRadioButton rbtnmasculino;
    private javax.swing.JTextField txtZonaLaboral;
    private javax.swing.JTextField txtapellido;
    private javax.swing.JTextField txtdireccion;
    private javax.swing.JTextField txtdni;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txttelefono;
    // End of variables declaration//GEN-END:variables
}
