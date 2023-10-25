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
import java.util.List;
import java.io.*;
import java.util.Arrays;
import javax.swing.*;


/**
 *
 * @author casti
 */
public class Grafo {
    private List<String> usuario;
    private List<List<String>> conexiones;
    private int[][] matrizAdyacencia;
    private int numVertices;
    private int numUsuarios;

    public Grafo() {
        this.usuario = new ArrayList<>();
        this.conexiones = new ArrayList<>();
        this.matrizAdyacencia = new int[numVertices][numVertices];
        this.numUsuarios = 0;
    }
    
    public void agregarUsuario(Vertice vertice) {
        usuario.add(vertice.toString());
        numUsuarios++;
    }

    public void agregarConexion(int origen, int destino) {
        matrizAdyacencia[origen][destino] = 1;
        matrizAdyacencia[destino][origen] = 1;
    }
    
    public void eliminarConexion(int origen, int destino) {
        matrizAdyacencia[origen][destino] = 0;
        matrizAdyacencia[destino][origen] = 0;
    }
    
    public boolean existeConexion(int origen, int destino) {
        return matrizAdyacencia[origen][destino] == 1;
    }
    
    public List<Integer> getAdyacentes(int vertice) {
        List<Integer> adyacentes = new ArrayList<>();
        for (int i = 0; i < numVertices; i++) {
            if (matrizAdyacencia[vertice][i] == 1) {
                adyacentes.add(i);
            }
        }
        return adyacentes;
    }
    
    public void actualizarRepositorio(File archivo) throws IOException {
        PrintWriter escritor = new PrintWriter(archivo);
        Iterable<Vertice> vertices = null;

        for (Vertice vertice : vertices) {
            escritor.println("# Usuario = " + vertice.getNombre());
            
        }
        escritor.println("Conexiones = " + getConexiones());
        escritor.close();
    }
    
    public int getNumUsuarios() {
        return numUsuarios;
    }

    public void cargarArchivo(File archivo) throws FileNotFoundException, IOException {
        JFileChooser selectorArchivos = new JFileChooser();
        Grafo grafo = new Grafo();
        int resultado = selectorArchivos.showOpenDialog(null);
        if (resultado == JFileChooser.APPROVE_OPTION) {
            archivo = selectorArchivos.getSelectedFile();
            FileReader lector = new FileReader(archivo);
            BufferedReader buffer = new BufferedReader(lector);
            String linea;
            while ((linea = buffer.readLine()) != null) {
                String[] campos = linea.split(" ");
                if (campos[0].equals("#")) {
                    continue;
                }
                int id = Integer.parseInt(campos[0]);
                String nombre = campos[1];
                grafo.agregarUsuario(new Vertice(id, nombre));
                String[] amigos = campos[2].split(",");
                for (String amigo : amigos) {
                    int idAmigo = Integer.parseInt(amigo);
                    grafo.agregarConexion(new Vertice(id, nombre).id , new Vertice(idAmigo, nombre).id);
                }
            }
            buffer.close();
            JOptionPane.showMessageDialog(null, "Los datos cargados en memoria se han perdido.");
        }
    }

    public List<String> getUsuarios() {
        return usuario;
    }

    public List<List<String>> getConexiones() {
        return conexiones;
    }
}
