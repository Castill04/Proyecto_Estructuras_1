/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1;


public class Vertice {
    public int id;
    public String nombre;
    public Arista conexion;

    public Vertice(int id, String nombre) {
            this.id = id;
            this.nombre = nombre;
            this.conexion = conexion;
        }


    public int getId() {
            return id;
        }

    public String getNombre() {
            return nombre;
        }

    public Arista getConexion() {
        return conexion;
    }

    public void setConexion(Arista conexion) {
        this.conexion = conexion;
    }
    
    
        
}
