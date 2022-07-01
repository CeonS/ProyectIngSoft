package Vista;

import Controlador.DBDetalleColaborador;
import Modelo.probarConexionDB;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class AsignarColaborador extends javax.swing.JFrame {

    public AsignarColaborador() {
        initComponents();
        this.setLocationRelativeTo(null);
        mostrarTablaColaboradores();
        mostrarTablaProyectos();
    }

    DefaultTableModel modelo = new DefaultTableModel();
    DefaultTableModel modelo2 = new DefaultTableModel();
    probarConexionDB pcDB = new probarConexionDB();
    public static int idproyecto, idcolaborador;

    void mostrarTablaProyectos() {

        modelo.addColumn("ID");
        modelo.addColumn("ID Reunión");
        modelo.addColumn("Fecha Inicial");
        modelo.addColumn("Fecha Final");
        modelo.addColumn("Zona Ejecución");
        modelo.addColumn("Sector");
        modelo.addColumn("Observaciones");
        modelo.addColumn("Estado");

        tablaProyectos.setModel(modelo);

        String sql = "select p.idProyecto, p.id_Reunion_Proy ,p.fecha_Inicial_Proyecto, p.fecha_Final_Proyecto, p.zonaEjecucionProy, np.descripcionParametro,"
                + " p.observacionesProy, p.estado_proyecto from proyecto p \n"
                + "inner join nivelparametro np on p.id_Parametro_Sector_Proy = np.idParametro";

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
            tablaProyectos.setModel(modelo);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error listar: " + e);
        }
    }

    void mostrarTablaColaboradores() {

        modelo2.addColumn("ID");
        modelo2.addColumn("Nombres");
        modelo2.addColumn("Apellidos");
        modelo2.addColumn("Zona Laboral");
        modelo2.addColumn("Telefono");
        modelo2.addColumn("DNI");
        modelo2.addColumn("Correo");
        modelo2.addColumn("Género");
        modelo2.addColumn("Tipo Colaborador");
        modelo2.addColumn("Estado");

        tablaColaboradores.setModel(modelo2);

        String sql = "SELECT c.idColaborador, p.nombres, p.apellidos, c.zonaLaboral, p.telefono, p.dni, p.correo, c.estado_Colaborador,np.descripcionParametro\n"
                + ", if(p.id_ParametroGenero=6,'Femenino','Masculino') as Genero FROM persona p\n"
                + "              inner join colaborador c on p.idPersona = c.id_Persona_Tec\n"
                + "             inner join nivelparametro np on c.id_Parametro_Tipo_Colaborador = np.idParametro";

        String datos[] = new String[10];
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
                datos[7] = rs.getString(10);
                datos[8] = rs.getString(9);
                datos[9] = rs.getString(8);
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
        tablaProyectos = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaColaboradores = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtADescripcion = new javax.swing.JTextArea();
        btnAsignar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tablaProyectos.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaProyectos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaProyectosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaProyectos);

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
        jScrollPane2.setViewportView(tablaColaboradores);

        jLabel1.setText("Proyectos");

        jLabel2.setText("Colaboradores");

        jLabel3.setText("DESCRIPCIÓN:");

        txtADescripcion.setColumns(20);
        txtADescripcion.setRows(5);
        jScrollPane3.setViewportView(txtADescripcion);

        btnAsignar.setText("Asignar");
        btnAsignar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsignarActionPerformed(evt);
            }
        });

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 738, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 738, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAsignar, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnAsignar, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                            .addComponent(btnSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAsignarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsignarActionPerformed

        DBDetalleColaborador dc = new DBDetalleColaborador();
        String descripcion = txtADescripcion.getText();
        dc.AgregarDetalleColaborador(pcDB.connection2(), idcolaborador, descripcion , idproyecto);

    }//GEN-LAST:event_btnAsignarActionPerformed

    private void tablaProyectosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaProyectosMouseClicked
        int filaSeleccionadaProyec = tablaProyectos.rowAtPoint(evt.getPoint());
        idproyecto = Integer.parseInt(tablaProyectos.getValueAt(filaSeleccionadaProyec, 0).toString());
    }//GEN-LAST:event_tablaProyectosMouseClicked

    private void tablaColaboradoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaColaboradoresMouseClicked
        int filaSeleccionadaColab = tablaColaboradores.rowAtPoint(evt.getPoint());
        idcolaborador = Integer.parseInt(tablaColaboradores.getValueAt(filaSeleccionadaColab, 0).toString());
    }//GEN-LAST:event_tablaColaboradoresMouseClicked

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
           FormEmpleado fe = new FormEmpleado();
        FormColaborador fc = new FormColaborador();

        if (fc.colaboradorForm == true) {
            fc.setVisible(true);
            this.dispose();
        } else {

            fe.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnSalirActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AsignarColaborador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAsignar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tablaColaboradores;
    private javax.swing.JTable tablaProyectos;
    private javax.swing.JTextArea txtADescripcion;
    // End of variables declaration//GEN-END:variables
}
