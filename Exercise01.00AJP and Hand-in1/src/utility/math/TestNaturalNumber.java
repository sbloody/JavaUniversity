package utility.math;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import java.util.Arrays;
import utility.math.*;

public class TestNaturalNumber
{
   @Before
   public void setUp() throws Exception
   { // nothing
   }

   @After
   public void tearDown() throws Exception
   { // nothing
   }

   @Test
   public void testConstructorAndGet()
   {
      NaturalNumber naturalNumber1 = new NaturalNumber(1);
      assertEquals(1, naturalNumber1.getValue());
      NaturalNumber naturalNumber2 = new NaturalNumber(2);
      assertEquals(2, naturalNumber2.getValue());
      NaturalNumber naturalNumber3 = new NaturalNumber(3510);
      assertEquals(3510, naturalNumber3.getValue());
   }

   @Test(expected = IllegalArgumentException.class)
   public void testConstructorException1()
   {
      NaturalNumber naturalNumber = new NaturalNumber(0);
   }

   @Test(expected = IllegalArgumentException.class)
   public void testConstructorException2()
   {
      NaturalNumber naturalNumber = new NaturalNumber(-18);
   }

   @Test
   public void testSetAndGet()
   {
      NaturalNumber naturalNumber = new NaturalNumber(1);
      naturalNumber.setValue(2);
      assertEquals(2, naturalNumber.getValue());
      naturalNumber.setValue(17);
      assertEquals(17, naturalNumber.getValue());
      naturalNumber.setValue(991);
      assertEquals(991, naturalNumber.getValue());
      naturalNumber.setValue(1);
      assertEquals(1, naturalNumber.getValue());
   }

   @Test(expected = IllegalArgumentException.class)
   public void testSetValueException1()
   {
      NaturalNumber naturalNumber = new NaturalNumber(1);
      naturalNumber.setValue(0);
   }

   @Test(expected = IllegalArgumentException.class)
   public void testSetValueException2()
   {
      NaturalNumber naturalNumber = new NaturalNumber(1);
      naturalNumber.setValue(-18);
   }

   @Test
   public void testToString()
   {
      NaturalNumber naturalNumber = new NaturalNumber(1);
      assertTrue(naturalNumber.toString().contains("1"));

      naturalNumber.setValue(991);
      assertTrue(naturalNumber.toString().contains("991"));

      naturalNumber.setValue(45329659);
      assertTrue(naturalNumber.toString().contains("45329659"));
   }

   @Test
   public void testGetPrimeFactors()
   {
      NaturalNumber naturalNumber = new NaturalNumber(3510);
      int[] primeNumbers = naturalNumber.getPrimeFactors();
      Arrays.sort(primeNumbers); // elements may not be sorted
      assertArrayEquals(new int[] { 2, 3, 3, 3, 5, 13 }, primeNumbers);
      naturalNumber.setValue(30);
      primeNumbers = naturalNumber.getPrimeFactors();
      Arrays.sort(primeNumbers); // elements may not be sorted
      assertArrayEquals(new int[] { 2, 3, 5 }, primeNumbers);

      naturalNumber.setValue(49);
      primeNumbers = naturalNumber.getPrimeFactors();
      assertArrayEquals(new int[] { 7, 7 }, primeNumbers);
      naturalNumber.setValue(877);
      primeNumbers = naturalNumber.getPrimeFactors();
      assertArrayEquals(new int[] { 877 }, primeNumbers);
      naturalNumber.setValue(1);
      primeNumbers = naturalNumber.getPrimeFactors();
      assertArrayEquals(new int[] {}, primeNumbers);
      System.out.println("testGetPrimeFactors ended (no errors)");
   }

   @Test
   public void testIsPrime()
   {
      NaturalNumber naturalNumber = new NaturalNumber(89);
      naturalNumber.setValue(109);
      assertTrue(naturalNumber.isPrime());
      naturalNumber.setValue(150);
      assertFalse(naturalNumber.isPrime());

   }

   // @Test
   // public void TestIsPrimePower()
   // {
   // NaturalNumber naturalNumber = new NaturalNumber(31);
   // assertTrue(naturalNumber.isPrimePower());
   // naturalNumber.setValue(16);
   // assertTrue(naturalNumber.isPrimePower());
   // naturalNumber.setValue(27);
   // assertTrue(naturalNumber.isPrimePower());
   // naturalNumber.setValue(30);
   // assertFalse(naturalNumber.isPrimePower());
   // }

   @Test
   public void testGetProperDivisors()
   {
      NaturalNumber naturalNumber = new NaturalNumber(3510);
      int[] properDivisors = naturalNumber.getProperDivisors();
      Arrays.sort(properDivisors); // elements may not be sorted
      assertArrayEquals(new int[] { 1, 2, 3, 5, 6, 9, 10, 13, 15, 18, 26, 27,
            30, 39, 45, 54, 65, 78, 90, 117, 130, 135, 195, 234, 270, 351, 390,
            585, 702, 1170, 1755 }, properDivisors);
      naturalNumber.setValue(28);
      properDivisors = naturalNumber.getProperDivisors();
      Arrays.sort(properDivisors); // elements may not be sorted
      assertArrayEquals(new int[] { 1, 2, 4, 7, 14}, properDivisors);
      naturalNumber.setValue(1);
      properDivisors = naturalNumber.getProperDivisors();
      assertArrayEquals(new int[] { }, properDivisors);
      naturalNumber.setValue(6);
      properDivisors = naturalNumber.getProperDivisors();
      Arrays.sort(properDivisors);
      assertArrayEquals(new int[] { 1, 2, 3 }, properDivisors);

   }
   
    @Test
    public void testPerfectNumber()
    {
    NaturalNumber naturalNumber=new NaturalNumber(6);
    assertTrue(naturalNumber.isPerfectNumber());
    naturalNumber.setValue(28);
    assertTrue(naturalNumber.isPerfectNumber());
    naturalNumber.setValue(45);
    assertFalse(naturalNumber.isPerfectNumber());
    naturalNumber.setValue(1);
    assertFalse(naturalNumber.isPerfectNumber());
    }
}
