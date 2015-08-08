/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ECGPlotter;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Alejandro
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("logo.png"));
        
        setIconImage(icon);
        ImageIcon icono = new javax.swing.ImageIcon(getClass().getResource("LogoAplicacionT.png"));
        Image imagen = icono.getImage();
        ImageIcon iconoEscalado = new ImageIcon (imagen.getScaledInstance(240,80,Image.SCALE_SMOOTH));
        LogoApp.setIcon(iconoEscalado);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        ContraseñaLoginField = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        IngresarLoginButton = new javax.swing.JButton();
        LogoApp = new javax.swing.JLabel();
        CorreoLoginField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Correo");

        ContraseñaLoginField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ContraseñaLoginField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ContraseñaLoginFieldKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Contraseña");

        IngresarLoginButton.setBackground(new java.awt.Color(25, 136, 25));
        IngresarLoginButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        IngresarLoginButton.setForeground(new java.awt.Color(238, 238, 238));
        IngresarLoginButton.setText("Ingresar");
        IngresarLoginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IngresarLoginButtonActionPerformed(evt);
            }
        });

        CorreoLoginField.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        CorreoLoginField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CorreoLoginFieldActionPerformed(evt);
            }
        });
        CorreoLoginField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CorreoLoginFieldKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ContraseñaLoginField, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LogoApp, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CorreoLoginField, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addComponent(IngresarLoginButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(jLabel3)))
                .addContainerGap(78, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(LogoApp, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CorreoLoginField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(8, 8, 8)
                .addComponent(ContraseñaLoginField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(IngresarLoginButton)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void IngresarLoginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IngresarLoginButtonActionPerformed
        // TODO add your handling code here:
        if (!"".equals(CorreoLoginField.getText()) && !"".equals(new String(ContraseñaLoginField.getPassword()))) {
            
            String logger[] = null;
            bd.MySQLConnection();
            logger = bd.Login("usuarios", CorreoLoginField.getText(), new String(ContraseñaLoginField.getPassword()));
            bd.closeConnection();
            if (logger[0] == null) {
                JOptionPane.showMessageDialog(this, "Correo o contraseña incorrecto");
            } else {
                dispose();
                ECGPlotter ecg = new ECGPlotter();
                ecg.setVisible(true);
                ecg.setActualUser(logger);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Llene todos los campos por favor");
        }
    }//GEN-LAST:event_IngresarLoginButtonActionPerformed

    private void ContraseñaLoginFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ContraseñaLoginFieldKeyTyped
        // TODO add your handling code here:
        if(evt.getKeyChar() == KeyEvent.VK_ENTER){
            IngresarLoginButton.doClick();
        }
        if(evt.getKeyChar() == KeyEvent.VK_TAB){
            IngresarLoginButton.requestFocus();
        }
    }//GEN-LAST:event_ContraseñaLoginFieldKeyTyped

    private void CorreoLoginFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CorreoLoginFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CorreoLoginFieldActionPerformed

    private void CorreoLoginFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CorreoLoginFieldKeyTyped
        // TODO add your handling code here:
        if(evt.getKeyChar() == KeyEvent.VK_ENTER){
            ContraseñaLoginField.requestFocus();
        }
        if(evt.getKeyChar() == KeyEvent.VK_TAB){
            ContraseñaLoginField.requestFocus();
        }
    }//GEN-LAST:event_CorreoLoginFieldKeyTyped

    public String getLogin() {
        return "IN";
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        
        new Login().setVisible(true);
    }
    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField ContraseñaLoginField;
    private javax.swing.JTextField CorreoLoginField;
    private javax.swing.JButton IngresarLoginButton;
    private javax.swing.JLabel LogoApp;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
    BDMySQL bd = new BDMySQL();
}
