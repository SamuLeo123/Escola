import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.NumberFormat;

public class Exemplo0915 extends JFrame implements AdjustmentListener
{
 JScrollBar SB1;
 JLabel L1,L2;
   
 public static void main(String args[])
  {
  JFrame Janela = new Exemplo0915();
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

 Exemplo0915() 
  {
  setBackground(new Color(190,190,190));
  setSize(250,100);
  setTitle("Uso da barra de rolagem");
  getContentPane().setLayout(new GridLayout(3,1));  
  SB1 = new JScrollBar(JScrollBar.HORIZONTAL,0,5,0,105); 
  SB1.addAdjustmentListener(this);  
  L1 = new JLabel("" + SB1.getValue(),JLabel.CENTER);
  L1.setForeground(Color.black);
  L2 = new JLabel("",JLabel.CENTER);
  L2.setForeground(Color.black);  
  getContentPane().add(SB1);
  getContentPane().add(L1);
  getContentPane().add(L2);
  }

public void adjustmentValueChanged(AdjustmentEvent e)
  {
  L1.setText(SB1.getValue() + " Centímetros");
  NumberFormat nf;
  nf = NumberFormat.getNumberInstance();
  nf.setMinimumFractionDigits(3);
  double pol = SB1.getValue() / 2.54;	
  L2.setText(nf.format(pol) +" Polegadas");
  }
}
