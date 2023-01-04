import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class nomove extends JFrame implements ActionListener {
    JLabel move;
    JButton ok;
    Font font = new Font("SanSerif", Font.BOLD, 30);
    nomove(){
        setTitle("no more moves");
        setSize(400,300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(null);
        move = new JLabel("<html><body><center>NO MORE<br>MOVES</center></body></html>");
        ok = new JButton("확인");

        move.setBounds(120, 50, 250, 100);
        ok.setBounds(140, 180, 100, 30);

        getContentPane().setBackground(Color.white);
        ok.setBackground(Color.pink);
        move.setFont(font);

        add(move);
        add(ok);

        ok.addActionListener(this);

        setVisible(true);
    }

//    public static void main(String[] args) {
//        new nomove();
//    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("확인")){
            dispose();
        }
    }
}
