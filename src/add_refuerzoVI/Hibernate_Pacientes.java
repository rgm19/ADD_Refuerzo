/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package add_refuerzoVI;

import static add_refuerzoV.BD_Pacientes.elecInt;
import java.sql.SQLException;
 import java.text.SimpleDateFormat;
import java.text.ParseException;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.print.attribute.standard.MediaPrintableArea.MM;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class Hibernate_Pacientes{    
    
    static Scanner teclado = new Scanner(System.in);    

    public static void main(String[]args) throws SQLException{
        
    Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);
    Session session = NewHibernateUtil.getSessionFactory().openSession();
    Transaction tx = null;
    
       while(true){
           menu(session, tx);
       }
  
	
	/*
	Query q = session.createQuery("from Pacientes"); //Respetar Mayusculas segun la clase del proyecto que corresponda con la tabla
	List<Pacientes> lista = q.list();
	Iterator <Pacientes> it = lista.iterator();
	while (it.hasNext())
	{
		Pacientes per = new Pacientes();
		per=it.next();
		System.out.println("nombre - " + per.getNombre());
		System.out.println("apellido - " + per.getApellidos());
		System.out.println("Edad -" + per.getDni());
                System.out.println("Ingreso -" + per.getFechaIngreso());
                System.out.println("Alta -" + per.getFechaAlta());
	}
	session.close();
        */
    }
    
//------------------------------------------------------------------------------
private static void menu(Session session, Transaction tx) throws SQLException {
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
               altaPaciente(session,tx);
                break;
                
            case 2:
                bajaPacientes(session, tx);
                break;
                
            case 3:
                listadoPacientesAnio(session,tx);
                break;
                
            case 4:
                modificarAlta(session,tx);
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
    private static void altaPaciente(Session session, Transaction tx ) {
       
        
        String sql ="from Pacientes where id=1";
        Pacientes p = (Pacientes) session.createQuery(sql).uniqueResult();
        
        String nombre = p.getNombre();
        String apellidos = p.getApellidos();
        String dni = p.getDni();
        String fecha_baja = p.getFechaIngreso();
        
        java.util.Date date = new java.util.Date();
        java.text.SimpleDateFormat sdf=new java.text.SimpleDateFormat("yyyy-MM-dd");
        String fecha_alta = sdf.format(date);
        
        //System.out.println(fecha_alta);
        
        
               
        Pacientes per = new Pacientes(13,nombre,apellidos,fecha_alta,dni,fecha_baja);
        session.save(per);
        
        String insert = "insert into Pacientes (select id, nombre, apellidos, fecha_alta, dni, fecha_ingreso from per)";
               // + "("+per.getId()+",'"+per.getNombre()+"','"+per.getApellidos()+"','"+per.getFechaAlta()+
                //"','"+per.getDni()+"','"+per.getFechaIngreso()+"')";
        int filas = session.createQuery(insert).executeUpdate();
        if(filas!=0){
            System.out.println("Paciente añadido a la BD");
        }

        //tx.commit();
        
        
        
    }
//------------------------------------------------------------------------------
    private static void bajaPacientes(Session session, Transaction tx) {
               
        java.util.Date date = new java.util.Date();
        java.text.SimpleDateFormat sdf=new java.text.SimpleDateFormat("yyyy-MM-dd");
        String fecha_baja = sdf.format(date);
        
        System.out.println("Escribe el id del paciente a cambiar la fecha");
        int id = teclado.nextInt();
        //teclado.nextLine();
        
        String update = "UPDATE Pacientes set fecha_ingreso ="+fecha_baja+" where id='"+id+"'";
        int filasIn2=session.createQuery(update).executeUpdate();
        System.out.println("Se han actualizado: " + filasIn2 + " filas");

    }
//------------------------------------------------------------------------------    

    private static void listadoPacientesAnio(Session session, Transaction tx) {
            
        String listado ="year(fecha_alta), count(dni) as cuantos from Pacientes group by year(fecha_alta)";
        Query q = session.createQuery(listado); //Respetar Mayusculas segun la clase del proyecto que corresponda con la tabla
	List<Pacientes> lista = q.list();
	Iterator <Pacientes> it = lista.iterator();

    }
//------------------------------------------------------------------------------
    private static void modificarAlta(Session session, Transaction tx) {
        java.util.Date date = new java.util.Date();
        java.text.SimpleDateFormat sdf=new java.text.SimpleDateFormat("yyyy-MM-dd");
        String fecha_alta = sdf.format(date);
        
        
        String update = "UPDATE Pacientes set fecha_ingreso ="+fecha_alta+" where id=2";
        int filasIn2=session.createQuery(update).executeUpdate();
        System.out.println("Se han actualizado: " + filasIn2 + " filas");
    }
}