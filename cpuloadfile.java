import java.io.*;

public class cpuloadfile
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
