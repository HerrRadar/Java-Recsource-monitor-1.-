import java.io.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class cpucal
{

      public double CPULOADcal() throws InterruptedException
      {
        threadnano CPUdata = new threadnano();
        long ThreadTime1 = (long)10;
        long Nano1 = (long)10;
        long ThreadTime2 = (long)10;
        long Nano2 = (long)10;
        while(true)
        { 
           ThreadTime1 = CPUdata.Thread1();
           Nano1 = CPUdata.Nano1();
           Thread.sleep(500);
           ThreadTime2 = CPUdata.Thread2();
           Nano2 = CPUdata.Nano2();
          long CPUThreadTime = ThreadTime2 - ThreadTime1;
          long CPUNanoTime = Nano2 - Nano1;

          {
            System.out.println(""+CPUNanoTime+" :/: "+CPUThreadTime);
          long CPULOADdata = CPUNanoTime /  CPUThreadTime;
          System.out.println(CPULOADdata + "% usage" + "    " + Nano1 + "  " + Nano2 + "  Thread  " + ThreadTime1 + "  " + ThreadTime2);
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
          return CPULOAD;
      }
    }
  }
}
