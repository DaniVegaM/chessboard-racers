package arbol;

import grafico.RedRutas;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import logica.Cuadro;

public class Arbol{
    private Cuadro raiz;
    public int numeroDeRutas = 0;
    public int numeroDeRutasGanadoras = 0;

    public Arbol(Cuadro raiz) { //Crea un arbol con la raiz especificada
        this.raiz = raiz;
    }
    
    public Cuadro getRaiz(){
        return raiz;
    }
    
    public void generarRutasGanadoras(char cuadroFinal, int numPlayer, Scanner scanner, BufferedWriter writer) throws FileNotFoundException, IOException{
            // Establece el delimitador a coma
            scanner.useDelimiter(", ");

            // Lee y muestra las cadenas del archivo
            while (scanner.hasNext()) {
                String cadena = scanner.next().trim(); // trim() elimina espacios en blanco alrededor de la cadena
                
                if(cadena.charAt(cadena.length() - 1) == cuadroFinal){
                    //System.out.println("Ruta GANADORA: " + cadena);
                    numeroDeRutasGanadoras++;
                    
                    // Escribe la cadena en el archivo
                    writer.write(cadena);
                    writer.write(", ");
                }
            }
            System.out.println("Total de Rutas ganadoras: " + numeroDeRutasGanadoras);
    }
    
    public void agregarHijosConPatron(char[] patronArray, Cuadro nodoActual, int i, String rutaActual, BufferedWriter writer, int nivel, RedRutas ventana) throws IOException{
        //System.out.println("i valee: " + i);
        if (i == patronArray.length) { //CASO BASE
            String cadena = rutaActual + nodoActual.name + ", ";
            
            // Escribe la cadena en el archivo
            writer.write(cadena);
            
            numeroDeRutas++;
            return; // Salir si i está fuera de los límites del patrón
        } //FIN CASO BASE
        
        // Imprimir con indentación según el nivel del árbol
        StringBuilder indentacion = new StringBuilder();
        for (int j = 0; j < nivel; j++) {
            indentacion.append("            "); // Dos espacios por nivel, puedes ajustarlo según tus preferencias
        }
        ventana.dibujarRuta(indentacion.toString() + "Nodo: " + nodoActual.name);
        
        char letraPatron = patronArray[i];
        
        //Cada vuelta agrega todos los hijos correspondientes a patronArray[i]
            if(letraPatron == 'b'){ //Agrego todos los hijos negros
                ventana.dibujarRuta("\n");
                for(int j = 0; j < nodoActual.getBlack().size(); j++){ //Agrego hijos negros al arrayList general
                    agregarHijosConPatron(patronArray, nodoActual.getBlack().get(j), i+1, rutaActual + nodoActual.name, writer, nivel + 1, ventana);
                }
                
            } else if(letraPatron == 'w'){ //Agrego todos los hijos blancos
                ventana.dibujarRuta("\n");
                for(int k = 0; k < nodoActual.getWhite().size(); k++){ //Agrego todos los hijos blancos al arrayList general       
                    agregarHijosConPatron(patronArray, nodoActual.getWhite().get(k), i+1, rutaActual + nodoActual.name, writer, nivel + 1, ventana);
                }
            }
    }
}
