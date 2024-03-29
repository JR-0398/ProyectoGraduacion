/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Pantallas;

import com.dao.controlCategoria;
import com.modelo.categoria;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
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
    
    private void listarTbCat() {
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
    }
    
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
    
    private void hideIdCat(){
        lblCodigo.setVisible(false);
    }
    
    private void hideTb(){
        tbListarCat.getColumnModel().getColumn(0).setMinWidth(1);
        tbListarCat.getColumnModel().getColumn(0).setMaxWidth(1);
        tbListarCat.getColumnModel().getColumn(0).setWidth(1);
    }

    /**
     * Creates new form categorias
     */
    public categorias() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/images/banana.png")).getImage());
        listarTbCat();
        bloquearCat();
        hideIdCat();
        hideTb();
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
        lblListarCat = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnCargarTb = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Control de categorias");
        setResizable(false);

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
        btnGuardarCat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/_active__save.png"))); // NOI18N
        btnGuardarCat.setText("Guardar");
        btnGuardarCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarCatActionPerformed(evt);
            }
        });

        btnActualizar.setBackground(new java.awt.Color(204, 204, 255));
        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/_active__save_all.png"))); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnCrear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ico30.png"))); // NOI18N
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons26.png"))); // NOI18N
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator3)
            .addComponent(jSeparator2)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(btnCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(btnGuardarCat)
                        .addGap(18, 18, 18)
                        .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(75, 75, 75)
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
                        .addGap(206, 206, 206)
                        .addComponent(lblInsertarCat)))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lblInsertarCat)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnGuardarCat)
                            .addComponent(btnActualizar))))
                .addContainerGap(15, Short.MAX_VALUE))
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
        btnEditarCat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/modificar.png"))); // NOI18N
        btnEditarCat.setText("Editar");
        btnEditarCat.setToolTipText("");
        btnEditarCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarCatActionPerformed(evt);
            }
        });

        btnBorrarCat.setBackground(new java.awt.Color(204, 204, 255));
        btnBorrarCat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/wastebasket48.png"))); // NOI18N
        btnBorrarCat.setText("Eliminar");
        btnBorrarCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarCatActionPerformed(evt);
            }
        });

        lblListarCat.setText("INFORMACION DE CATEGORIAS");

        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });

        btnBuscar.setBackground(new java.awt.Color(204, 204, 255));
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glass30.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnCargarTb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/update.png"))); // NOI18N
        btnCargarTb.setText("Recargar");
        btnCargarTb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarTbActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(227, 227, 227)
                        .addComponent(lblListarCat))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBorrarCat, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEditarCat, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCargarTb))))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(lblListarCat)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnEditarCat)
                        .addGap(18, 18, 18)
                        .addComponent(btnBorrarCat, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCargarTb, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(8, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
        if(txtNombreCat.getText().equals("")||txtDescripcionCat.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Verfique la informacion ingresada, ya que uno o ambos datos solicitados estan vacios", "Datos vacios", JOptionPane.ERROR_MESSAGE);
        }else if(txtNombreCat.getText().length() <= 4 ){
            JOptionPane.showMessageDialog(null, "El nombre de la caterogia debe tener al menos 5 caracteres", "Nombre de categoria incompleto", JOptionPane.WARNING_MESSAGE);
        }else{
            //if (controlCat.existeUsuario(txtNombreCat.getText()) == 0) {
            cat.setId_categoria(Integer.parseInt(lblCodigo.getText()));
            cat.setCatNombre(txtNombreCat.getText());
            cat.setCatDescripcion(txtDescripcionCat.getText());
            if (controlCat.editarCategoria(cat)){
                JOptionPane.showMessageDialog(this,"Se ha modificado la categoria", "Cambios realizados", JOptionPane.INFORMATION_MESSAGE);
                listarTbCat();
                limpiarCat();
                bloquearCat();
                //btnGuardarCat.setEnabled(true);
                btnActualizar.setEnabled(false);
            }else{
                JOptionPane.showMessageDialog(this,"Ha ocurrido un error, modifique la categoria nuevamente", "Error", JOptionPane.ERROR_MESSAGE);
            }    
            /*}else{
                JOptionPane.showMessageDialog(null, "La categoria ya existe, verifique la informacion","Categoria duplicada", JOptionPane.WARNING_MESSAGE);
            }*/
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnGuardarCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarCatActionPerformed
        // TODO add your handling code here:
        if(txtNombreCat.getText().equals("")||txtDescripcionCat.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Verfique la informacion ingresada, ya que uno o ambos datos solicitados estan vacios", "Datos vacios", JOptionPane.ERROR_MESSAGE);
        }else if(txtNombreCat.getText().length() <= 4 ){
            JOptionPane.showMessageDialog(null, "El nombre de la caterogia debe tener al menos 5 caracteres", "Nombre de categoria incompleto", JOptionPane.WARNING_MESSAGE);
        }else{
            if (controlCat.existeCategoria(txtNombreCat.getText()) == 0) {
                cat.setCatNombre(txtNombreCat.getText()); 
                cat.setCatDescripcion(txtDescripcionCat.getText());
                //this.lblNombreCat.setText(this.cat.getCategoria());
                //this.lblDescripcionCat.setText(this.cat.getDescripcionCat());
                if (controlCat.ingresarCategorias(cat)){
                    JOptionPane.showMessageDialog(this,"La categoria ha sido creada", "Categoria guardada", JOptionPane.INFORMATION_MESSAGE);
                    listarTbCat();
                    limpiarCat();
                    bloquearCat();
                    btnCrear.setEnabled(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Error al guardar la categoria, revise la informacion.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }else{
                JOptionPane.showMessageDialog(null, "La categoria ya existe, verifique la informacion","Categoria duplicada", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnGuardarCatActionPerformed

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
        bloquearCat();
        limpiarCat();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
        /*BuscarDatos();
        listarTbCat();
        bloquearCat();
        limpiarCat();*/
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void btnBorrarCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarCatActionPerformed
        // TODO add your handling code here:
               
        int fila = this.tbListarCat.getSelectedRow();
        int id = Integer.parseInt(this.tbListarCat.getValueAt(fila, 0).toString());
        int nCat = controlCat.BorrarCategoria(id);
        if (fila >= 0 && nCat == 0){
            //String id = this.tbListarCat.getValueAt(fila, 0).toString();
            String catNombre = this.tbListarCat.getValueAt(fila, 1).toString();
            this.cat.setId_categoria(id);
            int resp = JOptionPane.showConfirmDialog(null, "¿Desea eliminar la categoria "+catNombre+"?", "Advertencia", JOptionPane.YES_NO_OPTION);
            if (resp==JOptionPane.YES_OPTION){
                if (controlCat.EliminarCategoria(cat)){
                    JOptionPane.showMessageDialog(this,"La categoria se ha eliminado", "Categoria elminada", JOptionPane.INFORMATION_MESSAGE);
                    //BuscarDatos();
                    listarTbCat();
                }
            }else{
                JOptionPane.showMessageDialog(this,"Se ha cancelado la eliminacion de la categoria", "Cancelar, la categoria no se ha eliminado", JOptionPane.ERROR_MESSAGE);
            }
        }else if(fila >= 0 && nCat > 0){
            JOptionPane.showMessageDialog(this,"Actualmente esta categoria tiene asociado/os "+nCat+" articulo/os por lo tanto no se puede elminar", "Error no se puede borrar la categoria", JOptionPane.ERROR_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null, "Seleccione una categoria de la tabla para poder eliminar la informacion", "Seleccione una fila de la tabla", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnBorrarCatActionPerformed

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
            JOptionPane.showMessageDialog(null, "Seleccione una categoria de la tabla para poder editar su información", "Seleccione una fila de la tabla", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnEditarCatActionPerformed

    private void tbListarCatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbListarCatMouseClicked
        // TODO add your handling code here:
        /*this.txtNombreCat.setText(tbListarCat.getValueAt(tbListarCat.getSelectedRow(),1).toString());
        this.txtDescripcionCat.setText(tbListarCat.getValueAt(tbListarCat.getSelectedRow(),2).toString());
        this.lblCodigo.setText(tbListarCat.getValueAt(tbListarCat.getSelectedRow(),0).toString());*/
    }//GEN-LAST:event_tbListarCatMouseClicked

    private void btnCargarTbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarTbActionPerformed
        // TODO add your handling code here:
        listarTbCat();
        bloquearCat();
        limpiarCat();
    }//GEN-LAST:event_btnCargarTbActionPerformed

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
    private javax.swing.JButton btnCargarTb;
    private javax.swing.JButton btnCrear;
    private javax.swing.JButton btnEditarCat;
    private javax.swing.JButton btnGuardarCat;
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
