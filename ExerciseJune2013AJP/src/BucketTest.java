import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class BucketTest
{

   @Before
   public void setUp() throws Exception
   {
   }

   @After
   public void tearDown() throws Exception
   {
   }

   @Test
   public void testInsert()
   {
      Bucket bucket=new Bucket(10);
      bucket.insert(5);
      assertEquals(5,bucket.);
   }

}
