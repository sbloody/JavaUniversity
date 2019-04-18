package cd.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import cd.controller.CdController;

public class ButtonHandler implements ActionListener
{

   private CdController cdController;

   public ButtonHandler(CdController cdController)
   {

      this.cdController = cdController;
   }

   @Override
   public void actionPerformed(ActionEvent e)
   {
      String buttonLabel = e.getActionCommand();
      cdController.execute(buttonLabel);

   }
}