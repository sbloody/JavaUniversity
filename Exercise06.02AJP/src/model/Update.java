package model;

import view.GuiTemperature;

public class Update implements Runnable
{
   private Clock clock;
   private GuiTemperature view;

   public Update(GuiTemperature view, Clock clock)
   {
      this.clock = clock;
      this.view = view;
   }

   public void run()
   {
      for (int i = 0; i < 5 * 60; i++)
      {
         view.showClock(clock.getCurrentTime());

         try
         {

            Thread.sleep(1000);

         }
         catch (InterruptedException e)
         {

         }
      }
   }
}
