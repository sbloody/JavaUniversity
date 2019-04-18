
public class Main {

   public static void main(String[] args) {
      
      PancakeCooking cooking = new CampsitePancakeCooking();
      
      Camper camper1 = new Camper(cooking);
      Camper camper2 = new Camper(cooking);
      Camper camper3 = new Camper(cooking);
      
      CampsiteOwner CO = new CampsiteOwner(cooking);
      
      Thread thread = new Thread(CO, "Mamina");
      Thread thread1 = new Thread(camper1, "Denis");
      Thread thread2 = new Thread(camper2, "David");
      Thread thread3 = new Thread(camper3, "Daniel");
      
      thread.start();
      thread1.start();
      thread2.start();
      thread3.start();
      
   }

}
