import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Exemplo1001 extends JFrame 
    implements MouseListener, KeyListener, 
    TextListener, FocusListener, MouseMotionListener
{
  JButton B1;  
  JLabel L1,L2;  
  JTextField T1,T2;
  TextField T3;
  static int E=100,T=100;  

  public static void main(String[] args)
  {
   JFrame Janela = new Exemplo1001();
   Janela.show();
   
   WindowListener x = new WindowAdapter() 
     {
     public void windowClosing(WindowEvent e) 
       {
       System.exit(0);
       }
     public void windowActivated(WindowEvent e) 
       {
       // A Janela foi ativada
       }  
     public void windowDeactivated(WindowEvent e) 
       {
       // A Janela foi desativada
       }  
    public void windowIconified(WindowEvent e) 
       {
       // A Janela foi minimizada
       }     
    public void windowDeiconified(WindowEvent e) 
       {
       // A Janela foi restaurada;
       }     
	public void windowOpened(WindowEvent e) 
       {
       mostraMensagem("A Janela foi aberta");
       }         
    public void windowClosed(WindowEvent e) 
       {
        // A Janela foi fechada
       }  
     };
   Janela.addWindowListener(x);

   ComponentListener y = new ComponentAdapter() 
   {
    public void componentHidden(ComponentEvent e) 
	{ 
	mostraMensagem("A janela tornou-se oculta");
	}
	
	public void componentMoved(ComponentEvent e) 
	{ 
	mostraMensagem("A janela foi movida");
    } 
	
	public void componentResized(ComponentEvent e) 
	{ 
	mostraMensagem("A janela foi redimensionada");
	}
	
	public void componentShown(ComponentEvent e) 
	{ 
	mostraMensagem("A janela tornou-se visível");
	}
   };
   Janela.addComponentListener(y);
  }  

  Exemplo1001()
   {
    setTitle("Manipulação de Eventos");	
    setSize(280,200);
    setLocation(E,T); 
    getContentPane().setLayout(new GridLayout(6,1));
    L1 = new JLabel("");
    L2 = new JLabel("");
    B1 = new JButton ("Eventos do Botão"); 
    T1 = new JTextField();    
    T2 = new JTextField();    
    T3 = new TextField();      
    B1.addMouseListener(this); 
    B1.addMouseMotionListener(this);
    B1.setBackground(Color.gray);
    T1.addKeyListener(this);
    T3.addTextListener(this);  
    T3.addKeyListener(this);
    T3.addFocusListener(this);
    getContentPane().add(B1); 
    getContentPane().add(L1); 
    getContentPane().add(L2);
    getContentPane().add(T1); 
    getContentPane().add(T3); 
    getContentPane().add(T2); 
   }
	// métodos relativos a MouseListener
  public void mousePressed(MouseEvent e)
   { 
   L1.setText("O botão do Mouse foi pressionado"); 
   mostraMensagem(""+e.getClickCount() + "  " + e.getX()+ "  " + e.getY());
   //mostraMensagem(""+e.isLeftMouseButton()+ "  "+ e.isControlDown());
   }
  public void mouseClicked(MouseEvent e) 
   { 
   L1.setText("O botão do Mouse foi solto");
   }
  public void mouseEntered(MouseEvent e)
   { // o ponteiro do mouse entrou na área
   B1.setBackground(Color.yellow);
   }
  public void mouseExited(MouseEvent e) 
   { // o ponteiro do mouse saiu da área
   B1.setBackground(Color.gray);
   }
  public void mouseReleased(MouseEvent e) 
   { 
   L1.setText("O ponteiro do Mouse foi arrastado");
   }
   // métodos relativos a MouseMotionListener
  public void mouseMoved(MouseEvent e) 
   {
   L2.setText("Mouse se moveu em "+e.getX()+" , "+e.getY());
   }
  public void mouseDragged(MouseEvent e) 
   {
   L2.setText("Mouse foi arrastado em "+e.getX()+" , "+e.getY());
   }
	// métodos relativos a KeyListener
  public void keyPressed(KeyEvent e)
   { // uma tecla foi pressionada
    if (e.getSource()==T1)
       {
       if(e.getKeyCode()==10 || e.getKeyCode()==9) 
         {
         e.setKeyCode(9);  
         return;  
         }
       if(e.getKeyCode()==38) 
         {
         T = T - 5;
         setLocation(E,T); 
         }
       if(e.getKeyCode()==40) 
         {
         T = T + 5; 
         setLocation(E,T); 
         }		
       if(e.getKeyCode()==37) 
         { 
         E = E - 5;
         setLocation(E,T); 
         }
       if(e.getKeyCode()==39) 
         {
         E = E + 5; 
         setLocation(E,T); 
         }
       }
    if (e.getSource()==T3)
     {
     if(e.getKeyCode()==10 || e.getKeyCode()==9) 
         {
         e.setKeyCode(9);  
         return;  
         }
     if(e.getKeyCode()==8)
         return;
     if(e.getKeyCode()<96 || e.getKeyCode()>105) 
       {
       e.setKeyCode(e.VK_ESCAPE);  
       return;  
       }
     }
    }
    public void keyReleased(KeyEvent e) 
    {
    // uma tecla foi solta	
    }
    public void keyTyped(KeyEvent e)    
    {
    // uma tecla Unicode foi pressionada
    }

   // método relativo a TextListener
    public void textValueChanged(TextEvent e)
     {  // o conteúdo do campo texto foi alterado
     int n1,n2;
     try
       {
       n1 = Integer.parseInt(T1.getText());
       n2 = Integer.parseInt(T3.getText());
       T2.setText(""+n1*n2);
       }
     catch(NumberFormatException erro)
       { 
       T2.setText("0");
       return; 
       }
      } 

    public void focusGained(FocusEvent e) 
    { // o objeto recebeu o foco
	L1.setText("O objeto T3 recebeu o foco");
    }

    public void focusLost(FocusEvent e) 
    { // o objeto perdeu o foco
	L1.setText("O objeto T3 perdeu o foco");
    }
 
	public static void mostraMensagem(String men)
    {
     JOptionPane.showMessageDialog(null,men,"Mensagem",JOptionPane.INFORMATION_MESSAGE);	
    }
}

