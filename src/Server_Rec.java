import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Server_Rec extends Thread {
    private InetAddress ipadrs;
    private ServerSocket servSocket;
    private Socket socket;
    private PrintStream outStream;
    private BufferedReader inputStream;
    private Player1 p1;
    private int socketNum;
    //    public Server(int num){
    public Server_Rec(Player1 pO,int num){
        p1=pO;
        socketNum=num;
        try{
            ipadrs = InetAddress.getLocalHost();
            servSocket = new ServerSocket(socketNum);
            socket = servSocket.accept();// step 1
        }catch (UnknownHostException e){
            javax.swing.JOptionPane.showMessageDialog(null,"Error f "+e.toString());
        }catch (IOException ioe){
            javax.swing.JOptionPane.showMessageDialog(null,"Error g "+ioe.toString());
        }catch (Exception yee){
            javax.swing.JOptionPane.showMessageDialog(null,"Error h "+yee.toString());
        }
    }
    public void run(){
        try {
            outStream = new PrintStream(socket.getOutputStream());// tep 1
            inputStream = new BufferedReader(new InputStreamReader(socket.getInputStream()));// step 1
            sendToclient("");// step 1
            String str="";
            while (!(str=inputStream.readLine()).equals("")){// step 1

            }
        }catch (Exception e){
            javax.swing.JOptionPane.showMessageDialog(null,"Error i "+e.toString());
        }
    }
    public void  sendToclient(String command){
        try {
            if(outStream != null){
                outStream.println(command);
            }else{
                System.out.println("87");
            }
        }catch (Exception e){
            javax.swing.JOptionPane.showMessageDialog(null,"Error j "+e.toString());
        }
    }

}
