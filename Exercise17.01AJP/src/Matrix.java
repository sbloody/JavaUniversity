public class Matrix
{
   private int[][] matrix;

   public Matrix(int[][] m)
   {
      matrix = m;
   }

   public int[][] get2DArrayRepresantation()
   {
      int[][] array = new int[matrix.length][matrix[0].length];
      for (int i = 0; i < matrix.length; i++)
      {
         for (int j = 0; j < matrix[i].length; j++)
         {
            array[i][j] = matrix[i][j];
         }
      }
      return array;

   }

   public boolean isRectangular()
   {

      for (int i = 1; i < matrix.length; i++)
      {
         if (matrix == null)
            throw new IllegalArgumentException(
                  "It should have at least one element");
         if (matrix[i].length != matrix[i - 1].length)
            return false;

      }
      return true;

   }

   public boolean isSquare()
   {

      for (int i = 0; i < matrix.length; i++)
      {
         for (int j = 0; j < matrix[i].length; j++)
         {
            if (matrix[i].length == matrix[j].length && isRectangular())
               return true;
         }

      }

      return false;
   }

   public boolean isDiagonal()
   {

      for (int i = 0; i < matrix.length; i++)
      {
         for (int j = 0; j < matrix[i].length; j++)
         {
            if (i == j && isSquare())
               continue;
            if (matrix[i][j] != 0)
               return false;

         }

      }

      return true;
   }

   public boolean isIdentityMatrix()
   {

      for (int i = 0; i < matrix.length; i++)
      {
         for (int j = 0; j < matrix[i].length; j++)
         {
            if (isDiagonal() && i == j && matrix[i][j] == 1)
               return true;
         }
      }
      return false;
   }

   public boolean isSymetric()
   {
      for (int i = 0; i < matrix.length; i++)
      {
         for (int j = 0; j < matrix[i].length; j++)
         {
            if (isSquare() && matrix[i][j] != matrix[j][i])
               return false;
         }
      }
      return true;
   }

   public boolean isLowerTriangular()
   {
      for (int i = 0; i < matrix.length; i++)
      {
         for (int j = 0; j < matrix[i].length; j++)
         {
            if (i == j && isSquare())
               continue;
            if (matrix[i][j] != 0)
               return false;
         }

      }
      return true;

   }

   public boolean isHigherTriangular()
   {
      if (isSquare())
      {
         for (int i = 0; i < matrix.length; i++)
         {
            for (int j = 0; j < matrix[i].length; j++)
            {
               if (i == j)
                  continue;
               if (matrix[i][j] != 0)
                  return false;
            }

         }

      }
      return true;
   }

   public Matrix transpose()
   {
      int[][] array = new int[matrix[0].length][matrix.length];
      Matrix transpose = new Matrix(array);

      for (int i = 0; i < matrix.length; i++)
      {
         for (int j = 0; j < matrix[0].length; j++)
         {
            array[j][i] = matrix[i][j];
         }

      }
      
      return transpose;

   }
   
   public Matrix plus(Matrix m)
   {
      int [][]m2=m.get2DArrayRepresantation();
      int [][]m3=new int[matrix.length][matrix[0].length];
      
      if(m2.length!=matrix.length && m2[0].length!=matrix[0].length )
         throw new IllegalArgumentException("Dimension wrong");
      for(int i=0;i<matrix.length;i++)
      {
         for(int j=0;j<matrix[0].length;j++)
         {
            m3[i][j]=matrix[i][j]+m2[i][j];
         }
      }
      return new Matrix(m3);
   }
   
   public Matrix minus(Matrix m)
   {
      int [][]m2=m.get2DArrayRepresantation();
      int [][]m3=new int[matrix.length][matrix[0].length];
      
      if(m2.length!=matrix.length && m2[0].length!=matrix[0].length )
         throw new IllegalArgumentException("Dimension wrong");
      for(int i=0;i<matrix.length;i++)
      {
         for(int j=0;j<matrix[0].length;j++)
         {
            m3[i][j]=matrix[i][j]-m2[i][j];
         }
      }
      return new Matrix(m3);
   }
   
   public Matrix multiplication(Matrix m)
   {
      int [][]m2=m.get2DArrayRepresantation();
      int [][]m3=new int[matrix.length][matrix[0].length];
      
//      if(m2.length!=matrix.length && m2[0].length!=matrix[0].length )
//         throw new IllegalArgumentException("Dimension wrong");
      for(int i=0;i<matrix.length;i++)
      {
         for(int j=0;j<m2[0].length;j++)
         {
            for(int k=0;k<matrix[0].length;k++)
            {
               m3[i][j]+=matrix[i][k]*m2[k][j];
            }
         }
      }
      return new Matrix(m3);  
   }

   public String toString()
   {
      String s = "[";
      for (int i = 0; i < matrix.length; i++)
      {
         for (int j = 0; j < matrix[0].length; j++)
         {
            s += matrix[i][j];
            if (j != matrix[0].length - 1)
            {
               s += "  ";
            }
         }
         if (i != matrix.length - 1)
         {
            s += "\n";
         }
      }
     
      return s + "]";
   }

   public static void main(String[] args)
   {

      int[][] matrixDiagonal = { { 2, 0, 0, 0, 0 }, { 0, -3, 0, 0, 0 },
            { 0, 0, 7, 0, 0 }, { 0, 0, 0, 1, 0 }, { 0, 0, 0, 0, 11 } };

      int[][] matrixIdentity = { { 1, 0, 0, 0, 0 }, { 0, 1, 0, 0, 0 },
            { 0, 0, 1, 0, 0 }, { 0, 0, 0, 1, 0 }, { 0, 0, 0, 0, 1 } };

      int[][] matrixSquare = { { 2, 2, 2, 2 }, { 3, 3, 3, 3 }, { 4, 4, 4, 4 },
            { 5, 5, 5, 5 } };

      int[][] matrixRectangular = { { 2, 2, 2, 2 }, { 3, 3, 3, 3 },
            { 4, 4, 4, 4 }, { 5, 5, 5, 5 } };

      int[][] matrixSymmetric = { { 1, 7, 3 }, { 7, 4, -5 }, { 3, -5, 6 } };

      int[][] matrixLowerTriangular = { { 5, 0, 0, 0 }, { 3, 1, 0, 0 },
            { 4, 9, 4, 0 }, { 6, 8, 7, 2 } };
      int[][] matrixHigherTriangular = { { 5, 3, 0, 7 }, { 0, 1, 9, 8 },
            { 0, 0, 4, 6 }, { 0, 0, 0, 2 } };
      
      int [][] matrixTranspose ={{1,0,2},{-1,3,1}};
      
      int [][] matrixPlus={{3,1},{2,1},{1,0}};

      Matrix m1 = new Matrix(matrixDiagonal);
      Matrix m2 = new Matrix(matrixIdentity);
      Matrix m3 = new Matrix(matrixSquare);
      Matrix m4 = new Matrix(matrixRectangular);
      Matrix m5 = new Matrix(matrixSymmetric);
      Matrix m6 = new Matrix(matrixLowerTriangular);
      Matrix m7 = new Matrix(matrixHigherTriangular);
      Matrix m8=new Matrix(matrixTranspose);
      Matrix m9=new Matrix(matrixPlus);
      

//      System.out.println(m1.isDiagonal());
//      System.out.println(m2.isIdentityMatrix());
//      System.out.println(m3.isSquare());
//      System.out.println(m4.isRectangular());
//      System.out.println(m5.isSymetric());
//      System.out.println(m6.isLowerTriangular());
//      System.out.println(m7.isHigherTriangular());
//      System.out.println(m8);
//      System.out.println(m8.transpose());
//      System.out.println(m8.plus(m9));
//      System.out.println(m8.minus(m9));
      System.out.println(m8.multiplication(m9));
     

   }
}
