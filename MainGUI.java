import org.knowm.xchart.*;

public class MainGUI {

  public interface CPUinterface { //interface
    public void cpuloadfile();
    public void cpufile();
    public void cpucal();
    public double CPULOADcal();
  }

  class Main //Main thread
  {
    public static < CPU > void main(String[] args) throws InterruptedException {
      // variables for the chart
      cpucal myCPU = new cpucal();
      double x1 = 0.0;
      double x2 = 0.0;
      double x3 = 0.0;
      do {
        x1 = myCPU.CPULOADcal();
        Thread.sleep(1000);
        x2 = myCPU.CPULOADcal();
        Thread.sleep(1000);
        x3 = myCPU.CPULOADcal();
        break;
      } while (true);
      double[] xData = new double[] {
        0.0,
        30.0,
        60.0
      };
      double[] yData = new double[] {
        x1,
        x2,
        x3
      };
      System.out.println("Running program:  " + "x1 value:  " + x1 + "x2 value:  " + x2 + "x3 value:  " + x3);
      // creating the Chart
      XYChart chart = QuickChart.getChart("chart", "X", "Y", "y(x)", xData, yData);

      new SwingWrapper < > (chart).displayChart();
    }
  }
}