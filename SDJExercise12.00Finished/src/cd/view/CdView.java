package cd.view;

import cd.controller.CdController;

public interface CdView
{
   void start(CdController cdController);

   void show(String value);

   String get(String what);
}
