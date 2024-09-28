package utilidades;

public class Utilidades {
    public static void pausar2min(){
        //PAUSO PARA PRUEBAS
        try {
            // Pausa el programa durante 5000 milisegundos (5 segundos)
            Thread.sleep(120000);
        } catch (InterruptedException e) {
            // Maneja la excepción si se interrumpe la pausa
            e.printStackTrace();
        }
    }
    
    public static void pausar2seg(){
        //PAUSO PARA PRUEBAS
        try {
            // Pausa el programa durante 5000 milisegundos (5 segundos)
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // Maneja la excepción si se interrumpe la pausa
            e.printStackTrace();
        }
    }
}
