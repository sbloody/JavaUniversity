package utility.collection;

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
      NaturalNumber n1=new NaturalNumber(18745);
      assertEquals("5.12.25 [base 60]", n1.getValueInBase(60));
      n1.setValue(212);
      assertEquals("0b11010100", n1.getValueInBase(2));
      assertEquals("212",n1.getValueInBase(10));
      assertEquals("158 [base 12]", n1.getValueInBase(12)); 
      assertEquals("0xD4",n1.getValueInBase(16));
      assertEquals("AC [base 20]", n1.getValueInBase(20));
      assertEquals("3.32 [base 60]", n1.getValueInBase(60));
   }
   
   public void testDigitSum()
   {
      NaturalNumber n1=new NaturalNumber(84001);
      assertEquals(13,n1.getDigitSum());
      n1.setValue(65536);
      assertEquals(25,n1.getDigitSum());
   }

   public void testDigitalRoot()
   {
      NaturalNumber n1=new NaturalNumber(84001);
      assertEquals(4,n1.getDigitalRoot());
      n1.setValue(65536);
      assertEquals(7,n1.getDigitalRoot());
   }
}


