import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Exercicio5 extends JFrame implements ActionListener{
    JLabel l1, l2,l3;
    JButton b1;
    JTextField t1,t2;
    static JFrame j;
    GridBagConstraints c = new GridBagConstraints();
    public static void main (String[]args){
        j = new Exercicio5();
        j.setUndecorated(true);
        j.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setVisible(true);
    }
    
    Exercicio5(){
        this.setTitle("Ciclonometro");
        this.setBounds(300, 50, 350, 90);
        this.getContentPane().setBackground(new Color(255, 255, 255));
        this.getContentPane().setLayout(new GridBagLayout());
        l1 = new JLabel("Digite quantas voltas a roda deu:");
        l1.setForeground(Color.black);
        l1.setFont(new Font(" ", Font.BOLD, 14));
        l2 = new JLabel("Digite o diâmetro de sua roda em metros:");
        l2.setForeground(Color.black);
        l2.setFont(new Font(" ", Font.BOLD, 14));
        l3 = new JLabel("");
        l3.setForeground(Color.black);
        l3.setFont(new Font(" ", Font.BOLD, 14));
        b1 = new JButton("Calcular");
        b1.addActionListener(Exercicio5.this);
        t1 = new JTextField();
        t2 = new JTextField();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;c.gridx=0;c.gridy = 0;
        getContentPane().add(l1,c);
        c.weightx = 0.5;c.gridx=1;c.gridy = 0;c.gridwidth = 2;
        getContentPane().add(t1,c);
        c.weightx = 0.5;c.gridx=0;c.gridy = 1;
        getContentPane().add(l2,c);
        c.weightx = 0.5;c.gridx=1;c.gridy = 1;c.gridwidth = 2;
        getContentPane().add(t2,c);
        c.weightx = 0.5;c.gridx=0;c.gridy = 2;c.gridwidth = 3;
        getContentPane().add(b1,c);        
        c.weightx = 0.5;c.gridx=0;c.gridy = 3;c.gridwidth = 3;
        getContentPane().add(l3,c);
    }
    
    public void actionPerformed(ActionEvent e) {
        try{
            double d,v,t,c;
            d = Double.parseDouble(t2.getText());
            v = Double.parseDouble(t1.getText());
            c = Math.PI * d;
            t = c * v;
            l3.setText("Você andou "+t+ " metros");
        }
        catch(Exception er){
        }
    }
}
