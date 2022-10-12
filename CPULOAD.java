import java.io.*;
import java.lang.management.*;
import java.nio.file.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import org.knowm.xchart.*;

public class CPULOAD 
{

public interface CPUinterface {
public void CPULOADfile();
public void CPUcal();
public void Nano1();
}

}
class CPULOADfile
{
public static void CPUfile() throws InterruptedIOException
{
    try {
        File log = new File("logs\\CPULOG.txt");
        if (log.createNewFile()) {
          System.out.println("File created: " + log.getName());
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
}
}


class Nano1
{
  public static void Nano1()
  {
  ThreadMXBean ThreadBean1 = ManagementFactory.getThreadMXBean();
  {
  try
  {
 if (ThreadBean1.isThreadCpuTimeSupported())
      ThreadBean1.setThreadCpuTimeEnabled(true);
  else
      throw new AccessDeniedException("");
}
catch (AccessDeniedException e)
{
System.out.println("CPU Usage monitoring is not available!");
System.exit(0);
}
      while(true)
      {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
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
          long Nano1 = System.nanoTime();
          long ThreadTime1 = ThreadBean1.getCurrentThreadCpuTime();
        }
      }
  }
}

class Nano2
{
  public static void Nano2()
  {
  ThreadMXBean ThreadBean2 = ManagementFactory.getThreadMXBean();
  {
  try
  {
 if (ThreadBean2.isThreadCpuTimeSupported())
      ThreadBean2.setThreadCpuTimeEnabled(true);
  else
      throw new AccessDeniedException("");
}
catch (AccessDeniedException e)
{
System.out.println("CPU Usage monitoring is not available!");
System.exit(0);
}
      while(true)
      {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
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
          long Nano2 = System.nanoTime();
          long ThreadTime2 = ThreadBean2.getCurrentThreadCpuTime();
        }
      }
  }
}

class CPUcal
{
public double CPULOADcal() throws InterruptedException
{
  Nano1 myNano1 = new Nano1();
  Nano1.Nano1();
  Nano2 myNano2 = new Nano2();
  Nano2.Nano2();
          long Nano1 = Nano1.Nano1();
          long Nano2 = Nano2.Nano2();
          long ThreadTime1 = Nano1.Nano1();
          long ThreadTime2 = Nano2.Nano2();

          long CPUNanoTime = Nano1 - Nano2;
          long CPUThreadTime = ThreadTime1 - ThreadTime2;
          long CPULOADdata = CPUNanoTime /  CPUThreadTime;
          System.out.println(CPULOADdata + "% usage" + "    " + Nano1 + "    " + ThreadTime1);

          double CPULOAD = (long)CPULOADdata;
      try 
      {        
          DateTimeFormatter tid = DateTimeFormatter.ofPattern("HH:mm:ss");  
          LocalDateTime nu = LocalDateTime.now(); 
          
          FileWriter myWriter = new FileWriter("logs\\CPULOG.txt", true);
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

class Main
{
public static <CPU> void main(String [] args) throws InterruptedException
{
      CPUcal myCPU = new CPUcal();
      myCPU.CPULOADcal();
      double x1 = myCPU.CPULOADcal();
      double x2 = x1;
      double x3 = x2;
      Thread.sleep(5000);
      double[] xData = new double[] { 60.0, 30.0, 0.0 };
      double[] yData = new double[] { x3 , x2 , x1 };
   
      // Create Chart
      XYChart chart = QuickChart.getChart("chart", "X", "Y", "y(x)", xData, yData);
   
      // Show it
      new SwingWrapper(chart).displayChart();
}
}