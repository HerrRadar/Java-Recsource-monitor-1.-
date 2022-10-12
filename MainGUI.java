import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Dimension;
import org.knowm.xchart.*;
import java.io.*;
import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.nio.file.AccessDeniedException;
import java.io.FileWriter;  
import java.io.IOException;  
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.time.LocalDateTime; 

public class MainGUI implements ActionListener, SwingWorker<Boolean, double[]>
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
    
    public static void main(String[] args) throws Exception, InterruptedException
    {
        new MainGUI();
        try {
            File myObj = new File("logs\\CPULOG.txt");
            if (myObj.createNewFile()) {
              System.out.println("File created: " + myObj.getName());
            } 
            else {
              System.out.println("File already exists.");
            }
          } 
          catch (IOException e) 
          {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
          ThreadMXBean ThreadBean = ManagementFactory.getThreadMXBean();
  
            try
            {
           if (ThreadBean.isThreadCpuTimeSupported())
                ThreadBean.setThreadCpuTimeEnabled(true);
            else
                throw new AccessDeniedException("");
      }
      catch (AccessDeniedException e)
      {
          System.out.println("CPU Usage monitoring is not available!");
          System.exit(0);
      }
      long lastThreadTime = ThreadBean.getCurrentThreadCpuTime();
      Long lastNano = System.nanoTime();
          while(true)
          {
            Thread.sleep(1000);
              try
              {
                  int j = 0;
                  for (int i = 0; i < 20000000; i++)
                      j = (j + i) * j / 2;
                  Thread.sleep(10);
              }
              catch (InterruptedException e)
              {
              }
              Long Nano = System.nanoTime();
              Long ThreadTime = ThreadBean.getCurrentThreadCpuTime();
  
              Long CPULOAD = (Nano - lastNano)/(ThreadTime - lastThreadTime) ;
              System.out.println(CPULOAD + "% usage" + "    " + ThreadTime + "    " + Nano);
              lastThreadTime = ThreadTime;
              lastNano=Nano;
          try 
          {        
              DateTimeFormatter tid = DateTimeFormatter.ofPattern("HH:mm:ss");  
              LocalDateTime nu = LocalDateTime.now(); 
              
              FileWriter myWriter = new FileWriter("CPULOG.txt", true);
              BufferedWriter bw = new BufferedWriter(myWriter);
              PrintWriter out = new PrintWriter(bw);
              out.write(System.getProperty( "line.separator"));
              out.write("CPU Usage:    " + CPULOAD + "%    Time:" + (tid.format(nu))+ "");
              out.close();
                }
              catch (IOException o) 
              {
              System.out.println("An error occurred.");
              o.printStackTrace();
          } 
      }
    }
    class SwingWorkerRealTime {
 
        MySwingWorker mySwingWorker;
        SwingWrapper<XYChart> sw;
        XYChart chart;
       
        public static void main(String[] args) throws Exception {
       
          SwingWorkerRealTime swingWorkerRealTime = new SwingWorkerRealTime();
          swingWorkerRealTime.go();
        }
       
        private void go() {
       
          // Create Chart
          chart = QuickChart.getChart("SwingWorker XChart Real-time Demo", "Time", "Value", "randomWalk", new double[] { 0 }, new double[] { 0 });
          chart.getStyler().setLegendVisible(false);
          chart.getStyler().setXAxisTicksVisible(false);
       
          // Show it
          sw = new SwingWrapper<XYChart>(chart);
          sw.displayChart();
       
          mySwingWorker = new MySwingWorker();
          mySwingWorker.execute();
        }
       
          public MySwingWorker() {
       
            fifo.add(0.0);
          }
       
          @Override
          protected Boolean doInBackground() throws Exception {
       
            while (!isCancelled()) {
       
              fifo.add(fifo.get(fifo.size() - 1) + Math.random() - .5);
              if (fifo.size() > 500) {
                fifo.removeFirst();
              }
       
              double[] array = new double[fifo.size()];
              for (int i = 0; i < fifo.size(); i++) {
                array[i] = fifo.get(i);
              }
              publish(array);
       
              try {
                Thread.sleep(5);
              } catch (InterruptedException e) {
                // eat it. caught when interrupt is called
                System.out.println("MySwingWorker shut down.");
              }
       
            }
       
            return true;
          }
       
          @Override
          protected void process(List<double[]> chunks) {
       
            System.out.println("number of chunks: " + chunks.size());
       
            double[] mostRecentDataSet = chunks.get(chunks.size() - 1);
       
            chart.updateXYSeries("randomWalk", null, mostRecentDataSet, null);
            sw.repaintChart();
       
            long start = System.currentTimeMillis();
            long duration = System.currentTimeMillis() - start;
            try {
              Thread.sleep(40 - duration); // 40 ms ==> 25fps
              // Thread.sleep(400 - duration); // 40 ms ==> 2.5fps
            } catch (InterruptedException e) {
            }
       
          }
        }
    }
}