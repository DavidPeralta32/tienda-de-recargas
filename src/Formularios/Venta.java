/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import CONECTAR.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
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
public class Venta extends javax.swing.JFrame {

    Conexion cc = new Conexion();
    Connection cn = cc.conexion();
    Calendar fecha = new GregorianCalendar();
    DefaultTableModel modeloVenta2;
    private String id;

    public Venta() {
        initComponents();
        this.setTitle("Venta");
        this.setLocationRelativeTo(null);
        //txt_fechaactual.setCalendar(fecha);
        cargar();
        autoid();
        setIconImage(new ImageIcon(getClass().getResource("../Imagenes/iconrecarga.png")).getImage());

    }

    public void cargar() {
        String titulos[] = {"ID_Venta", "ID_Trabajador", "Numero Telefono", "Compañia", "Saldo", "Fecha"};
        String registros[] = new String[100];

        String sql = "Select* from venta";
        modeloVenta2 = new DefaultTableModel(null, titulos);

        try {
            Statement st = (Statement) cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                registros[0] = rs.getString("idVenta");
                registros[1] = rs.getString("idTrabajador_fk");
                registros[2] = rs.getString("NumTelefono");
                registros[3] = rs.getString("CompañiaVenta");
                registros[4] = rs.getString("Monto");
                registros[5] = rs.getString("Fecha");
                modeloVenta2.addRow(registros);
            }
            tb_ventas.setModel(modeloVenta2);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void actualizar() {
        tb_ventas.setModel(modeloVenta2);
        modeloVenta2.fireTableDataChanged();
        autoid();
    }

    private void autoid() {
        try {
            String sql = "Select numero from generarventa order by numero DESC limit 1";
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
                txt_idventa.setText(ftxt);
            } else {
                txt_idventa.setText("vt23");
                JOptionPane.showMessageDialog(null, "exito");
            }
        } catch (NumberFormatException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void limpiarVenta() {
        txt_idventa.setText("");
        txt_Importe.setText("");
        txt_compañia.setText("");
        txt_monto.setText("");
        txt_telefono.setText("");
       // txt_fechaactual.setCalendar(fecha);
        autoid();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_idventa = new javax.swing.JTextField();
        txt_telefono = new javax.swing.JTextField();
        txt_compañia = new javax.swing.JTextField();
        txt_monto = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        btn_atras = new javax.swing.JButton();
        btn_limpiar = new javax.swing.JButton();
        Vender = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_Importe = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_ventas = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        txt_buscar = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("DialogInput", 1, 12)); // NOI18N
        jLabel1.setText("ID");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 20, 30));

        jLabel2.setFont(new java.awt.Font("DialogInput", 1, 12)); // NOI18N
        jLabel2.setText("Numero Telefono");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        jLabel4.setFont(new java.awt.Font("DialogInput", 1, 12)); // NOI18N
        jLabel4.setText("Compañia");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, -1, -1));

        jLabel5.setFont(new java.awt.Font("DialogInput", 1, 12)); // NOI18N
        jLabel5.setText("Saldo/Monto");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 130, -1, -1));

        jLabel6.setFont(new java.awt.Font("DialogInput", 1, 12)); // NOI18N
        jLabel6.setText("Fecha");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, -1, -1));

        txt_idventa.setFont(new java.awt.Font("DialogInput", 1, 12)); // NOI18N
        getContentPane().add(txt_idventa, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, 70, 30));

        txt_telefono.setFont(new java.awt.Font("DialogInput", 1, 12)); // NOI18N
        getContentPane().add(txt_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 110, -1));

        txt_compañia.setFont(new java.awt.Font("DialogInput", 1, 12)); // NOI18N
        txt_compañia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_compañiaActionPerformed(evt);
            }
        });
        getContentPane().add(txt_compañia, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 180, 100, -1));

        txt_monto.setFont(new java.awt.Font("DialogInput", 1, 12)); // NOI18N
        txt_monto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_montoActionPerformed(evt);
            }
        });
        getContentPane().add(txt_monto, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 120, 100, 30));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 710, 10));

        btn_atras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/atrasflecha.png"))); // NOI18N
        btn_atras.setBorderPainted(false);
        btn_atras.setContentAreaFilled(false);
        btn_atras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_atrasActionPerformed(evt);
            }
        });
        getContentPane().add(btn_atras, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 40));

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
        getContentPane().add(btn_limpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 150, 90, 70));

        Vender.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        Vender.setText("VENDER");
        Vender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VenderActionPerformed(evt);
            }
        });
        getContentPane().add(Vender, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 80, 100, 50));

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel8.setText("VENTAS");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, 110, -1));

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel9.setText("Importe");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 170, 50, -1));

        txt_Importe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_ImporteActionPerformed(evt);
            }
        });
        getContentPane().add(txt_Importe, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 160, 100, 30));

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jTextArea2.setEnabled(false);
        jScrollPane2.setViewportView(jTextArea2);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 530, 190));

        tb_ventas.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tb_ventas);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 290, 630, 210));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buscarbien.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 10, 30, 30));

        txt_buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_buscarKeyPressed(evt);
            }
        });
        getContentPane().add(txt_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 10, 100, 30));

        jButton1.setText("REFRESCAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 240, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_montoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_montoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_montoActionPerformed

    private void btn_atrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_atrasActionPerformed
        this.dispose();
        Cajero gg = new Cajero();
        gg.setId(id);
        gg.setVisible(true);
    }//GEN-LAST:event_btn_atrasActionPerformed

    private void btn_limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limpiarActionPerformed
        limpiarVenta();
    }//GEN-LAST:event_btn_limpiarActionPerformed

    private void VenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VenderActionPerformed
        Statement st;
        String datos[] = new String[100];
        datos[0] = txt_idventa.getText();
        datos[1] = id;
        datos[2] = txt_telefono.getText();
        datos[3] = txt_compañia.getText();
        datos[4] = txt_monto.getText();
        datos[5] = txt_Importe.getText();
        int importe, monto, cambio;
        importe = Integer.parseInt(datos[5]);
        monto = Integer.parseInt(datos[4]);
        cambio = importe - monto;
        if (importe < monto) {
            JOptionPane.showMessageDialog(null, "Importe menor");
        }
        datos[4] = Integer.toString(monto);

        for (int i = 0; i < tb_ventas.getRowCount(); i++) {
            if (tb_ventas.getValueAt(i, 0).equals(datos[0])) {
                JOptionPane.showMessageDialog(null, "Duplicado");
                limpiarVenta();
                txt_idventa.requestFocus();
            }
        }
        if (datos[0].equals("") || datos[1].equals("") || datos[2].equals("") || datos[3].equals("") || datos[4].equals("")) {
            JOptionPane.showMessageDialog(null, "Debes llenar todos los campos  ");
            txt_idventa.requestFocus();

        } else {
            try {
                String sql = "insert venta(idVenta,idTrabajador_fk,NumTelefono,CompañiaVenta,Monto,Fecha) values(?,?,?,?,?,?)";
                st = cn.createStatement();
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setString(1, datos[0]);
                ps.setString(2, datos[1]);
                ps.setString(3, datos[2]);
                ps.setString(4, datos[3]);
                ps.setString(5, datos[4]);
               // ps.setString(6, ((JTextField) txt_fechaactual.getDateEditor().getUiComponent()).getText());
                ps.executeUpdate();
                modeloVenta2.addRow(datos);
                JOptionPane.showMessageDialog(null, "Venta exitosa ||Cambio de: " + cambio);
                autoid();
            } catch (SQLException e) {
                Logger.getLogger(Venta.class.getName()).log(Level.SEVERE, null, e);
            }

            limpiarVenta();
        }
    }//GEN-LAST:event_VenderActionPerformed

    private void txt_compañiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_compañiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_compañiaActionPerformed

    private void txt_ImporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_ImporteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_ImporteActionPerformed

    private void txt_buscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_buscarKeyPressed
        // TODO add your handling code here:
        String[] titulos = {"idVenta", "Trabajador", "Numero Telefono", "Compañia", "Saldo", "Fecha"};
        String[] registros = new String[50];

        String sql = "Select * from venta where idVenta like '%" + txt_buscar.getText() + "%'"
                + "OR NumTelefono like '%" + txt_buscar.getText() + "%'"
                + "OR CompañiaVenta like '%" + txt_buscar.getText() + "%'"
                + "OR Monto like '%" + txt_buscar.getText() + "%'";
        modeloVenta2 = new DefaultTableModel(null, titulos);
        try {
            Statement st = (Statement) cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                registros[0] = rs.getString("idVenta");
                registros[1] = rs.getString("idTrabajador_fk");
                registros[2] = rs.getString("NumTelefono");
                registros[3] = rs.getString("CompañiaVenta");
                registros[4] = rs.getString("Monto");
                registros[5] = rs.getString("Fecha");

                modeloVenta2.addRow(registros);
            }
            tb_ventas.setModel(modeloVenta2);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }


    }//GEN-LAST:event_txt_buscarKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        actualizar();

    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Venta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Vender;
    private javax.swing.JButton btn_atras;
    private javax.swing.JButton btn_limpiar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTable tb_ventas;
    private javax.swing.JTextField txt_Importe;
    private javax.swing.JTextField txt_buscar;
    private javax.swing.JTextField txt_compañia;
    public static javax.swing.JTextField txt_idventa;
    private javax.swing.JTextField txt_monto;
    private javax.swing.JTextField txt_telefono;
    // End of variables declaration//GEN-END:variables

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
