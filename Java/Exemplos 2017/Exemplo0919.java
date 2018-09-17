import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Exemplo0919 extends JFrame implements ActionListener
 {
  JPopupMenu mpopup;
  JMenuItem miCopiar, miColar, miSalvar;
  JMenuBar M1;
  JTextField T1;
  JButton B1,B2;
  public static void main(String args[])
  {
  JFrame Janela=new Exemplo0919();
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
 
  Exemplo0919()
  {
  setTitle("Uso de Menus Popup");
  setSize(220,120);
  setLocation(50,50);
  getContentPane().setBackground(new Color(0,128,128));
  getContentPane().setLayout(new GridLayout(3,1));
  M1 = new JMenuBar();
  T1 = new JTextField();
  B1 = new JButton("Botão 1");
  B2 = new JButton("Botão 2");
  mpopup = new JPopupMenu();
  MouseListener registra = new MostraPopup();
  B1.addMouseListener(registra);  
  miCopiar = new JMenuItem ("Copiar");
  miCopiar.addActionListener(this);
  miCopiar.setMnemonic(KeyEvent.VK_C);
  miColar = new JMenuItem ("Colar");
  miColar.addActionListener(this);
  miColar.setMnemonic(KeyEvent.VK_O);
  miSalvar = new JMenuItem ("Salvar", new ImageIcon("MenuSalvar.gif"));
  miSalvar.addActionListener(this);
  miSalvar.setMnemonic(KeyEvent.VK_S);
  mpopup.add(miCopiar);
  mpopup.add(miColar);
  mpopup.add(miSalvar);
  getContentPane().add(B1);
  getContentPane().add(B2);
  getContentPane().add(T1);
  } 

  public void actionPerformed(ActionEvent e)
  {
   if (e.getSource()==miCopiar)
      T1.setText("Copiar");
   if (e.getSource()==miColar)
      T1.setText("Colar");
   if (e.getSource()==miSalvar)
      T1.setText("Salvar");
  }

  class MostraPopup extends MouseAdapter 
	{
      public void mousePressed(MouseEvent e) 
	    {
	    mpopup.show(e.getComponent(),e.getX(), e.getY());	
	    }
    }
}