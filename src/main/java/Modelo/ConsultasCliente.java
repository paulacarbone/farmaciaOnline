/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Pau
 */
public class ConsultasCliente extends Conexion{
    
    public boolean registrar(Cliente pro){
    PreparedStatement ps = null;
    
    String sql = "INSERT INTO clientes(nombre,apellido,dni,email,telefono,fecha_nacimiento,cobertura_medica) VALUES(?,?,?,?,?,?,?)";
    Connection con = getConexion();
    
    try{
        ps = con.prepareStatement(sql);
        ps.setString(1, pro.getNombre());
        ps.setString(2, pro.getApellido());
        ps.setInt(3, pro.getDni());
        ps.setString(4, pro.getEmail());
        ps.setInt(5, pro.getTelefono());
        ps.setInt(6, pro.getFecha_nacimiento());
        ps.setString(7, pro.getCobertura_medica());
        ps.execute();
        return true;
        
    } catch(SQLException e){
         System.err.println(e);
         return false;
    
    } finally{
        try{
            con.close();
            
        } catch(SQLException e){
            System.err.println(e);
        }
    
    }
    }
       public boolean modificar(Cliente pro){
    PreparedStatement ps = null;
    
    String sql = "UPDATE clientes SET nombre=?, apellido=?, dni=?, email=?, telefono=?, fecha_nacimiento=?, cobertura_medica=? WHERE id_cliente=?";
    Connection con = getConexion();
    
    try{
        ps = con.prepareStatement(sql);
        ps.setString(1, pro.getNombre());
        ps.setString(2, pro.getApellido());
        ps.setInt(3, pro.getDni());
        ps.setString(4, pro.getEmail());
        ps.setInt(5, pro.getTelefono());
        ps.setInt(6, pro.getFecha_nacimiento());
        ps.setString(7, pro.getCobertura_medica());
        ps.setInt(8, pro.getId_cliente());
        ps.execute();
        return true;
        
    } catch(SQLException e){
         System.err.println(e);
         return false;
    
    } finally{
        try{
            con.close();
            
        } catch(SQLException e){
            System.err.println(e);
        }
    
    }
    } 
}
