import java.lang.management.*;
import java.nio.file.*;

public class threadnano {
  public long Thread1() throws InterruptedException {
    ThreadMXBean ThreadBean1 = ManagementFactory.getThreadMXBean();
    {
      try {
        if (ThreadBean1.isThreadCpuTimeSupported())
          ThreadBean1.setThreadCpuTimeEnabled(true);
        else
          throw new AccessDeniedException("CPU Usage monitoring is not available!");
      } catch (AccessDeniedException e) {
        // System.out.println("CPU Usage monitoring is not available!");
        System.exit(1);
      }
      long ThreadTime1 = 1;
      while (true) {
        try {
          Thread.sleep(500);
        } catch (InterruptedException e) {
        }
        ThreadTime1 = ThreadBean1.getCurrentThreadCpuTime();
        Thread.sleep(10);
        if (ThreadTime1 == (long) 0) {
          return ThreadTime1 + 1;
        } else {
          return ThreadTime1;
        }

      }
    }
  }

  public long Nano1() {
    long Nano1 = System.nanoTime();
    return Nano1;
  }

  public long Thread2() throws InterruptedException {
    ThreadMXBean ThreadBean2 = ManagementFactory.getThreadMXBean();
    {
      try {
        if (ThreadBean2.isThreadCpuTimeSupported())
          ThreadBean2.setThreadCpuTimeEnabled(true);
        else
          throw new AccessDeniedException("");
      } catch (AccessDeniedException e) {
        System.out.println("CPU Usage monitoring is not available!");
        System.exit(1);
      }
      long ThreadTime2 = 1;
      while (true) {
        try {
          ThreadTime2 = ThreadBean2.getCurrentThreadCpuTime();
          Thread.sleep(15);
          if (ThreadTime2 == (long) 0) {
            return 1;
          } else {
            return ThreadTime2;
          }
        } catch (InterruptedException e) {
          return 1;
        }
      }
    }
  }

  public long Nano2() {
    long Nano2 = System.nanoTime();
    return Nano2;
  }
}