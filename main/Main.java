package main;

import arbol.Arbol;
import grafico.Grafico;
import grafico.RedRutas;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import logica.Cuadro;
import logica.Jugador;
import static utilidades.Utilidades.pausar2seg;

public class Main {
    
    static Grafico ventana = new Grafico();
    static RedRutas ventana1 = new RedRutas(1);
    static RedRutas ventana2 = new RedRutas(2);
    
    
    //Patron
    static String patron1 = "";
    static String patron2 = "";
    static int numPlayers = 0;
    public static boolean play = true;
    public static int todoListo = 0;
    
    //Variables por si se quedan encerrados
    static int p1Pasa = 0;
    static int p2Pasa = 0;
    
    //Genero cuadros
        public static Cuadro A = new Cuadro('w', 'A');
        public static Cuadro B = new Cuadro('b', 'B');
        public static Cuadro C = new Cuadro('w', 'C');
        public static Cuadro D = new Cuadro('b', 'D');
        public static Cuadro E = new Cuadro('b', 'E');
        public static Cuadro F = new Cuadro('w', 'F');
        public static Cuadro G = new Cuadro('b', 'G');
        public static Cuadro H = new Cuadro('w', 'H');
        public static Cuadro I = new Cuadro('w', 'I');
        public static Cuadro J = new Cuadro('b', 'J');
        public static Cuadro K = new Cuadro('w', 'K');
        public static Cuadro L = new Cuadro('b', 'L');
        public static Cuadro M = new Cuadro('b', 'M');
        public static Cuadro N = new Cuadro('w', 'N');
        public static Cuadro O = new Cuadro('b', 'O');
        public static Cuadro P = new Cuadro('w', 'P');
        
    //Variables de rutas que sigo
        static String rutaQueSeguiP1 = "A";
        static String rutaQueSeguiP2 = "D";
        
        static int pasoP1 = 0;
        static int pasoP2 = 0;

    public static void main(String[] args) throws IOException {
        
    ventana.setVisible(true);
    ventana1.setVisible(true);
    ventana2.setVisible(true);
        
    //Esperamos hasta que se ingrese el patron
        if(numPlayers == 1){
            while (todoListo != 2) {
//                    System.out.println("todoListo: " + todoListo);
                try {
                    Thread.sleep(100); // Espera 100 milisegundos antes de verificar de nuevo
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } else{
            while (todoListo != 3) {
//                    System.out.println("todoListo: " + todoListo);
                try {
                    Thread.sleep(100); // Espera 100 milisegundos antes de verificar de nuevo
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
            
        //------------------------------> DATOS
        //Establecemos adyacencias
        Cuadro[] atemp; //Arreglo temporal para pasarlo como parametro a los setters
        
        //Adyacencias de A
        atemp = new Cuadro[]{B, E};
        A.setBlack(atemp);
        atemp = new Cuadro[]{F};
        A.setWhite(atemp);
        
        //Adyacencias de B
        atemp = new Cuadro[]{E, G};
        B.setBlack(atemp);
        atemp = new Cuadro[]{A, C, F};
        B.setWhite(atemp);
        
        //Adyacencias de C
        atemp = new Cuadro[]{B, D, G};
        C.setBlack(atemp);
        atemp = new Cuadro[]{F, H};
        C.setWhite(atemp);
        
        //Adyacencias de D
        atemp = new Cuadro[]{G};
        D.setBlack(atemp);
        atemp = new Cuadro[]{C, H};
        D.setWhite(atemp);
        
        //Adyacencias de E
        atemp = new Cuadro[]{B, J};
        E.setBlack(atemp);
        atemp = new Cuadro[]{A, F, I};
        E.setWhite(atemp);
        
        //Adyacencias de F
        atemp = new Cuadro[]{B, E, G, J};
        F.setBlack(atemp);
        atemp = new Cuadro[]{A, C, I, K};
        F.setWhite(atemp);
        
        //Adyacencias de G
        atemp = new Cuadro[]{B, D, J, L};
        G.setBlack(atemp);
        atemp = new Cuadro[]{C, F, H, K};
        G.setWhite(atemp);
        
        //Adyacencias de H
        atemp = new Cuadro[]{D, G, L};
        H.setBlack(atemp);
        atemp = new Cuadro[]{C, K};
        H.setWhite(atemp);
        
        //Adyacencias de I
        atemp = new Cuadro[]{E, J, M};
        I.setBlack(atemp);
        atemp = new Cuadro[]{F, N};
        I.setWhite(atemp);
        
        //Adyacencias de J
        atemp = new Cuadro[]{E, G, M, O};
        J.setBlack(atemp);
        atemp = new Cuadro[]{F, I, K, N};
        J.setWhite(atemp);
        
        //Adyacencias de K
        atemp = new Cuadro[]{G, J, L, O};
        K.setBlack(atemp);
        atemp = new Cuadro[]{F, H, N, P};
        K.setWhite(atemp);
        
        //Adyacencias de L
        atemp = new Cuadro[]{G, O};
        L.setBlack(atemp);
        atemp = new Cuadro[]{H, K, P};
        L.setWhite(atemp);
        
        //Adyacencias de M
        atemp = new Cuadro[]{J};
        M.setBlack(atemp);
        atemp = new Cuadro[]{I, N};
        M.setWhite(atemp);
        
        //Adyacencias de N
        atemp = new Cuadro[]{M, J, O};
        N.setBlack(atemp);
        atemp = new Cuadro[]{I, K};
        N.setWhite(atemp);
        
        //Adyacencias de O
        atemp = new Cuadro[]{J, L};
        O.setBlack(atemp);
        atemp = new Cuadro[]{N, K, P};
        O.setWhite(atemp);
        
        //Adyacencias de P
        atemp = new Cuadro[]{L, O};
        P.setBlack(atemp);
        atemp = new Cuadro[]{K};
        P.setWhite(atemp);
        
        //------------------------------> FIN DATOS
        
        //------------------------------> LOGICA
        
        //Creo dos arboles, uno para player1 y otro para player2
        
        //Convierto mi patron en array, para recorrerlo
        if(numPlayers == 1){ //SI ES 1 JUGADOR
            
            int longitudPatron = patron1.length() + 1;
            
            Arbol arbol1 = new Arbol(A); //Creo mi arbol
            char[] patronArray1 = new char[longitudPatron];
            System.arraycopy(patron1.toCharArray(), 0, patronArray1, 0, longitudPatron - 1);
            
            //Siempre se agrega esto para que cada player termine en su cuadro correspondiente
            patronArray1[longitudPatron - 1] = 'w';
            
            /*NOTA IMPORTANTE: Voy a añadirle a cada patron un color final, dependiendo la ruta de cada jugador,
                           por lo que si van a seguir el patron, pero al final cada uno puede llegar a su cuadro
            */
            
            for(char elemento: patronArray1){
                System.out.println("patronArray1: " + elemento);
            }
            
            //Genero arbol en base al patron
            /*NOTA: El patron empieza a contar a partir del segundo cuadro, (el cuadro que va despues de el cuadro de inicio del jugador)
                    Y el patron de cada player se modifica para que cada uno pueda acabar en su cuadro del color correspondiente
            */
         
            //Este metodo me genera el arbol al mismo tiempo que voy generando rutas
            BufferedWriter writer1 = new BufferedWriter(new FileWriter("rutas1.txt", true));
            
            System.out.println("Rutas de Player1");
            arbol1.agregarHijosConPatron(patronArray1, arbol1.getRaiz(), 0, "", writer1, 0, ventana1);
            writer1.close();
            writer1 = null;
            Grafico.estadoCad ="Ya genere rutas para Player1";
            
            Grafico.estadoCad = "El numero de rutas de player 1 es: " + arbol1.numeroDeRutas;
            
            System.out.println("RUTAS GANADORAS");
            Scanner scannerRutasG1 = new Scanner(new File("rutas1.txt"));
            
            BufferedWriter writerG1 = new BufferedWriter(new FileWriter("rutasGanadoras1.txt", true));
            
            arbol1.generarRutasGanadoras('P', 1, scannerRutasG1, writerG1);
            writerG1.close();
            scannerRutasG1.close();
            
            Grafico.estadoCad = "Termine de la logica, empezare a moverme";
            
            //------------------------------> FIN LOGICA

            //------------------------------> MOVERME EN TABLERO
            
            if(play = true){
                //Scanners para ir leyendo cadenas ganadoras
                Scanner scannerRutas1 = new Scanner(new File("rutasGanadoras1.txt"));
                ArrayList<String> rutasGanadoras1 = new ArrayList<>();

                scannerRutas1.useDelimiter(", ");

                while (scannerRutas1.hasNext()){ //Agrego mis rutas ganadoras al arrayList
                    String ruta = scannerRutas1.next().trim(); // trim() elimina espacios en blanco alrededor de la cadena
                    //System.out.println("Ruta: " + ruta);
                    rutasGanadoras1.add(ruta);
                }
                scannerRutas1.close();

                if(rutasGanadoras1.isEmpty()){
                    Grafico.estadoCad = "NO HAY MANERA DE QUE PLAYER 1 GANE CON ESE PATRON :( ";
                    return;
                }

                //PRUEBA
                //System.out.println("Ejemplo de rutasGaanadoras1: " + rutasGanadoras1.get(0));

                //Genero jugadores
                Jugador player1 = new Jugador("Player1", 'A');

                player1.setPosicionAnterior('A');


                int i = 1;
                while(i <= longitudPatron ){
                    moverJugadores(rutasGanadoras1, player1, i); 
                    if(pasoP1 == 0){
                        i++;
                    }
                    if(i > longitudPatron){
                       Grafico.estadoCad ="GANO EL JUGADOR 1";
                       break;
                    }
                    pausar2seg();
                }
                pausar2seg();
            //Imprimo las rutas que siguio cada uno
            Grafico.estadoCad = player1.name + " :La ruta que seguí fue " + rutaQueSeguiP1;
            }
        } else if(numPlayers == 2){ //SI SON 2 JUGADORES
            Arbol arbol1 = new Arbol(A); //Creo mi arbol
            Arbol arbol2 = new Arbol(D); //Creo mi arbol
            
            /*NOTA IMPORTANTE: Voy a añadirle a cada patron un color final, dependiendo la ruta de cada jugador,
                           por lo que si van a seguir el patron, pero al final cada uno puede llegar a su cuadro
            */
            int longitudPatron1 = patron1.length() + 1;
            int longitudPatron2 = patron2.length() + 1;
            
            char[] patronArray1 = new char[longitudPatron1];
            char[] patronArray2 = new char[longitudPatron2];
            
            System.arraycopy(patron1.toCharArray(), 0, patronArray1, 0, longitudPatron1 - 1);
            System.arraycopy(patron2.toCharArray(), 0, patronArray2, 0, longitudPatron2 - 1);
            
            //Siempre se agrega esto para que cada player termine en su cuadro correspondiente
            patronArray1[longitudPatron1 - 1] = 'w';
            patronArray2[longitudPatron2 - 1] = 'b';
            
            for(char elemento: patronArray1){
                System.out.println("patronArray1: " + elemento);
            }
            for(char elemento: patronArray2){
                System.out.println("patronArray2: " + elemento);
            }
            
            //Genero arbol en base al patron
            /*NOTA: El patron empieza a contar a partir del segundo cuadro, (el cuadro que va despues de el cuadro de inicio del jugador)
                    Y el patron de cada player se modifica para que cada uno pueda acabar en su cuadro del color correspondiente
            */
         
            //Este metodo me genera el arbol al mismo tiempo que voy generando rutas
            BufferedWriter writer1 = new BufferedWriter(new FileWriter("rutas1.txt", true));
            BufferedWriter writer2 = new BufferedWriter(new FileWriter("rutas2.txt", true));
            
            System.out.println("Rutas de Player1");
            arbol1.agregarHijosConPatron(patronArray1, arbol1.getRaiz(), 0, "", writer1, 0, ventana1);
            writer1.close();
            writer1 = null;
            Grafico.estadoCad = "Ya genere rutas para Player1";
            
            System.out.println("\n\n\nRutas de Player2");
            arbol2.agregarHijosConPatron(patronArray2, arbol2.getRaiz(), 0, "", writer2, 0, ventana2);
            writer2.close();
            writer2 = null;
            Grafico.estadoCad = "Ya genere rutas para Player2";


            System.out.println("El numero de rutas de player 1 es: " + arbol1.numeroDeRutas);
            System.out.println("El numero de rutas de player 2 es: " + arbol2.numeroDeRutas);

            Grafico.estadoCad = "Rutas generadas con exito";
            //pausar20seg();

            System.out.println("RUTAS GANADORAS");
            Scanner scannerRutasG1 = new Scanner(new File("rutas1.txt"));
            Scanner scannerRutasG2 = new Scanner(new File("rutas2.txt"));

            BufferedWriter writerG1 = new BufferedWriter(new FileWriter("rutasGanadoras1.txt", true));
            BufferedWriter writerG2 = new BufferedWriter(new FileWriter("rutasGanadoras2.txt", true));

            arbol1.generarRutasGanadoras('P', 1, scannerRutasG1, writerG1);
            writerG1.close();
            scannerRutasG1.close();
            arbol2.generarRutasGanadoras('M', 2, scannerRutasG2, writerG2);
            writerG2.close();
            scannerRutasG2.close();

            System.out.println("Termine de la logica, empezare a moverme");

            //------------------------------> FIN LOGICA

            //------------------------------> MOVERME EN TABLERO
            if(play = true){
                //Scanners para ir leyendo cadenas ganadoras
                Scanner scannerRutas1 = new Scanner(new File("rutasGanadoras1.txt"));
                ArrayList<String> rutasGanadoras1 = new ArrayList<>();

                Scanner scannerRutas2 = new Scanner(new File("rutasGanadoras2.txt"));
                ArrayList<String> rutasGanadoras2 = new ArrayList<>();

                // Establece el delimitador a coma
                scannerRutas1.useDelimiter(", ");
                scannerRutas2.useDelimiter(", ");

                while (scannerRutas1.hasNext()){ //Agrego mis rutas ganadoras al arrayList
                    String ruta = scannerRutas1.next().trim(); // trim() elimina espacios en blanco alrededor de la cadena
                    //System.out.println("Ruta: " + ruta);
                    rutasGanadoras1.add(ruta);
                }
                scannerRutas1.close();

                if(rutasGanadoras1.isEmpty()){
                    Grafico.estadoCad = "NO HAY MANERA DE QUE PLAYER 1 GANE CON ESE PATRON :( ";
                    return;
                }

                while (scannerRutas2.hasNext()){ //Agrego mis rutas ganadoras al arrayList
                    String ruta = scannerRutas2.next().trim(); // trim() elimina espacios en blanco alrededor de la cadena
                    //System.out.println("Ruta: " + ruta);
                    rutasGanadoras2.add(ruta);
                }
                scannerRutas2.close();

                if(rutasGanadoras2.isEmpty()){
                    Grafico.estadoCad = "NO HAY MANERA DE QUE PLAYER 2 GANE CON ESE PATRON :( ";
                    return;
                }

                //PRUEBA
                //System.out.println("Ejemplo de rutasGaanadoras1: " + rutasGanadoras1.get(0));

                //Genero jugadores
                Jugador player1 = new Jugador("Player1", 'A');
                Jugador player2 = new Jugador("Player2", 'D');

                player1.setPosicionAnterior('A');
                player2.setPosicionAnterior('D');

                //Generemos el random para ver quien empieza primero
                Random random = new Random();
                int quienPrimero = random.nextInt(2) + 1;

                Grafico.estadoCad = "PRIMERO EL JUGADOR: " + quienPrimero;


                int i = 1, j = 1;
                while(i <= longitudPatron1 && j <= longitudPatron2){

                    if(quienPrimero == 1){
                        if(p1Pasa == 2){
                            System.out.println("Se ciclo, ATRAPADOS");
                            Grafico.estadoCad = "ATRAPADOS";
                            break;
                        }
                        moverJugadores(rutasGanadoras1, player1, i); 
                        if(pasoP1 == 0){
                            p1Pasa = 0;
                            i++;
                        } else{
                            p1Pasa++;
                        }
                        if(i > longitudPatron1){
                           Grafico.estadoCad = "GANO EL JUGADOR 2";
                           break;
                        }
                        pausar2seg();
                        if(p2Pasa == 2){
                            System.out.println("Se ciclo, ATRAPADOS");
                            Grafico.estadoCad = "ATRAPADOS";
                            break;
                        }
                        moverJugadores(rutasGanadoras2, player2, j);
                        if(pasoP2 == 0){
                            p2Pasa = 0;
                            j++;
                        } else{
                            p2Pasa++;
                        }
                        if(j > longitudPatron2){
                            Grafico.estadoCad = "GANO EL JUGADOR 2";
                            break;
                        }
                        pausar2seg();
                    } else{
                        if(p2Pasa == 2){
                            System.out.println("Se ciclo, ATRAPADOS");
                            Grafico.estadoCad = "ATRAPADOS";
                            break;
                        }
                        moverJugadores(rutasGanadoras2, player2, j); 
                        if(pasoP2 == 0){
                            p2Pasa = 0;
                            j++;
                        } else{
                            p2Pasa++;
                        }
                        if(j > longitudPatron2){
                            Grafico.estadoCad = "GANO EL JUGADOR 2";
                            break;
                        }
                        pausar2seg();
                        if(p1Pasa == 2){
                            System.out.println("Se ciclo, ATRAPADOS");
                            Grafico.estadoCad = "ATRAPADOS";
                            break;
                        }
                        moverJugadores(rutasGanadoras1, player1, i);
                        if(pasoP1 == 0){
                            p1Pasa = 0;
                            i++;
                        } else{
                            p1Pasa++;
                        }
                        if(i > longitudPatron1){
                           Grafico.estadoCad = "GANO EL JUGADOR 2";
                           break;
                        }
                        pausar2seg();
                    }
                }
                
                pausar2seg();
                //Imprimo las rutas que siguio cada uno
                Grafico.estadoCad = player1.name + " :La ruta que seguí fue " + rutaQueSeguiP1;
                Grafico.estadoCad = player2.name + " :La ruta que seguí fue " + rutaQueSeguiP2;
            }

                //------------------------------> FIN MOVERME EN TABLERO
        }
              
        //------------------------------> FIN DE LIBERAR RECURSOS DEL SISTEMA
    }
    
    public static void moverJugadores(ArrayList<String> rutasGanadoras, Jugador player, int i){
        boolean yaMeMovi = false;
        
        int numRuta = 0; //Empieza en 1 porque la primera posicion es donde estoy parado
        
        char dondeEstoy = (rutasGanadoras.get(numRuta)).charAt(i);
        //System.out.println("Estoy en: " + dondeEstoy);
        while(yaMeMovi == false){ //Cada vez que entro al metodo, es un movimiento en el tablero
            // i me indica la posicion en el patron en la que voy
            //System.out.println("Comparo con: " + (rutasGanadoras.get(numRuta).charAt(i)));
            switch((rutasGanadoras.get(numRuta)).charAt(i)){
                case 'A':
                    if(A.disponibilidad == 1 && dondeEstoy == (rutasGanadoras.get(numRuta)).charAt(i)){
                        player.moverse('A'); //Me muevo
                        if(player.name == "Player1"){ //Agrego el cuadro a mi ruta
                            rutaQueSeguiP1 += "-> A";
                            ventana.mover1A(325, 85);
                            pasoP1 = 0;
                        } else{
                            rutaQueSeguiP2 += "-> A";
                            ventana.mover2A(325, 85);
                            pasoP2 = 0;
                        }
                        yaMeMovi = true;
                        numRuta = 0;
                    } else{
                        
                        //Tomamos la siguiente ruta
                        numRuta++;
                        System.out.println(player.name + " cambio a ruta" + numRuta + " en la posicion: " + (rutasGanadoras.get(numRuta)).charAt(i));
                        if(player.name == "Player1"){
                            Grafico.estadoCad = "PLAYER 1 PENSANDO";
                        } else{
                            Grafico.estadoCad = "PLAYER 2 PENSANDO";

                        }
                        if(numRuta >= (rutasGanadoras.size() - 1)){
                            System.out.println(player.name + "Paso, ya no tengo mas rutas");
                            //Para que ya no siga avanzando i cuando diga un player: "paso"
                            
                            if(player.name == "Player1"){
                                Grafico.estadoCad = "PLAYER 1 PASA";
                                pasoP1 = 1;
                            } else{
                                Grafico.estadoCad = "PLAYER 2 PASA";
                                pasoP2 = 1;
                            }
                            return;
                        }
                    }
                    break;
                case 'B':
                    if(B.disponibilidad == 1 && dondeEstoy == (rutasGanadoras.get(numRuta)).charAt(i)){
                        player.moverse('B'); //Me muevo
                        if(player.name == "Player1"){
                            rutaQueSeguiP1 += "-> B";
                            ventana.mover1A(480, 85);
                            pasoP1 = 0;
                        } else{
                            rutaQueSeguiP2 += "-> B";
                            ventana.mover2A(480, 85);
                            pasoP2 = 0;
                        }
                        yaMeMovi = true;
                        numRuta = 0;
                    } else{
                        //Tomamos la siguiente ruta
                        numRuta++;
                        System.out.println(player.name + " cambio a ruta" + numRuta + " en la posicion: " + (rutasGanadoras.get(numRuta)).charAt(i));
                        if(player.name == "Player1"){
                            Grafico.estadoCad = "PLAYER 1 PENSANDO";
                        } else{
                            Grafico.estadoCad = "PLAYER 2 PENSANDO";

                        }
                        if(numRuta >= (rutasGanadoras.size() - 1)){
                            System.out.println(player.name + "Paso, ya no tengo mas rutas");
                            //Para que ya no siga avanzando i cuando diga un player: "paso"
                            
                            if(player.name == "Player1"){
                                Grafico.estadoCad = "PLAYER 1 PASA";
                                pasoP1 = 1;
                            } else{
                                Grafico.estadoCad = "PLAYER 2 PASA";
                                pasoP2 = 1;
                            }
                            return;
                        }
                    }
                    break;
                case 'C':
                    if(C.disponibilidad == 1 && dondeEstoy == (rutasGanadoras.get(numRuta)).charAt(i)){
                        player.moverse('C'); //Me muevo
                        if(player.name == "Player1"){
                            rutaQueSeguiP1 += "-> C";
                            ventana.mover1A(625, 85);
                            pasoP1 = 0;
                        } else{
                            rutaQueSeguiP2 += "-> C";
                            ventana.mover2A(625, 85);
                            pasoP2 = 0;
                        }
                        yaMeMovi = true;
                        numRuta = 0;
                    } else{
                        //Tomamos la siguiente ruta
                        numRuta++;
                        System.out.println(player.name + " cambio a ruta" + numRuta + " en la posicion: " + (rutasGanadoras.get(numRuta)).charAt(i));
                        if(player.name == "Player1"){
                            Grafico.estadoCad = "PLAYER 1 PENSANDO";
                        } else{
                            Grafico.estadoCad = "PLAYER 2 PENSANDO";

                        }
                        if(numRuta >= (rutasGanadoras.size() - 1)){
                            System.out.println(player.name + "Paso, ya no tengo mas rutas");
                            //Para que ya no siga avanzando i cuando diga un player: "paso"
                            
                            if(player.name == "Player1"){
                                Grafico.estadoCad = "PLAYER 1 PASA";
                                pasoP1 = 1;
                            } else{
                                Grafico.estadoCad = "PLAYER 2 PASA";
                                pasoP2 = 1;
                            }
                            return;
                        }
                    }
                    break;
                case 'D':
                    if(D.disponibilidad == 1 && dondeEstoy == (rutasGanadoras.get(numRuta)).charAt(i)){
                        player.moverse('D'); //Me muevo
                        if(player.name == "Player1"){
                            rutaQueSeguiP1 += "-> D";
                            ventana.mover1A(780, 85);
                            pasoP1 = 0;
                        } else{
                            rutaQueSeguiP2 += "-> D";
                            ventana.mover2A(780, 85);
                            pasoP2 = 0;
                        }
                        yaMeMovi = true;
                        numRuta = 0;
                    } else{
                        //Tomamos la siguiente ruta
                        numRuta++;
                        System.out.println(player.name + " cambio a ruta" + numRuta + " en la posicion: " + (rutasGanadoras.get(numRuta)).charAt(i));
                        if(player.name == "Player1"){
                            Grafico.estadoCad = "PLAYER 1 PENSANDO";
                        } else{
                            Grafico.estadoCad = "PLAYER 2 PENSANDO";

                        }
                        if(numRuta >= (rutasGanadoras.size() - 1)){
                            System.out.println(player.name + "Paso, ya no tengo mas rutas");
                            //Para que ya no siga avanzando i cuando diga un player: "paso"
                            
                            if(player.name == "Player1"){
                                Grafico.estadoCad = "PLAYER 1 PASA";
                                pasoP1 = 1;
                            } else{
                                Grafico.estadoCad = "PLAYER 2 PASA";
                                pasoP2 = 1;
                            }
                            return;
                        }
                    }
                    break;
                case 'E':
                    if(E.disponibilidad == 1 && dondeEstoy == (rutasGanadoras.get(numRuta)).charAt(i)){
                        player.moverse('E'); //Me muevo
                        if(player.name == "Player1"){
                            rutaQueSeguiP1 += "-> E";
                            ventana.mover1A(325, 240);
                            pasoP1 = 0;
                        } else{
                            rutaQueSeguiP2 += "-> E";
                            ventana.mover2A(325, 240);
                            pasoP2 = 0;
                        }
                        yaMeMovi = true;
                        E.disponibilidad = 0;
                        numRuta = 0;
                    } else{
                        //Tomamos la siguiente ruta
                        numRuta++;
                        System.out.println(player.name + " cambio a ruta" + numRuta + " en la posicion: " + (rutasGanadoras.get(numRuta)).charAt(i));
                        if(player.name == "Player1"){
                            Grafico.estadoCad = "PLAYER 1 PENSANDO";
                        } else{
                            Grafico.estadoCad = "PLAYER 2 PENSANDO";

                        }
                        if(numRuta >= (rutasGanadoras.size() - 1)){
                            System.out.println(player.name + "Paso, ya no tengo mas rutas");
                            //Para que ya no siga avanzando i cuando diga un player: "paso"
                            
                            if(player.name == "Player1"){
                                Grafico.estadoCad = "PLAYER 1 PASA";
                                pasoP1 = 1;
                            } else{
                                Grafico.estadoCad = "PLAYER 2 PASA";
                                pasoP2 = 1;
                            }
                            return;
                        }
                    }
                    break;
                case 'F':
                    if(F.disponibilidad == 1 && dondeEstoy == (rutasGanadoras.get(numRuta)).charAt(i)){
                        player.moverse('F'); //Me muevo
                        if(player.name == "Player1"){
                            rutaQueSeguiP1 += "-> F";
                            ventana.mover1A(480, 240);
                            pasoP1 = 0;
                        } else{
                            rutaQueSeguiP2 += "-> F";
                            ventana.mover2A(480, 240);
                            pasoP2 = 0;
                        }
                        yaMeMovi = true;
                        numRuta = 0;
                    } else{
                        //Tomamos la siguiente ruta
                        numRuta++;
                        System.out.println(player.name + " cambio a ruta" + numRuta + " en la posicion: " + (rutasGanadoras.get(numRuta)).charAt(i));
                        if(player.name == "Player1"){
                            Grafico.estadoCad = "PLAYER 1 PENSANDO";
                        } else{
                            Grafico.estadoCad = "PLAYER 2 PENSANDO";

                        }
                        if(numRuta >= (rutasGanadoras.size() - 1)){
                            System.out.println(player.name + "Paso, ya no tengo mas rutas");
                            //Para que ya no siga avanzando i cuando diga un player: "paso"
                            
                            if(player.name == "Player1"){
                                Grafico.estadoCad = "PLAYER 1 PASA";
                                pasoP1 = 1;
                            } else{
                                Grafico.estadoCad = "PLAYER 2 PASA";
                                pasoP2 = 1;
                            }
                            return;
                        }
                    }
                    break;
                case 'G':
                    if(G.disponibilidad == 1 && dondeEstoy == (rutasGanadoras.get(numRuta)).charAt(i)){
                        player.moverse('G'); //Me muevo
                        if(player.name == "Player1"){
                            rutaQueSeguiP1 += "-> G";
                            ventana.mover1A(625, 240);
                            pasoP1 = 0;
                        } else{
                            rutaQueSeguiP2 += "-> G";
                            ventana.mover2A(625, 240);
                            pasoP2 = 0;
                        }
                        yaMeMovi = true;
                        numRuta = 0;
                    } else{
                        //Tomamos la siguiente ruta
                        numRuta++;
                        System.out.println(player.name + " cambio a ruta" + numRuta + " en la posicion: " + (rutasGanadoras.get(numRuta)).charAt(i));
                        if(player.name == "Player1"){
                            Grafico.estadoCad = "PLAYER 1 PENSANDO";
                        } else{
                            Grafico.estadoCad = "PLAYER 2 PENSANDO";

                        }
                        if(numRuta >= (rutasGanadoras.size() - 1)){
                            System.out.println(player.name + "Paso, ya no tengo mas rutas");
                            //Para que ya no siga avanzando i cuando diga un player: "paso"
                            
                            if(player.name == "Player1"){
                                Grafico.estadoCad = "PLAYER 1 PASA";
                                pasoP1 = 1;
                            } else{
                                Grafico.estadoCad = "PLAYER 2 PASA";
                                pasoP2 = 1;
                            }
                            return;
                        }
                    }
                    break;
                case 'H':
                    if(H.disponibilidad == 1 && dondeEstoy == (rutasGanadoras.get(numRuta)).charAt(i)){
                        player.moverse('H'); //Me muevo
                        if(player.name == "Player1"){
                            rutaQueSeguiP1 += "-> H";
                            ventana.mover1A(780, 240);
                            pasoP1 = 0;
                        } else{
                            rutaQueSeguiP2 += "-> H";
                            ventana.mover2A(780, 240);
                            pasoP2 = 0;
                        }
                        yaMeMovi = true;
                        numRuta = 0;
                    } else{
                        //Tomamos la siguiente ruta
                        numRuta++;
                        System.out.println(player.name + " cambio a ruta" + numRuta + " en la posicion: " + (rutasGanadoras.get(numRuta)).charAt(i));
                        if(player.name == "Player1"){
                            Grafico.estadoCad = "PLAYER 1 PENSANDO";
                        } else{
                            Grafico.estadoCad = "PLAYER 2 PENSANDO";

                        }
                        if(numRuta >= (rutasGanadoras.size() - 1)){
                            System.out.println(player.name + "Paso, ya no tengo mas rutas");
                            //Para que ya no siga avanzando i cuando diga un player: "paso"
                            
                            if(player.name == "Player1"){
                                Grafico.estadoCad = "PLAYER 1 PASA";
                                pasoP1 = 1;
                            } else{
                                Grafico.estadoCad = "PLAYER 2 PASA";
                                pasoP2 = 1;
                            }
                            return;
                        }
                    }
                    break;
                case 'I':
                    if(I.disponibilidad == 1 && dondeEstoy == (rutasGanadoras.get(numRuta)).charAt(i)){
                        player.moverse('I'); //Me muevo
                        if(player.name == "Player1"){
                            rutaQueSeguiP1 += "-> I";
                            ventana.mover1A(325, 395);
                            pasoP1 = 0;
                        } else{
                            rutaQueSeguiP2 += "-> I";
                            ventana.mover2A(325, 395);
                            pasoP2 = 0;
                        }
                        yaMeMovi = true;
                        numRuta = 0;
                    } else{
                        //Tomamos la siguiente ruta
                        numRuta++;
                        System.out.println(player.name + " cambio a ruta" + numRuta + " en la posicion: " + (rutasGanadoras.get(numRuta)).charAt(i));
                        if(player.name == "Player1"){
                            Grafico.estadoCad = "PLAYER 1 PENSANDO";
                        } else{
                            Grafico.estadoCad = "PLAYER 2 PENSANDO";

                        }
                        if(numRuta >= (rutasGanadoras.size() - 1)){
                            System.out.println(player.name + "Paso, ya no tengo mas rutas");
                            //Para que ya no siga avanzando i cuando diga un player: "paso"
                            
                            if(player.name == "Player1"){
                                Grafico.estadoCad = "PLAYER 1 PASA";
                                pasoP1 = 1;
                            } else{
                                Grafico.estadoCad = "PLAYER 2 PASA";
                                pasoP2 = 1;
                            }
                            return;
                        }
                    }
                    break;
                case 'J':
                    if(J.disponibilidad == 1 && dondeEstoy == (rutasGanadoras.get(numRuta)).charAt(i)){
                        player.moverse('J'); //Me muevo
                        if(player.name == "Player1"){
                            rutaQueSeguiP1 += "-> J";
                            ventana.mover1A(480, 395);
                            pasoP1 = 0;
                        } else{
                            rutaQueSeguiP2 += "-> J";
                            ventana.mover2A(480, 395);
                            pasoP2 = 0;
                        }
                        yaMeMovi = true;
                        numRuta = 0;
                    } else{
                        //Tomamos la siguiente ruta
                        numRuta++;
                        System.out.println(player.name + " cambio a ruta" + numRuta + " en la posicion: " + (rutasGanadoras.get(numRuta)).charAt(i));
                        if(player.name == "Player1"){
                            Grafico.estadoCad = "PLAYER 1 PENSANDO";
                        } else{
                            Grafico.estadoCad = "PLAYER 2 PENSANDO";

                        }
                        if(numRuta >= (rutasGanadoras.size() - 1)){
                            System.out.println(player.name + "Paso, ya no tengo mas rutas");
                            //Para que ya no siga avanzando i cuando diga un player: "paso"
                            
                            if(player.name == "Player1"){
                                Grafico.estadoCad = "PLAYER 1 PASA";
                                pasoP1 = 1;
                            } else{
                                Grafico.estadoCad = "PLAYER 2 PASA";
                                pasoP2 = 1;
                            }
                            return;
                        }
                    }
                    break;
                case 'K':
                    if(K.disponibilidad == 1 && dondeEstoy == (rutasGanadoras.get(numRuta)).charAt(i)){
                        player.moverse('K'); //Me muevo
                        if(player.name == "Player1"){
                            rutaQueSeguiP1 += "-> K";
                            ventana.mover1A(625, 395);
                            pasoP1 = 0;
                        } else{
                            rutaQueSeguiP2 += "-> K";
                            ventana.mover2A(625, 395);
                            pasoP2 = 0;
                        }
                        yaMeMovi = true;
                        numRuta = 0;
                    } else{
                        //Tomamos la siguiente ruta
                        numRuta++;
                        System.out.println(player.name + " cambio a ruta" + numRuta + " en la posicion: " + (rutasGanadoras.get(numRuta)).charAt(i));
                        if(player.name == "Player1"){
                            Grafico.estadoCad = "PLAYER 1 PENSANDO";
                        } else{
                            Grafico.estadoCad = "PLAYER 2 PENSANDO";

                        }
                        if(numRuta >= (rutasGanadoras.size() - 1)){
                            System.out.println(player.name + "Paso, ya no tengo mas rutas");
                            //Para que ya no siga avanzando i cuando diga un player: "paso"
                            
                            if(player.name == "Player1"){
                                Grafico.estadoCad = "PLAYER 1 PASA";
                                pasoP1 = 1;
                            } else{
                                Grafico.estadoCad = "PLAYER 2 PASA";
                                pasoP2 = 1;
                            }
                            return;
                        }
                    }
                    break;
                case 'L':
                    if(L.disponibilidad == 1 && dondeEstoy == (rutasGanadoras.get(numRuta)).charAt(i)){
                        player.moverse('L'); //Me muevo
                        if(player.name == "Player1"){
                            rutaQueSeguiP1 += "-> L";
                            ventana.mover1A(780, 395);
                            pasoP1 = 0;
                        } else{
                            rutaQueSeguiP2 += "-> L";
                            ventana.mover1A(780, 395);
                            pasoP2 = 0;
                        }
                        yaMeMovi = true;
                        numRuta = 0;
                    } else{
                        //Tomamos la siguiente ruta
                        numRuta++;
                        System.out.println(player.name + " cambio a ruta" + numRuta + " en la posicion: " + (rutasGanadoras.get(numRuta)).charAt(i));
                        if(player.name == "Player1"){
                            Grafico.estadoCad = "PLAYER 1 PENSANDO";
                        } else{
                            Grafico.estadoCad = "PLAYER 2 PENSANDO";

                        }
                        if(numRuta >= (rutasGanadoras.size() - 1)){
                            System.out.println(player.name + "Paso, ya no tengo mas rutas");
                            //Para que ya no siga avanzando i cuando diga un player: "paso"
                            
                            if(player.name == "Player1"){
                                Grafico.estadoCad = "PLAYER 1 PASA";
                                pasoP1 = 1;
                            } else{
                                Grafico.estadoCad = "PLAYER 2 PASA";
                                pasoP2 = 1;
                            }
                            return;
                        }
                    }
                    break;
                case 'M':
                    if(M.disponibilidad == 1 && dondeEstoy == (rutasGanadoras.get(numRuta)).charAt(i)){
                        player.moverse('M'); //Me muevo
                        if(player.name == "Player1"){
                            rutaQueSeguiP1 += "-> M";
                            ventana.mover1A(325, 550);
                            pasoP1 = 0;
                        } else{
                            rutaQueSeguiP2 += "-> M";
                            ventana.mover2A(325, 550);
                            pasoP2 = 0;
                        }
                        yaMeMovi = true;
                        numRuta = 0;
                    } else{
                        //Tomamos la siguiente ruta
                        numRuta++;
                        System.out.println(player.name + " cambio a ruta" + numRuta + " en la posicion: " + (rutasGanadoras.get(numRuta)).charAt(i));
                        if(player.name == "Player1"){
                            Grafico.estadoCad = "PLAYER 1 PENSANDO";
                        } else{
                            Grafico.estadoCad = "PLAYER 2 PENSANDO";

                        }
                        if(numRuta >= (rutasGanadoras.size() - 1)){
                            System.out.println(player.name + "Paso, ya no tengo mas rutas");
                            //Para que ya no siga avanzando i cuando diga un player: "paso"
                            
                            if(player.name == "Player1"){
                                Grafico.estadoCad = "PLAYER 1 PASA";
                                pasoP1 = 1;
                            } else{
                                Grafico.estadoCad = "PLAYER 2 PASA";
                                pasoP2 = 1;
                            }
                            return;
                        }
                    }
                    break;
                case 'N':
                    if(N.disponibilidad == 1 && dondeEstoy == (rutasGanadoras.get(numRuta)).charAt(i)){
                        player.moverse('N'); //Me muevo
                        if(player.name == "Player1"){
                            rutaQueSeguiP1 += "-> N";
                            ventana.mover1A(480, 550);
                            pasoP1 = 0;
                        } else{
                            rutaQueSeguiP2 += "-> N";
                            ventana.mover2A(480, 550);
                            pasoP2 = 0;
                        }
                        yaMeMovi = true;
                        numRuta = 0;
                    } else{
                        //Tomamos la siguiente ruta
                        numRuta++;
                        System.out.println(player.name + " cambio a ruta" + numRuta + " en la posicion: " + (rutasGanadoras.get(numRuta)).charAt(i));
                        if(player.name == "Player1"){
                            Grafico.estadoCad = "PLAYER 1 PENSANDO";
                        } else{
                            Grafico.estadoCad = "PLAYER 2 PENSANDO";

                        }
                        if(numRuta >= (rutasGanadoras.size() - 1)){
                            System.out.println(player.name + "Paso, ya no tengo mas rutas");
                            //Para que ya no siga avanzando i cuando diga un player: "paso"
                            
                            if(player.name == "Player1"){
                                Grafico.estadoCad = "PLAYER 1 PASA";
                                pasoP1 = 1;
                            } else{
                                Grafico.estadoCad = "PLAYER 2 PASA";
                                pasoP2 = 1;
                            }
                            return;
                        }
                    }
                    break;
                case 'O':
                    if(O.disponibilidad == 1 && dondeEstoy == (rutasGanadoras.get(numRuta)).charAt(i)){
                        player.moverse('O'); //Me muevo
                        if(player.name == "Player1"){
                            rutaQueSeguiP1 += "-> O";
                            ventana.mover1A(625, 550);
                            pasoP1 = 0;
                        } else{
                            rutaQueSeguiP2 += "-> O";
                            ventana.mover2A(625, 550);
                            pasoP2 = 0;
                        }
                        yaMeMovi = true;
                        numRuta = 0;
                    } else{
                        //Tomamos la siguiente ruta
                        numRuta++;
                        System.out.println(player.name + " cambio a ruta" + numRuta + " en la posicion: " + (rutasGanadoras.get(numRuta)).charAt(i));
                        if(player.name == "Player1"){
                            Grafico.estadoCad = "PLAYER 1 PENSANDO";
                        } else{
                            Grafico.estadoCad = "PLAYER 2 PENSANDO";

                        }
                        if(numRuta >= (rutasGanadoras.size() - 1)){
                            System.out.println(player.name + "Paso, ya no tengo mas rutas");
                            //Para que ya no siga avanzando i cuando diga un player: "paso"
                            
                            if(player.name == "Player1"){
                                Grafico.estadoCad = "PLAYER 1 PASA";
                                pasoP1 = 1;
                            } else{
                                Grafico.estadoCad = "PLAYER 2 PASA";
                                pasoP2 = 1;
                            }
                            return;
                        }
                    }
                    break;
                case 'P':
                    if(P.disponibilidad == 1 && dondeEstoy == (rutasGanadoras.get(numRuta)).charAt(i)){
                        player.moverse('P'); //Me muevo
                        if(player.name == "Player1"){
                            rutaQueSeguiP1 += "-> P";
                            ventana.mover1A(780, 550);
                            pasoP1 = 0;
                        } else{
                            rutaQueSeguiP2 += "-> P";
                            ventana.mover2A(780, 550);
                            pasoP2 = 0;
                        }
                        yaMeMovi = true;
                        numRuta = 0;
                    } else{
                        //Tomamos la siguiente ruta
                        numRuta++;
                        System.out.println(player.name + " cambio a ruta" + numRuta + " en la posicion: " + (rutasGanadoras.get(numRuta)).charAt(i));
                        if(player.name == "Player1"){
                            Grafico.estadoCad = "PLAYER 1 PENSANDO";
                        } else{
                            Grafico.estadoCad = "PLAYER 2 PENSANDO";

                        }
                        if(numRuta >= (rutasGanadoras.size() - 1)){
                            System.out.println(player.name + "Paso, ya no tengo mas rutas");
                            //Para que ya no siga avanzando i cuando diga un player: "paso"
                            
                            if(player.name == "Player1"){
                                Grafico.estadoCad = "PLAYER 1 PASA";
                                pasoP1 = 1;
                            } else{
                                Grafico.estadoCad = "PLAYER 2 PASA";
                                pasoP2 = 1;
                            }
                            return;
                        }
                    }
                    break;
            }
        }
    }
    
    public static void establecerPatron1(String patron){
        Main.patron1 = patron;
        System.out.println("El patron es: " + patron1);
        todoListo++;
    }
    public static void establecerPatron2(String patron){
        Main.patron2 = patron;
        System.out.println("El patron es: " + patron2);
        todoListo++;
    }
    
    public static String establecerPatronAleatorio(int numP){
        StringBuilder patronAleatorio = new StringBuilder();
        
        Random random = new Random();
        // Caracteres posibles en el patrón
        char[] caracteres = {'w', 'b'};

        // Genera el patrón aleatorio
        for (int i = 2; i < 49; i++) {
            // Obtiene un carácter aleatorio de 'caracteres' y lo agrega al patrón
            char caracterAleatorio = caracteres[random.nextInt(caracteres.length)];
            patronAleatorio.append(caracterAleatorio);
        }
        
        if(numP == 1){
            Main.patron1 = patronAleatorio.toString();
            System.out.println("El patron 1 es: " + Main.patron1);
        } else{
            Main.patron2 = patronAleatorio.toString();
            System.out.println("El patron 2 es: " + Main.patron2);
        }

        todoListo++;
        
        if(numP == 1){
            return Main.patron1;
        }
        else{
            return Main.patron2;
        }
    }
    
    public static void establecerNumJugadores(int numPlayers){
        Main.numPlayers = numPlayers;
        System.out.println("Numero de Jugadores: " + numPlayers);
        todoListo++;
    }
    
    public static int establecerNumJugadoresAleatorio(){
        Random random = new Random();
        Main.numPlayers = random.nextInt(2) + 1;
        todoListo++;
        
        return Main.numPlayers;
    }
}
