
public class CounterMain
{

   public static void main(String[] args)
   {
      Counter counter=new Counter(20, 0);
      CounterIncrementer inc1=new CounterIncrementer(counter, 200);
      CounterIncrementer inc2=new CounterIncrementer(counter, 200);
      CounterDecrementer dec1=new CounterDecrementer(counter, 200);
      CounterDecrementer dec2=new CounterDecrementer(counter, 200);
      Thread threadInc1=new Thread(inc1, "Incrementer1");
      Thread threadInc2=new Thread(inc2, "Incrementer2");
      Thread threadDec1=new Thread(dec1,"Decrementer1");
      Thread threadDec2=new Thread(dec2,"Decrementer2");
      threadInc1.start();
      threadInc2.start();
      threadDec1.start();
      threadDec2.start();
      

   }

}
