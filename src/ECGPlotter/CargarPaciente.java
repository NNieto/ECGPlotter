/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ECGPlotter;

import com.mysql.jdbc.Connection;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Norman
 */
public class CargarPaciente extends JDialog implements ActionListener {

    JLabel buscarTexto = new JLabel("Buscar...");
    JTextField buscarCampo = new JTextField();
    JLabel resultado = new JLabel("resultado");
    JButton cargar = new JButton("Cargar");
    JButton buscar = new JButton("Buscar");
    Connection Conexion;
    String[] valores;

    public CargarPaciente(JFrame padre, boolean modal) {

        // set properties
        buscarTexto.setBounds(20, 10, 100, 20);
        buscarCampo.setBounds(18, 40, 240, 30);
        buscar.setBounds(20, 80, 100, 20);
        resultado.setBounds(20, 120, 100, 20);
        cargar.setBounds(90, 200, 100, 20);
        setModal(modal);
        Container contenedor = getContentPane();
        contenedor.setLayout(null);
        setTitle("Cargar Paciente");
        this.setBounds(250, 100, 300, 300);
        cargar.addActionListener(this);
        buscar.addActionListener(this);

        //Añadiendo items al contenedor
        contenedor.add(buscarTexto);
        contenedor.add(buscarCampo);
        contenedor.add(buscar);
        contenedor.add(resultado);
        contenedor.add(cargar);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String Accion = e.getActionCommand();

        if ("Cargar".equals(Accion)) {
            BDMySQL ECG = new BDMySQL();
            ECG.MySQLConnection("root", "root", "ECGPlotter");
         //valores = ECG.getValues("usuarios");

            ECG.closeConnection();
        }

        if ("Buscar".equals(Accion)) {
            BDMySQL ECG = new BDMySQL();
            ECG.MySQLConnection("root", "root", "ECGPlotter");
            valores = ECG.getValues("usuarios", "Norman");
            resultado.setText(valores[1] + " " + valores[2]);
            ECG.closeConnection();
        }

    }

    public String[] obtenerPaciente() {
        return valores;

    }

}
