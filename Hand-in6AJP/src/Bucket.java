import java.util.Arrays;

public class Bucket
{
   private int[] bucket;
   private int count;

   public Bucket(int size)
   {
      bucket = new int[size];
      count = 0;
   }

   public void insert(int x)
   {
      bucket[count] = x;
      count++;
   }

   public void sort()
   {
      Arrays.sort(bucket, 0, count);
   }

   public int copyBucketInto(int[] A, int first)
   {
      for (int i = 0; i < count; i++)
      {
         A[first] = bucket[i];
         first++;
      }
      return count;
   }
}