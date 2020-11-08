/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import CONECTAR.Conexion;
//import com.placeholder.PlaceHolder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Davi_
 */
public class Proveedor extends javax.swing.JFrame {

    DefaultTableModel modeloproveedor;
    private String id;
    Conexion cc = new Conexion();
    Connection cn = cc.conexion();
    //PlaceHolder holder;

    public Proveedor() {
        initComponents();
        this.setTitle("Proveedores");
        this.setLocation(400, 150);
        cargar();
        autoid();
        //holder = new PlaceHolder(txt_buscar, "Buscar");
        setIconImage(new ImageIcon(getClass().getResource("../Imagenes/iconrecarga.png")).getImage());

    }

    private void autoid() {
        try {
            String sql = "Select numero from generarproveedor order by numero DESC limit 1";
            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                String numero = rs.getString("numero");
                int co = numero.length();
                String txt = numero.substring(0, 2);
                String num = numero.substring(2, co);
                int n = Integer.parseInt(num);
                n++;
                String snum = Integer.toString(n);
                String ftxt = txt + snum;
                txt_id.setText(ftxt);
            } else {
                JOptionPane.showMessageDialog(null, "exito");
            }
        } catch (NumberFormatException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void limpiar_proveedor() {
        this.txt_id.setText("");
        this.txt_nombre.setText("");
        this.txt_telefono.setText("");
        this.txt_correo.setText("");
        this.cbox_compañia.setSelectedIndex(0);
        autoid();
    }
    //cargar los dato de la base de datos a la tabla 

    public void cargar() {
        String[] titulos = {"Id", "Nombre", "Compañia", "Telefono", "Correo"};
        String[] registros = new String[100];

        String sql = "Select * from proveedor";
        modeloproveedor = new DefaultTableModel(null, titulos);
        //Conexion cc = new Conexion();
        //Connection cn = cc.conexion();
        try {
            Statement st = (Statement) cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                registros[0] = rs.getString("idProveedor");
                registros[1] = rs.getString("NombreProveedor");
                registros[2] = rs.getString("Compañia");
                registros[3] = rs.getString("TelefonoProveedor");
                registros[4] = rs.getString("CorreoProveedor");
                modeloproveedor.addRow(registros);

            }
            tb_proveedor.setModel(modeloproveedor);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_id = new javax.swing.JTextField();
        txt_nombre = new javax.swing.JTextField();
        cbox_compañia = new javax.swing.JComboBox<>();
        txt_telefono = new javax.swing.JTextField();
        txt_correo = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        btn_agregar = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();
        btn_modificar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txt_buscar = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_proveedor = new javax.swing.JTable();
        btm_limpiar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator1.setAlignmentX(1.0F);
        jSeparator1.setAlignmentY(1.0F);
        jSeparator1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 470, 10));

        jLabel2.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        jLabel2.setText("ID_Proveedor");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        jLabel3.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        jLabel3.setText("Nombre");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, -1, -1));

        jLabel4.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        jLabel4.setText("Compañia");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, -1, -1));

        jLabel5.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        jLabel5.setText("Telefono:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 130, -1, -1));

        jLabel6.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        jLabel6.setText("Correo:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 180, -1, -1));
        getContentPane().add(txt_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, 60, -1));

        txt_nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_nombreKeyTyped(evt);
            }
        });
        getContentPane().add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 100, -1));

        cbox_compañia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "TELCEL", "MOVISTAR" }));
        getContentPane().add(cbox_compañia, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, 100, -1));

        txt_telefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_telefonoActionPerformed(evt);
            }
        });
        txt_telefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_telefonoKeyTyped(evt);
            }
        });
        getContentPane().add(txt_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 130, 110, -1));

        txt_correo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_correoActionPerformed(evt);
            }
        });
        getContentPane().add(txt_correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 180, 110, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/atrasflecha.png"))); // NOI18N
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 40));

        btn_agregar.setText("AGREGAR");
        btn_agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agregarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_agregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 120, 90, 40));

        btn_eliminar.setText("ELIMINAR");
        btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 180, 90, 40));

        btn_modificar.setText("ACTUALIZAR");
        btn_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modificarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 240, 100, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buscarbien.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, -1, -1));

        txt_buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_buscarKeyPressed(evt);
            }
        });
        getContentPane().add(txt_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, 170, 30));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/proveedoresbien.png"))); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 0, 130, 100));

        tb_proveedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tb_proveedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_proveedorMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tb_proveedor);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 590, 210));

        btm_limpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/limpiarbien.png"))); // NOI18N
        btm_limpiar.setBorderPainted(false);
        btm_limpiar.setContentAreaFilled(false);
        btm_limpiar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btm_limpiar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/limpiachico.png"))); // NOI18N
        btm_limpiar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/limpiagrande.png"))); // NOI18N
        btm_limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btm_limpiarActionPerformed(evt);
            }
        });
        getContentPane().add(btm_limpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 210, 80, 70));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_telefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_telefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_telefonoActionPerformed

    private void txt_correoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_correoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_correoActionPerformed
    //boton REGRESAR
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
        Gerente ge = new Gerente();
        ge.setId(id);
        ge.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed
    //TextFiel buscar proveedores en la tabla 
    private void txt_buscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_buscarKeyPressed
        String[] titulos = {"idProveedor", "NombreProveedor", "Compañia", "TelefonoProveedor", "CorreoProveedor"};
        String[] registros = new String[50];

        String sql = "Select * from proveedor where idProveedor like '%" + txt_buscar.getText() + "%'"
                + "OR NombreProveedor like '%" + txt_buscar.getText() + "%'"
                + "OR Compañia like '%" + txt_buscar.getText() + "%'";
        modeloproveedor = new DefaultTableModel(null, titulos);
        try {
            Statement st = (Statement) cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                registros[0] = rs.getString("idProveedor");
                registros[1] = rs.getString("NombreProveedor");
                registros[2] = rs.getString("Compañia");
                registros[3] = rs.getString("TelefonoProveedor");
                registros[4] = rs.getString("CorreoProveedor");
                modeloproveedor.addRow(registros);
            }
            tb_proveedor.setModel(modeloproveedor);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_txt_buscarKeyPressed
    //poner datos en los TextField desde la base de datos
    private void tb_proveedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_proveedorMouseClicked
        limpiar_proveedor();
        int col = tb_proveedor.getSelectedRow();
        txt_id.setText(tb_proveedor.getModel().getValueAt(col, 0).toString());
        txt_nombre.setText(tb_proveedor.getModel().getValueAt(col, 1).toString());
         cbox_compañia.getModel().setSelectedItem(String.valueOf(tb_proveedor.getModel().getValueAt(col, 2)));
        txt_telefono.setText(tb_proveedor.getModel().getValueAt(col, 3).toString());
        txt_correo.setText(tb_proveedor.getModel().getValueAt(col, 4).toString());
    }//GEN-LAST:event_tb_proveedorMouseClicked
    //boton agregar
    private void btn_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregarActionPerformed
        //String verut =null;
        Statement st = null;
        String datos[] = new String[100];
        datos[0] = txt_id.getText();
        datos[1] = txt_nombre.getText();
        datos[2] = cbox_compañia.getSelectedItem().toString();
        datos[3] = txt_telefono.getText();
        datos[4] = txt_correo.getText();
        for (int i = 0; i < tb_proveedor.getRowCount(); i++) {
            if (tb_proveedor.getValueAt(i, 0).equals(datos[0])) {
                JOptionPane.showMessageDialog(null, "Duplicado");
                limpiar_proveedor();
                txt_id.requestFocus();
            }
        }
        if (datos[0].equals("") || datos[1].equals("") || cbox_compañia.getSelectedItem().equals("Seleccionar") || datos[3].equals("") || datos[4].equals("")) {
            JOptionPane.showMessageDialog(null, "Debes llenar todos los campos o Cambiar la opcion Seleccionar ");
            txt_id.requestFocus();

        } else {
            try {
                String sql = ("insert proveedor(idProveedor,NombreProveedor,Compañia,TelefonoProveedor,CorreoProveedor) values(?,?,?,?,?)");
                st = cn.createStatement();
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setString(1, datos[0]);
                ps.setString(2, datos[1]);
                ps.setString(3, datos[2]);
                ps.setString(4, datos[3]);
                ps.setString(5, datos[4]);
                ps.executeUpdate();
                modeloproveedor.addRow(datos);
                JOptionPane.showMessageDialog(null, "Agregado correctamente");
            } catch (SQLException e) {
                Logger.getLogger(Proveedor.class.getName()).log(Level.SEVERE, null, "error");
            }

            limpiar_proveedor();
        }
    }//GEN-LAST:event_btn_agregarActionPerformed
    //boton eliminar
    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed

        Statement st = null;
        String datos[] = new String[100];
        datos[0] = txt_id.getText();
        if (datos[0].equals("")) {
            JOptionPane.showMessageDialog(null, "Debes ingresar el id que desea eliminar");
        } else {
            String sql = "delete  from proveedor where idProveedor='" + datos[0] + "'";
            try {
                st = cn.createStatement();
                st.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Eliminado");
            } catch (SQLException ex) {
                Logger.getLogger(Proveedor.class.getName()).log(Level.SEVERE, null, ex);
            }
            int proveedor = tb_proveedor.getSelectedRow();
            modeloproveedor.removeRow(proveedor);
            limpiar_proveedor();
        }
    }//GEN-LAST:event_btn_eliminarActionPerformed
    //boton actualizar
    private void btn_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificarActionPerformed
        Statement st = null;
        String datos[] = new String[100];
        datos[0] = txt_id.getText();
        datos[1] = txt_nombre.getText();
        datos[2] = cbox_compañia.getSelectedItem().toString();
        datos[3] = txt_telefono.getText();
        datos[4] = txt_correo.getText();

        if (datos[0].equals("") || datos[1].equals("") || cbox_compañia.getSelectedItem().equals("Seleccionar") || datos[3].equals("") || datos[4].equals("")) {
            JOptionPane.showMessageDialog(null, "Debes llenar todos los campos o Cambiar la opcion Seleccionar ");
            txt_id.requestFocus();

        } else {
            String sql = "update proveedor set idProveedor='" + datos[0] + "',NombreProveedor='" + datos[1] + "',Compañia='" + datos[2] + "',TelefonoProveedor='" + datos[3] + "',CorreoProveedor='" + datos[4] + "' where idProveedor='" + datos[0] + "'";
            try {
                st = cn.createStatement();
                st.executeUpdate(sql);

                JOptionPane.showMessageDialog(null, "Actualizado correctamente");
            } catch (SQLException e) {
                Logger.getLogger(Proveedor.class.getName()).log(Level.SEVERE, null, e);
            }

            limpiar_proveedor();
        }
    }//GEN-LAST:event_btn_modificarActionPerformed
    //validar solo numeros 
    private void txt_telefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_telefonoKeyTyped
        int c = evt.getKeyChar();
        if ((c < '0' || c > '9')) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_telefonoKeyTyped
    //validar solo letras
    private void txt_nombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nombreKeyTyped
        char c = evt.getKeyChar();
        if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && (c < ' ' || c > ' ')) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_nombreKeyTyped

    private void btm_limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btm_limpiarActionPerformed
        limpiar_proveedor();
    }//GEN-LAST:event_btm_limpiarActionPerformed

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
            java.util.logging.Logger.getLogger(Proveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Proveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Proveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Proveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Proveedor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btm_limpiar;
    private javax.swing.JButton btn_agregar;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_modificar;
    private javax.swing.JComboBox<String> cbox_compañia;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tb_proveedor;
    private javax.swing.JTextField txt_buscar;
    private javax.swing.JTextField txt_correo;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_telefono;
    // End of variables declaration//GEN-END:variables

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
