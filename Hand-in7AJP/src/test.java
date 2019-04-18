public class test
{
   public static void main(String[] args)
   {
      int[][] matrix = { { 0, 0, 1, 2 }, { 3, 0, 0, 4 }, { 0, 0, 0, 0 },
            { 0, 0, 5, 0 } };
      int[] array = SearchArray.getArrayRepresentation(matrix);
      for (int j = 0; j < array.length; j++)
      {
         System.out.print(array[j] + ", ");
      }
      System.out.println();
      System.out.println(SearchArray.getNumberOfNonZeros(matrix));
      System.out.println();
      int[][] shit = SearchArray.getMatrixFromArray(array, 4);
      String s = "[";
      for (int i = 0; i < shit.length; i++)
      {
         for (int j = 0; j < shit[0].length; j++)
         {
            s += shit[i][j];
            if (j != shit[0].length - 1)
            {
               s += "  ";
            }
         }
         if (i != shit.length - 1)
         {
            s += "\n";
         }
      }
      System.out.println(s += "]");
   }
}