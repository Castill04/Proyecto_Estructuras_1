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
public class Arista {
    private Vertice start;
    private Vertice end;

    public Arista(Vertice start, Vertice end) {
        this.start = start;
        this.end = end;
        }

    public Vertice getStart() {
        return start;
        }

    public Vertice getEnd() {
        return end;
        }
    }

