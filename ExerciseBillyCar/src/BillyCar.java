
public class BillyCar
{
   private int state;
   
   
   public BillyCar(int state)
   {
      this.state=state;
   }
   
   public void push()
   {
      switch(this.state)
      {
         case 1: System.out.println("Car moves forward and car headlight shines");
         break;
         case 2: System.out.println("Car stops and headlight goes out");
         break;
         case 3: System.out.println("Headlight shines");
         break;
         case 4: System.out.println("Headlight goes out");
         break;
         case 5: System.out.println("Car runs backward with its headlight shining");
         break;
         case 6: System.out.println("Car stops and headlight goes out");
         break;
         case 7: System.out.println("Headlight shines");
         break;
         case 8: System.out.println("Headlight goes out");
         break;
         case 9: System.out.println("Car runs forward with its headlight shining");
         default: System.out.println("No state");
            break;
      }
   }
}
