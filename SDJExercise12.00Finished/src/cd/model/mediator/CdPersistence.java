package cd.model.mediator;

import java.io.IOException;

import cd.model.domain.Cd;
import cd.model.domain.CdList;

public interface CdPersistence
{
   public CdList load() throws IOException;

   public void save(CdList cdList) throws IOException;

   public void save(Cd cd) throws IOException;

   public void remove(Cd cd) throws IOException;

   public void clear() throws IOException;
}
