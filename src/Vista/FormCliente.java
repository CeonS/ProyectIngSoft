package Vista;

import Controlador.DBReunion;
import Modelo.probarConexionDB;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FormCliente extends javax.swing.JFrame {

    public FormCliente() {
        initComponents();
        this.setLocationRelativeTo(null);
        panelReunionesTabla.setVisible(false);
        jlblNohayReu.setVisible(false);
        AceptarReunion();

    }

    DefaultTableModel modelo = new DefaultTableModel();
    probarConexionDB pcDB = new probarConexionDB();
    Login l = new Login();

    public void AceptarReunion() {
        r.ValidarAceptacionReunion(pcDB.connection2());
        if (r.aceptarReunion == true) {
            JOptionPane.showMessageDialog(null, "Tiene una reunión por confirmar! Dirijase al apartado de reuniones!");
            panelReunionesTabla.setVisible(true);
            jlblNohayReu.setVisible(false);

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

            tablaReuniones.setModel(modelo);

            String sql = "select r.idReunion,np.descripcionParametro, pe.nombres as 'nombre empleado', pe.dni,\n"
                    + "p.nombres as 'nombre cliente',p.dni, r.fechaReunion, r.ubicacion, r.numeroContacto, r.estado_reunion from reunion r\n"
                    + "inner join servicio s on r.IdServicioReunion = s.IdServicio\n"
                    + "inner join nivelparametro np on s.idParametroTipoServicio = np.idParametro\n"
                    + "inner join usuario u on r.id_Usuario_Reu = u.idUsuario\n"
                    + "inner join persona pe on u.idPersonaUsuario = pe.idPersona\n"
                    + "inner join cliente c on r.idClienteReu = c.idCliente\n"
                    + "inner join persona p on c.id_PersonaC = p.idPersona where c.idCliente = " + l.idCliente;

            String datos[] = new String[10];
            Statement st;
            try {
                st = pcDB.connection2().createStatement();
                ResultSet rs = st.executeQuery(sql);
                if (rs.next()) {
                    datos[0] = rs.getString(1);
                    datos[1] = rs.getString(3);
                    datos[2] = rs.getString(4);
                    datos[3] = rs.getString(5);
                    datos[4] = rs.getString(6);
                    datos[5] = rs.getString(7);
                    datos[6] = rs.getString(8);
                    datos[7] = rs.getString(2);
                    datos[8] = rs.getString(9);
                    datos[9] = rs.getString(10);
                    modelo.addRow(datos);
                }
                tablaReuniones.setModel(modelo);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "error listar: " + e);
            }
        } else {
            jlblNohayReu.setVisible(true);
        }

    }
    DBReunion r = new DBReunion();
    String datos[] = new String[7];

    public void RellenarPerfil() {

        probarConexionDB pcDB = new probarConexionDB();
        int id = 0;
        int resultado = 0;
        String SQL = "select * from persona p where idPersona = " + l.personaPerfil;
        try {
            Statement st = pcDB.connection2().createStatement();
            ResultSet rs = st.executeQuery(SQL);

            if (rs.next()) {
                resultado = 1;

                if (resultado == 1) {

                    datos[0] = rs.getString("nombres");
                    datos[1] = rs.getString("apellidos");
                    datos[2] = rs.getString("direccion");
                    datos[3] = rs.getString("telefono");
                    datos[4] = rs.getString("dni");
                    datos[5] = rs.getString("correo");
                    datos[6] = rs.getString("id_ParametroGenero");
                    if (datos[6].equalsIgnoreCase("6")) {
                        txtGenero.setText("Femenino");
                    } else {
                        txtGenero.setText("Masculino");
                    }
                    txtNombres.setText(datos[0]);
                    txtApellidos.setText(datos[1]);
                    txtDireccion.setText(datos[2]);
                    txtTelefono.setText(datos[3]);
                    txtDNI.setText(datos[4]);
                    txtCorreo.setText(datos[5]);

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
        panelInicio = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
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
        txtCorreo = new javax.swing.JTextField();
        txtGenero = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        btnCerrarSesion = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        panelReuniones = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        panelReunionesTabla = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaReuniones = new javax.swing.JTable();
        btnRechazar = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        jlblNohayReu = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txttecnico = new javax.swing.JTextField();
        txtfecha = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtpago = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtsector = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTabbedPane1FocusGained(evt);
            }
        });
        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        panelInicio.setBackground(new java.awt.Color(18, 17, 17));
        panelInicio.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                panelInicioFocusGained(evt);
            }
        });
        panelInicio.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/NY2.png"))); // NOI18N
        panelInicio.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 0, 490, 690));

        jLabel2.setFont(new java.awt.Font("Runalto", 0, 72)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("BIENVENIDO");
        panelInicio.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, -1, -1));

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/G2R.png"))); // NOI18N
        panelInicio.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, 380, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Texto3.png"))); // NOI18N
        panelInicio.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 220, 470, 430));

        jTabbedPane1.addTab("Inicio", panelInicio);

        jPanel4.setBackground(new java.awt.Color(18, 17, 17));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Background.png"))); // NOI18N
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 30, -1, -1));

        jLabel5.setFont(new java.awt.Font("Signatra DEMO", 0, 56)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Cliente");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 130, -1, -1));

        jLabel6.setFont(new java.awt.Font("Bludhaven", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Nombres");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 250, -1, -1));

        jLabel7.setFont(new java.awt.Font("Bludhaven", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Apellidos");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 290, -1, -1));

        jLabel8.setFont(new java.awt.Font("Bludhaven", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("DNI");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 330, -1, -1));

        jLabel9.setFont(new java.awt.Font("Bludhaven", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Correo");
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 370, -1, -1));

        jLabel10.setFont(new java.awt.Font("Bludhaven", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Género");
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 410, -1, -1));

        txtNombres.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        txtNombres.setEnabled(false);
        txtNombres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombresActionPerformed(evt);
            }
        });
        jPanel4.add(txtNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 250, 180, -1));

        txtApellidos.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        txtApellidos.setEnabled(false);
        txtApellidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidosActionPerformed(evt);
            }
        });
        jPanel4.add(txtApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 290, 180, -1));

        txtDNI.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        txtDNI.setEnabled(false);
        jPanel4.add(txtDNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 330, 180, -1));

        txtCorreo.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        txtCorreo.setEnabled(false);
        jPanel4.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 370, 180, -1));

        txtGenero.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        txtGenero.setEnabled(false);
        jPanel4.add(txtGenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 410, 180, -1));

        jLabel11.setForeground(new java.awt.Color(204, 204, 204));
        jLabel11.setText("Desde enero del 2022");
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 190, 120, -1));

        jLabel12.setFont(new java.awt.Font("Bludhaven", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Teléfono");
        jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 490, -1, -1));

        txtTelefono.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        txtTelefono.setEnabled(false);
        jPanel4.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 490, 180, -1));

        jLabel13.setFont(new java.awt.Font("Bludhaven", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Dirección");
        jPanel4.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 450, -1, -1));

        txtDireccion.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        txtDireccion.setEnabled(false);
        jPanel4.add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 450, 180, -1));

        btnCerrarSesion.setFont(new java.awt.Font("Open Sans", 1, 14)); // NOI18N
        btnCerrarSesion.setText("CERRAR SESIÓN");
        btnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesionActionPerformed(evt);
            }
        });
        jPanel4.add(btnCerrarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 570, 140, 50));

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Cliente.png"))); // NOI18N
        jPanel4.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 560, 690));

        jTabbedPane1.addTab("Perfil", jPanel4);

        panelReuniones.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                panelReunionesFocusGained(evt);
            }
        });
        panelReuniones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelReunionesMouseClicked(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(18, 17, 17));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelReunionesTabla.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaReuniones.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablaReuniones);

        panelReunionesTabla.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 17, 1086, 240));

        btnRechazar.setFont(new java.awt.Font("Open Sans", 1, 14)); // NOI18N
        btnRechazar.setText("CANCELAR");
        btnRechazar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRechazarActionPerformed(evt);
            }
        });
        panelReunionesTabla.add(btnRechazar, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 340, 150, 30));

        btnAceptar.setFont(new java.awt.Font("Open Sans", 1, 14)); // NOI18N
        btnAceptar.setText("ACEPTAR");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        panelReunionesTabla.add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 340, 150, 30));

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Tabla.png"))); // NOI18N
        panelReunionesTabla.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -90, 1100, 680));

        jPanel5.add(panelReunionesTabla, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 93, 1098, 570));

        jlblNohayReu.setFont(new java.awt.Font("Runalto", 0, 24)); // NOI18N
        jlblNohayReu.setForeground(new java.awt.Color(255, 255, 255));
        jlblNohayReu.setText("No se encuentran reuniones a su nombre, vuelva luego. ");
        jPanel5.add(jlblNohayReu, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 40, 716, 43));

        javax.swing.GroupLayout panelReunionesLayout = new javax.swing.GroupLayout(panelReuniones);
        panelReuniones.setLayout(panelReunionesLayout);
        panelReunionesLayout.setHorizontalGroup(
            panelReunionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelReunionesLayout.setVerticalGroup(
            panelReunionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Reunion", panelReuniones);

        jPanel7.setBackground(new java.awt.Color(18, 17, 17));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Runalto", 0, 36)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Estado de visita técnica");
        jPanel7.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 110, -1, -1));

        jLabel15.setFont(new java.awt.Font("Bludhaven", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Técnico asignado");
        jPanel7.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 210, -1, -1));

        jLabel16.setFont(new java.awt.Font("Bludhaven", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Fecha de visita");
        jPanel7.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 290, -1, -1));

        txttecnico.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        txttecnico.setEnabled(false);
        txttecnico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttecnicoActionPerformed(evt);
            }
        });
        jPanel7.add(txttecnico, new org.netbeans.lib.awtextra.AbsoluteConstraints(886, 208, 163, -1));

        txtfecha.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        txtfecha.setEnabled(false);
        txtfecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfechaActionPerformed(evt);
            }
        });
        jPanel7.add(txtfecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(886, 291, 163, -1));

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Financing Strategy.png"))); // NOI18N
        jPanel7.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 390, -1, -1));

        jLabel17.setFont(new java.awt.Font("Bludhaven", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Monto a pagar");
        jPanel7.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 330, -1, -1));

        txtpago.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        txtpago.setEnabled(false);
        txtpago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpagoActionPerformed(evt);
            }
        });
        jPanel7.add(txtpago, new org.netbeans.lib.awtextra.AbsoluteConstraints(886, 331, 163, -1));

        jLabel19.setFont(new java.awt.Font("Bludhaven", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Sector");
        jPanel7.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 250, -1, -1));

        txtsector.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        txtsector.setEnabled(false);
        jPanel7.add(txtsector, new org.netbeans.lib.awtextra.AbsoluteConstraints(886, 251, 163, -1));

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Meet.png"))); // NOI18N
        jPanel7.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 690));

        jTabbedPane1.addTab("Visita Técnica", jPanel7);

        jPanel1.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1110, 720));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 722, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
        RellenarPerfil();
    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void jTabbedPane1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTabbedPane1FocusGained

    }//GEN-LAST:event_jTabbedPane1FocusGained

    private void txtpagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpagoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpagoActionPerformed

    private void txtfechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfechaActionPerformed

    private void txttecnicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttecnicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttecnicoActionPerformed

    private void panelReunionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelReunionesMouseClicked

    }//GEN-LAST:event_panelReunionesMouseClicked

    private void panelReunionesFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_panelReunionesFocusGained

    }//GEN-LAST:event_panelReunionesFocusGained

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        DBReunion r = new DBReunion();
        int opcion = JOptionPane.showConfirmDialog(null, "¿Desea confirmar la reunión?", "Confirmar", JOptionPane.YES_NO_CANCEL_OPTION);
        if (opcion == 0) {

            String estado = "Aceptada";
            r.ActualizarEstadoReunion(pcDB.connection2(), estado);
            panelReunionesTabla.setVisible(false);
            jlblNohayReu.setVisible(true);

        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnRechazarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRechazarActionPerformed
        DBReunion r = new DBReunion();
        int opcion = JOptionPane.showConfirmDialog(null, "¿Desea rechazar la reunión?", "Confirmar", JOptionPane.YES_NO_CANCEL_OPTION);
        if (opcion == 0) {

            String estado = "Inactiva";
            r.ActualizarEstadoReunion(pcDB.connection2(), estado);
            panelReunionesTabla.setVisible(false);
            jlblNohayReu.setVisible(true);

        }
    }//GEN-LAST:event_btnRechazarActionPerformed

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
        Login l = new Login();
        l.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCerrarSesionActionPerformed

    private void txtApellidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidosActionPerformed

    private void txtNombresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombresActionPerformed

    private void panelInicioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_panelInicioFocusGained

    }//GEN-LAST:event_panelInicioFocusGained

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
            java.util.logging.Logger.getLogger(FormCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
                new FormCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnRechazar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel jlblNohayReu;
    private javax.swing.JPanel panelInicio;
    private javax.swing.JPanel panelReuniones;
    private javax.swing.JPanel panelReunionesTabla;
    private javax.swing.JTable tablaReuniones;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDNI;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtGenero;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtfecha;
    private javax.swing.JTextField txtpago;
    private javax.swing.JTextField txtsector;
    private javax.swing.JTextField txttecnico;
    // End of variables declaration//GEN-END:variables
}
