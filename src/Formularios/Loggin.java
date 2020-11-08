
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
import javax.swing.JTextField;

/**
 *
 * @author Davi_
 */
public class Loggin extends javax.swing.JFrame {

    Conexion cc = new Conexion();
    Connection cn = cc.conexion();
   // PlaceHolder holder;
    public Loggin() {
        initComponents();
        this.setTitle("Inicio de sesion");
        this.setResizable(false);
        this.setBackground(Color.black);
        this.setLocationRelativeTo(null);
       // holder= new PlaceHolder(txt_nombre,"nombre usuario");
        //holder= new PlaceHolder(txt_contraseña,"*********");
        setIconImage(new ImageIcon(getClass().getResource("../Imagenes/iconrecarga.png")).getImage());
    }

    public String user() {
        String usuario1 = txt_nombre.getText();
        return usuario1;
    }

    void acceder(String usuario, String pass) {
        String cap = "";
        String id="";
        String sql = "Select * from trabajador where NombreTrabajador='" + usuario + "'&& Contraseña='" + pass + "'";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                cap = rs.getString("Puesto");
                id=rs.getString("idTrabajador");
            }
            if (cap.equals("Gerente") || cap.equalsIgnoreCase("Encargado turno") || cap.equals("jefe turno")) {
                this.setVisible(false);
                JOptionPane.showMessageDialog(null, "Bienvenido "+usuario);
                Gerente ge = new Gerente();
                ge.setId(id);
                ge.setVisible(true);
                ge.pack();

            }
            if (cap.equals("Cajero")) {
                this.setVisible(false);
                JOptionPane.showMessageDialog(null, "Bienvenido Cajero "+usuario);
                Cajero ca = new Cajero();
                ca.setId(id);
                System.out.println(id);
                ca.setVisible(true);
                ca.pack();

            }
            if ((!cap.equals("Gerente")) && (!cap.equals("Cajero")) && (!cap.equals("Encargado turno")) && (!cap.equals("jefe turno"))) {
                JOptionPane.showMessageDialog(null, "acceso denegado");

            }
        } catch (SQLException ex) {
            Logger.getLogger(Loggin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btn_aceptar = new javax.swing.JButton();
        txt_nombre = new javax.swing.JTextField();
        txt_contraseña = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("INICIO DE SESION");
        setLocation(new java.awt.Point(450, 250));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ID_USUARIO");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 90, 30));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("CONTRASEÑA");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 100, 30));

        btn_aceptar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btn_aceptar.setText("INICIAR SESION");
        btn_aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_aceptarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_aceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 230, 150, 40));
        getContentPane().add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 120, 30));
        getContentPane().add(txt_contraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, 120, 30));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/imagerecar.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 30, 180, -1));

        jSeparator2.setForeground(new java.awt.Color(51, 51, 51));
        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 0, 10, 290));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/loggin.png"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 90, 90));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondocajero.jpg"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 480, 290));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_aceptarActionPerformed
        String usuario = txt_nombre.getText();
        String pass = new String(txt_contraseña.getPassword());
        acceder(usuario, pass);
        this.txt_contraseña.setText("");
    }//GEN-LAST:event_btn_aceptarActionPerformed

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
            java.util.logging.Logger.getLogger(Loggin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Loggin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Loggin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Loggin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Loggin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_aceptar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPasswordField txt_contraseña;
    public static javax.swing.JTextField txt_nombre;
    // End of variables declaration//GEN-END:variables

    //objetos de la clase conectar 
}
