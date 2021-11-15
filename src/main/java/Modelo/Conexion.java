/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Pau
 */
public class Conexion {
    private final String base = "farmacia";
    private final String user = "root";
    private final String password = "";
    private final String url = "jdbc:mysql://localhost:3306/" + base;
    
    private Connection con = null;
    
    public Connection getConexion(){
        try{
           Class.forName("com.mysql.jbdc.Driver");
           con = (Connection) DriverManager.getConnection(this.url, this.user, this.password);
           
        } catch (Exception e) {
            System.err.println(e);
        }
        return con;
        


}
}

    


