/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1;

import java.util.ArrayList;
import java.util.List;


public class Vertice {
    public int id;
    public String nombre;
    public List<Arista> conexion;

    public Vertice(int id, String nombre) {
            this.id = id;
            this.nombre = nombre;
            this.conexion = new ArrayList<>();
        }


    public int getId() {
            return id;
        }

    public String getNombre() {
            return nombre;
        }

    public List<Arista> getConexions() {
        return conexion;
    }

    public void setConexion(Arista conexion) {
        this.conexion.add(conexion);
    }
    
    
        
}
