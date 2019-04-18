public class CookieMain
{

   public static void main(String[] args)
   {
      CookieJar jar = new CookieJar(20, 5, 24);
      CookieEater e1 = new CookieEater("Mario", jar);
      CookieEater e2 = new CookieEater("Angel", jar);
      CookieEater e3 = new CookieEater("Dani", jar);
      CookieEater e4 = new CookieEater("Edi", jar);
      CookieEater e5 = new CookieEater("Peter", jar);
      CookieBaker b1 = new CookieBaker(jar, "Martin");
      CookieBaker b2 = new CookieBaker(jar, "Veni");
      Thread threade1=new Thread(e1,"Eater1");
      Thread threade2=new Thread(e2,"Eater2");
      Thread threade3=new Thread(e3,"Eater3");
      Thread threade4=new Thread(e4,"Eater4");
      Thread threade5=new Thread(e5,"Eater5");
      Thread threadb1=new Thread(b1, "Baker1");
      Thread threadb2=new Thread(b2, "Baker2");
      threade1.start();
      threade2.start();
      threade3.start();
      threade4.start();
      threade5.start();
      threadb1.start();
      threadb2.start();

   }

}
