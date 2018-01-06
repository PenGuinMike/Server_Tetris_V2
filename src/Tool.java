import javax.swing.*;
import java.awt.*;

public class Tool extends JFrame {
    Container cp;
    private JTextArea jta = new JTextArea();
    private JScrollPane jsp = new JScrollPane(jta);

    public Tool (){
        init();
    }

    private void init(){
        cp=this.getContentPane();
        cp.setLayout(null);
        this.setBounds(200,200,400,600);
        cp.add(jsp);
        jta.setEditable(false);
    }
    public void addMs(String ms){
        jta.append(ms);
    }
}
