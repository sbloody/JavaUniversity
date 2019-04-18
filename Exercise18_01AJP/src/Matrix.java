public class Matrix
{

   private int[][] matrix;

   public Matrix(int[][] m)
   {
      this.matrix = m;
/*
  if (!isRectangular()) { throw new IllegalArgumentException(); }
*/
   }

   public int[][] get2DArrayRepresentation()
   {

      return matrix;

   }

   public boolean isRectangular()
   {

      for (int i = 0; i < matrix.length; i++)
      {

         if (matrix.length != matrix[i].length)
            return false;

      }
      return true;

   }

   public boolean isSquare()
   {

      return matrix.length == matrix[0].length;

   }

   public boolean isDiagonal()
   {

      if (isSquare())
      {

         for (int i = 0; i < matrix.length; i++)
         {
            for (int j = 0; j < matrix[i].length; j++)
            {
               if (i != j && matrix[i][j] != 0)
               {
                  return false;
               }

            }
         }

         return true;
      }
      return false;
   }

   public boolean isIdentity()
   {
      if (!isDiagonal())
      {
         return false;
      }
      for (int i = 0; i < matrix.length; i++)
      {
         for (int j = 0; j < matrix[i].length; j++)
         {
            if (i == j && matrix[i][j] != 1)
            {
               return false;
            }

         }
      }

      return true;

   }

   public boolean isSymmetric()
   {

      if (!isSquare())
      {
         System.out.println("Dsadsa");
         return false;
      }
      for (int i = 0; i < matrix.length; i++)
      {
         for (int j = i + 1; j < matrix[i].length; j++)
         {
            if (matrix[i][j] != matrix[j][i])
            {
               return false;
            }

         }
      }

      return true;
   }

   public boolean isLowerTriangular()
   {

      if (!isSquare())
      {
         System.out.println("Dsadsa");
         return false;
      }
      for (int i = 0; i < matrix.length; i++)
      {
         for (int j = i + 1; j < matrix[i].length; j++)
         {
            if (matrix[i][j] != 0)
            {
               return false;
            }

         }
      }

      return true;
   }

   public boolean isHigherTriangular()
   {

      if (!isSquare())
      {
         System.out.println("Dsadsa");
         return false;
      }
      for (int i = 0; i < matrix.length; i++)
      {
         for (int j = i + 1; j < matrix[i].length; j++)
         {
            if (matrix[j][i] != 0)
            {
               return false;
            }

         }
      }

      return true;
   }

   public Matrix transpose()
   {

      int[][] matrixTest = new int[matrix[0].length][matrix.length];

      for (int i = 0; i < matrix[i].length; i++)
      {
         for (int j = 0; j < matrix.length; j++)
         {
            matrixTest[i][j] = this.matrix[j][i];

         }

      }
      Matrix m = new Matrix(matrixTest);
      return m;

   }

   public String toString()
   {
      String s = "";
      for (int i = 0; i < matrix.length; i++)
      {
         if (i > 0)
         {
            s += "\n";
         }
         {
            for (int j = 0; j < matrix[i].length; j++)
            {
               s += matrix[i][j] + "\t";
            }
         }
      }
      return s;

   }

   public Matrix plus(Matrix m)
   {
      int[][] matrixTest2 = m.get2DArrayRepresentation();
      int[][] matrixTest = new int[matrix.length][matrix[0].length];
      
      for (int i = 0; i < matrix.length; i++)
      {
         for (int j = 0; j < matrix[i].length; j++)
         {
            matrixTest[i][j] = matrix[i][j] + matrixTest2[i][j];
            
         }

      }
      Matrix mTest = new Matrix(matrixTest);
      return mTest;
   }
   public Matrix minus(Matrix m)
   {
      int[][] matrixTest2 = m.get2DArrayRepresentation();
      int[][] matrixTest = new int[matrix.length][matrix[0].length];
      
      for (int i = 0; i < matrix.length; i++)
      {
         for (int j = 0; j < matrix[i].length; j++)
         {
            matrixTest[i][j] = matrix[i][j] - matrixTest2[i][j];
            
         }

      }
      Matrix mTest = new Matrix(matrixTest);
      return mTest;
   }
   public Matrix multiplication(Matrix m)
   {
     
      
      int[][] matrixTest2 = m.get2DArrayRepresentation();
      int[][] matrixReturn = new int[matrix.length][matrixTest2[0].length];
      
      for (int i = 0; i < matrix.length; i++)
      {
         for (int j = 0; j < matrixTest2[0].length; j++)
         {
            for (int k = 0; k < matrix[0].length;k++){
               
               matrixReturn[i][j] += matrix[i][k] * matrixTest2[k][j];
               
               
               
            }
            
         }

      }
      Matrix mTest = new Matrix(matrixReturn);
      return mTest;
   }

   public static void main(String[] args)
   {

      // int[][] array = { { 1, 2, 3 }, { 2, 3, 4 }, { 4, 3, 3 } };
      // int[][] array = { { 1, 2, 3 }, { 2, 3, 4 }};

      int[][] array = { { 3, 5, 7 },
                        { 0, 1, 2 },};

      int[][] array2 = {{ 1, 4 },
                        { 2, 5 },
                        { 3, 6 } };
      
      Matrix test = new Matrix(array);
      Matrix test2 = new Matrix(array2);

      System.out.println(test.toString());
      System.out.println("-------------------");
      //System.out.println(test.minus(test2));
      System.out.println(test2.toString());
      //System.out.println(test.transpose());
      System.out.println("-------------------");
      
      System.out.println(test.multiplication(test2));

      // System.out.println(test.toString());

   }

}
