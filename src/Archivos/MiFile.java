package Archivos;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

public class MiFile {
    private File mf=null;
    
    public File getMifile() {
        return mf;
    }
    
    public void setFile(String dir){
        mf=new File(dir);
    }
    
    public void Info(){
        if (mf.exists()) {
            System.out.println("Sí existe:");
            System.out.println("Nombre: " + mf.getName()
                    + "\nPath: " + mf.getPath()
                    + "\nAbsoluta: " + mf.getAbsolutePath()
                    + "\nPadre: " + mf.getAbsoluteFile().getParentFile().getName()
                    + "\nBytes: " + mf.length());

            if (mf.isFile()) {
                System.out.println("Es un archivo");
            } else if (mf.isDirectory()) {
                System.out.println("Es un folder");
            }

            System.out.println("Ultima modificación: " + new Date(mf.lastModified()));

        } else {
            System.out.println("El archivo no existe");
        }
    }
    
    public void crearFile()throws IOException{
        if (mf.createNewFile()) {
            System.out.println("Creado exitosamente");
        } else {
            System.out.println("No se pudo crear");
        }
    }
    
    public void crearFolder(){
        if (mf.mkdir()) {
            System.out.println("Creado exitosamente");
        } else {
            System.out.println("No se pudo crear");
        }
    }
    private boolean antidoto(File file){
        if(file.isDirectory()){
            for(File child:file.listFiles())
                antidoto(child);
        }
        return file.delete();
    }
    public void borrar(){
        if(antidoto(mf)){
            System.out.println("SE BORRO");
        }else{
            System.out.println("NO SE BORRO");
        }
        
    }
    
    public void dir(){
        if(mf.isDirectory()){
            System.out.println("Directorio de: "+mf.getAbsolutePath());
            System.out.println("");
            int cfiles=0,cdirs=0,tbytes=0;
        
        for(File child:mf.listFiles()){
            //Fecha Ultima Modificación
            if(!child.isHidden()){
                //Fecha última modificación
                Date ultima=new Date(child.lastModified());
                System.out.print(ultima+"\t");
            //Si es File or Folder
            if(child.isDirectory()){
                cdirs++;
                System.out.println("<DIR>\t\t");
            }else{
                //Si es un File
                cfiles++;
                tbytes+=child.length();
                System.out.println("\t"+child.length()+"\t");
            }
            System.out.println(child.getName());
        }
        }
        System.out.println(cfiles+" archivos\t"+tbytes+" bytes\n"+cdirs+" dirs\t");
    }
}
    public void tree(){
        tree(mf,"-");
    }
    private void tree(File dir,String tab){
        if(dir.isDirectory() && !dir.isHidden()){
            System.out.println(tab+dir.getName());
            for(File child:dir.listFiles()){
                tree(child,tab+"--");
            }
        }
    }
    
    public void writeText(boolean append) throws IOException{
    try(FileWriter fw=new FileWriter(mf,append)) {
        while(true){
            String txt=TestMiFile.lea.nextLine();
            System.out.print("Para dejar de escribir, coloque un \".\" al final de la frase: ");
            if (txt.endsWith(".")) {
                fw.write(txt+"\n"); 
                break;
            }
            fw.write(txt + "\n");
        }
    }
}
}
    
    
