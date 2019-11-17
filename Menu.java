import javax.swing.*;
import java.awt.event.*;
public class Menu implements ActionListener
{
    JButton button;
    public void actionPerformed(ActionEvent event)
    {
        button.setText("I'have been clicked!");
    }
    public void go()
    {
        JFrame frame = new JFrame();
        button = new JButton("click me");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(button);
        frame.setSize(200,200);
        frame.setVisible(true);
        button.addActionListener(this);
    }
    public static void main(String args[])
    {
       Menu m = new Menu();
       m.go();
    }
}