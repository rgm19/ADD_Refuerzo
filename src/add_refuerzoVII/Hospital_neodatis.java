/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package add_refuerzoVII;

import java.util.ArrayList;

import java.util.Scanner;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import org.neodatis.odb.*;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.ICriterion;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;
import org.neodatis.odb.impl.core.query.values.ValuesCriteriaQuery;

/**
 *
 * @author usuario5
 */
public class Hospital_neodatis {

    static ODB odb;
    static Scanner teclado = new Scanner(System.in);
    static ArrayList<Pacientes> pacientes = new ArrayList<>();
    
    public static void main(String[]args){
        odb= ODBFactory.open("BBDD");
        
        pacientes.add(new Pacientes(1,"Juan","LaFuente","2017-05-05","45A","2017-04-15"));
        pacientes.add(new Pacientes(2,"Miguel","Pico","2017-02-05","12Z","2017-04-15"));
        pacientes.add(new Pacientes(3,"Maribel","Gutierrez","2016-02-05","58U","2017-04-15"));
        pacientes.add(new Pacientes(4,"Teresa","Toro","2016-02-05","54T","2017-04-15"));
        pacientes.add(new Pacientes(5,"Julio","Abril","2016-02-05","52D","2017-04-15"));
        pacientes.add(new Pacientes(6,"Julio","Abril","2015-02-05","52D","2017-04-15"));
        pacientes.add(new Pacientes(7,"Carmen","Peña","2016-02-05","49F","2017-04-15"));
        pacientes.add(new Pacientes(8,"Carmen","Peña","2015-02-05","49F","2017-04-15"));
        pacientes.add(new Pacientes(9,"Angel","Rubi","2006-01-05","19E","2006-01-15"));
        pacientes.add(new Pacientes(10,"Manuel","Lopez","2017-01-05","55M","2017-04-15"));
        pacientes.add(new Pacientes(11,"Manuel","Lopez","2017-03-05","55M","2017-04-15"));
        pacientes.add(new Pacientes(12,"Teresa","Toro","2017-02-05","54T","2017-04-15"));
        pacientes.add(new Pacientes(13,"Paco","Manzano","2014-02-05","88F","2017-04-15"));
        pacientes.add(new Pacientes(14,"Paco","Manzano","2017-02-05","88F","2017-04-15"));
        
        for(Pacientes p: pacientes){
            odb.store(p);
        }
        
        while(true){
           menu();
        }
        
        
        
    }
 //-----------------------------------------------------------------------------
private static void menu(){
        int op=0;
        System.out.println();
        System.out.println("1- Modificar Paciente con OID2");
        System.out.println("2- Listado de Pacientes cuyo nombre empiece por A");
        System.out.println("3- Numero de personas registradas");
        System.out.println("4- Pacientes que se dieron de alta hace mas de 10 años");
        System.out.println("5- Nombre y apellidos del paciente mas Antiguo de la Base de datos");
        System.out.println("6- Media de ingresados por año");
        System.out.println("0- Salir");
        System.out.println("---------------------------------------------------");
                
        
        System.out.print("Opcion -> ");
        op=elecInt();
        teclado.nextLine();
        System.out.println();
        
        
        
        switch(op){
            case 1:
                modificarPaciente();
                break;
                
            case 2:
                listadoPacientesA();
                break;
                
            case 3:
                personasRegistradas();
                break;
                
            case 4:
                altaMas10Anios();
                break;
                            
            case 5:
                pacienteAntiguo();
                break;
             
            case 6:
                
                break;
                

                
            case 0:
                System.out.println("Cerrando Programa...");
                System.exit(0);
                break;
                
            default:
                System.out.println("Introduce una opcion valida!");
                break;
                
        }
    } 
//------------------------------------------------------------------------------
    public static int elecInt() {
         
        int aux=0;
        boolean control=true;
        
        do{       
                try{
                    aux= teclado.nextInt();
                    control=true;

                }catch(Exception e){
                    control=false;
                    System.out.println("Introduce un numero!");
                    teclado.nextLine();
                }  
        }while(control!=true);
      return aux;
    }
//------------------------------------------------------------------------------
    private static void modificarPaciente() {
        Objects<Pacientes> objects = odb.getObjects(Pacientes.class);
        
        for(Pacientes p : objects){
            Pacientes paci = objects.next();
            OID oid = odb.getObjectId(p);
            
            if(oid.getObjectId()== 4){
                System.out.println("Escribe el nuevo apellido del paciente "+paci.getNombre());
                String ap =teclado.nextLine();
                paci.setApellidos(ap);
                odb.store(paci);
                odb.commit();
                System.out.println("El paciente con OID "+oid.getObjectId()+", de nombre "+paci.getNombre()+", ahora tiene el apellido"+paci.getApellidos());
            }
        }
        
        System.out.println("Apellido cambiado correctamente");
    }
//------------------------------------------------------------------------------    

    private static void listadoPacientesA() {
       IQuery query = new CriteriaQuery(Pacientes.class, Where.and().add(Where.like("nombre", "A%")));
       Objects<Pacientes> object = odb.getObjects(query);
       int i=0;
       
       while(object.hasNext()){
           Pacientes p = object.next();
           System.out.println((i++) + p.toString());
           System.out.println();
           
       }
       
       if(i==0)System.out.println("Ningun paciente empieza por la letra A");
    }
//------------------------------------------------------------------------------    

    private static void personasRegistradas() {
        IQuery query5 = new CriteriaQuery(Pacientes.class);
        BigInteger numPersona = odb.count((CriteriaQuery) query5);
        System.out.println("Numero de personas: " + numPersona);
    }
//------------------------------------------------------------------------------
    private static void altaMas10Anios() {
         IQuery query = new CriteriaQuery(Pacientes.class, Where.and().add(Where.like("fechaAlta", "200%")));
       Objects<Pacientes> object = odb.getObjects(query);
       int i=0;
       
       while(object.hasNext()){
           Pacientes p = object.next();
           System.out.println((i++) + p.toString());
           System.out.println();
           
       }
       
       if(i==0)System.out.println("Ningun paciente fue dado de alta hace mas de 10 años");
    }
//------------------------------------------------------------------------------    

    private static void pacienteAntiguo() {          
        java.text.SimpleDateFormat sdf=new java.text.SimpleDateFormat("yyyy-MM-dd");
        Date fecha_antigua = null;
        Date fecha=null;
        Pacientes antiguo = new Pacientes();  
        Objects<Pacientes> objects = odb.getObjects(Pacientes.class);
        int vuelta=1;
        
        while(objects.hasNext()){
            Pacientes paci = objects.next();
            String aux = paci.getFechaBaja();
            
            

        
                try {

                    fecha = sdf.parse(aux); 
                    if(vuelta==1){ fecha_antigua=fecha; }
                    
                    if(fecha.before(fecha_antigua) == true){
                           fecha_antigua=fecha;
                           antiguo=paci;
                    }

                } catch (ParseException ex) { ex.printStackTrace(); }

           vuelta++;            
        }
        
        System.out.println("El paciente mas antiguo en la BD es; "+antiguo.getNombre()+" "+antiguo.getApellidos());
        
    }
}
