
package Entidades;

public class Venta {
    // Atributos
    private int id;
    private int productoId;
    private int clienteId;
    private int colaboradorId;
    private String tipo_comprobante;
    private String numero_comprobante;
    private String serie_comprobante;
    private String fecha_venta;
    private double precio_venta;
    private double igv;
    private double total;
    private boolean activo;
    
    // Constructores
    public Venta() {
    }

    public Venta(int id, int productoId, int clienteId, int colaboradorId, String tipo_comprobante, String numero_comprobante, String serie_comprobante, String fecha_venta, double precio_venta, double igv, double total, boolean activo) {
        this.id = id;
        this.productoId = productoId;
        this.clienteId = clienteId;
        this.colaboradorId = colaboradorId;
        this.tipo_comprobante = tipo_comprobante;
        this.numero_comprobante = numero_comprobante;
        this.serie_comprobante = serie_comprobante;
        this.fecha_venta = fecha_venta;
        this.precio_venta = precio_venta;
        this.igv = igv;
        this.total = total;
        this.activo = activo;
    }
    
    // Getter and setter
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

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
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

    public String getFecha_venta() {
        return fecha_venta;
    }

    public void setFecha_venta(String fecha_venta) {
        this.fecha_venta = fecha_venta;
    }

    public double getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(double precio_venta) {
        this.precio_venta = precio_venta;
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
        return "Ventas{" + "id=" + id + ", productoId=" + productoId + ", clienteId=" + clienteId + ", colaboradorId=" + colaboradorId + ", tipo_comprobante=" + tipo_comprobante + ", numero_comprobante=" + numero_comprobante + ", serie_comprobante=" + serie_comprobante + ", fecha_venta=" + fecha_venta + ", precio_venta=" + precio_venta + ", igv=" + igv + ", total=" + total + ", activo=" + activo + '}';
    }
}
