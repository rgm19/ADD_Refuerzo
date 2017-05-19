/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package add_refuerzoVI;

import static add_refuerzoV.BD_Pacientes.elecInt;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Query;
import org.hibernate.Session;


public class Hibernate_Pacientes{
    public static void main(String[]args) throws SQLException{
        
    Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);
    Session session = NewHibernateUtil.getSessionFactory().openSession();
    
    
       while(true){
           menu(session);
       }
  
	
	/*
	Query q = session.createQuery("from Pacientes");//Respetar Mayusculas segun la clase del proyecto que corresponda con la tabla
	List<Pacientes> lista = q.list();
	Iterator <Pacientes> it = lista.iterator();
	while (it.hasNext())
	{
		Pacientes per = new Pacientes();
		per=it.next();
		System.out.println("nobmre - " + per.getNombre());
		System.out.println("apellido - " + per.getApellidos());
		System.out.println("Edad -" + per.getDni());
                System.out.println("Ingreso: -" + per.getFechaIngreso());
                System.out.println("Alta -" + per.getFechaAlta());
	}
	session.close();
        */
    }
    
//------------------------------------------------------------------------------
private static void menu(Session session) throws SQLException {
        int op=0;
        System.out.println("1- Dar de alta un paciente");
        System.out.println("2- Dar de baja un paciente");
        System.out.println("3- Listado de pacientes por año");
        System.out.println("4- Modificar fecha de alta");
        System.out.println("0- Salir");
        System.out.println("---------------------------------------------------");
                
        
        System.out.print("Opcion -> ");
        op=elecInt();
        
        
        
        switch(op){
            case 1:
               altaPaciente(session);
                break;
                
            case 2:
                
                break;
                
            case 3:
               
                break;
                
            case 4:
                
                break;
                

                
            case 0:
                System.out.println("Cerrando Programa...");
                session.close();
                System.exit(0);
                break;
                
            default:
                System.out.println("Introduce una opcion valida!");
                break;
                
        }
    }    
//------------------------------------------------------------------------------
    private static void altaPaciente(Session session) {
       
    }
}