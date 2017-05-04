/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package add_refuerzoIV;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

/**
 *
 * @author usuario
 */
public class Agenda {
    static Persona persona; 
    static boolean bandera=true;
    static File fichero = new File("agenda.dat");
    static Scanner teclado = new Scanner(System.in);

    
    public static void main(String[]args) throws IOException, FileNotFoundException, ClassNotFoundException{
       
        
            do{
              menu();
            }while(bandera);
            
       System.exit(0);
    }   

    private static void menu() throws IOException, FileNotFoundException, ClassNotFoundException {
        
        System.out.println("1º- Añadir contacto nuevo");
        System.out.println("2º- Mostrar todos los contactos de la agenda");
        System.out.println("3º- Añadir un contacto nuevo");
        System.out.println("4º- Buscar un contacto por nombre");
        System.out.println("5º- Buscar un contacto por telefono");
        System.out.println("6º- Borrar un contacto por nombre");
        System.out.println("7º- Modificar un contacto por nombre");
        System.out.println("0º- Salir");
        
        int op = elecInt();
        switch(op){
            
            case 1:
                addContacto();
            break;
            
            case 2:
                listarContactos();
            break;
            
            case 3:     
                anadirContacto();
            break;
            
            case 4:
                buscarContacto();
            break;
            
            case 5:
                buscarTelf();
            break;
            
            case 6:
                borrarContacto();
            break;
            
            case 7:
                modificarTelf();
            break;
            
            case 0:
                bandera=false;
            break;
            
            default:
            System.out.println("Elige una de las opciones!");
        }    
        
    }
    //-----------------AÑADIR  lista CONTACTO-------------------------------------------
    private static void addContacto() throws FileNotFoundException, IOException {
        FileOutputStream fileout = new FileOutputStream(fichero);
        ObjectOutputStream dataOS = new ObjectOutputStream(fileout);
        String [] nombres ={"Ruben","Manolo","Ismael","Juan","Miguel"};
        String [] direccion ={"Paseo Santa Maria","Calle Sevilla","Calle Carmona","Plaza Asensio","Avenida Almagro"};
        int[] postal={12357,78453,13954,52049,36780};
        int [] tel ={654987321,789456123,741852963,258741369,465821379};
        
        for(int i=0;i<nombres.length;i++){
            persona = new Persona(nombres[i],direccion[i],postal[i],tel[i]);
            dataOS.writeObject(persona);
        }
        dataOS.close();
        fileout.close();   
    }
    //-------------Scanner teclado----------------------------------------------
    private static int elecInt() {
        Scanner teclado = new Scanner(System.in);
        int aux=0;
        boolean control=true;
        
        do{       
                try{
                    aux= teclado.nextInt();
                    control=true;

                }catch(Exception e){
                    control=false;
                    System.out.println("Introduce un numero!");
                }  
        }while(control!=true);
      return aux;
    }
    //-----------------LISTAR CONTACTOS-----------------------------------------
    private static void listarContactos() throws FileNotFoundException, IOException, ClassNotFoundException {
        
        FileInputStream fileIN = new FileInputStream(fichero);
        ObjectInputStream dataIN = new ObjectInputStream(fileIN);
        Persona p = new Persona();
        
        try{
            while(true){
               p=(Persona) dataIN.readObject();

               System.out.println("------------------------------------------");
               System.out.println("NOMBRE: "+p.getNombre());
               System.out.println("DIRECCION: "+p.getDireccion());
               System.out.println("TELEFONO: "+p.getTelf());
               System.out.println("C.P: "+p.getCodpostal());
               
            }
              
        }catch(Exception e){}
               System.out.println("------------------------------------------");  
        dataIN.close();
        fileIN.close(); 
    }
    //-------------------------BUSCAR UN CONTACTO-------------------------------
    private static void buscarContacto() throws FileNotFoundException, IOException {
        FileInputStream fileIN = new FileInputStream(fichero);
        ObjectInputStream dataIN = new ObjectInputStream(fileIN);
        Persona p = new Persona();
        
        System.out.println("Nombre de la persona a buscar");
        String aux = teclado.nextLine();
        
        try{
            while(true){
                p = (Persona) dataIN.readObject();
                
                if(aux.equalsIgnoreCase(p.getNombre())){
                    System.out.println("------------------------------------------");
                    System.out.println("NOMBRE: "+p.getNombre());
                    System.out.println("DIRECCION: "+p.getDireccion());
                    System.out.println("TELEFONO: "+p.getTelf());
                    System.out.println("C.P: "+p.getCodpostal());
                    System.out.println("------------------------------------------");
                }
            }
            
        }catch(Exception ex){
            System.err.println("ERROR -> "+ex.getMessage());
        }
        dataIN.close();
        fileIN.close();
        
    }
    //----------------------------añadirContactoNuevo---------------------------
    private static void anadirContacto() throws FileNotFoundException, IOException {
        FileOutputStream fileout = new FileOutputStream(fichero);
        ObjectOutputStream dataOS = new ObjectOutputStream(fileout);
        
        
        System.out.print("Nombre: ");
        String name = teclado.nextLine();
        System.out.println();
        
        System.out.print("Direccion: ");
        String direc = teclado.nextLine();
        System.out.println();
        
        System.out.print("Telefono: ");
        int telf = teclado.nextInt();
        System.out.println();
        
        System.out.print("C.P: ");
        int cp = teclado.nextInt();
        System.out.println();
        
        Persona p = new Persona(name,direc,telf,cp);
        dataOS.writeObject(p);
        
        fileout.close();
        dataOS.close();
    }
    //--------------Buscar telf-------------------------------------------------

    private static void buscarTelf() throws FileNotFoundException, IOException {
        FileInputStream fileIN = new FileInputStream(fichero);
        ObjectInputStream dataIN = new ObjectInputStream(fileIN);
        Persona p = new Persona();
        
        System.out.println("Telefono de la persona a buscar");
        int aux = teclado.nextInt();
        
        try{
            while(true){
                p = (Persona) dataIN.readObject();
                
                if(aux == p.getTelf()){
                    System.out.println("------------------------------------------");
                    System.out.println("NOMBRE: "+p.getNombre());
                    System.out.println("DIRECCION: "+p.getDireccion());
                    System.out.println("TELEFONO: "+p.getTelf());
                    System.out.println("C.P: "+p.getCodpostal());
                    System.out.println("------------------------------------------");
                }
            }
            
        }catch(Exception ex){
            System.err.println("ERROR -> "+ex.getMessage());
        }
        dataIN.close();
        fileIN.close();
    }
//-----------------Borrar Contacto----------------------------------------------    
    private static void borrarContacto() throws FileNotFoundException, IOException {
        FileInputStream fileIN = new FileInputStream(fichero);
        ObjectInputStream dataIN = new ObjectInputStream(fileIN);
        Persona p = new Persona();
        
        FileOutputStream fileout = new FileOutputStream(fichero, true);
        ObjectOutputStream dataOS = new ObjectOutputStream(fileout);
        
        System.out.println("Nombre de la persona a borrar");
        String aux = teclado.nextLine();
        
        try{
            while(true){
                p = (Persona) dataIN.readObject();
                
                if(aux.equalsIgnoreCase(p.getNombre())){
                       //***************************************
                      // revisar por falta de metodo para borrar
                      //****************************************
                       
                       
                }
            }
            
        }catch(Exception ex){
            System.err.println("ERROR -> "+ex.getMessage());
        }
        dataIN.close();
        fileIN.close();
        
        dataOS.close();
        fileout.close();
    }
    //---------------------Modificar telf---------------------------------------

    private static void modificarTelf() throws FileNotFoundException, IOException {
        FileInputStream fileIN = new FileInputStream(fichero);
        ObjectInputStream dataIN = new ObjectInputStream(fileIN);
        Persona p = new Persona();
        FileOutputStream fileout = new FileOutputStream(fichero);
        ObjectOutputStream dataOS = new ObjectOutputStream(fileout);
        
        
        System.out.println("Nombre de la persona a modificar telefono");
        String aux = teclado.nextLine();
        
        try{
            while(true){
                p = (Persona) dataIN.readObject();
                System.out.print("pruebaaaa!!!!");
                if(aux.equalsIgnoreCase(p.getNombre())){
                     System.out.print("Nuevo telf: ");
                     int nuevo = teclado.nextInt();
                     dataOS.writeInt(nuevo);
                }
            }
            
        }catch(Exception ex){
            System.err.println("ERROR -> "+ex.getMessage());
        }
        dataIN.close();
        fileIN.close();
        dataOS.close();
        fileout.close();
    }
    
}
