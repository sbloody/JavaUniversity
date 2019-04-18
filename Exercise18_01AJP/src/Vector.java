public class Vector
{
   private int[] vector;
   private boolean isColumn;

   public Vector(int[] v)
   {
      if (v != null)
      {
         this.vector = v;
      }
      else
      {
         this.vector = new int[0];
      }
      this.isColumn = true;
   }

   public int[] getArrayRepresentation()
   {
      return vector;
   }

   public int dimension()
   {
      return vector.length;
   }

   public boolean isColumnVector()
   {
      return isColumn;
   }

   public Vector transpose()

   {
      Vector v = new Vector(this.vector);
      v.isColumn = !this.isColumn;
      return v;
   }

   public Vector plus(Vector v)
   {
      if (vector.length != v.dimension() || isColumn != v.isColumnVector())
      {
         throw new IllegalArgumentException("Wrong vector size"
               + " or direction");
      }
      int[] array = v.getArrayRepresentation();
      int[] result = new int[v.dimension()];
      for (int i = 0; i < vector.length; i++)
      {
         result[i] = vector[i] + array[i];
      }
      Vector resultVector = new Vector(result);
      resultVector.isColumn = isColumn;
      return resultVector;
   }

   public Vector minus(Vector v)
   {
      if (vector.length != v.dimension() || isColumn != v.isColumnVector())
      {
         throw new IllegalArgumentException("Wrong vector size"
               + " or direction");
      }
      int[] array = v.getArrayRepresentation();
      int[] result = new int[v.dimension()];
      for (int i = 0; i < vector.length; i++)
      {
         result[i] = vector[i] - array[i];
      }
      Vector resultVector = new Vector(result);
      resultVector.isColumn = isColumn;
      return resultVector;
   }

   public Vector product(int scalar)
   {
      int[] result = new int[vector.length];
      for (int i = 0; i < vector.length; i++)
      {
         result[i] = scalar * vector[i];
      }
      Vector resultVector = new Vector(result);
      resultVector.isColumn = isColumn;
      return resultVector;
   }

   public int product(Vector v)
   {
      if (vector.length != v.dimension() || isColumn

      || !v.isColumnVector())
      {
         throw new IllegalArgumentException("Wrong vector size"
               + " or direction");
      }
      int[] array = v.getArrayRepresentation();
      int result = 0;
      for (int i = 0; i < vector.length; i++)
      {
         result += vector[i] * array[i];
      }
      return result;
   }

   public String toString()
   {
      String s = "[";
      for (int i = 0; i < vector.length; i++)
      {
         s += vector[i];
         if (i < vector.length - 1)
         {
            s += " ";
         }
      }
      s += "]";
      if (isColumn)
      {
         s += "T";
      }
      return s;
   }
}