/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package add_refuerzoVI;

import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Query;
import org.hibernate.Session;


public class NewClass{
    public static void main(String[]args){
        
        Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);
	Session session = NewHibernateUtil.getSessionFactory().openSession();
  
  
	//Ejemplo de select * from .... : //Prueba con la tabla personas (tabla abajo, introducir datos)
	
	
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
    }
}