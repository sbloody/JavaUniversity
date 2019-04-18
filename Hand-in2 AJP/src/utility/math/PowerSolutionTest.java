package utility.math;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PowerSolutionTest
{

   @Before
   public void setUp() throws Exception
   {
	   
   }

   @After
   public void tearDown() throws Exception
   {
   }

   @Test
   public void testPower()
   {
	  
      double calc = PowerSolution.powerIterative(5, 2);
      assertEquals(25, calc, 0);
      double calc1 = PowerSolution.powerRecursive(25, 0);
      assertEquals(1, calc1, 0);
      try
      {
         double calc2 = PowerSolution.powerRecursiveV2(16, -1);

      }
      catch (IllegalArgumentException e)
      {
         assertEquals("Power should be positive", e.getMessage());
      }

   }

}
