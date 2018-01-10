import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Server extends Thread {
    private InetAddress ipadrs;
    private ServerSocket servSocket;
    private Socket socket;
    private PrintStream outStream;
    private BufferedReader inputStream;
    private TetrisPane tp;
    private Player1 player1;
    private int socketNum;
    private Tool tool;

    public Server(TetrisPane tp1,Player1 p1,int num){
        tp=tp1;
        player1=p1;
        socketNum=num;
        System.out.println(socketNum);
        try{
            ipadrs = InetAddress.getLocalHost();
            servSocket = new ServerSocket(socketNum);
            socket = servSocket.accept();// step 1
        }catch (UnknownHostException e){
            javax.swing.JOptionPane.showMessageDialog(null,"Error a "+e.toString());
        }catch (IOException ioe){
            javax.swing.JOptionPane.showMessageDialog(null,"Error b "+ioe.toString());
        }catch (Exception yee){
            javax.swing.JOptionPane.showMessageDialog(null,"Error c "+yee.toString());
        }
    }
    public void run(){
        try {
            System.out.println(">____________<1");

            outStream = new PrintStream(socket.getOutputStream());// tep 1

            System.out.println(">____________<2");

            inputStream = new BufferedReader(new InputStreamReader(socket.getInputStream()));// step 1

            System.out.println(">____________<3");

            String str="";

            while (true){
                str=inputStream.readLine();
                System.out.println("in while "+str);
                if(str.equals("@cmd-bomb")){
                    tp.testfun("@cmd-bomb");
                }else {
                    player1.rec(str);
                }


            }

        }catch (Exception e){
            javax.swing.JOptionPane.showMessageDialog(null,"Error d "+e.toString());
        }
    }
    public void sendToclient(String command){
        try {
            outStream = new PrintStream(socket.getOutputStream());
            if(outStream != null){
                outStream.println(command);
            }else {
                System.out.println("Error there is a problem");
            }
        }catch (Exception e){
            javax.swing.JOptionPane.showMessageDialog(null,"Error e "+e.toString());
        }
    }


}
