import java.io.*;

public class cpuloadfile {
  public static String CPUfile() throws InterruptedIOException {
    String conf = "";
    try {
      File log = new File("logs\\CPULOG.txt");
      if (log.createNewFile()) {
        System.out.println("File created: " + log.getName());
        conf = "File created:  " + log.getName();
      } else {
        System.out.println("File already exists.");
        conf = "File already exsists";
      }
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    return conf;

  }
}