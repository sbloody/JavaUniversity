import utility.collection.binarySearch;


public class test
{

   public static void main(String[] args)
   {
      int list[] = new int[]{0,1,2,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,34,1349};
      int list2[]=new int[]{7,8,9,11,12,12,12,12,12,14,15};
      System.out.println(binarySearch.binarySearch(122, list2,0,list2.length-1));
   }


}
