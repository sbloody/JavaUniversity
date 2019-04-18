
public class CookieEater implements Runnable
{
   private String name;
   private CookieJar cookie;
   
   public CookieEater(String name, CookieJar cookie)
   {
      this.name=name;
      this.cookie=cookie;
   }
   
   private void timeForEatingTheCookie()
   {
      try
      {
         Thread.sleep(2000);
      }
      catch (InterruptedException e)
      {
         // ...
      }
   }

   @Override
   public void run()
   {
      while(true)
      {
         cookie.EatCookie(name);
         timeForEatingTheCookie();
      }
      
   }
   
   
}
