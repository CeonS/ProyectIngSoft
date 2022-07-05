package Vista;

import Controlador.DBCliente;
import javax.swing.JOptionPane;
import Controlador.DBLogin;
import Controlador.DBPersona;
import Controlador.DBRellenarFormulariosPerfil;
import Controlador.DBUsuario;
import Modelo.probarConexionDB;

public class Login extends javax.swing.JFrame {

    public static int bandTipoUsuario = 0;
    public static int personaPerfil = 0;

    @SuppressWarnings("deprecation")
    public Login() {
        initComponents();
        this.setLocationRelativeTo(null);
        jlblOcultar.setVisible(false);

    }
    public static boolean colaboradorForm = false, empleadoForm = false;
    DBLogin l = new DBLogin();
    probarConexionDB pcDB = new probarConexionDB();
    DBRellenarFormulariosPerfil RFP = new DBRellenarFormulariosPerfil();
    public static int idCliente;

    public void determinarTipoUsuario(String usu, String pass) {
        DBUsuario u = new DBUsuario();
        DBCliente c = new DBCliente();
        DBUsuario.resultadoT = 0;
        if (DBLogin.bandValidarUsuario == true) {
            u.TipoUsuario(pcDB.connection2(), usu);
            switch (DBUsuario.resultadoT) {
                case 2:
                    empleadoForm = true;
                    FormEmpleado fe = new FormEmpleado();
                    fe.setVisible(true);
                    this.dispose();
                    break;
                case 3:
                    idCliente = c.AsignarIDCliente(pcDB.connection2(), usu);
                    FormCliente fc = new FormCliente(); // no s[e porque no funciona
                    fc.setVisible(true);
                    this.dispose();
                    break;
                case 4:
                    colaboradorForm = true;
                    FormColaborador fcola = new FormColaborador();
                    fcola.setVisible(true);
                    this.dispose();
                    break;
                default:
                    break;
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelFondo = new javax.swing.JPanel();
        jLabelG2R = new javax.swing.JLabel();
        jLabelFondoColor = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtusuario = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnregistrar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        btnregistrocolaborador = new javax.swing.JButton();
        btningresocolaborador1 = new javax.swing.JButton();
        btningresar1 = new javax.swing.JButton();
        jlblOcultar = new javax.swing.JLabel();
        jlblVer = new javax.swing.JLabel();
        txtcontraseña = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelFondo.setBackground(new java.awt.Color(255, 255, 255));
        jPanelFondo.setForeground(new java.awt.Color(52, 52, 52));
        jPanelFondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelG2R.setFont(new java.awt.Font("Open Sans", 1, 18)); // NOI18N
        jLabelG2R.setForeground(new java.awt.Color(255, 255, 255));
        jLabelG2R.setText(" G2R");
        jPanelFondo.add(jLabelG2R, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 350, 50, 30));

        jLabelFondoColor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/login.png"))); // NOI18N
        jPanelFondo.add(jLabelFondoColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 620, 780));

        jLabel1.setFont(new java.awt.Font("Signatra DEMO", 1, 72)); // NOI18N
        jLabel1.setText("Bienvenido");
        jPanelFondo.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 90, -1, -1));

        txtusuario.setForeground(new java.awt.Color(153, 153, 153));
        txtusuario.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtusuario.setName(""); // NOI18N
        txtusuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtusuarioActionPerformed(evt);
            }
        });
        jPanelFondo.add(txtusuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 260, 250, 30));

        jLabel2.setFont(new java.awt.Font("Open Sans", 1, 14)); // NOI18N
        jLabel2.setText("Usuario");
        jPanelFondo.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 230, -1, -1));

        jLabel3.setFont(new java.awt.Font("Open Sans", 1, 14)); // NOI18N
        jLabel3.setText("Contraseña");
        jPanelFondo.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 300, -1, 20));

        btnregistrar.setBackground(new java.awt.Color(0, 0, 0));
        btnregistrar.setFont(new java.awt.Font("Open Sans", 1, 14)); // NOI18N
        btnregistrar.setForeground(new java.awt.Color(255, 255, 255));
        btnregistrar.setText("Registrar");
        btnregistrar.setBorder(null);
        btnregistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregistrarActionPerformed(evt);
            }
        });
        jPanelFondo.add(btnregistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 460, 250, 30));

        jLabel5.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 153, 153));
        jLabel5.setText("¿Eres colaborador de la empresa?");
        jPanelFondo.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 510, -1, -1));

        btnregistrocolaborador.setBackground(new java.awt.Color(204, 204, 204));
        btnregistrocolaborador.setFont(new java.awt.Font("Open Sans", 1, 14)); // NOI18N
        btnregistrocolaborador.setText("Registrar");
        btnregistrocolaborador.setBorder(null);
        btnregistrocolaborador.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnregistrocolaborador.setFocusCycleRoot(true);
        btnregistrocolaborador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregistrocolaboradorActionPerformed(evt);
            }
        });
        jPanelFondo.add(btnregistrocolaborador, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 590, 250, 30));

        btningresocolaborador1.setBackground(new java.awt.Color(204, 204, 204));
        btningresocolaborador1.setFont(new java.awt.Font("Open Sans", 1, 14)); // NOI18N
        btningresocolaborador1.setText("Ingresar");
        btningresocolaborador1.setBorder(null);
        btningresocolaborador1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btningresocolaborador1.setFocusCycleRoot(true);
        btningresocolaborador1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btningresocolaborador1ActionPerformed(evt);
            }
        });
        jPanelFondo.add(btningresocolaborador1, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 540, 250, 30));

        btningresar1.setBackground(new java.awt.Color(0, 0, 0));
        btningresar1.setFont(new java.awt.Font("Open Sans", 1, 14)); // NOI18N
        btningresar1.setForeground(new java.awt.Color(255, 255, 255));
        btningresar1.setText("Ingresar");
        btningresar1.setBorder(null);
        btningresar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btningresar1ActionPerformed(evt);
            }
        });
        jPanelFondo.add(btningresar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 410, 250, 30));

        jlblOcultar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlblOcultarMouseClicked(evt);
            }
        });
        jPanelFondo.add(jlblOcultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 250, 50, 50));

        jlblVer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlblVerMouseClicked(evt);
            }
        });
        jPanelFondo.add(jlblVer, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 250, 50, 50));

        txtcontraseña.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelFondo.add(txtcontraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 330, 250, 30));

        getContentPane().add(jPanelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1180, 780));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtusuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtusuarioActionPerformed

    }//GEN-LAST:event_txtusuarioActionPerformed

    private void btnregistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregistrarActionPerformed
        RegistrarCuenta RC = new RegistrarCuenta();
        RC.setVisible(true);
        this.dispose();
        bandTipoUsuario = 1;
    }//GEN-LAST:event_btnregistrarActionPerformed

    private void btnregistrocolaboradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregistrocolaboradorActionPerformed
        RegistrarCuenta RC = new RegistrarCuenta();
        RC.setVisible(true);
        this.dispose();
        bandTipoUsuario = 2;
    }//GEN-LAST:event_btnregistrocolaboradorActionPerformed

    private void btningresar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btningresar1ActionPerformed
        String usu = txtusuario.getText();
        String pass = String.valueOf(txtcontraseña.getPassword());
        DBPersona p = new DBPersona();
        RegistroDatosEmpleado de = new RegistroDatosEmpleado();
        if (usu.equalsIgnoreCase("") && pass.equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(null, "Los campos están vacíos!");

        } else {
            l.ValidarUsuario(pcDB.connection2(), usu, pass);
            if (DBLogin.bandValidarUsuario == true) {
                p.ValidarPersona(pcDB.connection2(), usu, pass);
                if (DBPersona.bandValidaPersona == false) {
                    de.setVisible(true);
                    this.dispose();

                } else {

                    DBUsuario usuario = new DBUsuario();
                    usuario.TipoUsuario(pcDB.connection2(), usu);
                    if (DBUsuario.resultadoT != 4) {
                        personaPerfil = RFP.AsignarPerfil(pcDB.connection2(), usu);
                        determinarTipoUsuario(usu, pass);

                    } else {
                        JOptionPane.showMessageDialog(null, "Inicie sesión como Colaborador!");
                    }
                }
            } else {
                txtusuario.setText("");
                txtcontraseña.setText("");
            }

        }
    }//GEN-LAST:event_btningresar1ActionPerformed

    private void btningresocolaborador1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btningresocolaborador1ActionPerformed
        String usu = txtusuario.getText();
        String pass = String.valueOf(txtcontraseña.getPassword());
        DBPersona p = new DBPersona();
        RegistroDatosColaborador dc = new RegistroDatosColaborador();
        if (usu.equalsIgnoreCase("") && pass.equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(null, "Los campos están vacíos!");

        } else {
            l.ValidarUsuario(pcDB.connection2(), usu, pass);
            if (DBLogin.bandValidarUsuario == true) {
                p.ValidarPersona(pcDB.connection2(), usu, pass);
                if (DBPersona.bandValidaPersona == false) {
                    dc.setVisible(true);
                    this.dispose();
                } else {
                    DBUsuario usuario = new DBUsuario();

                    usuario.TipoUsuario(pcDB.connection2(), usu);
                    if (DBUsuario.resultadoT == 4) {
                        colaboradorForm = true;
                        personaPerfil = RFP.AsignarPerfil(pcDB.connection2(), usu);
                        determinarTipoUsuario(usu, pass);

                    } else if (DBUsuario.resultadoT != 2) {
                        JOptionPane.showMessageDialog(null, "Inicie sesión como Cliente!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Inicie sesión como Empleado!");
                    }
                }
            } else {
                txtusuario.setText("");
                txtcontraseña.setText("");
            }

        }

    }//GEN-LAST:event_btningresocolaborador1ActionPerformed

    private void jlblVerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlblVerMouseClicked
        txtcontraseña.setEchoChar((char) 0);
        jlblVer.setVisible(false);
        jlblOcultar.setVisible(true);
    }//GEN-LAST:event_jlblVerMouseClicked

    private void jlblOcultarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlblOcultarMouseClicked

        txtcontraseña.setEchoChar('*');
        jlblOcultar.setVisible(false);
        jlblVer.setVisible(true);
    }//GEN-LAST:event_jlblOcultarMouseClicked

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btningresar1;
    private javax.swing.JButton btningresocolaborador1;
    private javax.swing.JButton btnregistrar;
    private javax.swing.JButton btnregistrocolaborador;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelFondoColor;
    private javax.swing.JLabel jLabelG2R;
    private javax.swing.JPanel jPanelFondo;
    private javax.swing.JLabel jlblOcultar;
    private javax.swing.JLabel jlblVer;
    private javax.swing.JPasswordField txtcontraseña;
    private javax.swing.JTextField txtusuario;
    // End of variables declaration//GEN-END:variables
}
