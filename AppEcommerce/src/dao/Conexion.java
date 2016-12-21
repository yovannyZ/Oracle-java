
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.sql.*;

/**
 *
 * @author yzeballos
 */
public class Conexion {
 
 private static Connection cn;
 private static Conexion instance;
 
 private Conexion(){
     try {  
         String connectionUrl = "jdbc:sqlserver://localhost:1433;" +
                     "databaseName=DBCOMMERCE;integratedSecurity=true;"; 
         
         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
         cn = DriverManager.getConnection(connectionUrl);
         
     } catch (Exception e) {
         e.printStackTrace();
     }
 }

public static Conexion getInstance(){
    
    if(instance == null){
        instance = new Conexion();
    }
    return instance;
}

public static Connection Conectar(){
    return cn;
}
}
