import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Exemplo0912 extends JFrame implements ActionListener
 {
 JButton B1,B2,B3;
 JLabel L1;
 public static void main(String args[])
  {
  JFrame Janela = new Exemplo0912();
  Janela.show();
  //fecha a janela
  WindowListener x = new WindowAdapter()
   {
   public void windowClosing(WindowEvent e)
    {
    System.exit(0);
    }
   };
  Janela.addWindowListener(x);
  }

  Exemplo0912()
  {
    setBackground(new Color(190,190,190));
    setSize(400,100);
    setTitle("Caixas de confirmacao");
    getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER));
    L1=new JLabel("Resposta: ");
    B1=new JButton("Sim e Nao");              B1.addActionListener(this);
    B2=new JButton("Sim, Nao e Cancelar");    B2.addActionListener(this);
    B3=new JButton("Ok e Cancelar");          B3.addActionListener(this);
    getContentPane().add(B1);
    getContentPane().add(B2);
    getContentPane().add(B3);
    getContentPane().add(L1);
  }

 public void actionPerformed(ActionEvent e)
    {
    int resposta=0;
    if(e.getSource()==B1)
      resposta=JOptionPane.showConfirmDialog(null,"Erro ao acessar arquivo. Tentar novamente?","Erro de arquivo",JOptionPane.YES_NO_OPTION,JOptionPane.ERROR_MESSAGE);
    if(e.getSource()==B2)
      resposta=JOptionPane.showConfirmDialog(null,"Deseja salvar as alteracoes?","Salvar o arquivo",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.WARNING_MESSAGE);
    if(e.getSource()==B3)
      resposta=JOptionPane.showConfirmDialog(null,"Deseja abrir o arquivo?","Abrir arquivo",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);

    switch(resposta)
     {
     case 0: L1.setText("Pressionado o botão Yes / Ok"); break;
     case 1: L1.setText("Pressionado o botão No"); break;
     case 2: L1.setText("Pressionado o botão Cancel"); break;
     }
    }
 }
