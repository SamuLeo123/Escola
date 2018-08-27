
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRootPane;
import javax.swing.JTextField;

public class Exercicio8 extends JFrame implements ActionListener{
    JLabel l1;
    JButton b1;
    static JFrame j;
    public static void main(String [] args){
        j = new Exercicio8();
        j.setUndecorated(true);
        j.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setVisible(true);
    }
    
    Exercicio8(){
        this.setTitle("Fibonacci");
        this.setBounds(300, 50, 370, 100);
        this.getContentPane().setBackground(new Color(150, 150, 150));
        this.getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        l1 = new JLabel("");
        l1.setForeground(Color.black);
        l1.setFont(new Font(" ", Font.BOLD, 14));
        b1 = new JButton("Calcular");
        b1.addActionListener(Exercicio8.this);
        getContentPane().add(l1);
        getContentPane().add(b1);
    }

    public void actionPerformed(ActionEvent e) {
        int i = 0, j = 2;
        int[] nac = new int[15];
        l1.setText(i + ", ");
        nac[0] = 1;
        l1.setText(l1.getText() + nac[0] + ", ");
        nac[1] = 1;
        l1.setText(l1.getText() + nac[1] + ", ");
        
        while (i < (nac.length - 2)) {
            nac[j] = nac[j - 1] + nac[j - 2];
            if (j == 14) {
                l1.setText(l1.getText() + nac[j] + ".");
            } else if (j < 14){
                l1.setText(l1.getText() + nac[j] + ", ");
            }
            j++;
            i++;
        }
        b1.setEnabled(false);
    }
}

