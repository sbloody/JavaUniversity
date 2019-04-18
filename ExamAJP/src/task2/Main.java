package task2;

public class Main
{
   public static void main(String[] args)
   {
      Searching sr=new Searching();
      int [] arr1={1};
      int[] arr = { 1, 2, 3, 4, 5, 6, 7, 7,8 };
      int [] arr2={1,2,3,4,5,6,7,8,9,9,9,10,13,15,20,35,40,45,49,50,53,55,60,75,78};
      System.out.println(sr.binarySearch(arr, 6, 0, 8));
      System.out.println(sr.binarySearchImproved(arr, 6, 0, 8));
      System.out.println(sr.binarySearch(arr1, 1, 0, 0));
      System.out.println(sr.binarySearchImproved(arr1, 1, 0, 0));
      System.out.println(sr.binarySearch(arr2, 15, 0, 24));
      System.out.println(sr.binarySearchImproved(arr2, 15, 0, 24));

   }
}
