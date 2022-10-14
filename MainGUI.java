import org.knowm.xchart.*;

public class MainGUI {

  public interface CPUinterface { // interface
    public void cpuloadfile();

    public void cpufile();

    public void cpucal();

    public double CPULOADcal();
  }

  class Main // Main thread
  {
    public static <CPU> void main(String[] args) throws InterruptedException {
      // variables for the chart
      cpucal myCPU = new cpucal();
      int numValues = 10;
      double[] yValues = new double[numValues];
      double[] xLabels = new double[numValues];
      double[] yData = new double[numValues];
      for (int i = 0; i < numValues; i++) {
        double load = myCPU.CPULOADcal();
        if (load > 100) {
          load = load % 100;
        }
        yValues[i] = load;
        xLabels[i] = 30 * i; // starts at 0, goes up in multiples of 30
        yData[i] = yValues[i];
        // Thread.sleep(1000);
      }
      System.out.println("Running program: ");
      for (int j=0; j < numValues; j++) {
        System.out.println("x" + (j + 1) + " value: " + yValues[j] + "\t");
      } // + "x1 value: " + x1 + "x2 value: " + x2 + "x3 value: " + x3);
        // creating the Chart
      XYChart chart = QuickChart.getChart("chart", "X (Time)", "Y (CPU Load)", "x(y) CPU Load per sec", xLabels, yData);

      new SwingWrapper<>(chart).displayChart();
    }
  }
}