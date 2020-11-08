/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import CONECTAR.Conexion;
import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Davi_
 */
public class Gerente extends javax.swing.JFrame {

    Conexion cc = new Conexion();
    Connection cn = cc.conexion();
    DefaultTableModel modeloDisponible;
    Calendar fecha = new GregorianCalendar();
    private String id;
  
            
    public Gerente() {
        initComponents();
        this.setTitle("Inicio  ");
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.WHITE);
        cargar();
        tb_disponible.getSelectedRow();
        txt_Telcel.setText(tb_disponible.getModel().getValueAt(0, 2).toString());
        txt_Movistar.setText(tb_disponible.getModel().getValueAt(1, 2).toString());
        txt_Ventas.setText(tb_disponible.getModel().getValueAt(2, 3).toString());
        txt_Compras.setText(tb_disponible.getModel().getValueAt(2, 4).toString());
       // txt_fechaactual.setCalendar(fecha);
        setIconImage(new ImageIcon(getClass().getResource("../Imagenes/iconrecarga.png")).getImage());
       
    }

    public void cargar() {

        String titulos[] = {"id", "Compañia", "Saldo_Disponible", "Ventas_Total", "Compras_Total"};
        String registros[] = new String[100];

        String sql = "Select* from disponible";
        modeloDisponible = new DefaultTableModel(null, titulos);

        try {
            Statement st = (Statement) cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                registros[0] = rs.getString("id");
                registros[1] = rs.getString("compañia");
                registros[2] = rs.getString("saldo");
                registros[3] = rs.getString("VentasTotal");
                registros[4] = rs.getString("ComprasTotal");

                modeloDisponible.addRow(registros);
            }
            tb_disponible.setModel(modeloDisponible);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();
        jMenu8 = new javax.swing.JMenu();
        jMenu9 = new javax.swing.JMenu();
        jMenuBar3 = new javax.swing.JMenuBar();
        jMenu10 = new javax.swing.JMenu();
        jMenu11 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_disponible = new javax.swing.JTable();
        txt_Telcel = new javax.swing.JTextField();
        txt_Movistar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_Ventas = new javax.swing.JTextField();
        txt_Compras = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnu_usuario = new javax.swing.JMenu();
        consul_usuario = new javax.swing.JMenuItem();
        salir = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        menu_consultaProveedores = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu12 = new javax.swing.JMenu();
        menu_proveedor = new javax.swing.JMenuItem();
        jMenu13 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();

        jMenu3.setText("File");
        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        jMenu1.setText("jMenu1");

        jMenu6.setText("jMenu6");

        jMenu7.setText("jMenu7");

        jMenu8.setText("jMenu8");

        jMenu9.setText("jMenu9");

        jMenu10.setText("File");
        jMenuBar3.add(jMenu10);

        jMenu11.setText("Edit");
        jMenuBar3.add(jMenu11);

        jMenuItem1.setText("jMenuItem1");

        tb_disponible.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tb_disponible);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_Telcel.setEditable(false);
        txt_Telcel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txt_Telcel.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txt_Telcel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 80, 70));

        txt_Movistar.setEditable(false);
        txt_Movistar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txt_Movistar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txt_Movistar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 100, 80, 70));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("SALDO TELCEL");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel2.setText("SALDO MOVISTAR");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 60, -1, -1));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setEnabled(false);
        jScrollPane2.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 490, 140));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel3.setText("SALDO TELCEL");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel4.setText("VENTAS TOTAL");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, -1, -1));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel5.setText("SALDO TELCEL");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel6.setText("COMPRAS TOTAL");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 240, -1, -1));

        txt_Ventas.setEditable(false);
        txt_Ventas.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txt_Ventas.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txt_Ventas, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 280, 60, 50));

        txt_Compras.setEditable(false);
        txt_Compras.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txt_Compras.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txt_Compras, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 280, 60, 50));

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jTextArea2.setEnabled(false);
        jScrollPane3.setViewportView(jTextArea2);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 490, 120));

        jMenuBar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        mnu_usuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/usuariosbien.png"))); // NOI18N
        mnu_usuario.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        consul_usuario.setText("Consulta Usuario");
        consul_usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consul_usuarioActionPerformed(evt);
            }
        });
        mnu_usuario.add(consul_usuario);

        salir.setText("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });
        mnu_usuario.add(salir);

        jMenuBar1.add(mnu_usuario);

        jMenu2.setText("Compra");
        jMenu2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        menu_consultaProveedores.setText("Consultar Compras");
        menu_consultaProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_consultaProveedoresActionPerformed(evt);
            }
        });
        jMenu2.add(menu_consultaProveedores);

        jMenuBar1.add(jMenu2);

        jMenu5.setText("Venta");
        jMenu5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        jMenuItem3.setText("Consulta Ventas");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem3);

        jMenuBar1.add(jMenu5);

        jMenu12.setText("Proveedor");
        jMenu12.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jMenu12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu12ActionPerformed(evt);
            }
        });

        menu_proveedor.setText("Consultar proveedores");
        menu_proveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_proveedorActionPerformed(evt);
            }
        });
        jMenu12.add(menu_proveedor);

        jMenuBar1.add(jMenu12);

        jMenu13.setText("Inventario");
        jMenu13.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        jMenuItem4.setText("Consultar Inventario");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu13.add(jMenuItem4);

        jMenuBar1.add(jMenu13);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        this.dispose();
        Loggin lo = new Loggin();
        lo.setVisible(true);
    }//GEN-LAST:event_salirActionPerformed

    private void consul_usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consul_usuarioActionPerformed
        this.dispose();
        Usuarios us = new Usuarios();
        us.setId(id);
        us.setVisible(true);
    }//GEN-LAST:event_consul_usuarioActionPerformed

    private void jMenu12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu12ActionPerformed
        this.dispose();
        Proveedor pr = new Proveedor();

        pr.setVisible(true);
    }//GEN-LAST:event_jMenu12ActionPerformed

    private void menu_proveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_proveedorActionPerformed
        this.dispose();
        Proveedor pr = new Proveedor();
        pr.setId(id);
        pr.setVisible(true);
    }//GEN-LAST:event_menu_proveedorActionPerformed

    private void menu_consultaProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_consultaProveedoresActionPerformed
        this.dispose();
        CsCompra cc = new CsCompra();
        cc.setId(id);
        cc.setVisible(true);
    }//GEN-LAST:event_menu_consultaProveedoresActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
      
        this.dispose();
        CsVenta cv = new CsVenta();
        cv.setId(id);
        cv.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        this.dispose();
        Inventario inv = new Inventario();
        inv.setId(id);
        inv.setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

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
            java.util.logging.Logger.getLogger(Gerente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Gerente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Gerente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gerente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Gerente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem consul_usuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu11;
    private javax.swing.JMenu jMenu12;
    private javax.swing.JMenu jMenu13;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuBar jMenuBar3;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JMenuItem menu_consultaProveedores;
    private javax.swing.JMenuItem menu_proveedor;
    private javax.swing.JMenu mnu_usuario;
    private javax.swing.JMenuItem salir;
    private javax.swing.JTable tb_disponible;
    private javax.swing.JTextField txt_Compras;
    private javax.swing.JTextField txt_Movistar;
    public static javax.swing.JTextField txt_Telcel;
    private javax.swing.JTextField txt_Ventas;
    // End of variables declaration//GEN-END:variables

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
