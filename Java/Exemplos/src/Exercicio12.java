
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRootPane;
import javax.swing.JTextField;

public class Exercicio12 extends JFrame implements ActionListener{
    JLabel l1, l2, l3, l4;
    JButton b1;
    JTextField t1, t2, t3;
    static JFrame j;
    public static void main(String [] args){
        j = new Exercicio12();
        j.setUndecorated(true);
        j.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setVisible(true);
    }
    
    Exercicio12(){
        this.setTitle("Verificar data");
        this.setBounds(300, 50, 500, 100);
        this.getContentPane().setBackground(new Color(150, 150, 150));
        this.getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        l1 = new JLabel("Dia do nascimento");
        l1.setForeground(Color.black);
        l1.setFont(new Font(" ", Font.BOLD, 14));
        l2 = new JLabel("Mês do nascimento");
        l2.setForeground(Color.black);
        l2.setFont(new Font(" ", Font.BOLD, 14));
        l3 = new JLabel("Ano do nascimento");
        l3.setForeground(Color.black);
        l3.setFont(new Font(" ", Font.BOLD, 14));
        l4 = new JLabel("");
        l4.setForeground(Color.black);
        l4.setFont(new Font(" ", Font.BOLD, 14));
        
        b1 = new JButton("Conferir");
        b1.addActionListener(Exercicio12.this);
        t1 = new JTextField();
        t2 = new JTextField();
        t3 = new JTextField();
        getContentPane().add(l1);
        getContentPane().add(t1);
        getContentPane().add(l2);
        getContentPane().add(t2);
        getContentPane().add(l3);
        getContentPane().add(t3);
        getContentPane().add(b1);
        getContentPane().add(l4);
    }

    public void actionPerformed(ActionEvent e) {
        Date d = new Date();
        SimpleDateFormat sdf =  new SimpleDateFormat("dd-MM-yyyy");
        sdf.setLenient(false);
        try { 
            d = sdf.parse(t1.getText() + "-" + t2.getText() + "-" + t3.getText());
            l4.setText("Data válida!");
            
        } catch (ParseException ex) {
            l4.setText("Data inválida!");
        }
    }
}