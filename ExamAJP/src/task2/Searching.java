package task2;

public class Searching
{


   public static int linearSearch(int[] arr, int key, int left, int right)
   {
      while (arr.length > right && right >= left && left >= 0)
      {
         if (key == arr[left])
            return left;
         left++;
      }
      return -1;
   }

   public static int binarySearch(int[] arr, int key, int left, int right)
   {

      while (arr.length > right && right >= left && left >= 0)
      {
        
         int middle = (left + right) / 2;
         if (key == arr[middle])
         {
            while (middle > 0 && arr[middle] == arr[middle - 1])
               middle--;
            return middle;
         }
         if (key > arr[middle])
            left = middle + 1;
         else
            right = middle - 1;
         return binarySearch(arr, key, left, right);
      }
      return -1;
   }
   
   public static int binarySearchImproved(int[] arr, int key, int left, int right)
   {

      while (arr.length > right && right >= left && left >= 0)
      {
         if(right-left<10)
         {
            System.out.println("linear");
            return linearSearch(arr, key, left, right);
         }
         int middle = (left + right) / 2;
         if (key == arr[middle])
         {
            while (middle > 0 && arr[middle] == arr[middle - 1])
               middle--;
            return middle;
         }
         if (key > arr[middle])
            left = middle + 1;
         else
            right = middle - 1;
         return binarySearch(arr, key, left, right);
      }
      return -1;
   }

}
