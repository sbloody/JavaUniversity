import java.util.Scanner;


public class Update implements Runnable
{
   private Clock clock;
   
   public Update(Clock clock)
   {
      this.clock=clock;
   }
   
   public void run()
   {
      Scanner input=new Scanner(System.in);
      int hour=input.nextInt();
      int minute=input.nextInt();
      int second=input.nextInt();
      clock.set(hour, minute, second);
   }
}
