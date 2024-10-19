
package Entidades;

import java.util.Date;

public class Producto {
    private int id;
    private int categoriaId;
    private String categoriaNombre;
    private int proveedorId;
    private String proveedorNombre;
    private String codigo;
    private String nombre;
    private String marca;
    private double precioCompra;
    private double ganancia;
    private int stock;
    private String descripcion;
    private String imagen;
    private String fecha_Vencimiento;
    private boolean activo;
    
    // Constructores
    
    public Producto() {
    }

    public Producto(int id, int categoriaId, String categoriaNombre, int proveedorId, String proveedorNombre, String codigo, String nombre, String marca, double precioCompra, double ganancia, int stock, String descripcion, String imagen, String fecha_Vencimiento, boolean activo) {
        this.id = id;
        this.categoriaId = categoriaId;
        this.categoriaNombre = categoriaNombre;
        this.proveedorId = proveedorId;
        this.proveedorNombre = proveedorNombre;
        this.codigo = codigo;
        this.nombre = nombre;
        this.marca = marca;
        this.precioCompra = precioCompra;
        this.ganancia = ganancia;
        this.stock = stock;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.fecha_Vencimiento = fecha_Vencimiento;
        this.activo = activo;
    }
    
    // Getter and Setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(int categoriaId) {
        this.categoriaId = categoriaId;
    }

    public String getCategoriaNombre() {
        return categoriaNombre;
    }

    public void setCategoriaNombre(String categoriaNombre) {
        this.categoriaNombre = categoriaNombre;
    }

    public int getProveedorId() {
        return proveedorId;
    }

    public void setProveedorId(int proveedorId) {
        this.proveedorId = proveedorId;
    }

    public String getProveedorNombre() {
        return proveedorNombre;
    }

    public void setProveedorNombre(String proveedorNombre) {
        this.proveedorNombre = proveedorNombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public double getGanancia() {
        return ganancia;
    }

    public void setGanancia(double ganancia) {
        this.ganancia = ganancia;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getFecha_Vencimiento() {
        return fecha_Vencimiento;
    }

    public void setFecha_Vencimiento(String fecha_Vencimiento) {
        this.fecha_Vencimiento = fecha_Vencimiento;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "Producto{" + "id=" + id + ", categoriaId=" + categoriaId + ", categoriaNombre=" + categoriaNombre + ", proveedorId=" + proveedorId + ", proveedorNombre=" + proveedorNombre + ", codigo=" + codigo + ", nombre=" + nombre + ", marca=" + marca + ", precioCompra=" + precioCompra + ", ganancia=" + ganancia + ", stock=" + stock + ", descripcion=" + descripcion + ", imagen=" + imagen + ", fecha_Vencimiento=" + fecha_Vencimiento + ", activo=" + activo + '}';
    }
    
}
