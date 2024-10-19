
package Datos;

import Entidades.Producto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import dataBase.Conexion;
import datos.interfaces.CrudPaginadoInterface;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ProductoDAO implements CrudPaginadoInterface<Producto> {
    private final Conexion CON;
    private PreparedStatement ps;
    private ResultSet rs;
    private boolean resp;
    
    public ProductoDAO(){
        CON=Conexion.getInstancia();
    }
    
    
    @Override
    public List<Producto> listar(String texto,int totalPorPagina,int numPagina) {
        List<Producto> registros=new ArrayList();
        try {
            ps=CON.conectar().prepareStatement("SELECT a.id_Productos,a.categoria_id, c.nombre as categoria_nombre, a.proveedor_id, p.nombre as proveedor_nombre, a.codigo_producto, a.nombre_producto, a.marca_producto, a.precio_compra, a.ganancia, a.cantidad_producto, "
                    + "a.descripcion_producto, a.imagen_producto, a.condicion FROM productos a inner join categorias c ON a.categoria_id=c.id_Categorias inner join proveedores p on a.categoria_id=p.id_Proveedores WHERE a.nombre_producto LIKE ? ORDER BY a.id_Productos ASC LIMIT ?,?");
            ps.setString(1,"%" + texto +"%");            
            ps.setInt(2, (numPagina-1)*totalPorPagina);
            ps.setInt(3, totalPorPagina);
            rs=ps.executeQuery();
            while(rs.next()){
                registros.add(new Producto(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7), 
                        rs.getString(8), rs.getDouble(9), rs.getDouble(10), rs.getInt(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getBoolean(15)));
            }
            ps.close();
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"MO SE PUDO MOSTRAR LOS PRODUCTOS REGISTRADOS " + e.getMessage());
        } finally{
            ps=null;
            rs=null;
            CON.desconectar();
        }
        return registros;
    }

    @Override
    public boolean insertar(Producto obj) {
        resp=false;
        try {
            ps=CON.conectar().prepareStatement("INSERT INTO productos (categoria_id, proveedor_id,codigo_producto,nombre_producto, marca_producto,precio_compra, "
                    + "ganancia,cantidad_producto,descripcion_producto,fecha_vencimiento,imagen_producto,condicion) VALUES (?,?,?,?,?,?,?,?,?,?,?,1)");
            ps.setInt(1,obj.getCategoriaId());
            ps.setInt(2, obj.getProveedorId());
            ps.setString(3, obj.getCodigo());
            ps.setString(4, obj.getNombre());
            ps.setString(5, obj.getMarca());
            ps.setDouble(6, obj.getPrecioCompra());
            ps.setDouble(7, obj.getGanancia());
            ps.setInt(8, obj.getStock());
            ps.setString(9, obj.getDescripcion());
            ps.setString(10, obj.getFecha_Vencimiento());
            ps.setString(11, obj.getImagen());
            if (ps.executeUpdate()>0){
                resp=true;
            }
            ps.close();
        }  catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "NO SE PUDIERON INSERTAR LOS DATOS " + e.getMessage());
        } finally{
            ps=null;
            CON.desconectar();
        }
        return resp;
    }

    @Override
    public boolean actualizar(Producto obj) {
        resp=false;
        try {
            ps=CON.conectar().prepareStatement("UPDATE productos SET categoria_id=?, codigo_producto=?, nombre_producto=?, ganacia=?, cantidad_producto=?, descripcion_producto=?, imagen_producto=? WHERE id_Productos=?");
            ps.setInt(1,obj.getCategoriaId());
            ps.setString(2, obj.getCodigo());
            ps.setString(3, obj.getNombre());
            ps.setDouble(4, obj.getGanancia());
            ps.setInt(5, obj.getStock());
            ps.setString(6, obj.getDescripcion());
            ps.setString(7, obj.getImagen());
            ps.setInt(8, obj.getId());
            if (ps.executeUpdate()>0){
                resp=true;
            }
            ps.close();
        }  catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"NO FUE POSIBLE ACTUALIZAR LOS DATOS " +  e.getMessage());
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
            ps=CON.conectar().prepareStatement("UPDATE productos SET condicion=0 WHERE id_Productos=?");
            ps.setInt(1, id);
            if (ps.executeUpdate()>0){
                resp=true;
            }
            ps.close();
        }  catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"NO FUE POSIBLE DESACTIVAR LA CATEGORIA " +  e.getMessage());
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
            ps=CON.conectar().prepareStatement("UPDATE productos SET condicion=1 WHERE id_Productos=?");
            ps.setInt(1, id);
            if (ps.executeUpdate()>0){
                resp=true;
            }
            ps.close();
        }  catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "NO FUE POSIBLE ACTIVAR LA CATEGORIA " + e.getMessage());
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
            ps=CON.conectar().prepareStatement("SELECT COUNT(id_Productos) FROM productos");            
            rs=ps.executeQuery();
            
            while(rs.next()){
                totalRegistros=rs.getInt("COUNT(id_Productos)");
            }            
            ps.close();
            rs.close();
        }  catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"NO FUE POSIBLE MOSTRAR EL TOTAL DE REGISTROS " + e.getMessage());
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
            ps=CON.conectar().prepareStatement("SELECT nombre_producto FROM productos WHERE nombre_producto=?");
            ps.setString(1, texto);
            rs=ps.executeQuery();
            rs.last();
            if(rs.getRow()>0){
                resp=true;
            }           
            ps.close();
            rs.close();
        }  catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"NO FUE POSIBLE REALIZAR LA ACCIÓN " + e.getMessage());
        } finally{
            ps=null;
            rs=null;
            CON.desconectar();
        }
        return resp;
    }
}
