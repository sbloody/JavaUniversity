import java.util.Arrays;

public class Task2
{
   public static void main(String[] args)
   {
      double[] data = { 4, 5, 7, 2, 1 };

      System.out.println(mean(data));
      System.out.println(median(data));
      System.out.println(deviation(data));
   }

   public static double mean(double[] data)
   {
      double sum = 0;
      double average = 0;
      for (int i = 0; i < data.length; i++)
      {
         sum += data[i];
      }
      average = sum / data.length;
      return average;
   }

   public static double median(double[] data)
   {
      double median = 0;
      Arrays.sort(data);
      int temp = data.length / 2;
      if (data.length % 2 != 0)
      {

         median = data[temp];
         return median;

      }

      else
      {
         temp = data.length / 2 - 1;
         double[] array = new double[2];

         array[0] = data[temp];
         array[1] = data[temp + 1];
         return mean(array);
      }

   }

   public static double deviation(double[] data)
   {
      double sum = 0;
      double deviation = 0;
      for (int i = 0; i < data.length; i++)
      {
         sum += Math.pow(data[i] - mean(data), 2);
      }

      deviation = Math.sqrt(sum / median(data));
      return deviation;

   }

}
