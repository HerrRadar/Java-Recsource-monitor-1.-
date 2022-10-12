import org.knowm.xchart.*;

public class MainGUI 
{

public interface CPUinterface {//interface
public void cpufile();
public void cpucal();
public void hreadnano();
}


class Main //Main thread
{
public static <CPU> void main(String [] args) throws InterruptedException
{     // variables for the chart
      cpucal myCPU = new cpucal();
      myCPU.CPULOADcal();
      myCPU.CPUconfirm();
      double x1 = myCPU.CPULOADcal();
      double x2 = x1;
      double x3 = x2;
      double[] xData = new double[] { 60.0, 30.0, 0.0 };
      double[] yData = new double[] { x3 , x2 , x1 };
      
      // creating the Chart
      XYChart chart = QuickChart.getChart("chart", "X", "Y", "y(x)", xData, yData);
   
      // Initialising the chart
      new SwingWrapper<>(chart).displayChart();
      System.out.println(myCPU.CPUconfirm());
}
}
}