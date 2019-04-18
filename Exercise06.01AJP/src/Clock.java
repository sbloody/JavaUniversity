public class Clock
{
   private int hour;
   private int minute;
   private int second;

   public Clock()
   {
      this.hour = 0;
      this.minute = 0;
      this.second = 0;
   }

   public void set(int hour, int minute, int second)
   {
      this.hour = hour;
      this.minute = minute;
      this.second = second;
   }

   public String toString()
   {
      return hour + ":" + minute + ":" + second;
   }

   public void tick()
   {
      this.second += 1;
      // add overflow to minutes from seconds

      this.minute += (int) (this.second / 60);
      // update seconds
      this.second = this.second % 60;
      // add overflow to minutes from seconds
      this.hour += (int) (this.minute / 60);
      // update minutes
      this.minute = this.minute % 60;
      // adjust hours
      this.hour = this.hour % 24;

   }
   
   
}
