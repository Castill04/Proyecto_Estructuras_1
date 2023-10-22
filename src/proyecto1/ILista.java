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
public interface ILista {
    public void insertBegin(Object element);
    public void insertFinal(Object element);
    public void insertIndex(Object element, int index);
    public Object deleteBegin();
    public Object deleteFinal();
    public Object deleteIndex(int index);
    public Boolean isEmpty();
    
}
