public class CampsiteOwner implements Runnable{
   
   
   private PancakeCooking pancakeCooking;
   
   public CampsiteOwner(PancakeCooking pancakeCooking){
      this.pancakeCooking = pancakeCooking;
   }  

   @Override
   public void run() {
   
      while(true){
         this.pancakeCooking.mixABowlOfPancakeBatter();
         this.pancakeCooking.refillBowl(2);
         refill();
      }
      
   }
   
   private void refill(){
      System.out.println(Thread.currentThread().getName() + " is mixing butter.");
      try {
         Thread.sleep(3500);
      } catch (InterruptedException e) {
         
      }

   }

}
