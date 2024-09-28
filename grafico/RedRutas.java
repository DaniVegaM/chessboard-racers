package grafico;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class RedRutas extends JFrame {

    private JTextArea jtextArea;

    public RedRutas(int player) {
        // Configura la ventana
        if (player == 1) {
            setTitle("Red de Rutas de Player 1");
        } else {
            setTitle("Red de Rutas de Player 2");
        }
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600); // Tamaño inicial de la ventana
        setLocationRelativeTo(null); // Centra la ventana en la pantalla

        JPanel panel = new JPanel();
        panel.setLayout(null);

        // Crea un JTextArea
        jtextArea = new JTextArea();
        jtextArea.setLineWrap(true);
        jtextArea.setWrapStyleWord(true);

        // Crea un JScrollPane y agrega el JTextArea a él
        JScrollPane scrollPane = new JScrollPane(jtextArea);
        // Establece un tamaño preferido para el JScrollPane
        scrollPane.setPreferredSize(new Dimension(780, 560));
        // Establece el tamaño y la posición del JScrollPane en el panel
        scrollPane.setBounds(10, 10, 780, 560);

        panel.add(scrollPane); // Agrega el JScrollPane al panel

        getContentPane().add(panel);
    }

    // Métodos para dibujar rutas

    public void dibujarRuta(String cadena) {
        jtextArea.append(cadena + "\n"); // Utiliza append para agregar texto al JTextArea
    }

    public static void main(String[] args) {
        RedRutas ventana = new RedRutas(1);
        ventana.setVisible(true);
    }
}
