import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.swing.*;
import javax.swing.event.*;

public class Exercicio13 extends JFrame 
        implements ListSelectionListener
{
  JLabel L1;
  JTextField T1;   
  JList lista;
  JButton bquant,bindice,bclear;
  DefaultListModel listModel;
  DecimalFormat df = new DecimalFormat();
  
public static void main(String args[])
  {
    JFrame Janela = new Exercicio13();
    Janela.setUndecorated(true);
    Janela.setVisible(true);
    Janela.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
    Janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Janela.show();
  }
   Exercicio13()
        {
            
        df.applyPattern("##.00");
        setLocation(300,100);
        setTitle("Descontos");
        setSize(200,350);
        T1 = new JTextField();
        L1 = new JLabel("Digite o valor:");
        L1.setForeground(Color.black);
        listModel = new DefaultListModel();
        listModel.addElement("Dinheiro");
        listModel.addElement("Cheque");
        listModel.addElement("Débito");
        listModel.addElement("Crédito");
        lista = new JList(listModel);
        
        lista.addListSelectionListener(this); 
        JScrollPane Painel = new JScrollPane(lista);
        getContentPane().setLayout(new GridLayout(2,2));
        getContentPane().add(T1);
        getContentPane().add(Painel);
        getContentPane().add(L1);
        }


public void valueChanged(ListSelectionEvent e)
        {
            try {
                double v = 0;
            switch(lista.getSelectedIndex()){
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