
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.text.NumberFormat;


public class ExemploFormatacao extends JFrame implements ActionListener{
    JTextField t1,t2;
    double v1=1000.54;
    int v2 = 200;
    NumberFormat df1, df2;
    public static void main(String [] args){
        JFrame Janela = new ExemploFormatacao();
        Janela.setUndecorated(true);
        Janela.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
        Janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Janela.setVisible(true);
    }
    
    ExemploFormatacao(){
        setTitle("Formatação");
        setBounds(230, 50, 350, 65);
        getContentPane().setBackground(Color.white);
        getContentPane().setLayout(new GridLayout(1, 2));
        df1 = NumberFormat.getNumberInstance();
        df1.setMinimumFractionDigits(4);
        df2 = NumberFormat.getNumberInstance();
        df2.setMinimumFractionDigits(2);
        t1 = new JTextField();
        t2 = new JTextField();
        t1.setText("" + df1.format(v1));
        t2.setText("" + df2.format(v2));
        t1.setEditable(false);
        t2.setEditable(false);
        getContentPane().add(t1);
        getContentPane().add(t2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
