import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Exemplo0913 extends JFrame implements ActionListener
 {
 JButton B1;
 JLabel L1;
 public static void main(String args[])
  {
  JFrame Janela = new Exemplo0913();
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

  Exemplo0913()
  {
    setBackground(new Color(190,190,190));
    setSize(230,100);
    setTitle("Uso da caixa de entrada");
    getContentPane().setLayout(new GridLayout(2,1));
    L1=new JLabel("",JLabel.CENTER);
    L1.setForeground(Color.blue);
    B1=new JButton("Login"); B1.addActionListener(this);
  	B1.setToolTipText("Clique aqui para entrar no Sistema");	
  	B1.setMnemonic(KeyEvent.VK_L);
    getContentPane().add(B1);
    getContentPane().add(L1);
  }
 public void actionPerformed(ActionEvent e)
    {
      String resp=JOptionPane.showInputDialog(null,"Qual o seu nome?","Login no sistema",JOptionPane.QUESTION_MESSAGE);
      if (!(resp==null || resp.equals("")))
          L1.setText("Seja Bem Vindo " + resp + " !!");
      else
          L1.setText("");
    }
 }
