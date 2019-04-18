
public class Bisection
{
   public static double bisectionRec(Function fct, double a, double b,
         double epsilon)
   {
      double midpoint = (b + a) / 2;
      while (Math.abs(b - a) > epsilon)
      {
         if ((fct.f(a) * fct.f(midpoint)) > 0)
         {
            return bisectionRec(fct, midpoint, b, epsilon);
         }
         else
            return bisectionRec(fct, a, midpoint, epsilon);

      }
      return midpoint;

   }
//   public static void main(String[] args)
//   {
//      Function sinus = new Sinus();
//      System.out.println(bisectionRec(sinus, (Math.PI/2), (3*Math.PI)/2, 0.0001));
//   }
}
