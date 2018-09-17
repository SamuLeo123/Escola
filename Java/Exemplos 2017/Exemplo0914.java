import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Exemplo0914 extends JFrame implements ActionListener
 {
 JButton B1;
 JLabel L1;
 
 public static void main(String args[])
  {
  JFrame Janela = new Exemplo0914();
  Janela.show();
  WindowListener x = new WindowAdapter()
   {
   public void windowClosing(WindowEvent e)
    {
    System.exit(0);
    }
   };
  Janela.addWindowListener(x);
  }

  Exemplo0914()
  {
    setBackground(new Color(190,190,190));
    setSize(250,100);
    setTitle("Caixas de entrada");
    getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER));
    L1=new JLabel("");        
    L1.setForeground(Color.blue);
    B1= new JButton("Dialogo de Opcao");   B1.addActionListener(this);
    getContentPane().add(B1);              getContentPane().add(L1);
  }
 public void actionPerformed(ActionEvent e)
    {
    String[] escolha = {"Entre 1 e 20 anos","Entre 21 e 40 anos","Mais de 40 anos"};
    int resp=JOptionPane.showOptionDialog(null,"Qual sua idade?","Idade",0,JOptionPane.INFORMATION_MESSAGE,null,escolha,escolha[0]);
    String idade = (escolha[resp]);
    L1.setText("Idade: " + idade);
    }
 }
