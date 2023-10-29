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
    private List<Vertice> usuario;
    //private List<List<String>> conexiones;
    private int[][] matrizAdyacencia;
    private int numVertices;
    private int numUsuarios;

    public Grafo() {
        this.usuario = new ArrayList<>();
        //this.conexiones = new ArrayList<>();
        this.matrizAdyacencia = new int[numVertices][numVertices];
        this.numUsuarios = 0;
    }
    
    public void agregarUsuario(Vertice vertice) {
        usuario.add(vertice);
        numUsuarios++;
    }

    public void agregarConexion(Vertice origen, Vertice destino) {
        Vertice user = getUsuario(origen);
        if (user != null) {
            user.conexion.add(new Arista(origen, destino));
        }
        //matrizAdyacencia[origen][destino] = 1;
        //matrizAdyacencia[destino][origen] = 1;
    }
    
//    public void agregarConexion(int origen, int destino) {
//        matrizAdyacencia[origen][destino] = 1;
//        //matrizAdyacencia[destino][origen] = 1;
//    }
    
    public void eliminarConexion(int origen, int destino) {
        matrizAdyacencia[origen][destino] = 0;
        //matrizAdyacencia[destino][origen] = 0;
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
        //escritor.println("Conexiones = " + getConexiones());
        escritor.close();
    }
    
    public int getNumUsuarios() {
        return numUsuarios;
    }

    public String cargarArchivo(File archivo) throws FileNotFoundException, IOException {
        //JFileChooser selectorArchivos = new JFileChooser();
        Grafo grafo = new Grafo();
        //int resultado = selectorArchivos.showOpenDialog(null);
        //if (resultado == JFileChooser.APPROVE_OPTION) {
            //archivo = selectorArchivos.getSelectedFile();
            FileReader lector = new FileReader(archivo);
            BufferedReader buffer = new BufferedReader(lector);
            String linea;
            boolean addConexion = false;
            String grafo_txt="";
            while((linea = buffer.readLine())!= null){
                if (!linea.isEmpty()){
                    grafo_txt += linea+ "\n";
                } 
            }
            buffer.close();
            
            return grafo_txt;
            
           
            
//            while ((linea = buffer.readLine()) != null) {
//                String[] campos = linea.split(" ");
//                if (campos[0].equals("Conexion")) {
//                   addConexion = true;
//                   continue;
//                }
////                if (campos[0].equals("#")) {
////                    continue;
////                }
//                if (!addConexion) {
//                int id = Integer.parseInt(campos[0]);
//                String nombre = campos[1];
//                grafo.agregarUsuario(new Vertice(id, nombre));
//                }
//                else {
//                     String[] relation = campos[0].split(",");
//                     int idorigin = Integer.parseInt(relation[0]);
//                     int iddestino = Integer.parseInt(relation[1]);
//                     //grafo.agregarConexion(idorigin, iddestino);
//                }
                
                
//                String[] amigos = campos[2].split(",");
//                for (String amigo : amigos) {
//                    int idAmigo = Integer.parseInt(amigo);
//                        grafo.agregarConexion(new Vertice(id, nombre).id , new Vertice(idAmigo, nombre).id);
//                }
            //}
            //buffer.close();
            //return grafo;
            //JOptionPane.showMessageDialog(null, "Los datos cargados en memoria se han perdido.");
        //}
    }

    public List<Vertice> getUsuarios() {
        return usuario;
    }
    
    public Vertice getUsuario(Vertice usuario) {
        Vertice item = null;
        for(Vertice item2 : getUsuarios()){
            if (item2.id == usuario.id)
                return item2;
        }
        return item;
    }

//    public List<List<String>> getConexiones() {
//        return conexiones;
//    }
}
