import cd.controller.CdController;
import cd.model.mediator.CdModel;
import cd.model.mediator.CdModelManager;
import cd.view.CdView;
import cd.view.CdGUI;

public class Main
{
   public static void main(String args[])
   {
      try
      {
         CdModel model = new CdModelManager();
         CdView view = new CdGUI();
         CdController controller = new CdController(model, view);
         view.start(controller);
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
   }
}