import java.awt.*;
import java.awt.event.*;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.*;
public class Exercicio11 extends JFrame implements ActionListener{
    JLabel l1, l2;
    JButton b1;
    JTextField t1;
    static JFrame j;
    public static void main (String[]args){
        j = new Exercicio11();
        j.setUndecorated(true);
        j.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setVisible(true);
    }
    
    public Exercicio11(){
        this.setTitle("Vida");
        this.setBounds(300, 50, 350, 90);
        this.getContentPane().setBackground(new Color(255, 255, 255));
        this.getContentPane().setLayout(new GridLayout(2, 4));
        l1 = new JLabel("Digite sua data de nascimento dd/mm/aaaa");
        l1.setForeground(Color.black);
        l1.setFont(new Font(" ", Font.BOLD, 14));
        l2 = new JLabel("");
        l2.setForeground(Color.black);
        l2.setFont(new Font(" ", Font.BOLD, 14));
        b1 = new JButton("Calcular");
        b1.addActionListener(Exercicio11.this);
        t1 = new JTextField();
        getContentPane().add(l1);
        getContentPane().add(t1);
        getContentPane().add(b1);
        getContentPane().add(l2);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            Calendar dia_atual = Calendar.getInstance();
            Calendar data = Calendar.getInstance();
            DateFormat df = DateFormat.getDateInstance();
            String data_ins = t1.getText();
            Date datanasc = df.parse(data_ins);
            data.setTime(datanasc);
            long milinasc = data.getTimeInMillis();

            long miliatu = dia_atual.getTimeInMillis();
            long dif = miliatu - milinasc; 
            if(dif<0){
                l2.setText("Não é possivel calcular uma data FUTURA");
            }
            else{
            long dias = dif / 86400000;
            l2.setText("Você viveu: " + dias + " dias");
            }
        }        
        catch(Exception err){}
    }
}
