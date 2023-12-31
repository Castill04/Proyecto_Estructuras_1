/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funciones;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.JOptionPane;

/**
 *
 * @author francisco
 */
public class LeerArchivo {
    /**
     * Funcion para guardar el contenido del archivo seleccionado como string
     * @param url, path del archivo seleccionado por el usuario
     * @return String grafo_txt, contenido del archivo seleccionado
     */
    public String leertxt(String url){

        String line;  
        String grafo_txt="";
        File file = new File(url);
        try{
            if (!file.exists()){
                file.createNewFile();
            } else{
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                while((line = br.readLine())!= null){
                    if (!line.isEmpty()){
                        grafo_txt += line+ "\n";
                    } 
                }
                br.close();

            }
        }catch(Exception err){
             JOptionPane.showMessageDialog(null, "Error");
        }

        return grafo_txt;
    }
}
