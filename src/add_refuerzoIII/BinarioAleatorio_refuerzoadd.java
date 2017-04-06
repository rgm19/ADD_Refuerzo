/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package add_refuerzoIII;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author usuario5
 */
public class BinarioAleatorio_refuerzoadd {
    static Scanner teclado = new Scanner(System.in);
    public static void main(String[]args) throws IOException{
        
       int [] horas = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24};
       
        
        
        
        File fichero = new File("temperaturas.tmp");
        if(!fichero.exists()){
            fichero.createNewFile();
            System.out.println("Se ha creado el archivo 'temperaturas.tmp'");
        }else{
            System.out.println("El archivo 'temperaturas.tmp' ya  ha sido creado anteriormente");
        }
        
        DataOutputStream dataOS = new DataOutputStream(new FileOutputStream(fichero)); 
        
        for(int i=0;i<horas.length;i++){
            dataOS.writeInt(horas[i]);
            dataOS.writeDouble((double)Math.random()*(100-10)+10);
            dataOS.writeDouble((double)Math.random()*(40-0)+0);
        }        
        dataOS.close();
        

        
        
        
    }
    
}
