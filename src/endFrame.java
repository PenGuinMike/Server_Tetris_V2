import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class endFrame extends JFrame {
    int FrameW=400,FrameH=330;
    private Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    private JButton jbtnreStart;
    private JButton jbtnExit;
    public endFrame (){
        init ();
    }

    private void init(){
        this.setTitle("Server_end");
        this.setLayout(null);
        this.setBounds(dim.width/2-FrameW/2,dim.height/2-FrameH/2,FrameW,FrameH);
        jbtnreStart = new JButton("Restart");
        jbtnExit = new JButton("Exit");
        jbtnreStart.setBounds(85,135,85,45);
        jbtnExit.setBounds(205,135,85,45);
        jbtnExit.setOpaque(true);
        jbtnExit.setBackground(new Color(166, 101, 151));
        this.add(jbtnreStart);
        this.add(jbtnExit);
        jbtnreStart.setEnabled(false);
        jbtnreStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Server_ShowIP ssIp = new Server_ShowIP();
                ssIp.setVisible(true);
                endFrame.this.dispose();
            }
        });


        jbtnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

    }
}
