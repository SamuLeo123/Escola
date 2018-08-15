import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Exemplo2 extends JFrame implements ActionListener{
    JLabel l1, l2, l3;
    JButton b1, b2, b3, b4, b5;
    JTextField t1, t2, t3;
    static JFrame j;
    public static void main(String [] args){
        j = new Exemplo2();
        j.setUndecorated(true);
        j.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setVisible(true);
    }
    
    Exemplo2(){
        this.setTitle("Calculadora");
        this.setBounds(300, 50, 350, 90);
        this.getContentPane().setBackground(new Color(150, 150, 150));
        this.getContentPane().setLayout(new GridLayout(3, 4));
        l1 = new JLabel("Número 1");
        l1.setForeground(Color.black);
        //l1.setFont(new Font(" ", Font.BOLD, 14));
        l2 = new JLabel("Número 2");
        l2.setForeground(Color.black);
        l2.setFont(new Font(" ", Font.BOLD, 14));
        l3 = new JLabel("Número 3");
        l3.setForeground(Color.black);
        l3.setFont(new Font(" ", Font.BOLD, 14));
        b1 = new JButton("+");
        b1.addActionListener(Exemplo2.this);
        b2 = new JButton("-");
        b2.addActionListener(Exemplo2.this);
        b3 = new JButton("*");
        b3.addActionListener(Exemplo2.this);
        b4 = new JButton("/");
        b4.addActionListener(Exemplo2.this);
        b5 = new JButton("Limpa");
        b5.addActionListener(Exemplo2.this);
        b5.setBackground(Color.black);
        b5.setForeground(Color.white);
        t1 = new JTextField();
        t2 = new JTextField();
        t3 = new JTextField();
        t3.setEditable(false);
        getContentPane().add(l1);
        getContentPane().add(t1);
        getContentPane().add(b1);
        getContentPane().add(b2);
        getContentPane().add(l2);
        getContentPane().add(t2);
        getContentPane().add(b3);
        getContentPane().add(b4);
        getContentPane().add(l3);
        getContentPane().add(t3);
        getContentPane().add(b5);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b5) {
            t1.setText("");
            t2.setText("");
            t3.setText("");
            return;
        }
        double n1 =0, n2 = 0, result = 0;
        try{
            n1 = Double.parseDouble(t1.getText());
            n2 = Double.parseDouble(t2.getText());
        }
        catch(NumberFormatException erro){
            t3.setText("Erro");
            return;
        }
        if (e.getSource() == b1) {
            result = n1 + n2;
        }
        if (e.getSource() == b2) {
            result = n1 - n2;
        }
        if (e.getSource() == b3) {
            result = n1 * n2;
        }
        if (e.getSource() == b4) {
            result = n1 / n2;
        }
        t3.setText(" " + result);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
