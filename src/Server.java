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
//    public Server(TetrisPane tp1,int num){
    public Server(TetrisPane tp1,Player1 p1,int num){
        tp=tp1;
        player1=p1;
        socketNum=num;
        System.out.println(socketNum);
        tool = new Tool();
//        tool.setVisible(true);
        try{
            ipadrs = InetAddress.getLocalHost();
            servSocket = new ServerSocket(socketNum);
            tool.addMs("new socket succes"+"\n");
            socket = servSocket.accept();// step 1
            tool.addMs("socket accept succes"+"\n");
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
//            socket = servSocket.accept();// step 1
//            tool.addMs("socket accept succes"+"\n");
            outStream = new PrintStream(socket.getOutputStream());// tep 1
            inputStream = new BufferedReader(new InputStreamReader(socket.getInputStream()));// step 1
            sendToclient("test");// step 1
            String str="";
            while (!(str=inputStream.readLine()).equals("")){// step 1
                System.out.println(str);
            }
        }catch (Exception e){
            javax.swing.JOptionPane.showMessageDialog(null,"Error d "+e.toString());
        }
    }
    public void  sendToclient(String command){
        try {
            if(outStream != null){
//                outStream.println(command);
                outStream.write(command.getBytes());
            }else{
                System.out.println("87");
            }
        }catch (Exception e){
            javax.swing.JOptionPane.showMessageDialog(null,"Error e "+e.toString());
        }
    }

}
