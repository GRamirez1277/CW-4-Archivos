package Archivos;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TestMiFile {
    static Scanner lea=new Scanner(System.in);
    public static void main(String[] args) {
        MiFile mf=new MiFile();
        int opcion=0;
        do{
            System.out.println("*****MENU*****");
            System.out.println("1- Set Archivo/Folder");
            System.out.println("2- Ver información");
            System.out.println("3- Crear Archivo");
            System.out.println("4- Crear Folder");
            System.out.println("5- Borrar");
            System.out.println("6- Dir");
            System.out.println("7- Tree");
            System.out.println("8- Escribir (Sobreescribiendo por completo)");
            System.out.println("9- Escribir (Manteniendo el texto anterior)");
            System.out.println("10- Leer");
            System.out.println("11- Salir ");
            System.out.print("Opción: ");
            try{
                opcion=lea.nextInt();
                switch(opcion)
                {
                    case 1:
                        System.out.print("Dirección: ");
                        mf.setFile(lea.next());
                        break;
                    case 2:
                        mf.Info();
                        break;
                    case 3:
                        mf.crearFile();
                        break;
                    case 4:
                        mf.crearFolder();
                        break;
                    case 5:
                        mf.borrar();
                        break;
                    case 6:
                        mf.dir();
                        break;
                    case 7:
                        mf.tree();
                        break;
                    case 8:
                        mf.blankText();
                        break;
                    case 9:
                        mf.writeText(true);
                        break;
                    case 10:
                        mf.readText();
                        break;
                }
            }catch(InputMismatchException e){
                lea.nextLine();
                System.out.println("Por favor ingrese una opción correcta");
            }catch(NullPointerException e){
                System.out.println("Debe seleccionar la opción 1 por lo menos una vez.");
            }catch(Exception e){
                System.out.println("Error: "+e.getMessage());
            }
        }while(opcion!=11);
        
    
    }
}
