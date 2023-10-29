/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funciones;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.MultiGraph;
import org.graphstream.ui.swing_viewer.SwingViewer;
import org.graphstream.ui.swing_viewer.ViewPanel;
import org.graphstream.ui.view.Viewer;
import proyecto1.Arista;
import proyecto1.Grafo;
import proyecto1.Vertice;

/**
 *
 * @author francisco
 */
public class FunctionGrafo {
    
    Grafo grafoAux = new Grafo();
    LeerArchivo f = new LeerArchivo();
    FunctionTXT use = new FunctionTXT();
    String infoGrafo = f.leertxt("test\\proyecto.txt");
    String[] users = use.getUsuarios(infoGrafo);
    String[] relaciones = use.getRelaciones(infoGrafo);
    
    public Grafo crearGrafo(String[] users, String[] relaciones){
        for (int i = 1; i < users.length; i++) {
            String[] info = users[i].trim().split(",");
            String username = info[1].trim();
            int id = Integer.parseInt(info[0].trim());
            Vertice user1 = new Vertice(id, username);
            grafoAux.agregarUsuario(user1);
        }
        for (int j = 1; j < relaciones.length; j++) {
                String[] relationships = relaciones[j].trim().split(",");
                int id1 = Integer.parseInt(relationships[0].trim());
                int id2 = Integer.parseInt(relationships[1].trim());
                //int years = Integer.parseInt(relationships[2].trim());
                List<Vertice> usersGrafo = grafoAux.getUsuarios();
//                NodoVertex pointer = usersGrafo.getHead();
//                User userAux = (User) pointer.getElement();
//                int idAux = userAux.getUserID();
                Vertice idName1 = getUsuarioByID(usersGrafo, id1);
                Vertice idName2 = getUsuarioByID(usersGrafo, id2);
                if (idName1 != null && idName2 != null){
                    grafoAux.agregarConexion(idName1, idName2);
                }else{
                    JOptionPane.showMessageDialog(null, "error");
                   }
                
        } 
        return grafoAux;
        
        }
      
     
    public Vertice getUsuarioByID(List<Vertice> allUsers, int id){
        Vertice name = null;
        for (Vertice user : allUsers) {
            
            
            if(user.id == id){
                return user;
            } 
        } return name;
    }
    
//    public boolean validarAgregarUser (Grafo grafo,String idUser1, String idUser2, String username1,String username2, String years){
//        try{
//            if (username1.charAt(0)!='@' || username2.charAt(0)!='@'){
//                    JOptionPane.showMessageDialog(null, "Error: Recuerde colocar @ antes de los usernames de los usuarios");
//                    return false;
//            }
//            int year = Integer.parseInt(years);
//            int id1 = Integer.parseInt(idUser1);
//            int id2 = Integer.parseInt(idUser2);
//
//            if (id1 == id2){
//                JOptionPane.showMessageDialog(null, "Error: Recuerde que dos usuarios no pueden tener el mismo id");
//                return false;
//            } if (username1.equalsIgnoreCase(username2)){
//                JOptionPane.showMessageDialog(null, "Error: Recuerde que dos usuarios no pueden tener el mismo username");
//                return false;
//            }
//            User usuario1 = new User(username1, id1);
//            User usuario2 = new User(username2, id2);
//            ListaVertex listaUsers = grafo.getUserList();
//            for (NodoVertex pointer = listaUsers.getHead(); pointer != listaUsers.getTail(); pointer = pointer.getNext()) {
//                User usuarioComparar =(User) pointer.getElement();
//                String usernameComparar = usuarioComparar.getUsername();
//                int idComparar = usuarioComparar.getUserID();
////                if((usuario1.getUserID() == idComparar && !usuario1.getUsername().equalsIgnoreCase(usernameComparar)) || (usuario1.getUserID() != idComparar && usuario1.getUsername().equalsIgnoreCase(usernameComparar))){
////                    JOptionPane.showMessageDialog(null, "Error: Los valores del usuario 1 no coinciden con los guardados en el sistema.\nRecuerde que un usuario tiene un unico id y username");
////                    return false;
////                } if((usuario2.getUserID() == idComparar && !usuario2.getUsername().equalsIgnoreCase(usernameComparar)) || (usuario2.getUserID() != idComparar && usuario2.getUsername().equalsIgnoreCase(usernameComparar))){
////                    JOptionPane.showMessageDialog(null, "Error: Los valores del usuario 2 no coinciden con los guardados en el sistema.\nRecuerde que un usuario tiene un unico id y username");
////                    return false;
////                }; 
//                if( idComparar == id1 ){
//                    JOptionPane.showMessageDialog(null, "El usuario 1 ya esta registrado en el sistema. Ingrese solo usuarios nuevos.");
//                    return false;
//                } if (idComparar == id2){
//                    JOptionPane.showMessageDialog(null, "El usuario 2 ya esta registrado en el sistema. Ingrese solo usuarios nuevos.");
//                    return false;
//                }
//
//        }}catch(Exception e){
//            JOptionPane.showMessageDialog(null, "Error: Recuerde solo ingresar numeros enteros en los ids y en los años de amistad");
//            return false;
//        } 
//        return true;
//        
//    
//        }
    
//    public boolean validarAddUser (Grafo grafo,String idUser1, String username1){
//        try{
//            if (username1.charAt(0)!='@'){
//                    JOptionPane.showMessageDialog(null, "Error: Recuerde colocar @ antes de los usernames de los usuarios");
//                    return false;
//            }
//            int id1 = Integer.parseInt(idUser1);
//
//            ListaVertex listaUsers = grafo.getUserList();
//            for (NodoVertex pointer = listaUsers.getHead(); pointer != listaUsers.getTail(); pointer = pointer.getNext()) {
//                User usuarioComparar =(User) pointer.getElement();
//                String usernameComparar = usuarioComparar.getUsername();
//                int idComparar = usuarioComparar.getUserID();
//                if( idComparar == id1 ){
//                    JOptionPane.showMessageDialog(null, "Ya existe un usuario registrado con el id "+id1+"\nIngrese unicamente usuarios nuevos por favor.");
//                    return false;
//                } else if( usernameComparar.trim().equalsIgnoreCase(username1)){
//                    JOptionPane.showMessageDialog(null, "Ya existe un usuario registrado con el username "+username1+"\nIngrese unicamente usuarios nuevos por favor.");
//                    return false;
//                }
//
//        }}catch(Exception e){
//            JOptionPane.showMessageDialog(null, "Error: Recuerde solo ingresar numeros enteros como id");
//            return false;
//        } 
//        return true;
//        
//    
//        }
           
    public void viewGraph(Graph graph) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        JPanel panel = new JPanel(new GridLayout()){
        @Override
        public Dimension getPreferredSize() {
            return new Dimension(640, 480);
            }
        };
        frame.setSize(panel.getWidth(), panel.getHeight());
        frame.setBackground(Color.blue);
        Viewer viewer = new SwingViewer(graph, Viewer.ThreadingModel.GRAPH_IN_GUI_THREAD);
        viewer.enableAutoLayout();
        ViewPanel viewPanel = (ViewPanel)viewer.addDefaultView(false);
        panel.add(viewPanel);
        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);  
        
    }
    
    public Graph drawGraph (Grafo grafo){
        Graph graph = new MultiGraph("Relacion");
        System.setProperty("org.graphstream.ui", "swing");
        graph.setAttribute("ui.stylesheet", "node{\n"+ "size:40px,30px;\n"+"fill-color:#9EBCEF; \n"+"text-mode: normal; \n"+"}");
        
        for (int i=0;i<grafo.getUsuarios().size();i++){
            Vertice user = grafo.getUsuarios().get(i);
            //String userid = grafo.getUserList().getDato(i).getElement().getUsername();
            String userid = user.getNombre();
            graph.addNode(userid).setAttribute("ui.label",userid);
        }
        // Se recorre la lista de adyacencia de nuestro grafo para añadir los arcos y pesos al grafo de GraphStream
        for (int i=0; i < grafo.getUsuarios().size(); i++){
            Vertice friend1 = grafo.getUsuarios().get(i);
            //NodoVertex node1 = grafo.getUserList().getDato(i);
            for (int j=0; j<friend1.getConexions().size(); j++){
                Arista friend2 = friend1.getConexions().get(j);
                //String weight = String.valueOf(node1.getFriendList().getDato(j).getWeight());
                String id = friend1.getNombre() + friend2.getEnd().getNombre();
                graph.addEdge(id, friend1.getNombre(), friend2.getEnd().getNombre(), false);
            }
    } return graph;
    }
    
}
