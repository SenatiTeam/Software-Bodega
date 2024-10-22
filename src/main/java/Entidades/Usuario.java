
package Entidades;


public class Usuario {
    // Atributos
    private int id;
    private int rolId;
    private String nombre;
    private String tipoDocumento;
    private int numDocumento;
    private String direccion;
    private int telefono;
    private String fecha_contrato;
    private String email;
    private String clave;
    private String foto;
    private boolean activo;

    // Constructores
    public Usuario() {
    }

    public Usuario(int id, int rolId, String nombre, String tipoDocumento, int numDocumento, String direccion, int telefono, String email, boolean activo) {
        this.id = id;
        this.rolId = rolId;
        this.nombre = nombre;
        this.tipoDocumento = tipoDocumento;
        this.numDocumento = numDocumento;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.activo = activo;
    }

    public Usuario(int id, int rolId, String nombre, String tipoDocumento, int numDocumento, String direccion, int telefono, String fecha_contrato, String email, String clave, String foto, boolean activo) {
        this.id = id;
        this.rolId = rolId;
        this.nombre = nombre;
        this.tipoDocumento = tipoDocumento;
        this.numDocumento = numDocumento;
        this.direccion = direccion;
        this.telefono = telefono;
        this.fecha_contrato = fecha_contrato;
        this.email = email;
        this.clave = clave;
        this.foto = foto;
        this.activo = activo;
    }
    
    // Getter and Setter 
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRolId() {
        return rolId;
    }

    public void setRolId(int rolId) {
        this.rolId = rolId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public int getNumDocumento() {
        return numDocumento;
    }

    public void setNumDocumento(int numDocumento) {
        this.numDocumento = numDocumento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getFecha_contrato() {
        return fecha_contrato;
    }

    public void setFecha_contrato(String fecha_contrato) {
        this.fecha_contrato = fecha_contrato;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", rolId=" + rolId + ", nombre=" + nombre + ", tipoDocumento=" + tipoDocumento + ", numDocumento=" + numDocumento + ", direccion=" + direccion + ", telefono=" + telefono + ", fecha_contrato=" + fecha_contrato + ", email=" + email + ", clave=" + clave + ", foto=" + foto + ", activo=" + activo + '}';
    }
}
