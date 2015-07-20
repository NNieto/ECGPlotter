/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ECGPlotter;

import java.awt.BorderLayout;
import org.jfree.chart.ChartPanel;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author Alejandro
 */
public class Medir extends java.awt.Dialog {

    /**
     * Creates new form Medir
     */
    public Medir(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        chart = new ChartPanel(osc.crearGrafica(collection));
        ContenedorOsciloscopio.setLayout(new BorderLayout());
        ContenedorOsciloscopio.add(chart, BorderLayout.CENTER);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollBar1 = new javax.swing.JScrollBar();
        ContenedorOsciloscopio = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ObservacionesArea = new javax.swing.JTextArea();
        ObservacionesLabel = new javax.swing.JLabel();
        Grabar = new javax.swing.JButton();
        GuardarImagenBoton = new javax.swing.JButton();
        javax.swing.JButton GuardarECG = new javax.swing.JButton();

        setTitle("Medición");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        ContenedorOsciloscopio.setBackground(new java.awt.Color(102, 102, 102));

        ObservacionesArea.setColumns(20);
        ObservacionesArea.setRows(5);
        jScrollPane1.setViewportView(ObservacionesArea);

        ObservacionesLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        ObservacionesLabel.setForeground(new java.awt.Color(0, 102, 255));
        ObservacionesLabel.setText("Observaciones");
        ObservacionesLabel.setToolTipText("");

        Grabar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Grabar.setText("Grabar");
        Grabar.setToolTipText("");
        Grabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GrabarActionPerformed(evt);
            }
        });

        GuardarImagenBoton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        GuardarImagenBoton.setText("Guardar Imagen");
        GuardarImagenBoton.setToolTipText("");
        GuardarImagenBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarImagenBotonActionPerformed(evt);
            }
        });

        GuardarECG.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        GuardarECG.setText("Guardar Registro ECG");
        GuardarECG.setToolTipText("");
        GuardarECG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarECGActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ContenedorOsciloscopio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 884, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(172, 172, 172)
                                .addComponent(Grabar, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(GuardarImagenBoton)
                                .addGap(39, 39, 39)
                                .addComponent(GuardarECG, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(ObservacionesLabel)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(ContenedorOsciloscopio, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ObservacionesLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Grabar)
                    .addComponent(GuardarImagenBoton)
                    .addComponent(GuardarECG))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Closes the dialog
     */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    private void GrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GrabarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GrabarActionPerformed

    private void GuardarImagenBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarImagenBotonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GuardarImagenBotonActionPerformed

    private void GuardarECGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarECGActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GuardarECGActionPerformed

    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ContenedorOsciloscopio;
    private javax.swing.JButton Grabar;
    private javax.swing.JButton GuardarImagenBoton;
    private javax.swing.JTextArea ObservacionesArea;
    private javax.swing.JLabel ObservacionesLabel;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
    private ChartPanel chart;
    Osciloscopio osc = new Osciloscopio();
    final XYSeries serie1 = new XYSeries("ECG");
    final XYSeriesCollection collection = new XYSeriesCollection();
}
