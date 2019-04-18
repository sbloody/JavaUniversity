public class BusStop
{
   public static void main(String args[])
   {
      Bus bus = new Bus();
      System.out.println("Bus ID: " + bus.getId());
      System.out.println();
      BusPassenger[] passengers = new BusPassenger[4];
      passengers[0] = new BusPassenger("Allan");
      passengers[1] = new BusPassenger("Britt");
      passengers[2] = new BusPassenger("Carl");
      passengers[3] = new BusPassenger("Dee");

      for (int i = 0; i < passengers.length; i++)
      {
         System.out.println(passengers[i] + " is getting in");
         passengers[i].getIn(bus);
      }
      System.out.println(passengers[2] + " is getting out");
      passengers[2].getOut();
      System.out.println();
      System.out.println(bus);
   }
}