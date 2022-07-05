package Vista;

import Controlador.DBColaborador;
import Controlador.DBDetalleColaborador;
import Controlador.DBPersona;
import Modelo.probarConexionDB;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public final class FormColaborador extends javax.swing.JFrame {

    public FormColaborador() {
        initComponents();
        this.setLocationRelativeTo(null);
        panelProyectosTabla.setVisible(false);
        if (FormEmpleado.control != 1) {
            aceptarDetalle();
            RellenarPerfil();
        }

    }
    DBDetalleColaborador dc = new DBDetalleColaborador();
    DBPersona p = new DBPersona();
    DefaultTableModel modelo = new DefaultTableModel();
    Login l = new Login();
    DBColaborador c = new DBColaborador();
    public static int idColaborador;

    public void aceptarDetalle() {

        idColaborador = c.hallarIDColaboradorIdPersona(pcDB.connection2(), Login.personaPerfil);
        dc.ValidarAceptacionDetalleColaborador(pcDB.connection2(), idColaborador);
        if (DBDetalleColaborador.aceptarDetalle == true) {

            JOptionPane.showMessageDialog(null, "Tiene un proyecto por confirmar! Dirijase al apartado de proyectos!");

            modelo.addColumn("ID");
            modelo.addColumn("ID Reunión");
            modelo.addColumn("Fecha Inicial");
            modelo.addColumn("Fecha Final");
            modelo.addColumn("Zona Ejecución");
            modelo.addColumn("Sector");
            modelo.addColumn("Observaciones");
            modelo.addColumn("Estado");

            tablaProyecto.setModel(modelo);

            String sql = "select p.idProyecto, p.id_Reunion_Proy ,p.fecha_Inicial_Proyecto, p.fecha_Final_Proyecto, p.zonaEjecucionProy, np.descripcionParametro,"
                    + " p.observacionesProy, p.estado_proyecto from proyecto p \n"
                    + "inner join nivelparametro np on p.id_Parametro_Sector_Proy = np.idParametro "
                    + "inner join detallecolaborador dc on p.idProyecto = dc.id_Proyecto_DetalleColaboradores where dc.estadoDetalleColaborador = 'Pendiente'"
                    + " and dc.id_ColaboradorDetalle = " + idColaborador;

            String datos[] = new String[8];
            Statement st;
            try {
                st = pcDB.connection2().createStatement();
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    datos[0] = rs.getString(1);
                    datos[1] = rs.getString(2);
                    datos[2] = rs.getString(3);
                    datos[3] = rs.getString(4);
                    datos[4] = rs.getString(5);
                    datos[5] = rs.getString(6);
                    datos[6] = rs.getString(7);
                    datos[7] = rs.getString(8);
                    modelo.addRow(datos);
                }
                tablaProyecto.setModel(modelo);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "error listar: " + e);
            }
            btnvisualizarproyecto.setVisible(false);
            panelProyectosTabla.setVisible(true);
        }
    }

    String datos[] = new String[9];
    probarConexionDB pcDB = new probarConexionDB();

    public void RellenarPerfil() {
        Login l = new Login();

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
                    if (datos[6].equalsIgnoreCase("6")) {
                        txtGenero.setText("Femenino");
                    } else {
                        txtGenero.setText("Masculino");
                    }
                    if (datos[8].equalsIgnoreCase("7")) {
                        txtTipoColaborador.setText("Técnico");
                    } else if (datos[8].equalsIgnoreCase("8")) {
                        txtTipoColaborador.setText("Ingeniero");
                    } else {
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
        jLabel15 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        txtNombres = new javax.swing.JTextField();
        txtApellidos = new javax.swing.JTextField();
        txtDNI = new javax.swing.JTextField();
        txtZonaLaboral = new javax.swing.JTextField();
        txtTipoColaborador = new javax.swing.JTextField();
        txtGenero = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        btnCerrarSesion = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        panelProyectosTabla = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProyecto = new javax.swing.JTable();
        btnRechazar = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();
        btnvisualizarproyecto = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        btnvisualizarvisitatecnica = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnvisualizarclientes = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(23, 23, 23));
        jPanel3.setMinimumSize(new java.awt.Dimension(790, 420));
        jPanel3.setPreferredSize(new java.awt.Dimension(790, 420));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/NY2.png"))); // NOI18N
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 0, 490, 690));

        jLabel15.setFont(new java.awt.Font("Runalto", 0, 72)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("BIENVENIDO");
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, -1, -1));

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/G2R.png"))); // NOI18N
        jPanel3.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, 380, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Texto3.png"))); // NOI18N
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 220, 470, 430));

        jTabbedPane1.addTab("Inicio", jPanel3);

        jPanel4.setBackground(new java.awt.Color(23, 23, 23));
        jPanel4.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanel4MouseMoved(evt);
            }
        });
        jPanel4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPanel4FocusGained(evt);
            }
        });
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel4MouseClicked(evt);
            }
        });
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtNombres.setEnabled(false);
        jPanel4.add(txtNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 210, 180, -1));

        txtApellidos.setEnabled(false);
        txtApellidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidosActionPerformed(evt);
            }
        });
        jPanel4.add(txtApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 250, 180, -1));

        txtDNI.setEnabled(false);
        jPanel4.add(txtDNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 290, 180, -1));

        txtZonaLaboral.setEnabled(false);
        jPanel4.add(txtZonaLaboral, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 490, 180, -1));

        txtTipoColaborador.setEnabled(false);
        jPanel4.add(txtTipoColaborador, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 530, 180, -1));

        txtGenero.setEnabled(false);
        jPanel4.add(txtGenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 370, 180, -1));

        txtDireccion.setEnabled(false);
        jPanel4.add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 410, 180, -1));

        txtTelefono.setEnabled(false);
        jPanel4.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 450, 180, -1));

        txtCorreo.setEnabled(false);
        jPanel4.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 330, 180, -1));

        btnCerrarSesion.setFont(new java.awt.Font("Open Sans", 1, 14)); // NOI18N
        btnCerrarSesion.setText("CERRAR SESIÓN");
        btnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesionActionPerformed(evt);
            }
        });
        jPanel4.add(btnCerrarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 580, 140, 50));

        jLabel6.setFont(new java.awt.Font("Bludhaven", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Nombres");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 210, -1, -1));

        jLabel7.setFont(new java.awt.Font("Bludhaven", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Apellidos");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 250, -1, -1));

        jLabel8.setFont(new java.awt.Font("Bludhaven", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("DNI");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 290, -1, -1));

        jLabel24.setFont(new java.awt.Font("Bludhaven", 1, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Correo");
        jPanel4.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 330, -1, -1));

        jLabel12.setFont(new java.awt.Font("Bludhaven", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Género");
        jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 370, -1, -1));

        jLabel21.setFont(new java.awt.Font("Bludhaven", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Dirección");
        jPanel4.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 410, -1, -1));

        jLabel23.setFont(new java.awt.Font("Bludhaven", 1, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Teléfono");
        jPanel4.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 450, -1, -1));

        jLabel9.setFont(new java.awt.Font("Bludhaven", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Zona Laboral");
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 490, -1, -1));

        jLabel10.setFont(new java.awt.Font("Bludhaven", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Tipo Colaborador");
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 530, -1, -1));

        jLabel13.setFont(new java.awt.Font("Open Sans", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Datos generales del colaborador");
        jPanel4.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 150, -1, -1));

        jLabel11.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Desde enero del 2022");
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 100, 150, -1));

        jLabel5.setFont(new java.awt.Font("Signatra DEMO", 0, 56)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Colaborador");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 40, -1, -1));

        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Cliente.png"))); // NOI18N
        jPanel4.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 560, 690));

        jTabbedPane1.addTab("Perfil", jPanel4);

        jPanel6.setBackground(new java.awt.Color(23, 23, 23));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jScrollPane1.setViewportView(tablaProyecto);

        btnRechazar.setFont(new java.awt.Font("Open Sans", 1, 18)); // NOI18N
        btnRechazar.setText("CANCELAR");
        btnRechazar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRechazarActionPerformed(evt);
            }
        });

        btnAceptar.setFont(new java.awt.Font("Open Sans", 1, 18)); // NOI18N
        btnAceptar.setText("ACEPTAR");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelProyectosTablaLayout = new javax.swing.GroupLayout(panelProyectosTabla);
        panelProyectosTabla.setLayout(panelProyectosTablaLayout);
        panelProyectosTablaLayout.setHorizontalGroup(
            panelProyectosTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelProyectosTablaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelProyectosTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(panelProyectosTablaLayout.createSequentialGroup()
                        .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRechazar, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panelProyectosTablaLayout.setVerticalGroup(
            panelProyectosTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelProyectosTablaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelProyectosTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRechazar, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        jPanel6.add(panelProyectosTabla, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, 990, 330));

        btnvisualizarproyecto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/gestionproyecto.png"))); // NOI18N
        jPanel6.add(btnvisualizarproyecto, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 70, 140, -1));

        jLabel29.setFont(new java.awt.Font("Signatra DEMO", 1, 60)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("VISUALIZAR");
        jPanel6.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 110, -1, -1));

        jTabbedPane1.addTab("Proyecto", jPanel6);

        jPanel7.setBackground(new java.awt.Color(23, 23, 23));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnvisualizarvisitatecnica.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/visitatecnica.png"))); // NOI18N
        btnvisualizarvisitatecnica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnvisualizarvisitatecnicaActionPerformed(evt);
            }
        });
        jPanel7.add(btnvisualizarvisitatecnica, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 350, 140, -1));

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/mantenimiento.png"))); // NOI18N
        jPanel7.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 560, 690));

        jLabel28.setFont(new java.awt.Font("Signatra DEMO", 1, 60)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("VISUALIZAR");
        jPanel7.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 180, -1, -1));

        jTabbedPane1.addTab("Visita Técnica", jPanel7);

        jPanel2.setBackground(new java.awt.Color(23, 23, 23));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnvisualizarclientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/clientes.png"))); // NOI18N
        btnvisualizarclientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnvisualizarclientesActionPerformed(evt);
            }
        });
        jPanel2.add(btnvisualizarclientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 340, 143, -1));

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ClienteA.png"))); // NOI18N
        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 560, 690));

        jLabel27.setFont(new java.awt.Font("Signatra DEMO", 1, 60)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("VISUALIZAR");
        jPanel2.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 180, -1, -1));

        jTabbedPane1.addTab("Clientes", jPanel2);

        jPanel1.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1110, 720));

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

    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void btnvisualizarclientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnvisualizarclientesActionPerformed
        Login.colaboradorForm = true;
        ListadoClientes lc = new ListadoClientes();
        lc.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnvisualizarclientesActionPerformed

    private void btnvisualizarvisitatecnicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnvisualizarvisitatecnicaActionPerformed
        Login.colaboradorForm = true;
        ListadoVisitasTecnicas lvt = new ListadoVisitasTecnicas();
        lvt.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnvisualizarvisitatecnicaActionPerformed

    private void btnRechazarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRechazarActionPerformed

        int opcion = JOptionPane.showConfirmDialog(null, "¿Desea rechazar la participación en el proyecto?", "Confirmar", JOptionPane.YES_NO_CANCEL_OPTION);
        if (opcion == 0) {

            String estado = "Inactivo";
            idColaborador = c.hallarIDColaboradorIdPersona(pcDB.connection2(), Login.personaPerfil);
            dc.ActualizarEstadoDetalleColaborador(pcDB.connection2(), estado, idColaborador);
            panelProyectosTabla.setVisible(false);
            btnvisualizarproyecto.setVisible(true);

        }
    }//GEN-LAST:event_btnRechazarActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed

        int opcion = JOptionPane.showConfirmDialog(null, "¿Desea confirmar la participación en el proyecto?", "Confirmar", JOptionPane.YES_NO_CANCEL_OPTION);
        if (opcion == 0) {

            String estado = "Aceptado";
            idColaborador = c.hallarIDColaboradorIdPersona(pcDB.connection2(), Login.personaPerfil);
            dc.ActualizarEstadoDetalleColaborador(pcDB.connection2(), estado, idColaborador);
            panelProyectosTabla.setVisible(false);
            btnvisualizarproyecto.setVisible(true);

        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void jPanel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseClicked

    }//GEN-LAST:event_jPanel4MouseClicked

    private void jPanel4FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPanel4FocusGained

    }//GEN-LAST:event_jPanel4FocusGained

    private void jPanel4MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseMoved

    }//GEN-LAST:event_jPanel4MouseMoved

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
        Login.colaboradorForm = true;
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
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnRechazar;
    private javax.swing.JButton btnvisualizarclientes;
    private javax.swing.JButton btnvisualizarproyecto;
    private javax.swing.JButton btnvisualizarvisitatecnica;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel panelProyectosTabla;
    private javax.swing.JTable tablaProyecto;
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
