import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class result extends JFrame implements ActionListener {
    Font font = new Font("SanSerif", Font.BOLD, 20);
    Font winfont = new Font("SanSerif", Font.BOLD, 50);
    JLabel win1, win2, equal;
    JButton again;
    gameboard board;
    result(gameboard board){
        this.board = board;
        setTitle("게임 결과");
        setSize(600,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(null);
        again = new JButton("Try Again");
        JButton exit = new JButton("Exit");
        win1 = new JLabel("!!!! Player 1 Win !!!!");
        win2 = new JLabel("!!!! Player 2 Win !!!!");
        equal = new JLabel("!!!! Both Win !!!!");

        win1.setBounds(70, 100, 480, 80);
        win2.setBounds(70, 100, 480, 80);
        equal.setBounds(115, 100, 480, 80);
        again.setBounds(150, 250, 300,60);
        exit.setBounds(150, 330, 300, 60);

        getContentPane().setBackground(Color.white);
        again.setBackground(Color.PINK);
        exit.setBackground(Color.pink);

        again.setFont(font);
        exit.setFont(font);
        win1.setFont(winfont);
        win2.setFont(winfont);
        equal.setFont(winfont);

        add(again);
        add(exit);

//        System.out.println("aaa" + game.num1);
//        System.out.println("aaa" + game.num2);

        if(game.num1 > game.num2){
            add(win1);
        }
        else if(game.num1 == game.num2){
            add(equal);
        }
        else
            add(win2);

        again.addActionListener(this);
        exit.addActionListener(this);

        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Exit")){
            System.exit(0);
        }
        if(e.getActionCommand().equals("Try Again")){
            dispose();
            for(int i = 0; i < 8; i++){
                for(int j = 0; j < 8; j++){
                    board.stones[i][j] = 0;
                }
            }
            board.stones[3][3] = board.stones[4][4] = -1;
            board.stones[3][4] = board.stones[4][3] = 1;
            board.color = true;
            game.player1.setBackground(Color.green);
            game.player2.setBackground(Color.black);
            board.repaint();
        }
    }
}
