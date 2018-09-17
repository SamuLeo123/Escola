import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Exemplo0916 extends JFrame implements ActionListener
{
  JTextArea TA1,TA2;
  JTextField T1;
  JButton B1,B2;

public static void main(String args[])
  {
  JFrame Janela = new Exemplo0916();
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

 Exemplo0916()
  {
  setSize(480,280);
  setTitle("Uso do JTextArea");
  getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER));  
  T1 = new JTextField(40);
  T1.addActionListener(this);
  B1 = new JButton("Copia Tudo");
  B1.addActionListener(this);
  B2 = new JButton("Copia Selecao");
  B2.addActionListener(this);
  TA1 = new JTextArea("Editor de texto:\n",5,40);
  TA2 = new JTextArea(5,40);
  JScrollPane painel1 = new JScrollPane(TA1);
  JScrollPane painel2 = new JScrollPane(TA2);
  getContentPane().add(painel1);  getContentPane().add(T1);
  getContentPane().add(B1);       getContentPane().add(B2);
  getContentPane().add(painel2);
  }

  public void actionPerformed(ActionEvent e)
  {
  if (e.getSource()==T1) 
    {
    TA1.append(T1.getText());
    T1.setText("");
    }
  if (e.getSource()==B1) 
    TA2.setText(TA1.getText()); 
  if (e.getSource()==B2) 
    TA2.setText(TA1.getSelectedText());
  }
}

/*
Sinais de Escape:
\b retrocesso
\n novalinha
\t tabulação
\r retorno do carro
\f avanço do formulário
\\ barra invertida
\' apóstrofo
\" aspas 
*/
