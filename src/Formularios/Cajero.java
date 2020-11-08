/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import CONECTAR.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Davi_
 */
public class Cajero extends javax.swing.JFrame {
    DefaultTableModel modeloResultado;
     Conexion cc = new Conexion(); 
     Connection cn=cc.conexion();
     Calendar fecha = new GregorianCalendar();
     private String id;
             

    public Cajero() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Menu Cajero");
        cargar();
        this.setResizable(false);
                setIconImage(new ImageIcon(getClass().getResource("../Imagenes/iconrecarga.png")).getImage());
         tb_resultado.getSelectedRow();
        txt_Telcel1.setText(tb_resultado.getModel().getValueAt(0, 2).toString());
        txt_Movistar.setText(tb_resultado.getModel().getValueAt(1, 2).toString());
       // txt_fechaactual.setCalendar(fecha);
    }

    public void cargar(){
        
        String titulos[] = {"id","Compañia","Saldo_Disponible","Ventas_Total","Compras_Total"};
        String registros[] = new String[100];

        String sql = "Select* from disponible";
        modeloResultado = new DefaultTableModel(null, titulos);

        try {
            Statement st = (Statement) cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                registros[0] = rs.getString("id");
                registros[1] = rs.getString("compañia");
                registros[2] = rs.getString("saldo");
                registros[3] = rs.getString("VentasTotal");
                registros[4] = rs.getString("ComprasTotal");
                
                modeloResultado.addRow(registros);
            }
            tb_resultado.setModel(modeloResultado);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_resultado = new javax.swing.JTable();
        btn_Compra = new javax.swing.JButton();
        btn_venta = new javax.swing.JButton();
        txt_Movistar = new javax.swing.JTextField();
        txt_Telcel1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondocajero.jpg"))); // NOI18N

        tb_resultado.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tb_resultado);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_Compra.setFont(new java.awt.Font("Ebrima", 1, 24)); // NOI18N
        btn_Compra.setText("COMPRAR");
        btn_Compra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CompraActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Compra, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 170, 90));

        btn_venta.setFont(new java.awt.Font("Ebrima", 1, 24)); // NOI18N
        btn_venta.setText("VENDER");
        btn_venta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ventaActionPerformed(evt);
            }
        });
        getContentPane().add(btn_venta, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 70, 170, 90));

        txt_Movistar.setEditable(false);
        txt_Movistar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        txt_Movistar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txt_Movistar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 220, 80, 60));

        txt_Telcel1.setEditable(false);
        txt_Telcel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        txt_Telcel1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txt_Telcel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 220, 80, 60));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("Saldo_Telcel");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, -1, 20));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setText("Saldo_Movistar");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 190, -1, -1));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setEnabled(false);
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 350, 140));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel4.setText("CAJERO");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, -1, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 470, 10));

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logginbien.png"))); // NOI18N
        jMenu3.setToolTipText("Cerrar sesion");
        jMenu3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenu3.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N

        jMenuItem1.setText("Cerrar sesion");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_CompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CompraActionPerformed
        this.dispose();
        Compra c = new Compra();
        c.setId(id);
        System.out.println(id);
        c.setVisible(true);
    }//GEN-LAST:event_btn_CompraActionPerformed

    private void btn_ventaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ventaActionPerformed
        this.dispose();
        Venta v = new Venta();
        v.setId(id);
        v.setVisible(true);
    }//GEN-LAST:event_btn_ventaActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        this.dispose();
        Loggin lo = new Loggin();
        lo.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

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
            java.util.logging.Logger.getLogger(Cajero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cajero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cajero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cajero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cajero().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Compra;
    private javax.swing.JButton btn_venta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTable tb_resultado;
    private javax.swing.JTextField txt_Movistar;
    private javax.swing.JTextField txt_Telcel1;
    // End of variables declaration//GEN-END:variables

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
