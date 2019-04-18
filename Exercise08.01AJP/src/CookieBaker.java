public class CookieBaker implements Runnable
{
   private String name;
   private CookieJar cookie;

   public CookieBaker(CookieJar cookie, String name)
   {
      this.cookie = cookie;
      this.name = name;
   }
   
   private void timeForBakingTheCookie()
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
         cookie.BakeCookie(name);
         timeForBakingTheCookie();
      }
      
   }
}
