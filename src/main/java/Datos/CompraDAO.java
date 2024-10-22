
package Datos;

import Datos.interfaces.compraInterfaz;
import Entidades.Compra;
import dataBase.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class CompraDAO implements compraInterfaz <Compra>{
    private final Conexion CON;
    private PreparedStatement ps;
    private ResultSet rs;
    private boolean resp;
    
    public CompraDAO(){
        CON=Conexion.getInstancia();
    }

    @Override
    public List<Compra> listar(String texto, int totalPorPagina, int numPagina) {
        List<Compra> registros=new ArrayList();
        try {
            ps=CON.conectar().prepareStatement("SELECT a.id_Compras, a.producto_id, pr.nombre_producto, a.proveedor_id, p.nombre, a.colaborador_id, c.nombre, "
                    + "a.tipo_comprobante, a.numero_comprobante, a.serie_comprobante, "
                    + "a.fecha_comprobante, a.igv, a.total, a.condicion "
                    + "FROM compras a "
                    + "INNER JOIN productos pr ON a.categoria_id=pr.id_Categorias "
                    + "INNER JOIN proveedores p ON a.proveedor_id=p.id_Proveedores "
                    + "INNER JOIN colaboradores c ON a.colaborador_id=c.id_Colaboradores"
                    + "WHERE a.numero_comprobante LIKE ? ORDER BY a.id_Compras ASC LIMIT ?,?,?,?");
            ps.setString(1,"%" + texto +"%");
            ps.setInt(2, (numPagina-1)*totalPorPagina);
            ps.setInt(3, totalPorPagina);
            rs=ps.executeQuery();
            while(rs.next()){
                registros.add(new Compra(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getString(5), 
                        rs.getString(6), rs.getString(7), rs.getString(8), rs.getDouble(9), rs.getDouble(10), rs.getBoolean(11)));
            }
            ps.close();
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"NO SE PUEDEN MOSTRAR LAS COMPRAS REGISTRADAS " + e.getMessage());
        } finally{
            ps=null;
            rs=null;
            CON.desconectar();
        }
        return registros;
    }

    @Override
    public boolean insertar(Compra obj) {
        resp=false;
        try {
            ps=CON.conectar().prepareStatement("INSERT INTO productos (producto_id, proveedor_id, colaborador_id, tipo_comprobante, numero_comprobante, "
                    + "serie_comprobante, fecha_comprobante, igv, total, condicion) VALUES (?,?,?,?,?,?,?,?,?,1)");
            ps.setInt(1, obj.getProductoId());
            ps.setInt(2, obj.getProveedorId());
            ps.setInt(3, obj.getColaboradorId());
            ps.setString(4, obj.getTipo_comprobante());
            ps.setString(5, obj.getNumero_comprobante());
            ps.setString(6, obj.getSerie_comprobante());
            ps.setString(7, obj.getFecha_comprobante());
            ps.setDouble(8, obj.getIgv());
            ps.setDouble(9, obj.getTotal());
            if (ps.executeUpdate()>0){
                resp=true;
            }
            ps.close();
        }  catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"NO SE PUEDE RESITRAR LA COMPRA " + e.getMessage());
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
            ps=CON.conectar().prepareStatement("UPDATE compras SET condicion=0 WHERE id_Compras=?");
            ps.setInt(1, id);
            if (ps.executeUpdate()>0){
                resp=true;
            }
            ps.close();
        }  catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"NO SE PUDO RECHAZAR LA VENTA " + e.getMessage());
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
            ps=CON.conectar().prepareStatement("UPDATE compras SET condicion=1 WHERE id_Compras=?");
            ps.setInt(1, id);
            if (ps.executeUpdate()>0){
                resp=true;
            }
            ps.close();
        }  catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"NO SE PUDO ACEPTAR LA VENTA " + e.getMessage());
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
            ps=CON.conectar().prepareStatement("SELECT COUNT(id_Compras) FROM compras");            
            rs=ps.executeQuery();
            
            while(rs.next()){
                totalRegistros=rs.getInt("COUNT(id_Compras)");
            }            
            ps.close();
            rs.close();
        }  catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"NO SE PUEDE CARGAR EL TOTAL DE LAS COMPRAS " + e.getMessage());
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
            ps=CON.conectar().prepareStatement("SELECT numero_comprobante FROM compras WHERE numero_comprobante=?");
            ps.setString(1, texto);
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
