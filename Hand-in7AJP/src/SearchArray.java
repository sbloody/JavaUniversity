import java.util.Arrays;

public class SearchArray
{

   // public static void main(String[] args)
   // {
   // int[] array = { 2, 5, 7, 8, 10, 14 };
   // System.out.println(searchSequential(array, 14));
   // System.out.println(searchRecSequential(array, 8, 1));
   // int[][] matrix = { { 2, 3, 4, 5 }, { 10, -2, 0, -1 }, { 1, 15, 0, 5 },
   // { 2, 4, 0, -5 } };
   // int[] array1 = { 0, 3, -15, 2, 4, 10, 0, 7, 0, 8, 0, 5, 2, 4, -2, 0 };
   // System.out.println(getNumberOfNonZeros(matrix));
   // System.out.println(Arrays.toString(getArrayRepresentation(matrix)));
   // getMatrixFromArray(array1, 4);
   //
   // }

   private static int searchSequential(int[] A, int value)
   {
      Arrays.sort(A);
      for (int i = 0; i < A.length; i++)
      {
         if (A[i] > value)
         {
            System.out
                  .println("Didn't find the value, didn't go through entire array; ENDED ON i = "
                        + i);
            return -1;
         }
         if (A[i] == value)
         {
            System.out.println("Found the value; ENDED ON i = " + i);
            return i;
         }
      }
      return -1;

   }

   private static int searchRecSequential(int[] A, int value, int currentIndex)
   {
      if (currentIndex == 0)
      {
         Arrays.sort(A, 0, A.length);
      }

      if (A[currentIndex] > value)
      {
         return -1;
      }

      if (A[currentIndex] == value)
      {
         return currentIndex;
      }
      return searchRecSequential(A, value, currentIndex + 1);

   }

   static int getNumberOfNonZeros(int[][] matrix)
   {
      int count = 0;
      for (int i = 0; i < matrix.length; i++)
      {
         for (int j = 0; j < matrix[i].length; j++)
         {
            if (matrix[i][j] != 0)
               count++;
         }

      }
      return count;
   }

   static int[] getArrayRepresentation(int[][] matrix)
   {
      int number = 0;
      int[] array = new int[getNumberOfNonZeros(matrix) * 3];
      for (int i = 0; i < matrix.length; i++)
      {
         for (int j = 0; j < matrix[i].length; j++)
         {
            if (matrix[i][j] != 0)
            {
               array[number] = matrix[i][j];
               number++;
               array[number] = i;
               number++;
               array[number] = j;
               number++;

            }

         }
      }

      return array;
   }

   static int[][] getMatrixFromArray(int[] array, int dimension)
   {

      int[][] matrix = new int[dimension][dimension];
      for (int i = 2; i < array.length; i += 3)
      {
         matrix[array[i - 1]][array[i]] = array[i - 2];
      }

      return matrix;
   }

}
