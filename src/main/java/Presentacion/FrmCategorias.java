
package Presentacion;

import Presentacion.views.Principal_Administrador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.TableRowSorter;
import Negocios.CategoriaControl;
import javax.swing.JOptionPane;

public class FrmCategorias extends javax.swing.JPanel {
    private Principal_Administrador pr;
    private final CategoriaControl CONTROL;
    private String accion;
    private String nombreAnt;

    public FrmCategorias(Principal_Administrador principal) {
        initComponents();
        this.pr=principal;
        btnRegresar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                pr.activarBotones();
                pr.principal();
            }
        });
        this.CONTROL=new CategoriaControl();
        this.listar("");
        tablaGeneral.setEnabledAt(1, false);
        this.accion="guardar";
        txtId.setVisible(false);
    }
    
    private void listar(String texto){
        tablaListado.setModel(this.CONTROL.listar(texto));
        TableRowSorter orden= new TableRowSorter(tablaListado.getModel());
        tablaListado.setRowSorter(orden);
        lblRegistros.setText("MOSTRADO " + this.CONTROL.totalMostrados() + " DE UN TOTAL DE " + this.CONTROL.total() + " REGISTROS");
    }
    
    private void limpiar(){
        txtNombre.setText("");
        txtDescripcion.setText("");
        this.accion="guardar";
    }
    
    private void mensajeError(String mensaje){
        JOptionPane.showMessageDialog(this, mensaje,"Sistema",JOptionPane.ERROR_MESSAGE);
    }
    
    private void mensajeOk(String mensaje){
        JOptionPane.showMessageDialog(this, mensaje,"Sistema",JOptionPane.INFORMATION_MESSAGE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        tablaGeneral = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        btnRegresar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaListado = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        btnActivar = new javax.swing.JButton();
        btnDesactivar = new javax.swing.JButton();
        lblRegistros = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        btnCancelar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        txtNombre = new javax.swing.JTextField();
        txtId = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tablaGeneral.setBackground(new java.awt.Color(255, 255, 255));
        tablaGeneral.setForeground(new java.awt.Color(0, 0, 0));
        tablaGeneral.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        btnRegresar.setBackground(new java.awt.Color(0, 204, 204));
        btnRegresar.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        btnRegresar.setForeground(new java.awt.Color(204, 204, 204));
        btnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/arrow-80-16.png"))); // NOI18N
        btnRegresar.setText("REGRESAR");
        btnRegresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegresar.setIconTextGap(10);

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("NOMBRE DE LA CATEGORÍA");

        txtBuscar.setBackground(new java.awt.Color(204, 204, 204));
        txtBuscar.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txtBuscar.setForeground(new java.awt.Color(0, 0, 0));
        txtBuscar.setHighlighter(null);

        btnBuscar.setBackground(new java.awt.Color(0, 204, 204));
        btnBuscar.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(204, 204, 204));
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/zoom-16.png"))); // NOI18N
        btnBuscar.setText("BUSCAR");
        btnBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscar.setIconTextGap(10);
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnRegistrar.setBackground(new java.awt.Color(0, 204, 204));
        btnRegistrar.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        btnRegistrar.setForeground(new java.awt.Color(204, 204, 204));
        btnRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/save-16.png"))); // NOI18N
        btnRegistrar.setText("REGISTRAR");
        btnRegistrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegistrar.setIconTextGap(10);
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnEditar.setBackground(new java.awt.Color(0, 204, 204));
        btnEditar.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(204, 204, 204));
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edit-2-16.png"))); // NOI18N
        btnEditar.setText("EDITAR");
        btnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditar.setIconTextGap(10);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setForeground(new java.awt.Color(255, 255, 255));

        tablaListado.setBackground(new java.awt.Color(255, 255, 255));
        tablaListado.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        tablaListado.setForeground(new java.awt.Color(0, 0, 0));
        tablaListado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaListado);

        jLabel2.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("NÚMERO DE PÁGINAS");

        jComboBox1.setBackground(new java.awt.Color(204, 204, 204));
        jComboBox1.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jComboBox1.setForeground(new java.awt.Color(0, 0, 0));

        jLabel3.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("NÚMERO DE REGISTROS POR PÁGINAS");

        jComboBox2.setBackground(new java.awt.Color(204, 204, 204));
        jComboBox2.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jComboBox2.setForeground(new java.awt.Color(0, 0, 0));

        btnActivar.setBackground(new java.awt.Color(153, 255, 255));
        btnActivar.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        btnActivar.setForeground(new java.awt.Color(0, 0, 0));
        btnActivar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/activar.png"))); // NOI18N
        btnActivar.setText("ACTIVAR CATEGORÍA");
        btnActivar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnActivar.setIconTextGap(10);
        btnActivar.setPreferredSize(new java.awt.Dimension(172, 33));
        btnActivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActivarActionPerformed(evt);
            }
        });

        btnDesactivar.setBackground(new java.awt.Color(153, 255, 255));
        btnDesactivar.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        btnDesactivar.setForeground(new java.awt.Color(0, 0, 0));
        btnDesactivar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/apagar.png"))); // NOI18N
        btnDesactivar.setText("DESACTIVAR CATEGORÍA");
        btnDesactivar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDesactivar.setIconTextGap(10);
        btnDesactivar.setPreferredSize(new java.awt.Dimension(172, 33));
        btnDesactivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivarActionPerformed(evt);
            }
        });

        lblRegistros.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        lblRegistros.setForeground(new java.awt.Color(0, 0, 0));
        lblRegistros.setText("REGISTROS");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(btnActivar, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDesactivar, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(lblRegistros, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(txtBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                                .addGap(50, 50, 50)
                                .addComponent(btnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnRegistrar, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                                .addGap(4, 4, 4))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar)
                    .addComponent(btnRegistrar)
                    .addComponent(btnEditar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 594, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActivar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDesactivar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRegistros))
                .addGap(29, 29, 29))
        );

        tablaGeneral.addTab("LISTA", jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("NOMBRE DE LA CATEGORÍA");

        jLabel6.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("DESCRIPCIÓN");

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));

        txtDescripcion.setBackground(new java.awt.Color(204, 204, 204));
        txtDescripcion.setColumns(20);
        txtDescripcion.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txtDescripcion.setForeground(new java.awt.Color(0, 0, 0));
        txtDescripcion.setRows(5);
        jScrollPane2.setViewportView(txtDescripcion);

        btnCancelar.setBackground(new java.awt.Color(0, 204, 204));
        btnCancelar.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(204, 204, 204));
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/close.gif"))); // NOI18N
        btnCancelar.setText("CANCELAR");
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelar.setIconTextGap(10);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnGuardar.setBackground(new java.awt.Color(0, 204, 204));
        btnGuardar.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(204, 204, 204));
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/save-16.png"))); // NOI18N
        btnGuardar.setText("GUARDAR");
        btnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardar.setIconTextGap(10);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        txtNombre.setBackground(new java.awt.Color(204, 204, 204));
        txtNombre.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txtNombre.setForeground(new java.awt.Color(0, 0, 0));
        txtNombre.setHighlighter(null);

        txtId.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtId.setForeground(new java.awt.Color(255, 0, 51));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(96, 96, 96)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(216, 216, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCancelar)
                    .addComponent(btnGuardar))
                .addContainerGap(521, Short.MAX_VALUE))
        );

        tablaGeneral.addTab("FORMULARIO", jPanel3);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tablaGeneral)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tablaGeneral)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        this.listar(txtBuscar.getText());
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        // TODO add your handling code here:
        tablaGeneral.setEnabledAt(1, true);
        tablaGeneral.setEnabledAt(0, false);
        tablaGeneral.setSelectedIndex(1);
        this.accion="guardar";
        btnGuardar.setText("Guardar");
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        tablaGeneral.setEnabledAt(0, true);
        tablaGeneral.setEnabledAt(1, false);
        tablaGeneral.setSelectedIndex(0);
        this.limpiar();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        if (txtNombre.getText().length()==0 || txtNombre.getText().length()>50){
            JOptionPane.showMessageDialog(this, "Debes ingresar un nombre y no debe ser mayor a 50 caracteres, es obligatorio.","Sistema", JOptionPane.WARNING_MESSAGE);
            txtNombre.requestFocus();
            return;
        }
        if (txtDescripcion.getText().length()>500){
            JOptionPane.showMessageDialog(this, "Debes ingresar una descripción no mayor a 500 caracteres.","Sistema", JOptionPane.WARNING_MESSAGE);
            txtDescripcion.requestFocus();
            return;
        }
        String resp;
        if (this.accion.equals("editar")){
            //Editar
            resp=this.CONTROL.actualizar(Integer.parseInt(txtId.getText()),txtNombre.getText(),this.nombreAnt, txtDescripcion.getText());
            if(resp.equals("OK")){
                this.mensajeOk("Actualizado correctamente");
                this.limpiar();
                this.listar("");                
                tablaGeneral.setSelectedIndex(0);
                tablaGeneral.setEnabledAt(1, false);
                tablaGeneral.setEnabledAt(0, true);
            }else{
                this.mensajeError(resp);
            }
        }else{
            //guardar
            resp=this.CONTROL.insertar(txtNombre.getText(), txtDescripcion.getText());
            if(resp.equals("OK")){
                this.mensajeOk("Registrado correctamente");
                this.limpiar();
                this.listar("");
                tablaGeneral.setEnabledAt(0, true);
                tablaGeneral.setEnabledAt(1, false);
                tablaGeneral.setSelectedIndex(0);
        this.limpiar();
            }else{
                this.mensajeError(resp);
            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
        if (tablaListado.getSelectedRowCount()==1){
            String id= String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(),0));
            String nombre= String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(),1));
            this.nombreAnt= String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(),1));
            String descripcion= String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(),2));
            
            txtId.setText(id);
            txtNombre.setText(nombre);
            txtDescripcion.setText(descripcion);
            
            tablaGeneral.setEnabledAt(0, false);
            tablaGeneral.setEnabledAt(1, true);
            tablaGeneral.setSelectedIndex(1);
            this.accion="editar";
            btnGuardar.setText("Editar");
        }else{
            this.mensajeError("Seleccione 1 registro a editar.");
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnDesactivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivarActionPerformed
        // TODO add your handling code here:
        if (tablaListado.getSelectedRowCount() == 1) {
            String id= String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(),0));
            String nombre= String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(),1));
            
            if(JOptionPane.showConfirmDialog(this,"Deseas desactivar el registro: " + nombre + " ?", "Desactivar", JOptionPane.YES_NO_OPTION)==0){
                String resp=this.CONTROL.desactivar(Integer.parseInt(id));
                if (resp.equals("OK")){
                    this.mensajeOk("Registro desactivado");
                    this.listar("");
                }else{
                    this.mensajeError(resp);
                }
            }
        } else {
            this.mensajeError("Seleccione 1 registro a desactivar.");
        }
    }//GEN-LAST:event_btnDesactivarActionPerformed

    private void btnActivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActivarActionPerformed
        // TODO add your handling code here:
        if (tablaListado.getSelectedRowCount() == 1) {
            String id= String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(),0));
            String nombre= String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(),1));
            
            if(JOptionPane.showConfirmDialog(this,"Deseas activar el registro: " + nombre + " ?", "Activar", JOptionPane.YES_NO_OPTION)==0){
                String resp=this.CONTROL.activar(Integer.parseInt(id));
                if (resp.equals("OK")){
                    this.mensajeOk("Registro activado");
                    this.listar("");
                }else{
                    this.mensajeError(resp);
                }
            }
        } else {
            this.mensajeError("Seleccione 1 registro a activar.");
        }
    }//GEN-LAST:event_btnActivarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActivar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnDesactivar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblRegistros;
    private javax.swing.JTabbedPane tablaGeneral;
    private javax.swing.JTable tablaListado;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JLabel txtId;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
