package utility.collection;

import java.io.File;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Scanner;

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

   private static String[] getFromFile(String filename)
   {
      ArrayList<String> lines = new ArrayList<>();
      try
      {
         File file = new File(filename);
         Scanner in = new Scanner(file);
         while (in.hasNext())
         {
            lines.add(in.nextLine().toLowerCase());
         }
         in.close();
      }
      catch (Exception e)
      {
         //
      }
      String[] all = new String[lines.size()];
      return lines.toArray(all);

   }

   private static boolean isIn(String word, String[] words, int start, int end)
   {
      if (start > end)
         return false;
      int middle = (start + end) / 2;
      if (word.compareTo(words[middle]) == 0)
         return true;
      if (word.compareTo(words[middle]) > 0)
         start = middle + 1;
      else
         end = middle - 1;
      return isIn(word, words, start, end);
   }

   public boolean isInDictionary()
   {
      String[] dictionary = getFromFile("dictionary.txt");
      return isIn(this.text, dictionary, 0, dictionary.length - 1);

   }

   // @Override
   // public int compareTo(Object o)
   // {
   //
   // if(text instanceof String)
   // {
   // if(text.charAt(0) )
   // }
   // return 0;
   // }
}
