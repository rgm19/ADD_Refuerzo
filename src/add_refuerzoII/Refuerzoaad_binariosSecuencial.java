/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package add_refuerzoII;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author usuario
 */
public class Refuerzoaad_binariosSecuencial {
    static Scanner teclado = new Scanner(System.in);
    public static void main(String[]args) throws IOException{
        File f1 = new File("pedidos.txt");
        if(!f1.exists()){
            f1.createNewFile();
            System.out.println("El fichero ha sido creado!");
        }else{
            System.out.println("El fichero ya existe");
        }
        
        FileOutputStream fileOut = new FileOutputStream(f1);
        DataOutputStream dataOS = new DataOutputStream(fileOut);
    
        double[] precios ={150,40,89,620,870};
        int [] unidades ={5,7,12,8,30};
        String [] descripciones = {"paquetes de papel", "lapices", "boligrafos","carteras","mesas"};
        
        for(int i=0;i<5;i++){
            dataOS.writeUTF(descripciones[i]);
            dataOS.writeInt(unidades[i]);
            dataOS.writeDouble(precios[i]);
        }
        
        dataOS.close();
        fileOut.close();
        System.out.println("### Los datos se añadieron con exito ###");
    //--------------------------------------------------------------------------------
    
        String des="";
        double prize;
        int stock;
        
        FileInputStream fileIN = new FileInputStream(f1);
        DataInputStream dataIN = new DataInputStream(fileIN);
        System.out.println("*****************************************************");
        
        try{
            while(true){
                des=dataIN.readUTF();               
                stock=dataIN.readInt();
                prize=dataIN.readDouble();

                System.out.println("Articulo: "+des+", Precio: "+prize+", Unidades: "+stock);

            }
        }catch(Exception ex){
            System.err.println("Error -> "+ex.getMessage()+" fin del contenido");
        }    
        System.out.println("*******************************************");
        dataIN.close();
        fileIN.close();
        
        //----------------------------------------------------------------------
        
        FileInputStream fileIN2 = new FileInputStream(f1);
        DataInputStream dataIN2 = new DataInputStream(fileIN2);
        
        System.out.println("Inserte el nombre del articulo a buscar:");
        System.out.print("Articulo -> ");
        String search = teclado.nextLine();
        
        try{
            
            while(true){
                String aux = dataIN2.readUTF();
                int cant = dataIN2.readInt();
                double pre = dataIN2.readDouble();
                
                if(aux.equals(search)){                
                         
                    System.out.println("!!Articulo encontrado!!");
                    System.out.println("Articulo: "+aux+", Precio: "+pre+", Unidades: "+cant);
                    
                }
            }
        }catch(Exception ex){
            System.out.println("Error -> "+ex.getMessage()+" fin de la busqueda");
        }
        
        dataIN2.close();
        fileIN2.close();
    }
}
