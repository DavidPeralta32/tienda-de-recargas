/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import CONECTAR.Conexion;
import static Formularios.Loggin.txt_nombre;
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
public class Compra extends javax.swing.JFrame {

    Conexion cc = new Conexion();
    Connection cn = cc.conexion();
    DefaultTableModel modeloCompra;
    Calendar fecha = new GregorianCalendar();
    Inventario inv = new Inventario();
    private String id;
    //PlaceHolder holder;

    public Compra() {
        initComponents();
        this.setTitle("Compra");
        this.setLocationRelativeTo(null);
        cargar();
        this.setResizable(false);
        System.out.println("llegue " + id);
        autoid();
        //txt_fechaactual.setCalendar(fecha);
        //holder = new PlaceHolder(txt_idproveedor, "cp00");
        //holder = new PlaceHolder(txt_buscar, "Buscar");
        setIconImage(new ImageIcon(getClass().getResource("../Imagenes/iconrecarga.png")).getImage());

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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_idcompra = new javax.swing.JTextField();
        txt_idproveedor = new javax.swing.JTextField();
        txt_compañia = new javax.swing.JTextField();
        txt_monto = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        btn_atras = new javax.swing.JButton();
        btn_limpiar = new javax.swing.JButton();
        Comprar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_compra = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_buscar = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("DialogInput", 1, 12)); // NOI18N
        jLabel1.setText("ID");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 20, 30));

        jLabel2.setFont(new java.awt.Font("DialogInput", 1, 12)); // NOI18N
        jLabel2.setText("ID_Proveedor");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, -1, -1));

        jLabel4.setFont(new java.awt.Font("DialogInput", 1, 12)); // NOI18N
        jLabel4.setText("Compañia");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 80, -1, -1));

        jLabel5.setFont(new java.awt.Font("DialogInput", 1, 12)); // NOI18N
        jLabel5.setText("Saldo/Monto");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 130, -1, -1));

        jLabel6.setFont(new java.awt.Font("DialogInput", 1, 12)); // NOI18N
        jLabel6.setText("Fecha");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, -1, -1));

        txt_idcompra.setFont(new java.awt.Font("DialogInput", 1, 12)); // NOI18N
        getContentPane().add(txt_idcompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, 50, 30));

        txt_idproveedor.setFont(new java.awt.Font("DialogInput", 1, 12)); // NOI18N
        getContentPane().add(txt_idproveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 60, 30));

        txt_compañia.setFont(new java.awt.Font("DialogInput", 1, 12)); // NOI18N
        getContentPane().add(txt_compañia, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 80, 120, 30));

        txt_monto.setFont(new java.awt.Font("DialogInput", 1, 12)); // NOI18N
        txt_monto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_montoActionPerformed(evt);
            }
        });
        getContentPane().add(txt_monto, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 120, 120, 30));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 710, 10));

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
        btn_limpiar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/limpiagrande.png"))); // NOI18N
        btn_limpiar.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/limpiachico.png"))); // NOI18N
        btn_limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_limpiarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_limpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 130, 80, 70));

        Comprar.setText("COMPRAR");
        Comprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComprarActionPerformed(evt);
            }
        });
        getContentPane().add(Comprar, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 75, -1, 40));

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
        jScrollPane1.setViewportView(tb_compra);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 660, 200));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setEnabled(false);
        jScrollPane2.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 640, 150));

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel7.setText("COMPRAS");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, 100, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buscarbien.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 10, -1, -1));

        txt_buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_buscarKeyPressed(evt);
            }
        });
        getContentPane().add(txt_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 10, 100, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_montoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_montoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_montoActionPerformed

    private void btn_atrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_atrasActionPerformed
        this.dispose();
        Cajero cj = new Cajero();
        cj.setId(id);
        cj.setVisible(true);
    }//GEN-LAST:event_btn_atrasActionPerformed

    private void btn_limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limpiarActionPerformed
        limpiarCompra();
    }//GEN-LAST:event_btn_limpiarActionPerformed

    private void ComprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComprarActionPerformed
        Statement st = null;
        System.out.println("Comprare " + id);
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
                String sql = ("insert compra(idCompra,idProveedor,idTrabajador,CompañiaCompra,saldoComprado,Fecha) values(?,?,?,?,?,?)");
                st = cn.createStatement();
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setString(1, datos[0]);
                ps.setString(2, datos[1]);
                ps.setString(3, datos[2]);
                ps.setString(4, datos[3]);
                ps.setString(5, datos[4]);
              //  ps.setString(6, ((JTextField) txt_fechaactual.getDateEditor().getUiComponent()).getText());
                ps.executeUpdate();
                modeloCompra.addRow(datos);
                JOptionPane.showMessageDialog(null, "Agregado correctamente");
            } catch (SQLException e) {
                Logger.getLogger(Proveedor.class.getName()).log(Level.SEVERE, null, e);
            }

            limpiarCompra();
        }
    }//GEN-LAST:event_ComprarActionPerformed

    private void txt_buscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_buscarKeyPressed
        // TODO add your handling code here:
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
            java.util.logging.Logger.getLogger(Compra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Compra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Compra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Compra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Compra().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Comprar;
    private javax.swing.JButton btn_atras;
    private javax.swing.JButton btn_limpiar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTable tb_compra;
    private javax.swing.JTextField txt_buscar;
    private javax.swing.JTextField txt_compañia;
    private javax.swing.JTextField txt_idcompra;
    private javax.swing.JTextField txt_idproveedor;
    private javax.swing.JTextField txt_monto;
    // End of variables declaration//GEN-END:variables

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
