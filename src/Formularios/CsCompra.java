/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import CONECTAR.Conexion;

//import com.placeholder.PlaceHolder;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Davi_
 */
public class CsCompra extends javax.swing.JFrame {

    Conexion cc = new Conexion();
    Connection cn = cc.conexion();
    DefaultTableModel modeloCompra;
    Calendar fecha = new GregorianCalendar();
    private String id;
  //  PlaceHolder holder;

    public CsCompra() {
        initComponents();
        this.setTitle("Lista de compras");
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.WHITE);
        this.setResizable(false);
        cargar();
       // txt_fechaactual.setCalendar(fecha);
        //holder = new PlaceHolder(txt_idproveedor, "pr00");
        //holder = new PlaceHolder(txt_buscar, "Buscar");
        setIconImage(new ImageIcon(getClass().getResource("../Imagenes/iconrecarga.png")).getImage());
        autoid();
    }

    private void autoid() {
        try {
            String sql = "Select numero from generarcompra order by numero DESC limit 1";
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
                txt_idcompra.setText(ftxt);
            } else {
                JOptionPane.showMessageDialog(null, "exito");
            }
        } catch (NumberFormatException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void limpiarCompra() {
        txt_idcompra.setText("");
        txt_idproveedor.setText("");
        txt_idtrabajador.setText(id);
        txt_compañia.setText("");
        txt_monto.setText("");
        //txt_fechaactual.setCalendar(fecha);
        autoid();
    }

    public void cargar() {

        String titulos[] = {"ID_Compra", "ID_Proveedor", "ID_Trabajador", "Compañia", "saldoComprado", "Fecha"};
        String registros[] = new String[100];

        String sql = "Select* from compra";
        modeloCompra = new DefaultTableModel(null, titulos);
        Connection cn = cc.conexion();
        try {
            Statement st = (Statement) cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                registros[0] = rs.getString("idCompra");
                registros[1] = rs.getString("idProveedor");
                registros[2] = rs.getString("idTrabajador");
                registros[3] = rs.getString("CompañiaCompra");
                registros[4] = rs.getString("saldoComprado");
                registros[5] = rs.getString("Fecha");
                modeloCompra.addRow(registros);
            }
            tb_compra.setModel(modeloCompra);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_idcompra = new javax.swing.JTextField();
        txt_idproveedor = new javax.swing.JTextField();
        txt_idtrabajador = new javax.swing.JTextField();
        txt_compañia = new javax.swing.JTextField();
        txt_monto = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_compra = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        txt_buscar = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btn_atras = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();
        btn_modificar = new javax.swing.JButton();
        btn_limpiar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("DialogInput", 1, 12)); // NOI18N
        jLabel1.setText("ID");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 20, 30));

        jLabel2.setFont(new java.awt.Font("DialogInput", 1, 12)); // NOI18N
        jLabel2.setText("ID_Proveedor");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, -1, -1));

        jLabel3.setFont(new java.awt.Font("DialogInput", 1, 12)); // NOI18N
        jLabel3.setText("ID_Trabajador");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, -1, 20));

        jLabel4.setFont(new java.awt.Font("DialogInput", 1, 12)); // NOI18N
        jLabel4.setText("Compañia");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 70, -1, -1));

        jLabel5.setFont(new java.awt.Font("DialogInput", 1, 12)); // NOI18N
        jLabel5.setText("Saldo/Monto");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 110, -1, -1));

        jLabel6.setFont(new java.awt.Font("DialogInput", 1, 12)); // NOI18N
        jLabel6.setText("Fecha");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 160, -1, -1));

        txt_idcompra.setFont(new java.awt.Font("DialogInput", 1, 12)); // NOI18N
        getContentPane().add(txt_idcompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 40, 30));

        txt_idproveedor.setFont(new java.awt.Font("DialogInput", 1, 12)); // NOI18N
        getContentPane().add(txt_idproveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 50, 30));

        txt_idtrabajador.setFont(new java.awt.Font("DialogInput", 1, 12)); // NOI18N
        txt_idtrabajador.setEnabled(false);
        txt_idtrabajador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_idtrabajadorActionPerformed(evt);
            }
        });
        getContentPane().add(txt_idtrabajador, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, 60, 30));

        txt_compañia.setFont(new java.awt.Font("DialogInput", 1, 12)); // NOI18N
        txt_compañia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_compañiaActionPerformed(evt);
            }
        });
        getContentPane().add(txt_compañia, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 70, 100, -1));

        txt_monto.setFont(new java.awt.Font("DialogInput", 1, 12)); // NOI18N
        txt_monto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_montoActionPerformed(evt);
            }
        });
        getContentPane().add(txt_monto, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 110, 100, -1));

        tb_compra.setModel(new javax.swing.table.DefaultTableModel(
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
        tb_compra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_compraMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_compra);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 680, 250));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 710, 10));

        txt_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_buscarActionPerformed(evt);
            }
        });
        txt_buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_buscarKeyPressed(evt);
            }
        });
        getContentPane().add(txt_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 10, 130, 30));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buscarbien.png"))); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, -1, -1));

        btn_atras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/atrasflecha.png"))); // NOI18N
        btn_atras.setBorderPainted(false);
        btn_atras.setContentAreaFilled(false);
        btn_atras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_atrasActionPerformed(evt);
            }
        });
        getContentPane().add(btn_atras, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 40));

        btn_eliminar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btn_eliminar.setText("ELIMINAR");
        btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 100, 120, 40));

        btn_modificar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btn_modificar.setText("ACTUALIZAR");
        btn_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modificarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 150, -1, 40));

        btn_limpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/limpiarbien.png"))); // NOI18N
        btn_limpiar.setBorderPainted(false);
        btn_limpiar.setContentAreaFilled(false);
        btn_limpiar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_limpiar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/limpiachico.png"))); // NOI18N
        btn_limpiar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/limpiagrande.png"))); // NOI18N
        btn_limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_limpiarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_limpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 200, 80, 70));

        jButton1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton1.setText("COMPRAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 50, 120, 40));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 520, 170));

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel8.setText("COMPRAS");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, 130, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_montoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_montoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_montoActionPerformed

    private void txt_idtrabajadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_idtrabajadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_idtrabajadorActionPerformed

    private void btn_atrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_atrasActionPerformed
        this.dispose();
        Gerente gg = new Gerente();
        gg.setId(id);
        gg.setVisible(true);
    }//GEN-LAST:event_btn_atrasActionPerformed

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed
        Statement st;
        String dato = txt_idcompra.getText();
        if (dato.equals("")) {
            JOptionPane.showMessageDialog(null, "Debes poner el idCompra que deseas borrar");
        }
        String sql = "delete from compra where idCompra='" + dato + "'";
        try {
            st = cn.createStatement();
            st.executeUpdate(sql);
            int remover = tb_compra.getSelectedRow();
            modeloCompra.removeRow(remover);
            JOptionPane.showMessageDialog(null, "Registro eliminado con exito");
        } catch (SQLException e) {
            System.out.println("error");
            JOptionPane.showMessageDialog(null, "error al eliminar registro");
        }
        limpiarCompra();
    }//GEN-LAST:event_btn_eliminarActionPerformed

    private void btn_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificarActionPerformed
        Statement st;
        String datos[] = new String[50];
        datos[0] = txt_idcompra.getText();
        datos[1] = txt_idproveedor.getText();
        datos[2] = id;
        datos[3] = txt_compañia.getText();
        datos[4] = txt_monto.getText();
       // txt_fechaactual.setCalendar(fecha);

        if (datos[0].equals("") || datos[1].equals("") || datos[2].equals("") || datos[3].equals("") || datos[4].equals("")) {
            JOptionPane.showMessageDialog(null, "Debes llenar todos los campos");
        }
        String sql = "update compra set idProveedor='" + datos[1] + "',idTrabajador='" + datos[2] + "',CompañiaCompra='" + datos[3] + "',saldoComprado='" + datos[4] + "' where idCompra='" + datos[0] + "'";
        try {
            st = cn.createStatement();
            st.executeUpdate(sql);
            modeloCompra.fireTableDataChanged();
            JOptionPane.showMessageDialog(null, "Registro Actualizado");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar");
        }
        limpiarCompra();
    }//GEN-LAST:event_btn_modificarActionPerformed

    private void btn_limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limpiarActionPerformed
        limpiarCompra();
    }//GEN-LAST:event_btn_limpiarActionPerformed

    private void tb_compraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_compraMouseClicked
        limpiarCompra();
        int col = tb_compra.getSelectedRow();
        txt_idcompra.setText(tb_compra.getModel().getValueAt(col, 0).toString());
        txt_idproveedor.setText(tb_compra.getModel().getValueAt(col, 1).toString());
        txt_idtrabajador.setText(tb_compra.getModel().getValueAt(col, 2).toString());
        txt_compañia.setText(tb_compra.getModel().getValueAt(col, 3).toString());
        txt_monto.setText(tb_compra.getModel().getValueAt(col, 4).toString());
        Date date = null;
        try {
            date = new SimpleDateFormat("yyy-MM-d").parse((String) modeloCompra.getValueAt(col, 5));
        } catch (ParseException ex) {
            Logger.getLogger(CsCompra.class.getName()).log(Level.SEVERE, null, ex);
        }
        //txt_fechaactual.setDate(date);


    }//GEN-LAST:event_tb_compraMouseClicked

    private void txt_buscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_buscarKeyPressed
        String[] titulos = {"idCompra", "idProveedor", "idTrabajador", "CompañiaCompra", "saldoComprado", "Fecha"};
        String[] registros = new String[50];

        String sql = "Select * from compra where idCompra like '%" + txt_buscar.getText() + "%'"
                + "OR saldoComprado like '%" + txt_buscar.getText() + "%'"
                + "OR CompañiaCompra like '%" + txt_buscar.getText() + "%'";
        modeloCompra = new DefaultTableModel(null, titulos);
        try {
            Connection cn = cc.conexion();
            Statement st = (Statement) cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                registros[0] = rs.getString("idCompra");
                registros[1] = rs.getString("idProveedor");
                registros[2] = rs.getString("idTrabajador");
                registros[3] = rs.getString("CompañiaCompra");
                registros[4] = rs.getString("saldoComprado");
                registros[5] = rs.getString("Fecha");

                modeloCompra.addRow(registros);
            }
            tb_compra.setModel(modeloCompra);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_txt_buscarKeyPressed

    private void txt_compañiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_compañiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_compañiaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Statement st;

        String datos[] = new String[100];
        datos[0] = txt_idcompra.getText();
        datos[1] = txt_idproveedor.getText();
        datos[2] = id;
        datos[3] = txt_compañia.getText();
        datos[4] = txt_monto.getText();

        for (int i = 0; i < tb_compra.getRowCount(); i++) {

            if (tb_compra.getValueAt(i, 0).equals(datos[0])) {
                JOptionPane.showMessageDialog(null, "Duplicado");
                limpiarCompra();
                txt_idcompra.requestFocus();
            }
        }
        if (datos[0].equals("") || datos[1].equals("") || datos[2].equals("") || datos[3].equals("") || datos[4].equals("")) {
            JOptionPane.showMessageDialog(null, "Debes llenar todos los campos  ");
            txt_idcompra.requestFocus();

        } else {
            try {
                String sql = ("insert  compra(idCompra,idProveedor,idTrabajador,CompañiaCompra,saldoComprado,Fecha) values(?,?,?,?,?,?)");
                st = cn.createStatement();
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setString(1, datos[0]);
                ps.setString(2, datos[1]);
                ps.setString(3, datos[2]);
                ps.setString(4, datos[3]);
                ps.setString(5, datos[4]);
               // ps.setString(6, ((JTextField) txt_fechaactual.getDateEditor().getUiComponent()).getText());
                ps.executeUpdate();
                modeloCompra.addRow(datos);
                JOptionPane.showMessageDialog(null, "Compra correctamente");
            } catch (SQLException e) {
                Logger.getLogger(CsCompra.class.getName()).log(Level.SEVERE, null, e);
            }

            limpiarCompra();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txt_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_buscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_buscarActionPerformed

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
            java.util.logging.Logger.getLogger(CsCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CsCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CsCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CsCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CsCompra().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_atras;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_limpiar;
    private javax.swing.JButton btn_modificar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTable tb_compra;
    private javax.swing.JTextField txt_buscar;
    private javax.swing.JTextField txt_compañia;
    private javax.swing.JTextField txt_idcompra;
    private javax.swing.JTextField txt_idproveedor;
    private javax.swing.JTextField txt_idtrabajador;
    private javax.swing.JTextField txt_monto;
    // End of variables declaration//GEN-END:variables

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
