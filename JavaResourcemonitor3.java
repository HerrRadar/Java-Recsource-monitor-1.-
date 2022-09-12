import java.io.*;
import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.nio.file.AccessDeniedException;
import java.io.FileWriter;  
import java.io.IOException;  
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime; 

public class JavaResourcemonitor3 {
    public static void main(String[] args) throws InterruptedException 
    {
        try {
          File myObj = new File("logs\\CPULOG.txt");
          if (myObj.createNewFile()) {
            System.out.println("File created: " + myObj.getName());
          } 
          else {
            System.out.println("File already exists.");
          }
        } 
        catch (IOException e) {
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
        try {        
            DateTimeFormatter tid = DateTimeFormatter.ofPattern("HH:mm:ss");  
            LocalDateTime nu = LocalDateTime.now(); 
            
            FileWriter myWriter = new FileWriter("CPULOG.txt", true);
            BufferedWriter bw = new BufferedWriter(myWriter);
            PrintWriter out = new PrintWriter(bw);
            out.write(System.getProperty( "line.separator"));
            out.write("CPU Usage:    " + CPULOAD + "%    Time:" + (tid.format(nu))+ "");
            out.close();
              }
            catch (IOException o) {
            System.out.println("An error occurred.");
            o.printStackTrace();
        } 
    }
    }
}
