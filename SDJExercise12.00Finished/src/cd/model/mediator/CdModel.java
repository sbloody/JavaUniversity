package cd.model.mediator;

import cd.model.domain.Cd;
import cd.model.domain.CdList;

public interface CdModel
{
   public CdList getAll();

   public void addCd(Cd cd);

   public Cd removeCd(String title);

   public Cd getCd(int index);

   public CdList getCds(String title);

   public int getNumberOfCds();

}
