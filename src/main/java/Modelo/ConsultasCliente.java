/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author Pau
 */
public class ConsultasCliente extends Conexion {

    public boolean registrar(Cliente pro) {
        PreparedStatement ps = null;

        String sql = "INSERT INTO clientes(nombre,apellido,dni,email,telefono,fecha_nacimiento,cobertura_medica) VALUES(?,?,?,?,?,?,?)";
        Connection con = getConexion();

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, pro.getNombre());
            ps.setString(2, pro.getApellido());
            ps.setInt(3, pro.getDni());
            ps.setString(4, pro.getEmail());
            ps.setInt(5, pro.getTelefono());
            ps.setDate(6, formatearFecha(pro.getFecha_nacimiento()));
            ps.setString(7, pro.getCobertura_medica());
            ps.execute();
            return true;
        } catch (Exception e) {
            System.err.println(e);
            return false;

        } finally {
            try {
                con.close();

            } catch (SQLException e) {
                System.err.println(e);
            }

        }
    }

    public boolean modificar(Cliente pro) {
        PreparedStatement ps = null;

        String sql = "UPDATE clientes SET nombre=?, apellido=?, dni=?, email=?, telefono=?, fecha_nacimiento=?, cobertura_medica=? WHERE id_cliente=?";
        Connection con = getConexion();

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, pro.getNombre());
            ps.setString(2, pro.getApellido());
            ps.setInt(3, pro.getDni());
            ps.setString(4, pro.getEmail());
            ps.setInt(5, pro.getTelefono());
            ps.setDate(6, formatearFecha(pro.getFecha_nacimiento()));
            ps.setString(7, pro.getCobertura_medica());
            ps.setInt(8, pro.getId_cliente());
            ps.execute();
            return true;

        } catch (SQLException e) {
            System.err.println(e);
            return false;

        } finally {
            try {
                con.close();

            } catch (SQLException e) {
                System.err.println(e);
            }

        }
    }

    public boolean eliminar(Cliente pro) {
        PreparedStatement ps = null;

        String sql = "DELETE FROM clientes WHERE id_cliente=?";
        Connection con = getConexion();

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, pro.getId_cliente());
            ps.execute();
            return true;

        } catch (SQLException e) {
            System.err.println(e);
            return false;

        } finally {
            try {
                con.close();

            } catch (SQLException e) {
                System.err.println(e);
            }

        }
    }

    public boolean buscar(Cliente pro) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = "SELECT FROM clientes WHERE dni=?";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, pro.getDni());
            rs = ps.executeQuery();
            if (rs.next()) {
                pro.setId_cliente(Integer.parseInt(rs.getString("id_cliente")));
                pro.setDni(Integer.parseInt(rs.getString("dni")));
                pro.setNombre(rs.getString("nombre"));
                pro.setApellido(rs.getString("apellido"));
                return true;
            }

            return false;

        } catch (SQLException e) {
            System.err.println(e);
            return false;

        } finally {
            try {
                con.close();

            } catch (SQLException e) {
                System.err.println(e);
            }

        }
    }

    private Date formatearFecha(String fechaString) throws ParseException {
        java.util.Date fechaNacimiento = new SimpleDateFormat("dd/MM/yyyy").parse(fechaString);
        return new Date(fechaNacimiento.getTime());
    }
}
