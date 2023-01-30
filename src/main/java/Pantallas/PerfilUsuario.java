/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Pantallas;

import com.dao.ControlUsuario;
import com.modelo.usuario;
import db_conexion.cConexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Banos
 */
public class PerfilUsuario extends javax.swing.JFrame {
    private String ruDui;
    ControlUsuario controlUsu = new ControlUsuario();
    List<usuario> datos = new ArrayList<>();
    usuario usr = new usuario();
     
    private void CargarDatosUsuario(){
        String usDui = ruDui;
        datos = (List<usuario>) controlUsu.CargarFiltrar(usDui);
            Object[] obj = new Object[9];
            for (usuario fila : datos) {
                obj[0] = fila.getId_usuario();
                this.txtId.setText(Integer.toString(fila.getId_usuario()));
                obj[1] = fila.getUsNombre();
                this.txtNombre.setText(fila.getUsNombre());
                obj[2] = fila.getUsApellido();
                this.txtApellido.setText(fila.getUsApellido());
                obj[3] = fila.getUsDui();
                this.txtDui.setText(fila.getUsDui());
                obj[4] = fila.getUsPasswd();
                String contra = fila.getUsPasswd();
                this.txtPass.setText(contra);
                this.txtConfirmPass.setText(contra);
                obj[5] = fila.getUsCargo();
                this.txtCargo.setText(fila.getUsCargo());
                obj[6] = fila.getUsTelefono();
                this.txtTelefono.setText(fila.getUsTelefono());
                obj[7] = fila.getUsPregunta();
                this.txtPregunta.setText(fila.getUsPregunta());
                obj[8] = fila.getUsRespuesta();
                this.txtRespuesta.setText(fila.getUsRespuesta());
            }
    }
    
    private void txtBloqueados(){
        txtId.setEnabled(false);
        txtNombre.setEnabled(false);
        txtApellido.setEnabled(false);
        txtDui.setEnabled(false);
        txtPass.setEnabled(false);
        txtConfirmPass.setEnabled(false);
        txtCargo.setEnabled(false);
        txtTelefono.setEnabled(false);
        txtPregunta.setEnabled(false);
        txtRespuesta.setEnabled(false);
        txtTipo.setEnabled(false);
        btnActualizar.setVisible(false);
        btnEditar.setEnabled(true);
        cbxPass.setEnabled(false);
        cbxConfirmPass.setEnabled(false);
    }
    
    private void txtEditables(){
        //txtId..setEnabled(true);
        //txtTipo.setEnabled(true);
        txtNombre.setEnabled(true);
        txtApellido.setEnabled(true);
        txtDui.setEnabled(true);
        txtPass.setEnabled(true);
        txtConfirmPass.setEnabled(true);
        txtCargo.setEnabled(true);
        txtTelefono.setEnabled(true);
        txtPregunta.setEnabled(true);
        txtRespuesta.setEnabled(true);
        btnEditar.setEnabled(false);
        btnActualizar.setVisible(true);
        cbxPass.setEnabled(true);
        cbxConfirmPass.setEnabled(true);
    }
    
    private void lblInvisible(){
      lblID.setVisible(false);
      lblDuiDB.setVisible(false);
    }
    
    private void tipoUsuario(){
        cConexion con = new cConexion();
        String idTipo, tipoUS, usID, usDui;
        usID = txtId.getText();
        usDui = lblDuiDB.getText();
        String sql = "SELECT tipo_usuario.tuNombre, usuario.id_tipoUsuario FROM tipo_usuario LEFT JOIN usuario ON usuario.id_tipoUsuario = tipo_usuario.id_tipoUsuario WHERE usuario.id_usuario = '"+usID+"' AND usuario.usDui = '"+usDui+"'";
        PreparedStatement ps;
        ResultSet res;
        try {
            ps = con.conexion().prepareStatement(sql);
            res = ps.executeQuery();
            if(res.next()){
                tipoUS = res.getString("tuNombre");
                txtTipo.setText(tipoUS);
                //System.out.println(tipoUS);
                idTipo = res.getString("id_tipoUsuario");
                lblID.setText(idTipo);
            }else{
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error", "Error", JOptionPane.ERROR_MESSAGE);
            }
            //ps.close();
            //res.close();
            con.conexion().close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error: "+e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }  
    }
    
    /**
     * Creates new form PerfilUsuario
     */
    public PerfilUsuario() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/images/banana.png")).getImage());
        lblInvisible();
        txtBloqueados();
        //tipoUsuario();
        //CargarDatosUsuario();
    }
    
    public void obtenerDuiRU(String Dui){
        this.ruDui = Dui;
        lblDuiDB.setText(ruDui);
        CargarDatosUsuario();
        tipoUsuario();
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
        jSeparator1 = new javax.swing.JSeparator();
        lblNombre = new javax.swing.JLabel();
        lblDui = new javax.swing.JLabel();
        lblPass = new javax.swing.JLabel();
        lblCargo = new javax.swing.JLabel();
        btnEditar = new javax.swing.JButton();
        lblRespuesta = new javax.swing.JLabel();
        lblPregunta = new javax.swing.JLabel();
        lblApellido = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        txtDui = new javax.swing.JTextField();
        txtCargo = new javax.swing.JTextField();
        txtPregunta = new javax.swing.JTextField();
        txtRespuesta = new javax.swing.JTextField();
        btnActualizar = new javax.swing.JButton();
        txtTelefono = new javax.swing.JTextField();
        lblTelefono = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        lblConfirmPass = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtId = new javax.swing.JTextPane();
        txtPass = new javax.swing.JPasswordField();
        txtConfirmPass = new javax.swing.JPasswordField();
        lblTipo = new javax.swing.JLabel();
        txtTipo = new javax.swing.JTextField();
        lblID = new javax.swing.JLabel();
        lblDuiDB = new javax.swing.JLabel();
        cbxPass = new javax.swing.JCheckBox();
        cbxConfirmPass = new javax.swing.JCheckBox();
        btnPanel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Perfil del usuario");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));

        lblNombre.setText("Nombre:");

        lblDui.setText("DUI:");

        lblPass.setText("Contraseña:");

        lblCargo.setText("Cargo:");

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/editar.png"))); // NOI18N
        btnEditar.setText("Editar ");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        lblRespuesta.setText("Respuesta:");

        lblPregunta.setText("Pregunta:");

        lblApellido.setText("Apellido:");

        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        txtApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidoKeyTyped(evt);
            }
        });

        txtDui.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDuiKeyTyped(evt);
            }
        });

        txtCargo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCargoKeyTyped(evt);
            }
        });

        txtPregunta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPreguntaKeyTyped(evt);
            }
        });

        txtRespuesta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRespuestaKeyTyped(evt);
            }
        });

        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/save.png"))); // NOI18N
        btnActualizar.setText("Guardar cambios");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });

        lblTelefono.setText("Telefono:");

        lblId.setText("ID:");

        lblConfirmPass.setText("Confirmar contraseña:");

        txtId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIdKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(txtId);

        txtPass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPassKeyTyped(evt);
            }
        });

        txtConfirmPass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtConfirmPassKeyTyped(evt);
            }
        });

        lblTipo.setText("Tipo de usuario:");

        lblID.setText("ID");

        lblDuiDB.setText("DUI");

        cbxPass.setText("Mostrar contraseña");
        cbxPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxPassActionPerformed(evt);
            }
        });

        cbxConfirmPass.setText("Mostrar contraseña");
        cbxConfirmPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxConfirmPassActionPerformed(evt);
            }
        });

        btnPanel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/panel.png"))); // NOI18N
        btnPanel.setText("Regresar al panel de control");
        btnPanel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPanelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 626, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(lblTelefono)
                                    .addComponent(lblPregunta)
                                    .addComponent(lblRespuesta)
                                    .addComponent(lblTipo)
                                    .addComponent(lblDuiDB, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtTelefono)
                                        .addComponent(txtPregunta, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtRespuesta, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(btnActualizar)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnEditar))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblPass)
                                    .addComponent(lblDui)
                                    .addComponent(lblApellido)
                                    .addComponent(lblNombre)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lblID)
                                        .addGap(18, 18, 18)
                                        .addComponent(lblId))
                                    .addComponent(lblCargo)
                                    .addComponent(lblConfirmPass))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
                                        .addComponent(txtApellido, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtDui, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtPass, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addComponent(txtCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtConfirmPass, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbxPass)
                                    .addComponent(cbxConfirmPass))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(btnPanel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblId)
                            .addComponent(lblID)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblApellido)
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDui)
                    .addComponent(txtDui, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPass)
                    .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxPass)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtConfirmPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblConfirmPass))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxConfirmPass)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCargo))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTelefono)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPregunta)
                    .addComponent(txtPregunta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRespuesta)
                    .addComponent(txtRespuesta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTipo)
                    .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnActualizar)
                    .addComponent(btnEditar)
                    .addComponent(lblDuiDB))
                .addGap(31, 31, 31)
                .addComponent(btnPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
        String pass = new String(txtPass.getPassword());
        String passCon = new String(txtConfirmPass.getPassword());
        
        if (txtId.getText().equals("") || txtNombre.getText().equals("") || txtApellido.getText().equals("") || txtDui.getText().equals("") || pass.equals("") || passCon.equals("") 
                || txtCargo.getText().equals("") || txtTelefono.getText().equals("") || txtPregunta.getText().equals("") || txtRespuesta.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Existen elementos vacios, debe ingresar todos lo datos solicitados", "Datos vacios", JOptionPane.ERROR_MESSAGE);
        } 
        else if(txtNombre.getText().length()<3 || txtApellido.getText().length()<4){
            JOptionPane.showMessageDialog(null, "Ingresar Nombre y/o Apellido con mas caracteres de los actuales", "Datos incompletos", JOptionPane.WARNING_MESSAGE);
        } 
        else if(txtDui.getText().length()<9){
            JOptionPane.showMessageDialog(null, "El campo DUI debe tener un total de 9 caracteres", "Numero de DUI incompleto", JOptionPane.WARNING_MESSAGE);
        }else{
            if (pass.length() >= 10){
                if (pass.equals(passCon)) {
                usr.setUsPasswd(pass);
                usr.setUsNombre(txtNombre.getText());
                usr.setUsApellido(txtApellido.getText());
                usr.setUsDui(txtDui.getText());
                usr.setUsCargo(txtCargo.getText());
                usr.setUsTelefono(txtTelefono.getText());
                usr.setUsPregunta(txtPregunta.getText());
                usr.setUsRespuesta(txtRespuesta.getText());
                usr.setId_tipoUsuario(Integer.parseInt(lblID.getText()));
                usr.setId_usuario(Integer.parseInt(txtId.getText()));
                if (controlUsu.modificarInfoUsuario(usr)) {
                    JOptionPane.showMessageDialog(null, "Su perfil ha sido actualizado, puede iniciar sesion nuevamente para validar los cambios", "Perfil actualizado, inicie sesion nuevamente", JOptionPane.INFORMATION_MESSAGE);
                    CargarDatosUsuario();
                    txtBloqueados();
                    
                    int type_user = Integer.parseInt(lblID.getText());
                    String usNombre = txtNombre.getText();
                    String usApellido = txtApellido.getText();
                    String usDui = txtDui.getText();
                    String usCargo = txtCargo.getText();
                    int usId = Integer.parseInt(txtId.getText());
                    if(type_user == 1){
                        MenuAdmin newForm = new MenuAdmin();
                        newForm.obtenerDatos(type_user, usNombre, usApellido, usDui, usCargo, usId);
                        newForm.setLocationRelativeTo(null);
                        newForm.setVisible(true);
                        this.dispose();
                    }else{
                        Menu newForm = new Menu();
                        newForm.obtenerDatos(type_user, usNombre, usApellido, usDui, usCargo, usId);
                        newForm.setLocationRelativeTo(null);
                        newForm.setVisible(true);
                        this.dispose();
                    }
                    
                    /*InicioSesion newForm = new InicioSesion();
                    newForm.setVisible(true);
                    newForm.setLocationRelativeTo(null);
                    this.dispose();*/
                }else{
                    JOptionPane.showMessageDialog(null, "Se ha producido un error al actulizar el perfil, revise la informacion", "Actualizacion de perfil invalida", JOptionPane.ERROR_MESSAGE);
                }
            }else{
                    JOptionPane.showMessageDialog(null, "Las contraseñas no son iguales, verifique que este escribiendo ambas contraseñas correctamente", "Contraseñas diferentes", JOptionPane.ERROR_MESSAGE);
                }
            }else{
                JOptionPane.showMessageDialog(null, "La contraseña debe de ser mayor a 9 caracteres","Contraseña incompleta", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
        txtEditables();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        // TODO add your handling code here:
        char vNombre = evt.getKeyChar();
        boolean asciiBS = vNombre == 8;
        boolean asciiSP = vNombre == 32;
        boolean asciiSH = vNombre == 16;
        int cNombre = txtNombre.getText().length(); 
        
        if(!Character.isLetter(vNombre) && !asciiBS && !asciiSP && !asciiSH){
            //getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Este campo solo permite ingresar letras, Segun el formato de cada Nombre", "Formato de dato invalido", JOptionPane.INFORMATION_MESSAGE);
        }
        
        if(cNombre >= 15){
            evt.consume();
        }
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtApellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidoKeyTyped
        // TODO add your handling code here:
        char vApellido = evt.getKeyChar();
        boolean asciiBS = vApellido == 8;
        boolean asciiSP = vApellido == 32;
        boolean asciiSH = vApellido == 16;
        int cApellido = txtApellido.getText().length(); 
        
        if(!Character.isLetter(vApellido) && !asciiBS && !asciiSP && !asciiSH){
            //getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Este campo solo permite ingresar letras, Segun el formato de cada Apellido", "Formato de dato invalido", JOptionPane.INFORMATION_MESSAGE);
        }
        
        if(cApellido >= 15){
            evt.consume();
        }
    }//GEN-LAST:event_txtApellidoKeyTyped

    private void txtDuiKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDuiKeyTyped
        // TODO add your handling code here:
        char vDui = evt.getKeyChar();
        boolean asciiBS = vDui == 8;
        int cDui = txtDui.getText().length(); 
        
        if(!Character.isDigit(vDui) && !asciiBS){
            //getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Este campo solo permite ingresar numeros, segun el formato del numero de DUI", "Formato de dato invalido", JOptionPane.INFORMATION_MESSAGE);
        }
        
        if(cDui >= 9){
            evt.consume();
        }
    }//GEN-LAST:event_txtDuiKeyTyped

    private void txtCargoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCargoKeyTyped
        // TODO add your handling code here:
        char vCargo = evt.getKeyChar();
        boolean asciiBS = vCargo == 8;
        boolean asciiSP = vCargo == 32;
        boolean asciiSH = vCargo == 16;
        int cCargo = txtCargo.getText().length(); 
        
        if(!Character.isLetter(vCargo) && !asciiBS && !asciiSP && !asciiSH){
            //getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Segun el formato, este campo solo permite ingresar letras", "Formato de dato invalido", JOptionPane.INFORMATION_MESSAGE);
        }
        
        if(cCargo >= 12){
            evt.consume();
        }
    }//GEN-LAST:event_txtCargoKeyTyped

    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
        // TODO add your handling code here:
        char vTel = evt.getKeyChar();
        boolean asciiBS = vTel == 8;
        boolean asciiDS = vTel == 45;
        int cTel = txtTelefono.getText().length(); 
        
        if(!Character.isDigit(vTel) && !asciiBS && !asciiDS){
            //getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Segun el formato, este campo solo permite ingresar numeros", "Formato de dato invalido", JOptionPane.INFORMATION_MESSAGE);
        }
        
        if(cTel >= 9){
            evt.consume();
        }
    }//GEN-LAST:event_txtTelefonoKeyTyped

    private void txtPreguntaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPreguntaKeyTyped
        // TODO add your handling code here:
        char vPregunta = evt.getKeyChar();
        boolean asciiBS = vPregunta == 8;
        boolean asciiSH = vPregunta == 16;
        boolean asciiSP = vPregunta == 32;
        int cPregunta = txtPregunta.getText().length(); 
        
        if(!Character.isLetter(vPregunta) && !asciiBS && !asciiSH && !asciiSP){
            //getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Segun el formato, para la Pregunta solo se permite ingresar letras", "Formato de dato invalido", JOptionPane.INFORMATION_MESSAGE);
        }
        
        if(cPregunta >= 90){
            evt.consume();
        }
    }//GEN-LAST:event_txtPreguntaKeyTyped

    private void txtRespuestaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRespuestaKeyTyped
        // TODO add your handling code here:
        int cRespuesta = txtRespuesta.getText().length(); 
        
        if(cRespuesta >= 10){
            evt.consume();
        }
    }//GEN-LAST:event_txtRespuestaKeyTyped

    private void txtIdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdKeyTyped
        // TODO add your handling code here:
        char vId = evt.getKeyChar();
        boolean asciiBS = vId == 8;
        int cId = txtId.getText().length(); 
        
        if(!Character.isDigit(vId) && !asciiBS){
            //getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Segun el formato, este campo solo permite ingresar numeros", "Formato de dato invalido", JOptionPane.INFORMATION_MESSAGE);
        }
        
        if(cId >= 2){
            evt.consume();
        }
    }//GEN-LAST:event_txtIdKeyTyped

    private void txtPassKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPassKeyTyped
        // TODO add your handling code here:
        int cPass = String.valueOf(txtPass.getPassword()).length();
        
        if(cPass >= 12){
            evt.consume();
        }
    }//GEN-LAST:event_txtPassKeyTyped

    private void txtConfirmPassKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtConfirmPassKeyTyped
        // TODO add your handling code here:
        int cPasswd = String.valueOf(txtConfirmPass.getPassword()).length();
        
        if(cPasswd >= 12){
            evt.consume();
        }
    }//GEN-LAST:event_txtConfirmPassKeyTyped

    private void cbxPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxPassActionPerformed
        // TODO add your handling code here:
        if(cbxPass.isSelected()){
            txtPass.setEchoChar((char)0);
        }else{
            txtPass.setEchoChar('*');
        }
    }//GEN-LAST:event_cbxPassActionPerformed

    private void cbxConfirmPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxConfirmPassActionPerformed
        // TODO add your handling code here:
        if(cbxConfirmPass.isSelected()){
            txtConfirmPass.setEchoChar((char)0);
        }else{
            txtConfirmPass.setEchoChar('*');
        }
    }//GEN-LAST:event_cbxConfirmPassActionPerformed

    private void btnPanelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPanelActionPerformed
        // TODO add your handling code here:
        int type_user = Integer.parseInt(lblID.getText());
        String usNombre = txtNombre.getText();
        String usApellido = txtApellido.getText();
        String usDui = txtDui.getText();
        String usCargo = txtCargo.getText();
        int usId = Integer.parseInt(txtId.getText());
        if(type_user == 1){
            MenuAdmin newForm = new MenuAdmin();
            newForm.obtenerDatos(type_user, usNombre, usApellido, usDui, usCargo, usId);
            newForm.setLocationRelativeTo(null);
            newForm.setVisible(true);
            this.dispose();
        }else{
            Menu newForm = new Menu();
            newForm.obtenerDatos(type_user, usNombre, usApellido, usDui, usCargo, usId);
            newForm.setLocationRelativeTo(null);
            newForm.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnPanelActionPerformed

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
            java.util.logging.Logger.getLogger(PerfilUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PerfilUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PerfilUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PerfilUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PerfilUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnPanel;
    private javax.swing.JCheckBox cbxConfirmPass;
    private javax.swing.JCheckBox cbxPass;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblApellido;
    private javax.swing.JLabel lblCargo;
    private javax.swing.JLabel lblConfirmPass;
    private javax.swing.JLabel lblDui;
    private javax.swing.JLabel lblDuiDB;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPass;
    private javax.swing.JLabel lblPregunta;
    private javax.swing.JLabel lblRespuesta;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCargo;
    private javax.swing.JPasswordField txtConfirmPass;
    private javax.swing.JTextField txtDui;
    private javax.swing.JTextPane txtId;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtPregunta;
    private javax.swing.JTextField txtRespuesta;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtTipo;
    // End of variables declaration//GEN-END:variables
}
