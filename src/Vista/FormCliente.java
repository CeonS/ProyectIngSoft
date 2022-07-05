package Vista;

import Controlador.DBProyecto;
import Controlador.DBReunion;
import Modelo.probarConexionDB;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public final class FormCliente extends javax.swing.JFrame {

    public FormCliente() {
        initComponents();
        this.setLocationRelativeTo(null);
        panelReunionesTabla.setVisible(false);
        jlblNohayReu.setVisible(false);
        jlblNohayProy.setVisible(false);
        panelReunionesTabla1.setVisible(false);
        if (FormEmpleado.control != 23) {
            AceptarReunion();
            AceptarPresupuesto();
        }

    }

    DefaultTableModel modelo = new DefaultTableModel();
    probarConexionDB pcDB = new probarConexionDB();
    Login l = new Login();
    public static int idReunion, idProyecto;
    DBReunion r = new DBReunion();
    DBProyecto p = new DBProyecto();

    public void AceptarReunion() {
        r.ValidarAceptacionReunion(pcDB.connection2(), Login.idCliente);
        if (DBReunion.aceptarReunion == true) {
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
                    + "inner join persona p on c.id_PersonaC = p.idPersona where c.idCliente = " + Login.idCliente + " and r.estado_reunion = 'Pendiente'";

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

    public void AceptarPresupuesto() {
        p.ValidarPresupuesto(pcDB.connection2(), Login.idCliente);
        if (DBProyecto.Presupuesto == true) {
            JOptionPane.showMessageDialog(null, "Tiene un presupuesto por confirmar! Dirijase al apartado de proyectos!");
            jlblPresupuesto.setVisible(true);
            panelReunionesTabla1.setVisible(true);
            jlblNohayProy.setVisible(false);

            String sql = "select s.monto, p.idProyecto from proyecto p inner join reunion r on p.id_Reunion_Proy = r.idReunion \n"
                    + "                    inner join servicio s on r.IdServicioReunion = s.IdServicio\n"
                    + "                    inner join detallecolaborador dc on p.idProyecto = dc.id_Proyecto_Detallecolaboradores where dc.estadoDetalleColaborador = 'Aceptado' \n"
                    + "                    and r.idClienteReu = " + Login.idCliente;

            String dato = "";
            Statement st;
            try {
                st = pcDB.connection2().createStatement();
                ResultSet rs = st.executeQuery(sql);
                if (rs.next()) {
                    dato = rs.getString(1);
                    idProyecto = rs.getInt(2);
                }

                jlblPresupuesto.setText("Presupuesto: " + dato);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "error listar: " + e);
            }
        } else {
            jlblNohayProy.setVisible(true);
        }

    }

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
        jLabel20 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        txtNombres = new javax.swing.JTextField();
        txtApellidos = new javax.swing.JTextField();
        txtDNI = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        txtGenero = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        btnCerrarSesion = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        panelReuniones = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        panelReunionesTabla = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaReuniones = new javax.swing.JTable();
        btnRechazar = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();
        jlblNohayReu = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        panelReunionesTabla1 = new javax.swing.JPanel();
        btnRechazar1 = new javax.swing.JButton();
        btnAceptar1 = new javax.swing.JButton();
        jlblPresupuesto = new javax.swing.JLabel();
        jlblNohayProy = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        txttecnico = new javax.swing.JTextField();
        txtfecha = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtpago = new javax.swing.JTextField();
        txtsector = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();

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

        panelInicio.setBackground(new java.awt.Color(23, 23, 23));
        panelInicio.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                panelInicioFocusGained(evt);
            }
        });
        panelInicio.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/NY2.png"))); // NOI18N
        panelInicio.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 0, 490, 690));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Texto3.png"))); // NOI18N
        panelInicio.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 220, 470, 430));

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/G2R.png"))); // NOI18N
        panelInicio.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, 380, -1));

        jLabel2.setFont(new java.awt.Font("Runalto", 0, 72)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("BIENVENIDO");
        panelInicio.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, -1, -1));

        jTabbedPane1.addTab("Inicio", panelInicio);

        jPanel4.setBackground(new java.awt.Color(23, 23, 23));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtNombres.setEnabled(false);
        txtNombres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombresActionPerformed(evt);
            }
        });
        jPanel4.add(txtNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 240, 180, -1));

        txtApellidos.setEnabled(false);
        txtApellidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidosActionPerformed(evt);
            }
        });
        jPanel4.add(txtApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 280, 180, -1));

        txtDNI.setEnabled(false);
        jPanel4.add(txtDNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 320, 180, -1));

        txtCorreo.setEnabled(false);
        jPanel4.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 360, 180, -1));

        txtGenero.setEnabled(false);
        jPanel4.add(txtGenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 400, 180, -1));

        txtTelefono.setEnabled(false);
        jPanel4.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 480, 180, -1));

        txtDireccion.setEnabled(false);
        jPanel4.add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 440, 180, -1));

        btnCerrarSesion.setFont(new java.awt.Font("Open Sans", 1, 14)); // NOI18N
        btnCerrarSesion.setText("CERRAR SESIÓN");
        btnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesionActionPerformed(evt);
            }
        });
        jPanel4.add(btnCerrarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 560, 140, 50));

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Cliente.png"))); // NOI18N
        jPanel4.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 560, 690));

        jLabel6.setFont(new java.awt.Font("Bludhaven", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Nombres");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 240, -1, -1));

        jLabel7.setFont(new java.awt.Font("Bludhaven", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Apellidos");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 280, -1, -1));

        jLabel8.setFont(new java.awt.Font("Bludhaven", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("DNI");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 320, -1, -1));

        jLabel9.setFont(new java.awt.Font("Bludhaven", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Correo");
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 360, -1, -1));

        jLabel10.setFont(new java.awt.Font("Bludhaven", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Género");
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 400, -1, -1));

        jLabel13.setFont(new java.awt.Font("Bludhaven", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Dirección");
        jPanel4.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 440, -1, -1));

        jLabel12.setFont(new java.awt.Font("Bludhaven", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Teléfono");
        jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 480, -1, -1));

        jLabel5.setFont(new java.awt.Font("Signatra DEMO", 0, 56)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Cliente");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 40, -1, -1));

        jLabel11.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(204, 204, 204));
        jLabel11.setText("Desde enero del 2022");
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 110, 130, -1));

        jLabel24.setFont(new java.awt.Font("Open Sans", 1, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Datos generales del cliente");
        jPanel4.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 170, -1, -1));

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
        panelReuniones.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(23, 23, 23));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        tablaReuniones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaReunionesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaReuniones);

        btnRechazar.setText("CANCELAR");
        btnRechazar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRechazarActionPerformed(evt);
            }
        });

        btnAceptar.setText("ACEPTAR");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelReunionesTablaLayout = new javax.swing.GroupLayout(panelReunionesTabla);
        panelReunionesTabla.setLayout(panelReunionesTablaLayout);
        panelReunionesTablaLayout.setHorizontalGroup(
            panelReunionesTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelReunionesTablaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 359, Short.MAX_VALUE)
                .addComponent(btnRechazar, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jScrollPane1)
        );
        panelReunionesTablaLayout.setVerticalGroup(
            panelReunionesTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelReunionesTablaLayout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelReunionesTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRechazar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        jPanel5.add(panelReunionesTabla, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, -1, -1));

        jlblNohayReu.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jlblNohayReu.setForeground(new java.awt.Color(255, 255, 255));
        jlblNohayReu.setText("NO SE ENCUENTRAN REUNIONES A TU NOMBRE, VUELVE LUEGO!");
        jPanel5.add(jlblNohayReu, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 30, 550, 43));

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Tabla.png"))); // NOI18N
        jPanel5.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 1110, 540));

        panelReuniones.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, 1110, 710));

        jTabbedPane1.addTab("Reunion", panelReuniones);

        jPanel6.setBackground(new java.awt.Color(23, 23, 23));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnRechazar1.setFont(new java.awt.Font("Open Sans", 1, 18)); // NOI18N
        btnRechazar1.setText("CANCELAR");
        btnRechazar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRechazar1ActionPerformed(evt);
            }
        });

        btnAceptar1.setFont(new java.awt.Font("Open Sans", 1, 18)); // NOI18N
        btnAceptar1.setText("ACEPTAR");
        btnAceptar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptar1ActionPerformed(evt);
            }
        });

        jlblPresupuesto.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N

        javax.swing.GroupLayout panelReunionesTabla1Layout = new javax.swing.GroupLayout(panelReunionesTabla1);
        panelReunionesTabla1.setLayout(panelReunionesTabla1Layout);
        panelReunionesTabla1Layout.setHorizontalGroup(
            panelReunionesTabla1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelReunionesTabla1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelReunionesTabla1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelReunionesTabla1Layout.createSequentialGroup()
                        .addComponent(btnAceptar1, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68)
                        .addComponent(btnRechazar1, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelReunionesTabla1Layout.createSequentialGroup()
                        .addComponent(jlblPresupuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(147, 147, 147))))
        );
        panelReunionesTabla1Layout.setVerticalGroup(
            panelReunionesTabla1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelReunionesTabla1Layout.createSequentialGroup()
                .addContainerGap(96, Short.MAX_VALUE)
                .addComponent(jlblPresupuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addGroup(panelReunionesTabla1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRechazar1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAceptar1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        jPanel6.add(panelReunionesTabla1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 170, -1, -1));

        jlblNohayProy.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jlblNohayProy.setForeground(new java.awt.Color(255, 255, 255));
        jlblNohayProy.setText("NO SE ENCUENTRAN PRESUPUESTOS POR ACEPTAR A TU NOMBRE, VUELVE LUEGO!");
        jPanel6.add(jlblNohayProy, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, 716, 43));

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Tabla.png"))); // NOI18N
        jPanel6.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 1100, 540));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Proyecto", jPanel2);

        jPanel7.setBackground(new java.awt.Color(23, 23, 23));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txttecnico.setEnabled(false);
        txttecnico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttecnicoActionPerformed(evt);
            }
        });
        jPanel7.add(txttecnico, new org.netbeans.lib.awtextra.AbsoluteConstraints(833, 240, 210, -1));

        txtfecha.setEnabled(false);
        txtfecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfechaActionPerformed(evt);
            }
        });
        jPanel7.add(txtfecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(833, 320, 210, -1));

        jLabel18.setBackground(new java.awt.Color(23, 23, 23));
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Financing Strategy.png"))); // NOI18N
        jPanel7.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 430, -1, -1));

        txtpago.setEnabled(false);
        txtpago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpagoActionPerformed(evt);
            }
        });
        jPanel7.add(txtpago, new org.netbeans.lib.awtextra.AbsoluteConstraints(833, 360, 210, -1));

        txtsector.setEnabled(false);
        jPanel7.add(txtsector, new org.netbeans.lib.awtextra.AbsoluteConstraints(833, 280, 210, -1));

        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Meet.png"))); // NOI18N
        jPanel7.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 690));

        jLabel14.setFont(new java.awt.Font("Runalto", 0, 36)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Estado de visita técnica");
        jPanel7.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 110, -1, -1));

        jLabel15.setFont(new java.awt.Font("Bludhaven", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Técnico asignado");
        jPanel7.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 240, -1, -1));

        jLabel19.setFont(new java.awt.Font("Bludhaven", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Sector");
        jPanel7.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 280, -1, -1));

        jLabel16.setFont(new java.awt.Font("Bludhaven", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Fecha de visita");
        jPanel7.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 320, -1, -1));

        jLabel17.setFont(new java.awt.Font("Bludhaven", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Monto a pagar");
        jPanel7.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 360, -1, -1));

        jTabbedPane1.addTab("Visita Técnica", jPanel7);

        jPanel1.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1110, 720));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1107, Short.MAX_VALUE)
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

    private void txtpagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpagoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpagoActionPerformed

    private void txtfechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfechaActionPerformed

    private void txttecnicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttecnicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttecnicoActionPerformed

    private void jTabbedPane1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTabbedPane1FocusGained

    }//GEN-LAST:event_jTabbedPane1FocusGained

    private void panelReunionesFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_panelReunionesFocusGained

    }//GEN-LAST:event_panelReunionesFocusGained

    private void panelReunionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelReunionesMouseClicked

    }//GEN-LAST:event_panelReunionesMouseClicked

    private void panelInicioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_panelInicioFocusGained

    }//GEN-LAST:event_panelInicioFocusGained

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        DBReunion r = new DBReunion();
        int opcion = JOptionPane.showConfirmDialog(null, "¿Desea confirmar la reunión?", "Confirmar", JOptionPane.YES_NO_CANCEL_OPTION);
        if (opcion == 0) {

            if (idReunion == 0) {
                JOptionPane.showMessageDialog(null, "Seleccione una fila primero");
            } else {
                String estado = "Aceptada";
                r.ActualizarEstadoReunion(pcDB.connection2(), estado, idReunion);
                panelReunionesTabla.setVisible(false);
                jlblNohayReu.setVisible(true);
            }

        }

    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnRechazarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRechazarActionPerformed
        DBReunion r = new DBReunion();
        int opcion = JOptionPane.showConfirmDialog(null, "¿Desea rechazar la reunión?", "Confirmar", JOptionPane.YES_NO_CANCEL_OPTION);
        if (opcion == 0) {

            if (idReunion == 0) {
                JOptionPane.showMessageDialog(null, "Seleccione una fila primero");
            } else {
                String estado = "Inactiva";
                r.ActualizarEstadoReunion(pcDB.connection2(), estado, idReunion);
                panelReunionesTabla.setVisible(false);
                jlblNohayReu.setVisible(true);
            }

        }
    }//GEN-LAST:event_btnRechazarActionPerformed

    private void tablaReunionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaReunionesMouseClicked
        int filaSeleccionada = tablaReuniones.rowAtPoint(evt.getPoint());
        idReunion = Integer.parseInt(tablaReuniones.getValueAt(filaSeleccionada, 0).toString());
    }//GEN-LAST:event_tablaReunionesMouseClicked

    private void btnRechazar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRechazar1ActionPerformed
        DBProyecto p = new DBProyecto();
        int opcion = JOptionPane.showConfirmDialog(null, "¿Desea rechazar el presupuesto?", "Confirmar", JOptionPane.YES_NO_CANCEL_OPTION);
        if (opcion == 0) {

            String estado = "Inactivo";
            p.ActualizarEstadoProyecto(pcDB.connection2(), estado, idProyecto);
            panelReunionesTabla1.setVisible(false);
            jlblNohayReu.setVisible(true);

        }
    }//GEN-LAST:event_btnRechazar1ActionPerformed

    private void btnAceptar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptar1ActionPerformed

        DBProyecto p = new DBProyecto();
        int opcion = JOptionPane.showConfirmDialog(null, "¿Desea aceptar el presupuesto?", "Confirmar", JOptionPane.YES_NO_CANCEL_OPTION);
        if (opcion == 0) {

            String estado = "Activo";
            p.ActualizarEstadoProyecto(pcDB.connection2(), estado, idProyecto);
            panelReunionesTabla1.setVisible(false);
            jlblNohayReu.setVisible(true);

        }

    }//GEN-LAST:event_btnAceptar1ActionPerformed

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
    private javax.swing.JButton btnAceptar1;
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnRechazar;
    private javax.swing.JButton btnRechazar1;
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
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel jlblNohayProy;
    private javax.swing.JLabel jlblNohayReu;
    private javax.swing.JLabel jlblPresupuesto;
    private javax.swing.JPanel panelInicio;
    private javax.swing.JPanel panelReuniones;
    private javax.swing.JPanel panelReunionesTabla;
    private javax.swing.JPanel panelReunionesTabla1;
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
