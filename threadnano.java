import java.lang.management.*;
import java.nio.file.*;

public class threadnano 
{
  public long Thread1() throws InterruptedException
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
          long ThreadTime1 = ThreadBean1.getCurrentThreadCpuTime();
          Thread.sleep(10);
          if(ThreadBean1 .equals((long)0))
          {
          return ThreadTime1;
          }else
          {
          System.out.println(ThreadTime1/ThreadTime1);
          }
        }
      }
  }
  public Long Nano1()
  {
  Long Nano1 = System.nanoTime();
  return Nano1;
  }
  

public Long Thread2() throws InterruptedException
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
        Long ThreadTime2 = ThreadBean2.getCurrentThreadCpuTime();
        Thread.sleep(10);
        if(ThreadBean2 .equals((long)0))
        {
        return ThreadTime2;
        }else
        {
        System.out.println(ThreadTime2/ThreadTime2);
        }
      }
    }
  }
  public Long Nano2()
  {
    Long Nano2 = System.nanoTime();
    return Nano2;
  }
}
