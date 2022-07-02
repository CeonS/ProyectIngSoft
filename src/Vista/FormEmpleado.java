package Vista;

import Modelo.probarConexionDB;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class FormEmpleado extends javax.swing.JFrame {

    public FormEmpleado() {
        initComponents();
        this.setLocationRelativeTo(null);
        control = 1;
    }

        
     public static int control;
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
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
        jPanel8 = new javax.swing.JPanel();
        btnagregarreunion = new javax.swing.JButton();
        btnvisualizarreunion = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        panelServicio = new javax.swing.JPanel();
        btnagregarservicio = new javax.swing.JButton();
        btnvisualizarservicio = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        btnAsignarColaboradores = new javax.swing.JButton();
        btnagregarproyecto = new javax.swing.JButton();
        btnvisualizarproyecto = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        btnagregarvisitatecnica = new javax.swing.JButton();
        btnvisualizarvisitatecnica = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        btnagregarclientes = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        btnvisualizarclientes = new javax.swing.JButton();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        btnrealizarpago = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();

        jLabel29.setText("jLabel29");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setForeground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(153, 204, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Poe.png"))); // NOI18N
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 100, 300, 350));

        jLabel2.setFont(new java.awt.Font("Hack Nerd Font", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 153));
        jLabel2.setText("BIENVENIDO A G2R SOLUTIONS");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        jLabel3.setFont(new java.awt.Font("Hack Nerd Font", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("<html><h2>Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Etiam viverra arcu dui, ut eleifend eros eleifend et. Ut commodo congue augue, vitae scelerisque augue congue sit amet. </h2> ");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 390, 290));

        jTabbedPane1.addTab("Inicio", jPanel3);

        jPanel4.setBackground(new java.awt.Color(153, 204, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Background.png"))); // NOI18N
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        jLabel5.setFont(new java.awt.Font("Hack Nerd Font", 1, 18)); // NOI18N
        jLabel5.setText("Usuario");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, -1, -1));

        jLabel6.setFont(new java.awt.Font("Hack Nerd Font", 1, 18)); // NOI18N
        jLabel6.setText("Nombres");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 100, -1, -1));

        jLabel7.setFont(new java.awt.Font("Hack Nerd Font", 1, 18)); // NOI18N
        jLabel7.setText("Apellidos");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 140, -1, -1));

        jLabel8.setFont(new java.awt.Font("Hack Nerd Font", 1, 18)); // NOI18N
        jLabel8.setText("DNI");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 180, -1, -1));

        txtNombres.setEnabled(false);
        jPanel4.add(txtNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 100, 180, -1));

        txtApellidos.setEnabled(false);
        txtApellidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidosActionPerformed(evt);
            }
        });
        jPanel4.add(txtApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 140, 180, -1));

        txtDNI.setEnabled(false);
        jPanel4.add(txtDNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 180, 180, -1));

        jLabel11.setText("Desde enero del 2022");
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 160, 150, -1));

        jLabel12.setFont(new java.awt.Font("Hack Nerd Font", 1, 18)); // NOI18N
        jLabel12.setText("Teléfono");
        jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 340, -1, -1));

        txtTelefono.setEnabled(false);
        jPanel4.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 340, 180, -1));

        jLabel26.setFont(new java.awt.Font("Hack Nerd Font", 1, 14)); // NOI18N
        jLabel26.setText("Datos generales del usuario.");
        jPanel4.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 50, -1, -1));

        jLabel21.setFont(new java.awt.Font("Hack Nerd Font", 1, 18)); // NOI18N
        jLabel21.setText("Género");
        jPanel4.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 260, -1, -1));

        jLabel36.setFont(new java.awt.Font("Hack Nerd Font", 1, 18)); // NOI18N
        jLabel36.setText("Correo");
        jPanel4.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 220, -1, -1));

        txtGenero.setEnabled(false);
        jPanel4.add(txtGenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 260, 180, -1));

        txtCorreo.setEnabled(false);
        jPanel4.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 220, 180, -1));

        jLabel37.setFont(new java.awt.Font("Hack Nerd Font", 1, 18)); // NOI18N
        jLabel37.setText("Dirección");
        jPanel4.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 300, -1, -1));

        txtDireccion.setEnabled(false);
        jPanel4.add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 300, 180, -1));

        btnCerrarSesion.setText("Cerrar Sesión");
        btnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesionActionPerformed(evt);
            }
        });
        jPanel4.add(btnCerrarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 30, 140, 50));

        jTabbedPane1.addTab("Perfil", jPanel4);

        jPanel8.setBackground(new java.awt.Color(153, 204, 255));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnagregarreunion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/agregar-archivo.png"))); // NOI18N
        btnagregarreunion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnagregarreunionActionPerformed(evt);
            }
        });
        jPanel8.add(btnagregarreunion, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, -1, -1));

        btnvisualizarreunion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/visualizacion.png"))); // NOI18N
        btnvisualizarreunion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnvisualizarreunionActionPerformed(evt);
            }
        });
        jPanel8.add(btnvisualizarreunion, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 180, -1, -1));

        jLabel17.setFont(new java.awt.Font("Hack Nerd Font", 1, 24)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 102, 153));
        jLabel17.setText("AGREGAR");
        jPanel8.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 130, -1, -1));

        jLabel18.setFont(new java.awt.Font("Hack Nerd Font", 1, 24)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 102, 153));
        jLabel18.setText("VISUALIZAR");
        jPanel8.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 130, -1, -1));

        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/reunion.png"))); // NOI18N
        jPanel8.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 0, 520, 410));

        jTabbedPane1.addTab("Reunión", jPanel8);

        panelServicio.setBackground(new java.awt.Color(153, 204, 255));
        panelServicio.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnagregarservicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/agregar-archivo.png"))); // NOI18N
        btnagregarservicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnagregarservicioActionPerformed(evt);
            }
        });
        panelServicio.add(btnagregarservicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, -1, -1));

        btnvisualizarservicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/visualizacion.png"))); // NOI18N
        btnvisualizarservicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnvisualizarservicioActionPerformed(evt);
            }
        });
        panelServicio.add(btnvisualizarservicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 170, -1, -1));

        jLabel13.setBackground(new java.awt.Color(0, 102, 153));
        jLabel13.setFont(new java.awt.Font("Hack Nerd Font", 1, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 102, 153));
        jLabel13.setText("AGREGAR");
        panelServicio.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, -1, -1));

        jLabel14.setFont(new java.awt.Font("Hack Nerd Font", 1, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 102, 153));
        jLabel14.setText("VISUALIZAR");
        panelServicio.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 120, -1, -1));

        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/agente-de-atencion-al-cliente_1.png"))); // NOI18N
        panelServicio.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, -70, -1, -1));

        jTabbedPane1.addTab("Servicio", panelServicio);

        jPanel6.setBackground(new java.awt.Color(153, 204, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton2.setText("Visualizar Colaboradores");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 310, 160, 100));

        btnAsignarColaboradores.setText("Asignar Colaboradores");
        btnAsignarColaboradores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsignarColaboradoresActionPerformed(evt);
            }
        });
        jPanel6.add(btnAsignarColaboradores, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 310, 160, 100));

        btnagregarproyecto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/agregar-archivo.png"))); // NOI18N
        btnagregarproyecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnagregarproyectoActionPerformed(evt);
            }
        });
        jPanel6.add(btnagregarproyecto, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, -1, -1));

        btnvisualizarproyecto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/visualizacion.png"))); // NOI18N
        btnvisualizarproyecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnvisualizarproyectoActionPerformed(evt);
            }
        });
        jPanel6.add(btnvisualizarproyecto, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 120, -1, -1));

        jLabel15.setFont(new java.awt.Font("Hack Nerd Font", 1, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 102, 153));
        jLabel15.setText("AGREGAR");
        jPanel6.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 60, -1, -1));

        jLabel16.setFont(new java.awt.Font("Hack Nerd Font", 1, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 102, 153));
        jLabel16.setText("VISUALIZAR");
        jPanel6.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 50, -1, -1));

        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/gestion-de-proyectos.png"))); // NOI18N
        jPanel6.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, 530, 540));

        jTabbedPane1.addTab("Proyecto", jPanel6);

        jPanel7.setBackground(new java.awt.Color(153, 204, 255));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnagregarvisitatecnica.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/agregar-archivo.png"))); // NOI18N
        btnagregarvisitatecnica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnagregarvisitatecnicaActionPerformed(evt);
            }
        });
        jPanel7.add(btnagregarvisitatecnica, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 130, -1, -1));

        btnvisualizarvisitatecnica.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/visualizacion.png"))); // NOI18N
        btnvisualizarvisitatecnica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnvisualizarvisitatecnicaActionPerformed(evt);
            }
        });
        jPanel7.add(btnvisualizarvisitatecnica, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 130, -1, -1));

        jLabel19.setFont(new java.awt.Font("Hack Nerd Font", 1, 24)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 102, 153));
        jLabel19.setText("AGREGAR");
        jPanel7.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 90, -1, -1));

        jLabel20.setFont(new java.awt.Font("Hack Nerd Font", 1, 24)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 102, 153));
        jLabel20.setText("VISUALIZAR");
        jPanel7.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 90, -1, -1));

        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/soporte-tecnico.png"))); // NOI18N
        jPanel7.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(-70, -40, -1, -1));

        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/tarjeta-de-identificacion.png"))); // NOI18N
        jPanel7.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 270, -1, -1));

        jTabbedPane1.addTab("Visita Técnica", jPanel7);

        jPanel2.setBackground(new java.awt.Color(153, 204, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel23.setFont(new java.awt.Font("Hack Nerd Font", 1, 24)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 102, 153));
        jLabel23.setText("AGREGAR");
        jPanel2.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(143, 59, -1, -1));

        btnagregarclientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/agregar-usuario.png"))); // NOI18N
        btnagregarclientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnagregarclientesActionPerformed(evt);
            }
        });
        jPanel2.add(btnagregarclientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(121, 115, 161, -1));

        jLabel22.setFont(new java.awt.Font("Hack Nerd Font", 1, 24)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 102, 153));
        jLabel22.setText("VISUALIZAR");
        jPanel2.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(457, 59, -1, -1));

        btnvisualizarclientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/comentarios.png"))); // NOI18N
        btnvisualizarclientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnvisualizarclientesActionPerformed(evt);
            }
        });
        jPanel2.add(btnvisualizarclientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(446, 115, 161, -1));

        jLabel33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/kyc.png"))); // NOI18N
        jPanel2.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(-140, -10, -1, -1));

        jLabel34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cara-feliz (1).png"))); // NOI18N
        jPanel2.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 270, -1, -1));

        jButton3.setText("Generar reporte");
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 500, 180, 80));

        jTabbedPane1.addTab("Clientes", jPanel2);

        jPanel9.setBackground(new java.awt.Color(153, 204, 255));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnrealizarpago.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/metodo-de-pago.png"))); // NOI18N
        btnrealizarpago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnrealizarpagoActionPerformed(evt);
            }
        });
        jPanel9.add(btnrealizarpago, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, -1, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pago.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel9.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 140, -1, -1));

        jLabel24.setFont(new java.awt.Font("Hack Nerd Font", 1, 24)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(0, 102, 153));
        jLabel24.setText("PAGAR");
        jPanel9.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, -1, -1));

        jLabel25.setFont(new java.awt.Font("Hack Nerd Font", 1, 24)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(0, 102, 153));
        jLabel25.setText("PAGOS PENDIENTES");
        jPanel9.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 80, -1, -1));

        jLabel35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pago-en-linea.png"))); // NOI18N
        jPanel9.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, -20, -1, -1));

        jTabbedPane1.addTab("Pago", jPanel9);

        jPanel1.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, 620));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void btnAsignarColaboradoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsignarColaboradoresActionPerformed
        AsignarColaborador ac = new AsignarColaborador();
        ac.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAsignarColaboradoresActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       ListadoColaboradores lc = new ListadoColaboradores();
       lc.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

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
    private javax.swing.JButton btnAsignarColaboradores;
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
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
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
