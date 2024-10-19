
package dataBase;

public class Main_conectar {

    public static void main(String[] args) {
        Conexion conexion = Conexion.getInstancia();
        conexion.conectar();
        if(conexion.cadena != null){
            System.out.println("CONECTADO");
        }else{
            System.out.println("DESCONECTADO");
        }
    }
    
}
