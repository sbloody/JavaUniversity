import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadBible
{

   public static void main(String[] args) throws IOException
   {
      String[] bible = loadFile("./src/bible.txt");
      System.out.println("Bible loaded...");
      String[] dictionary = loadFile("./src/dictionary.txt");
      System.out.println("Dictionary loaded...");
//      numberOfWordsInBible(bible);
//      numberOfCharactersInBible(bible);
//      System.out.println(frequency('a', bible));
//      System.out.println(minCharacterFrequency(bible));
//      System.out.println(maxCharacterFrequency(bible));
//      System.out.println(characterFrequencyTable(bible));
      System.out.println(averageCharacterFrequency(bible));
   }

   public static boolean isInASortedArray(String word, String[] words)
   {
      return isInASortedArray(word, words, 0, words.length - 1);
   }

   private static boolean isInASortedArray(String word, String[] words,
         int start, int end)
   {
      if (start > end)
      {
         return false;
      }
      int middle = (start + end) / 2;
      int compare = word.compareTo(words[middle]);
      if (compare == 0)
      {
         return true;
      }
      if (compare < 0)
      {
         end = middle - 1;
      }
      else
      {
         start = middle + 1;
      }
      return isInASortedArray(word, words, start, end);
   }

   public static String[] loadFile(String filename)
   {
      ArrayList<String> words = new ArrayList<>();
      File file = new File(filename);
      Scanner in = null;
      try
      {
         in = new Scanner(file);
         while (in.hasNext())
         {
            String token = in.next();
            if (!token.matches(".*\\d+.*"))
            {
               Pattern p = Pattern.compile("[^a-z0-9 ]",
                     Pattern.CASE_INSENSITIVE);
               Matcher m = p.matcher(token);
               if (m.find())
               {
                  token = token.replaceAll("[^\\w\\s]", "");
               }
               words.add(token.toLowerCase());
            }
         }
      }
      catch (FileNotFoundException e)
      {
         e.printStackTrace();
      }
      in.close();
      String[] all = new String[words.size()];
      return words.toArray(all);
   }

   public static void numberOfWordsInBible(String[] array)
   {
      System.out.println("Number of words in the bible: " + array.length);
   }

   public static void numberOfCharactersInBible(String[] array)
   {
      int total = 0;
      for (int i = 0; i < array.length; i++)
      {
         total += array[i].length();
      }
      System.out.println("Number of characters in the Bible: " + total);
   }

   public static int frequency(int c, String[] array)
   {
      int count = 0;
      for (int i = 0; i < array.length; i++)
      {
         String temp = array[i];
         for (int j = 0; j < temp.length(); j++)
         {
            if (temp.charAt(j) == c)
               count++;
         }
      }
      return count;
   }

   public static int minCharacterFrequency(String[] array)
   {
      int min = frequency('a', array);
      for (int i = 1; i < 26; i++)
      {
         if (frequency('a' + i, array) < min)
         {
            min = frequency('a' + i, array);
         }
      }
      return min;
   }

   public static int maxCharacterFrequency(String[] array)
   {
      int max = frequency('a', array);
      for (int i = 1; i < 26; i++)
      {
         if (frequency('a' + i, array) > max)
         {
            max = frequency('a' + i, array);
         }
      }
      return max;
   }

   public static String characterFrequencyTable(String[] array)
   {

      String s = "a" + ":" + (double) frequency('a', array)
            / (double) maxCharacterFrequency(array) + "("
            + frequency('a', array) + ")" + "\n";
      for (int i = 1; i < 26; i++)
      {

         double f = (double) frequency('a' + i, array)
               / (double) maxCharacterFrequency(array);
         s += (char) ('a' + i) + ":" + f + "(" + frequency('a' + i, array)
               + ")" + "\n";

      }

      return s;
   }

   public static int averageCharacterFrequency(String[] array)

   {
      int count=0;
      
      
      for(int i=0;i<26;i++)
      {
         count+=frequency('a'+i, array);
         
      }
      int avg=count/26;
      return avg;
   }
}
