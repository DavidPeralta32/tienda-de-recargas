/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONECTAR;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;


public class Conexion {

    Connection conect = null;

    public Connection conexion() {
        try {

            
            String url="jdbc:mysql://localhost:3306/recargasperitas?useTimezone=true&serverTimezone=UTC"; 
            String usuario = "root";
            String contraseña = "CYtyestylo123";
            Class.forName("com.mysql.cj.jdbc.Driver");
            
             conect = DriverManager.getConnection(url,usuario,contraseña); 
                  if ( conect != null ) 
                    System.out.println("Se ha establecido una conexión a la base de datos " +  
                                       "\n " + url ); 
  
           // JOptionPane.showMessageDialog(null, "exito de conexion");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de conexion" + e);
        }
        return conect;
    }
}
