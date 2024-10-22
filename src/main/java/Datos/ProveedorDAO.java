
package Datos;

import Datos.interfaces.proveedorInterfaz;
import Entidades.Proveedor;
import dataBase.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ProveedorDAO implements proveedorInterfaz <Proveedor>{
    private final Conexion CON;
    private PreparedStatement ps;
    private ResultSet rs;
    private boolean resp;
    
    public ProveedorDAO(){
        CON=Conexion.getInstancia();
    }

    @Override
    public List<Proveedor> listar(String texto, int totalPorPagina, int numPagina) {
        List<Proveedor> registros=new ArrayList();
        try {
            ps=CON.conectar().prepareStatement("SELECT * FROM proveedores WHERE nombre LIKE ?");
            ps.setString(1,"%" + texto +"%");
            rs=ps.executeQuery();
            while(rs.next()){
                registros.add(new Proveedor(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getString(6), rs.getBoolean(7)));
            }
            ps.close();
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"NO SE PUEDEN MOSTRAR A LOS PROVEEDORES REGISTRADOR " + e.getMessage());
        } finally{
            ps=null;
            rs=null;
            CON.desconectar();
        }
        return registros;
    }

    @Override
    public boolean insertar(Proveedor obj) {
        resp=false;
        try {
            ps=CON.conectar().prepareStatement("INSERT INTO proveedores (nombre, tipo_proveedor, documento, telefono, direccion, condicion) VALUES (?,?,?,?,?,1)");
            ps.setString(1, obj.getNombre());
            ps.setString(2, obj.getTipo_proveedor());
            ps.setInt(3, obj.getDocumento());
            ps.setInt(4, obj.getTelefono());
            ps.setString(5, obj.getDireccion());
            if (ps.executeUpdate()>0){
                resp=true;
            }
            ps.close();
        }  catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"NO SE PUDO INSERTAR AL PROVEEDOR " + e.getMessage());
        } finally{
            ps=null;
            CON.desconectar();
        }
        return resp;
    }

    @Override
    public boolean actualizar(Proveedor obj) {
        resp=false;
        try {
            ps=CON.conectar().prepareStatement("UPDATE proveedores SET nombre=?, tipo_proveedor=?, documento=?, telefono=?, direccion=? WHERE id_Proveedores=?");
            ps.setString(1, obj.getNombre());
            ps.setString(2, obj.getTipo_proveedor());
            ps.setInt(3, obj.getDocumento());
            ps.setInt(4, obj.getTelefono());
            ps.setString(5, obj.getDireccion());
            ps.setInt(6, obj.getId());
            if (ps.executeUpdate()>0){
                resp=true;
            }
            ps.close();
        }  catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"NO SE PUDO ACTUALIZAR LOS DATOS DEL PROVEEDOR " + e.getMessage());
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
            ps=CON.conectar().prepareStatement("UPDATE proveedores SET condicion=0 WHERE id_Proveedores=?");
            ps.setInt(1, id);
            if (ps.executeUpdate()>0){
                resp=true;
            }
            ps.close();
        }  catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"NO SE PUEDE DESACTIVAR AL PROVEEDOR " + e.getMessage());
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
            ps=CON.conectar().prepareStatement("UPDATE proveedores SET condicion=0 WHERE id_Proveedores=?");
            ps.setInt(1, id);
            if (ps.executeUpdate()>0){
                resp=true;
            }
            ps.close();
        }  catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"NO SE PUEDE ACTIVAR AL PROVEEDOR " + e.getMessage());
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
            ps=CON.conectar().prepareStatement("SELECT COUNT(id_Proveedores) FROM proveedores");            
            rs=ps.executeQuery();
            
            while(rs.next()){
                totalRegistros=rs.getInt("COUNT(id_proveedores)");
            }            
            ps.close();
            rs.close();
        }  catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"NO SE PUEDE CARGAR EL TOTAL DE LOS PROVEEDORES " + e.getMessage());
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
            ps=CON.conectar().prepareStatement("SELECT documento FROM proveedores WHERE documento=?");
            ps.setInt(1, 0);
            rs=ps.executeQuery();
            rs.last();
            if(rs.getRow()>0){
                resp=true;
            }           
            ps.close();
            rs.close();
        }  catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"ERROR " +  e.getMessage());
        } finally{
            ps=null;
            rs=null;
            CON.desconectar();
        }
        return resp;
    }
}
