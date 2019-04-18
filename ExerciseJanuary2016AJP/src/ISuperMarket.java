
public interface ISuperMarket
{
   void enterWaitingLine(); // One more customer is ready to be served,                            
                             // and notifies about it.                            
                              // While customer has not been served, he/she is       waiting.  
   void startNextServing(); // The cashier serves next customer.                           
   // While no customer, the cashier is waiting.  
   
   void serviceFinished (); // The cashier has finished the service,                           
   // and notifies the next customer to be served. 
}
