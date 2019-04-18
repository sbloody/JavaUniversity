import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class Log
{
   private QueueADT<LogLine> logQueue;
   private File logFile;

   public Log()
   {
      this.logQueue = new LinkedQueue<>();
      String filename = new DateTime().getSortableDate();
      this.logFile = new File(filename);
   }

   public synchronized void add(LogLine log)
   {
      if (log == null)
      {
         return;
      }

      logQueue.enqueue(log); // add to the queue
      addToFile(log);// add to the file
      System.out.println(log); // add to the console
   }

   public QueueADT<LogLine> getAll()
   {
      return logQueue;
   }

   private void addToFile(LogLine log)
   {
      if (log == null)
      {
         return;
      }
      BufferedWriter out = null;
      try
      {
         out = new BufferedWriter(new FileWriter(logFile, true));
         out.write(log+"");
         out.newLine();
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
      finally
      {
         try
         {
            out.close();
         }
         catch (Exception e)
         {
            e.printStackTrace();
         }
      }
   }
}