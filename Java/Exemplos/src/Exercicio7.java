import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Exercicio7 extends JFrame implements ActionListener{
    JLabel l1,l2,l3,l4,l5;
    JButton b1;
    JTextField t1,t2,t3;
    static JFrame j;
    double at;
    public static void main(String [] args){
        j = new Exercicio7();
        j.setUndecorated(true);
        j.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setVisible(true);
        j.pack();
    }
    
    public Exercicio7(){
        this.setTitle("Área da Residencia");
        this.setBounds(300, 300, 300, 300);
        this.getContentPane().setBackground(new Color(255, 255, 255));
        this.getContentPane().setLayout(new GridLayout(6, 2, 30, 50));
        l1 = new JLabel("Nome do cômodo");
        l1.setForeground(Color.black);
        l1.setFont(new Font(" ", Font.BOLD, 14));
        l2 = new JLabel("A Largura do cômodo");
        l2.setForeground(Color.black);
        l2.setFont(new Font(" ", Font.BOLD, 14));
        l3 = new JLabel("O Comprimento do cômodo");
        l3.setForeground(Color.black);
        l3.setFont(new Font(" ", Font.BOLD, 14));
        l4 = new JLabel("");
        l4.setForeground(Color.black);
        l4.setFont(new Font(" ", Font.BOLD, 14));
        l5 = new JLabel("");
        l5.setForeground(Color.black);
        l5.setFont(new Font(" ", Font.BOLD, 14));
        b1 = new JButton("Calcular");
        b1.addActionListener(Exercicio7.this);
        t1 = new JTextField();
        t2 = new JTextField();
        t3 = new JTextField();
        getContentPane().add(l1);
        getContentPane().add(t1);
        getContentPane().add(l2);
        getContentPane().add(t2);
        getContentPane().add(l3);
        getContentPane().add(t3);
        getContentPane().add(l4);
        getContentPane().add(l5);
        getContentPane().add(b1);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            double l,c,a;
            c = Double.parseDouble(t2.getText());
            l = Double.parseDouble(t3.getText());
            a = c*l;
            at = at+ a;
            l4.setText("Área do cômodo: " + a);
            l5.setText("Área Total: " + at);
        }
        catch(Exception er){
        l4.setText("e" + er);}
    }
}
