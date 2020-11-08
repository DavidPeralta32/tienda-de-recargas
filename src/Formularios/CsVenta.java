/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import CONECTAR.Conexion;
import static Formularios.Gerente.txt_Telcel;
import static Formularios.Venta.txt_idventa;
//import com.placeholder.PlaceHolder;
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
import static javafx.application.Platform.exit;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Davi_
 */
public class CsVenta extends javax.swing.JFrame {

    Conexion cc = new Conexion();
    Connection cn = cc.conexion();
    DefaultTableModel modeloVenta;
    DefaultTableModel modeloDisponible;
    Calendar fecha = new GregorianCalendar();
    private String id;
   // PlaceHolder holder;

    public CsVenta() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        cargar();
        cargar2();
        this.setTitle("Venta");
       // txt_fechaactual.setCalendar(fecha);
        autoid();
        //holder = new PlaceHolder(txt_buscar, "Buscar");
        //holder = new PlaceHolder(txt_Importe, "Con cuanto paga");
        setIconImage(new ImageIcon(getClass().getResource("../Imagenes/iconrecarga.png")).getImage());
        tb_disponible.getSelectedRow();
        txt_dspoTelcel.setText(tb_disponible.getModel().getValueAt(0, 2).toString());
        txt_dispoMovistar.setText(tb_disponible.getModel().getValueAt(1, 2).toString());
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

    public void consultarsaldoTelcel() {

        if (txt_Compañia.getText().equals("Telcel")) {
            int saldoTelceldispo = Integer.parseInt(txt_dspoTelcel.getText());
            int saldoTelcelVenta = Integer.parseInt(txt_Monto.getText());
            if (saldoTelceldispo < saldoTelcelVenta) {
                JOptionPane.showMessageDialog(null, "SALDO INSUFICIENTE");
                limpiarVenta();
            }
        } else if (txt_Compañia.getText().equals("Movistar")) {
            int saldoMovistardispo = Integer.parseInt(txt_dispoMovistar.getText());
            int saldoMovistarVenta = Integer.parseInt(txt_Monto.getText());
            if (saldoMovistardispo < saldoMovistarVenta) {
                JOptionPane.showMessageDialog(null, "SALDO INSUFICIENTE");
                limpiarVenta();
            }
        }

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
                txt_idVenta.setText(ftxt);
            } else {
                JOptionPane.showMessageDialog(null, "exito");
            }
        } catch (NumberFormatException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void limpiarVenta() {
        txt_idVenta.setText("");
        txt_idTrabajador.setText(id);
        txt_Compañia.setText("");
        txt_Monto.setText("");
        txt_numero.setText("");
        txt_Importe.setText("");
       // txt_fechaactual.setCalendar(fecha);
        autoid();

    }

    public void cargar2() {
        String titulos[] = {"ID_Venta", "ID_Trabajador", "Numero Telefono", "Compañia", "Saldo", "Fecha"};
        String registros[] = new String[100];

        String sql = "Select* from venta";
        modeloVenta = new DefaultTableModel(null, titulos);

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
                modeloVenta.addRow(registros);
            }
            tb_Venta2.setModel(modeloVenta);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        tb_disponible = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_Venta2 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btn_Vender = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();
        btn_actualizar = new javax.swing.JButton();
        btn_limpiar = new javax.swing.JButton();
        btn_atras = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_buscar = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        txt_idVenta = new javax.swing.JTextField();
        txt_idTrabajador = new javax.swing.JTextField();
        txt_numero = new javax.swing.JTextField();
        txt_Compañia = new javax.swing.JTextField();
        txt_Monto = new javax.swing.JTextField();
        txt_Importe = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        txt_dspoTelcel = new javax.swing.JTextField();
        txt_dispoMovistar = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

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
        jScrollPane3.setViewportView(tb_disponible);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tb_Venta2.setModel(new javax.swing.table.DefaultTableModel(
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
        tb_Venta2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_Venta2MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_Venta2);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 751, 229));

        jLabel1.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        jLabel1.setText("ID");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, 20, 30));

        jLabel2.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        jLabel2.setText("Numero Telefono");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, -1, 20));

        jLabel3.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        jLabel3.setText("ID_Trabajador");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, -1, 20));

        jLabel4.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        jLabel4.setText("Compañia");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 110, -1, -1));

        jLabel5.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        jLabel5.setText("Saldo/Monto");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 150, -1, -1));

        jLabel6.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        jLabel6.setText("Fecha");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 240, -1, -1));

        jLabel9.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        jLabel9.setText("Importe");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 190, 70, 20));

        btn_Vender.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btn_Vender.setText("VENDER");
        btn_Vender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_VenderActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Vender, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 70, 100, 40));

        btn_eliminar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btn_eliminar.setText("ELIMINAR");
        btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 120, 110, 40));

        btn_actualizar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btn_actualizar.setText("ACTUALIZAR");
        btn_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_actualizarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 170, 130, 40));

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
        getContentPane().add(btn_limpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 220, 90, 70));

        btn_atras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/atrasflecha.png"))); // NOI18N
        btn_atras.setBorderPainted(false);
        btn_atras.setContentAreaFilled(false);
        btn_atras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_atrasActionPerformed(evt);
            }
        });
        getContentPane().add(btn_atras, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 40));

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel7.setText("VENTAS");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buscarbien.png"))); // NOI18N
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 10, -1, -1));

        txt_buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_buscarKeyPressed(evt);
            }
        });
        getContentPane().add(txt_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 10, 110, 30));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 820, 10));
        getContentPane().add(txt_idVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 80, -1));

        txt_idTrabajador.setEnabled(false);
        getContentPane().add(txt_idTrabajador, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, 70, -1));
        getContentPane().add(txt_numero, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 190, 70, -1));
        getContentPane().add(txt_Compañia, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 100, 80, 30));
        getContentPane().add(txt_Monto, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 140, 80, 30));
        getContentPane().add(txt_Importe, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 180, 80, 30));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setEnabled(false);
        jScrollPane2.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 520, 200));

        txt_dspoTelcel.setEnabled(false);
        getContentPane().add(txt_dspoTelcel, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 70, 40));

        txt_dispoMovistar.setEnabled(false);
        getContentPane().add(txt_dispoMovistar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 50, 70, 40));

        jLabel10.setText("TELCEL:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, -1, -1));

        jLabel11.setText("MOVISTAR:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 60, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_atrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_atrasActionPerformed
        this.dispose();
        Gerente g = new Gerente();
        g.setId(id);
        g.setVisible(true);
    }//GEN-LAST:event_btn_atrasActionPerformed

    private void btn_limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limpiarActionPerformed
        limpiarVenta();
    }//GEN-LAST:event_btn_limpiarActionPerformed

    private void btn_VenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_VenderActionPerformed
        Statement st;
        String datos[] = new String[100];
        datos[0] = txt_idVenta.getText();
        datos[1] = id;
        datos[2] = txt_numero.getText();
        datos[3] = txt_Compañia.getText();
        datos[4] = txt_Monto.getText();
        datos[5] = txt_Importe.getText();
       // boolean correcto=false;
        //int saldoTelceldispo;
        //int saldoTelcelVenta;
        //int saldoMovistardispo;
        //int saldoMovistarVenta;
        int importe, monto, cambio;
        importe = Integer.parseInt(datos[5]);
        monto = Integer.parseInt(datos[4]);
        cambio = importe - monto;
        if (importe < monto) {
            JOptionPane.showMessageDialog(null, "Importe menor");
        }
       
        /*if (datos[3].equals("Telcel")) {
            saldoTelceldispo = Integer.parseInt(txt_dspoTelcel.getText());
            saldoTelcelVenta = Integer.parseInt(datos[4]);
            if (saldoTelceldispo < saldoTelcelVenta) {
                JOptionPane.showMessageDialog(null, "SALDO TELCEL INSUFICIENTE");
                correcto=true;
                limpiarVenta();
                limpiarVenta();
                
            } else{
                JOptionPane.showMessageDialog(null, "SALDO TELCEL ");
            }
        } 
        if (datos[3].equals("Movistar")) {
            saldoMovistardispo = Integer.parseInt(txt_dispoMovistar.getText());
            saldoMovistarVenta = Integer.parseInt(txt_Monto.getText());
            if (saldoMovistardispo < saldoMovistarVenta) {
                JOptionPane.showMessageDialog(null, "SALDO MOVISTAR INSUFICIENTE");
                correcto=true;
                limpiarVenta();
                limpiarVenta();
                
            } else {
                JOptionPane.showMessageDialog(null, "SALDO MOVISTAR SUFICIENTE");
            }
        }*/

        datos[4] = Integer.toString(monto);
        
             if (datos[0].equals("") || datos[1].equals("") || datos[2].equals("") || datos[3].equals("") || datos[4].equals("")) {
            JOptionPane.showMessageDialog(null, "Debes llenar todos los campos  ");
            txt_idVenta.requestFocus();

        } else {
            try {
                String sql = ("insert venta(idVenta,idTrabajador_fk,NumTelefono,CompañiaVenta,Monto,Fecha) values(?,?,?,?,?,?)");
                st = cn.createStatement();
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setString(1, datos[0]);
                ps.setString(2, datos[1]);
                ps.setString(3, datos[2]);
                ps.setString(4, datos[3]);
                ps.setString(5, datos[4]);
               // ps.setString(6, ((JTextField) txt_fechaactual.getDateEditor().getUiComponent()).getText());
                ps.executeUpdate();
                modeloVenta.addRow(datos);
                JOptionPane.showMessageDialog(null, "Venta exitosa ||Cambio de: " + cambio);
            } catch (SQLException e) {
                Logger.getLogger(CsVenta.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        
       

        limpiarVenta();
    }//GEN-LAST:event_btn_VenderActionPerformed

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed
        Statement st;
        String dato = txt_idVenta.getText();
        if (dato.equals("")) {
            JOptionPane.showMessageDialog(null, "Debes poner el idVenta que deseas borrar");
        }
        try {
            String sql = "delete from venta where idVenta='" + dato + "'";

            st = cn.createStatement();
            st.executeUpdate(sql);
            int remover = tb_Venta2.getSelectedRow();
            modeloVenta.removeRow(remover);
            JOptionPane.showMessageDialog(null, "Registro eliminado con exito");

        } catch (SQLException e) {
            System.out.println("error");
            JOptionPane.showMessageDialog(null, "error al eliminar registro");
        }
        JOptionPane.showMessageDialog(null, "Registro eliminado con exito");

        limpiarVenta();
    }//GEN-LAST:event_btn_eliminarActionPerformed

    private void btn_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_actualizarActionPerformed
        Statement st;
        String datos[] = new String[50];
        datos[0] = txt_idVenta.getText();
        datos[1] = id;
        datos[2] = txt_numero.getText();
        datos[3] = txt_Compañia.getText();
        datos[4] = txt_Monto.getText();
        //txt_fechaactual.setCalendar(fecha);

        if (datos[0].equals("") || datos[1].equals("") || datos[2].equals("") || datos[3].equals("") || datos[4].equals("")) {
            JOptionPane.showMessageDialog(null, "Debes llenar todos los campos");
        }
        String sql = "update venta set idTrabajador_fk='" + datos[1] + "',NumTelefono='" + datos[2] + "',CompañiaVenta='" + datos[3] + "',Monto='" + datos[4] + "' where idVenta='" + datos[0] + "'";
        try {

            st = cn.createStatement();
            st.executeUpdate(sql);
            modeloVenta.fireTableDataChanged();
            JOptionPane.showMessageDialog(null, "Registro Actualizado");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar");
        }
        limpiarVenta();
    }//GEN-LAST:event_btn_actualizarActionPerformed

    private void tb_Venta2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_Venta2MouseClicked
        limpiarVenta();
        int col = tb_Venta2.getSelectedRow();
        txt_idVenta.setText(tb_Venta2.getModel().getValueAt(col, 0).toString());
        txt_idTrabajador.setText(tb_Venta2.getModel().getValueAt(col, 1).toString());
        txt_numero.setText(tb_Venta2.getModel().getValueAt(col, 2).toString());
        txt_Compañia.setText(tb_Venta2.getModel().getValueAt(col, 3).toString());
        txt_Monto.setText(tb_Venta2.getModel().getValueAt(col, 4).toString());
        Date date = null;
        try {
            date = new SimpleDateFormat("yyy-MM-d").parse((String) modeloVenta.getValueAt(col, 5));
        } catch (ParseException ex) {
            Logger.getLogger(CsCompra.class.getName()).log(Level.SEVERE, null, ex);
        }
       // txt_fechaactual.setDate(date);
        modeloVenta.fireTableDataChanged();

    }//GEN-LAST:event_tb_Venta2MouseClicked

    private void txt_buscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_buscarKeyPressed
        String[] titulos = {"idVenta", "Trabajador", "Numero Telefono", "Compañia", "Saldo", "Fecha"};
        String[] registros = new String[50];

        String sql = "Select * from venta where idVenta like '%" + txt_buscar.getText() + "%'"
                + "OR NumTelefono like '%" + txt_buscar.getText() + "%'"
                + "OR CompañiaVenta like '%" + txt_buscar.getText() + "%'"
                + "OR Monto like '%" + txt_buscar.getText() + "%'";
        modeloVenta = new DefaultTableModel(null, titulos);
        try {
            Connection cn = cc.conexion();
            Statement st = (Statement) cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                registros[0] = rs.getString("idVenta");
                registros[1] = rs.getString("idTrabajador_fk");
                registros[2] = rs.getString("NumTelefono");
                registros[3] = rs.getString("CompañiaVenta");
                registros[4] = rs.getString("Monto");
                registros[5] = rs.getString("Fecha");

                modeloVenta.addRow(registros);
            }
            tb_Venta2.setModel(modeloVenta);
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
            java.util.logging.Logger.getLogger(CsVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CsVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CsVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CsVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CsVenta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Vender;
    private javax.swing.JButton btn_actualizar;
    private javax.swing.JButton btn_atras;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_limpiar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTable tb_Venta2;
    private javax.swing.JTable tb_disponible;
    private javax.swing.JTextField txt_Compañia;
    private javax.swing.JTextField txt_Importe;
    private javax.swing.JTextField txt_Monto;
    private javax.swing.JTextField txt_buscar;
    private javax.swing.JTextField txt_dispoMovistar;
    private javax.swing.JTextField txt_dspoTelcel;
    private javax.swing.JTextField txt_idTrabajador;
    private javax.swing.JTextField txt_idVenta;
    private javax.swing.JTextField txt_numero;
    // End of variables declaration//GEN-END:variables

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
