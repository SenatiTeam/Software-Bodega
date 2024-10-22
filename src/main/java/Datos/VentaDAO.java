
package Datos;

import Datos.interfaces.ventaInterfaz;
import Entidades.Venta;
import dataBase.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class VentaDAO implements ventaInterfaz <Venta>{
    private final Conexion CON;
    private PreparedStatement ps;
    private ResultSet rs;
    private boolean resp;
    
    public VentaDAO(){
        CON=Conexion.getInstancia();
    }

    @Override
    public List<Venta> listar(String texto, int totalPorPagina, int numPagina) {
        List<Venta> registros=new ArrayList();
        try {
            ps=CON.conectar().prepareStatement("SELECT a.id_Ventas, a.producto_id, pr.nombre_producto, a.cliente_id, p.nombre, a.colaborador_id, c.nombre, "
                    + "a.tipo_comprobante, a.numero_comprobante, a.serie_comprobante, a.fecha_venta, a.precio_venta, a.igv, a.total, a.condicion"
                    + "FROM Ventas a "
                    + "INNER JOIN productos pr ON a.categoria_id=pr.id_Categorias "
                    + "INNER JOIN clientes p ON a.cliente_id=p.id_Clientes "
                    + "INNER JOIN colaboradores c ON a.colaborador_id=c.id_Colaboradores"
                    + "WHERE a.numero_comprobante LIKE ? ORDER BY a.id_Ventas ASC LIMIT ?,?,?,?");
            ps.setString(1,"%" + texto +"%");
            ps.setInt(2, (numPagina-1)*totalPorPagina);
            ps.setInt(3, totalPorPagina);
            rs=ps.executeQuery();
            while(rs.next()){
                registros.add(new Venta(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getString(5), 
                        rs.getString(6), rs.getString(7), rs.getString(8), rs.getDouble(9), rs.getDouble(10), rs.getDouble(11), rs.getBoolean(12)));
            }
            ps.close();
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"NO SE PUEDEN MOSTRAR LAS VENTAS REGISTRADAS " + e.getMessage());
        } finally{
            ps=null;
            rs=null;
            CON.desconectar();
        }
        return registros;
    }

    @Override
    public boolean insertar(Venta obj) {
        resp=false;
        try {
            ps=CON.conectar().prepareStatement("INSERT INTO productos (producto_id, cliente_id, colaborador_id, tipo_comprobante, numero_comprobante, "
                    + "serie_comprobante, fecha_venta, precio_venta, igv, total, condicion) VALUES (?,?,?,?,?,?,?,?,?,?,1)");
            ps.setInt(1, obj.getProductoId());
            ps.setInt(2, obj.getClienteId());
            ps.setInt(3, obj.getColaboradorId());
            ps.setString(4, obj.getTipo_comprobante());
            ps.setString(5, obj.getNumero_comprobante());
            ps.setString(6, obj.getSerie_comprobante());
            ps.setString(7, obj.getFecha_venta());
            ps.setDouble(8, obj.getPrecio_venta());
            ps.setDouble(9, obj.getIgv());
            ps.setDouble(10, obj.getTotal());
            if (ps.executeUpdate()>0){
                resp=true;
            }
            ps.close();
        }  catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"NO SE PUEDE REGISTRAR LA VENTA " + e.getMessage());
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
            ps=CON.conectar().prepareStatement("UPDATE ventas SET condicion=0 WHERE id_Ventas=?");
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
            ps=CON.conectar().prepareStatement("UPDATE ventas SET condicion=1 WHERE id_Ventas=?");
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
            ps=CON.conectar().prepareStatement("SELECT COUNT(id_Ventas) FROM ventas");            
            rs=ps.executeQuery();
            
            while(rs.next()){
                totalRegistros=rs.getInt("COUNT(id_Ventas)");
            }            
            ps.close();
            rs.close();
        }  catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"NO SE PUEDE CARGAR EL TOTAL DE LAS VENTAS " + e.getMessage());
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
            ps=CON.conectar().prepareStatement("SELECT numero_comprobante FROM ventas WHERE numero_comprobante=?");
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
