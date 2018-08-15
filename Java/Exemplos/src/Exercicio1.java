
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Exercicio1 extends JFrame implements ActionListener{
    JLabel l1,l2, l3;
    JButton b1;
    JTextField t1,t2,t3;
    static JFrame j;
    public static void main(String [] args){
        j = new Exercicio1();
        j.setUndecorated(true);
        j.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setVisible(true);
    }
    public Exercicio1(){
        
    }
}
