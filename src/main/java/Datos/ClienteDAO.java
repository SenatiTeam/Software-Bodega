
package Datos;

import Datos.interfaces.clienteInterfaz;
import Entidades.Cliente;
import dataBase.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ClienteDAO implements clienteInterfaz <Cliente>{
    private final Conexion CON;
    private PreparedStatement ps;
    private ResultSet rs;
    private boolean resp;
    
    public ClienteDAO(){
        CON=Conexion.getInstancia();
    }

    @Override
    public List<Cliente> listar(String texto, int totalPorPagina, int numPagina) {
        List<Cliente> registros=new ArrayList();
        try {
            ps=CON.conectar().prepareStatement("SELECT * FROM clientes WHERE nombre_cliente LIKE ?");
            ps.setString(1,"%" + texto +"%");
            rs=ps.executeQuery();
            while(rs.next()){
                registros.add(new Cliente(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getString(7), rs.getBoolean(8)));
            }
            ps.close();
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"NO SE PUEDEN MOSTRAR A LOS CLIENTES REGISTRADOS " + e.getMessage());
        } finally{
            ps=null;
            rs=null;
            CON.desconectar();
        }
        return registros;
    }
    
    public List<Cliente> seleccionar() {
        List<Cliente> registros=new ArrayList();
        try {
            ps=CON.conectar().prepareStatement("SELECT id_Clientes, nombre_cliente FROM clientes ORDER BY nombre_cliente asc");
            rs=ps.executeQuery();
            while(rs.next()){
                registros.add(new Cliente(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
            }
            ps.close();
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"NO SE PUDO SELECCIONAR AL CLIENTE " + e.getMessage());
        } finally{
            ps=null;
            rs=null;
            CON.desconectar();
        }
        return registros;
    }

    @Override
    public boolean insertar(Cliente obj) {
        resp=false;
        try {
            ps=CON.conectar().prepareStatement("INSERT INTO clientes (nombre_cliente, tipo_cliente, tipo_documento, documento, telefono, direccion, condicion) VALUES (?,?,?,?,?,?,1)");
            ps.setString(1, obj.getNombre());
            ps.setString(2, obj.getTipo_cliente());
            ps.setString(3, obj.getTipo_documento());
            ps.setInt(4, obj.getDocumento());
            ps.setInt(5, obj.getTelefono());
            ps.setString(6, obj.getDireccion());
            if (ps.executeUpdate()>0){
                resp=true;
            }
            ps.close();
        }  catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"NO SE PUEDE INSERTAR UN NUEVO CLIENTE " + e.getMessage());
        } finally{
            ps=null;
            CON.desconectar();
        }
        return resp;
    }

    @Override
    public boolean actualizar(Cliente obj) {
        resp=false;
        try {
            ps=CON.conectar().prepareStatement("UPDATE clientes SET nombre_cliente=?, tipo_cliente=?, tipo_documento=?, documento=?, telefono=?, direccion=? WHERE id_Clientes=?");
            ps.setString(1, obj.getNombre());
            ps.setString(2, obj.getTipo_cliente());
            ps.setString(3, obj.getTipo_documento());
            ps.setInt(4, obj.getDocumento());
            ps.setInt(5, obj.getTelefono());
            ps.setString(6, obj.getDireccion());
            ps.setInt(7, obj.getId());
            if (ps.executeUpdate()>0){
                resp=true;
            }
            ps.close();
        }  catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"NO SE PUEDEN ACTUALIZAR LOS DATOS DEL CLIENTE " + e.getMessage());
        } finally{
            ps=null;
            CON.desconectar();
        }
        return resp;
    }

    @Override
    public boolean desactivar(int id) {
        resp=false;
        try {
            ps=CON.conectar().prepareStatement("UPDATE clientes SET condicion=0 WHERE id_Clientes=?");
            ps.setInt(1, id);
            if (ps.executeUpdate()>0){
                resp=true;
            }
            ps.close();
        }  catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"NO SE PUEDE DESCATIVAR AL CLIENTE " + e.getMessage());
        } finally{
            ps=null;
            CON.desconectar();
        }
        return resp;
    }

    @Override
    public boolean activar(int id) {
        resp=false;
        try {
            ps=CON.conectar().prepareStatement("UPDATE clientes SET condicion=1 WHERE id_Clientes=?");
            ps.setInt(1, id);
            if (ps.executeUpdate()>0){
                resp=true;
            }
            ps.close();
        }  catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"NO SE PUEDE ATIVAR AL CLIENTE " + e.getMessage());
        } finally{
            ps=null;
            CON.desconectar();
        }
        return resp;
    }

    @Override
    public int total() {
        int totalRegistros=0;
        try {
            ps=CON.conectar().prepareStatement("SELECT COUNT(id_Clientes) FROM clientes");            
            rs=ps.executeQuery();
            
            while(rs.next()){
                totalRegistros=rs.getInt("COUNT(id_Clientes)");
            }            
            ps.close();
            rs.close();
        }  catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"NO SE PUEDE CARGAR EL TOTAL DE LOS CLIENTES REGISTRADOS " + e.getMessage());
        } finally{
            ps=null;
            rs=null;
            CON.desconectar();
        }
        return totalRegistros;
    }

    @Override
    public boolean existe(String texto) {
        resp=false;
        try {
            ps=CON.conectar().prepareStatement("SELECT documento FROM clientes WHERE documento=?");
            ps.setInt(1, 0);
            rs=ps.executeQuery();
            rs.last();
            if(rs.getRow()>0){
                resp=true;
            }           
            ps.close();
            rs.close();
        }  catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"EL DOCUMENTO YA EXISTE " +  e.getMessage());
        } finally{
            ps=null;
            rs=null;
            CON.desconectar();
        }
        return resp;
    }
}
