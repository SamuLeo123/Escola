
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRootPane;
import javax.swing.JTextField;


public class Exercicio6 extends JFrame implements ActionListener{
    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10;
    JButton b1;
    JTextField t1, t2, t3, t4;
    static JFrame j;
    public static void main(String [] args){
        j = new Exercicio6();
        j.setUndecorated(true);
        j.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setVisible(true);
    }
    
    Exercicio6(){
        this.setTitle("Soma e divisão");
        this.setBounds(300, 50, 350, 350);
        this.getContentPane().setBackground(new Color(150, 150, 150));
        this.getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        l1 = new JLabel("Primeiro valor");
        l1.setForeground(Color.black);
        l1.setFont(new Font(" ", Font.BOLD, 14));
        l2 = new JLabel("Segundo valor");
        l2.setForeground(Color.black);
        l2.setFont(new Font(" ", Font.BOLD, 14));
        l3 = new JLabel("Terceiro valor");
        l3.setForeground(Color.black);
        l3.setFont(new Font(" ", Font.BOLD, 14));
        l4 = new JLabel("Quarto valor");
        l4.setForeground(Color.black);
        l4.setFont(new Font(" ", Font.BOLD, 14));
        
        l5 = new JLabel("");
        l5.setForeground(Color.black);
        l5.setFont(new Font(" ", Font.BOLD, 14));
        l6 = new JLabel("");
        l6.setForeground(Color.black);
        l6.setFont(new Font(" ", Font.BOLD, 14));
        l7 = new JLabel("");
        l7.setForeground(Color.black);
        l7.setFont(new Font(" ", Font.BOLD, 14));
        l8 = new JLabel("");
        l8.setForeground(Color.black);
        l8.setFont(new Font(" ", Font.BOLD, 14));
        l9 = new JLabel("");
        l9.setForeground(Color.black);
        l9.setFont(new Font(" ", Font.BOLD, 14));
        l10 = new JLabel("");
        l10.setForeground(Color.black);
        l10.setFont(new Font(" ", Font.BOLD, 14));
        b1 = new JButton("Calcular");
        b1.addActionListener(Exercicio6.this);
        t1 = new JTextField();
        t2 = new JTextField();
        t3 = new JTextField();
        t4 = new JTextField();
        getContentPane().add(l1);
        getContentPane().add(t1);
        getContentPane().add(l2);
        getContentPane().add(t2);
        getContentPane().add(l3);
        getContentPane().add(t3);
        getContentPane().add(l4);
        getContentPane().add(t4);
        getContentPane().add(b1);
        getContentPane().add(l5);
        getContentPane().add(l6);
        getContentPane().add(l7);
        getContentPane().add(l8);
        getContentPane().add(l9);
        getContentPane().add(l10);
    }

    public void actionPerformed(ActionEvent e) {
        try{
            double soma = Double.parseDouble(t1.getText()) + Double.parseDouble(t2.getText()) + Double.parseDouble(t3.getText()) + Double.parseDouble(t4.getText());
            l5.setText("A soma é " + soma);
            l6.setText("A média é " + (soma/4));
            l7.setText("O resto da divisão da soma por " + t1.getText() + " é " + (soma % Double.parseDouble((t1.getText()))));
            l8.setText("O resto da divisão da soma por " + t2.getText() + " é " + (soma % Double.parseDouble((t2.getText()))));
            l9.setText("O resto da divisão da soma por " + t3.getText() + " é " + (soma % Double.parseDouble((t3.getText()))));
            l10.setText("O resto da divisão da soma por " + t4.getText() + " é " + (soma % Double.parseDouble((t4.getText()))));
        }
        catch(Exception er){
            l5.setText("Preencha todos os campos!");
        }
    }
}
