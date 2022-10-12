import javax.swing.*;
import javax.swing.JFrame;
import java.awt.event.*;
import java.awt.Point;
import java.awt.Color;
import java.awt.*;
import java.io.File;  
import java.io.FileWriter;
import java.io.IOException;  // Import the IOException class to handle errors

public class SwingGame2 implements KeyListener, ActionListener
{
    JFrame f;
    JButton a;//Character
    JButton q;//Up
    JButton w;//Down
    JButton s;//Death Wall
    JButton r;//Right
    JButton t;//Reset
    JButton y;//Mode
 	JButton u;//Score
    JButton i;//River
    JButton o;//River
    JButton p;//River
    JButton e;//Bridge
    JButton d;//Bridge 2
    JButton l;//Bridge 3
    JButton g;//Bridge 4
    JButton h;//Bridge 5
    JButton j;//Bridge 6
    JButton k;//Bridge 7
	JButton z;
	JButton x;
	JButton c;
	JButton v;
    int Score =(0);
    Icon Miner = new ImageIcon("C:\\Miner3.png");

    SwingGame2()
    {
        f=new JFrame();
        f.setSize (1920,1080);
        f.setLayout (null);
        f.setVisible (true);

        a = new JButton("Miner");
        a.setIcon(new ImageIcon("Miner3.png"));
        a.setSize (50,50);
        a.setLocation(100,100);
		a.setBackground(Color.white);
        a.setBorderPainted(false);
        a.setContentAreaFilled(false);
        a.setFocusPainted(false);
        a.setOpaque(false);
        f.add (a);

        e = new JButton("Bridge");
        e.setFont(new Font("Arial", Font.BOLD, 15));
        e.setBounds (375,350,250,100);
        e.setBackground (Color.gray);
		e.setForeground(Color.white);
        f.add (e);
        d = new JButton("Bridge2");
		d.setFont(new Font("Arial", Font.BOLD, 15));
		d.setBounds (875,200,250,100);
		d.setBackground (Color.gray);
		d.setForeground(Color.white);
        f.add (d);
        g = new JButton("Bridge3");
		g.setFont(new Font("Arial", Font.BOLD, 15));
		g.setBounds (875,500,250,100);
		g.setBackground (Color.gray);
		g.setForeground(Color.white);
        f.add (g);
        h = new JButton("Bridge");
		h.setFont(new Font("Arial", Font.BOLD, 15));
		h.setBounds (375,350,250,100);
		h.setBackground (Color.gray);
		h.setForeground(Color.white);
        f.add (h);
        j = new JButton("Bridge");
		j.setFont(new Font("Arial", Font.BOLD, 15));
		j.setBounds (375,350,250,100);
		j.setBackground (Color.gray);
		j.setForeground(Color.white);
        f.add (j);
        k = new JButton("Bridge");
		k.setFont(new Font("Arial", Font.BOLD, 15));
		k.setBounds (375,350,250,100);
		k.setBackground (Color.gray);
		k.setForeground(Color.white);
        f.add (k);
        z = new JButton("Bridge");
		z.setFont(new Font("Arial", Font.BOLD, 15));
		z.setBounds (1400,150,250,100);
		z.setBackground (Color.gray);
		z.setForeground(Color.white);
        f.add (z);
        x = new JButton("Bridge");
		x.setFont(new Font("Arial", Font.BOLD, 15));
		x.setBounds (1400,350,250,100);
		x.setBackground (Color.gray);
		x.setForeground(Color.white);
        f.add (x);
        c = new JButton("Bridge");
		c.setFont(new Font("Arial", Font.BOLD, 15));
		c.setBounds (1400,550,250,100);
		c.setBackground (Color.gray);
		c.setForeground(Color.white);
        f.add (c);
        v = new JButton("");
		v.setFont(new Font("Arial", Font.BOLD, 15));
		v.setBounds (0,800,1920,10);
		v.setBackground (Color.gray);
		v.setForeground(Color.white);
        f.add (v);
        q = new JButton("UP");
       	q.setFont(new Font("Arial", Font.BOLD, 10));
       	q.setBounds (910,810,100,100);
       	q.addActionListener(this);
       	q.setBackground (Color.black);
       	q.setForeground(Color.white);
        f.add (q);
        w = new JButton("DOWN");
        w.setFont(new Font("Arial", Font.BOLD, 10));
        w.setBounds (910,910,100,100);
        w.addActionListener(this);
        w.setBackground (Color.black);
        w.setForeground(Color.white);
        f.add (w);
        s = new JButton("Death Wall");
        s.setFont(new Font("Arial", Font.BOLD, 10));
        s.setSize (20,800);
        s.addActionListener(this);
        s.setBackground (Color.red);
        s.setForeground(Color.white);
        f.add (s);
        t = new JButton("RESET");
		t.setFont(new Font("Arial", Font.BOLD, 10));
		t.setBounds (310,910,100,100);
		t.addActionListener(this);
		t.setBackground (Color.black);
		t.setForeground(Color.white);
        f.add (t);
        r = new JButton("RIGHT");
        r.setFont(new Font("Arial", Font.BOLD, 10));
        r.setBounds (1010,910,100,100);
        r.addActionListener(this);
        r.setBackground (Color.black);
        r.setForeground(Color.white);
        f.add (r);
        y = new JButton("MODE");
        y.setFont(new Font("Arial", Font.BOLD, 10));
        y.setBounds (310,810,100,100);
        y.addActionListener(this);
        y.setBackground (Color.black);
        y.setForeground(Color.white);
        f.add (y);
        u = new JButton("Score: " +Score);
        u.setFont(new Font("Arial", Font.BOLD, 30));
        u.setBounds (10,810,300,200);
        u.addActionListener(this);
        u.setBackground (Color.black);
        u.setForeground(Color.white);
        f.add (u);
        i = new JButton("River of death");
        i.setFont(new Font("Arial", Font.BOLD, 15));
        i.setBounds (400,0,200,800);
        i.setBackground (Color.orange);
        i.setForeground(Color.white);
        f.add (i);
        o = new JButton("River of Death");
		o.setFont(new Font("Arial", Font.BOLD, 15));
		o.setBounds (900,0,200,800);
		o.setBackground (Color.orange);
		o.setForeground(Color.white);
        f.add (o);
        p = new JButton("River of Death");
		p.setFont(new Font("Arial", Font.BOLD, 15));
		p.setBounds (1400,0,200,800);
		p.setBackground (Color.orange);
		p.setForeground(Color.white);
        f.add (p);

    }
    public void actionPerformed(ActionEvent e)
    {
		Point ps = a.getLocation();
		Point ws = s.getLocation();
		int X2 = ws.x;
		int Y2 = ws.y;
		int X = ps.x;
		int Y = ps.y;
		if(e.getSource()==q )//UP
		{
			a.setLocation(X,Y-50);
			System.out.println("X coordinates" +X +"  Y Coordinates" +Y);
		}
		if(e.getSource()==w )//DOWN
		{
			a.setLocation(X,Y+50);
			System.out.println("X coordinates" +X +"  Y Coordinates" +Y);
		}
		if(e.getSource()==w || e.getSource()==q || e.getSource()==r)//Death Wall
		{
			s.setLocation(X2+25,0);
			System.out.println("Death wall X coordinates" +X2 +"  Death wall Y Coordinates" +Y2);
		}
		if(e.getSource()==r )//RIGHT
		{
			a.setLocation(X+50,Y);
			System.out.println("X coordinates" +X +"  Y Coordinates" +Y);
		}
		if(e.getSource()==t )//RESET
		{
			a.setLocation(200,400);
			s.setLocation(0,0);
			Score = 0;
			u.setText("Score:test " +Score);
			System.out.println("X coordinates" +X +"Y Coordinates" +Y);
		}
		if(e.getSource()==y )//MODE (Beta)
		{

		}
		if(e.getSource()==w || e.getSource()==q || e.getSource()==r)//Score machine
		{
			if(X>=600 && X<=900)
			{
				Score = 1;
				u.setText("Score: " +Score);
				System.out.println(Score);
			}
			else if (X>=900 && X<=1400)
			{
				Score = 2;
				u.setText("Score: " +Score);
				System.out.println(Score);
			}
			else if (X>1400)
			{
				Score = 3;
				u.setText("Score: " +Score);
				System.out.println(Score);
			}
			else
			{
			}
		}


		if(X<=X2)// retry command
		{
			u.setText("Failed,Try again?");
			if(e.getSource()==u)
			{
				s.setLocation (0,0);
				a.setLocation (200,400);
				u.setText("Score: " +Score);
			}
		}
		// death detectors. There is some issues here that i need to fix, but its not a	 priority.
		if(X>=350 && X<=550)
		{
			if(Y>=450 || Y<=300)
			{
			a.setLocation(200,400);
			s.setLocation(0,0);
			Score = 0;
			u.setText("Score: " +Score);
			System.out.println("You Died!");
			System.out.println("X coordinates" +X +"Y Coordinates" +Y);
			}
		}
		if(X >=875 && X<=1010)
		{
			if(Y>=200 || Y<=400)
			{
			a.setLocation(200,400);
			s.setLocation(0,0);
			Score = 0;
			u.setText("Score: " +Score);
			System.out.println("You Died!");
			System.out.println("X coordinates" +X +"Y Coordinates" +Y);
			}
		}
		if(X>=1350 && X<=1510)
		{
			if(Y>=350 || Y<=200)
			{
			a.setLocation(200,400);
			s.setLocation(0,0);
			Score = 0;
			u.setText("Score: " +Score);
			System.out.println("You Died!");
			System.out.println("X coordinates" +X +"Y Coordinates" +Y);
			}
		}
    }
	{
		try {
		  File myObj = new File(".\filename.txt");
		  System.out.println(myObj.toPath());
		  if (myObj.createNewFile()) {
			System.out.println("File created: " + myObj.getName());
		  } else {
			System.out.println("File already exists.");
		  }
		} catch (IOException e) {
		  System.out.println("An error occurred.");
		  e.printStackTrace();
		}
	}
	{
		try {
		  FileWriter myWriter = new FileWriter("filename.txt");
		  myWriter.write("Files in Java might be tricky, but it is fun enough!");
		  myWriter.close();
		  System.out.println("Successfully wrote to the file.");
		} catch (IOException e) {
		  System.out.println("An error occurred.");
		  e.printStackTrace();
		}
	  }
    public static void main ( String args [ ])
    {
        new SwingGame2();
    }
}
