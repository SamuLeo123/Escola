
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JRootPane;

public class Exemplo1 extends JFrame {
    Exemplo1(){
        setTitle("janela exemplo.");
        setBounds(50, 50, 30, 120);
        setResizable(true);
        getContentPane().setBackground(new Color(220, 220, 220));
    }
    
    public static void main(String [] args){
        JFrame janela = new Exemplo1();
        janela.setUndecorated(true);
        janela.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setVisible(true);
    }
}
