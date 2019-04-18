

public class StackListBasedMain {
      
      public static void main(String[]args) 
      {
         StackListBased<String> list = new StackListBased<>();
         
         list.push("Somth");
         list.push("nothink");
         list.push("yoo");
         System.out.println(list.toString());
         
         
         
         System.out.println(list.peek());
         
         list.pop();
         System.out.println(list.toString());
         list.pop();
         System.out.println(list.isEmpty());
         list.pop();
         
         System.out.println(list.isEmpty());
         
         System.out.println(list.toString());
      }
}
