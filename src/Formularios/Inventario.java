/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import CONECTAR.Conexion;
//import com.placeholder.PlaceHolder;
import java.sql.Connection;
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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Davi_
 */
public class Inventario extends javax.swing.JFrame {

    DefaultTableModel modeloInventario;
    Conexion cc = new Conexion();
    Connection cn = cc.conexion();
    Calendar fecha = new GregorianCalendar();
    private String id;
  //  PlaceHolder holder;

    public Inventario() {
        initComponents();
        cargar();
        this.setLocationRelativeTo(null);
        this.setTitle("INVENTARIO");
        this.setResizable(false);
    //    txt_fecha.setCalendar(fecha);
      //  holder = new PlaceHolder(txt_buscar, "Buscar");
        setIconImage(new ImageIcon(getClass().getResource("../Imagenes/iconrecarga.png")).getImage());

    }

    public void limpiar() {
        txt_idinventario.setText("");
        txt_transaccion.setText("");
        txt_idventa.setText("");
        txt_idcompra.setText("");
        txt_trabajador.setText("");
        txt_comptelcel.setText("");
        txt_venttelcel.setText("");
        txt_montotelcel.setText("");
        txt_compMovistar.setText("");
        txt_ventMovistar.setText("");
        txt_montoMovistar.setText("");
      //  txt_fecha.setCalendar(fecha);

    }

    public void cargar() {
        String titulos[] = {"ID_Inventario", "Transaccion", "ID_Venta", "ID_Compra", "Trabajador", "Com_Telcel", "Venta_Telcel", "Monto_Telcel", "Comp_Movistar", "Venta_Movistar", "Monto_Movistar", "Fecha"};
        String registros[] = new String[100];

        String sql = "Select* from inventario2";
        modeloInventario = new DefaultTableModel(null, titulos);

        try {
            Statement st = (Statement) cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                registros[0] = rs.getString("idInventario2");
                registros[1] = rs.getString("Transaccion");
                registros[2] = rs.getString("idTranVenta_fk2");
                registros[3] = rs.getString("idTranCompra_fk1");
                registros[4] = rs.getString("idTrabajador_fk5");
                registros[5] = rs.getString("ComprasTelcel");
                registros[6] = rs.getString("VentaTelcel");
                registros[7] = rs.getString("Monto_Telcel");
                registros[8] = rs.getString("CompraMovistar");
                registros[9] = rs.getString("VentaMovistar");
                registros[10] = rs.getString("Monto_Movistar");
                registros[11] = rs.getString("Fecha");
                modeloInventario.addRow(registros);
            }
            tb_inventario.setModel(modeloInventario);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tb_inventario = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_buscar = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_idinventario = new javax.swing.JTextField();
        txt_transaccion = new javax.swing.JTextField();
        txt_idventa = new javax.swing.JTextField();
        txt_idcompra = new javax.swing.JTextField();
        txt_trabajador = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_comptelcel = new javax.swing.JTextField();
        txt_venttelcel = new javax.swing.JTextField();
        txt_montotelcel = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txt_compMovistar = new javax.swing.JTextField();
        txt_ventMovistar = new javax.swing.JTextField();
        txt_montoMovistar = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tb_inventario.setModel(new javax.swing.table.DefaultTableModel(
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
        tb_inventario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_inventarioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_inventario);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 1022, 311));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/atrasflecha.png"))); // NOI18N
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 40));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setText("INVENTARIO");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 0, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buscarbien.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 10, 30, 30));

        txt_buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_buscarKeyPressed(evt);
            }
        });
        getContentPane().add(txt_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 10, 110, 30));

        jLabel3.setText("ID");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 20, -1));

        jLabel4.setText("TRANSACCION");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, -1, -1));

        jLabel5.setText("ID VENTA");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, -1, -1));

        jLabel6.setText("ID COMPRA");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, -1, -1));

        jLabel7.setText("TRABAJADOR");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, -1, -1));
        getContentPane().add(txt_idinventario, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 80, 30));
        getContentPane().add(txt_transaccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 110, 30));
        getContentPane().add(txt_idventa, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, 110, 30));
        getContentPane().add(txt_idcompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 200, 110, 30));
        getContentPane().add(txt_trabajador, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 240, 110, 30));

        jLabel8.setText("COMPRAS TELCEL");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 130, -1, -1));

        jLabel9.setText("VENTAS TELCEL");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 180, -1, -1));

        jLabel10.setText("MONTO TELCEL");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 230, -1, -1));
        getContentPane().add(txt_comptelcel, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 120, 110, 30));
        getContentPane().add(txt_venttelcel, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 170, 110, 30));
        getContentPane().add(txt_montotelcel, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 220, 110, 30));

        jLabel11.setText("COMPRAS MOVISTAR");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 130, -1, -1));

        jLabel12.setText("VENTAS MOVISTAR");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 180, -1, -1));

        jLabel13.setText("MONTO MOVISTAR");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 230, -1, -1));
        getContentPane().add(txt_compMovistar, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 120, 110, 30));
        getContentPane().add(txt_ventMovistar, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 170, 110, 30));
        getContentPane().add(txt_montoMovistar, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 220, 110, 30));

        jButton2.setText("ACTUALIZAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 80, -1, -1));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/limpiarbien.png"))); // NOI18N
        jButton4.setContentAreaFilled(false);
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/limpiachico.png"))); // NOI18N
        jButton4.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/limpiagrande.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 50, 80, 70));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
        Gerente g = new Gerente();
        g.setId(id);
        g.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txt_buscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_buscarKeyPressed
        String titulos[] = {"ID_Inventario", "Transaccion", "ID_Venta", "ID_Compra", "Trabajador", "Com_Telcel", "Venta_Telcel", "Monto_Telcel", "Comp_Movistar", "Venta_Movistar", "Monto_Movistar", "Fecha"};
        String[] registros = new String[50];

        String sql = "Select * from inventario2 where idInventario2 like '%" + txt_buscar.getText() + "%'"
                + "OR Transaccion like '%" + txt_buscar.getText() + "%'"
                + "OR idTranVenta_fk2 like '%" + txt_buscar.getText() + "%'"
                + "OR idTrabajador_fk5 like '%" + txt_buscar.getText() + "%'"
                + "OR Monto_Telcel like '%" + txt_buscar.getText() + "%'"
                + "OR Monto_Movistar like '%" + txt_buscar.getText() + "%'"
                + "OR idTranCompra_fk1 like '%" + txt_buscar.getText() + "%'";
        modeloInventario = new DefaultTableModel(null, titulos);
        try {
            Statement st = (Statement) cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                registros[0] = rs.getString("idInventario2");
                registros[1] = rs.getString("Transaccion");
                registros[2] = rs.getString("idTranVenta_fk2");
                registros[3] = rs.getString("idTranCompra_fk1");
                registros[4] = rs.getString("idTrabajador_fk5");
                registros[5] = rs.getString("ComprasTelcel");
                registros[6] = rs.getString("VentaTelcel");
                registros[7] = rs.getString("Monto_Telcel");
                registros[8] = rs.getString("CompraMovistar");
                registros[9] = rs.getString("VentaMovistar");
                registros[10] = rs.getString("Monto_Movistar");
                registros[11] = rs.getString("Fecha");

                modeloInventario.addRow(registros);
            }
            tb_inventario.setModel(modeloInventario);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_txt_buscarKeyPressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Statement st = null;
        String datos[] = new String[50];
        datos[0] = txt_idinventario.getText();
        datos[1] = txt_transaccion.getText();
        datos[2] = txt_idventa.getText();
        datos[3] = txt_idcompra.getText();
        datos[4] = txt_trabajador.getText();
        datos[5] = txt_comptelcel.getText();
        datos[6] = txt_venttelcel.getText();
        datos[7] = txt_montotelcel.getText();
        datos[8] = txt_compMovistar.getText();
        datos[9] = txt_ventMovistar.getText();
        datos[10] = txt_montoMovistar.getText();
      //  txt_fecha.setCalendar(fecha);

        if (datos[0].equals("") || datos[1].equals("") || datos[2].equals("") || datos[3].equals("") || datos[4].equals("") || datos[5].equals("") || datos[6].equals("") || datos[7].equals("") || datos[8].equals("") || datos[9].equals("") || datos[10].equals("")) {
            JOptionPane.showMessageDialog(null, "Debes llenar todos los campos");
        }
        String sql = "update inventario2 set Transaccion='" + datos[1] + "',idTranVenta_fk2='" + datos[2] + "',idTranCompra_fk1='" + datos[3] + "',idTrabajador_fk5='" + datos[4] + "',ComprasTelcel='" + datos[5] + "',VentaTelcel='" + datos[6] + "',Monto_Telcel='" + datos[7] + "',CompraMovistar='" + datos[8] + "',VentaMovistar='" + datos[9] + "',Monto_Movistar='" + datos[4] + "' where idInventario2='" + datos[0] + "'";
        try {
            st = cn.createStatement();
            st.executeUpdate(sql);
            modeloInventario.fireTableDataChanged();
            JOptionPane.showMessageDialog(null, "Registro Actualizado");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar");
        }
        limpiar();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tb_inventarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_inventarioMouseClicked
        int col = tb_inventario.getSelectedRow();
        txt_idinventario.setText(tb_inventario.getModel().getValueAt(col, 0).toString());
        txt_transaccion.setText(tb_inventario.getModel().getValueAt(col, 1).toString());
        txt_idventa.setText(tb_inventario.getModel().getValueAt(col, 2).toString());
        txt_idcompra.setText(tb_inventario.getModel().getValueAt(col, 3).toString());
        txt_trabajador.setText(tb_inventario.getModel().getValueAt(col, 4).toString());
        txt_comptelcel.setText(tb_inventario.getModel().getValueAt(col, 5).toString());
        txt_venttelcel.setText(tb_inventario.getModel().getValueAt(col, 6).toString());
        txt_montotelcel.setText(tb_inventario.getModel().getValueAt(col, 7).toString());
        txt_compMovistar.setText(tb_inventario.getModel().getValueAt(col, 8).toString());
        txt_ventMovistar.setText(tb_inventario.getModel().getValueAt(col, 9).toString());
        txt_montoMovistar.setText(tb_inventario.getModel().getValueAt(col, 10).toString());
        Date date = null;
        try {
            date = new SimpleDateFormat("yyy-MM-d").parse((String) modeloInventario.getValueAt(col, 11));
        } catch (ParseException ex) {
            Logger.getLogger(CsCompra.class.getName()).log(Level.SEVERE, null, ex);
        }
      //  txt_fecha.setDate(date);
    }//GEN-LAST:event_tb_inventarioMouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        limpiar();
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(Inventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inventario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable tb_inventario;
    private javax.swing.JTextField txt_buscar;
    private javax.swing.JTextField txt_compMovistar;
    private javax.swing.JTextField txt_comptelcel;
    private javax.swing.JTextField txt_idcompra;
    private javax.swing.JTextField txt_idinventario;
    private javax.swing.JTextField txt_idventa;
    private javax.swing.JTextField txt_montoMovistar;
    private javax.swing.JTextField txt_montotelcel;
    private javax.swing.JTextField txt_trabajador;
    private javax.swing.JTextField txt_transaccion;
    private javax.swing.JTextField txt_ventMovistar;
    private javax.swing.JTextField txt_venttelcel;
    // End of variables declaration//GEN-END:variables

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
