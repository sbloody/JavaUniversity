
public class TeamMemberThread implements Runnable
{
   private PizzaMethods member;
   
   public TeamMemberThread(PizzaMethods member)
   {
      this.member=member;
   }

   @Override
   public void run()
   {
      while(true)
      {
         member.getAPizzaSlice();
         program();
      }
      
   }
   
   private void program()
   {
     
      try
      {
         Thread.sleep(2000);
      }
      catch (InterruptedException e)
      {

      }
   }
   
   
}
