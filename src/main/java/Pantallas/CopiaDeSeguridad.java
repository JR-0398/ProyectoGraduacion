/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Pantallas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Banos
 */
public class CopiaDeSeguridad extends javax.swing.JFrame {
    JFileChooser RealizarBackUp = new JFileChooser();
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
    
    private void bloquearDatos(){
        txtRutaBU.setEnabled(false);
        btnCrearBU.setEnabled(false);
        //btnCancelarBU.setEnabled(false);  
    }
    
    private void cambioDatos(){
        txtRutaBU.setEnabled(true);
        txtRutaBU.setEditable(false);
        btnCrearBU.setEnabled(true);
        btnCancelarBU.setEnabled(true);   
    }

    /**
     * Creates new form CopiaDeSeguridad
     */
    public CopiaDeSeguridad() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/images/banana.png")).getImage());
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
        txtRutaBU = new javax.swing.JTextField();
        btnRutaUP = new javax.swing.JButton();
        btnCrearBU = new javax.swing.JButton();
        btnCancelarBU = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Crear copia de seguridad");
        setResizable(false);

        lblRuta.setText("Ruta para guardar la copia de seguridad");

        btnRutaUP.setText("Seleccionar");
        btnRutaUP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRutaUPActionPerformed(evt);
            }
        });

        btnCrearBU.setText("Crear copia de seguridad");
        btnCrearBU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearBUActionPerformed(evt);
            }
        });

        btnCancelarBU.setText("Cancelar");
        btnCancelarBU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarBUActionPerformed(evt);
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
                    .addComponent(txtRutaBU, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCrearBU))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCancelarBU, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRutaUP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRuta)
                    .addComponent(txtRutaBU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRutaUP))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCrearBU)
                    .addComponent(btnCancelarBU))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRutaUPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRutaUPActionPerformed
        // TODO add your handling code here:
        int resp;
        resp = RealizarBackUp.showSaveDialog(this);
        if(resp == JFileChooser.APPROVE_OPTION){
            txtRutaBU.setText(RealizarBackUp.getSelectedFile().getAbsolutePath());
            //JOptionPane.showMessageDialog(null, "Se ha seleccionado la ruta donde se almacenara la copia de seguridad", "Ruta de la copia de seguridad", JOptionPane.INFORMATION_MESSAGE);
            cambioDatos();
        }else if(resp == JFileChooser.CANCEL_OPTION){
            JOptionPane.showMessageDialog(null, "La ruta donde se almacenara la copia de seguridad no ha sido seleccionada", "Ruta de la copia de seguridad cancelada", JOptionPane.ERROR_MESSAGE);
        }     
    }//GEN-LAST:event_btnRutaUPActionPerformed

    private void btnCrearBUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearBUActionPerformed
        // TODO add your handling code here:
        String dbNombre = "db_inventario";
        String dbUsuario = "root";
        String dbPass = "admin";
        String rutaMySql = "C:\\Program Files\\MySQL\\MySQL Workbench 8.0\\mysqldump.exe";
        String fecha = df.format(new Date().getTime());
        try{
            Runtime runtime = Runtime.getRuntime();
            File backupFile = new File(String.valueOf(RealizarBackUp.getSelectedFile().toString())+"_"+fecha+".sql");
            FileWriter fw = new FileWriter(backupFile);
            Process child = runtime.exec(rutaMySql+" --password="+dbPass+" --user="+dbUsuario+ " --databases "+dbNombre); 
            InputStreamReader irs = new InputStreamReader(child.getInputStream());
            BufferedReader br = new BufferedReader(irs);
            String line;
            while( (line=br.readLine()) != null ) {
                fw.write(line + "\n");
            }
            fw.close();
            irs.close();
            br.close();
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, "Error no se genero el archivo por el siguiente motivo: "+e.getMessage(), "Error",JOptionPane.ERROR_MESSAGE);
        }
        JOptionPane.showMessageDialog(null, "Se ha generado la copia de seguridad, verifique el archivo en la carpeta de la ruta seleccionada","Copia de seguridad generada",JOptionPane.INFORMATION_MESSAGE);
        bloquearDatos();
        txtRutaBU.setText("");
    }//GEN-LAST:event_btnCrearBUActionPerformed

    private void btnCancelarBUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarBUActionPerformed
        // TODO add your handling code here:
        MenuDB newForm = new MenuDB();
        newForm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCancelarBUActionPerformed

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
            java.util.logging.Logger.getLogger(CopiaDeSeguridad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CopiaDeSeguridad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CopiaDeSeguridad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CopiaDeSeguridad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CopiaDeSeguridad().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelarBU;
    private javax.swing.JButton btnCrearBU;
    private javax.swing.JButton btnRutaUP;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblRuta;
    private javax.swing.JTextField txtRutaBU;
    // End of variables declaration//GEN-END:variables
}
