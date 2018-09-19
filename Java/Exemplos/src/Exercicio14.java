
/*
Construa uma classe que simule o cadastramento de pessoas. O user deve digitar seu Nome, End, CEKSU, e Estado Civil, sendo que

Seksu deve ser escolhido em algum lugar. Ao pressionar o botão mostrar todos estes dados deverao ser copiados para uma JTEXTAREAAAAAAAAAAAAAAAAAAAAAA
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;




public class Exercicio14 extends JFrame implements ActionListener{
    JLabel ln,le,lec,ls;
    JTextField tn, te, tec;
    JRadioButton radio1,radio2,radio3;
    ButtonGroup radiogroup;
    
    public static void main(String args[])
  {
    JFrame Janela = new Exercicio14();
    Janela.setUndecorated(true);
    Janela.setVisible(true);
    Janela.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
    Janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Janela.show();
  }
   Exercicio14()
        {
            
        setLocation(300,100);
        setTitle("Cadastro");
        setSize(200,350);
        getContentPane().setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        
        ln.setText("Nome: ");
        le.setText("Endereço: ");
        lec.setText("Estado Civil: ");      
        radio1 = new JRadioButton("Homem");
        radio2 = new JRadioButton("Mulher");
        radio3 = new JRadioButton("Outros");
        radiogroup = new ButtonGroup();
        radiogroup.add(radio1);
        radiogroup.add(radio2);
        radiogroup.add(radio3);
        }
   
    public void actionPerformed(ActionEvent e) {
        
    }
}

