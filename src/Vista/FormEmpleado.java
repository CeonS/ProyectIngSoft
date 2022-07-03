package Vista;

import Modelo.probarConexionDB;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class FormEmpleado extends javax.swing.JFrame {

    public FormEmpleado() {
        initComponents();
        this.setLocationRelativeTo(null);
        
    }

        
     
     String datos [] = new String[9];

    public void RellenarPerfil() {
        Login l = new Login();
        probarConexionDB pcDB = new probarConexionDB();
        int resultado = 0;
        String SQL = "select * from persona p"
                + " where p.idPersona = " + l.personaPerfil;
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
                    if(datos[6].equalsIgnoreCase("6")){
                        txtGenero.setText("Femenino");
                    }else{
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

        jLabel29 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtNombres = new javax.swing.JTextField();
        txtApellidos = new javax.swing.JTextField();
        txtDNI = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        txtGenero = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        btnCerrarSesion = new javax.swing.JButton();
        jLabel39 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        btnagregarreunion = new javax.swing.JButton();
        btnvisualizarreunion = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        panelServicio = new javax.swing.JPanel();
        btnagregarservicio = new javax.swing.JButton();
        btnvisualizarservicio = new javax.swing.JButton();
        jLabel30 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        btnagregarproyecto = new javax.swing.JButton();
        btnvisualizarproyecto = new javax.swing.JButton();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        btnagregarvisitatecnica = new javax.swing.JButton();
        btnvisualizarvisitatecnica = new javax.swing.JButton();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        btnAsignarColaboradores1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnagregarclientes = new javax.swing.JButton();
        btnvisualizarclientes = new javax.swing.JButton();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        btnrealizarpago = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();

        jLabel29.setText("jLabel29");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(23, 23, 23));
        jPanel3.setPreferredSize(new java.awt.Dimension(1110, 690));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Runalto", 0, 72)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("BIENVENIDO");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/NY2.png"))); // NOI18N
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 0, 490, -1));

        jLabel38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/G2R.png"))); // NOI18N
        jPanel3.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, 380, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Texto3.png"))); // NOI18N
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 220, 470, 430));

        jTabbedPane1.addTab("Inicio", jPanel3);

        jPanel4.setBackground(new java.awt.Color(23, 23, 23));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Signatra DEMO", 0, 56)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Empleado");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 70, -1, -1));

        jLabel6.setFont(new java.awt.Font("Bludhaven", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Nombres");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 240, -1, -1));

        jLabel7.setFont(new java.awt.Font("Bludhaven", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Apellidos");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 280, -1, -1));

        jLabel8.setFont(new java.awt.Font("Bludhaven", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("DNI");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 320, -1, -1));

        txtNombres.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        txtNombres.setEnabled(false);
        jPanel4.add(txtNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 240, 180, -1));

        txtApellidos.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        txtApellidos.setEnabled(false);
        txtApellidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidosActionPerformed(evt);
            }
        });
        jPanel4.add(txtApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 280, 180, -1));

        txtDNI.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        txtDNI.setEnabled(false);
        jPanel4.add(txtDNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 320, 180, -1));

        jLabel11.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Desde enero del 2022");
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 140, 130, -1));

        jLabel12.setFont(new java.awt.Font("Bludhaven", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Teléfono");
        jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 480, -1, -1));

        txtTelefono.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        txtTelefono.setEnabled(false);
        jPanel4.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 480, 180, -1));

        jLabel26.setFont(new java.awt.Font("Open Sans", 1, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Datos generales del usuario");
        jPanel4.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 190, -1, -1));

        jLabel21.setFont(new java.awt.Font("Bludhaven", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Género");
        jPanel4.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 400, -1, -1));

        jLabel36.setFont(new java.awt.Font("Bludhaven", 1, 18)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("Correo");
        jPanel4.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 360, -1, -1));

        txtGenero.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        txtGenero.setEnabled(false);
        jPanel4.add(txtGenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 400, 180, -1));

        txtCorreo.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        txtCorreo.setEnabled(false);
        jPanel4.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 360, 180, -1));

        jLabel37.setFont(new java.awt.Font("Bludhaven", 1, 18)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText("Dirección");
        jPanel4.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 440, -1, -1));

        txtDireccion.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        txtDireccion.setEnabled(false);
        jPanel4.add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 440, 180, -1));

        btnCerrarSesion.setFont(new java.awt.Font("Open Sans", 1, 14)); // NOI18N
        btnCerrarSesion.setText("CERRAR SESIÓN");
        btnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesionActionPerformed(evt);
            }
        });
        jPanel4.add(btnCerrarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 560, 140, 50));

        jLabel39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Cliente.png"))); // NOI18N
        jPanel4.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 560, 690));

        jTabbedPane1.addTab("Perfil", jPanel4);

        jPanel8.setBackground(new java.awt.Color(23, 23, 23));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnagregarreunion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/gestionreunion.png"))); // NOI18N
        btnagregarreunion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnagregarreunionActionPerformed(evt);
            }
        });
        jPanel8.add(btnagregarreunion, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 440, -1, -1));

        btnvisualizarreunion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/reunionproyecto2.png"))); // NOI18N
        btnvisualizarreunion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnvisualizarreunionActionPerformed(evt);
            }
        });
        jPanel8.add(btnvisualizarreunion, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 150, -1, -1));

        jLabel17.setFont(new java.awt.Font("Signatra DEMO", 1, 60)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("AGREGAR");
        jPanel8.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 360, -1, -1));

        jLabel18.setFont(new java.awt.Font("Signatra DEMO", 1, 60)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("VISUALIZAR");
        jPanel8.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 70, -1, -1));

        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/reufondo.png"))); // NOI18N
        jPanel8.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 560, 690));

        jTabbedPane1.addTab("Reunión", jPanel8);

        panelServicio.setBackground(new java.awt.Color(23, 23, 23));
        panelServicio.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnagregarservicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/servicios2.png"))); // NOI18N
        btnagregarservicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnagregarservicioActionPerformed(evt);
            }
        });
        panelServicio.add(btnagregarservicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 440, -1, -1));

        btnvisualizarservicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/servicios1.png"))); // NOI18N
        btnvisualizarservicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnvisualizarservicioActionPerformed(evt);
            }
        });
        panelServicio.add(btnvisualizarservicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 150, -1, -1));

        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/servicio.png"))); // NOI18N
        panelServicio.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 2, 560, 690));

        jLabel32.setFont(new java.awt.Font("Signatra DEMO", 1, 60)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("VISUALIZAR");
        panelServicio.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 70, -1, -1));

        jLabel34.setFont(new java.awt.Font("Signatra DEMO", 1, 60)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("AGREGAR");
        panelServicio.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 360, -1, -1));

        jTabbedPane1.addTab("Servicio", panelServicio);

        jPanel6.setBackground(new java.awt.Color(23, 23, 23));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnagregarproyecto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/gestionproyecto.png"))); // NOI18N
        btnagregarproyecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnagregarproyectoActionPerformed(evt);
            }
        });
        jPanel6.add(btnagregarproyecto, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 150, -1, -1));

        btnvisualizarproyecto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/gestionproyecto2.png"))); // NOI18N
        btnvisualizarproyecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnvisualizarproyectoActionPerformed(evt);
            }
        });
        jPanel6.add(btnvisualizarproyecto, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 440, -1, -1));

        jLabel41.setFont(new java.awt.Font("Signatra DEMO", 1, 60)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setText("VISUALIZAR");
        jPanel6.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 70, -1, -1));

        jLabel42.setFont(new java.awt.Font("Signatra DEMO", 1, 60)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setText("AGREGAR");
        jPanel6.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 360, -1, -1));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Proyecto.png"))); // NOI18N
        jPanel6.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 560, 690));

        jTabbedPane1.addTab("Proyecto", jPanel6);

        jPanel7.setBackground(new java.awt.Color(23, 23, 23));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnagregarvisitatecnica.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/visitatecnica2.png"))); // NOI18N
        btnagregarvisitatecnica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnagregarvisitatecnicaActionPerformed(evt);
            }
        });
        jPanel7.add(btnagregarvisitatecnica, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 150, -1, -1));

        btnvisualizarvisitatecnica.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/visitatecnica.png"))); // NOI18N
        btnvisualizarvisitatecnica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnvisualizarvisitatecnicaActionPerformed(evt);
            }
        });
        jPanel7.add(btnvisualizarvisitatecnica, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 440, -1, -1));

        jLabel43.setFont(new java.awt.Font("Signatra DEMO", 1, 60)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setText("VISUALIZAR");
        jPanel7.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 70, -1, -1));

        jLabel44.setFont(new java.awt.Font("Signatra DEMO", 1, 60)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 255, 255));
        jLabel44.setText("AGREGAR");
        jPanel7.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 360, -1, -1));

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/mantenimiento.png"))); // NOI18N
        jPanel7.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 560, 690));

        jTabbedPane1.addTab("Visita Técnica", jPanel7);

        jPanel5.setBackground(new java.awt.Color(23, 23, 23));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/colaboradoresfondo.png"))); // NOI18N
        jPanel5.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 2, 560, 690));

        btnAsignarColaboradores1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/colaboradores.png"))); // NOI18N
        btnAsignarColaboradores1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsignarColaboradores1ActionPerformed(evt);
            }
        });
        jPanel5.add(btnAsignarColaboradores1, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 150, 160, 130));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/colaboradores2.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 440, 160, 130));

        jLabel45.setFont(new java.awt.Font("Signatra DEMO", 1, 60)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setText("VISUALIZAR");
        jPanel5.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 70, -1, -1));

        jLabel46.setFont(new java.awt.Font("Signatra DEMO", 1, 60)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(255, 255, 255));
        jLabel46.setText("AGREGAR");
        jPanel5.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 360, -1, -1));

        jTabbedPane1.addTab("Colaborador", jPanel5);

        jPanel2.setBackground(new java.awt.Color(23, 23, 23));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnagregarclientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/clientes2.png"))); // NOI18N
        btnagregarclientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnagregarclientesActionPerformed(evt);
            }
        });
        jPanel2.add(btnagregarclientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 440, 161, -1));

        btnvisualizarclientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/clientes.png"))); // NOI18N
        btnvisualizarclientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnvisualizarclientesActionPerformed(evt);
            }
        });
        jPanel2.add(btnvisualizarclientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 150, 161, 130));

        jLabel47.setFont(new java.awt.Font("Signatra DEMO", 1, 60)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jLabel47.setText("VISUALIZAR");
        jPanel2.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 70, -1, -1));

        jLabel48.setFont(new java.awt.Font("Signatra DEMO", 1, 60)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(255, 255, 255));
        jLabel48.setText("AGREGAR");
        jPanel2.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 360, -1, -1));

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ClienteA.png"))); // NOI18N
        jPanel2.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 560, 690));

        jTabbedPane1.addTab("Clientes", jPanel2);

        jPanel9.setBackground(new java.awt.Color(23, 23, 23));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnrealizarpago.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pagar.png"))); // NOI18N
        btnrealizarpago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnrealizarpagoActionPerformed(evt);
            }
        });
        jPanel9.add(btnrealizarpago, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 150, -1, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pagar2.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel9.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 440, -1, -1));

        jLabel24.setFont(new java.awt.Font("Signatra DEMO", 1, 60)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("PAGAR");
        jPanel9.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 70, -1, -1));

        jLabel25.setFont(new java.awt.Font("Signatra DEMO", 1, 60)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("PAGOS PENDIENTES");
        jPanel9.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 360, -1, -1));

        jLabel35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pagodeb.png"))); // NOI18N
        jPanel9.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 560, 690));

        jTabbedPane1.addTab("Pago", jPanel9);

        jPanel1.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1110, 720));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtApellidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidosActionPerformed

    private void btnagregarservicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnagregarservicioActionPerformed

        RegistrarServicio rs = new RegistrarServicio();
        rs.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_btnagregarservicioActionPerformed

    private void btnvisualizarreunionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnvisualizarreunionActionPerformed
       ListadoReuniones lr = new ListadoReuniones();
       lr.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_btnvisualizarreunionActionPerformed

    private void btnvisualizarclientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnvisualizarclientesActionPerformed
       ListadoClientes lc = new ListadoClientes();
       lc.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_btnvisualizarclientesActionPerformed

    private void btnrealizarpagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnrealizarpagoActionPerformed
        Pago pago = new Pago();
        pago.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnrealizarpagoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        PagosPendientes pp = new PagosPendientes();
        pp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnvisualizarvisitatecnicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnvisualizarvisitatecnicaActionPerformed
        ListadoVisitasTecnicas lvt = new ListadoVisitasTecnicas();
        lvt.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnvisualizarvisitatecnicaActionPerformed

    private void btnagregarclientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnagregarclientesActionPerformed
        RegistrarClientes rc = new RegistrarClientes();
        rc.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnagregarclientesActionPerformed

    private void btnagregarreunionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnagregarreunionActionPerformed
       RegistrarReuniones rr = new RegistrarReuniones();
       rr.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_btnagregarreunionActionPerformed

    private void btnvisualizarservicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnvisualizarservicioActionPerformed
       ListadoServicios ls = new ListadoServicios();
       ls.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_btnvisualizarservicioActionPerformed

    private void btnagregarproyectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnagregarproyectoActionPerformed
       RegistrarProyectos rp = new RegistrarProyectos();
       rp.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_btnagregarproyectoActionPerformed

    private void btnvisualizarproyectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnvisualizarproyectoActionPerformed
      ListadoProyectos lp = new ListadoProyectos();
      lp.setVisible(true);
      this.dispose();
    }//GEN-LAST:event_btnvisualizarproyectoActionPerformed

    private void btnagregarvisitatecnicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnagregarvisitatecnicaActionPerformed
      RegistrarVisitaTecnica rvt = new RegistrarVisitaTecnica();
      rvt.setVisible(true);
      this.dispose();
    }//GEN-LAST:event_btnagregarvisitatecnicaActionPerformed

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
       RellenarPerfil();
    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
       Login l = new Login();
       l.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_btnCerrarSesionActionPerformed

    private void btnAsignarColaboradores1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsignarColaboradores1ActionPerformed
        AsignarColaborador ac = new AsignarColaborador();
        ac.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAsignarColaboradores1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        ListadoColaboradores lc = new ListadoColaboradores();
        lc.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(FormEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormEmpleado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAsignarColaboradores1;
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnagregarclientes;
    private javax.swing.JButton btnagregarproyecto;
    private javax.swing.JButton btnagregarreunion;
    private javax.swing.JButton btnagregarservicio;
    private javax.swing.JButton btnagregarvisitatecnica;
    private javax.swing.JButton btnrealizarpago;
    private javax.swing.JButton btnvisualizarclientes;
    private javax.swing.JButton btnvisualizarproyecto;
    private javax.swing.JButton btnvisualizarreunion;
    private javax.swing.JButton btnvisualizarservicio;
    private javax.swing.JButton btnvisualizarvisitatecnica;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel panelServicio;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDNI;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtGenero;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
