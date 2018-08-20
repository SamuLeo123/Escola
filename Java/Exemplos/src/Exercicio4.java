import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Exercicio4 extends JFrame implements ActionListener{
    JLabel l1, l2, l3;
    JButton b1;
    JTextField t1, t2;
    static JFrame j;
    int i = 0;
    public static void main(String [] args){
        j = new Exercicio4();
        j.setUndecorated(true);
        j.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setVisible(true);
    }
    
    Exercicio4(){
        this.setTitle("Banco");
        this.setBounds(300, 50, 350, 90);
        this.getContentPane().setBackground(new Color(150, 150, 150));
        this.getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        l1 = new JLabel("Digite sua conta");
        l1.setForeground(Color.black);
        l1.setFont(new Font(" ", Font.BOLD, 14));
        l2 = new JLabel("Digite sua Senha");
        l2.setForeground(Color.black);
        l2.setFont(new Font(" ", Font.BOLD, 14));
        l3 = new JLabel("");
        l3.setForeground(Color.black);
        l3.setFont(new Font(" ", Font.BOLD, 14));
        b1 = new JButton("Entrar");
        b1.addActionListener(Exercicio4.this);
        t1 = new JTextField();
        t2 = new JTextField();
        getContentPane().add(l1);
        getContentPane().add(t1);
        getContentPane().add(l2);
        getContentPane().add(t2);
        getContentPane().add(b1);
        getContentPane().add(l3);
        
    }

    public void actionPerformed(ActionEvent e) {
        try{
            String s = null;
            s = t2.getText().toUpperCase();
            if(s.equals("JAVA")){
                l3.setText("Voce ACERTOU!");
            }
            else{
               i++;  
               if(i==3){
                   System.exit(0);
               }
               l3.setText("Você errou, e tem mais " + (3-i) + " tentativas, Vacilao" );
               
            }
        }        
        catch(Exception er){
        }
    }
}