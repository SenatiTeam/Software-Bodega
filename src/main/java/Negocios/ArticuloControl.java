
package Negocios;

import Datos.ProductoDAO;
import Datos.CategoriaDAO;
import Entidades.Producto;
import Entidades.Categoria;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

public class ArticuloControl {
    private final ProductoDAO DATOS;
    private final CategoriaDAO DATOSCAT;
    private Producto obj;
    private DefaultTableModel modeloTabla;
    public int registrosMostrados;
    
    public ArticuloControl(){
        this.DATOS=new ProductoDAO();
        this.DATOSCAT=new CategoriaDAO();
        this.obj=new Producto();
        this.registrosMostrados=0;
    }
    
    public DefaultTableModel listar(String texto,int totalPorPagina,int numPagina){
        List<Producto> lista=new ArrayList();
        lista.addAll(DATOS.listar(texto,totalPorPagina,numPagina));
        
        String[] titulos={"ID","CATEGORÍA ID","NOMBRE DE CATEGORÍA","PROVEEDOR ID","NOMBRE DEL PROBVEEDOR","CÓDIGO","NOMBRE","MARCA",
            "PRECIO COMPRA","GANANCIA","STOCK","DESCIPCIÓN","FECHA DE VENCIMIENTO","IMAGEN","ESTADO"};
        this.modeloTabla=new DefaultTableModel(null,titulos);        
        
        String estado;
        String[] registro = new String[10];
        
        this.registrosMostrados=0;
        for (Producto item:lista){
            if (item.isActivo()){
                estado="Activo";
            } else{
                estado="Inactivo";
            }
            registro[0]=Integer.toString(item.getId());
            registro[1]=Integer.toString(item.getCategoriaId());
            registro[2]=item.getCategoriaNombre();
            registro[3]=Integer.toString(item.getProveedorId());
            registro[4]=item.getProveedorNombre();
            registro[5]=item.getCodigo();
            registro[6]=item.getNombre();
            registro[7]=item.getMarca();
            registro[8]=Double.toString(item.getPrecioCompra());
            registro[9]=Double.toString(item.getGanancia());
            registro[10]=Integer.toString(item.getStock());
            registro[11]=item.getDescripcion();
            registro[12]=item.getFecha_Vencimiento();
            registro[13]=item.getImagen();
            registro[14]=estado;
            this.modeloTabla.addRow(registro);
            this.registrosMostrados=this.registrosMostrados+1;
        }
        return this.modeloTabla;
    }
    
    public DefaultComboBoxModel seleccionar(){
        DefaultComboBoxModel items= new DefaultComboBoxModel();
        List<Categoria> lista=new ArrayList();
        lista=DATOSCAT.seleccionar();
        for (Categoria item: lista){
            items.addElement(new Categoria(item.getId(),item.getNombre()));
        }
        return items;
    }
    
    public String insertar(int categoriaId, int proveedorId, String nombre, String marca, double precioCompra, double ganacia, int stock,String descripcion, String fecha_vencimiento, String imagen){
        if (DATOS.existe(nombre)){
            return "El registro ya existe.";
        }else{
            obj.setCategoriaId(categoriaId);
            obj.setProveedorId(proveedorId);
            obj.setNombre(nombre);
            obj.setMarca(marca);
            obj.setPrecioCompra(precioCompra);
            obj.setGanancia(ganacia);
            obj.setStock(stock);
            obj.setDescripcion(descripcion);
            obj.setFecha_Vencimiento(fecha_vencimiento);
            obj.setImagen(imagen);
            if (DATOS.insertar(obj)){
                return "OK";
            }else{
                return "Error en el registro.";
            }
        }
    }
    
    public String actualizar(int id,int categoriaId, String codigo, String nombre, String nombreAnt, double precioCompra, int stock,String descripcion, String imagen){
        if (nombre.equals(nombreAnt)){
            obj.setId(id);
            obj.setCategoriaId(categoriaId);
            obj.setCodigo(codigo);
            obj.setNombre(nombre);
            obj.setPrecioCompra(precioCompra);
            obj.setStock(stock);
            obj.setDescripcion(descripcion);
            obj.setImagen(imagen);
            if(DATOS.actualizar(obj)){
                return "OK";
            }else{
                return "Error en la actualización.";
            }
        }else{
            if (DATOS.existe(nombre)){
                return "El registro ya existe.";
            }else{
                obj.setId(id);
                obj.setCategoriaId(categoriaId);
                obj.setCodigo(codigo);
                obj.setNombre(nombre);
                obj.setPrecioCompra(precioCompra);
                obj.setStock(stock);
                obj.setDescripcion(descripcion);
                obj.setImagen(imagen);
                if (DATOS.actualizar(obj)){
                    return "OK";
                }else{
                    return "Error en la actualización.";
                }
            }
        }
    }
    
    public String desactivar(int id){
        if (DATOS.desactivar(id)){
            return "OK";
        }else{
            return "No se puede desactivar el registro";
        }
    }
    
    public String activar(int id){
        if (DATOS.activar(id)){
            return "OK";
        }else{
            return "No se puede activar el registro";
        }
    }
    
    public int total(){
        return DATOS.total();
    }
    
    public int totalMostrados(){
        return this.registrosMostrados;
    }
}
