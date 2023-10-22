/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author casti
 */
public class Grafo {
    private ArrayList<String> usuarios;
    private ArrayList<ArrayList<String>> conexiones;

    public Grafo() {
        usuarios = new ArrayList<>();
        conexiones = new ArrayList<>();
    }

    public void cargarArchivo(File archivo) throws FileNotFoundException, IOException {
        Scanner sc = new Scanner(new FileReader(archivo));
        usuarios.clear();
        conexiones.clear();
        while (sc.hasNextLine()) {
            String linea = sc.nextLine();
            String[] componentes = linea.split(",");
            usuarios.add(componentes[0]);
            conexiones.add(new ArrayList<>());
            for (int i = 1; i < componentes.length; i++) {
                conexiones.get(usuarios.size() - 1).add(componentes[i]);
            }
        }
        JOptionPane.showMessageDialog(null, "Se ha cargado un nuevo archivo. Los datos actuales no se han guardado.");
    }

    public ArrayList<String> getUsuarios() {
        return usuarios;
    }

    public ArrayList<ArrayList<String>> getConexiones() {
        return conexiones;
    }
}
