/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ECGPlotter;

/**
 *
 * @author Norman
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
 
public class BDMySQL {
 
    private static Connection Conexion;
    private String pass = "root" ,user = "root";
    private String BD = "ECGPlotter";
    public void MySQLConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + BD, user, pass);
            System.out.println("Se ha iniciado la conexión con el servidor de forma exitosa");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BDMySQL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(BDMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
    public void closeConnection() {
        try {
            Conexion.close();
            System.out.println("Se ha finalizado la conexión con el servidor");
        } catch (Exception ex) {
            Logger.getLogger(BDMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
    public void CrearBD(String nombre) {
        try {
            String Query = "CREATE DATABASE " + nombre;
            Statement st = Conexion.createStatement();
            st.executeUpdate(Query);
            MySQLConnection();
            System.out.println("Se ha creado la base de datos " + nombre + " de forma exitosa");
        } catch (Exception ex) {
            Logger.getLogger(BDMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
    public void CrearTablaUsuarios(String nombre) {
        try {
            String Query = "CREATE TABLE IF NOT EXISTS " + nombre + ""
                    + "(user_id int NOT NULL AUTO_INCREMENT,Nombre VARCHAR(50), Apellido VARCHAR(50),"
                    + " profesion VARCHAR(300), correo VARCHAR(300),contraseña VARCHAR(100),"
                    + " PRIMARY KEY (user_id))";
            System.out.println("Se ha creado la base de tabla " + nombre + " de forma exitosa");
            Statement st = Conexion.createStatement();
            st.executeUpdate(Query);
        } catch (Exception ex) {
            Logger.getLogger(BDMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void CrearTablaCitas(String nombre) {
        try {
            String Query = "CREATE TABLE IF NOT EXISTS  " + nombre + ""
                    + "(cita_id int NOT NULL AUTO_INCREMENT,Tipo VARCHAR(50), Fecha VARCHAR(100),"
                    + " Hora VARCHAR(100), Lugar VARCHAR(100),user_id int, paciente_id int"
                    + ",observaciones_cita VARCHAR(200),estado_cita VARCHAR(100),PRIMARY KEY (cita_id))";
            System.out.println("Se ha creado la base de tabla " + nombre + " de forma exitosa");
            Statement st = Conexion.createStatement();
            st.executeUpdate(Query);
        } catch (Exception ex) {
            Logger.getLogger(BDMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void CrearTablaPacientes(String nombre) {
        try {
            String Query = "CREATE TABLE IF NOT EXISTS  " + nombre + ""
                    + "(paciente_id int NOT NULL AUTO_INCREMENT,Nombre VARCHAR(50), Apellido VARCHAR(50),"
                    + " registro_ecg VARCHAR(300), observaciones VARCHAR(300),cedula int,correo VARCHAR(200)"
                    + ",direccion VARCHAR(100),telefono int, sexo VARCHAR(1),antecedentes VARCHAR(500),proxima_cita VARCHAR(100), ultima_cita VARCHAR(100),PRIMARY KEY (paciente_id))";
            System.out.println("Se ha creado la base de tabla " + nombre + " de forma exitosa");
            Statement st = Conexion.createStatement();
            st.executeUpdate(Query);
        } catch (Exception ex) {
            Logger.getLogger(BDMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
    public void InsertarDatos(String nombre_tabla, String _id, String nombre, String apellido, String registro_ecg, String observaciones, int cedula, String correo, String direccion, int  telefono, String sexo, String antecedentes, String proxima_cita, String ultima_cita) {
        try {
            String Query = "INSERT INTO " + nombre_tabla + "(nombre,apellido,registro_ecg,observaciones,cedula,correo,direccion,telefono,sexo,antecedentes,proxima_cita,ultima_cita) VALUES("
                    // + "\"" + _id + "\", "
                    + "\"" + nombre + "\", "
                    + "\"" + apellido + "\", "
                    + "\"" + registro_ecg + "\", "
                    + "\"" + observaciones + "\", "
                    + "\"" + cedula + "\", "
                    + "\"" + correo + "\", "
                    + "\"" + direccion + "\", "
                    + "\"" + telefono + "\", "
                    + "\"" + sexo + "\", "
                    + "\"" + antecedentes + "\", "
                    + "\"" + proxima_cita + "\", "
                    + "\"" + ultima_cita + "\")";
            Statement st = Conexion.createStatement();
            st.executeUpdate(Query);
            System.out.println("Datos almacenados de forma exitosa");
        } catch (Exception ex) {
            System.out.println("Error en el almacenamiento de datos");
        }
    }
 
    public void GuardarCitas(String nombre_tabla, String Tipo, String Fecha, String Hora, String Lugar, int user_id, int paciente_id, String observaciones_cita,String estado_cita){
    try {
            String Query = "INSERT INTO " + nombre_tabla + "(Tipo,Fecha,Hora,Lugar ,user_id,paciente_id,observaciones_cita,estado_cita) VALUES("
                    // + "\"" + _id + "\", "
                    + "\"" + Tipo + "\", "
                    + "\"" + Fecha + "\", "
                    + "\"" + Hora + "\", "
                    + "\"" + Lugar + "\", "
                    + "\"" + user_id + "\", "
                    + "\"" + paciente_id + "\", "
                    + "\"" + observaciones_cita + "\", "
                    + "\"" + estado_cita + "\")";
            Statement st = Conexion.createStatement();
            st.executeUpdate(Query);
            Query = "UPDATE pacientes SET proxima_cita = '" + Fecha + "' WHERE paciente id = '" + paciente_id + "'";
            st.executeUpdate(Query);
            System.out.println("Datos almacenados de forma exitosa");
        } catch (Exception ex) {
            System.out.println("Error en el almacenamiento de datos");
        }
    
    }
    
    public String[] Login(String nombre_tabla, String correo, String password){
        String[] valores = new String[5]; 
        try {
            String Query = "SELECT * FROM " + nombre_tabla + " WHERE correo = \"" + correo + "\" AND contraseña = \"" + password + "\"";
            
            Statement st = Conexion.createStatement();
            java.sql.ResultSet resultSet;
            resultSet = st.executeQuery(Query);
            while (resultSet.next()) {
               valores[0] = "" + resultSet.getString("user_id");
               valores[1] = resultSet.getString("Nombre");
               valores[2] = resultSet.getString("Apellido");
               valores[3] = resultSet.getString("profesion");
               valores[4] = resultSet.getString("correo");
   
            }
            
            
 
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error en la adquisición de datos" +ex);
        }
        
        return valores;
    }
    public String[] ObtenerPacientePorCedula(String nombre_tabla, int cedula) {
       String[] valores = new String[13]; 
        try {
            String Query = "SELECT * FROM " + nombre_tabla + " WHERE cedula = \"" + cedula + "\"";
            Statement st = Conexion.createStatement();
            java.sql.ResultSet resultSet;
            resultSet = st.executeQuery(Query);
            
            while (resultSet.next()) {
               valores[0] = "" + resultSet.getString("paciente_id");
               valores[1] = resultSet.getString("nombre");
               valores[2] = resultSet.getString("apellido");
               valores[3] = resultSet.getString("registro_ecg");
               valores[4] = resultSet.getString("observaciones");
               valores[5] = resultSet.getString("cedula");
               valores[6] = resultSet.getString("correo");
               valores[7] = resultSet.getString("direccion");
               valores[8] = resultSet.getString("telefono");
               valores[9] = resultSet.getString("sexo");
               valores[10] = resultSet.getString("antecedentes");
               valores[11] = resultSet.getString("proxima_cita");
               valores[12] = resultSet.getString("ultima_cita");
   
            }
            
            
 
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error en la adquisición de datos" +ex);
        }
        
        return valores;
    }

    public DefaultTableModel ObtenerCitasPorPaciente(int paciente_id, JTable jtable1) {
       String[] valores = new String[7];
       ArrayList lista = new ArrayList();
       DefaultTableModel modelo = (DefaultTableModel) jtable1.getModel();
        try {
            String Query = "SELECT cita_id,Tipo,Fecha,Hora,Lugar,observaciones_cita,estado_cita FROM " + "citas" + " WHERE paciente_id = \"" + paciente_id + "\"";
            Statement st = Conexion.createStatement();
            java.sql.ResultSet resultSet;
            resultSet = st.executeQuery(Query);
            
            while (resultSet.next()) {
               Object [] fila = new Object[7];
               for (int i=0;i<7;i++) fila[i] = resultSet.getObject(i+1);
               System.out.println(fila[6]);
               modelo.addRow(fila);
  
            }
            
            
 
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error en la adquisición de datos" +ex);
        }
        return modelo;
    }

    public Vector ListarUsuarios() {
       Vector valores = new Vector();
       
       String nombre_tabla = "usuarios";
        try {
            String Query = "SELECT * FROM " + nombre_tabla;
            Statement st = Conexion.createStatement();
            java.sql.ResultSet resultSet;
            resultSet = st.executeQuery(Query);
            
            while (resultSet.next()) {
               
                valores.addElement(resultSet.getString("_id") + "-" + resultSet.getString("nombre") + "-" + resultSet.getString("apellido"));
   
            }
            
            
 
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error en la adquisición de datos" +ex);
        }
        
        return valores;
    }
 
    public void deleteRecord(String table_name, String ID) {
        try {
            String Query = "DELETE FROM " + table_name + " WHERE ID = \"" + ID + "\"";
            Statement st = Conexion.createStatement();
            st.executeUpdate(Query);
 
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, "Error borrando el registro especificado");
        }
    }
 
}