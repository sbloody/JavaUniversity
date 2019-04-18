import java.util.ArrayList;


public class TaskList
{
   private ArrayList<String> tasks;
   
   public TaskList()
   {
      this.tasks = new ArrayList<String>();
   }
   
   public void addTask(String task)
   {
      this.tasks.add(task);
   }
   public String getAndRemoveNextTask()
   {
      return tasks.remove(this.tasks.size() - 1);
      
   }
   public int size()
   {
      return tasks.size();
   }
}