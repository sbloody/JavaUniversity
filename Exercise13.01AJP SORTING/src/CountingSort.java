import java.util.Arrays;

public class CountingSort
{

   public static void main(String[] args)
   {
      int []array= {4,2, 0, 5, 2, 1, 2, 1, 5, 5, 4, 2, 2};
      countingSort(array, 0, 5);
      System.out.println(Arrays.toString(array));
   }

   public static void countingSort(int[] array, int small, int large)
   {
      int[] count = new int[large - small + 1];
      for (int number : array)
      {
         count[number - small]++;
      }
      int z = 0;
      for (int i = small; i <= large; i++)
      {
         while (count[i - small] > 0)
         {
            array[z] = i;
            z++;
            count[i - small]--;
         }
      }
   }

}
