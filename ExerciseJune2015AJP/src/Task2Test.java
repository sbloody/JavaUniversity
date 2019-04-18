import static org.junit.Assert.*;

import java.awt.LinearGradientPaint;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Task2Test
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
   public void testLinear()
   {
      Task2 task=new Task2();
      int[][] matrix = { { 6, 8, 13 }, { 14, 19, 21 }, { 15, 22, 23 } };
      int[] array = task.linearSearch(matrix, 21);
      assertEquals(1, array[0]);
      assertEquals(2, array[1]);
   }

   @Test
   public void testBinary()
   {
      Task2 task=new Task2();
      int[][] matrix = { { 6, 8, 13 }, { 14, 19, 21 }, { 15, 22, 23 } };
      int[] array1 = task.binarySearch(21, matrix);
      assertEquals(1, array1[0]);
      assertEquals(2, array1[1]);
   }

}
