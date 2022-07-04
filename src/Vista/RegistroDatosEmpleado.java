package Vista;

import Modelo.probarConexionDB;
import javax.swing.JOptionPane;
import Controlador.DBNivelParametros;
import Controlador.DBPersona;
import Controlador.DBUsuario;

public class RegistroDatosEmpleado extends javax.swing.JFrame {

    probarConexionDB pc = new probarConexionDB();
    public static String usuario;

    @SuppressWarnings("deprecation")
    public RegistroDatosEmpleado() {
        initComponents();
        this.setLocationRelativeTo(null);
        
    }
RegistrarCuenta rc = new RegistrarCuenta();
DBNivelParametros np = new DBNivelParametros();
    public int determinarGenero() {
        int sexo = 0;
        
        if (rbtnfemenino.isSelected() == true) {
            sexo = np.Validar(pc.connection2(), rbtnfemenino.getLabel());

        } else if (rbtnmasculino.isSelected() == true) {
            sexo = np.Validar(pc.connection2(), rbtnmasculino.getLabel());
        } else {
            JOptionPane.showMessageDialog(null, "Debe ingresar un genero!");
        }
        return sexo;
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        txtapellido = new javax.swing.JTextField();
        txtdni = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        btnenviar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        rbtnmasculino = new javax.swing.JRadioButton();
        rbtnfemenino = new javax.swing.JRadioButton();
        txtelefono = new javax.swing.JTextField();
        btnVolver = new javax.swing.JButton();
        txtDireccion = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        lblusuario = new javax.swing.JLabel();

        jLabel4.setText("jLabel4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1256, 850));

        jPanel1.setBackground(new java.awt.Color(23, 23, 23));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/register2.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 590, 850));

        jLabel2.setFont(new java.awt.Font("Signatra DEMO", 1, 72)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Registra tus datos");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 90, 420, 110));

        jLabel3.setFont(new java.awt.Font("Bludhaven", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nombres");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 340, -1, -1));

        jLabel5.setFont(new java.awt.Font("Bludhaven", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Apellidos");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 380, -1, -1));

        jLabel6.setFont(new java.awt.Font("Bludhaven", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Género");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 540, -1, -1));

        jLabel7.setFont(new java.awt.Font("Bludhaven", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("DNI");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 420, -1, -1));

        txtnombre.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        jPanel1.add(txtnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 340, 240, -1));

        txtapellido.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        jPanel1.add(txtapellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 380, 240, -1));

        txtdni.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        jPanel1.add(txtdni, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 420, 240, -1));

        jLabel9.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(153, 153, 153));
        jLabel9.setText("Rellene sus datos correctamente.");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 260, 290, -1));

        btnenviar.setFont(new java.awt.Font("Open Sans", 1, 14)); // NOI18N
        btnenviar.setText("ENVIAR");
        btnenviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnenviarActionPerformed(evt);
            }
        });
        jPanel1.add(btnenviar, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 730, 140, 50));

        jLabel8.setFont(new java.awt.Font("Bludhaven", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Dirección");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 460, -1, -1));

        rbtnmasculino.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        rbtnmasculino.setForeground(new java.awt.Color(255, 255, 255));
        rbtnmasculino.setText("Masculino");
        rbtnmasculino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnmasculinoActionPerformed(evt);
            }
        });
        jPanel1.add(rbtnmasculino, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 540, -1, -1));

        rbtnfemenino.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        rbtnfemenino.setForeground(new java.awt.Color(255, 255, 255));
        rbtnfemenino.setText("Femenino");
        rbtnfemenino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnfemeninoActionPerformed(evt);
            }
        });
        jPanel1.add(rbtnfemenino, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 540, -1, -1));

        txtelefono.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        jPanel1.add(txtelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 500, 240, -1));

        btnVolver.setFont(new java.awt.Font("Open Sans", 1, 14)); // NOI18N
        btnVolver.setText("VOLVER");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        jPanel1.add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 730, 140, 50));

        txtDireccion.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        jPanel1.add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 460, 240, -1));

        jLabel11.setFont(new java.awt.Font("Bludhaven", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Teléfono");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 500, -1, -1));
        jPanel1.add(lblusuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 30, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1285, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 850, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rbtnmasculinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnmasculinoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtnmasculinoActionPerformed

    private void rbtnfemeninoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnfemeninoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtnfemeninoActionPerformed

    private void btnenviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnenviarActionPerformed
        String nombres = txtnombre.getText();
        String apellidos = txtapellido.getText();
        String dni = txtdni.getText();
        String direccion = txtDireccion.getText();
        String telefono = txtelefono.getText();
        usuario = rc.usuarioDE;
        int tipoUsuario = 0;
        int idPersona = 0;
        

        
        DBPersona rp = new DBPersona();
        
        DBUsuario u = new DBUsuario();
      
        

        rp.AgregarPersona(pc.connection2(), nombres, apellidos, rc.correo, direccion, dni, telefono, determinarGenero());
        if (rp.bandAgregarPersona == true) {
            tipoUsuario = np.Validar(pc.connection2(), "Empleado");
            idPersona = rp.AsignarIDPersona(pc.connection2(), dni);
            
            u.AgregarUsuarioA(pc.connection2(), usuario, idPersona, tipoUsuario);
            if(u.bandAgregarUsuario == true){
            FormEmpleado fe = new FormEmpleado();
            fe.setVisible(true);
            this.dispose();
            }else{
                JOptionPane.showMessageDialog(null, "Error no se pudo crear el Usuario!");
            }
        }
    }//GEN-LAST:event_btnenviarActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        Login l = new Login();
        l.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

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
            java.util.logging.Logger.getLogger(RegistroDatosEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistroDatosEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistroDatosEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroDatosEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistroDatosEmpleado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVolver;
    private javax.swing.JButton btnenviar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblusuario;
    private javax.swing.JRadioButton rbtnfemenino;
    private javax.swing.JRadioButton rbtnmasculino;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtapellido;
    private javax.swing.JTextField txtdni;
    private javax.swing.JTextField txtelefono;
    private javax.swing.JTextField txtnombre;
    // End of variables declaration//GEN-END:variables
}
