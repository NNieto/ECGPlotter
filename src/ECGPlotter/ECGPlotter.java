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
import javax.swing.BorderFactory;
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
public class ECGPlotter implements ActionListener {

    // Declaracion de Variables
    JFrame mainFrame = new JFrame();
    Container contentPane = mainFrame.getContentPane();
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
    final XYSeries serie1 = new XYSeries("Fernando Alonso");
    final XYSeries serie2 = new XYSeries("Jaime Alguersuari");
    final XYSeriesCollection collection = new XYSeriesCollection();

    public ECGPlotter(String titulo) {
        serie1.add(1, 131.78);
        serie1.add(2, 129.95);
        serie1.add(3, 128.16);
        serie1.add(4, 125.91);
        serie1.add(5, 130.44);
        serie2.add(1, 133.16);
        serie2.add(2, 132.32);
        serie2.add(3, 129.86);
        serie2.add(4, 128.02);
        serie2.add(5, 132.45);
        collection.addSeries(serie1);
        collection.addSeries(serie2);
        // Set properties 
        mainFrame.setTitle(titulo);
        archivo.add(pacienteNuevo);
        archivo.add(cargarPaciente);
        archivo.add(guardar);
        mainMenu.add(archivo);
        mainFrame.setJMenuBar(mainMenu);
        //    osc.setBackground(Color.black);
        // osc.setBorder(BorderFactory.createLoweredBevelBorder());
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(800, 600);
        guardar.setBounds(300, 250, 100, 30);
        nombrePaciente.setBounds(150, 60, 100, 20);
        mainPanel.setBounds(140, 80, 450, 200);
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
        contentPane.add(nombrePaciente);
        contentPane.add(mainPanel);
        contentPane.add(observaciones);
        contentPane.add(scrollNotas);
        //final JFreeChart grafica = osc.crearGrafica(collection);
        //  osc.crearGrafica(collection);
        mainFrame.setVisible(true);
    }

    public static void main(String[] args) {
        ECGPlotter main = new ECGPlotter("ECG Plotter");

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String Accion = e.getActionCommand();

        if ("Cargar Paciente".equals(Accion)) {
            CargarPaciente cp = new CargarPaciente(mainFrame, true);
            String[] valores = cp.obtenerPaciente();
            nombrePaciente.setText("#" + valores[0] + " " + valores[1] + " " + valores[2]);
            notas.setText(valores[4]);
        }

        if ("Guardar".equals(Accion)) {
            BDMySQL ECG = new BDMySQL();

        }

        if ("Paciente Nuevo".equals(Accion)) {
            CrearPaciente dialog = new CrearPaciente(new java.awt.Frame(), true);
            
            dialog.setVisible(true);

        }

    }

}
