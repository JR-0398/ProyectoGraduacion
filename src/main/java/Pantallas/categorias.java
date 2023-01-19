/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Pantallas;

import com.dao.controlCategoria;
import com.modelo.categoria;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Banos
 */
public class categorias extends javax.swing.JFrame {
    
    String[] columnas = {"ID", "NOMBRE", "DESCRIPCION"};
    DefaultTableModel model = new DefaultTableModel(columnas,0){
        @Override 
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    controlCategoria controlCat = new controlCategoria();
    List<categoria> datos = new ArrayList<>();
    categoria cat = new categoria();
    
    /*private void listarTbCat() {
        tbListarCat.getTableHeader().setReorderingAllowed(false);
        model.setRowCount(0);
        datos.clear();
        datos = (List<categoria>) controlCat.mostrarCategorias();
        Object[] obj = new Object[3];
        for (categoria fila : datos) {
            obj[0] = fila.getId_categoria();
            obj[1] = fila.getCatNombre();
            obj[2] = fila.getCatDescripcion();
            model.addRow(obj);
        }
        tbListarCat.setModel(model);
    }*/
    
    private void BuscarDatos(){
        tbListarCat.getTableHeader().setReorderingAllowed(false);
        model.setRowCount(0);
        datos.clear();
        String frase = txtBuscar.getText();
        datos = (List<categoria>) controlCat.buscarCategoria(frase);
        Object[] obj = new Object[3];
        for (categoria fila : datos) {
            obj[0] = fila.getId_categoria();
            obj[1] = fila.getCatNombre();
            obj[2] = fila.getCatDescripcion();
            model.addRow(obj);
        }
        tbListarCat.setModel(model);
    }
    
    private void limpiarCat(){
        txtNombreCat.setText("");
        txtDescripcionCat.setText("");  
        txtBuscar.setText("");
    }
    
    private void bloquearCat(){
        txtNombreCat.setEnabled(false);
        txtDescripcionCat.setEnabled(false);
        btnGuardarCat.setEnabled(false);
        btnActualizar.setEnabled(false);
    }
    
    private void editablesCat(){
        txtNombreCat.setEnabled(true);
        txtDescripcionCat.setEnabled(true);
    }

    /**
     * Creates new form categorias
     */
    public categorias() {
        initComponents();
        //listarTbCat();
        BuscarDatos();
        bloquearCat();
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
        lblDescripcionCat = new javax.swing.JLabel();
        txtNombreCat = new javax.swing.JTextField();
        lblNombreCat = new javax.swing.JLabel();
        lblInsertarCat = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescripcionCat = new javax.swing.JTextArea();
        lblCodigo = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        btnGuardarCat = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnCrear = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbListarCat = new javax.swing.JTable();
        btnEditarCat = new javax.swing.JButton();
        btnBorrarCat = new javax.swing.JButton();
        btnMenu = new javax.swing.JButton();
        btnProductos = new javax.swing.JButton();
        lblListarCat = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(200, 237, 253));

        lblDescripcionCat.setText("Descripción");

        txtNombreCat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreCatKeyTyped(evt);
            }
        });

        lblNombreCat.setText("Categoria");

        lblInsertarCat.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblInsertarCat.setText("CATEGORIA");

        txtDescripcionCat.setColumns(20);
        txtDescripcionCat.setRows(5);
        txtDescripcionCat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDescripcionCatKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(txtDescripcionCat);

        lblCodigo.setText("ID");

        btnGuardarCat.setBackground(new java.awt.Color(204, 204, 255));
        btnGuardarCat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/save.png"))); // NOI18N
        btnGuardarCat.setText("Guardar");
        btnGuardarCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarCatActionPerformed(evt);
            }
        });

        btnActualizar.setBackground(new java.awt.Color(204, 204, 255));
        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/actualizar.png"))); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnCrear.setText("+");
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });

        btnCancelar.setText("x");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblNombreCat)
                                .addGap(39, 39, 39)
                                .addComponent(txtNombreCat, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblDescripcionCat)
                                    .addComponent(lblCodigo))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(btnCrear)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar)
                        .addGap(34, 34, 34)
                        .addComponent(btnGuardarCat)
                        .addGap(32, 32, 32)
                        .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(298, 298, 298)
                        .addComponent(lblInsertarCat)))
                .addContainerGap(231, Short.MAX_VALUE))
            .addComponent(jSeparator3)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lblInsertarCat)
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombreCat)
                    .addComponent(txtNombreCat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblDescripcionCat)
                        .addGap(18, 18, 18)
                        .addComponent(lblCodigo))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardarCat)
                    .addComponent(btnActualizar)
                    .addComponent(btnCrear)
                    .addComponent(btnCancelar))
                .addContainerGap(63, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(200, 237, 253));

        tbListarCat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Codigo", "Categoria", "Descripción"
            }
        ));
        tbListarCat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbListarCatMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbListarCat);

        btnEditarCat.setBackground(new java.awt.Color(204, 204, 255));
        btnEditarCat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/editar.png"))); // NOI18N
        btnEditarCat.setText("Editar");
        btnEditarCat.setToolTipText("");
        btnEditarCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarCatActionPerformed(evt);
            }
        });

        btnBorrarCat.setBackground(new java.awt.Color(204, 204, 255));
        btnBorrarCat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/eliminar.png"))); // NOI18N
        btnBorrarCat.setText("Eliminar");
        btnBorrarCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarCatActionPerformed(evt);
            }
        });

        btnMenu.setBackground(new java.awt.Color(204, 204, 255));
        btnMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/inventaio.png"))); // NOI18N
        btnMenu.setText("Menu de Inicio");
        btnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuActionPerformed(evt);
            }
        });

        btnProductos.setBackground(new java.awt.Color(204, 204, 255));
        btnProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lista.png"))); // NOI18N
        btnProductos.setText("Control de articulos");
        btnProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductosActionPerformed(evt);
            }
        });

        lblListarCat.setText("INFORMACION DE CATEGORIAS");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Buscar ");

        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });

        btnBuscar.setBackground(new java.awt.Color(204, 204, 255));
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buscar.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblListarCat)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(btnProductos)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnMenu))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 562, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnBuscar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEditarCat, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBorrarCat)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditarCat)
                    .addComponent(btnBorrarCat)
                    .addComponent(jLabel6)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addGap(29, 29, 29)
                .addComponent(lblListarCat)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMenu))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
        if(txtNombreCat.getText().equals("")||txtDescripcionCat.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Existen datos vacio, verifique !!");
        }else{
            cat.setId_categoria(Integer.parseInt(lblCodigo.getText()));
            cat.setCatNombre(txtNombreCat.getText());
            cat.setCatDescripcion(txtDescripcionCat.getText());
            if (controlCat.editarCategoria(cat)){
                JOptionPane.showMessageDialog(this,"Se ha modificado con exito!!");
                BuscarDatos();
                //listarTbCat();
                limpiarCat();
                bloquearCat();
                //btnGuardarCat.setEnabled(true);
                btnActualizar.setEnabled(false);
            }else{
                JOptionPane.showMessageDialog(this,"Ha ocurrido un error al modificar");
            }
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnGuardarCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarCatActionPerformed
        // TODO add your handling code here:
        if(txtNombreCat.getText().equals("")||txtDescripcionCat.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Ingrese todos los datos solicitados !!");
        }else{
            if (controlCat.existeUsuario(txtNombreCat.getText()) == 0) {
                cat.setCatNombre(txtNombreCat.getText()); 
                cat.setCatDescripcion(txtDescripcionCat.getText());
                //this.lblNombreCat.setText(this.cat.getCategoria());
                //this.lblDescripcionCat.setText(this.cat.getDescripcionCat());
                if (controlCat.ingresarCategorias(cat)){
                    JOptionPane.showMessageDialog(this,"Categoria guardada con exito !!");
                    BuscarDatos();
                    //listarTbCat();
                    limpiarCat();
                    bloquearCat();
                    btnCrear.setEnabled(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Error al guardar la categoria revise la informacion.");
                }
            }else{
                    JOptionPane.showMessageDialog(null, "La categoria ya existe");
            }
        }
    }//GEN-LAST:event_btnGuardarCatActionPerformed

    private void tbListarCatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbListarCatMouseClicked
        // TODO add your handling code here:
        /*this.txtNombreCat.setText(tbListarCat.getValueAt(tbListarCat.getSelectedRow(),1).toString());
        this.txtDescripcionCat.setText(tbListarCat.getValueAt(tbListarCat.getSelectedRow(),2).toString());
        this.lblCodigo.setText(tbListarCat.getValueAt(tbListarCat.getSelectedRow(),0).toString());*/
    }//GEN-LAST:event_tbListarCatMouseClicked

    private void btnEditarCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarCatActionPerformed
        // TODO add your handling code here:
        int fila = this.tbListarCat.getSelectedRow();
        if (fila >= 0) {
            editablesCat();
            btnGuardarCat.setEnabled(false);
            btnActualizar.setEnabled(true);
            txtNombreCat.setText(tbListarCat.getValueAt(tbListarCat.getSelectedRow(),1).toString());
            txtDescripcionCat.setText(tbListarCat.getValueAt(tbListarCat.getSelectedRow(),2).toString());
            lblCodigo.setText(tbListarCat.getValueAt(tbListarCat.getSelectedRow(),0).toString());
        }else{
            JOptionPane.showMessageDialog(null, "Seleccione una categoria de la tabla para poder editar su información");
        }
    }//GEN-LAST:event_btnEditarCatActionPerformed

    private void btnBorrarCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarCatActionPerformed
        // TODO add your handling code here:
        int fila = this.tbListarCat.getSelectedRow();
        if (fila >= 0){
            String id = this.tbListarCat.getValueAt(fila, 0).toString();
            String catNombre = this.tbListarCat.getValueAt(fila, 1).toString();
            this.cat.setId_categoria(Integer.parseInt(id));
            int resp = JOptionPane.showConfirmDialog(null, "¿Desea eliminar la categoria "+catNombre+"?", "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
            if (resp==JOptionPane.YES_OPTION){
                if (controlCat.EliminarCategoria(cat)){
                    JOptionPane.showMessageDialog(this,"Categoria eliminada");
                    BuscarDatos();
                    //listarTbCat();
                }
            }else{
                JOptionPane.showMessageDialog(this,"La categoria no se ha eliminado");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Seleccione una categoria de la tabla para poder Eliminarla");
        }
    }//GEN-LAST:event_btnBorrarCatActionPerformed

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        // TODO add your handling code here:
        btnGuardarCat.setEnabled(true);
        btnCrear.setEnabled(false);
        editablesCat();
    }//GEN-LAST:event_btnCrearActionPerformed

    private void txtNombreCatKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreCatKeyTyped
        // TODO add your handling code here:
        char vNombreCat = evt.getKeyChar();
        boolean asciiBS = vNombreCat == 8;
        boolean asciiSP = vNombreCat == 32;
        boolean asciiSH = vNombreCat == 16;
        int cNombreCat = txtNombreCat.getText().length(); 
        
        if(!Character.isLetter(vNombreCat) && !asciiBS && !asciiSP && !asciiSH){
            //getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Para el nombre de la categoria solo se permite ingresar letras", "Formato de dato invalido", JOptionPane.INFORMATION_MESSAGE);
        }
        
        if(cNombreCat >= 20){
            evt.consume();
        }
    }//GEN-LAST:event_txtNombreCatKeyTyped

    private void txtDescripcionCatKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescripcionCatKeyTyped
        // TODO add your handling code here:
        int cDescripcionCat = txtDescripcionCat.getText().length(); 
        
        if(cDescripcionCat >= 150){
            evt.consume();
        }
    }//GEN-LAST:event_txtDescripcionCatKeyTyped

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
        /*BuscarDatos();
        listarTbCat();
        bloquearCat();
        limpiarCat();*/
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        bloquearCat();
        limpiarCat();
        btnCrear.setEnabled(true);
        btnGuardarCat.setEnabled(false);
        btnActualizar.setEnabled(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        BuscarDatos();
        //listarTbCat();
        bloquearCat();
        limpiarCat();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btnMenuActionPerformed

    private void btnProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductosActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btnProductosActionPerformed

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
            java.util.logging.Logger.getLogger(categorias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(categorias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(categorias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(categorias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new categorias().setVisible(true);
            }
        });
    }
     
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBorrarCat;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCrear;
    private javax.swing.JButton btnEditarCat;
    private javax.swing.JButton btnGuardarCat;
    private javax.swing.JButton btnMenu;
    private javax.swing.JButton btnProductos;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblDescripcionCat;
    private javax.swing.JLabel lblInsertarCat;
    private javax.swing.JLabel lblListarCat;
    private javax.swing.JLabel lblNombreCat;
    private javax.swing.JTable tbListarCat;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextArea txtDescripcionCat;
    private javax.swing.JTextField txtNombreCat;
    // End of variables declaration//GEN-END:variables

}
