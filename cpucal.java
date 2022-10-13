import java.io.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class cpucal
{

      public double CPULOADcal() throws InterruptedException
      {
        threadnano CPUdata = new threadnano();
        Long ThreadTime1 = (long)10;
        Long Nano1 = (long)10;
        Long ThreadTime2 = (long)10;
        Long Nano2 = (long)10;
        while(true)
        { 
           ThreadTime1 = CPUdata.Thread1();
           Nano1 = CPUdata.Nano1();
           ThreadTime2 = CPUdata.Thread2();
           Nano2 = CPUdata.Nano2();
          long CPUThreadTime = ThreadTime1 - ThreadTime2;
          long CPUNanoTime = Nano1 - Nano2;

          {
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
          return CPULOAD;
      }
    }
  }
}
