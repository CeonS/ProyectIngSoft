package Vista;

import Controlador.DBColaborador;
import Controlador.DBNivelParametros;
import Controlador.DBPersona;
import Controlador.DBServicio;
import Controlador.Parametros;
import Modelo.probarConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ListadoColaboradores extends javax.swing.JFrame {

    public ListadoColaboradores() {
        initComponents();
        this.setLocationRelativeTo(null);
        mostrarTablaColaboradores();
        rellenarComboBoxs();
    }
    DefaultTableModel modelo2 = new DefaultTableModel();
    probarConexionDB pcDB = new probarConexionDB();
    public static int idColaborador, dni;
    public static String descrip;

    public void rellenarComboBoxs() {

        DBPersona p = new DBPersona();
        ArrayList<Parametros> listaColaboradoresGenero = p.getGeneros(pcDB.connection2());

        cbxGenero.removeAllItems();

        for (int i = 0; i < listaColaboradoresGenero.size(); i++) {
            cbxGenero.addItem(listaColaboradoresGenero.get(i).getDescripcionParametro());
        }

        //CbxTipoCOLABORADOR
        DBColaborador c = new DBColaborador();
        ArrayList<Parametros> listaColaboradoresTipo = c.getTipoColaborador(pcDB.connection2());

        cbxTipoColaborador.removeAllItems();

        for (int i = 0; i < listaColaboradoresTipo.size(); i++) {
            cbxTipoColaborador.addItem(listaColaboradoresTipo.get(i).getDescripcionParametro());
        }

    }

    void mostrarTablaColaboradores() {

        modelo2.addColumn("ID");
        modelo2.addColumn("Proyecto Asociado");
        modelo2.addColumn("Nombres");
        modelo2.addColumn("Apellidos");
        modelo2.addColumn("Zona Laboral");
        modelo2.addColumn("Telefono");
        modelo2.addColumn("DNI");
        modelo2.addColumn("Correo");
        modelo2.addColumn("Género");
        modelo2.addColumn("Tipo Colaborador");
        modelo2.addColumn("Descripción");
        modelo2.addColumn("Estado");

        tablaColaboradores.setModel(modelo2);

        String sql = "SELECT c.idColaborador, pr.idProyecto, p.nombres, p.apellidos, c.zonaLaboral, p.telefono, p.dni, p.correo,  if(p.id_ParametroGenero=6,'Femenino','Masculino') as Genero,np.descripcionParametro\n"
                + " , dc.descripcionColaborador,c.estado_Colaborador  FROM persona p\n"
                + " inner join colaborador c on p.idPersona = c.id_Persona_Tec\n"
                + " inner join nivelparametro np on c.id_Parametro_Tipo_Colaborador = np.idParametro\n"
                + " inner join detallecolaborador dc on c.idColaborador = dc.id_ColaboradorDetalle\n"
                + " inner join proyecto pr on dc.id_Proyecto_DetalleColaboradores = pr.idProyecto";

        String datos[] = new String[12];
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
                datos[8] = rs.getString(9);
                datos[9] = rs.getString(10);
                datos[10] = rs.getString(11);
                datos[11] = rs.getString(12);
                modelo2.addRow(datos);
            }
            tablaColaboradores.setModel(modelo2);
        } catch (Exception e) {
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaColaboradores = new javax.swing.JTable();
        btnActualizar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtNombres = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtApellidos = new javax.swing.JTextField();
        txtZonaLaboral = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtDNI = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cbxGenero = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        cbxTipoColaborador = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtADescripcion = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        txtEstado = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaColaboradores.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaColaboradores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaColaboradoresMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaColaboradores);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, 1530, 340));

        btnActualizar.setFont(new java.awt.Font("Open Sans", 1, 14)); // NOI18N
        btnActualizar.setText("ACTUALIZAR");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        getContentPane().add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, 650, 140, 50));

        btnSalir.setFont(new java.awt.Font("Open Sans", 1, 14)); // NOI18N
        btnSalir.setText("SALIR");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(1490, 650, 140, 50));

        jLabel1.setFont(new java.awt.Font("Bludhaven", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nombres");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 500, -1, 40));
        getContentPane().add(txtNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 510, 200, -1));

        jLabel2.setFont(new java.awt.Font("Bludhaven", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Apellidos");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 540, -1, 40));
        getContentPane().add(txtApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 550, 200, -1));
        getContentPane().add(txtZonaLaboral, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 590, 200, -1));

        jLabel3.setFont(new java.awt.Font("Bludhaven", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Zona Laboral");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 580, -1, 40));

        jLabel4.setFont(new java.awt.Font("Bludhaven", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Telefono");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 620, -1, 40));
        getContentPane().add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 630, 200, -1));

        jLabel5.setFont(new java.awt.Font("Bludhaven", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Correo");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 700, -1, 40));
        getContentPane().add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 710, 200, -1));

        jLabel6.setFont(new java.awt.Font("Bludhaven", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("DNI");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 660, -1, 40));
        getContentPane().add(txtDNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 670, 200, -1));

        jLabel7.setFont(new java.awt.Font("Bludhaven", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Género");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 510, -1, -1));

        cbxGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Femenino" }));
        cbxGenero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxGeneroActionPerformed(evt);
            }
        });
        getContentPane().add(cbxGenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 510, 140, -1));

        jLabel8.setFont(new java.awt.Font("Bludhaven", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Tipo colaborador");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 550, -1, -1));

        jLabel12.setFont(new java.awt.Font("Signatra DEMO", 1, 60)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Lista de colaboradores");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 30, -1, -1));

        cbxTipoColaborador.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(cbxTipoColaborador, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 550, 140, -1));

        jLabel9.setFont(new java.awt.Font("Bludhaven", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Descripción");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 600, -1, -1));

        txtADescripcion.setColumns(20);
        txtADescripcion.setRows(5);
        jScrollPane2.setViewportView(txtADescripcion);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 600, 287, -1));

        jLabel10.setFont(new java.awt.Font("Bludhaven", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Estado");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 710, -1, -1));
        getContentPane().add(txtEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 710, 140, -1));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondolista.png"))); // NOI18N
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1720, 840));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed

        String validar = txtNombres.getText();
        if (validar.equals("")) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila primero!");
        } else {
            String Datos[] = new String[10];

            Datos[0] = txtNombres.getText();
            Datos[1] = txtApellidos.getText();
            Datos[2] = txtZonaLaboral.getText();
            Datos[3] = txtTelefono.getText();
            Datos[4] = txtDNI.getText();
            Datos[5] = txtCorreo.getText();
            Datos[6] = cbxGenero.getSelectedItem().toString();
            Datos[7] = cbxTipoColaborador.getSelectedItem().toString();
            Datos[8] = txtADescripcion.getText();
            Datos[9] = txtEstado.getText();

            DBNivelParametros np = new DBNivelParametros();

            int idGenero = np.Validar(pcDB.connection2(), Datos[6]);
            int idParametroTipo = np.Validar(pcDB.connection2(), Datos[7]);

            String sqlColaborador = "UPDATE colaborador SET zonaLaboral = '" + Datos[2]
                    + "', estado_Colaborador = '" + Datos[9] + "', id_Parametro_Tipo_Colaborador = " + idParametroTipo + ""
                    + " where idColaborador = " + idColaborador;

            String sqlPersona = "UPDATE persona SET nombres = '" + Datos[0] + "', apellidos = '" + Datos[1] + "',"
                    + " telefono = " + Datos[3] + ", dni = " + Datos[4] + ", correo = '" + Datos[5] + "'"
                    + ", id_ParametroGenero = " + idGenero + ", estado_persona = '" + Datos[9] + "' where "
                    + "dni = " + dni;

            String sqlDetalleColaborador = "UPDATE detallecolaborador SET estadoDetalleColaborador = '" + Datos[9] + "',"
                    + " descripcionColaborador = '" + Datos[8] + "' where descripcionColaborador = '" + descrip + "'";

            try {

                PreparedStatement pps1 = pcDB.connection2().prepareStatement(sqlColaborador);
                pps1.executeUpdate();
                pps1.close();
                PreparedStatement pps2 = pcDB.connection2().prepareStatement(sqlPersona);
                pps2.executeUpdate();
                pps2.close();
                PreparedStatement pps3 = pcDB.connection2().prepareStatement(sqlDetalleColaborador);
                pps3.executeUpdate();
                pps3.close();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error de actualizacion " + e);
            }
        }

        int fila = tablaColaboradores.getRowCount();
        for (int i = fila - 1; i >= 0; i--) {
            modelo2.removeRow(i);
        }

        String sql = "SELECT c.idColaborador, pr.idProyecto, p.nombres, p.apellidos, c.zonaLaboral, p.telefono, p.dni, p.correo,  if(p.id_ParametroGenero=6,'Femenino','Masculino') as Genero,np.descripcionParametro\n"
                + " , dc.descripcionColaborador,c.estado_Colaborador  FROM persona p\n"
                + " inner join colaborador c on p.idPersona = c.id_Persona_Tec\n"
                + " inner join nivelparametro np on c.id_Parametro_Tipo_Colaborador = np.idParametro\n"
                + " inner join detallecolaborador dc on c.idColaborador = dc.id_ColaboradorDetalle\n"
                + " inner join proyecto pr on dc.id_Proyecto_DetalleColaboradores = pr.idProyecto";

        String datos[] = new String[12];
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
                datos[8] = rs.getString(9);
                datos[9] = rs.getString(10);
                datos[10] = rs.getString(11);
                datos[11] = rs.getString(12);
                modelo2.addRow(datos);
            }
            tablaColaboradores.setModel(modelo2);
        } catch (Exception e) {
        }


    }//GEN-LAST:event_btnActualizarActionPerformed

    private void tablaColaboradoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaColaboradoresMouseClicked
        int filaSeleccionada = tablaColaboradores.rowAtPoint(evt.getPoint());
        idColaborador = Integer.parseInt(tablaColaboradores.getValueAt(filaSeleccionada, 0).toString());
        txtNombres.setText(tablaColaboradores.getValueAt(filaSeleccionada, 2).toString());
        txtApellidos.setText(tablaColaboradores.getValueAt(filaSeleccionada, 3).toString());
        txtZonaLaboral.setText(tablaColaboradores.getValueAt(filaSeleccionada, 4).toString());
        txtTelefono.setText(tablaColaboradores.getValueAt(filaSeleccionada, 5).toString());
        txtDNI.setText(tablaColaboradores.getValueAt(filaSeleccionada, 6).toString());
        dni = Integer.parseInt(tablaColaboradores.getValueAt(filaSeleccionada, 6).toString());
        txtCorreo.setText(tablaColaboradores.getValueAt(filaSeleccionada, 7).toString());
        cbxGenero.setSelectedItem(tablaColaboradores.getValueAt(filaSeleccionada, 8).toString());
        cbxTipoColaborador.setSelectedItem(tablaColaboradores.getValueAt(filaSeleccionada, 9).toString());
        txtADescripcion.setText(tablaColaboradores.getValueAt(filaSeleccionada, 10).toString());
        descrip = tablaColaboradores.getValueAt(filaSeleccionada, 10).toString();
        txtEstado.setText(tablaColaboradores.getValueAt(filaSeleccionada, 11).toString());
    }//GEN-LAST:event_tablaColaboradoresMouseClicked

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
         if (Login.colaboradorForm == true) {
            FormColaborador fc = new FormColaborador();
            fc.setVisible(true);
            this.dispose();
        } else {
            FormEmpleado fe = new FormEmpleado();
            fe.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnSalirActionPerformed

    private void cbxGeneroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxGeneroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxGeneroActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListadoColaboradores().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cbxGenero;
    private javax.swing.JComboBox<String> cbxTipoColaborador;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablaColaboradores;
    private javax.swing.JTextArea txtADescripcion;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDNI;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtZonaLaboral;
    // End of variables declaration//GEN-END:variables
}
