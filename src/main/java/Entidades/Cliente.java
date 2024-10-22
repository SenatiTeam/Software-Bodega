
package Entidades;

public class Cliente {
    // Atributos
    private int id;
    private String nombre;
    private String tipo_cliente;
    private String tipo_documento;
    private int documento;
    private int telefono;
    private String direccion;
    private boolean activo;
    
    // Constructopres
    public Cliente() {
    }

    public Cliente(int id, String nombre, String tipo_cliente, String tipo_documento, int documento, int telefono, String direccion, boolean activo) {
        this.id = id;
        this.nombre = nombre;
        this.tipo_cliente = tipo_cliente;
        this.tipo_documento = tipo_documento;
        this.documento = documento;
        this.telefono = telefono;
        this.direccion = direccion;
        this.activo = activo;
    }

    public Cliente(String nombre, String tipo_cliente, String tipo_documento, int documento) {
        this.nombre = nombre;
        this.tipo_cliente = tipo_cliente;
        this.tipo_documento = tipo_documento;
        this.documento = documento;
    }
    
    // Getter and Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo_cliente() {
        return tipo_cliente;
    }

    public void setTipo_cliente(String tipo_cliente) {
        this.tipo_cliente = tipo_cliente;
    }

    public String getTipo_documento() {
        return tipo_documento;
    }

    public void setTipo_documento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", nombre=" + nombre + ", tipo_cliente=" + tipo_cliente + ", tipo_documento=" + tipo_documento + ", documento=" + documento + ", telefono=" + telefono + ", direccion=" + direccion + ", activo=" + activo + '}';
    }
}
