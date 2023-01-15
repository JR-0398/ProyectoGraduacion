/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Pantallas;

import com.dao.ControlUsuario;
import com.modelo.tipoUsuario;
import com.modelo.usuario;
import db_conexion.cConexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author victor
 */
public class ListarUsuarios extends javax.swing.JFrame {

    private JButton btnCrearUsuNuevo;
    private JButton btnEditarInfoUsu;
   

    String[] columnas = {"ID", "NOMBRE", "APELLIDO", "DUI", "CARGO", "TELEFONO", "PREGUNTA", "RESPUESTA"};

    ControlUsuario controlUsu = new ControlUsuario();
    List<usuario> datos = new ArrayList<>();
    usuario usr = new usuario();

    DefaultTableModel model = new DefaultTableModel(columnas, 0) { //Para que las celdas no sean editables a traves del modelo
        public boolean isCellEditable(int filas, int columnas) {
            if (columnas == 8) {
                return true;
            } else {
                return false;
            }
        }
    };
    
    public void CargarBuscarDatos(){
    tableListUsuarios.getTableHeader().setReorderingAllowed(false);
    model.setRowCount(0);
    datos.clear();
    String frase = this.txtBuscar.getText();
    datos = (List<usuario>) controlUsu.CargarFiltrar(frase);
        Object[] obj = new Object[8];
        for (usuario fila : datos) {
            obj[0] = fila.getId_usuario();
            obj[1] = fila.getUsNombre();
            obj[2] = fila.getUsApellido();
            obj[3] = fila.getUsDui();
            obj[4] = fila.getUsCargo();
            obj[5] = fila.getUsTelefono();
            obj[6] = fila.getUsPregunta();
            obj[7] = fila.getUsRespuesta();
            model.addRow(obj);
        }
        tableListUsuarios.setModel(model);
    
    }

//    public void cargarTablaUsuarios() {
//        tableListUsuarios.getTableHeader().setReorderingAllowed(false);
//        model.setRowCount(0);
//        datos.clear();
//        datos = (List<usuario>) controlUsu.MostrarUsuarios();
//        Object[] obj = new Object[9];
//        for (usuario fila : datos) {
//            obj[0] = fila.getId_usuario();
//            obj[1] = fila.getNombre();
//            obj[2] = fila.getApellido();
//            obj[3] = fila.getDui();
//            obj[4] = fila.getuLogin();
//            obj[5] = fila.getPasswd();
//            obj[6] = fila.getTelefono();
//            obj[7] = fila.getDireccion();
//            obj[8] = fila.getCargo();
//            model.addRow(obj);
//        }
//        tableListUsuarios.setModel(model);
//
//    }

    public void limpiarCampos() {
        this.txtApellido.setText("");
        this.txtCargo.setText("");
        this.txtContra.setText("");
        this.txtRespuesta.setText("");
        this.txtDui.setText("");
        this.txtNombre.setText("");
        this.txtTelefono.setText("");
        this.txtPregunta.setText("");
        this.txtID.setText("");
    }

    public void jTextBloqueados() {
        txtNombre.setEnabled(false);
        txtApellido.setEnabled(false);
        txtCargo.setEnabled(false);
        txtContra.setEnabled(false);
        txtRespuesta.setEnabled(false);
        txtDui.setEnabled(false);
        txtTelefono.setEnabled(false);
        txtPregunta.setEnabled(false);
        txtID.setEnabled(false);
    }

    public void jTextEditables() {
        txtNombre.setEnabled(true);
        txtApellido.setEnabled(true);
        txtCargo.setEnabled(true);
        txtContra.setEnabled(true);
        txtPregunta.setEnabled(true);
        txtRespuesta.setEnabled(true);
        txtDui.setEnabled(true);
        txtTelefono.setEnabled(true);
        txtID.setEnabled(true);
    }
    
    public void btnNoVisibles(){
        btnCancelar.setVisible(false);
        btnGuardar.setVisible(false);
        btnCrearUsu.setVisible(false);
        //lblTipo.setVisible(false);
    }
    
    private void cbxTipoUs(){
        cConexion con = new cConexion();
        String sql = "SELECT id_tipoUsuario, tuNombre FROM tipo_usuario";
        PreparedStatement ps;
        ResultSet res;
        try {
            ps = con.conexion().prepareStatement(sql);
            res = ps.executeQuery();
            while (res.next()){
                //System.out.println(res.getInt("id_tipoUsuario"));
                //System.out.println(res.getString("tuNombre"));
                cbxTipo.addItem(
                        new tipoUsuario ((res.getInt("id_tipoUsuario")),
                                res.getString("tuNombre")));
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error: "+e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }  
    }
    
    private void cbxIDtipoUS(){
        cConexion con = new cConexion();
        String tipoUS, usID, usDui;
        int idTipo;
        usID = txtID.getText();
        usDui = txtDui.getText();
        String sql = "SELECT tipo_usuario.tuNombre, usuario.id_tipoUsuario FROM tipo_usuario LEFT JOIN usuario ON usuario.id_tipoUsuario = tipo_usuario.id_tipoUsuario WHERE usuario.id_usuario = '"+usID+"' AND usuario.usDui = '"+usDui+"'";
        PreparedStatement ps;
        ResultSet res;
        try {
            ps = con.conexion().prepareStatement(sql);
            res = ps.executeQuery();
            if(res.next()){
                tipoUS = res.getString("tuNombre");
                txtTipo.setText(tipoUS);
                //txtTipo.setText(tipoUS);
                //System.out.println(tipoUS);
                idTipo = res.getInt("id_tipoUsuario");
                lblTipo.setText(String.valueOf(idTipo));
            }else{
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error: "+e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }  
        /*cConexion con = new cConexion();
        String usID, usDui;
        int usTipo;
        usID = txtID.getText();
        usDui = txtDui.getText();
        String sql = "SELECT id_tipoUsuario FROM usuario WHERE id_usuario = '"+usID+"' AND usDui = '"+usDui+"'";
        PreparedStatement ps;
        ResultSet res;
        try {
            ps = con.conexion().prepareStatement(sql);
            res = ps.executeQuery();
            if(res.next()){
                usTipo = res.getInt("id_tipoUsuario");
                lblTipo.setText(String.valueOf(usTipo));
            }else{
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error: "+e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }*/  
    }

    /**
     * Creates new form ListarUsuarios
     */
    public ListarUsuarios() {
        initComponents();
        //cargarTablaUsuarios();
        setLocationRelativeTo(null);
        jTextBloqueados();
        btnNoVisibles();
        //String frase = this.txtBuscar.getText(); //Variable para capturar la palabra a usar en el filtro de busqueda del CargarBuscarDatos
        CargarBuscarDatos();
        cbxTipoUs();
        //cbxIDtipoUS();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        txtDui = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtContra = new javax.swing.JTextField();
        txtPregunta = new javax.swing.JTextField();
        txtCargo = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        btnCrearUsu = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtRespuesta = new javax.swing.JTextField();
        lblTipo = new javax.swing.JLabel();
        lblTipoUS = new javax.swing.JLabel();
        cbxTipo = new javax.swing.JComboBox<>();
        txtTipo = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableListUsuarios = new javax.swing.JTable();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnCrearUsuario = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jSeparator1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 255, 255), new java.awt.Color(0, 0, 153), new java.awt.Color(0, 0, 153), new java.awt.Color(255, 255, 255)));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setText("Información del usuario");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel2.setText("Nombre:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel4.setText("Apellido:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel5.setText("Dui:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel6.setText("Contraseña:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel7.setText("Cargo:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel9.setText("Pregunta:");

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel10.setText("Teléfono:");

        btnCrearUsu.setText("Crear Usuario");
        btnCrearUsu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearUsuActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel11.setText("ID:");

        txtID.setEditable(false);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel8.setText("Respuesta:");

        lblTipo.setText("ID");

        lblTipoUS.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblTipoUS.setText("Tipo de Usuario:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel8))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDui, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtContra, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPregunta, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtRespuesta, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnCrearUsu)
                                .addGap(62, 62, 62)
                                .addComponent(btnGuardar)
                                .addGap(56, 56, 56)
                                .addComponent(btnCancelar))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(lblTipoUS)
                        .addGap(18, 18, 18)
                        .addComponent(cbxTipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel3)
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtDui, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtContra, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)))
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtPregunta, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRespuesta, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTipoUS)
                    .addComponent(cbxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCrearUsu)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar)
                    .addComponent(lblTipo)
                    .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51))
        );

        jPanel2.setBackground(new java.awt.Color(237, 252, 252));

        tableListUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8"
            }
        ));
        tableListUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableListUsuariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableListUsuarios);

        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buscar.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnCrearUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/agregar.png"))); // NOI18N
        btnCrearUsuario.setText("Crear Usuario");
        btnCrearUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearUsuarioActionPerformed(evt);
            }
        });

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/editar.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/eliminar.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lista.png"))); // NOI18N
        jLabel1.setText("Lista de Usuarios");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(317, 317, 317)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(btnBuscar)
                        .addGap(144, 144, 144)
                        .addComponent(btnCrearUsuario)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditar)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminar)))
                .addGap(83, 83, 83))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscar)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCrearUsuario)
                    .addComponent(btnEditar)
                    .addComponent(btnEliminar))
                .addGap(35, 35, 35)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(93, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 193, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tableListUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableListUsuariosMouseClicked
        // TODO add your handling code here:
//        int fila = this.tableListUsuarios.getSelectedRow();
//        this.txtNombre.setText(tableListUsuarios.getValueAt(tableListUsuarios.getSelectedRow(), 0).toString());
//        this.txtApellido.setText(tableListUsuarios.getValueAt(tableListUsuarios.getSelectedRow(), 1).toString());
//        this.txtCargo.setText(tableListUsuarios.getValueAt(tableListUsuarios.getSelectedRow(), 1).toString());
    }//GEN-LAST:event_tableListUsuariosMouseClicked

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
        int fila = this.tableListUsuarios.getSelectedRow();
            btnCrearUsu.setEnabled(false);
            btnCrearUsu.setVisible(false);
        if (fila >= 0) {
            jTextEditables();
            

            this.txtID.setText(this.tableListUsuarios.getValueAt(fila, 0).toString());
            this.txtNombre.setText(this.tableListUsuarios.getValueAt(fila, 1).toString());
            this.txtApellido.setText(this.tableListUsuarios.getValueAt(fila, 2).toString());
            this.txtDui.setText(this.tableListUsuarios.getValueAt(fila, 3).toString());
            this.txtCargo.setText(this.tableListUsuarios.getValueAt(fila, 4).toString());
            this.txtTelefono.setText(this.tableListUsuarios.getValueAt(fila, 5).toString());
            this.txtPregunta.setText(this.tableListUsuarios.getValueAt(fila, 6).toString());
            this.txtRespuesta.setText(this.tableListUsuarios.getValueAt(fila, 7).toString());
            //this.txtTelefono.setText(this.tableListUsuarios.getValueAt(fila, 8).toString());
            
           //txtPregunta.setEditable(false);
           cbxIDtipoUS();
           
            btnGuardar.setEnabled(true);
            btnGuardar.setVisible(true);
            txtID.setEnabled(false);

            /* if (!this.tableListUsuarios.getValueAt(fila, 2).toString().isEmpty()) {
                this.txtDui.setText(this.tableListUsuarios.getValueAt(fila, 2).toString());
            }
            else{     
            }
             */
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una usuario de la tabla para poder editar su información");
        }
            //String usTipo = txtTipo.getText();
           //int index = Integer.parseInt(lblTipo.getText());
           //this.cbxTipo.setSelectedItem(Integer.parseInt(lblTipo.getText()));
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
//        if (txtNombre.getText().equals("") || txtApellido.getText().equals("") 
//                || txtContra.getText().equals("") || txtUsuario.getText().equals("")) {
//            JOptionPane.showMessageDialog(null, "Los campos nombre, apellido, usuario y contraseña son obligatorios");
//        }
        String pass = new String(this.txtContra.getText());
        int usID = Integer.parseInt(txtID.getText());
        
        if (txtPregunta.getText().equals("") || txtNombre.getText().equals("")
                || txtApellido.getText().equals("") || txtPregunta.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Hay campos vacios, debe completar todos los campos");
        } else if (txtNombre.getText().length() < 6
                || txtApellido.getText().length() < 6) {
            JOptionPane.showMessageDialog(null, "Los campos de Nombre y apellido deben de ser mayor a 6 caracteres");
        } else if (txtDui.getText().length() < 8) {
            JOptionPane.showMessageDialog(null, "El campo usuario debe de ser mayor a 7 caracteres");
        } else {
            if (pass.length() >= 10) {
              
                usr.setUsPasswd(pass);
                usr.setUsNombre(txtNombre.getText());
                usr.setUsApellido(txtApellido.getText());
                usr.setUsDui(txtDui.getText());
                usr.setUsCargo(txtCargo.getText());
                usr.setUsTelefono(txtTelefono.getText());
                usr.setUsPregunta(txtPregunta.getText());
                usr.setUsRespuesta(txtRespuesta.getText());
                //usr.setId_tipoUsuario(Integer.parseInt(txtpru.getText()));
                usr.setId_usuario(usID);
                if (controlUsu.modificarInfoUsuario(usr)) {
                    JOptionPane.showMessageDialog(null, "El Usuario se Edito con exito");
                    jTextBloqueados();
                    limpiarCampos();
                    //cargarTablaUsuarios();
                    CargarBuscarDatos();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al guardar el usuario, revise la informacion.");
                }

            } else {
                JOptionPane.showMessageDialog(null, "La contraseña debe de ser mayor a 9 caracteres");
            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCrearUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearUsuarioActionPerformed
        // TODO add your handling code here:
        jTextEditables();
        limpiarCampos();
        btnCrearUsu.setEnabled(true);
        btnCrearUsu.setVisible(true);
        btnGuardar.setEnabled(false);
        btnGuardar.setVisible(false);
        txtID.setEnabled(false);
        txtNombre.requestFocus();
        
    }//GEN-LAST:event_btnCrearUsuarioActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        int fila = this.tableListUsuarios.getSelectedRow();
        btnCrearUsu.setEnabled(false);
        btnCancelar.setEnabled(false);
        btnGuardar.setEnabled(false);
        btnGuardar.setVisible(false);
        limpiarCampos();
        
        if (fila >= 0) {
            String usrNombre = this.tableListUsuarios.getValueAt(fila, 1).toString(); 
            String usrApellido = this.tableListUsuarios.getValueAt(fila, 2).toString();
            String usrDui = this.tableListUsuarios.getValueAt(fila, 3).toString();
            String usrNombreCompleto = (usrNombre+" "+usrApellido); //Capturamos el usuario seleccionado
            
            String id= (this.tableListUsuarios.getValueAt(fila, 0).toString());//Capturamos el id del usuario para poderlo eliminar
            this.usr.setId_usuario(Integer.parseInt(id));
            int resultado = JOptionPane.showConfirmDialog(ListarUsuarios.this, "¿Esta seguro de querer ELIMINAR a " + usrNombreCompleto + " con el numero de DUI: "
                    + usrDui + " de la lista de Usuarios?", "Confirmación", JOptionPane.YES_NO_OPTION);
            if (resultado == JOptionPane.YES_OPTION) {

                if (controlUsu.EliminarUsuario(this.usr)) {

                    JOptionPane.showMessageDialog(null, "El USUARIO fue ELIMINADO correctamente");
                    //cargarTablaUsuarios();
                    CargarBuscarDatos();
                    limpiarCampos();
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una usuario de la tabla para poder Eliminarlo");

        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnCrearUsuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearUsuActionPerformed
        // TODO add your handling code here:
        String pass = new String(this.txtContra.getText());
        tipoUsuario tipoUsuario = (tipoUsuario) cbxTipo.getSelectedItem();

        if (txtPregunta.getText().equals("") || txtNombre.getText().equals("")
                || txtApellido.getText().equals("") || txtPregunta.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Hay campos vacios, debe completar todos los campos");
        } else if (txtNombre.getText().length() < 3
                || txtApellido.getText().length() < 4) {
            JOptionPane.showMessageDialog(null, "El campo de Nombre y/o Apellido deben contener mas caracteres");
        } else if (txtDui.getText().length() < 9) {
            JOptionPane.showMessageDialog(null, "El campo DUI debe tener un total de 9 caracteres");
        } else {
            if (pass.length() >= 10) {
                if (controlUsu.existeUsuario(txtDui.getText()) == 0) { //Validamos que no existan usuarios duplicados
                    usr.setUsDui(txtDui.getText());
                    usr.setUsPasswd(pass);
                    usr.setUsNombre(txtNombre.getText());
                    usr.setUsApellido(txtApellido.getText());
                    usr.setId_tipoUsuario(tipoUsuario.getId_tipoUsuario());
                    usr.setUsPregunta(txtPregunta.getText());
                    usr.setUsTelefono(txtTelefono.getText());
                    usr.setUsRespuesta(txtRespuesta.getText());
                    usr.setUsCargo(txtCargo.getText());
                    if (controlUsu.registrar(usr)) {
                        JOptionPane.showMessageDialog(null, "El Usuario se creo con exito");
                        jTextBloqueados();
                        limpiarCampos();
                        //cargarTablaUsuarios();
                        CargarBuscarDatos();
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al guardar el usuario, revise la informacion.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "El usuario ya existe");
                }
            } else {
                JOptionPane.showMessageDialog(null, "La contraseña debe de ser mayor a 9 caracteres");
            }
        }
    }//GEN-LAST:event_btnCrearUsuActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
//        String frase = this.txtBuscar.getText(); //Variable para capturar la palabra a usar en el filtro de busqueda del CargarBuscarDatos

        CargarBuscarDatos();
        btnNoVisibles();
        limpiarCampos();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed

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
            java.util.logging.Logger.getLogger(ListarUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListarUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListarUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListarUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ListarUsuarios().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(ListarUsuarios.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCrearUsu;
    private javax.swing.JButton btnCrearUsuario;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<tipoUsuario> cbxTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JLabel lblTipoUS;
    private javax.swing.JTable tableListUsuarios;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCargo;
    private javax.swing.JTextField txtContra;
    private javax.swing.JTextField txtDui;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPregunta;
    private javax.swing.JTextField txtRespuesta;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtTipo;
    // End of variables declaration//GEN-END:variables
}
