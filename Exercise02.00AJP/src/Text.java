public class Text
{
   private String text;

   public Text(String text)
   {
      this.text = text;
   }

   public String getText()
   {
      return text;
   }

   public String toString()
   {
      return "Text: " + this.text;
   }

   public boolean isPalindromIterative()
   {
      return isPalindromeLoop(text);
   }
   public boolean isPalindrome()
   {
      return isPalindrome(text, 0, text.length() - 1);
   }

   public String reverseString()
   {
      return reverseString(text, text.length() - 1);
   }

   private static String reverseString(String s, int last)
   {
      if (last < 0)
      {
         return "";

      }

      return s.charAt(last) + reverseString(s, last - 1);
   }

   private static boolean isPalindrome(String text, int left, int right)
   {

      if (left >= right)
      {
         return true;

      }
      while ((text.charAt(left) >= 'a' && text.charAt(right) <= 'z')
            || (text.charAt(left) >= 'A' && text.charAt(right) <= 'Z'))
      {
         left++;
         right--;
      }
      return (Character.toLowerCase(text.charAt(left)) == Character
            .toLowerCase(text.charAt(right)))
            && isPalindrome(text, left + 1, right - 1);
   }

   private static boolean isPalindromeLoop(String text)
   {

      String reverse = "";
      for (int i = text.length() - 1; i >= 0; i--)
      {
         reverse += text.charAt(i);
      }
      if (text.equals(reverse))
         return true;
      return false;
   }
   
  
}
