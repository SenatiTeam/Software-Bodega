
package Entidades;

public class Compra {
    // Atributos
    private int id;
    private int productoId;
    private int proveedorId;
    private int colaboradorId;
    private String tipo_comprobante;
    private String numero_comprobante;
    private String serie_comprobante;
    private String fecha_comprobante;
    private double igv;
    private double total;
    private boolean activo;
    
    // Constructores
    public Compra() {
    }

    public Compra(int id, int productoId, int proveedorId, int colaboradorId, String tipo_comprobante, String numero_comprobante, String serie_comprobante, String fecha_comprobante, double igv, double total, boolean activo) {
        this.id = id;
        this.productoId = productoId;
        this.proveedorId = proveedorId;
        this.colaboradorId = colaboradorId;
        this.tipo_comprobante = tipo_comprobante;
        this.numero_comprobante = numero_comprobante;
        this.serie_comprobante = serie_comprobante;
        this.fecha_comprobante = fecha_comprobante;
        this.igv = igv;
        this.total = total;
        this.activo = activo;
    }
    
    // Getter and Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductoId() {
        return productoId;
    }

    public void setProductoId(int productoId) {
        this.productoId = productoId;
    }

    public int getProveedorId() {
        return proveedorId;
    }

    public void setProveedorId(int proveedorId) {
        this.proveedorId = proveedorId;
    }

    public int getColaboradorId() {
        return colaboradorId;
    }

    public void setColaboradorId(int colaboradorId) {
        this.colaboradorId = colaboradorId;
    }

    public String getTipo_comprobante() {
        return tipo_comprobante;
    }

    public void setTipo_comprobante(String tipo_comprobante) {
        this.tipo_comprobante = tipo_comprobante;
    }

    public String getNumero_comprobante() {
        return numero_comprobante;
    }

    public void setNumero_comprobante(String numero_comprobante) {
        this.numero_comprobante = numero_comprobante;
    }

    public String getSerie_comprobante() {
        return serie_comprobante;
    }

    public void setSerie_comprobante(String serie_comprobante) {
        this.serie_comprobante = serie_comprobante;
    }

    public String getFecha_comprobante() {
        return fecha_comprobante;
    }

    public void setFecha_comprobante(String fecha_comprobante) {
        this.fecha_comprobante = fecha_comprobante;
    }

    public double getIgv() {
        return igv;
    }

    public void setIgv(double igv) {
        this.igv = igv;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "Compras{" + "id=" + id + ", productoId=" + productoId + ", proveedorId=" + proveedorId + ", colaboradorId=" + colaboradorId + ", tipo_comprobante=" + tipo_comprobante + ", numero_comprobante=" + numero_comprobante + ", serie_comprobante=" + serie_comprobante + ", fecha_comprobante=" + fecha_comprobante + ", igv=" + igv + ", total=" + total + ", activo=" + activo + '}';
    }
}
