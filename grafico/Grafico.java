package grafico;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.Timer;
import main.Main;

public class Grafico extends JFrame implements ActionListener {

    private JTextArea jtextArea;
    private JTextArea jtextArea2;
    private JTextArea playersArea;
    static private JTextArea estadoArea;
    private Button button1;
    private Button button2;
    private Button randomButton;
    private Button playersButton;
    private Button autoButton;
    private Button deleteButton;
    
    private String patron;

    private JLabel gifLabel;
    private ImageIcon gifImage;
    
    public static String estadoCad = "READY?";
    
    private int numPlayers;
    
    //Para mover imagen
    private int objetivoX1 = 0;  // Coordenada X a la que deseas mover la imagen
    private int objetivoY1 = 0;  // Coordenada Y a la que deseas mover la imagen
    
    private int objetivoX2 = 0;  // Coordenada X a la que deseas mover la imagen
    private int objetivoY2 = 0;  // Coordenada Y a la que deseas mover la imagen
    
    private int p1X = 325;
    private int p1Y = 85;
    
    private int p2X = 780;
    private int p2Y = 85;
    
    private static final int PASO = 5;  // Cantidad de píxeles que la imagen se mueve en cada paso
    private Timer timer;  // Temporizador para manejar la animación
    private Timer timer2;
    private Timer timer3;
    
    private ImageIcon p1;
    private ImageIcon p2;

    public Grafico() { //Constructor de mi ventana

        // Configura la ventana
        setTitle("ChessBoard Racers");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 1000);
        setLocationRelativeTo(null); // Centra la ventana en la pantalla
        
        
        //IMAGENES
        URL path1 = Grafico.class.getClassLoader().getResource("./grafico/p1.png");
        URL path2 = Grafico.class.getClassLoader().getResource("./grafico/p2.png");
            p1 = new ImageIcon(path1);
            p2 = new ImageIcon(path2);

        // Crea un panel personalizado para dibujar todo
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Métodos para dibujar todo
                dibujarTablero(g);
                g.drawImage(p1.getImage(), p1X, p1Y, this);
                g.drawImage(p2.getImage(), p2X, p2Y, this);
            }
        };

        // Establece el diseño del panel como nulo para que puedas posicionar los componentes manualmente
        panel.setLayout(null);

        //----> ESTRUCTURA GRAFICA

        // Crea un TextField
        jtextArea = new JTextArea(10, 15);
        jtextArea.setLineWrap(true); // Permite saltos de línea automáticos
        jtextArea.setWrapStyleWord(true); // Ajusta las palabras al ancho del área de texto
        jtextArea.setBounds(20, 300-150, 200, 50); // Posición y tamaño del JTextArea
        panel.add(jtextArea); // Agrega el TextField al panel
        
        jtextArea2 = new JTextArea(10, 15);
        jtextArea2.setLineWrap(true); // Permite saltos de línea automáticos
        jtextArea2.setWrapStyleWord(true); // Ajusta las palabras al ancho del área de texto
        jtextArea2.setBounds(20, 240, 200, 50); // Posición y tamaño del JTextArea
        panel.add(jtextArea2); // Agrega el TextField al panel
        
        //GIF
        // Cargar el GIF usando ImageIcon
        URL pathGif = Grafico.class.getClassLoader().getResource("./grafico/hacking.gif");
        gifImage = new ImageIcon(pathGif);
        gifLabel = new JLabel(gifImage);
        gifLabel.setBounds(30, 500, 200, 200);
        panel.add(gifLabel);

        reproducirAnimacionGIF();
        
        //ESTADO
        // Establece la fuente en negrita y el color de texto en rojo para estadoArea
        estadoArea = new JTextArea(10, 200);
        estadoArea.setLineWrap(true); // Permite saltos de línea automáticos
        estadoArea.setWrapStyleWord(true); // Ajusta las palabras al ancho del área de texto
        estadoArea.setBounds(300, 15, 600, 40); // Posición y tamaño del JTextArea
        Font fuenteNegritaRoja = new Font("Arial", Font.BOLD, 14);
        estadoArea.setFont(fuenteNegritaRoja);
        estadoArea.setForeground(Color.RED);
        panel.add(estadoArea); // Agrega el TextField al panel
        
        // Crea un TextField
        playersArea = new JTextArea(1, 15);
        playersArea.setLineWrap(true); // Permite saltos de línea automáticos
        playersArea.setWrapStyleWord(true); // Ajusta las palabras al ancho del área de texto
        playersArea.setBounds(20, 480-150, 200, 20); // Posición y tamaño del JTextArea
        panel.add(playersArea); // Agrega el TextField al panel

        // Crea un botón para ingresar patrón
        button1 = new Button("Asignar Patrón Player 1");
        button1.addActionListener(this); // Registra la clase actual como el listener del botón
        button1.setBounds(55, 200, 140, 30); // Posición y tamaño del botón
        panel.add(button1); // Agrega el botón al panel
        
        // Crea un botón para ingresar patrón
        button2 = new Button("Asignar Patrón Player 2");
        button2.addActionListener(this); // Registra la clase actual como el listener del botón
        button2.setBounds(55, 295, 140, 30); // Posición y tamaño del botón
        panel.add(button2); // Agrega el botón al panel

        // Crea un botón para generar patrón aleatorio
        randomButton = new Button("Generar Patrón Aleatorio");
        randomButton.addActionListener(this); // Registra la clase actual como el listener del botón
        randomButton.setBounds(35, 400-150, 160, 30); // Posición y tamaño del botón
        panel.add(randomButton); // Agrega el botón al panel
        
        // Crea un botón para ingresar numPlayers
        playersButton = new Button("Asignar Jugadores");
        playersButton.addActionListener(this); // Registra la clase actual como el listener del botón
        playersButton.setBounds(45, 510-150, 150, 30); // Posición y tamaño del botón
        panel.add(playersButton); // Agrega el botón al panel
        
        // Crea un botón para modo automatico
        autoButton = new Button("Modo Automatico");
        autoButton.addActionListener(this); // Registra la clase actual como el listener del botón
        autoButton.setBounds(65, 650-200, 100, 30); // Posición y tamaño del botón
        panel.add(autoButton); // Agrega el botón al panel
        
        // Crea un botón para modo automatico
        deleteButton = new Button("Borrar Archivos");
        deleteButton.addActionListener(this); // Registra la clase actual como el listener del botón
        deleteButton.setBounds(65, 400, 100, 30); // Posición y tamaño del botón
        panel.add(deleteButton); // Agrega el botón al panel

        //----> FIN DE ESTRUCTURA GRAFICA

        // Agrega el panel a la ventana
        getContentPane().add(panel);

        // Etiquetas
        // Etiqueta del título
        JLabel titleLabel = new JLabel("AFND");
        JLabel titleLabel2 = new JLabel("Carreras de Ajedrez");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24)); // Personaliza la fuente
        titleLabel2.setFont(new Font("Arial", Font.BOLD, 24)); // Personaliza la fuente
        titleLabel.setBounds(85, 150-150, 300, 30); // Posición y tamaño de la etiqueta
        titleLabel2.setBounds(20, 170-150, 300, 30);
        panel.add(titleLabel);
        panel.add(titleLabel2);

        // Etiqueta del subtítulo
        JLabel subtitleLabel = new JLabel("Daniel Vega Miranda");
        subtitleLabel.setFont(new Font("Arial", Font.PLAIN, 18)); // Personaliza la fuente
        subtitleLabel.setBounds(20, 195-150, 300, 30); // Posición y tamaño de la etiqueta
        panel.add(subtitleLabel);
        
        //Instruccion patron
        JLabel instruccionPatron = new JLabel("Ingrese un patron");
        JLabel instruccionPatron2 = new JLabel("Blanco (w) y Negro (b)");
        instruccionPatron.setFont(new Font("Arial", Font.PLAIN, 14)); // Personaliza la fuente
        instruccionPatron2.setFont(new Font("Arial", Font.PLAIN, 14)); // Personaliza la fuente
        instruccionPatron.setBounds(60, 240-150, 300, 30); // Posición y tamaño de la etiqueta
        instruccionPatron2.setBounds(40, 260-150, 300, 30); // Posición y tamaño de la etiqueta
        panel.add(instruccionPatron);
        panel.add(instruccionPatron2);
        
        //Hilo con timer para mover imagenes
        //Timer para mover imagenes
        // Inicializa el temporizador con una velocidad de 10 milisegundos entre cada paso
        timer = new Timer(10, new ActionListener() {
        @Override
            public void actionPerformed(ActionEvent e) {
                mover1();
            }
        });
        
        timer2 = new Timer(10, new ActionListener() {
        @Override
            public void actionPerformed(ActionEvent e) {
                mover2();
            }
        });
        
        timer3 = new Timer(5, new ActionListener() {
        @Override
            public void actionPerformed(ActionEvent e) {
                mostrarEstado();
            }
        });
    }
    
    private void dibujarTablero(Graphics g) {
        int tamañoCelda = 150; // Tamaño de cada celda del tablero
        int filas = 4;
        int columnas = 4;

        // Dibuja el tablero de ajedrez de 4x4
        for (int fila = 0; fila < filas; fila++) {
            for (int columna = 0; columna < columnas; columna++) {
                // Alterna el color de fondo para crear el patrón del tablero
                if ((fila + columna) % 2 == 0) {
                    g.setColor(Color.WHITE);
                } else {
                    g.setColor(Color.BLACK);
                }

                // Dibuja una celda del tablero
                 g.fillRect(300 + columna * tamañoCelda, 70 + fila * tamañoCelda, tamañoCelda, tamañoCelda);
            }
        }
    }
    
    private void mover1() {
        // Calcula la diferencia entre las coordenadas actuales y las coordenadas objetivo
        int dx = objetivoX1 - p1X;
        int dy = objetivoY1 - p1Y;

        // Calcula la distancia euclidiana entre las coordenadas actuales y las coordenadas objetivo
        double distancia = Math.sqrt(dx * dx + dy * dy);

        // Si la distancia es mayor que el paso, mueve la imagen un paso hacia las coordenadas objetivo
        if (distancia > PASO) {
            double angulo = Math.atan2(dy, dx);
            p1X += (int) (PASO * Math.cos(angulo));
            p1Y += (int) (PASO * Math.sin(angulo));
            repaint();  // Vuelve a pintar el panel para actualizar la posición de la imagen
        } else {
            // Si la distancia es menor o igual al paso, mueve la imagen directamente a las coordenadas objetivo
            p1X = objetivoX1;
            p1Y = objetivoY1;
            timer.stop();  // Detiene el temporizador ya que la animación ha terminado
            repaint();  // Vuelve a pintar el panel para actualizar la posición de la imagen por última vez
        }
    }
    
    private void mover2() {
        // Calcula la diferencia entre las coordenadas actuales y las coordenadas objetivo
        int dx = objetivoX2 - p2X;
        int dy = objetivoY2 - p2Y;

        // Calcula la distancia euclidiana entre las coordenadas actuales y las coordenadas objetivo
        double distancia = Math.sqrt(dx * dx + dy * dy);

        // Si la distancia es mayor que el paso, mueve la imagen un paso hacia las coordenadas objetivo
        if (distancia > PASO) {
            double angulo = Math.atan2(dy, dx);
            p2X += (int) (PASO * Math.cos(angulo));
            p2Y += (int) (PASO * Math.sin(angulo));
            repaint();  // Vuelve a pintar el panel para actualizar la posición de la imagen
        } else {
            // Si la distancia es menor o igual al paso, mueve la imagen directamente a las coordenadas objetivo
            p2X = objetivoX2;
            p2Y = objetivoY2;
            timer2.stop();  // Detiene el temporizador ya que la animación ha terminado
            repaint();  // Vuelve a pintar el panel para actualizar la posición de la imagen por última vez
        }
    }
    
    public void mover1A(int x, int y) {
        objetivoX1 = x;
        objetivoY1 = y;
        timer.start();  // Inicia la animación
    }
    
    public void mover2A(int x, int y) {
        objetivoX2 = x;
        objetivoY2 = y;
        timer2.start();  // Inicia la animación
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Se llama cuando se hace clic en el botón
        if (e.getSource() == button1) {
            // Obtiene el texto del TextField y lo asigna a la variable patron
            patron = jtextArea.getText();
            // Llama a un método en la clase principal para manejar el patrón
            Main.establecerPatron1(patron);
            timer3.start();
        } else if(e.getSource() == button2){
            // Obtiene el texto del TextField y lo asigna a la variable patron
            patron = jtextArea2.getText();
            // Llama a un método en la clase principal para manejar el patrón
            Main.establecerPatron2(patron);
            timer3.start();
        } else if (e.getSource() == randomButton) {
            patron = Main.establecerPatronAleatorio(1);
            jtextArea.setText("Patron: " + patron);
            patron = Main.establecerPatronAleatorio(2);
            jtextArea2.setText("Patron: " + patron);
            timer3.start();
        } else if(e.getSource() == playersButton){
            // Obtiene el texto del TextField y lo asigna a la variable patron
            numPlayers = Integer.parseInt(playersArea.getText());
            // Llama a un método en la clase principal para manejar el patrón
            Main.establecerNumJugadores(numPlayers);
        } else if (e.getSource() == autoButton){
            patron = Main.establecerPatronAleatorio(1);
            jtextArea.setText("Patron: " + patron);
            patron = Main.establecerPatronAleatorio(2);
            jtextArea2.setText("Patron: " + patron);
            
            numPlayers = Main.establecerNumJugadoresAleatorio();
            playersArea.setText("Numero de Jugadores: " + numPlayers);
        } else if (e.getSource() == deleteButton){
                File archivo1 = new File("rutas1.txt");
                File archivo2 = new File("rutas2.txt");
                File archivo3 = new File("rutasGanadoras1.txt");
                File archivo4 = new File("rutasGanadoras2.txt");

                //Si los quiero ver no los borro
                archivo1.delete();
                archivo2.delete();
                archivo3.delete();
                archivo4.delete();
        }
    }
    
    public void mostrarEstado(){
        estadoArea.setText(estadoCad);
    }

    private void reproducirAnimacionGIF() {
        ImageIcon icon = (ImageIcon) gifLabel.getIcon();
        gifLabel.setIcon(null); // Limpia el icono actual para evitar problemas de visualización
        gifLabel.setIcon(icon); // Establece el icono nuevamente para reiniciar la animación
    }
}
