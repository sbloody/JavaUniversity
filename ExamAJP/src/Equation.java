public class Equation
{
   public static double secant(Function fct, double x0, double x1,
         double epsilon)
   {
      //I can't understand the exercise ??
      // if (Math.abs(x1 - x0) < epsilon)
      // {
      // double a = fct.f(x0);
      // double b = fct.f(x1);

     
      double c = (x0 * fct.f(x1) - x1 * fct.f(x0)) / ((fct.f(x1) - fct.f(x0)));
      if(Math.abs(c-x1)<epsilon)
         return c;
      else return -1;
      
//      if (Math.abs(c - x1) < epsilon)
//         return c;
     
      // if((fct.f(x0)<0))
      // {
      // x0=fct.f(x0);
      // }
      //
      // if(fct.f(x1)>0)
      // {
      // x1=fct.f(x1);
      // }
      // return c;

//      return -1;
      // System.out.println(a);
      // System.out.println(b);
      //
      // double c = (x0 * b - x1 * a) / (b - a);
      // if (Math.abs(c - x1) < epsilon)
      // return c;
      // return -1;
   }

    public static double secRec(Function fct, double x0, double x1,
    double epsilon)
    {
   
    double c = (x0 * fct.f(x1) - x1 * fct.f(x0)) / (fct.f(x1) - fct.f(x0));
    if(Math.abs(c-x1)<epsilon)
       return c;
    return secRec(fct, x0, x1, epsilon);
   
    }

   public static void main(String[] args)
   {
      Secant s = new Secant();
      System.out.println(secant(s, 3, 4, 2));
       System.out.println(secRec(s, 3, 4, 2));
   }
}
