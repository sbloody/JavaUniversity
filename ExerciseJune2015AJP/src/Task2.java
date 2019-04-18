import java.util.Arrays;

public class Task2
{

   public static int[] linearSearch(int[][] matrix, int key)
   {
      int[] array = new int[2];
      for (int i = 0; i < matrix.length; i++)
      {
         for (int j = 0; j < matrix[i].length; j++)
         {
            if (matrix[i][j] == key)
            {
               array[0] = i;
               array[1] = j;
               return array;
            }
         }
      }
      return null;
   }

   // public static int[] binarySearchOfMatrix(int[][] matrix, int key)
   // {
   // for (int i = 0; i < matrix.length; i++)
   // {
   // for (int j = 0; j < matrix[i].length; j++)
   // {
   // binarySearch(matrix[i], key, matrix[i][0], matrix[i].length - 1);
   // }
   // }
   // return -1;
   // }
   //
   // public static int binarySearch(int[] array, int key, int left, int right)
   // {
   // while (left <= right)
   // {
   // int middle = (left + right) / 2;
   // if (array[middle] > key)
   // {
   // right = middle - 1;
   // }
   // else if (array[middle] < key)
   // {
   // left = middle + 1;
   // }
   // else
   // {
   // return middle;
   // }
   // }
   // return -1;
   // }
   //
   // public static int[] binarySearch(int[][] matrix, int key)
   // {
   // for (int i = 0; i < matrix.length; i++)
   // {
   // for (int j = 0; j < matrix[i].length; j++)
   // {
   // while (matrix[i][j] <= matrix[i][matrix[i].length])
   // {
   //
   // }
   // }
   // }
   // }

   public static int[] binarySearch(int key, int[][] matrix)
   {
      int[] array = new int[2];
      for (int i = 0; i < matrix.length; i++)
      {
         for (int j = 0; j < matrix[i].length; j++)
         {
            int middle = matrix[i].length / 2;

            if (key == matrix[i][middle])
            {
               array[0] = i;
               array[1] = middle;
               return array;
            }
            if (key > matrix[i][middle])
               middle++;
            else
            {
               middle--;
               
            }
         }
      }
      return null;
   }
//   public static void main(String[] args)
//   {
//      int[][] matrix={{6,8,13},{14,19,21},{15,22,23}};
//      Arrays.toString(binarySearch(21, matrix));
//   }

}
