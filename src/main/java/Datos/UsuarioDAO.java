
package Datos;

import Datos.interfaces.usuarioInterfaz;
import Entidades.Usuario;
import dataBase.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class UsuarioDAO implements usuarioInterfaz <Usuario>{
    private final Conexion CON;
    private PreparedStatement ps;
    private ResultSet rs;
    private boolean resp;
    
    public UsuarioDAO(){
        CON=Conexion.getInstancia();
    }

    @Override
    public List<Usuario> listar(String texto, int totalPorPagina, int numPagina) {
        List<Usuario> registros=new ArrayList();
        try {
            ps=CON.conectar().prepareStatement("SELECT c.id_Colaboradores, c.rol_id, r.nombre, c.nombre, c.tipo_documento, "
                    + "c.documento, c.telefono, c.direccion, c.fecha_contrato, c.email, c.clave, c.foto, c.condicion"
                    + "FROM colaboradores c "
                    + "INNER JOIN roles r ON a.rol_id=r.id_Rol "
                    + "WHERE a.nombre LIKE ? ORDER BY c.id_Colaboradores ASC LIMIT ?,?");
            ps.setString(1,"%" + texto +"%");
            rs=ps.executeQuery();
            while(rs.next()){
                registros.add(new Usuario(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6), 
                        rs.getInt(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getBoolean(12)));
            }
            ps.close();
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"NO SE PUEDEN MOSTRAR A LOS USUARIOS " + e.getMessage());
        } finally{
            ps=null;
            rs=null;
            CON.desconectar();
        }
        return registros;
    }

    @Override
    public boolean insertar(Usuario obj) {
        resp=false;
        try {
            ps=CON.conectar().prepareStatement("INSERT INTO colaboradores (rol_id, nombre, tipo_documento, documento, telefono, direccion, fecha_contrato, email, clave, foto, condicion) VALUES (?,?,?,?,?,?,?,?,?,?,1)");
            ps.setInt(1, obj.getRolId());
            ps.setString(2, obj.getNombre());
            ps.setString(3, obj.getTipoDocumento());
            ps.setInt(4, obj.getNumDocumento());
            ps.setInt(5, obj.getTelefono());
            ps.setString(6, obj.getDireccion());
            ps.setString(7, obj.getFecha_contrato());
            ps.setString(8, obj.getEmail());
            ps.setString(9, obj.getClave());
            ps.setString(10, obj.getFoto());
            if (ps.executeUpdate()>0){
                resp=true;
            }
            ps.close();
        }  catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"NO SE PUDO REGISTRAR AL USUARIO " + e.getMessage());
        } finally{
            ps=null;
            CON.desconectar();
        }
        return resp;
    }

    @Override
    public boolean actualizar(Usuario obj) {
        resp=false;
        try {
            ps=CON.conectar().prepareStatement("UPDATE categorias SET rol_id=?, nombre=?, tipo_documento=?, documento=?, telefono=?, direccion=?, fecha_contrato=?, email=?, clave=?, foto=? WHERE id_Colaboradores=?");
            ps.setInt(1, obj.getRolId());
            ps.setString(2, obj.getNombre());
            ps.setString(3, obj.getTipoDocumento());
            ps.setInt(4, obj.getNumDocumento());
            ps.setInt(5, obj.getTelefono());
            ps.setString(6, obj.getDireccion());
            ps.setString(7, obj.getFecha_contrato());
            ps.setString(8, obj.getEmail());
            ps.setString(9, obj.getClave());
            ps.setString(10, obj.getFoto());
            ps.setInt(11, obj.getId());
            ps.setInt(3, obj.getId());
            if (ps.executeUpdate()>0){
                resp=true;
            }
            ps.close();
        }  catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"NO SE PUDO ACTUALIZAR LOS DATOS DEL USUARIO " + e.getMessage());
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
            ps=CON.conectar().prepareStatement("UPDATE colaboradores SET condicion=0 WHERE id_Colaboradores=?");
            ps.setInt(1, id);
            if (ps.executeUpdate()>0){
                resp=true;
            }
            ps.close();
        }  catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"NO SE PUEDE DESACTIVAR AL USUARIO " + e.getMessage());
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
            ps=CON.conectar().prepareStatement("UPDATE colaboradores SET condicion=1 WHERE id_Colaboradores=?");
            ps.setInt(1, id);
            if (ps.executeUpdate()>0){
                resp=true;
            }
            ps.close();
        }  catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"NO SE PUEDE ACTIVAR AL USUARIO " + e.getMessage());
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
            ps=CON.conectar().prepareStatement("SELECT COUNT(id_Colaboradores) FROM colaboradores");            
            rs=ps.executeQuery();
            
            while(rs.next()){
                totalRegistros=rs.getInt("COUNT(id_Colaboradores)");
            }            
            ps.close();
            rs.close();
        }  catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"NO SE PUEDE CARGAR EL TOTAL DE LOS USUARIOS " + e.getMessage());
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
            ps=CON.conectar().prepareStatement("SELECT documento FROM colaboradores WHERE documento=?");
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
