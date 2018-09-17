import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

class Exemplo1101 extends JFrame implements ActionListener 
   {
   JLabel L1;
   JButton B1,B2,B3;
   TextArea TA1;

 public static void main(String[] args)
 {
   JFrame Janela = new Exemplo1101();
   WindowListener x = new WindowAdapter() 
     {
     public void windowClosing(WindowEvent e) 
       {
       System.exit(0);
       }
     };
   Janela.addWindowListener(x);
   Janela.show();
 }

   Exemplo1101() 
   {
     setTitle("Manipulação de arquivo Texto");
     setSize (500,250);
     getContentPane().setBackground (new Color (150,150,150));
     getContentPane().setLayout (new FlowLayout());
     L1 = new JLabel("Texto a ser gravado:");
     L1.setForeground(Color.black);
     B1 = new JButton("Gravar");
     B2 = new JButton("Ler");
     B3 = new JButton("Limpar");
     B1.addActionListener(this);
     B2.addActionListener(this);
     B3.addActionListener(this);
     TA1 = new TextArea(8,60);
     getContentPane().add(L1);   
     getContentPane().add(TA1);   
     getContentPane().add(B1);   
     getContentPane().add(B2);   
     getContentPane().add(B3);
    } 

   public void actionPerformed(ActionEvent e)
   {
   String nome_do_arquivo = "c:/arq.txt";
   if (e.getSource() == B3)  //limpar    
      TA1.setText("");
   if (e.getSource() == B1)  //gravar
     {
     try 
      {
      String S = TA1.getText();
      byte b[] = S.getBytes();
      FileOutputStream out = new FileOutputStream(nome_do_arquivo);
      out.write(b);
      out.close();
      } 
     catch(java.io.IOException exc) 
      {
      System.out.println("Erro ao gravar no arquivo");
      }
     }
   if (e.getSource() == B2)  //ler
     {
     try 
      {
      FileInputStream in = new FileInputStream(nome_do_arquivo);
      byte bt[] = new byte[10240];     
      in.read(bt);
      String S = new String(bt);
      TA1.setText(S);
      in.close();
      } 
     catch(java.io.IOException exc) 
      {
      System.out.println("Erro ao ler o arquivo");
      }
     }
 }
}
