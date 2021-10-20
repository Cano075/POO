package acceso;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Acceso{
    
    public static void main(String[] args){
        do{
            boolean seAccede = Accede();
            if(seAccede){
                System.out.println("\nSe ha podido acceder al programa");
                break;
            }
            else{
                System.out.println("\nNo se ha podido acceder al programa");
                System.out.println("Revise otra vez sus datos O si se encuentra inactivo");
            }
        }while (true);
    }
    
    public static boolean Accede(){
        boolean estaAutenticado = false;
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el nombre de usuario");
        String nombreUsuario = sc.nextLine();
        System.out.println("Ingrese la contrasena");
        String contrasena = sc.nextLine();
        
        String path = "src\\datosAcceso\\datosAcceso.txt";
        
        File archivo = new File(path);
        
        try{
            Scanner inputBuffer = new Scanner(archivo);
            
            while(inputBuffer.hasNext()){
                String linea = inputBuffer.nextLine();
                String[] valores = linea.split("\t");
                
                if(valores[0].equals(nombreUsuario));{
                    if(valores[1].equals(contrasena)){
                        if(valores[2].equals("Activo")){
                            estaAutenticado = true;
                        }
                    }
                }
            }
        }catch(FileNotFoundException fe){
            fe.printStackTrace();
        }
        return estaAutenticado;
    }
}
