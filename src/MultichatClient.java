import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.*;
import java.io.*;
import java.util.Scanner;
import java.awt.*;

public class MultichatClient {
    game myGame;
    public static void main(String args[]){
        new login();
    }
    public void ClientRun(){
        try{
            String serverIp = login.send_ip;
            Socket socket = new Socket(serverIp, 7777);
            System.out.println("서버에 연결되었습니다.");
            myGame = new game(login.send_name);
            Thread sender = new Thread(new ClientSender(socket,login.send_name, myGame.board));
            Thread receiver = new Thread(new ClientReceiver(socket));

            sender.start();
            receiver.start();
        }catch(ConnectException ce){
            ce.printStackTrace();
        }catch(Exception e){}
    }
    static class ClientSender extends Thread{
        Socket socket;
        static DataOutputStream out;
        String name;

        gameboard board;

        ClientSender(Socket socket, String name, gameboard board){
            this.board = board;
            this.socket = socket;
            try{
                out = new DataOutputStream(socket.getOutputStream());
                this.name = name;
            }catch (Exception e){}
        }

        @ Override
        public void run(){
            try{
                if(out!=null){
                    out.writeUTF(name);
                }
                while (out!=null) {
//                    if(gameboard.checkchat){
////                        System.out.println(gameboard.sendPoint);
//                        out.writeUTF(gameboard.sendPoint);
//                        gameboard.checkchat = false;
//                    }
                }
            }catch (IOException e){}
        }
    }
    class ClientReceiver extends Thread{
        Socket socket;
        DataInputStream in;
        ClientReceiver(Socket socket){
            this.socket = socket;
            try{
                in = new DataInputStream(socket.getInputStream());
            }catch (IOException e){}
        }

        @ Override
        public void run(){
            while(in!=null){
                try{
                    String str = in.readUTF();
//                    System.out.println("checking");
                    System.out.println(str);
                    myGame.board.readpaint(str);
                }catch (IOException e){
                    System.out.println("error!");
                }
            }
        }
    }
}
