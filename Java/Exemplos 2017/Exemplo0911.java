import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Exemplo0911 extends JFrame implements ActionListener
 {
 ImageIcon icone = new ImageIcon("C:/Livros/Java/estrela.gif"); 
 JButton B1,B2,B3,B4,B5,B6;

 public static void main(String args[])
  {
  JFrame Janela = new Exemplo0911();
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

  Exemplo0911()
  {
    setBackground(new Color(190,190,190));
    setSize(350,100);
    setTitle("Caixas de mensagem");
    getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER));
    B1=new JButton("Pergunta");              B1.addActionListener(this);
    B2=new JButton("Informacao");            B2.addActionListener(this);
    B3=new JButton("Alerta");                B3.addActionListener(this);
    B4=new JButton("Erro");                  B4.addActionListener(this);
    B5=new JButton("Definida pelo usuario"); B5.addActionListener(this);
    B6=new JButton("Somente mensagem");      B6.addActionListener(this);
    getContentPane().add(B1);
    getContentPane().add(B2);
    getContentPane().add(B3);
    getContentPane().add(B4);
    getContentPane().add(B5);
    getContentPane().add(B6);
  }

 public void actionPerformed(ActionEvent e)
    {
    if(e.getSource()==B1)
      JOptionPane.showMessageDialog(null,"Sera que estou aprendendo Java?","Pergunta",JOptionPane.QUESTION_MESSAGE);
    if(e.getSource()==B2)
      JOptionPane.showMessageDialog(null,"Esta e uma mensagem de informacao.","Mensagem de Informacao",JOptionPane.INFORMATION_MESSAGE);
    if(e.getSource()==B3)
      JOptionPane.showMessageDialog(null,"Cuidado!","Mensagem de Alerta",JOptionPane.WARNING_MESSAGE);
    if(e.getSource()==B4)
      JOptionPane.showMessageDialog(null,"Ocorreu algum erro!","Mensagem de Erro",JOptionPane.ERROR_MESSAGE);
    if(e.getSource()==B5)
      JOptionPane.showMessageDialog(null,"Utilizando um gif animado.","Definido pelo usuario",JOptionPane.INFORMATION_MESSAGE,icone);
    if(e.getSource()==B6)
      JOptionPane.showMessageDialog(null,"Caixa de mensagem simples.","Somente mensagem",JOptionPane.PLAIN_MESSAGE);
    }
 }
