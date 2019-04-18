import model.Clock;
import model.Temperature;
import model.Update;
import view.GuiTemperature;

public class GuiMain
{
   public static void main(String[] args)
   {
      Temperature temp = new Temperature();
      Clock clock = new Clock();
      

      GuiTemperature view = new GuiTemperature(temp, clock);
      Update updateClock = new Update(view, clock);
      Thread updateClockThread=new Thread(updateClock);
      updateClockThread.start();

      view.setVisible(true);
      System.out.println("MAIN ENDED");
   }
}
