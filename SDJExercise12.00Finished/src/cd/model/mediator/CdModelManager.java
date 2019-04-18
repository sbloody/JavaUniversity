package cd.model.mediator;

import java.io.IOException;

import cd.model.domain.Cd;
import cd.model.domain.CdList;

public class CdModelManager implements CdModel
{
   private CdList list;
   private CdPersistence storage;

   public CdModelManager()
   {
      try
      {
         storage = new CdTextFile("src/cds.txt");
         list = storage.load();

      }
      catch (IOException e)
      {
         list = new CdList(); // empty
      }
   }

   @Override
   public CdList getAll()
   {
      return list;
   }

   @Override
   public void addCd(Cd cd)
   {
      list.addCd(cd);

   }

   @Override
   public Cd removeCd(String title)
   {

      return list.removeFirstCdByTitle(title);
   }

   @Override
   public Cd getCd(int index)
   {

      return list.getCD(index);
   }

   @Override
   public CdList getCds(String title)
   {
      return list.getCdsByTitle(title);
   }

   @Override
   public int getNumberOfCds()
   {
      return list.getNumberOfCds();
   }

}
