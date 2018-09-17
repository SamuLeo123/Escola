import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Exemplo0907 extends JFrame 
        implements ListSelectionListener, ActionListener
{
  JLabel L1;
  JTextField T1;   
  JList lista;
  JButton bquant,bindice,bclear;
  DefaultListModel listModel;

public static void main(String args[])
  {
   JFrame Janela = new Exemplo0907();
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
   Exemplo0907()
        {
        setLocation(300,100);
        setTitle("Uso do JList");
        setSize(200,250);
        T1 = new JTextField();
        T1.addActionListener(this);
        L1 = new JLabel("Sem selecao");
        L1.setForeground(Color.black);
        bquant = new JButton("Quantidade de itens");
        bquant.addActionListener(this);
        bindice = new JButton("Indice selecionado");
        bindice.addActionListener(this);
        bclear = new JButton("Remove item");
        bclear.addActionListener(this);
        listModel = new DefaultListModel();
        listModel.addElement("Banana");
        listModel.addElement("Pera");
        listModel.addElement("Maça");
        listModel.addElement("Uva");
        lista = new JList(listModel);
        
        lista.addListSelectionListener(this); 
        JScrollPane Painel = new JScrollPane(lista);
        getContentPane().setLayout(new GridLayout(6,1));
        getContentPane().add(L1);
        getContentPane().add(T1);
        getContentPane().add(Painel);
        getContentPane().add(bquant);
        getContentPane().add(bindice);
        getContentPane().add(bclear);
        }

public void actionPerformed(ActionEvent e)
        {
        if (e.getSource()==T1)
                {
                listModel.addElement(T1.getText());  
                T1.setText("");
                }
        if (e.getSource()==bquant)
           T1.setText("Quantidade: " + listModel.getSize());
        if (e.getSource()==bindice)
           T1.setText("Indice selecionado: " + lista.getSelectedIndex());   
        if (e.getSource()==bclear)
           {
           int index = lista.getSelectedIndex();
           L1.setText("Removido : "+ lista.getSelectedValue());
           listModel.remove(index);

           }
        }

public void valueChanged(ListSelectionEvent e)
        {
        L1.setText("Selecionado : "+ lista.getSelectedValue());
        }
}
