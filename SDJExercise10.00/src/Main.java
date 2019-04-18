
public class Main
{

   public static void main(String[] args)
   {
      LogLine logLine=new LogLine("removing a cd has been pressed");
      LogLine logLine1=new LogLine("title for cd to remove has been entered");
      Log log=new Log();
      log.add(logLine);
      log.add(logLine1);
      
      
   }

}
