import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Exercicio2 extends JFrame implements ActionListener{
    JLabel l1,l2, l3, l , l0;
    JButton b1, b2, b3, b4;
    JTextField t1,t2,t3;
    static JFrame j;
    public static void main(String [] args){
        j = new Exercicio2();
        j.setUndecorated(true);
        j.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setVisible(true);
        j.pack();
    }
public Exercicio2(){
    this.setTitle("CALCULADORA");
    //this.setBounds(300, 50, 350, 90);
    this.setBounds(300, 300, 300, 300);
    this.getContentPane().setBackground(new Color(150, 150, 150));
    this.getContentPane().setLayout(new GridLayout(6, 2, 30, 50));
    l1 = new JLabel("Primeiro número");
    l1.setForeground(Color.black);
    l1.setFont(new Font(" ", Font.BOLD, 14));
    l2 = new JLabel("Segundo número");
    l2.setForeground(Color.black);
    l2.setFont(new Font(" ", Font.BOLD, 14));
    l3 = new JLabel("Resultado");
    l3.setForeground(Color.black);
    l3.setFont(new Font(" ", Font.BOLD, 14));
    b1 = new JButton("A");
    b1.addActionListener(Exercicio2.this);
    b2 = new JButton("B");
    b2.addActionListener(Exercicio2.this);
    b3 = new JButton("C");
    b3.addActionListener(Exercicio2.this);
    b4 = new JButton("D");
    b4.addActionListener(Exercicio2.this);
    t1 = new JTextField();
    t2 = new JTextField();
    t3 = new JTextField();
    l = new JLabel("A = +, B = -, C = *, D = /");
    l0 = new JLabel();
    l.setForeground(Color.black);
    l.setFont(new Font(" ", Font.BOLD, 14));
    getContentPane().add(l1);
    getContentPane().add(t1);
    getContentPane().add(l2);
    getContentPane().add(t2);
    getContentPane().add(l);
    getContentPane().add(l0);
    getContentPane().add(b1);
    getContentPane().add(b2);
    getContentPane().add(b3);
    getContentPane().add(b4);
    getContentPane().add(l3);
    getContentPane().add(t3);
}

 @Override
public void actionPerformed(ActionEvent e) {
	try{
	double n1 = Double.parseDouble(t1.getText()), n2 = Double.parseDouble(t2.getText()), result = 0;
	if(e.getSource() == b1){
		result = n1 + n2;
	}
	if(e.getSource() == b2){
		result = n1 - n2;
	}
	if(e.getSource() == b3){
		result = n1 * n2;
	}
	if(e.getSource() == b4){
		result = n1 / n2;
	}
	t3.setText(String.valueOf(result));
	}
	catch(Exception erro){
		t3.setText("Erro");
	}
    }
}
