package logica;

import java.util.ArrayList;

public class Cuadro{
    public char color, name;
    public int disponibilidad;
    public ArrayList<Cuadro> adjacentsB, adjacentsW; //Aqui guardo adyacencias negras y blancas
    private ArrayList<Cuadro> hijos; //Hijos en general para las rutas
    private Cuadro papa; //Referencia al papá de este nodo (Creo que ya no es necesario esto)
    
    public Cuadro(char color, char name){ //Cada cuadro sera blanco o negro y tendra un identificador (Una letra)
        this.color = color;
        this.name = name;
        
        this.disponibilidad = 1; //Cuando crees el cuadro, va a estar disponible
        this.adjacentsB = new ArrayList<>();
        this.adjacentsW = new ArrayList<>();
        this.hijos = new ArrayList<>();
    }
    
    public Cuadro(){
        
    }
    
    //Almacenaremos sus adyacencias
    public void setBlack(Cuadro [] array){
        int i;
        for(i = 0; i < array.length; i++){
            adjacentsB.add(array[i]);
        }
    }
    public void setWhite(Cuadro [] array){
        int i;
        for(i = 0; i < array.length; i++){
            adjacentsW.add(array[i]);
        }
    }
    public ArrayList<Cuadro> getBlack(){
        return adjacentsB;
    }
    public ArrayList<Cuadro> getWhite(){
        return adjacentsW;
    }
    
    //Metodos para el arbol
    public void setPapa(Cuadro obj) { //Le digo cual es el papá de este nodo
        this.papa = obj;
    }

    public Cuadro getPapa() { //Obtengo el papá del nodo
        return this.papa;
    }

    public ArrayList<Cuadro> getHijos() { //retorna mi ArrayList de hijos
        return this.hijos;
    }

    public void setHijos(ArrayList<Cuadro> value) { //Le pasamos el arrayList de hijos
        this.hijos = value;
    }

    public void añadirHijo(Cuadro obj) { //Añado hijos a mi nodo
        this.hijos.add(obj);
    }
    
    //--------------->
//    public void printTree(Cuadro nodo, String prefix, boolean isTail) {
//        System.out.println(prefix + (isTail ? "└── " : "├── ") + nodo.name);
//        ArrayList<Cuadro> children = nodo.getHijos();
//        for (int i = 0; i < children.size() - 1; i++) {
//            printTree(children.get(i), prefix + (isTail ? "    " : "│   "), false);
//        }
//        if (!children.isEmpty()) {
//            printTree(children.get(children.size() - 1), prefix + (isTail ?"    " : "│   "), true);
//        }
//    }
}
