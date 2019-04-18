package cd.controller;

import cd.model.domain.Cd;
import cd.model.domain.CdList;
import cd.model.mediator.CdModel;
import cd.view.CdView;

public class CdController
{
   private CdModel model;
   private CdView view;

   public CdController(CdModel model, CdView view)
   {
      this.model = model;
      this.view = view;
   }

   public void execute(String what)
   {
      what = what.toLowerCase();

      if (what.startsWith("list"))

      {
         view.show("" + model.getAll());
      }
      else if (what.startsWith("add"))
      {
         String msg = "Add method - not implemented";
         view.show(msg);
      }
      else if (what.startsWith("remove"))
      {
         String input = view.get("title");
         if (input == null)
            return;
         String msg = "";
         Cd cd = model.removeCd(input);
         if (cd != null)
         {
            msg = "REMOVED: \n" + cd;
         }
         else
         {
            msg = "No CD with title: \"" + input + "\" found";
         }
         view.show(msg);
      }
      else if (what.startsWith("search"))
      {
         String input = view.get("title");
         if (input == null)
            return;
         String msg = "";
         CdList list = model.getCds(input);
         for (int i = 0; i < list.getNumberOfCds(); i++)
         {
            msg += list.getCD(i) + "\n\n\n";
         }
         if (list.getNumberOfCds() == 0)
         {
            msg = "No CD with title: \"" + input + "\" found";
         }
         view.show(msg);
      }
      else if (what.startsWith("quit"))
      {
         System.exit(0);
      }
   }
}
