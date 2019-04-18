
public class BlockingQueueMain
{

   public static void main(String[] args)
   {
      BlockingQueue<String> test= new BlockingQueue<>(15);
      
      test.put("sasda");
      test.put("asdsa");
      test.put("babbb");
      System.out.println(test.size());
      System.out.println(test.toString());

   }

}
