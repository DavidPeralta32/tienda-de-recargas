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
public class Usuarios extends javax.swing.JFrame {

    DefaultTableModel modeloUsuario;
    private String id;
   // PlaceHolder holder;

    public Usuarios() {
        initComponents();
        this.setTitle("Usuarios");
        this.setLocation(400, 150);
        this.setResizable(false);
        this.getContentPane().setBackground(Color.WHITE);
        //holder = new PlaceHolder(txt_buscar, "Buscar");
        setIconImage(new ImageIcon(getClass().getResource("../Imagenes/iconrecarga.png")).getImage());

        cargar();

    }

    //metodo limpiar campos
    public void limpiar_usuario() {
        this.txt_id.setText("");
        this.txt_nombre.setText("");
        this.txt_apellido.setText("");
        this.txt_correo.setText("");
        this.txt_contraseña.setText("");
        this.txt_puesto.setText("");
        this.txt_turno.setText("");
        this.txt_horas.setText("");
        this.txt_dias.setText("");
        this.txt_sueldo.setText("");
    }

//metodo cargar
    public void cargar() {

        String[] titulos = {"Id", "Nombre", "Apellido", "Correo electronico", "Contraseña", "Puesto", "Turno", "Horas", "Dias", "Sueldo"};
        String[] registros = new String[100];

        String sql = "Select * from trabajador";
        modeloUsuario = new DefaultTableModel(null, titulos);
        Conexion cc = new Conexion();
        Connection cn = cc.conexion();
        try {
            Statement st = (Statement) cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                registros[0] = rs.getString("idTrabajador");
                registros[1] = rs.getString("NombreTrabajador");
                registros[2] = rs.getString("Apellido");
                registros[3] = rs.getString("CorreoElectronico");
                registros[4] = rs.getString("Contraseña");
                registros[5] = rs.getString("Puesto");
                registros[6] = rs.getString("Turno");
                registros[7] = rs.getString("HorasTrabajo");
                registros[8] = rs.getString("DiasTrabajo");
                registros[9] = rs.getString("Sueldo");

                modeloUsuario.addRow(registros);

            }
            tb_usuarios.setModel(modeloUsuario);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_usuarios = new javax.swing.JTable();
        btn_atras = new javax.swing.JButton();
        txt_buscar = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        btn_insertar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        txt_id = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_apellido = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_correo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_contraseña = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();
        txt_puesto = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txt_turno = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txt_horas = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txt_dias = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txt_sueldo = new javax.swing.JTextField();
        btn_eliminar = new javax.swing.JButton();
        btn_actualizar = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        btn_limpiar = new javax.swing.JButton();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tb_usuarios.setModel(new javax.swing.table.DefaultTableModel(
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
        tb_usuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_usuariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_usuarios);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, 640, 170));

        btn_atras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/atrasflecha.png"))); // NOI18N
        btn_atras.setBorderPainted(false);
        btn_atras.setContentAreaFilled(false);
        btn_atras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_atrasActionPerformed(evt);
            }
        });
        getContentPane().add(btn_atras, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 50, -1));

        txt_buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_buscarKeyPressed(evt);
            }
        });
        getContentPane().add(txt_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 180, 30));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 0, 20, 330));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buscarbien.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 30, 30));

        btn_insertar.setText("INGRESAR");
        btn_insertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_insertarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_insertar, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 140, -1, -1));

        jLabel2.setFont(new java.awt.Font("Ebrima", 1, 12)); // NOI18N
        jLabel2.setText("ID");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 20, -1));
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 480, 10));
        getContentPane().add(txt_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 40, -1));

        jLabel3.setFont(new java.awt.Font("Ebrima", 1, 12)); // NOI18N
        jLabel3.setText("Nombre:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        txt_nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_nombreKeyTyped(evt);
            }
        });
        getContentPane().add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 120, -1));

        jLabel4.setFont(new java.awt.Font("Ebrima", 1, 12)); // NOI18N
        jLabel4.setText("Apellido:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

        txt_apellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_apellidoKeyTyped(evt);
            }
        });
        getContentPane().add(txt_apellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, 120, -1));

        jLabel5.setFont(new java.awt.Font("Ebrima", 1, 12)); // NOI18N
        jLabel5.setText("Correo:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 50, 10));
        getContentPane().add(txt_correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, 120, -1));

        jLabel6.setFont(new java.awt.Font("Ebrima", 1, 12)); // NOI18N
        jLabel6.setText("Contraseña:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, -1, -1));
        getContentPane().add(txt_contraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 220, 120, -1));

        jLabel7.setFont(new java.awt.Font("Ebrima", 1, 12)); // NOI18N
        jLabel7.setText("Puesto");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, -1, -1));
        getContentPane().add(txt_puesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 270, 120, -1));

        jLabel8.setFont(new java.awt.Font("Ebrima", 1, 12)); // NOI18N
        jLabel8.setText("Turno");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 100, -1, -1));
        getContentPane().add(txt_turno, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 100, 120, -1));

        jLabel9.setFont(new java.awt.Font("Ebrima", 1, 12)); // NOI18N
        jLabel9.setText("Horas:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 140, -1, -1));

        txt_horas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_horasKeyTyped(evt);
            }
        });
        getContentPane().add(txt_horas, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 140, 120, -1));

        jLabel10.setFont(new java.awt.Font("Ebrima", 1, 12)); // NOI18N
        jLabel10.setText("Dias:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 180, -1, -1));

        txt_dias.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_diasKeyTyped(evt);
            }
        });
        getContentPane().add(txt_dias, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 180, 120, -1));

        jLabel11.setFont(new java.awt.Font("Ebrima", 1, 12)); // NOI18N
        jLabel11.setText("Sueldo:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 220, -1, -1));

        txt_sueldo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_sueldoKeyTyped(evt);
            }
        });
        getContentPane().add(txt_sueldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 220, 120, -1));

        btn_eliminar.setText("ELIMINAR");
        btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 200, -1, -1));

        btn_actualizar.setText("MODIFICAR");
        btn_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_actualizarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 260, -1, 30));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/usuario.jpg"))); // NOI18N
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 10, 100, 100));

        btn_limpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/limpiarbien.png"))); // NOI18N
        btn_limpiar.setBorderPainted(false);
        btn_limpiar.setContentAreaFilled(false);
        btn_limpiar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/limpiachico.png"))); // NOI18N
        btn_limpiar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/limpiagrande.png"))); // NOI18N
        btn_limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_limpiarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_limpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 250, 70, 70));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //regresar 
    private void btn_atrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_atrasActionPerformed
        this.dispose();
        Gerente ge = new Gerente();
        ge.setId(id);
        ge.setVisible(true);
    }//GEN-LAST:event_btn_atrasActionPerformed
    //boton buscar 
    private void txt_buscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_buscarKeyPressed
        String[] titulos = {"Id", "Nombre", "Apellido", "Correo electronico", "Contraseña", "Puesto", "Turno", "Horas", "Dias", "Sueldo"};
        String[] registros = new String[50];

        String sql = "Select * from trabajador Where idTrabajador LIKE'%" + txt_buscar.getText() + "%'"
                + "OR NombreTrabajador LIKE '%" + txt_buscar.getText() + "%'"
                + "OR Apellido LIKE '%" + txt_buscar.getText() + "%'"
                + "OR Puesto LIKE '%" + txt_buscar.getText() + "%'";
        modeloUsuario = new DefaultTableModel(null, titulos);
        Conexion cc = new Conexion();
        Connection cn = cc.conexion();
        try {
            Statement st = (Statement) cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                registros[0] = rs.getString("idTrabajador");
                registros[1] = rs.getString("NombreTrabajador");
                registros[2] = rs.getString("Apellido");
                registros[3] = rs.getString("CorreoElectronico");
                registros[4] = rs.getString("Contraseña");
                registros[5] = rs.getString("Puesto");
                registros[6] = rs.getString("Turno");
                registros[7] = rs.getString("HorasTrabajo");
                registros[8] = rs.getString("DiasTrabajo");
                registros[9] = rs.getString("Sueldo");
                modeloUsuario.addRow(registros);
            }

            tb_usuarios.setModel(modeloUsuario);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_txt_buscarKeyPressed

    private void btn_insertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_insertarActionPerformed
        Statement stmt = null;
        String[] datos = new String[10];
        datos[0] = txt_id.getText();
        datos[1] = txt_nombre.getText();
        datos[2] = txt_apellido.getText();
        datos[3] = txt_correo.getText();
        datos[4] = txt_contraseña.getText();
        datos[5] = txt_puesto.getText();
        datos[6] = txt_turno.getText();
        datos[7] = txt_dias.getText();
        datos[8] = txt_horas.getText();
        datos[9] = txt_sueldo.getText();

        for (int i = 0; i < tb_usuarios.getRowCount(); i++) {
            if (tb_usuarios.getValueAt(i, 0).equals(datos[0])) {
                JOptionPane.showMessageDialog(null, "Duplicado");
                limpiar_usuario();
                txt_id.requestFocus();
            }
        }
        if (datos[0] == null || datos[1].equals("") || datos[1].equals("") || txt_correo.getText().equals("") || txt_contraseña.getText().equals("")
                || txt_puesto.getText().equals("") || txt_turno.getText().equals("") || txt_horas.getText().equals("") || txt_dias.getText().equals("") || txt_sueldo.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
        } else {
            try {

                Conexion cc = new Conexion();
                Connection cn = cc.conexion();
                stmt = cn.createStatement();
                stmt.executeUpdate("Insert trabajador(IdTrabajador,NombreTrabajador,Apellido,CorreoElectronico,Contraseña,Puesto,Turno,HorasTrabajo,DiasTrabajo,Sueldo) VALUES('" + txt_id.getText() + "','" + txt_nombre.getText() + "','" + txt_apellido.getText() + "','" + txt_correo.getText() + "','" + txt_contraseña.getText() + "',"
                        + "'" + txt_puesto.getText() + "','" + txt_turno.getText() + "','" + txt_horas.getText() + "','" + txt_dias.getText() + "','" + txt_sueldo.getText() + "')");

            } catch (SQLException ex) {
                Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, null, "error");
            }
            JOptionPane.showMessageDialog(null, "Agregado correctamente");
            limpiar_usuario();
            modeloUsuario.addRow(datos);
        }

    }//GEN-LAST:event_btn_insertarActionPerformed

    private void txt_horasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_horasKeyTyped
        int c = evt.getKeyChar();
        if ((c < '0' || c > '9')) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_horasKeyTyped

    private void txt_diasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_diasKeyTyped
        int c = evt.getKeyChar();
        if ((c < '0' || c > '9')) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_diasKeyTyped

    private void txt_sueldoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_sueldoKeyTyped

    }//GEN-LAST:event_txt_sueldoKeyTyped

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed
        Statement stmt = null;

        if (txt_id.getText() == null) {
            JOptionPane.showMessageDialog(null, "Debe llenar el campo id");
        } else {
            try {

                Conexion cc = new Conexion();
                Connection cn = cc.conexion();
                stmt = cn.createStatement();
                stmt.executeUpdate("Delete from trabajador where IdTrabajador = '" + txt_id.getText() + "'");

            } catch (SQLException ex) {
                Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, null, "error");
            }
            JOptionPane.showMessageDialog(null, "Eliminado correctamente");

        }
        int remover = tb_usuarios.getSelectedRow();
        modeloUsuario.removeRow(remover);
        limpiar_usuario();
    }//GEN-LAST:event_btn_eliminarActionPerformed

    private void tb_usuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_usuariosMouseClicked
        limpiar_usuario();
        int col = tb_usuarios.getSelectedRow();
        txt_id.setText(tb_usuarios.getModel().getValueAt(col, 0).toString());
        txt_nombre.setText(tb_usuarios.getModel().getValueAt(col, 1).toString());
        txt_apellido.setText(tb_usuarios.getModel().getValueAt(col, 2).toString());
        txt_correo.setText(tb_usuarios.getModel().getValueAt(col, 3).toString());
        txt_contraseña.setText(tb_usuarios.getModel().getValueAt(col, 4).toString());
        txt_puesto.setText(tb_usuarios.getModel().getValueAt(col, 5).toString());
        txt_turno.setText(tb_usuarios.getModel().getValueAt(col, 6).toString());
        txt_horas.setText(tb_usuarios.getModel().getValueAt(col, 7).toString());
        txt_dias.setText(tb_usuarios.getModel().getValueAt(col, 8).toString());
        txt_sueldo.setText(tb_usuarios.getModel().getValueAt(col, 9).toString());
    }//GEN-LAST:event_tb_usuariosMouseClicked

    private void btn_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_actualizarActionPerformed
        Statement stmt = null;
        String[] datos = new String[10];
        datos[0] = txt_id.getText();
        datos[1] = txt_nombre.getText();
        datos[2] = txt_apellido.getText();
        datos[3] = txt_correo.getText();
        datos[4] = txt_contraseña.getText();
        datos[5] = txt_puesto.getText();
        datos[6] = txt_turno.getText();
        datos[7] = txt_dias.getText();
        datos[8] = txt_horas.getText();
        datos[9] = txt_sueldo.getText();
        if (datos[0] == null || datos[1].equals("") || datos[1].equals("") || txt_correo.getText().equals("") || txt_contraseña.getText().equals("")
                || txt_puesto.getText().equals("") || txt_turno.getText().equals("") || txt_horas.getText().equals("") || txt_dias.getText().equals("") || txt_sueldo.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
        } else {
            try {
                Conexion cc = new Conexion();
                Connection cn = cc.conexion();
                stmt = cn.createStatement();
                stmt.executeUpdate("update trabajador set NombreTrabajador ='" + datos[1] + "' ,Apellido ='" + datos[2] + "',CorreoElectronico ='" + datos[3] + "',Contraseña ='" + datos[4] + "',Puesto ='" + datos[5] + "',Turno ='" + datos[6] + "',HorasTrabajo ='" + datos[7] + "',DiasTrabajo ='" + datos[8] + "',Sueldo ='" + datos[9] + "'"
                        + "  where IdTrabajador = '" + txt_id.getText() + "'");

            } catch (SQLException ex) {
                Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, null, "error");
            }
            JOptionPane.showMessageDialog(null, "Actualizado correctamente");
            limpiar_usuario();
        }
    }//GEN-LAST:event_btn_actualizarActionPerformed

    private void txt_nombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nombreKeyTyped
        char c = evt.getKeyChar();
        if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && (c < ' ' || c > ' ')) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_nombreKeyTyped

    private void txt_apellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_apellidoKeyTyped
        char c = evt.getKeyChar();
        if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && (c < ' ' || c > ' ')) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_apellidoKeyTyped

    private void btn_limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limpiarActionPerformed
        limpiar_usuario();
    }//GEN-LAST:event_btn_limpiarActionPerformed

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
            java.util.logging.Logger.getLogger(Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Usuarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_actualizar;
    private javax.swing.JButton btn_atras;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_insertar;
    private javax.swing.JButton btn_limpiar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable tb_usuarios;
    private javax.swing.JTextField txt_apellido;
    private javax.swing.JTextField txt_buscar;
    private javax.swing.JPasswordField txt_contraseña;
    private javax.swing.JTextField txt_correo;
    private javax.swing.JTextField txt_dias;
    private javax.swing.JTextField txt_horas;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_puesto;
    private javax.swing.JTextField txt_sueldo;
    private javax.swing.JTextField txt_turno;
    // End of variables declaration//GEN-END:variables

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
