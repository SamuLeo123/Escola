import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Exemplo0908 extends JFrame 
       implements ActionListener, ItemListener
 {
   JLabel L1;
   JTextField T1,T2,T3;
   JComboBox combo;
   JButton B1,B2,B3,B4,B5,B6,B7,B8;

 public static void main(String args[])
  {
   JFrame Janela = new Exemplo0908();
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

 Exemplo0908()
  {
   setTitle("Uso do JComboBox");
   setSize(400,170);
   getContentPane().setBackground(new Color(190,190,190));
   L1 = new JLabel("Conteudo");
   L1.setForeground(Color.blue);
   L1.setFont(new Font("Arial", Font.BOLD, 15));
   B1 = new JButton("Mostra Texto"); B1.addActionListener(this);
   B2 = new JButton("Mostra Indice"); B2.addActionListener(this);
   B3 = new JButton("Adiciona Item"); B3.addActionListener(this);
   B4 = new JButton("Remove Item"); B4.addActionListener(this);        
   B5 = new JButton("Remove Todos"); B5.addActionListener(this);
   B6 = new JButton("Quant. Itens"); B6.addActionListener(this);
   T1 = new JTextField(); T2 = new JTextField(); 
   String[] cores = {"Branco","Vermelho","Azul","Verde"};
   combo = new JComboBox(cores);
   combo.addItemListener(this);
   getContentPane().setLayout(new GridLayout(5,2));
   getContentPane().add(L1);
   getContentPane().add(combo);
   getContentPane().add(B1);
   getContentPane().add(B4);    
   getContentPane().add(B2);
   getContentPane().add(B5); 
   getContentPane().add(B3);
   getContentPane().add(T1);  
   getContentPane().add(B6);
   getContentPane().add(T2);
  }
 
 public void actionPerformed(ActionEvent e)
  {
   if (e.getSource()==B1)
    L1.setText("Texto: "+combo.getSelectedItem());
   if (e.getSource()==B2)
    L1.setText("Indice: " + combo.getSelectedIndex());
   if (e.getSource()==B3)
     if (T1.getText().length()!=0)
      {                   
      combo.addItem(T1.getText());
      T1.setText("");
      }
   if (e.getSource()==B4)
    combo.removeItemAt(combo.getSelectedIndex());
   if (e.getSource()==B5)
    combo.removeAllItems();
   if (e.getSource()==B6)
    T2.setText(""+combo.getItemCount());     
  }

public void itemStateChanged(ItemEvent e)
  {
 	T1.setText(""+combo.getSelectedItem());
  }	
 }
