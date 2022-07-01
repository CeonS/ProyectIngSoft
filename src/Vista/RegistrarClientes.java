package Vista;

import Controlador.DBCliente;
import Controlador.DBNivelParametros;
import Controlador.DBPersona;
import Controlador.DBRegistraCuenta;
import Controlador.DBRellenarFormulariosPerfil;

import Controlador.DBUsuario;
import Controlador.Parametros;
import Modelo.probarConexionDB;
import static Vista.Login.personaPerfil;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class RegistrarClientes extends javax.swing.JFrame {

    @SuppressWarnings("deprecation")
    public static int personaPerfil = 0;
    probarConexionDB pcDB = new probarConexionDB();
    DBRellenarFormulariosPerfil RFP = new DBRellenarFormulariosPerfil();

    public RegistrarClientes() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    private void llenarSectores() {

        DBCliente c = new DBCliente();
        ArrayList<Parametros> listaServicios = c.getTipoClientes(pcDB.connection2());

        cbxTipoCliente.removeAllItems();

        for (int i = 0; i < listaServicios.size(); i++) {
            cbxTipoCliente.addItem(listaServicios.get(i).getDescripcionParametro());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        cbxTipoCliente = new javax.swing.JComboBox<>();
        txtCorreo = new javax.swing.JTextField();
        txtDNI = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        txtApellidos = new javax.swing.JTextField();
        txtNombres = new javax.swing.JTextField();
        rbtnmasculino = new javax.swing.JRadioButton();
        rbtnfemenino = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton2.setFont(new java.awt.Font("Hack Nerd Font", 1, 12)); // NOI18N
        jButton2.setText("SALIR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 470, -1, 30));

        btnRegistrar.setFont(new java.awt.Font("Hack Nerd Font", 0, 12)); // NOI18N
        btnRegistrar.setText("REGISTRAR");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 470, -1, 30));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/blogging bw.png"))); // NOI18N
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 80, 500, 430));

        jLabel6.setFont(new java.awt.Font("Hack Nerd Font", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("REGISTRO DE CLIENTES");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 490, 70));

        jLabel7.setFont(new java.awt.Font("Hack Nerd Font", 1, 22)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Apellidos");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, -1, -1));

        jLabel1.setFont(new java.awt.Font("Hack Nerd Font", 1, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nombres");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, -1, -1));

        jLabel9.setFont(new java.awt.Font("Hack Nerd Font", 1, 22)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Teléfono");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 330, -1, 30));

        jLabel11.setFont(new java.awt.Font("Hack Nerd Font", 1, 22)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Correo");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, -1, 30));

        jLabel12.setFont(new java.awt.Font("Hack Nerd Font", 1, 22)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Dirección");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 290, -1, 30));

        jLabel13.setFont(new java.awt.Font("Hack Nerd Font", 1, 22)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Género");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 370, -1, 30));

        jLabel14.setFont(new java.awt.Font("Hack Nerd Font", 1, 22)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("DNI");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, -1, 30));

        jLabel15.setFont(new java.awt.Font("Hack Nerd Font", 1, 22)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Tipo cliente");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 410, -1, 30));

        cbxTipoCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hogar", "Oficinas Administrativas", "Industrias", "MYPES" }));
        cbxTipoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxTipoClienteActionPerformed(evt);
            }
        });
        jPanel1.add(cbxTipoCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 410, 200, 30));

        txtCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoActionPerformed(evt);
            }
        });
        jPanel1.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 210, 190, -1));

        txtDNI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDNIActionPerformed(evt);
            }
        });
        jPanel1.add(txtDNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 250, 190, -1));

        txtTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoActionPerformed(evt);
            }
        });
        jPanel1.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 330, 190, -1));

        txtDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionActionPerformed(evt);
            }
        });
        jPanel1.add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 290, 190, -1));

        txtApellidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidosActionPerformed(evt);
            }
        });
        jPanel1.add(txtApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 170, 190, -1));

        txtNombres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombresActionPerformed(evt);
            }
        });
        jPanel1.add(txtNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 130, 190, -1));

        rbtnmasculino.setFont(new java.awt.Font("Hack Nerd Font", 1, 14)); // NOI18N
        rbtnmasculino.setForeground(new java.awt.Color(255, 255, 255));
        rbtnmasculino.setText("Masculino");
        jPanel1.add(rbtnmasculino, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 370, -1, -1));

        rbtnfemenino.setFont(new java.awt.Font("Hack Nerd Font", 1, 14)); // NOI18N
        rbtnfemenino.setForeground(new java.awt.Color(255, 255, 255));
        rbtnfemenino.setText("Femenino");
        jPanel1.add(rbtnfemenino, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 370, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/6.jpg"))); // NOI18N
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 510));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombresActionPerformed

    private void txtCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorreoActionPerformed

    private void txtDNIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDNIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDNIActionPerformed

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoActionPerformed

    private void txtDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionActionPerformed

    private void txtApellidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidosActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        FormEmpleado fe = new FormEmpleado();
        fe.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void cbxTipoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTipoClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxTipoClienteActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        DBPersona p = new DBPersona();
        probarConexionDB pcDB = new probarConexionDB();
        String nombres = txtNombres.getText();
        String apellidos = txtApellidos.getText();
        String dni = txtDNI.getText();
        String direccion = txtDireccion.getText();
        String telefono = txtTelefono.getText();
        String correo = txtCorreo.getText();
        String tipoCliente = String.valueOf(cbxTipoCliente.getSelectedItem());
        int sexo = 0;
        DBNivelParametros np = new DBNivelParametros();
        DBCliente c = new DBCliente();
        DBUsuario u = new DBUsuario();
        DBRegistraCuenta rc = new DBRegistraCuenta();

        if (rbtnfemenino.isSelected() == true) {
            sexo = np.Validar(pcDB.connection2(), rbtnfemenino.getLabel());

        } else if (rbtnmasculino.isSelected() == true) {
            sexo = np.Validar(pcDB.connection2(), rbtnmasculino.getLabel());
        } else {
            JOptionPane.showMessageDialog(null, "Debe ingresar un genero!");
        }

        p.AgregarPersona(pcDB.connection2(), nombres, apellidos, correo, direccion, dni, telefono, sexo);

        String[] frag = nombres.split(" ");

        if (p.bandAgregarPersona == true) {
            rc.AgregarLoginUsuario(pcDB.connection2(), frag[0] + dni, dni);
            u.AsignarUsuario(pcDB.connection2(), frag[0] + dni);
            if (u.ExisteUsuario == true) {

                c.AgregarCliente(pcDB.connection2(), np.Validar(pcDB.connection2(), tipoCliente), p.AsignarIDPersona(pcDB.connection2(), dni));
            } else {
                u.AgregarUsuarioCliente(pcDB.connection2(), p.AsignarIDPersona(pcDB.connection2(), dni), frag[0], dni);
                c.AgregarCliente(pcDB.connection2(), np.Validar(pcDB.connection2(), tipoCliente), p.AsignarIDPersona(pcDB.connection2(), dni));
            }
        }
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
            java.util.logging.Logger.getLogger(RegistrarClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrarClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrarClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrarClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistrarClientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox<String> cbxTipoCliente;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton rbtnfemenino;
    private javax.swing.JRadioButton rbtnmasculino;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDNI;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
