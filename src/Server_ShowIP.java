import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Server_ShowIP  extends JFrame{
    private InetAddress ipadrs;
    private JLabel jlbIp;
    private JButton jbtnStart;
    int FrameW=400,FrameH=330;
    private Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    public Server_ShowIP(){
        try {
            ipadrs = InetAddress.getLocalHost();
        }catch (UnknownHostException e){
            javax.swing.JOptionPane.showMessageDialog(null,"Error one "+e.toString());
        }catch (IOException ioe){
            javax.swing.JOptionPane.showMessageDialog(null,"Error two "+ioe.toString());
        }catch (Exception yee){
            javax.swing.JOptionPane.showMessageDialog(null,"Error three "+yee.toString());
        }
        init();
    }
    private void init(){
        String strIp = ipadrs.getHostAddress();
        this.setTitle("Server's IP");
        this.setLayout(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setBounds(dim.width/2-FrameW/2,dim.height/2-FrameH/2,FrameW,FrameH);
        jlbIp = new JLabel(strIp);
        jbtnStart = new JButton("Start");
        jlbIp.setBounds(80,80,350,35);
        jbtnStart.setBounds(150,150,85,45);
        Font f = new Font(null, Font.PLAIN, 30);
        jlbIp.setFont(f);
        this.add(jlbIp);
        this.add(jbtnStart);

        jbtnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Tetris_Frame tf=new Tetris_Frame(Server_ShowIP.this);
                tf.setVisible(true);
//                Server_ShowIP.this.dispose();
                Server_ShowIP.this.setVisible(false);
            }
        });
    }
}
