import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Exemplo1002 extends JFrame 
    implements KeyListener
{
  JTextField T1,T2;  

   public static void main(String[] args)
   {
   JFrame Janela = new Exemplo1002();
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
     
  Exemplo1002()
   {
    setTitle("Código das teclas");	
    setSize(190,65);
    setResizable(false);
    setLocation(100,100); 
    getContentPane().setLayout(new GridLayout(2,1));
    T1 = new JTextField();    
    T2 = new JTextField();    
    T1.addKeyListener(this);
    getContentPane().add(T1); 
    getContentPane().add(T2); 
   }
       
  public void keyPressed(KeyEvent e)
   { 
   T2.setText(""+e.getKeyCode()); 
   }
   public void keyReleased(KeyEvent e) {}
   public void keyTyped(KeyEvent e)    {}
}

