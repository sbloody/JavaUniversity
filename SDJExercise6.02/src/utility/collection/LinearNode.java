package utility.collection;

public class LinearNode<T>
{
   private T element;
   private LinearNode<T> next;
   
   public LinearNode()
   {
      this.element=null;
      this.next=null;
   }
   
   public LinearNode(T elemt)
   {
      this.element=elemt;
      this.next=null;
   }
   
   public LinearNode(T elemt, LinearNode<T> next)
   {
      this.element=elemt;
      this.next=next;
   }
   
   public LinearNode<T> getNext()
   {
      return next;
   }
   
   public void setNext(LinearNode<T> node)
   {
      this.next=node;
   }
   
   public T getElement()
   {
      return element;
   }
   
   public void setElement(T elem)
   {
      this.element=elem;
   }
}
