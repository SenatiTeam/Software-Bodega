
package dataBase;

import java.sql.Connection; // Libreria para la conexion a MySQL
import javax.swing.JOptionPane;
import java.sql.DriverManager;
import java.sql.SQLException; // Para ocultar los errores

public class Conexion {
    // Variables 
    private final String DRIVER="com.mysql.jdbc.Driver";
    private final String URL="jdbc:mysql://localhost:3306/";
    private final String DB="db_almacen";
    private final String USER="root";
    private final String PASSWORD="";
    
    public Connection cadena; // Variable que importa la libreria SQL
    public static Conexion instancia; // Variable de instancia a la clase
    
    // Constructor 
    public Conexion() {
        this.cadena = null;
    }
    
    // Método para conectar a la base de datos
    public Connection conectar(){
        try {
            Class.forName(DRIVER);
            this.cadena=DriverManager.getConnection(URL+DB,USER,PASSWORD);
        }catch (ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null,"ERROR DE CONEXIÓN A LA BASE DE DATOS " + e.getMessage()); // e.getMessage muestra el error 
            System.exit(0);
        }
        return this.cadena;
    }
    
    // Método para desconectar a la base de datos
    public void desconectar(){
        try {
            this.cadena.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"NO SE PUDO CERRAR LA CONSULTA STATEMENT " + e.getMessage());
        }
    }
    
    // Método para instanciar la conexión
    public synchronized static Conexion getInstancia(){
        if (instancia == null) {
            instancia = new Conexion(); 
        }
        return instancia;
    }
    
}
