/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Pantallas;

//import db_conexion.cConexion;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Banos
 */
public class RestaurarCopiaDeSeguridad extends javax.swing.JFrame {
    //JFileChooser RestaurarBackUp = new JFileChooser();
    
    private void bloquearDatos(){
        txtRutaRES.setEnabled(false);
        btnCrearRES.setEnabled(false);
        btnCancelarRES.setEnabled(false);  
    }
    
    private void cambioDatos(){
        txtRutaRES.setEnabled(true);
        txtRutaRES.setEditable(false);
        btnCrearRES.setEnabled(true);
        btnCancelarRES.setEnabled(true);   
    }
    
    private void borrarDB(){
        Connection con = null;
        String url = "jdbc:mysql://localhost:3306";
        String user = "root";
        String pass = "admin";
        String sql = "DROP DATABASE IF EXISTS db_inventario";
        try {
            con = DriverManager.getConnection(url,user,pass);
            Statement s = con.createStatement();
            s.execute(sql);
            s.execute(sql);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error: "+e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }  
    }
    
    private void crearDB(){
        Connection con = null;
        String url = "jdbc:mysql://localhost:3306";
        String user = "root";
        String pass = "admin";
        String sql = "CREATE DATABASE db_inventario";
        try {
            con = DriverManager.getConnection(url,user,pass);
            Statement s = con.createStatement();
            s.execute(sql);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error: "+e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }  
    }
    
    
    /**
     * Creates new form RestaurarCopiaDeSeguridad
     */
    public RestaurarCopiaDeSeguridad() {
        initComponents();
        bloquearDatos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblRuta = new javax.swing.JLabel();
        txtRutaRES = new javax.swing.JTextField();
        btnRutaRES = new javax.swing.JButton();
        btnCrearRES = new javax.swing.JButton();
        btnCancelarRES = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblRuta.setText("Ruta para restaurar la copia de seguridad");

        btnRutaRES.setText("Seleccionar");
        btnRutaRES.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRutaRESActionPerformed(evt);
            }
        });

        btnCrearRES.setText("Crear copia de seguridad");
        btnCrearRES.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearRESActionPerformed(evt);
            }
        });

        btnCancelarRES.setText("Cancelar");
        btnCancelarRES.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarRESActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lblRuta)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtRutaRES, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCrearRES))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCancelarRES, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRutaRES, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRuta)
                    .addComponent(txtRutaRES, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRutaRES))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCrearRES)
                    .addComponent(btnCancelarRES))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRutaRESActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRutaRESActionPerformed
        // TODO add your handling code here:
        JFileChooser ch = new JFileChooser();
        FileNameExtensionFilter fil = new FileNameExtensionFilter("Seleccione el archivo SQL (.sql)","sql");
        ch.setFileFilter(fil);
        int se = ch.showSaveDialog(null);
        if(se == JFileChooser.APPROVE_OPTION){
            txtRutaRES.setText(ch.getSelectedFile().getAbsolutePath());
            //JOptionPane.showMessageDialog(null, "", "", JOptionPane.INFORMATION_MESSAGE);
            cambioDatos();
        }else if(se == JFileChooser.CANCEL_OPTION){
            JOptionPane.showMessageDialog(null, "Se ha cancelado la seleccion del archivo para restaurar la copia de seguridad", "Restauracion de la copia de seguridad cancelada", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnRutaRESActionPerformed

    private void btnCrearRESActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearRESActionPerformed
        // TODO add your handling code here:
        String dbNombre = "db_inventario";
        String dbUsuario = "root";
        String dbPass = "admin";
        String rutaMySql = "C:\\Program Files\\MySQL\\MySQL Workbench 8.0\\mysql.exe";
        String ruta = txtRutaRES.getText();
        try{
            borrarDB();
            crearDB();
            Process backup = Runtime.getRuntime().exec(rutaMySql+" --user="+dbUsuario+" --password="+dbPass+" "+dbNombre);
            OutputStream os = backup.getOutputStream();
            FileInputStream fis = new FileInputStream(ruta);
            byte[] buffer = new byte[1000];
            int leido = fis.read(buffer);
            while (leido > 0) {
                os.write(buffer, 0, leido);
                leido = fis.read(buffer);
            }
            os.flush(); 
            os.close(); 
            fis.close();
           
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, "Error no se ha podido restaurar la copia de seguridad por el siguiente motivo: "+e.getMessage(), "Error",JOptionPane.ERROR_MESSAGE);
        }
        JOptionPane.showMessageDialog(null, "Se ha restaurado la copia de seguridad","Copia de seguridad restaurada",JOptionPane.INFORMATION_MESSAGE);
        bloquearDatos();
        txtRutaRES.setText("");     
    }//GEN-LAST:event_btnCrearRESActionPerformed

    private void btnCancelarRESActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarRESActionPerformed
        // TODO add your handling code here:
        MenuDB newForm = new MenuDB();
        newForm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCancelarRESActionPerformed

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
            java.util.logging.Logger.getLogger(RestaurarCopiaDeSeguridad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RestaurarCopiaDeSeguridad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RestaurarCopiaDeSeguridad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RestaurarCopiaDeSeguridad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RestaurarCopiaDeSeguridad().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelarRES;
    private javax.swing.JButton btnCrearRES;
    private javax.swing.JButton btnRutaRES;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblRuta;
    private javax.swing.JTextField txtRutaRES;
    // End of variables declaration//GEN-END:variables
}