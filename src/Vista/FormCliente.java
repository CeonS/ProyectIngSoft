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
        jLabel3 = new javax.swing.JLabel();
        panelReuniones = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        panelReunionesTabla = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaReuniones = new javax.swing.JTable();
        btnRechazar = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setForeground(new java.awt.Color(255, 255, 255));
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

        panelInicio.setBackground(new java.awt.Color(0, 120, 158));
        panelInicio.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                panelInicioFocusGained(evt);
            }
        });
        panelInicio.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Poe.png"))); // NOI18N
        panelInicio.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 70, 340, 350));

        jLabel2.setFont(new java.awt.Font("Hack Nerd Font", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("BIENVENIDO A G2R SOLUTIONS");
        panelInicio.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        jLabel3.setFont(new java.awt.Font("Hack Nerd Font", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("<html><h2>Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Etiam viverra arcu dui, ut eleifend eros eleifend et. Ut commodo congue augue, vitae scelerisque augue congue sit amet. </h2> ");
        panelInicio.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 390, 290));

        jTabbedPane1.addTab("Inicio", panelInicio);

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

        jPanel5.setBackground(new java.awt.Color(102, 102, 255));

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
                .addGroup(panelReunionesTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(panelReunionesTablaLayout.createSequentialGroup()
                        .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRechazar, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panelReunionesTablaLayout.setVerticalGroup(
            panelReunionesTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelReunionesTablaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelReunionesTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRechazar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        jlblNohayReu.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jlblNohayReu.setForeground(new java.awt.Color(255, 255, 255));
        jlblNohayReu.setText("NO SE ENCUENTRAN REUNIONES A TU NOMBRE, VUELVE LUEGO!");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jlblNohayReu, javax.swing.GroupLayout.PREFERRED_SIZE, 716, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(553, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelReunionesTabla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jlblNohayReu, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelReunionesTabla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(160, Short.MAX_VALUE))
        );

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

        jPanel7.setBackground(new java.awt.Color(0, 120, 158));

        jLabel14.setFont(new java.awt.Font("Hack Nerd Font", 1, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("ESTADO DE LA VISITA TÉCNICA");

        jLabel15.setFont(new java.awt.Font("Hack Nerd Font", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Técnico asignado");

        jLabel16.setFont(new java.awt.Font("Hack Nerd Font", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Fecha de visita");

        txttecnico.setEnabled(false);
        txttecnico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttecnicoActionPerformed(evt);
            }
        });

        txtfecha.setEnabled(false);
        txtfecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfechaActionPerformed(evt);
            }
        });

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Financing Strategy.png"))); // NOI18N

        jLabel17.setFont(new java.awt.Font("Hack Nerd Font", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Monto a pagar");

        txtpago.setEnabled(false);
        txtpago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpagoActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Hack Nerd Font", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Sector");

        txtsector.setEnabled(false);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel7Layout.createSequentialGroup()
                                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel15)
                                        .addComponent(jLabel16))
                                    .addGap(104, 104, 104)
                                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtfecha, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                                        .addComponent(txttecnico, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                                        .addComponent(txtsector)))
                                .addGroup(jPanel7Layout.createSequentialGroup()
                                    .addComponent(jLabel17)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 134, Short.MAX_VALUE)
                                    .addComponent(txtpago, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel19)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addComponent(jLabel14)))
                .addGap(0, 771, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel18))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txttecnico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addGap(21, 21, 21)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(txtsector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtfecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txtpago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(77, 77, 77)
                .addComponent(jLabel18))
        );

        jTabbedPane1.addTab("Visita Técnica", jPanel7);

        jPanel4.setBackground(new java.awt.Color(0, 120, 158));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Background.png"))); // NOI18N
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        jLabel5.setFont(new java.awt.Font("Hack Nerd Font", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Cliente");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, -1, -1));

        jLabel6.setFont(new java.awt.Font("Hack Nerd Font", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Nombres");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 120, -1, -1));

        jLabel7.setFont(new java.awt.Font("Hack Nerd Font", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Apellidos");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 160, -1, -1));

        jLabel8.setFont(new java.awt.Font("Hack Nerd Font", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("DNI");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 200, -1, -1));

        jLabel9.setFont(new java.awt.Font("Hack Nerd Font", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Correo");
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 240, -1, -1));

        jLabel10.setFont(new java.awt.Font("Hack Nerd Font", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Género");
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 280, -1, -1));

        txtNombres.setEnabled(false);
        txtNombres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombresActionPerformed(evt);
            }
        });
        jPanel4.add(txtNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 120, 180, -1));

        txtApellidos.setEnabled(false);
        txtApellidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidosActionPerformed(evt);
            }
        });
        jPanel4.add(txtApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 160, 180, -1));

        txtDNI.setEnabled(false);
        jPanel4.add(txtDNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 200, 180, -1));

        txtCorreo.setEnabled(false);
        jPanel4.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 240, 180, -1));

        txtGenero.setEnabled(false);
        jPanel4.add(txtGenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 280, 180, -1));

        jLabel11.setForeground(new java.awt.Color(204, 204, 204));
        jLabel11.setText("Desde enero del 2022");
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 120, -1));

        jLabel12.setFont(new java.awt.Font("Hack Nerd Font", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Teléfono");
        jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 360, -1, -1));

        txtTelefono.setEnabled(false);
        jPanel4.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 360, 180, -1));

        jLabel13.setFont(new java.awt.Font("Hack Nerd Font", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Dirección");
        jPanel4.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 320, -1, -1));

        txtDireccion.setEnabled(false);
        jPanel4.add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 320, 180, -1));

        btnCerrarSesion.setText("Cerrar Sesión");
        btnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesionActionPerformed(evt);
            }
        });
        jPanel4.add(btnCerrarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 30, 140, 50));

        jTabbedPane1.addTab("Perfil", jPanel4);

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
