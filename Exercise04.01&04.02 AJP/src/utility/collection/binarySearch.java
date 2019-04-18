package utility.collection;

public class binarySearch
{
   public static int binarySearch(int x, int[] sortedArray)
   {
      if (sortedArray.length == 0)
         return -1;
      int middle = sortedArray.length / 2;
      for (int i = 0; i <= sortedArray.length; i++)
      {
         if (x == sortedArray[middle])
            return middle;
         if (x > sortedArray[middle])
            middle++;
         else
         {
            middle--;
            System.out.println("pasti");
         }
      }
      return -1;
   }

   public static int binarySearch(int x, int[] sortedArray, int left, int right)
   {
      if (left > right)
         return -1;
      int middle = (left + right) / 2;
      if (x == sortedArray[middle])
      {
         while (middle > 0 && sortedArray[middle] == sortedArray[middle - 1])
            middle--;
         return middle;
      }
      if (x > sortedArray[middle])
         left = middle + 1;
      else
         right = middle - 1;
      return binarySearch(x, sortedArray, left, right);
   }
}
