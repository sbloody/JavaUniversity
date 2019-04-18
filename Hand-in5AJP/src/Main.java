public class Main
{

   public static void main(String[] args)
   {
      AirportQueue airport = new AirportQueue<>();

      new Thread(new Guide(airport)).start();

      new Thread(new PassportController(airport, "US")).start();
      new Thread(new PassportController(airport, "BG")).start();

   }

}
