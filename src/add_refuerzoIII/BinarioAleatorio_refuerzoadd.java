package add_refuerzoIII;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

/**
 *
 * @author usuario5
 */
public class BinarioAleatorio_refuerzoadd {
    
    static Scanner teclado = new Scanner(System.in);
    static double min=50,max=0;
    static int hmin=0, hmax=0;  
   
    public static void main(String[]args) throws IOException{
        
       int [] horas = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24};
            
        //Crea el fichero y comprueba su existencia
        File fichero = new File("temperaturas.tmp");
        if(!fichero.exists()){
            fichero.createNewFile();
            System.out.println("Se ha creado el archivo 'temperaturas.tmp'");
        }else{
            System.out.println("El archivo 'temperaturas.tmp' ya  ha sido creado anteriormente");
        }
        
        //Escritura aleatoria del fichero
        RandomAccessFile dataOS = new RandomAccessFile(fichero,"rw");
        try{
            int datapos=0;
            dataOS.seek(datapos);
            for(int i=0;i<horas.length;i++){
                
                dataOS.writeInt(horas[i]);
                dataOS.writeDouble((int) (Math.random() * (100-10) + 10));
                dataOS.writeDouble((int) (Math.random() * (40-0) + 0));
                
                datapos=datapos+20;
                dataOS.seek(datapos);
            }
        }catch(IOException ex){
            System.err.println("Error -> "+ex.getMessage());
        }
        dataOS.close();
        
        //Lectura aleatoria del fichero
        RandomAccessFile rfile = new RandomAccessFile(fichero,"r");
        try{
        int pos=0;
        rfile.seek(pos);
        
        
            while(true){
                    int h =rfile.readInt();
                    double p= rfile.readDouble();
                    double t = rfile.readDouble();
                    System.out.println("Hora: "+h+" ,Presion: "+p+" ,Temperatura: "+t);


                    if(t<min){
                        min=t;
                        hmin=h;
                    }

                    if(t>max){
                        max=t;
                        hmax=h;
                    }
                 pos=pos+20;
                 rfile.seek(pos);
            }
            
            
            
        }catch(IOException e){
            System.err.println("Error -> "+e.getMessage());
        }  
        
        System.out.println("--------------------------------------------------------------------");
        System.out.println("La temperatura minima fue de "+min+" grados a las "+hmin+" horas");
        System.out.println("--------------------------------------------------------------------");
        System.out.println("La temperatura maxima fue de "+max+" grados a las "+hmax+" horas");
        System.out.println("--------------------------------------------------------------------");
        
        rfile.close();
    }
    
}
