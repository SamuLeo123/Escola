
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
        j.pack();
    }
    public Exercicio1(){
        this.setTitle("Código de Desconto");
        //this.setBounds(300, 50, 350, 90);
        this.setBounds(300, 50, 350, 90);
        this.getContentPane().setBackground(new Color(150, 150, 150));
        this.getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        l1 = new JLabel("Valor da compra");
        l1.setForeground(Color.black);
        //l1.setFont(new Font(" ", Font.BOLD, 14));
        l2 = new JLabel("Código de Desconto");
        l2.setForeground(Color.black);
        l2.setFont(new Font(" ", Font.BOLD, 14));
        l3 = new JLabel("Preço Final");
        l3.setForeground(Color.black);
        l3.setFont(new Font(" ", Font.BOLD, 14));
        b1 = new JButton("Calcular");
        b1.addActionListener(Exercicio1.this);
        t1 = new JTextField();
        t2 = new JTextField();
        t3 = new JTextField();
        t3.setEditable(false);
        getContentPane().add(l1);
        getContentPane().add(t1);
        getContentPane().add(l2);
        getContentPane().add(t2);
        //this.add(Box.createHorizontalBox());
        getContentPane().add(b1);
        getContentPane().add(l3);
        getContentPane().add(t3);
    }
    
     @Override
    public void actionPerformed(ActionEvent e) {
        try{
            double n1, fin;
            int n2;
            n1 = Double.parseDouble(t1.getText());
            n2 = Integer.parseInt(t2.getText());
            switch(n2){
                case 1: fin = n1 * 0.95;break;
                case 2: fin = n1 * 0.90;break;
                case 3: fin = n1 * 0.80;break;
                case 4: fin = n1 * 0.50;break;
                default: fin = n1; break;
            }
            t3.setText(String.valueOf(fin));
        }
        catch(Exception er){
            t3.setText("Error");
        }
        
    }
}
