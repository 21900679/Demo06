import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

public class game extends JFrame implements ActionListener {
    gameboard board;
    Font font = new Font("SanSerif", Font.BOLD, 20);
    Font count = new Font("SanSerif", Font.BOLD, 30);
    static int num1, num2;
    static Color btn1 = Color.green;
    static Color btn2 = Color.black;
    static JLabel score1, score2, player1, player2;
    JButton clear;
    public game(String name){
        board = new gameboard();
        setTitle(name);
        setSize(900, 730);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        player1 = new JLabel("Player 1 : ●");
        player2 = new JLabel("Player 2 : ○");
        score1 = new JLabel("● X " + num1);
        score2 = new JLabel("○ X " + num2);
        clear = new JButton("🏠");

        setLayout(null);
        player1.setOpaque(true);         //투명한가 불투명한가. true 불투명
        player2.setOpaque(true);
        player1.setHorizontalAlignment(player1.CENTER);     //중간으로 정렬
        player2.setHorizontalAlignment(player2.CENTER);
        score1.setHorizontalAlignment(score1.CENTER);
        score2.setHorizontalAlignment(score2.CENTER);

        player1.setBounds(700, 50,130,50);
        score1.setBounds(700, 100, 130, 50);
        player2.setBounds(700,350, 130, 50);
        score2.setBounds(700, 400, 130, 50);
        clear.setBounds(700,600, 130, 50);

        getContentPane().setBackground(Color.white);
        player1.setBackground(btn1);
        player2.setBackground(btn2);
        clear.setBackground(Color.white);

        player1.setBorder(new LineBorder(Color.black, 2));
        player2.setBorder(new LineBorder(Color.black, 2));

        player1.setFont(font);
        player2.setFont(font);
        score1.setFont(count);
        score2.setFont(count);
        clear.setFont(count);

        add(board);
        add(player1);
        add(player2);
        add(score1);
        add(score2);
        add(clear);

        clear.addActionListener(this);

        setVisible(true);
    }
    public void remove(){
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                board.stones[i][j] = 0;
            }
        }
        board.stones[3][3] = board.stones[4][4] = -1;
        board.stones[3][4] = board.stones[4][3] = 1;
        board.color = true;
        game.btn1 = Color.green;
        game.btn2 = Color.black;
        player1.setBackground(game.btn1);
        player2.setBackground(game.btn2);
        board.repaint();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("🏠")){
            try{
                MultichatClient.ClientSender.out.writeUTF("초기화");
            }catch (IOException a){}

            for(int i = 0; i < 8; i++){
                for(int j = 0; j < 8; j++){
                    board.stones[i][j] = 0;
                }
            }
            board.stones[3][3] = board.stones[4][4] = -1;
            board.stones[3][4] = board.stones[4][3] = 1;
            board.color = true;
            game.btn1 = Color.green;
            game.btn2 = Color.black;
            player1.setBackground(game.btn1);
            player2.setBackground(game.btn2);
            board.repaint();
        }
    }
//    public static void main(String[] args) {
//        new game();
//    }

}
