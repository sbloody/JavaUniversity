
public class Main
{

   public static void main(String[] args)
   {
      PizzaMethods monitor= new PizzaMethods();
      ScrumMasterThread scrum=new ScrumMasterThread(monitor);
      TeamMemberThread member1=new TeamMemberThread(monitor);
      TeamMemberThread member2=new TeamMemberThread(monitor);
      PizzaGuyThread guy=new PizzaGuyThread(monitor);
      Thread t1=new Thread(member1,"Team member 1");
      Thread t2=new Thread(member2, "Team member 2");
      Thread t3=new Thread(scrum, "Scrum master");
      Thread t4=new Thread(guy, "Pizza guy");
      t1.start();
      t2.start();
      t3.start();
      t4.start();
      
      
      

   }

}
