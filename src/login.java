import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class login extends JFrame implements ActionListener {
    JLabel Name, Ip;
    Font font;
    JButton in;
    JTextField name_text, name_ip;
    static String send_name, send_ip;
    login(){
        setTitle("로그인");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.white);

        font = new Font("SanSerif", Font.BOLD, 20);

        setLayout(null);

        Name = new JLabel("닉네임 : ");
        Ip = new JLabel("Ip : ");
        in = new JButton("참여");
        name_text = new JTextField("");
        name_ip = new JTextField("");

        Name.setBounds(50, 40, 100, 50);
        Ip.setBounds(50, 100, 100, 50);
        in.setBounds(150, 170, 100, 40);
        name_text.setBounds(150, 40, 150, 40);
        name_ip.setBounds(150, 100, 150, 40);

        Name.setFont(font);
        Ip.setFont(font);
        in.setFont(font);

        in.setBackground(Color.pink);

        add(Name);
        add(Ip);
        add(in);
        add(name_text);
        add(name_ip);

        in.addActionListener(this);

        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("참여")){
            send_name = name_text.getText();
            send_ip = name_ip.getText();
            MultichatClient run = new MultichatClient();
            run.ClientRun();
            dispose();
        }
    }
    public static void main(String args[]){
        new login();
    }
}
