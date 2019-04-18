import java.util.Observable;

public class Main
{
   public static void main(String[] args)
   {
      Model model = new ModelManager();
      DataLogger dataLogger = new DataLogger(model, 3000);
      Thread loggerThread = new Thread(dataLogger, "DataLogger");
      loggerThread.start();
      TemperatureGUI view = new TemperatureGUI(model);
      view.setVisible(true);
   }
}