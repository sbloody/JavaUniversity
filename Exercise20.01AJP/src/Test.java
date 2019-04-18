import junit.framework.TestCase;


public class Test extends TestCase
{

   protected void setUp() throws Exception
   {
      super.setUp();
   }

   protected void tearDown() throws Exception
   {
      super.tearDown();
   }

   public void testBisection()
   {
      Bisection b=new Bisection();
      Function sinus=new Function()
      {
         
         @Override
         public double f(double x)
         {
            return (Math.sin(x));
         }
      };
      assertEquals(3.14,b.bisectionRec(sinus, (Math.PI/2), (3*Math.PI)/2, 0.0001));
   }
}
