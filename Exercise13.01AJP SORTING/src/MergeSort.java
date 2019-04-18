import java.util.Arrays;

public class MergeSort
{
   public static void main(String[] args)
   {
      // Unsorted array
      int[] a = { 6, 5, 3, 1, 8, 7, 2, 4 };

      // Call merge sort
      mergeSort(a);

      // Check the output which is sorted array
      System.out.println(Arrays.toString(a));
   }

   public static void mergeSort(int[] array)
   {
      if (array.length <= 1)
      {
         return;
      }
      int middle = array.length / 2;
      int[] leftArray = new int[middle];
      int[] rightArray = new int[array.length - leftArray.length];
      System.arraycopy(array, 0, leftArray, 0, leftArray.length);
      System.arraycopy(array, leftArray.length, rightArray, 0,
            rightArray.length);
      mergeSort(leftArray);
      mergeSort(rightArray);
      merge(array, leftArray, rightArray);
   }

   private static void merge(int[] array, int[] leftArray, int[] rightArray)
   {
      // Index Position in first array - starting with first element
      int iFirst = 0;

      // Index Position in second array - starting with first element
      int iSecond = 0;

      // Index Position in merged array - starting with first position
      int iMerged = 0;

      while (iFirst < leftArray.length && iSecond < rightArray.length)
      {
         if (leftArray[iFirst] < rightArray[iSecond])
         {
            array[iMerged] = leftArray[iFirst];
            iFirst++;
         }
         else
         {
            array[iMerged] = rightArray[iSecond];
            iSecond++;
         }
         iMerged++;
      }
      // copy remaining elements from both halves - each half will have already
      // sorted elements
      System.arraycopy(leftArray, iFirst, array, iMerged, leftArray.length
            - iFirst);
      System.arraycopy(rightArray, iSecond, array, iMerged, rightArray.length
            - iSecond);
   }

}
