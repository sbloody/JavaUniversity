public class CookieJar
{
   private int numberOfCookies;
   private int limit;
   private int numberOnPlate;

   public CookieJar(int numberOfCookies, int limit, int numberOnPlate)
   {
      this.numberOfCookies = numberOfCookies;
      this.limit = limit;
      this.numberOnPlate=numberOnPlate;
   }

   public synchronized void BakeCookie(String employee)
   {
      while (numberOfCookies >= limit)
         try
         {
            wait();
         }
         catch (InterruptedException e)
         {

         }
      numberOfCookies+=numberOnPlate;
      System.out.println(employee + " bakes cookies and now there are: "
            + numberOfCookies);
      notifyAll();

   }

   public synchronized void EatCookie(String who)
   {
      while (numberOfCookies <= 0)
         try
         {
            wait();
         }
         catch (InterruptedException e)
         {

         }
      numberOfCookies--;
      System.out.println(who + " just ate a cookie and now there are: "
            + numberOfCookies);
      notifyAll();
   }
}
