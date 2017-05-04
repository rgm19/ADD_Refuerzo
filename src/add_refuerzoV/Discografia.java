package add_refuerzoV;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * las tablas y los datos han sido creados por workbench
 * @author usuario5
 */
public class Discografia {
    public static void main(String[]args){
        //gkitrjgdghiojojyohip5
        try(
                Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/Discografica","root","root");
            ){
                 Statement sentencia =  (Statement) conexion.createStatement();
                 ResultSet resultado = null;
                 
                 
                 //16 sentencia preparada para canciones actualizar duracion
                 String consultaduracion = "Select*from empleados where ";
                 
                
        }catch(Exception e){}
    }
}
