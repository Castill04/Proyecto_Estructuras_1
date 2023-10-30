/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1;

/**
 *
 * @author casti
 */
import Funciones.FunctionGrafo;
import Funciones.FunctionTXT;
import Funciones.LeerArchivo;
import Interfaces.Bienvenida;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JFileChooser;

public class main {    
    public static Grafo grafo;

    public static void main(String[] args) throws FileNotFoundException, IOException {

        LeerArchivo f = new LeerArchivo();
        FunctionTXT content = new FunctionTXT();
        String infoGrafo = f.leertxt("test\\proyecto.txt");
        String[] users = content.getUsuarios(infoGrafo);
        String[] relaciones = content.getRelaciones(infoGrafo);
        FunctionGrafo grafoFunctions = new FunctionGrafo();
        grafo = grafoFunctions.crearGrafo(users, relaciones);
        
        Bienvenida window = new Bienvenida();
        window.setVisible(true);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        
    }
    
    

}
