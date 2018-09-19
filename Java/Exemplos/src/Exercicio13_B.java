import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.swing.*;
import javax.swing.event.*;

public class Exercicio13_B extends JFrame 
        implements ItemListener
{
  JLabel L1;
  JTextField T1;   
  JList lista;
  JComboBox combo;
  JButton bquant,bindice,bclear;
  DefaultListModel listModel;
  DecimalFormat df = new DecimalFormat();
  
public static void main(String args[])
  {
    JFrame Janela = new Exercicio13_B();
    Janela.setUndecorated(true);
    Janela.setVisible(true);
    Janela.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
    Janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Janela.show();
  }
   Exercicio13_B()
        {
            
        df.applyPattern("##.00");
        setLocation(300,100);
        setTitle("Descontos");
        setSize(500,150);
        T1 = new JTextField();
        L1 = new JLabel("Digite o valor:");
        L1.setForeground(Color.black);
        
        String[] pgto = {"Dinheiro","Cheque","Débito","Crédito"};
        combo = new JComboBox(pgto);
        combo.addItemListener(this);
        JScrollPane Painel = new JScrollPane(lista);
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
        getContentPane().add(T1);
        getContentPane().add(combo);
        getContentPane().add(L1);
        }


public void itemStateChanged(ItemEvent e)
        {
            try {
                double v = 0;
            switch(combo.getSelectedIndex()){
                case 0 :  v = Double.parseDouble(T1.getText()) * 0.95; break;
                case 1 :  v = Double.parseDouble(T1.getText()) * 1.05; break;
                case 2 :  v = Double.parseDouble(T1.getText()) * 1.1; break;
                case 3 :  v = Double.parseDouble(T1.getText()) * 1.1; break;
            }
            L1.setText("Valor total: "+ df.format(v));
            } catch (Exception er) {
                L1.setText("");
            }
            
        }
}