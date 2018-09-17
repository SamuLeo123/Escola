import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Exemplo0917 extends JFrame implements ActionListener
 {
  JMenuBar M1;
  JTextField T1;
  JMenu menuCadastro, menuRelatorio;
  JMenuItem micliente, mifornecedor, misair, mirlcliente, mirlfornecedor;

public static void main(String args[])
 {
  JFrame Janela=new Exemplo0917();
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

 Exemplo0917()
  {
  setTitle("Uso de Menus");
  setSize(270,130);
  setLocation(50,50);
  getContentPane().setBackground(new Color(0,128,128));
  T1 = new JTextField();
  M1 = new JMenuBar(); 
  menuCadastro = new JMenu("Cadastro"); 
  menuRelatorio = new JMenu("Relatorios");
  micliente = new JMenuItem ("Cliente");
  micliente.addActionListener(this);
  mifornecedor = new JMenuItem ("Fornecedor");
  mifornecedor.addActionListener(this);
  misair = new JMenuItem ("Sair do sistema");
  misair.addActionListener(this);
  menuCadastro.add(micliente);
  menuCadastro.add(mifornecedor);
  menuCadastro.add(misair);
  mirlcliente = new JMenuItem ("Relação de Clientes");
  mirlcliente.addActionListener(this);
  mirlfornecedor = new JMenuItem ("Relação de Fornecedores");
  mifornecedor.addActionListener(this);
  menuRelatorio.add(mirlcliente);
  menuRelatorio.add(mirlfornecedor);
  M1.add(menuCadastro);
  M1.add(menuRelatorio);
  setJMenuBar(M1);
  getContentPane().add(T1);
 }

 public void actionPerformed(ActionEvent e)
  {
   if (e.getSource()==micliente)
      T1.setText("Escolhido o item Cliente");
   if (e.getSource()==mifornecedor)
      T1.setText("Escolhido o item Fornecedor");      
   if (e.getSource()==mirlcliente)
      T1.setText("Escolhido o item Relação de Clientes");
   if (e.getSource()==mirlfornecedor)
      T1.setText("Escolhido o item Relação de Fornecedores");      
   if (e.getSource()==misair)
     System.exit(0);    
  }
}
