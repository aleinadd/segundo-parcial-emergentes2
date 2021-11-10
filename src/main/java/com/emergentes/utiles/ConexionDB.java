/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emergentes.utiles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class ConexionDB {
   static String driver = "com.mysql.jdbc.Driver" ;
    static String url = "jdbc:mysql://localhost:3306/bd_eventos";
    static String usuario = "root";
    static String password = "";
    Connection conn =null;

    public ConexionDB() {
  try  {
      // especificacion del driver
      Class.forName(driver);
      // establecemos la conex a la bd
      conn = DriverManager.getConnection(url ,usuario , password );
      // verificamos  si la conexxion fue exitosa
      if(conn !=null){
          System.out.println("Conexion OK:"+ conn);
      
      }
  }catch(ClassNotFoundException ex){
     Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE , null, ex);
  } catch (SQLException ex){
  Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE , null, ex);    
       }
  }
public Connection conectar()
{
    return conn;
}
public void desconectar()
{
    
try {
    conn.close();
} catch (SQLException ex){
    Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE , null, ex);
    
    
}
}
}