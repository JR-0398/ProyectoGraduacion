/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Pantallas;

import com.dao.controlArticulo;
import com.modelo.articulo;
import db_conexion.cConexion;
//import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
//import java.util.logging.Level;
//import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author victor
 */
public class Productos extends javax.swing.JFrame {
    
    cConexion con = new cConexion();
    int id_categoria, usId;
    String categoria;
    String[] columnas = {"ID", "CODIGO", "NOMBRE", "CANTIDAD", "ESTADO", "COMENTARIO", "USUARIO", "CATEGORIA"};
    DefaultTableModel model = new DefaultTableModel(columnas,0){
        @Override 
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    controlArticulo controlArt = new controlArticulo();
    List<articulo> datos = new ArrayList<>();
    articulo art = new articulo();
    
    /*private void listarTbArt() {
        tbListarArt.getTableHeader().setReorderingAllowed(false);
        this.model.setRowCount(0);
        datos.clear();
        datos = (List<articulo>) controlArt.mostrarArticulos();
        Object[] obj = new Object[8];
        for (articulo fila : datos) {
            obj[0] = fila.getId_articulo();
            obj[1] = fila.getArtCodigo();
            obj[2] = fila.getArtNombre();
            obj[3] = fila.getArtCantidad();
            obj[4] = fila.getArtEstado();
            obj[5] = fila.getArtComentario();
            obj[6] = fila.getId_usuario();
            obj[7] = fila.getId_categoria();
            this.model.addRow(obj);
        }
        this.tbListarArt.setModel(model);
    }*/
    
    private void BuscarDatos(){
        tbListarArt.getTableHeader().setReorderingAllowed(false);
        model.setRowCount(0);
        datos.clear();
        String frase = txtBuscar.getText();
        datos = (List<articulo>) controlArt.buscarArticulo(frase);
        Object[] obj = new Object[8];
        for (articulo fila : datos) {
            obj[0] = fila.getId_articulo();
            obj[1] = fila.getArtCodigo();
            obj[2] = fila.getArtNombre();
            obj[3] = fila.getArtCantidad();
            obj[4] = fila.getArtEstado();
            obj[5] = fila.getArtComentario();
            obj[6] = fila.getId_usuario();
            obj[7] = fila.getId_categoria();
            model.addRow(obj);
        }
        tbListarArt.setModel(model);
    }
    
    private void limpiarArt(){
        txtCodigo.setText("");
        txtNombre.setText("");
        txtComentario.setText("");
    }
    
    private void bloquearArt(){
        txtCodigo.setEnabled(false);
        txtNombre.setEnabled(false);
        txtCantidad.setEnabled(false);
        cbxEstado.setEnabled(false);
        txtComentario.setEnabled(false);
        cbxCategoria.setEnabled(false);
        btnGuardar.setEnabled(false);
        btnActualizar.setEnabled(false);
    }
    
    private void editablesArt(){
        txtCodigo.setEnabled(true);
        txtNombre.setEnabled(true);
        txtCantidad.setEnabled(true);
        cbxEstado.setEnabled(true);
        txtComentario.setEnabled(true);
        cbxCategoria.setEnabled(true); 
    }
    
    private void cargarCbxCat(){
       //cConexion con = new cConexion();
       String sql = "SELECT catNombre FROM categoria";
       PreparedStatement ps;
       ResultSet res;
        try {
           ps = con.conexion().prepareStatement(sql);
           res = ps.executeQuery();
           Object dato[]= new Object[1];
           while (res.next()){
               for (int i=0;i<1;i++){
                   dato[i]=(res.getObject(i+1));
                   this.cbxCategoria.addItem(String.valueOf(dato[i]));
               } 
           //while (res.next()) {
               ///cbxCategoria.addItem(res.getString("categoria"));
           }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error: "+e.toString(), " ¡¡ ERROR !!", JOptionPane.ERROR_MESSAGE);
        }
    }
    
     public void idCategoria(){
       //cConexion con = new cConexion();
       //String cat = cbxCategoria.getSelectedItem().toString();
       String sql = "SELECT id_categoria FROM categoria WHERE catNombre = '"+cbxCategoria.getSelectedItem()+"'";
       PreparedStatement ps;
       ResultSet res;
       try {
           ps = con.conexion().prepareStatement(sql);
           res = ps.executeQuery();
            if(res.next()) {
                id_categoria = res.getInt("id_categoria");
            } else {
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error", "¡¡ ERROR !!", JOptionPane.ERROR_MESSAGE);
            }
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error: "+e.toString(), " ¡¡ ERROR !!", JOptionPane.ERROR_MESSAGE);
        }  
    }
     
     public void nombreCat(){
       //cConexion con = new cConexion();
       //String cat = cbxCategoria.getSelectedItem().toString();
       String sql = "SELECT catNombre FROM categoria WHERE id_categoria = '"+id_categoria+"'";
       PreparedStatement ps;
       ResultSet res;
       try {
           ps = con.conexion().prepareStatement(sql);
           res = ps.executeQuery();
            if(res.next()) {
                categoria = res.getString("catNombre");
            } else {
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error", "¡¡ ERROR !!", JOptionPane.ERROR_MESSAGE);
            }
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error: "+e.toString(), " ¡¡ ERROR !!", JOptionPane.ERROR_MESSAGE);
        }  
    }

    /**
     * Creates new form Productos
     */
    public Productos() {
        initComponents();
        //listarTbArt();
        cargarCbxCat();
        //idCategoria();
        BuscarDatos();
        bloquearArt();
    }
    
    public void obtenerDato(int usId){
        this.usId = usId;
        lblUserLogin.setText(String.valueOf(usId));
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
        lblCodigo = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        lblNombreArt = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblCantidad = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JSpinner();
        lblEstado = new javax.swing.JLabel();
        cbxEstado = new javax.swing.JComboBox<>();
        lblCategoria = new javax.swing.JLabel();
        cbxCategoria = new javax.swing.JComboBox<>();
        lblComentario = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtComentario = new javax.swing.JTextArea();
        btnGuardar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        lblDetalleArt = new javax.swing.JLabel();
        lblIdArticulo = new javax.swing.JLabel();
        lblIdUser = new javax.swing.JLabel();
        lblUserLogin = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbListarArt = new javax.swing.JTable();
        lblBuscar = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnPerfil = new javax.swing.JButton();
        btnCat = new javax.swing.JButton();
        btnMenu = new javax.swing.JButton();
        lblInfo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        lblCodigo.setText("Código");

        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActionPerformed(evt);
            }
        });

        lblNombreArt.setText("Nombre");

        lblCantidad.setText("Cantidad");

        txtCantidad.setModel(new javax.swing.SpinnerNumberModel(1, 1, 9999, 1));

        lblEstado.setText("Estado");

        cbxEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Dañado", "En reparación", "Inactivo" }));

        lblCategoria.setText("Categoria");

        lblComentario.setText("Comentario");

        txtComentario.setColumns(20);
        txtComentario.setRows(5);
        jScrollPane2.setViewportView(txtComentario);

        btnGuardar.setBackground(new java.awt.Color(255, 218, 172));
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/save.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnActualizar.setBackground(new java.awt.Color(255, 218, 172));
        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/actualizar.png"))); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnCancelar.setText("x");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnNuevo.setText("+");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        lblDetalleArt.setText("ARTICULO");

        lblIdArticulo.setText("ID");

        lblIdUser.setText("ID");

        lblUserLogin.setText("ID");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblComentario)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNombreArt)
                            .addComponent(lblCodigo)
                            .addComponent(lblCantidad)
                            .addComponent(lblEstado)
                            .addComponent(lblCategoria)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnNuevo)
                                .addGap(18, 18, 18)
                                .addComponent(btnCancelar)))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxCategoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbxEstado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtCantidad)
                            .addComponent(txtNombre)
                            .addComponent(txtCodigo)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lblDetalleArt)
                                        .addGap(18, 18, 18)
                                        .addComponent(lblIdArticulo)
                                        .addGap(26, 26, 26)
                                        .addComponent(lblIdUser)
                                        .addGap(18, 18, 18)
                                        .addComponent(lblUserLogin))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnActualizar)))
                                .addGap(0, 22, Short.MAX_VALUE)))))
                .addGap(24, 24, 24))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDetalleArt)
                    .addComponent(lblIdArticulo)
                    .addComponent(lblIdUser)
                    .addComponent(lblUserLogin))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodigo)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombreArt)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCantidad)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEstado)
                    .addComponent(cbxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblComentario)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCategoria)
                    .addComponent(cbxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnNuevo)
                    .addComponent(btnCancelar)
                    .addComponent(btnActualizar))
                .addGap(36, 36, 36))
        );

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));

        tbListarArt.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Código", "Nombre", "Categoria", "Descripción"
            }
        ));
        tbListarArt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbListarArtMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbListarArt);

        lblBuscar.setText("Buscar");

        btnBuscar.setBackground(new java.awt.Color(255, 218, 172));
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buscar.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnEditar.setBackground(new java.awt.Color(255, 218, 172));
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/editar.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.setToolTipText("");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnEliminar.setBackground(new java.awt.Color(255, 218, 172));
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/eliminar.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnPerfil.setBackground(new java.awt.Color(255, 218, 172));
        btnPerfil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/perfill.png"))); // NOI18N
        btnPerfil.setText("Perfil");

        btnCat.setBackground(new java.awt.Color(255, 218, 172));
        btnCat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/inventaio.png"))); // NOI18N
        btnCat.setText("Categoria");

        btnMenu.setBackground(new java.awt.Color(255, 218, 172));
        btnMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/panel.png"))); // NOI18N
        btnMenu.setText("Menu Principal");

        lblInfo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/informacion.png"))); // NOI18N
        lblInfo.setText("INFORMACION");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnPerfil)
                        .addGap(18, 18, 18)
                        .addComponent(btnMenu)
                        .addGap(18, 18, 18)
                        .addComponent(btnCat)
                        .addGap(29, 29, 29))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblInfo)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lblBuscar)
                                .addGap(18, 18, 18)
                                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnBuscar)))
                        .addGap(18, 18, 18)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 573, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(lblInfo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBuscar)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar)
                    .addComponent(btnEditar)
                    .addComponent(btnEliminar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPerfil)
                    .addComponent(btnCat)
                    .addComponent(btnMenu))
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        idCategoria();
        if(txtCodigo.getText().equals("")||txtNombre.getText().equals("") || txtComentario.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Ingrese todos los datos solicitados !!");
        }else{
            art.setArtCodigo(txtCodigo.getText());
            art.setArtNombre(txtNombre.getText());
            art.setArtCantidad(Integer.parseInt(txtCantidad.getValue().toString()));
            art.setArtEstado(cbxEstado.getSelectedItem().toString());
            art.setArtComentario(txtComentario.getText());
            art.setId_usuario(Integer.valueOf(lblUserLogin.getText()));
            art.setId_categoria(id_categoria);
            if (controlArt.ingresarArticulos(art)){
                JOptionPane.showMessageDialog(this,"Categoria guardada con exito !!");
                //listarTbArt();
                //limpiarArt();
                BuscarDatos();
                bloquearArt();
                limpiarArt();
                btnNuevo.setEnabled(true);
            }else{
                JOptionPane.showMessageDialog(this,"Error al insertar");
            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void tbListarArtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbListarArtMouseClicked
        // TODO add your handling code here:
        /*this.txtCodigo.setText(tbListarArt.getValueAt(tbListarArt.getSelectedRow(),1).toString());
        this.txtNombre.setText(tbListarArt.getValueAt(tbListarArt.getSelectedRow(),2).toString());
        this.txtCantidad.setValue(Integer.parseInt(tbListarArt.getValueAt(tbListarArt.getSelectedRow(),3).toString()));
        this.cbxEstado.setSelectedItem(tbListarArt.getValueAt(tbListarArt.getSelectedRow(),4).toString());
        this.txtUsuario.setText(tbListarArt.getValueAt(tbListarArt.getSelectedRow(),5).toString());
        id_categoria = Integer.parseInt(tbListarArt.getValueAt(tbListarArt.getSelectedRow(),6).toString());
        nombreCat();
        this.cbxCategoria.setSelectedItem(categoria);
        this.lblIdArticulo.setText(tbListarArt.getValueAt(tbListarArt.getSelectedRow(),0).toString());*/
    }//GEN-LAST:event_tbListarArtMouseClicked

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
        int fila = this.tbListarArt.getSelectedRow();
        if (fila >= 0) {
            editablesArt();
            btnGuardar.setEnabled(false);
            btnActualizar.setEnabled(true);
            txtCodigo.setText(tbListarArt.getValueAt(tbListarArt.getSelectedRow(),1).toString());
            txtNombre.setText(tbListarArt.getValueAt(tbListarArt.getSelectedRow(),2).toString());
            txtCantidad.setValue(Integer.parseInt(tbListarArt.getValueAt(tbListarArt.getSelectedRow(),3).toString()));
            cbxEstado.setSelectedItem(tbListarArt.getValueAt(tbListarArt.getSelectedRow(),4).toString());
            txtComentario.setText(tbListarArt.getValueAt(tbListarArt.getSelectedRow(),5).toString());
            lblIdUser.setText(tbListarArt.getValueAt(tbListarArt.getSelectedRow(),6).toString());
            id_categoria = Integer.parseInt(tbListarArt.getValueAt(tbListarArt.getSelectedRow(),7).toString());
            nombreCat();
            cbxCategoria.setSelectedItem(categoria);
            lblIdArticulo.setText(tbListarArt.getValueAt(tbListarArt.getSelectedRow(),0).toString());
        }else{
            JOptionPane.showMessageDialog(null, "Seleccione un articulo de la tabla para poder editar su información");
        }
        
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        /*int resp = JOptionPane.showConfirmDialog(null, "¿Desea eliminar el articulo selecionado ??", "Advertencia !!", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
        if (resp == JOptionPane.YES_OPTION)
        {
            if (this.controlArt.EliminarArticulo(this.art)){
                JOptionPane.showMessageDialog(this,"Articulo eliminado !!");
                listarTbArt();
                //limpiarCat();
            }else{
                JOptionPane.showMessageDialog(this,"El articulo no se ha eliminado !!");
            }
        }*/
        
        int fila = tbListarArt.getSelectedRow();
        if (fila >= 0){
            String id = tbListarArt.getValueAt(fila, 0).toString();
            String artCodigo = tbListarArt.getValueAt(fila, 1).toString();
            String artNombre = tbListarArt.getValueAt(fila, 2).toString();
            art.setId_articulo(Integer.parseInt(id));
            int resp = JOptionPane.showConfirmDialog(null, "¿Desea eliminar el articulo "+artNombre+" con el codigo: "+artCodigo+"?", "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
            if (resp==JOptionPane.YES_OPTION){
                if (controlArt.EliminarArticulo(art)){
                    JOptionPane.showMessageDialog(this,"Articulo eliminade");
                    BuscarDatos();
                    //listarTbCat();
                }
            }else{
                JOptionPane.showMessageDialog(this,"el articulo no se ha eliminado");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Seleccione un articulo de la tabla para poder Eliminarlp");
        }
        
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        bloquearArt();
        limpiarArt();
        btnNuevo.setEnabled(true);
        btnGuardar.setEnabled(false);
        btnActualizar.setEnabled(false);

    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
        idCategoria();
        if(txtCodigo.getText().equals("") || txtNombre.getText().equals("") || txtComentario.getText().equals("") ){
            JOptionPane.showMessageDialog(null, "Ingrese todos los datos solicitados");
        }else{
            //art.setId_articulo(Integer.parseInt(this.lblIdArticulo.getText()));
            art.setArtCodigo(txtCodigo.getText());
            art.setArtNombre(txtNombre.getText());
            art.setArtCantidad(Integer.parseInt(txtCantidad.getValue().toString()));
            art.setArtEstado(cbxEstado.getSelectedItem().toString());
            art.setArtComentario(txtComentario.getText());
            art.setId_usuario(Integer.parseInt(lblIdUser.getText()));
            art.setId_categoria(id_categoria);
            if (this.controlArt.editarArticulo(art)){
                JOptionPane.showMessageDialog(this,"Se ha modificado con exito!!");
                //listarTbArt();
                //limpiarCat();
                BuscarDatos();
                bloquearArt();
                limpiarArt();
                btnActualizar.setEnabled(false);
            }else{
                JOptionPane.showMessageDialog(this,"Ha ocurrido un error al modificar");
            }
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        btnGuardar.setEnabled(true);
        btnNuevo.setEnabled(false);
        editablesArt();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        BuscarDatos();
        //listarTbCat();
        bloquearArt();
        limpiarArt();
    }//GEN-LAST:event_btnBuscarActionPerformed

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
            java.util.logging.Logger.getLogger(Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Productos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCat;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnMenu;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnPerfil;
    private javax.swing.JComboBox<String> cbxCategoria;
    private javax.swing.JComboBox<String> cbxEstado;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblBuscar;
    private javax.swing.JLabel lblCantidad;
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblComentario;
    private javax.swing.JLabel lblDetalleArt;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblIdArticulo;
    private javax.swing.JLabel lblIdUser;
    private javax.swing.JLabel lblInfo;
    private javax.swing.JLabel lblNombreArt;
    private javax.swing.JLabel lblUserLogin;
    private javax.swing.JTable tbListarArt;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JSpinner txtCantidad;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextArea txtComentario;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
