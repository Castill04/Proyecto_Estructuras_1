/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funciones;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.regex.Pattern;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;


/**
 *
 * @author francisco
 */
public class FunctionTXT {
    JFileChooser seleccionar = new JFileChooser();
    File archivo; 
    FileInputStream entrada; 
    FileOutputStream salida; 
    /**
     * Creates new form AbrirGuardarTxt
     */

    /**
     * Funcion que abre el archivo txt
     * @param archivo, File seleccionado por el usuario
     * @return String documento, contenido del archivo seleccionado
     */
    public String AbrirArchivo(File archivo){
        String documento="";
        try{
            entrada = new FileInputStream(archivo);
            int ascci;
            while((ascci = entrada.read())!=-1){
                char caracter = (char) ascci; 
                documento += caracter; 
            }
        }catch(Exception e){      
        }
        return documento; 
    }
    
    public String GuardarArchivo(File archivo, String documento){
        String mensaje = null; 
        try {
            salida = new FileOutputStream(archivo);
            byte[] bytxt = documento.getBytes();
            salida.write(bytxt);
            mensaje="Archivo guardado";  
        }catch(Exception e){
        }
        return mensaje;
    }

    /**
     * Funcion que valida que el contenido del txt cumpla con la estructura requerida
     * @param contenido, contenido del archivo seleccionado por el usuario
     * @return boolean true si el archivo es valido
     */
    public boolean validarTxt(String contenido){
        try{
         if (!contenido.contains("Usuarios") || !contenido.contains("Relaciones")){
             return false;
         } else{
             String[] separar = contenido.split("Relaciones");
             String usuarios = separar [0];
             String relaciones = separar[1];
             String[] users = usuarios.split("\n");
             String[] relations = relaciones.split("\n");
             for (int i = 1; i < users.length; i++){
                 String[] user = users[i].trim().split(",");
                 try{
                     Integer.parseInt(user[0]);
                     String username = user[1];
                     if (user[1].trim().charAt(0) != '@'){
                         return false;     
                     }
                 }catch(Exception e){
                     return false;
                 }
                 
             } for (int i = 1; i < relations.length; i++) {
                 String[] relacion = relations[i].split(",");
               
                 try{
                     Integer.parseInt(relacion[0].trim());
                     Integer.parseInt(relacion[1].trim());
                 } catch(Exception e){
                     return false;
                 }}
         }
        
             }catch(Exception e){
                 return false;
             }return true;
          
          
       }
    
    
    public String[] getUsuarios (String content){
        String[] separar = content.split("Relaciones");
        String usuarios = separar [0];
        String[] users = usuarios.split("\n");
        return users;
    }
    
    /**
     * Funcion que separa el contenido del archivo para obtener el array de relaciones
     * @param content, contenido del archivo seleccionado por el usuario
     * @return Array users, array de relaciones cada una con los ids de cada usuario y sus años de amistad
     */
    public String[] getRelaciones (String content){
        String[] separar = content.split("Relaciones");
        String relaciones = separar[1];
        String[] relations = relaciones.split("\n");
        return relations;
    }
       
    
    /**
     * Funcion que permite reemplazar la informacion del TXT del sistema con la informacion subida por el usuario
     * @param contenido, informacion contenida el archivo seleccionado por el usuario
     */
    public void escribir_txt(String contenido){
        
        try{
            PrintWriter pw = new PrintWriter("test\\Proyecto.txt");
            pw.write(contenido);
            
            pw.close();
//            JOptionPane.showMessageDialog(null, "Guardado exitoso");
            
        }catch(Exception err){
            JOptionPane.showMessageDialog(null, err);
        }
    }
    
    public void modificarUsuarioRelacion (int id1, int id2, String username1, String username2, int years){
        
        LeerArchivo read = new LeerArchivo();
        String document = read.leertxt("test\\TxtProyecto.txt");
        String[] info = document.split("Relaciones");
        String users = info[0];

        users += +id1+","+username1+"\n"+id2+","+username2;
        String relaciones = info[1];
        relaciones += id1+","+id2+","+years+"\n";
        String agregar = users +"\n\nRelaciones"+ relaciones+"\n";

        escribir_txt(agregar);
        
    }
    
    public void agregarRelacion(int id1, int id2, int years){
        LeerArchivo read = new LeerArchivo();
        String document = read.leertxt("test\\TxtProyecto.txt");
        String[] info = document.split("Relaciones");
        String users = info[0];

        
        String relaciones = info[1];
        String[] relations = relaciones.split("\n");
        String relacionesFinal ="";
        String agregar = users +"\n\nRelaciones\n";
        for (int i = 1; i < relations.length; i++) {
            String[] ids = relations[i].trim().split(",");
            relacionesFinal += relations[i]+"\n";
        }
        agregar += relacionesFinal + String.valueOf(id1) +"," + String.valueOf(id2)+","+String.valueOf(years);
        escribir_txt(agregar);
    }
    
    
    public void agregarUser (String username, int id){
        LeerArchivo read = new LeerArchivo();
        String document = read.leertxt("test\\TxtProyecto.txt");
        String[] info = document.split("Relaciones");
        String users = info[0];
        String relations = info[1];
        users += +id+","+username+"\n";

        String agregar = users +"\n\nRelaciones"+relations;

        escribir_txt(agregar);
    }
}
