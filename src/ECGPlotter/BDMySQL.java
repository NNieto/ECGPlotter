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
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
 
public class BDMySQL {
 
    private static Connection Conexion;
 
    public void MySQLConnection(String user, String pass, String db_name) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + db_name, user, pass);
            System.out.println("Se ha iniciado la conexión con el servidor de forma exitosa");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BDMySQL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BDMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
    public void closeConnection() {
        try {
            Conexion.close();
            System.out.println("Se ha finalizado la conexión con el servidor");
        } catch (SQLException ex) {
            Logger.getLogger(BDMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
    public void CrearBD(String nombre) {
        try {
            String Query = "CREATE DATABASE " + nombre;
            Statement st = Conexion.createStatement();
            st.executeUpdate(Query);
            MySQLConnection("root", "", nombre);
            System.out.println("Se ha creado la base de datos " + nombre + " de forma exitosa");
        } catch (SQLException ex) {
            Logger.getLogger(BDMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
    public void CrearTabla(String nombre) {
        try {
            String Query = "CREATE TABLE " + nombre + ""
                    + "(user_id int NOT NULL AUTO_INCREMENT,Nombre VARCHAR(50), Apellido VARCHAR(50),"
                    + " registro_ecg VARCHAR(300), observaciones VARCHAR(300),cedula int,correo VARCHAR(100)"
                    + ",direccion VARCHAR(100),telefono int, sexo VARCHAR(1),antecedentes VARCHAR(500),PRIMARY KEY (user_id))";
            System.out.println("Se ha creado la base de tabla " + nombre + " de forma exitosa");
            Statement st = Conexion.createStatement();
            st.executeUpdate(Query);
        } catch (SQLException ex) {
            Logger.getLogger(BDMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
    public void InsertarDatos(String nombre_tabla, String _id, String nombre, String apellido, String registro_ecg, String observaciones, int cedula, String correo, String direccion, int  telefono, String sexo, String antecedentes) {
        try {
            String Query = "INSERT INTO " + nombre_tabla + "(nombre,apellido,registro_ecg,observaciones,cedula,correo,direccion,telefono,sexo,antecedentes) VALUES("
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
                    + "\"" + antecedentes + "\")";
            Statement st = Conexion.createStatement();
            st.executeUpdate(Query);
            System.out.println("Datos almacenados de forma exitosa");
        } catch (SQLException ex) {
            System.out.println("Error en el almacenamiento de datos");
        }
    }
 
    public String[] ObtenerValores(String nombre_tabla, int cedula) {
       String[] valores = new String[12]; 
        try {
            String Query = "SELECT * FROM " + nombre_tabla + " WHERE cedula = \"" + cedula + "\"";
            Statement st = Conexion.createStatement();
            java.sql.ResultSet resultSet;
            resultSet = st.executeQuery(Query);
            
            while (resultSet.next()) {
               valores[0] = "" + resultSet.getString("user_id");
               valores[1] = resultSet.getString("nombre");
               valores[2] = resultSet.getString("apellido");
               valores[3] = resultSet.getString("registro_ecg");
               valores[4] = resultSet.getString("observaciones");
               valores[5] = resultSet.getString("cedula");
               valores[6] = resultSet.getString("correo");
               valores[7] = resultSet.getString("direccion");
               valores[8] = resultSet.getString("telefono");
               valores[9] = resultSet.getString("sexo");
               valores[11] = resultSet.getString("antecedentes");
   
            }
            
            
 
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la adquisición de datos" +ex);
        }
        
        return valores;
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
            
            
 
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la adquisición de datos" +ex);
        }
        
        return valores;
    }
 
    public void deleteRecord(String table_name, String ID) {
        try {
            String Query = "DELETE FROM " + table_name + " WHERE ID = \"" + ID + "\"";
            Statement st = Conexion.createStatement();
            st.executeUpdate(Query);
 
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, "Error borrando el registro especificado");
        }
    }
 
}