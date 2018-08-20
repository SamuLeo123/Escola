import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Exercicio3 extends JFrame implements ActionListener{
    JLabel l1, l2;
    JButton b1;
    JTextField t1;
    static JFrame j;
    public static void main(String [] args){
        j = new Exercicio3();
        j.setUndecorated(true);
        j.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setVisible(true);
    }
    
    Exercicio3(){
        this.setTitle("Calculadora");
        this.setBounds(300, 50, 350, 90);
        this.getContentPane().setBackground(new Color(150, 150, 150));
        this.getContentPane().setLayout(new GridLayout(3, 4));
        l1 = new JLabel("Digite sua idade");
        l1.setForeground(Color.black);
        l1.setFont(new Font(" ", Font.BOLD, 14));
        l2 = new JLabel("Você é");
        l2.setForeground(Color.black);
        l2.setFont(new Font(" ", Font.BOLD, 14));
        b1 = new JButton("Calcular");
        b1.addActionListener(Exercicio3.this);
        t1 = new JTextField();
        getContentPane().add(l1);
        getContentPane().add(t1);
        getContentPane().add(b1);
        getContentPane().add(l2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            String s = null;
            int i = Integer.parseInt(t1.getText());
            if(i > 0 && i <= 2){
                s = "Bebê"; 
            }
            else if(i >= 3 && i<= 11){
                s = "Criança";
            }
            else if(i >= 0 && i <= 2){ 
                s = "Bebê"; 
            }
            else if(i >= 12 && i <= 19){ 
                s = "Adolescente"; 
            }
            else if(i >= 20 && i <= 30){ 
                s = "Jovem"; 
            }
            else if(i >= 31 && i <= 60){ 
                s = "Adulto"; 
            }            
            else if(i >= 61){ 
                s = "Idoso"; 
            }
            l2.setText("Você é um " + s);
            
        }        
        catch(Exception er){
        }
    }
}