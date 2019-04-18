
public class CampsitePancakeCooking implements PancakeCooking{
   
   private int numberOfPlates,butterPortions;
   
   
   public CampsitePancakeCooking(){
      this.numberOfPlates = 4;
      this.butterPortions = 5;
   }
   

   @Override
   public synchronized void takeBakingPlate() {
      
      while(numberOfPlates <= 0){
         try {
            wait();
         } catch (InterruptedException e) {
            
         }
      }
      this.numberOfPlates--;
      System.out.println(Thread.currentThread().getName() + " has taken a baking plate and there is "
      + this.numberOfPlates + "  number of baking plates left.");
   }

   @Override
   public synchronized void pourBatterOnBakingPlate() {
      while(butterPortions <= 0){
         try {
            wait();
         } catch (InterruptedException e) {
            
         }
      }
      this.butterPortions--;
      System.out.println(Thread.currentThread().getName() + " has used a butter portion and there is  "
      + this.butterPortions + " butter portions left.");
      notifyAll();
   }

   @Override
   public synchronized void putBackBakingPlate() {
      this.numberOfPlates++;
      System.out.println(Thread.currentThread().getName() + " has returned a baking plate and there is  "
            + this.numberOfPlates + "  number of baking plates left.");
      notifyAll();
   }

   @Override
   public synchronized void mixABowlOfPancakeBatter() {
      while(this.butterPortions >= 5){
         try {
            wait();
         } catch (InterruptedException e) {
            
         }
      }
   }
   
   @Override
   public synchronized void refillBowl(int butterPortions) {
      this.butterPortions += butterPortions;
      System.out.println(Thread.currentThread().getName() + " has refilled the bowl and there is  "
            + this.butterPortions + "  butter portions left.");
      notifyAll();
   }

}
