public class LinearNode<T>
{

   private T element;
   private LinearNode<T> next;

   public LinearNode()
   {
      this.element = null;
   }

   public LinearNode(T elemnt)
   {
      this.element = elemnt;
   }

   public LinearNode(T elemnt, LinearNode<T> next)
   {
      this.element = elemnt;
      this.next = next;
   }

   public LinearNode<T> getNext()
   {
      return next;
   }

   public void setNext(LinearNode<T> node)
   {
      this.next = node;
   }

   public T getElement()
   {
      T temp = this.element;
      return temp;
   }

   public void setElement(T elem)
   {
      this.element = elem;
   }
}
