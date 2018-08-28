import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Exercicio9 extends JFrame implements ActionListener{
    JLabel l1, lt, lb, ln, lp, lv;
    JButton bl, bs, bd, bsl, bn, bb, b5;
    JTextField a;
    static JFrame j;
    GridBagConstraints c = new GridBagConstraints();
    public static void main(String [] args){
        j = new Exercicio9();
        j.setUndecorated(true);
        j.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setVisible(true);
        j.pack();
    }
    
    public Exercicio9(){
    this.setTitle("Eleição");
    this.setBounds(300, 300, 300, 300);
    this.getContentPane().setBackground(new Color(255, 255, 255));
    this.getContentPane().setLayout(new GridBagLayout());
    l1 = new JLabel("Escolha seu candidato:");
    l1.setForeground(Color.black);
    l1.setFont(new Font(" ", Font.BOLD, 14));
    bl = new JButton("Leléo");
    bl.addActionListener(Exercicio9.this);
    bs = new JButton("Samuel");
    bs.addActionListener(Exercicio9.this);
    bd = new JButton("Ditador do Bairro");
    bd.addActionListener(Exercicio9.this);
    bsl = new JButton("SamuLéo");
    bsl.addActionListener(Exercicio9.this);
    bn = new JButton("Nulo");
    bn.addActionListener(Exercicio9.this);
    bb = new JButton("Branco");
    bb.addActionListener(Exercicio9.this);
    b5 = new JButton("Finalizar");
    b5.addActionListener(Exercicio9.this);
    c.fill = GridBagConstraints.HORIZONTAL;
    c.weightx = 0.5;c.gridx=1;c.gridy = 0;c.gridwidth =1;c.insets = new Insets(0,10,10,10);c.ipadx = 40;
    getContentPane().add(l1,c);
    c.weightx = 0.5;c.gridx=0;c.gridy = 1;
    getContentPane().add(bl,c);
    c.weightx = 0.5;c.gridx=2;c.gridy = 1;
    getContentPane().add(bs,c);
    c.weightx = 0.5;c.gridx=0;c.gridy = 2;
    getContentPane().add(bd,c);
    c.weightx = 0.5;c.gridx=2;c.gridy = 2;
    getContentPane().add(bsl,c);
    c.weightx = 0.5;c.gridx=0;c.gridy = 3;
    getContentPane().add(bn,c);
    c.weightx = 0.5;c.gridx=2;c.gridy = 3;
    getContentPane().add(bb,c);
    c.weightx = 0.5;c.gridx=0;c.gridy = 4;c.gridwidth = 3;
    getContentPane().add(b5,c);
        
    lt = new JLabel("");
    lt.setForeground(Color.black);
    lt.setFont(new Font(" ", Font.BOLD, 14));
    ln = new JLabel("");
    ln.setForeground(Color.black);
    ln.setFont(new Font(" ", Font.BOLD, 14));
    lb = new JLabel("");
    lb.setForeground(Color.black);
    lb.setFont(new Font(" ", Font.BOLD, 14));
    lp = new JLabel("");
    lp.setForeground(Color.black);
    lp.setFont(new Font(" ", Font.BOLD, 14));
    lv = new JLabel("");
    lv.setForeground(Color.black);
    lv.setFont(new Font(" ", Font.BOLD, 14));
    c.weightx = 0.5;c.gridx=0;c.gridy = 5;c.gridwidth = 3;
    getContentPane().add(lt,c);c.weightx = 0.5;c.gridx=0;c.gridy = 6;c.gridwidth = 3;
    getContentPane().add(ln,c);c.weightx = 0.5;c.gridx=0;c.gridy = 7;c.gridwidth = 3;
    getContentPane().add(lb,c);c.weightx = 0.5;c.gridx=0;c.gridy = 8;c.gridwidth = 3;
    getContentPane().add(lp,c);c.weightx = 0.5;c.gridx=0;c.gridy = 9;c.gridwidth = 3;
    getContentPane().add(lv,c);c.weightx = 0.5;c.gridx=0;c.gridy = 10;c.gridwidth = 3;
    }
    
    public void actionPerformed(ActionEvent e) {
        try{
            if(e.getSource()==bl){
                Votar(1);
            }
            else if(e.getSource()==bs){
                Votar(2);
            }
            else if(e.getSource()==bd){
                Votar(3);
            }
            else if(e.getSource()==bsl){
                Votar(4);
            }
            else if(e.getSource()==bb){
                Votar(5);
            }
            else if(e.getSource()==bn){
                Votar(6);
            }
            else if(e.getSource()==b5){
                Show();
            }
        }
        catch(Exception er){}
    }
    
    
    double vl,vs,vd,vsl,vb,vn,vtt;
    public void Votar(int cand){
        vtt++;
        switch (cand){
            case 1: vl++;break;
            case 2: vs++;break;
            case 3: vd++;break;
            case 4: vsl++;break;
            case 5: vb++;break;
            case 6: vn++;break;
        }
    }
    
    public void Show(){
        lt.setText("Esta votação teve " + vtt + " votos");
        lb.setText("Esta votação teve " + vb + " votos em branco");
        ln.setText("Esta votação teve " + vn + " votos nulos");
        String v = PorcVenc();
        lp.setText("Porcentagens: Leléo: " + pl+ "%; Samuel: " + ps+ "%; Ditador: " + pd + "%; SamuLéo: " + psl + "%;");
        if(v.equals("Empate")){
            lv.setText("Houve um "+ v);
        } else {
            lv.setText("O Vencedor foi: " + v);
        }
        
        
    }
    
    double pl,ps,pd,psl;
    public String PorcVenc(){
        pl = (vl/vtt)*100;
        ps = (vs/vtt)*100;
        pd = (vd/vtt)*100;
        psl = (vsl/vtt)*100;
        if(vl == vs && vl == vd && vl == vsl){
            return "Empate";
        }
        else if(vl > vs && vl > vd && vl > vsl){
            return "Leléo";
        }
        else if(vs > vl && vs > vd && vs > vsl){
            return "Samuel";
        }
        else if(vd > vl && vd > vs && vd > vsl){
            return "Ditador do Bairro";
        }
        else{
            return "SamuLéo";
        }
    }
}
