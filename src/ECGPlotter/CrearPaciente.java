/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ECGPlotter;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Norman
 */
public class CrearPaciente extends JDialog implements ActionListener {
    
    
    Container contentPane = this.getContentPane();
    JLabel nombreLabel = new JLabel("Nombre");
    JLabel apellidoLabel = new JLabel("Apellido");
    JLabel _idLabel = new JLabel("ID");
    JTextField nombre = new JTextField();
    JTextField apellido = new JTextField();
    JButton empezarButton = new JButton("Medir");
    JLabel observacionesLabel = new JLabel("Observaciones");
    JTextArea notas = new JTextArea();
    JScrollPane scrollNotas=new JScrollPane(notas);
    public CrearPaciente(JFrame padre, boolean modal){
    
       // set properties
          nombreLabel.setBounds(20, 10, 100, 20);
          nombre.setBounds(18,40,240,30);
          apellidoLabel.setBounds(20, 80, 100, 20);
          apellido.setBounds(20, 120, 100, 20);
          observacionesLabel.setBounds(90, 200, 100, 20);
          
          Container contenedor = getContentPane();
          contenedor.setLayout(null);
        
          this.setBounds(250, 100, 300, 300);
       // cargar.addActionListener(this);
       // buscar.addActionListener(this);
        
        
        //Añadiendo items al contenedor
          contenedor.add(nombreLabel);
          contenedor.add(nombre); 
          contenedor.add(apellidoLabel);
          contenedor.add(apellido);
          contenedor.add(observacionesLabel);
          contenedor.add(scrollNotas);
       

          setTitle("Cargar Paciente");
          setModal(modal);
          setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
}
