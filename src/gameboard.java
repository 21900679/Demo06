import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

public class gameboard extends JPanel implements MouseListener {
    boolean color = true;   //true(black), false(white)
    int[][] stones = new int[8][8];     // 1 (black), -1 (white), 3 (놓을 수 있음)
    Color temp;
    int count, check, finish;
    static boolean checkchat = false;
    static String sendPoint;
    gameboard(){
        setBounds(50, 50, 600, 600);
        setBackground(new Color(218, 167, 96));
        setBorder(new LineBorder(Color.black, 3));

        stones[3][3] = stones[4][4] = -1;
        stones[3][4] = stones[4][3] = 1;

        addMouseListener(this);
    }
    public void paint(Graphics g){
        super.paint(g);

        for(int i = 0; i < 9; i++){
            g.drawLine(0, 75 * i, 600, 75 * i);
            ((Graphics2D) g).setStroke(new BasicStroke(1.0f));
            g.drawLine(75 * i, 0, 75 * i, 600);
        }
        new check(stones, color);

        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if(stones[i][j] == 1){
                    game.num1++;
                    g.setColor(Color.black);
                    g.fillOval(i * 75, j * 75, 75, 75);
                }
                else if(stones[i][j] == -1){
                    game.num2++;
                    g.setColor(Color.white);
                    g.fillOval(i * 75, j * 75, 75, 75);
                }
                else if(stones[i][j] == 3){
                    g.setColor(Color.gray);
                    g.drawOval(i * 75, j * 75, 75, 75);
                    check++;
                }
                else
                    count++;    // 다 stones가 찼을 경우
            }
        }
        game.score1.setText("● X " + game.num1);
        game.score2.setText("○ X " + game.num2);
        if((count + check) == 0){       // 자리가 다 찼을 때,
            new result(this);
        }
        else if(game.num1 == 0 || game.num2 == 0){
            new result(this);
        }
        else if(check == 0 && finish != 2){        // 놓을 수 있는 자리가 없을 때,
            new nomove();
            finish++;
            temp = game.btn1;
            game.btn1 = game.btn2;
            game.btn2 = temp;
            game.player1.setBackground(game.btn1);
            game.player2.setBackground(game.btn2);
            color = !color;
            if(finish == 2){        //  black, white 둘다 놓을 수 있는 자리가 없을 때,
                new result(this);
            }
            repaint();
        }
        else{
            finish = 0;
        }
        game.num1 = game.num2 = count = check = 0;
    }
    @Override
    public void mouseClicked(MouseEvent e) {    //마우스 버튼 클릭

    }

    @Override
    public void mousePressed(MouseEvent e) {    //마우스 버튼 누름

        if(stones[e.getX() / 75][e.getY() / 75] == 3){
            sendPoint = e.getX()/75 + "," + e.getY()/75;
            try{
                MultichatClient.ClientSender.out.writeUTF(sendPoint);
            }catch (IOException a){}

            temp = game.btn1;
            game.btn1 = game.btn2;
            game.btn2 = temp;
            game.player1.setBackground(game.btn1);
            game.player2.setBackground(game.btn2);
            color = !color;
            if(color){
                stones[e.getX() / 75][e.getY() / 75] = -1;
            }
            else
                stones[e.getX() / 75][e.getY() / 75] = 1;
            new change(stones, e.getX() / 75, e.getY()/ 75);
            repaint();
        }
    }
    public void readpaint(String sendPoint){
        try {
            String[] read = sendPoint.split(",");
            int readX = Integer.parseInt(read[0]);
            int readY = Integer.parseInt(read[1]);
            if(stones[readX][readY] != -1 && stones[readX][readY] != 1) {
                temp = game.btn1;
                game.btn1 = game.btn2;
                game.btn2 = temp;
                game.player1.setBackground(game.btn1);
                game.player2.setBackground(game.btn2);
                color = !color;
                if (color) {
                    stones[readX][readY] = -1;
                } else
                    stones[readX][readY] = 1;
                new change(stones, readX, readY);
                repaint();
            }
        }catch (Exception e){}
    }

    @Override
    public void mouseReleased(MouseEvent e) {   //마우스 버튼을 놓음

    }

    @Override
    public void mouseEntered(MouseEvent e) {    //마우스가 윈도우 안에 들어옴

    }

    @Override
    public void mouseExited(MouseEvent e) {     //마우스가 윈도우 밖으로 나감

    }
}
