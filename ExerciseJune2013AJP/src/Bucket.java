import java.lang.reflect.Array;
import java.util.Arrays;

public class Bucket
{
   private int[] bucket;
   private int count; // the next free place in the bucket

   /*
    * size is the maximum number of elements that can be held in this bucket. *
    * You may assume that the user of the bucket never inserts more * than
    * 'size' elements.
    */
   public Bucket(int size)
   {
      bucket = new int[size];
      count = 0;
   }

   /* Inserts x on the next free place in the bucket */
   public void insert(int x)
   {
      int temp=count;
      count=x;
      temp++;
   }

   /* Sorts bucket, using a simple sorting method */
   public void sort()
   {
      Arrays.sort(bucket);
   }

   // Copies the bucket elements into A; first is the first place in A to copy *
   // an
   // element from the bucket. * The method returns how many elements have
   // been copied from the bucket */
   public int copyBucketInto(int[] A, int first)
   { 
      int count=0;
      for(int i=0;i<A.length;i++)
      {
         A[first]=bucket[i];
         first++;
         count++;
      }
      return count;
   }
}
