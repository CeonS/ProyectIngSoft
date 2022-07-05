package Vista;

import Controlador.DBNivelParametros;
import Controlador.DBPersona;
import Controlador.DBProyecto;
import Controlador.DBReunion;
import Controlador.DBSector;
import Controlador.DBServicio;
import Controlador.Parametros;
import Modelo.probarConexionDB;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class RegistrarProyectos extends javax.swing.JFrame {

    public RegistrarProyectos() {
        initComponents();
        this.setLocationRelativeTo(null);
        panelTabla.setVisible(false);
        llenarSectores();
    }

    probarConexionDB pcDB = new probarConexionDB();
    DefaultTableModel modelo = new DefaultTableModel();
    public String reunion;

    void crearTabla() {
        modelo.addColumn("ID");
        modelo.addColumn("Cliente");
        modelo.addColumn("DNI Cliente");
        modelo.addColumn("Empleado");
        modelo.addColumn("DNI Empleado");
        modelo.addColumn("Fecha");
        modelo.addColumn("Ubicación");
        modelo.addColumn("Servicio");
        modelo.addColumn("Número Contacto");
        modelo.addColumn("Estado");

        tablaReunion.setModel(modelo);
    }

    void mostrarTabla() {
        reunion = txtReunion.getText();
        String sql = "select np.descripcionParametro, pe.nombres as 'nombre empleado', pe.dni,\n"
                + "p.nombres as 'nombre cliente',p.dni, r.fechaReunion, r.ubicacion, r.numeroContacto, r.estado_reunion, r.idReunion from reunion r\n"
                + "inner join servicio s on r.IdServicioReunion = s.IdServicio\n"
                + "inner join nivelparametro np on s.idParametroTipoServicio = np.idParametro\n"
                + "inner join usuario u on r.id_Usuario_Reu = u.idUsuario\n"
                + "inner join persona pe on u.idPersonaUsuario = pe.idPersona\n"
                + "inner join cliente c on r.idClienteReu = c.idCliente\n"
                + "inner join persona p on c.id_PersonaC = p.idPersona"
                + " where r.idReunion = " + reunion + " and r.estado_reunion = 'Aceptada'";

        String datos[] = new String[10];
        Statement st;
        try {
            st = pcDB.connection2().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = rs.getString(10);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                datos[5] = rs.getString(6);
                datos[6] = rs.getString(7);
                datos[7] = rs.getString(1);
                datos[8] = rs.getString(8);
                datos[9] = rs.getString(9);
                modelo.addRow(datos);
            }
            tablaReunion.setModel(modelo);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error listar: " + e);
        }
    }

    private void llenarSectores() {

        DBSector s = new DBSector();
        ArrayList<Parametros> listaServicios = s.getSectores(pcDB.connection2());

        cbxSector.removeAllItems();

        for (int i = 0; i < listaServicios.size(); i++) {
            cbxSector.addItem(listaServicios.get(i).getDescripcionParametro());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtZonaEjecucion = new javax.swing.JTextField();
        cbxSector = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAObservaciones = new javax.swing.JTextArea();
        panelTabla = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaReunion = new javax.swing.JTable();
        btnRegistrar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtReunion = new javax.swing.JTextField();
        DateCFinal = new com.toedter.calendar.JDateChooser();
        DateCInicial = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(23, 23, 23));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtZonaEjecucion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtZonaEjecucionActionPerformed(evt);
            }
        });
        jPanel1.add(txtZonaEjecucion, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 410, 160, 30));

        cbxSector.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(cbxSector, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 270, 160, 30));

        txtAObservaciones.setColumns(20);
        txtAObservaciones.setRows(5);
        jScrollPane1.setViewportView(txtAObservaciones);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 460, 540, -1));

        jScrollPane2.setPreferredSize(new java.awt.Dimension(1000, 100));

        tablaReunion.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tablaReunion);

        panelTabla.add(jScrollPane2);

        jPanel1.add(panelTabla, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 230, 1010, 120));

        btnRegistrar.setFont(new java.awt.Font("Open Sans", 1, 14)); // NOI18N
        btnRegistrar.setText("REGISTRAR");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 600, 140, 50));

        btnSalir.setFont(new java.awt.Font("Open Sans", 1, 14)); // NOI18N
        btnSalir.setText("SALIR");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 600, 140, 50));

        jLabel4.setFont(new java.awt.Font("Bludhaven", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Observaciones");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 460, -1, -1));

        jLabel3.setFont(new java.awt.Font("Bludhaven", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Zona Ejecución");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 420, -1, -1));

        jLabel9.setFont(new java.awt.Font("Bludhaven", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Fecha Final");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 370, -1, -1));

        jLabel6.setFont(new java.awt.Font("Signatra DEMO", 1, 72)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Registro de proyectos");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 70, 490, 70));

        jLabel7.setFont(new java.awt.Font("Bludhaven", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Fecha Inicial");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 320, -1, -1));

        jLabel1.setFont(new java.awt.Font("Bludhaven", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Sector");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 280, -1, -1));

        jLabel2.setFont(new java.awt.Font("Bludhaven", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Reunion");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, -1, -1));

        txtReunion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtReunionFocusGained(evt);
            }
        });
        txtReunion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtReunionActionPerformed(evt);
            }
        });
        txtReunion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtReunionKeyReleased(evt);
            }
        });
        jPanel1.add(txtReunion, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 230, 160, 30));

        DateCFinal.setDateFormatString("yyyy-MM-dd");
        jPanel1.add(DateCFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 360, 160, 30));

        DateCInicial.setDateFormatString("yyyy-MM-dd");
        jPanel1.add(DateCInicial, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 310, 160, 30));

        jLabel8.setBackground(new java.awt.Color(23, 23, 23));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/registros.png"))); // NOI18N
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1460, 740));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 740));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtReunionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtReunionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtReunionActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        FormEmpleado fe = new FormEmpleado();
        fe.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void txtZonaEjecucionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtZonaEjecucionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtZonaEjecucionActionPerformed

    private void txtReunionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtReunionKeyReleased
        reunion = txtReunion.getText();
        crearTabla();
        int columna = tablaReunion.getColumnCount();
        int fila = tablaReunion.getRowCount();
        if (reunion.equals("")) {
            panelTabla.setVisible(false);

            if (fila > 0) {
                modelo.removeRow(0);

            }
            if (columna > 9) {
                modelo.setColumnCount(0);
            }
        } else {
            if (columna > 9) {
                modelo.setColumnCount(0);

                if (fila > 0) {
                    modelo.removeRow(0);
                }
                crearTabla();
                mostrarTabla();
                panelTabla.setVisible(true);
            } else {
                mostrarTabla();
                panelTabla.setVisible(true);
            }

        }

    }//GEN-LAST:event_txtReunionKeyReleased

    private void txtReunionFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtReunionFocusGained
        String reunion = txtReunion.getText();
        if (reunion.equals("")) {

        } else {
            int columna = tablaReunion.getColumnCount();
            int fila = tablaReunion.getRowCount();
            if (columna > 9) {
                modelo.setColumnCount(0);

                if (fila > 0) {
                    modelo.removeRow(0);
                    crearTabla();
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
    }//GEN-LAST:event_txtReunionFocusGained

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        DBNivelParametros np = new DBNivelParametros();
        int reunion = Integer.parseInt(txtReunion.getText());
        String sector = cbxSector.getSelectedItem().toString();
        int idParametro = np.Validar(pcDB.connection2(), sector);
        String fechaInicial = ((JTextField) DateCInicial.getDateEditor().getUiComponent()).getText();
        String fechaFinal = ((JTextField) DateCFinal.getDateEditor().getUiComponent()).getText();
        String zonaEjecucion = txtZonaEjecucion.getText();
        String observaciones = txtAObservaciones.getText();
        String cliente = "";
        DBProyecto pro = new DBProyecto();
        DBPersona p = new DBPersona();
        DBReunion r = new DBReunion();

        pro.AgregarProyecto(pcDB.connection2(), reunion, idParametro, Date.valueOf(fechaInicial), Date.valueOf(fechaFinal), zonaEjecucion, observaciones);
        r.ActualizarEstadoReunion(pcDB.connection2(), "Realizada", reunion);
        int opcion = JOptionPane.showConfirmDialog(null, "¿Desea registrar los datos del proyecto?", "Confirmar", JOptionPane.YES_NO_CANCEL_OPTION);
        if (opcion == 0) {

            try {
                Properties props = new Properties();
                props.setProperty("mail.smtp.host", "smtp.gmail.com");
                props.setProperty("mail.smtp.starttls.enable", "true");
                props.setProperty("mail.smtp.port", "587");
                props.setProperty("mail.smtp.auth", "true");

                Session session = Session.getDefaultInstance(props);

                try {

                    String sql = "select * from reunion where idReunion =" + reunion;
                    Statement st;
                    st = pcDB.connection2().createStatement();
                    ResultSet rs = st.executeQuery(sql);
                    if (rs.next()) {

                        cliente = rs.getString(8);
                    }

                } catch (Exception e) {
                }

                String correoRemitente = "ceon0508@gmail.com";
                String passwordRemitente = "oynzouhkkijdjfho";
                String correoReceptor = p.AsignarPersonaIdCliente(pcDB.connection2(), Integer.parseInt(cliente));
                String asunto = "Datos Generales - Confirmación de reunión";

                String sqlQuery = "select ls.Usuario, ls.contraseña from login_usuario ls inner join Usuario u on ls.Usuario = u.Usuario\n"
                        + "inner join persona p on u.idPersonaUsuario = p.idPersona\n"
                        + "inner join cliente c on p.idPersona = c.id_PersonaC\n"
                        + "where c.idCliente = " + cliente;
                int resultado = 0;
                String[] datos = new String[2];

                try {
                    Statement st = pcDB.connection2().createStatement();
                    ResultSet rs = st.executeQuery(sqlQuery);

                    if (rs.next()) {
                        resultado = 1;

                        if (resultado == 1) {

                            datos[0] = rs.getString("ls.Usuario");
                            datos[1] = rs.getString("ls.Contraseña");

                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Error de Acceso, Usuario No Registrado");
                    }
                    pcDB.connection2().close();
                    st.close();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error de Registro " + e.getMessage());
                }

              String mensaje = "Se ha registrado un proyecto a su nombre, ingrese a su cuenta brindada en el presente correo \n"
                        + "para poder visualizar el presupuesto estimado para el proyecto, si está conforme acepte,\n"
                        + "en caso contrario, no acepte y nos comunicaremos con usted.\n\n\n\n"
                        + " Usuario: " + datos[0] + "\n"
                        + " Contraseña:" + datos[1] + "";
                MimeMessage message = new MimeMessage(session);
                message.setFrom(new InternetAddress(correoRemitente));
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(correoReceptor));
                message.setSubject(asunto);
                message.setText(mensaje);
                JOptionPane.showMessageDialog(null, "Espere... Se realizará el envío del correo al cliente asociado");
                Transport t = session.getTransport("smtp");
                t.connect(correoRemitente, passwordRemitente);
                t.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
                t.close();
                JOptionPane.showMessageDialog(null, "Se le envío un correo al Cliente asociado al proyecto!");

            } catch (AddressException ex) {
                java.util.logging.Logger.getLogger(RegistrarReuniones.class.getName()).log(Level.SEVERE, null, ex);
            } catch (MessagingException ex) {
                java.util.logging.Logger.getLogger(RegistrarReuniones.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {

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
            java.util.logging.Logger.getLogger(RegistrarProyectos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrarProyectos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrarProyectos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrarProyectos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistrarProyectos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser DateCFinal;
    private com.toedter.calendar.JDateChooser DateCInicial;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cbxSector;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel panelTabla;
    private javax.swing.JTable tablaReunion;
    private javax.swing.JTextArea txtAObservaciones;
    private javax.swing.JTextField txtReunion;
    private javax.swing.JTextField txtZonaEjecucion;
    // End of variables declaration//GEN-END:variables
}
