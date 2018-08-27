
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRootPane;

public class Exercicio10 extends JFrame implements ActionListener{
    JLabel l1;
    JButton b1;
    static JFrame j;
    public static void main(String [] args){
        j = new Exercicio10();
        j.setUndecorated(true);
        j.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setVisible(true);
    }
    
    Exercicio10(){
        this.setTitle("Descontos");
        this.setBounds(300, 50, 500, 100);
        this.getContentPane().setBackground(new Color(150, 150, 150));
        this.getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        l1 = new JLabel("");
        l1.setForeground(Color.black);
        l1.setFont(new Font(" ", Font.BOLD, 14));
        b1 = new JButton("Ver descontos");
        b1.addActionListener(Exercicio10.this);
        getContentPane().add(b1);
        getContentPane().add(l1);
    }

    public void actionPerformed(ActionEvent e) {
        Date d = new Date();
        Calendar c = Calendar.getInstance(); 
        c.setTime(d);
        int dia = c.get(c.DAY_OF_WEEK);
        switch(dia){
          case Calendar.SUNDAY : l1.setText("Hoje é domingo e o trabalho de artes é amanhã? 50% de desconto pela Brantovisk Art!!!!!!"); break;
          case Calendar.MONDAY : l1.setText("Segunda é dia de ser gratuito com o Victor, 300% de desconto!!!!"); break;
          case Calendar.TUESDAY : l1.setText("Terça é dia de descontos com descontos de 60%!!!!"); break;
          case Calendar.WEDNESDAY : l1.setText("Quarta é dia mais um dia pra se anunciar descontos!!"); break;
          case Calendar.THURSDAY : l1.setText("Quinta tem desconto tbm!!!"); break;
          case Calendar.FRIDAY : l1.setText("Sexta é o dia q a criatividade acaba, leve essa ideia por apenas metade do preço!!"); break;
          case Calendar.SATURDAY : l1.setText("Sábado é dia de terminar logo essa Classe!!"); break;
        }
    }
}
