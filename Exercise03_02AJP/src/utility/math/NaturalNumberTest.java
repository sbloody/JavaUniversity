package utility.math;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class NaturalNumberTest
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
   public void testGetValueInBase()
   {
      NaturalNumber nb=new NaturalNumber(3610);
      assertEquals("111000011010", nb.getValueInBase(2));
      assertEquals("3610",nb.getValueInBase(10));
      assertEquals("210A",nb.getValueInBase(12));
      assertEquals("E1A",nb.getValueInBase(16));
      assertEquals("90A",nb.getValueInBase(20));
      assertEquals("1.0.10", nb.getValueInBase(60));
      
   }

}
