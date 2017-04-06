package aad_refuerzoI;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author usuario5
 */
public class Ejercicios_file {
    static Scanner teclado = new Scanner(System.in);
    public static void main(String []args) throws IOException{
        
        ejercicio1();
        ejercicio2();
        ejercicio3();
        ejercicio4();
        ejercicio5(args[0]);
        
    }

    private static void ejercicio1() throws IOException {
       //Ejercicio 1 Renombra los ficheros
        File file1 = new File("datos.txt");
        File file2 = new File("datos.dat");
        if(!file1.exists() || !file2.exists()){
            file1.createNewFile();
            file2.createNewFile();
            System.out.println("Uno de los archivos no existia y se ha creado!");
        }
        
        file1.renameTo(file2);
        System.out.println("Se han renombrado los ficheros");
    }

    private static void ejercicio2() {
        //Ejercicio 2 realizar un programa que muestre sólo los archivos (no directorios) del directorio indicado por el usuario como argumento. Utilizar el método isFile de la clase File.
        System.out.println("Escribe el directorio!");
        String cad = teclado.nextLine();
        File file3 = new File(cad);
        String [] files = file3.list();
        for(String aux : files){
            File file4=new File(aux);
            if(file4.isFile()){
                System.out.println(aux+" es un fichero");
            }else{
                System.out.println(aux+" NO es un fichero");
            }
        }
    }

    private static void ejercicio3() throws IOException {
       //3.- Realizar un programa que renombre un archivo.
        //El usuario introducirá dos argumentos: nombre original completo (con la ruta) del archivo, y nombre final. Utilizar el método renameTo de la clase File. 
        System.out.println("Introduce el directorio de el archivo:");
        String cad = teclado.nextLine();
        File fichero = new File(cad);
        
        if(!fichero.exists()){
            fichero.createNewFile();
            System.out.println("No existia el fichero y se ha creado");
        }
        
        System.out.print("Nombre nuevo del fichero -> ");
        String nombre = teclado.nextLine();
        
        File nuevo = new File(nombre);
        fichero.renameTo(nuevo);
        System.out.println("El fichero se ha renombrado como "+fichero.getName());
    }

    private static void ejercicio4() {
      // 4.- Realizar un programa que borre el directorio indicado por el usuario como argumento. Debe poder borrarlo sea cual sea su contenido.
      System.out.println("Introduce el directorio a borrar");
      String cad = teclado.nextLine();
      File fichero = new File(cad);
      fichero.delete();
      System.out.println("El directorio se ha borrado");
    }

    private static void ejercicio5(String file) {
       //5.- Realizar un programa que muestre la lista de ficheros (archivos y directorios) de un directorio.
       //El nombre del directorio se pasará al programa desde la línea de comandos al ejecutarlo. Utilizar el método list de la clase File. 
       File fichero = new File(file);
    }
}
