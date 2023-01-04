import java.net.*;
import java.io.*;
import java.util.*;
public class MultichatServer {
    HashMap clients;    //key와 value를 가지는 것 clinet의

    MultichatServer(){
        clients = new HashMap();
        Collections.synchronizedMap(clients);   // hashMap이 순서대로 쌓이도록
    }
    public void start(){
        ServerSocket serverSocket = null;   //ㅅ버에서만 사용
        Socket socket = null;       //client

        try {
            serverSocket = new ServerSocket(7777);
            System.out.println("서버가 시작되었습니다.");

            while(true){
                socket = serverSocket.accept();     //client 받아들이겠다.
                System.out.println("["+socket.getInetAddress()+":"+socket.getPort()+"]"+"에서 접속하였습니다.");
                ServerReceiver thread = new ServerReceiver(socket);     //socket을 가지고
                thread.start();     //계속 실행
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    void sendToAll(String msg){
        Iterator it = clients.keySet().iterator();
        while(it.hasNext()){
            try{
                DataOutputStream out = (DataOutputStream) clients.get(it.next());
                out.writeUTF(msg);
            }catch (IOException e){}
        }
    }
    public static void main(String args[]){
        new MultichatServer().start();
    }
    class ServerReceiver extends Thread{
        Socket socket;
        DataInputStream in;
        DataOutputStream out;

        ServerReceiver(Socket socket){
            this.socket = socket;
            try{
                in = new DataInputStream(socket.getInputStream());
                out = new DataOutputStream(socket.getOutputStream());
            }catch (IOException e){}
        }
        public void run(){
            String name = "";

            try{
                name = in.readUTF();
                sendToAll("#"+name+"님이 들어오셨습니다.");

                clients.put(name, out);
                System.out.println("현재 서버접속자 수는 " + clients.size() + "입니다.");
                while(in!=null) {
                    sendToAll(in.readUTF());
                }
            } catch (IOException e){

            }finally{
                sendToAll("#"+name+"님이 나가셨습니다.");
                clients.remove(name);
                System.out.println("["+socket.getInetAddress()+":"+socket.getPort()+"]"+"에서 접속을 종료하였습니다.");
                System.out.println("현재 서버접속자 수는 "+ clients.size()+"입니다.");
            }
        }
    }
}
