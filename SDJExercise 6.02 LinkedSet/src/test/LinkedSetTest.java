package test;

import java.util.Iterator;

import utility.collection.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LinkedSetTest
{
   private SetADT<String> set;

   @Before
   public void setUp() throws Exception
   {
      set = new LinkedSet<>();
   }

   @After
   public void tearDown() throws Exception
   {
   }

   @Test
   public void testAddElement()
   {
      set.add("$A$");
      assertTrue(set.size() == 1 && containsAllUsingIterator("$A$"));
      set.add("$B$");
      assertTrue(set.size() == 2 && containsAllUsingIterator("$A$", "$B$"));
      set.add("$B$");
      assertTrue(set.size() == 2 && containsAllUsingIterator("$A$", "$B$"));
      set.add("$C$");
      assertTrue(set.size() == 3
            && containsAllUsingIterator("$A$", "$B$", "$C$"));
      try
      {
         set.add(null);
         assertTrue(set.size() == 4
               && containsAllUsingIterator("$A$", "$B$", "$C$", null));
         set.add(null);
         assertTrue(set.size() == 4
               && containsAllUsingIterator("$A$", "$B$", "$C$", null));
      }
      catch (IllegalArgumentException e)
      {
         // OK
      }
      System.out.println("add:" + set);
   }

   @Test
   public void testRemoveElement()
   {
      set.add("$A$");
      set.add("$B$");
      set.add("$C$");
      set.add("$D$");
      set.remove("$A$"); // first
      assertTrue(set.size() == 3
            && containsAllUsingIterator("$B$", "$C$", "$D$"));
      set.remove("$C$"); // middle
      assertTrue(set.size() == 2 && containsAllUsingIterator("$B$", "$D$"));
      set.remove("$D$"); // last
      assertTrue(set.size() == 1 && containsAllUsingIterator("$B$"));
      set.remove("$B$"); // emptying
      assertTrue(set.size() == 0);

      // add and remove some again
      set.add("$A$");
      set.add("$B$");
      set.add("$C$");
      set.add("$D$");
      set.remove("$A$"); // first
      assertTrue(set.size() == 3
            && containsAllUsingIterator("$B$", "$C$", "$D$"));
      set.remove("$C$"); // middle
      assertTrue(set.size() == 2 && containsAllUsingIterator("$B$", "$D$"));
      set.add("$A2$");
      assertTrue(set.size() == 3
            && containsAllUsingIterator("$B$", "$D$", "$A2$"));
      set.add("$C2$");
      assertTrue(set.size() == 4
            && containsAllUsingIterator("$B$", "$D$", "$A2$", "$C2$"));
      System.out.println(set);
   }

   @Test(expected = IllegalStateException.class)
   public void testRemoveElementException1()
   {
      set.add("$A$");
      set.add("$B$");
      set.add("$C$");
      set.add("$D$");
      set.remove("???");
   }

   @Test(expected = IllegalStateException.class)
   public void testRemoveElementException2()
   {
      set.add("$A$");
      set.add("$B$");
      set.add("$C$");
      set.add("$D$");
      set.remove(null);
   }

   @Test
   public void testContains()
   {
      assertFalse(set.contains("$A$"));
      assertFalse(set.contains(null));
      set.add("$A$");
      set.add("$B$");
      set.add("$C$");
      set.add("$D$");
      assertTrue(set.contains("$A$"));
      assertTrue(set.contains("$B$"));
      assertTrue(set.contains("$C$"));
      assertTrue(set.contains("$D$"));
      assertFalse(set.contains("???"));
      assertFalse(set.contains(null));
      try
      {
         set.add(null);
         assertTrue(set.contains(null));
         assertTrue(set.contains("$B$"));
         assertTrue(set.contains("$D$"));
         assertTrue(set.contains("$C$"));
      }
      catch (IllegalArgumentException e)
      {
         // OK
      }
      System.out.println("contains:" + set);
   }

   @Test
   public void testUnion()
   {
      set.add("A");
      set.add("B");
      set.add("C");
      set.add("D");
      set.add("E");
      set.add("F");

      SetADT<String> otherSet = new LinkedSet<>();
      otherSet.add("B");
      otherSet.add("D");
      otherSet.add("G");
      otherSet.add("H");
      SetADT<String> unionSet = set.union(otherSet);
      try
      {
         set.add(null);
         otherSet.add(null);
         unionSet = set.union(otherSet);
         set = unionSet;
         assertTrue(containsAllUsingIterator("A", "B", "C", "D", "E", "F", "G",
               "H", null));
      }
      catch (IllegalArgumentException e)
      {
         set = unionSet;
         assertTrue(containsAllUsingIterator("A", "B", "C", "D", "E", "F", "G",
               "H"));
      }
      System.out.println("unionSet:" + unionSet);
   }

   @Test
   public void testIntersection()
   {
      set.add("A");
      set.add("B");
      set.add("C");
      set.add("D");
      set.add("E");
      set.add("F");

      SetADT<String> otherSet = new LinkedSet<>();
      otherSet.add("B");
      otherSet.add("D");
      otherSet.add("G");
      otherSet.add("H");
      SetADT<String> intersectionSet = set.intersection(otherSet);
      try
      {
         set.add(null);
         otherSet.add(null);
         intersectionSet = set.intersection(otherSet);
         set = intersectionSet;
         assertTrue(containsAllUsingIterator("D", "B", null));
      }
      catch (IllegalArgumentException e)
      {
         intersectionSet = set.intersection(otherSet);
         set = intersectionSet;
         assertTrue(containsAllUsingIterator("B", "D"));
      }
      System.out.println("intersectionSet:" + intersectionSet);
   }

   @Test
   public void testIntersectionEmpty()
   {
      set.add("A");
      set.add("B");
      set.add("C");
      set.add("D");
      set.add("E");
      set.add("F");

      SetADT<String> otherSet = new LinkedSet<>();
      otherSet.add("I");
      otherSet.add("J");
      otherSet.add("G");
      otherSet.add("H");
      SetADT<String> intersectionSet = set.intersection(otherSet);
      try
      {
         set.add(null);
         intersectionSet = set.intersection(otherSet);
         assertTrue(intersectionSet.isEmpty());
      }
      catch (IllegalArgumentException e)
      {
         intersectionSet = set.intersection(otherSet);
         assertTrue(intersectionSet.isEmpty());
      }
      System.out.println("intersectionSetEmpty:" + intersectionSet);
   }

   @Test
   public void testIsSubSet()
   {
      set.add("A");
      set.add("B");
      set.add("C");

      SetADT<String> otherSet = new LinkedSet<>();
      otherSet.add("D");
      otherSet.add("A");
      otherSet.add("B");
      otherSet.add("C");
      otherSet.add("E");
      assertTrue(set.isSubset(otherSet));
      assertFalse(otherSet.isSubset(set));

      try
      {
         set.add(null);
         assertFalse(set.isSubset(otherSet));
         otherSet.add(null);
         assertTrue(set.isSubset(otherSet));
      }
      catch (IllegalArgumentException e)
      {
       }
      System.out.println("IsSubSet:" + set);
   }

   @Test
   public void testIsSubSetEmpty()
   {
      SetADT<String> otherSet = new LinkedSet<>();
      assertTrue(set.isSubset(otherSet));
      assertTrue(otherSet.isSubset(set));
      System.out.println("IsSubSetEmpty:" + set);
   }

   @Test
   public void testUnion2()
   {
      SetADT<String> otherSet = new LinkedSet<>();
      SetADT<String> unionSet = set.union(otherSet);
      assertTrue(unionSet.isEmpty());
      System.out.println("unionSet2:" + unionSet);
   }
   @Test
   public void testUnionNull()
   {
      set.add(null);
      SetADT<String> otherSet = new LinkedSet<>();
      SetADT<String> unionSet = set.union(otherSet);
      assertTrue(unionSet.size()==1 && unionSet.contains(null));
      System.out.println("unionSet2:" + unionSet);
   }

   @Test
   public void testIsEmpty()
   {
      assertTrue(set.isEmpty());
      set.add("$A$");
      assertFalse(set.isEmpty());
      set.add("$B$");
      set.add("$C$");
      set.add("$D$");
      assertFalse(set.isEmpty());
      set.remove("$B$");
      set.remove("$A$");
      set.remove("$D$");
      set.remove("$C$");
      assertTrue(set.isEmpty());
      try
      {
         set.add(null);
         set.add("$B$");
         assertFalse(set.isEmpty());
         set.remove("$B$");
         assertFalse(set.isEmpty());
         set.remove(null);
         assertTrue(set.isEmpty());
      }
      catch (IllegalArgumentException e)
      {
         // OK
      }
      System.out.println("isEmpty:" + set);
   }

   @Test
   public void testSize()
   {
      assertEquals(0, set.size());
      set.add("$A$");
      assertEquals(1, set.size());
      set.add("$B$");
      set.add("$C$");
      set.add("$D$");
      assertEquals(4, set.size());

      set.remove("$A$");
      assertEquals(3, set.size());
      try
      {
         set.add(null);
         assertEquals(4, set.size());
         set.remove(null);
      }
      catch (IllegalArgumentException e)
      {
         // OK
      }
      System.out.println("size1:" + set);
      set.remove("$B$");
      assertEquals(2, set.size());
      set.remove("$C$");
      set.remove("$D$");
      assertEquals(0, set.size());
      System.out.println("size2:" + set);
   }

   private boolean containsAllUsingIterator(String... s)
   {
      if (s.length != set.size())
      {
         return false;
      }
      Iterator<String> iterator = set.iterator();
      int count = 0;
      while (iterator.hasNext())
      {
         count++;
         String current = iterator.next();
         boolean found = false;
         for (int i = 0; i < s.length; i++)
         {
            if ((current == null && s[i] == null)
                  || (current != null && current.equals(s[i])))
            {
               found = true;
               break;
            }
         }
         if (!found)
         {
            return false;
         }
      }
      return count == s.length;
   }

   private boolean containsAll2(String... s)
   {
      if (s.length != set.size())
      {
         return false;
      }
      for (int i = 0; i < s.length; i++)
      {
         if (!set.contains(s[i]))
         {
            return false;
         }
      }
      return true;
   }

}
