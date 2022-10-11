import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Dimension;
import javax.swing.SwingUtilities;

import JavaResourcemonitor3.JRmCPU;

public class MainGUI extends JPanel implements ActionListener 
{//Variables
JFrame JRMGUI;
JButton Next;
JButton Previous;
JButton Toggle;
JButton CPU;
JButton Reset;
JButton Open_in_explorer;

MainGUI()
{   //Frame Settings
    JRMGUI=new JFrame();
    JRMGUI.setSize (1280,720);
    JRMGUI.setLayout(null);
    JRMGUI.setBackground(Color.BLACK);
    JRMGUI.setVisible(true);
    JRMGUI.setMaximizedBounds(new Rectangle(0,0 , 1280, 720)); 
    JRMGUI.setMinimumSize(new Dimension(1280,720));
    JRMGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    //Button Settings
    Next = new JButton("Next");
    Next.setFont(new Font("Courier New", Font.BOLD, 15));
    Next.setSize(100,50);
    Next.setLocation(1,630);
    Next.setBackground(Color.blue);
    Next.setForeground(Color.white);
    Next.setBorderPainted(false);
    Next.addActionListener(this);
    JRMGUI.add (Next);

    Previous = new JButton("Prev");
    Previous.setFont(new Font("Courier New", Font.BOLD, 15));
    Previous.setSize(100,50);
    Previous.setLocation(201,630);
    Previous.setBackground(Color.blue);
    Previous.setForeground(Color.white);
    Previous.setBorderPainted(false);
    Previous.addActionListener(this);
    JRMGUI.add (Previous);

    Reset = new JButton("Reset");
    Reset.setFont(new Font("Courier New", Font.BOLD, 15));
    Reset.setSize(100,50);
    Reset.setLocation(101,630);
    Reset.setBackground(Color.blue);
    Reset.setForeground(Color.white);
    Reset.setBorderPainted(false);
    Reset.addActionListener(this);
    JRMGUI.add (Reset);

    Toggle = new JButton("Toggle Chart");
    Toggle.setFont(new Font("Courier New", Font.BOLD, 15));
    Toggle.setSize(300,50);
    Toggle.setLocation(1,579);
    Toggle.setBackground(Color.blue);
    Toggle.setForeground(Color.white);
    Toggle.setBorderPainted(false);
    Toggle.addActionListener(this);
    JRMGUI.add (Toggle);

    CPU = new JButton();
    CPU.setFont(new Font("Courier New", Font.BOLD, 15));
    CPU.setSize(200,200);
    CPU.setLocation(0,0);
    CPU.setBackground(Color.blue);
    CPU.setForeground(Color.white);
    CPU.setVisible(false);
    JRMGUI.add (CPU);
    
}
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==Toggle)
        {
            if(CPU.isVisible()==true)
            {
            CPU.setVisible(false);
            }
            else
            {
            CPU.setVisible(true);
            }
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                main(); 
            }
        });
    }
    private static void main() {
        System.out.println("Created GUI on EDT? "+
        SwingUtilities.isEventDispatchThread());
        new MainGUI();
        Println(CPULOAD.JRmCPU);
    }
}
