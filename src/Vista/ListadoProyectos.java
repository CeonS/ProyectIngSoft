package Vista;

import Controlador.DBNivelParametros;
import Modelo.probarConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.HeadlessException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.SQLException;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import java.io.IOException;

public class ListadoProyectos extends javax.swing.JFrame {

    public ListadoProyectos() {
        initComponents();
        this.setLocationRelativeTo(null);
        mostrarTabla();
    }
    DefaultTableModel modelo = new DefaultTableModel();
    probarConexionDB pcDB = new probarConexionDB();
    public static String idProyecto, descripcionSector;
    public static int filaSeleccionada;

    void mostrarTabla() {

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
            tablaProyecto.setModel(modelo);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error listar: " + e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProyecto = new javax.swing.JTable();
        btnactualizar = new javax.swing.JButton();
        DateCInicial = new com.toedter.calendar.JDateChooser();
        DateCFInal = new com.toedter.calendar.JDateChooser();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAObservaciones = new javax.swing.JTextArea();
        btnReportePDF = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtEstado = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtZonaEjecucion = new javax.swing.JTextField();
        txtSector = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaProyecto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Sector", "Fecha inicial", "Fecha final", "Zona ejecución", "Observaciones", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tablaProyecto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaProyectoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaProyecto);
        if (tablaProyecto.getColumnModel().getColumnCount() > 0) {
            tablaProyecto.getColumnModel().getColumn(0).setResizable(false);
            tablaProyecto.getColumnModel().getColumn(1).setResizable(false);
            tablaProyecto.getColumnModel().getColumn(2).setResizable(false);
            tablaProyecto.getColumnModel().getColumn(3).setResizable(false);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 1550, 340));

        btnactualizar.setBackground(new java.awt.Color(204, 204, 204));
        btnactualizar.setFont(new java.awt.Font("Open Sans", 1, 14)); // NOI18N
        btnactualizar.setText("ACTUALIZAR");
        btnactualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnactualizarActionPerformed(evt);
            }
        });
        getContentPane().add(btnactualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, 630, 140, 50));

        DateCInicial.setDateFormatString("yyyy-MM-dd");
        getContentPane().add(DateCInicial, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 570, 160, 30));

        DateCFInal.setDateFormatString("yyyy-MM-dd");
        getContentPane().add(DateCFInal, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 620, 160, 30));

        txtAObservaciones.setColumns(20);
        txtAObservaciones.setRows(5);
        jScrollPane2.setViewportView(txtAObservaciones);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 580, 350, 100));

        btnReportePDF.setFont(new java.awt.Font("Open Sans", 1, 14)); // NOI18N
        btnReportePDF.setText("GENERAR REPORTE");
        btnReportePDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportePDFActionPerformed(evt);
            }
        });
        getContentPane().add(btnReportePDF, new org.netbeans.lib.awtextra.AbsoluteConstraints(1460, 470, 170, 50));

        jButton4.setBackground(new java.awt.Color(204, 204, 204));
        jButton4.setFont(new java.awt.Font("Open Sans", 1, 14)); // NOI18N
        jButton4.setText("SALIR");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1480, 630, 140, 50));

        jLabel8.setFont(new java.awt.Font("Bludhaven", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Observaciones");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 570, -1, 30));
        getContentPane().add(txtEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 680, 160, 30));

        jLabel7.setFont(new java.awt.Font("Bludhaven", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Estado");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 690, -1, 30));

        jLabel5.setFont(new java.awt.Font("Bludhaven", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Zona Ejecucion");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 520, -1, 30));

        jLabel3.setFont(new java.awt.Font("Bludhaven", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Fecha final");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 630, -1, -1));

        jLabel4.setFont(new java.awt.Font("Bludhaven", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Fecha inicial");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 570, -1, -1));
        getContentPane().add(txtZonaEjecucion, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 520, 160, 30));
        getContentPane().add(txtSector, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 520, 160, 30));

        jLabel1.setFont(new java.awt.Font("Bludhaven", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Sector");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 520, -1, -1));

        jLabel2.setFont(new java.awt.Font("Signatra DEMO", 1, 60)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Lista de proyectos");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 40, 450, 60));

        txtnombre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondolista.png"))); // NOI18N
        getContentPane().add(txtnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 1720, 834));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnactualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnactualizarActionPerformed
        DBNivelParametros np = new DBNivelParametros();
        String validar = txtSector.getText();
        if (validar.equals("")) {
            JOptionPane.showMessageDialog(null, "Escoja una fila primero!");
        } else {
            String datosU[] = new String[4];

            datosU[0] = txtSector.getText();
            datosU[1] = txtZonaEjecucion.getText();
            datosU[2] = txtAObservaciones.getText();
            datosU[3] = txtEstado.getText();

            Date fechaI = DateCInicial.getDate();
            long dI = fechaI.getTime();
            java.sql.Date fechaIN = new java.sql.Date(dI);

            Date fechaF = DateCInicial.getDate();
            long dF = fechaF.getTime();
            java.sql.Date fechaFI = new java.sql.Date(dF);

            String sqlSector = "UPDATE nivelparametro SET descripcionParametro = '" + datosU[0] + "' where descripcionParametro = '" + descripcionSector + "'";
            String sqlProyecto = "UPDATE proyecto SET fecha_Inicial_Proyecto = '" + fechaIN + "', fecha_Final_Proyecto = '" + fechaFI + "', zonaEjecucionProy = '" + datosU[1] + "'"
                    + ", estado_proyecto = '" + datosU[3] + "', observacionesProy = '" + datosU[2] + "' where idProyecto = " + idProyecto;

            try {

                PreparedStatement pps1 = pcDB.connection2().prepareStatement(sqlSector);
                pps1.executeUpdate();
                pps1.close();
                PreparedStatement pps2 = pcDB.connection2().prepareStatement(sqlProyecto);
                pps2.executeUpdate();
                pps2.close();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error de actualizacion " + e);
            }
        }

        int fila = tablaProyecto.getRowCount();
        for (int i = fila - 1; i >= 0; i--) {
            modelo.removeRow(i);
        }

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
            tablaProyecto.setModel(modelo);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error listar: " + e);
        }
    }//GEN-LAST:event_btnactualizarActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
         if (Login.colaboradorForm == true) {
            FormColaborador fc = new FormColaborador();
            fc.setVisible(true);
            this.dispose();
        } else {
            FormEmpleado fe = new FormEmpleado();
            fe.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void tablaProyectoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaProyectoMouseClicked
        filaSeleccionada = tablaProyecto.rowAtPoint(evt.getPoint());
        txtSector.setText(tablaProyecto.getValueAt(filaSeleccionada, 1).toString());
        DateCInicial.setDate(java.sql.Date.valueOf(tablaProyecto.getModel().getValueAt(filaSeleccionada, 2).toString()));
        DateCFInal.setDate(java.sql.Date.valueOf(tablaProyecto.getModel().getValueAt(filaSeleccionada, 3).toString()));
        txtZonaEjecucion.setText(tablaProyecto.getValueAt(filaSeleccionada, 4).toString());
        txtAObservaciones.setText(tablaProyecto.getValueAt(filaSeleccionada, 6).toString());
        txtEstado.setText(tablaProyecto.getValueAt(filaSeleccionada, 7).toString());
        idProyecto = tablaProyecto.getValueAt(filaSeleccionada, 0).toString();


    }//GEN-LAST:event_tablaProyectoMouseClicked

    private void btnReportePDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportePDFActionPerformed

        Document documento = new Document(PageSize.A4, 60, 60, 50, 50);
        String validar = txtEstado.getText();
        if (validar.equals("")) {
            JOptionPane.showMessageDialog(null, "Seleccione un proyecto primero!");
        } else {
            try {
                String ruta = System.getProperty("user.home");

                PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Documents//ReportesG2R/Reporte_Proyecto 0" + idProyecto + ".pdf"));

                Image header = Image.getInstance("src/img/G2RSolutions.jpg");
                header.scaleToFit(500, 1000);
                header.setAlignment(Chunk.ALIGN_CENTER);

                Paragraph parrafo = new Paragraph();
                parrafo.setAlignment(Paragraph.ALIGN_CENTER);

                parrafo.setFont(FontFactory.getFont("Tahoma", 18, Font.BOLD, BaseColor.DARK_GRAY));
                parrafo.add("\n\nREPORTE PROYECTO NRO. 0" + idProyecto + "\n\n");

                Paragraph parrafoFinal = new Paragraph();
                parrafoFinal.setAlignment(Paragraph.ALIGN_JUSTIFIED);
                parrafo.setFont(FontFactory.getFont("Tahoma", 14, Font.BOLD, BaseColor.DARK_GRAY));
                parrafoFinal.add("\n\nObservaciones: ");

                documento.open();
                documento.add(header);
                documento.add(parrafo);

                PdfPTable tabla = new PdfPTable(7);
                tabla.addCell("ID Proyecto");
                tabla.addCell("ID Reunión");
                tabla.addCell("Fecha Inicial");
                tabla.addCell("Fecha Final");
                tabla.addCell("Zona Ejecución");
                tabla.addCell("Sector");
                tabla.addCell("Estado");

                try {
                    String sqlReporte = "select p.idProyecto, p.id_Reunion_Proy ,p.fecha_Inicial_Proyecto, p.fecha_Final_Proyecto, p.zonaEjecucionProy, np.descripcionParametro,\n"
                            + "  p.estado_proyecto, p.observacionesProy from proyecto p \n"
                            + " inner join nivelparametro np on p.id_Parametro_Sector_Proy = np.idParametro where p.idProyecto = " + idProyecto;
                    PreparedStatement pst = pcDB.connection2().prepareStatement(sqlReporte);

                    ResultSet rs = pst.executeQuery();
                    if (rs.next()) {
                        do {
                            tabla.addCell(rs.getString(1));
                            tabla.addCell(rs.getString(2));
                            tabla.addCell(rs.getString(3));
                            tabla.addCell(rs.getString(4));
                            tabla.addCell(rs.getString(5));
                            tabla.addCell(rs.getString(6));
                            tabla.addCell(rs.getString(7));
                            parrafoFinal.add(rs.getString(8));

                        } while (rs.next());
                        documento.add(tabla);
                        documento.add(parrafoFinal);

                    }

                } catch (DocumentException | SQLException e) {
                }

                try {

                } catch (Exception e) {
                }
                documento.close();
                JOptionPane.showMessageDialog(null, "Reporte del proyecto creado!!!");

            } catch (DocumentException | HeadlessException | FileNotFoundException e) {
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error en la imagen");
            }

        }


    }//GEN-LAST:event_btnReportePDFActionPerformed

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
            java.util.logging.Logger.getLogger(ListadoProyectos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListadoProyectos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListadoProyectos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListadoProyectos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListadoProyectos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser DateCFInal;
    private com.toedter.calendar.JDateChooser DateCInicial;
    private javax.swing.JButton btnReportePDF;
    private javax.swing.JButton btnactualizar;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablaProyecto;
    private javax.swing.JTextArea txtAObservaciones;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtSector;
    private javax.swing.JTextField txtZonaEjecucion;
    private javax.swing.JLabel txtnombre;
    // End of variables declaration//GEN-END:variables
}
