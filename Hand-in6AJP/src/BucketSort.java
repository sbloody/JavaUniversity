public class BucketSort
{
   public static void bucketSort(int[] A, int m)
   {
      Bucket between0n25 = new Bucket(m);
      Bucket between25n50 = new Bucket(m);
      Bucket between50n75 = new Bucket(m);
      Bucket between75n100 = new Bucket(m);

      for (int i = 0; i < A.length; i++)
      {
         if (A[i] < 25)
         {
            between0n25.insert(A[i]);
         }
         else if (A[i] < 50 && A[i] >= 25)
         {
            between25n50.insert(A[i]);
         }
         else if (A[i] < 75 && A[i] >= 50)
         {
            between50n75.insert(A[i]);
         }
         else
         {
            between75n100.insert(A[i]);
         }
      }
      between0n25.sort();
      between25n50.sort();
      between50n75.sort();
      between75n100.sort();

      int number1 = between0n25.copyBucketInto(A, 0);
      int number2 = between25n50.copyBucketInto(A, number1);
      int pos = number1 + number2;
      int number3 = between50n75.copyBucketInto(A, pos);
      int pos2 = number3 + pos;
      between75n100.copyBucketInto(A, pos2);
   }

   public static void main(String[] args)
   {
      int[] A = { 78, 17, 39, 26, 72, 94, 21, 4, 47, 12, 68, 87 };
      bucketSort(A, 5);
      for (int i = 0; i < A.length; i++)
      {
         System.out.println(A[i]);
      }
   }
}