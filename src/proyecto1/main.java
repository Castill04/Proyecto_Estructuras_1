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
import Interfaces.newpackage.FunctionalRequirements;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JFileChooser;

public class main {    

    public static void main(String[] args) throws FileNotFoundException, IOException {

        FunctionalRequirements window = new FunctionalRequirements(); 
        Grafo grafo = new Grafo();
        

        JFileChooser fileChooser = new JFileChooser();
        int resultado = fileChooser.showOpenDialog(null);
        if (resultado == JFileChooser.APPROVE_OPTION) {
            File archivo = fileChooser.getSelectedFile();
            grafo.cargarArchivo(archivo);
            for (int i = 0; i < grafo.getUsuarios().size(); i++) {
                System.out.println("Usuario: " + grafo.getUsuarios().get(i));
                for (String conexion : grafo.getConexiones().get(i)) {
                    System.out.println("Conexión: " + conexion);
                }
            }
        }
    }
    
    

}
