/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package add_refuerziIV;

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

    
    public static void main(String[]args) throws IOException, FileNotFoundException, ClassNotFoundException{
 
      /*
      if(!fichero.exists()){
          fichero.createNewFile();
      }
      */
       
        
            while(!bandera){
              menu();
            }
            
       //dataOS.close();
       //fileout.close();
       System.exit(0);
    }   

    private static void menu() throws IOException, FileNotFoundException, ClassNotFoundException {
        
        System.out.println("1º- Añadir contacto nuevo");
        System.out.println("2º- Mostrar todos los contactos de la agenda");
        System.out.println("0º- Salir");
        
        int op = elecInt();
        switch(op){
            
            case 1:
                addContacto();
            break;
            
            case 2:
                listarContactos();
            break;
            
            case 0:
                bandera=false;
            break;
            
            default:
            System.out.println("Elige una de las opciones!");
        }    
        
    }
    //-----------------AÑADIR CONTACTO-------------------------------------------
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
        
        while(true){
           Persona p = new Persona();
           p=(Persona) dataIN.readObject();
           
        }
        
        
        //dataIN.close();
        //fileIN.close();
    }
}
