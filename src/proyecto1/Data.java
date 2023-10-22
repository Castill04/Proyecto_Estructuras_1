/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1;

import java.util.ArrayList;

/**
 *
 * @author casti
 */
public class Data {
    private Lista data; // Cambia esto por la estructura de datos que estés utilizando

    public Data() {
        this.data = new Lista();
    }
    public boolean isDataInMemory() {
        return !this.data.isEmpty();
    }
}
