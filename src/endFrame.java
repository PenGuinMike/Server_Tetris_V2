import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class endFrame extends JFrame {
    int FrameW=400,FrameH=330;
    private Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    private JLabel jbtnreStart;
    private JButton jbtnExit;
    public endFrame (){
        init ();
    }

    private void init(){
        this.setTitle("Server_end");
        this.setLayout(null);
        this.setBounds(dim.width/2-FrameW/2,dim.height/2-FrameH/2,FrameW,FrameH);
        jbtnreStart = new JLabel("the game is over");
        jbtnExit = new JButton("Exit");
        jbtnreStart.setBounds(85,85,150,45);
        jbtnExit.setBounds(105,135,85,45);
        jbtnExit.setOpaque(true);
        jbtnExit.setBackground(new Color(166, 101, 151));
        this.add(jbtnreStart);
        this.add(jbtnExit);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jbtnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

    }
}
