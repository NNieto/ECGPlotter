/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ECGPlotter;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author Norman
 */
public class Medir implements ActionListener {

    // Declaracion de Variables
    int i = 0;
    Random rnd = new Random();
    JDialog mainDialog = new JDialog();
    Container contentPane = mainDialog.getContentPane();
    JPanel mainPanel = new JPanel();
    ChartPanel chart;
    JMenuBar mainMenu = new JMenuBar();
    JMenu archivo = new JMenu("Archivo");
    JMenuItem pacienteNuevo = new JMenuItem("Paciente Nuevo");
    JMenuItem cargarPaciente = new JMenuItem("Cargar Paciente");
    JMenuItem guardar = new JMenuItem("Guardar");
    JLabel nombrePaciente = new JLabel("Nombre Paciente");
    JLabel observaciones = new JLabel("Observaciones");
    JTextArea notas = new JTextArea();
    JScrollPane scrollNotas = new JScrollPane(notas);
    Osciloscopio osc = new Osciloscopio();
    final XYSeries serie1 = new XYSeries("ECG");
    final XYSeriesCollection collection = new XYSeriesCollection();

    public Medir(String titulo) {
        serie1.add(0, 0);
        collection.addSeries(serie1);
        // Set properties 
        mainDialog.setTitle(titulo);
        archivo.add(pacienteNuevo);
        archivo.add(cargarPaciente);
        archivo.add(guardar);
        mainMenu.add(archivo);
        mainDialog.setJMenuBar(mainMenu);
        //    osc.setBackground(Color.black);
        // osc.setBorder(BorderFactory.createLoweredBevelBorder());
       // mainDialog.setDefaultCloseOperation(JDialog.EXIT_ON_CLOSE);
        mainDialog.setSize(800, 600);
        guardar.setBounds(300, 250, 100, 30);
        nombrePaciente.setBounds(150, 60, 100, 20);
        mainPanel.setBounds(180, 0, 610, 600);
        observaciones.setBounds(150, 300, 100, 20);
        scrollNotas.setBounds(140, 320, 450, 100);
        cargarPaciente.addActionListener(this);
        pacienteNuevo.addActionListener(this);
        guardar.addActionListener(this);
        chart = new ChartPanel(osc.crearGrafica(collection));
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(chart, BorderLayout.NORTH);
        // Añadiendo componentes al contenedor
        contentPane.setLayout(null);
        // contentPane.add(nombrePaciente);
        contentPane.add(mainPanel);
       // contentPane.add(observaciones);
        // contentPane.add(scrollNotas);
        //final JFreeChart grafica = osc.crearGrafica(collection);
        //  osc.crearGrafica(collection);
        mainDialog.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String Accion = e.getActionCommand();

        if ("Cargar Paciente".equals(Accion)) {
            
        }

        if ("Guardar".equals(Accion)) {
            BDMySQL ECG = new BDMySQL();

        }

        if ("Paciente Nuevo".equals(Accion)) {
            //i++;
            try {

                for (; i < 200; i++) {
                    Thread.sleep(0);
                    serie1.add(i,(int) (rnd.nextDouble() * 50 + 1));
                    Thread.sleep(0);
                }
            } catch (InterruptedException ie) {
    //Handle exception
            }

        }

    }

}
