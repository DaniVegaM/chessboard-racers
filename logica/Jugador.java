package logica;

import static main.Main.A;
import static main.Main.B;
import static main.Main.C;
import static main.Main.D;
import static main.Main.E;
import static main.Main.F;
import static main.Main.G;
import static main.Main.H;
import static main.Main.I;
import static main.Main.J;
import static main.Main.K;
import static main.Main.L;
import static main.Main.M;
import static main.Main.N;
import static main.Main.O;
import static main.Main.P;

public class Jugador {
    public String name;
    char posicionActual;
    char posicionAnterior;
    
    public Jugador(String name, char posicionActual){ //Constructor
        this.name = name;
        this.posicionActual = posicionActual;
    }
    
    public void moverse(char posicionActual){
        this.posicionActual = posicionActual;
        
        switch(posicionAnterior){ //La posicion anterior queda disponible porque ya me moví
            case 'A':
                A.disponibilidad = 1;
                posicionAnterior = posicionActual;
                break;
            case 'B':
                B.disponibilidad = 1;
                posicionAnterior = posicionActual;
                break;
            case 'C':
                C.disponibilidad = 1;
                posicionAnterior = posicionActual;
                break;
            case 'D':
                D.disponibilidad = 1;
                posicionAnterior = posicionActual;
                break;
            case 'E':
                E.disponibilidad = 1;
                posicionAnterior = posicionActual;
                break;
            case 'F':
                F.disponibilidad = 1;
                posicionAnterior = posicionActual;
                break;
            case 'G':
                G.disponibilidad = 1;
                posicionAnterior = posicionActual;
                break;
            case 'H':
                H.disponibilidad = 1;
                posicionAnterior = posicionActual;
                break;
            case 'I':
                I.disponibilidad = 1;
                posicionAnterior = posicionActual;
                break;
            case 'J':
                J.disponibilidad = 1;
                posicionAnterior = posicionActual;
                break;
            case 'K':
                K.disponibilidad = 1;
                posicionAnterior = posicionActual;
                break;
            case 'L':
                L.disponibilidad = 1;
                posicionAnterior = posicionActual;
                break;
            case 'M':
                M.disponibilidad = 1;
                posicionAnterior = posicionActual;
                break;
            case 'N':
                N.disponibilidad = 1;
                posicionAnterior = posicionActual;
                break;
            case 'O':
                O.disponibilidad = 1;
                posicionAnterior = posicionActual;
                break;
            case 'P':
                P.disponibilidad = 1;
                posicionAnterior = posicionActual;
                break;
            default:
                break;
        }
        
        switch(posicionActual){ //La posicion actual esta ocupada
            case 'A':
                A.disponibilidad = 0;
                break;
            case 'B':
                B.disponibilidad = 0;
                break;
            case 'C':
                C.disponibilidad = 0;
                break;
            case 'D':
                D.disponibilidad = 0;
                break;
            case 'E':
                E.disponibilidad = 0;
                break;
            case 'F':
                F.disponibilidad = 0;
                break;
            case 'G':
                G.disponibilidad = 0;
                break;
            case 'H':
                H.disponibilidad = 0;
                break;
            case 'I':
                I.disponibilidad = 0;
                break;
            case 'J':
                J.disponibilidad = 0;
                break;
            case 'K':
                K.disponibilidad = 0;
                break;
            case 'L':
                L.disponibilidad = 0;
                break;
            case 'M':
                M.disponibilidad = 0;
                break;
            case 'N':
                N.disponibilidad = 0;
                break;
            case 'O':
                O.disponibilidad = 0;
                break;
            case 'P':
                P.disponibilidad = 0;
                break;
            default:
                break;
        }
    }
    
    public char getPosicionActual(){
        return posicionActual;
    }

    public void setPosicionAnterior(char posicionAnterior) {
        this.posicionAnterior = posicionAnterior;
    }
    
    public void anteriorYaEstaDisponible(){ //NO TIENE CASO
        switch(posicionAnterior){
            case 'A':
                A.disponibilidad = 1;
                break;
            case 'B':
                B.disponibilidad = 1;
                break;
            case 'C':
                C.disponibilidad = 1;
                break;
            case 'D':
                D.disponibilidad = 1;
                break;
            case 'E':
                E.disponibilidad = 1;
                break;
            case 'F':
                F.disponibilidad = 1;
                break;
            case 'G':
                G.disponibilidad = 1;
                break;
            case 'H':
                H.disponibilidad = 1;
                break;
            case 'I':
                I.disponibilidad = 1;
                break;
            case 'J':
                J.disponibilidad = 1;
                break;
            case 'K':
                K.disponibilidad = 1;
                break;
            case 'L':
                L.disponibilidad = 1;
                break;
            case 'M':
                M.disponibilidad = 1;
                break;
            case 'N':
                N.disponibilidad = 1;
                break;
            case 'O':
                O.disponibilidad = 1;
                break;
            case 'P':
                P.disponibilidad = 1;
                break;
            default:
                break;
        }
    }
}
