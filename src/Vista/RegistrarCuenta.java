package Vista;

import Controlador.DBRegistraCuenta;
import Modelo.probarConexionDB;
import javax.swing.JOptionPane;

public class RegistrarCuenta extends javax.swing.JFrame {

    public static String correo = "";
    public static String usuarioDE = "";

    public RegistrarCuenta() {
        initComponents();
        this.setLocationRelativeTo(null);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtusuario = new javax.swing.JTextField();
        txtcorreoempleado = new javax.swing.JTextField();
        txtcontraseñaempleado = new javax.swing.JTextField();
        txtconfirmarcontraseñaempleado = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(23, 23, 23));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(0, 102, 153));
        jLabel2.setFont(new java.awt.Font("Signatra DEMO", 1, 60)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Registra tu cuenta");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 120, -1, 60));

        jLabel1.setFont(new java.awt.Font("Bludhaven", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Usuario");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 230, -1, -1));

        jLabel3.setFont(new java.awt.Font("Bludhaven", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Correo");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 280, -1, -1));

        jLabel4.setFont(new java.awt.Font("Bludhaven", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Contraseña");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 330, -1, -1));

        jLabel5.setFont(new java.awt.Font("Bludhaven", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Confirmar Contraseña");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 380, -1, -1));
        jPanel1.add(txtusuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 230, 200, -1));
        jPanel1.add(txtcorreoempleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 280, 200, -1));
        jPanel1.add(txtcontraseñaempleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 330, 200, -1));
        jPanel1.add(txtconfirmarcontraseñaempleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 380, 200, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Sign Up.png"))); // NOI18N
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 580, 260, -1));

        btnSalir.setFont(new java.awt.Font("Open Sans", 1, 14)); // NOI18N
        btnSalir.setText("SALIR");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 480, 140, 50));

        btnRegistrar.setFont(new java.awt.Font("Open Sans", 1, 14)); // NOI18N
        btnRegistrar.setText("REGISTRAR");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 480, 140, 50));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/crear.png"))); // NOI18N
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 590, 850));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1285, 850));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        RegistroDatosColaborador RDC = new RegistroDatosColaborador();
        RegistroDatosEmpleado RDE = new RegistroDatosEmpleado();
        DBRegistraCuenta DBR = new DBRegistraCuenta();
        probarConexionDB pcDB = new probarConexionDB();
        usuarioDE = txtusuario.getText();
        String contrasenia = String.valueOf(txtcontraseñaempleado.getText());
        String cContrasenia = String.valueOf(txtconfirmarcontraseñaempleado.getText());
        correo = txtcorreoempleado.getText();

        Login l = new Login();
        if (contrasenia.equals(cContrasenia)) {
            DBR.AgregarLoginUsuario(pcDB.connection2(), usuarioDE, contrasenia);
            if (DBR.bandRegistro == true) {
                if (l.bandTipoUsuario == 1) {
                    RDE.setVisible(true);
                    this.dispose();
                } else if (l.bandTipoUsuario == 2) {
                    RDC.setVisible(true);
                    this.dispose();
                }

            } else {
                JOptionPane.showMessageDialog(null, "Ya existe un usuario con ese nombre!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ambas contraseñas deben ser iguales!");

        }

    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        Login l = new Login();
        l.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

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
            java.util.logging.Logger.getLogger(RegistrarCuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrarCuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrarCuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrarCuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistrarCuenta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtconfirmarcontraseñaempleado;
    private javax.swing.JTextField txtcontraseñaempleado;
    private javax.swing.JTextField txtcorreoempleado;
    private javax.swing.JTextField txtusuario;
    // End of variables declaration//GEN-END:variables
}
