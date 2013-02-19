/*
 * @authors: Casey Wu, Kevin Navero  
 * @Assignment name: Project 3
 * @Class and section number: CPE103-04
 */

/*
 * Description: Linked list implementation queue
 */
public class LQueue<T>
{
   /*
    * Description: front of queue
    */
   private Node front;
   
   /*
    * Description: end of queue
    */
   private Node end;

   /*
    * Description: constructor to create empty queue object
    */
   public LQueue()
   {
      front = null;
      end = null;
   }

   /*
    * Description: enqueue(add) item to the end of queue
    * Parameters: item is the item to add
    * Precondition: item is not null
    * Postcondition: item is added to the end of queue
    */
   public void enqueue(T item)
   {
      Node temp = new Node();
      temp.element = item;
      temp.link = null;

      if (isEmpty())
      {
         front = temp;
         end = temp;
      }

      else
      {
         end.link = temp;
         end = temp;
      }
   }

   /*
    * Description: dequeue(removes) front element
    * Return: removed element
    * Exception: throws MyException if queue is empty
    * Postcondition: removes front element from queue
    */
   public T dequeue()
   {
      if (isEmpty())
      {
         throw new MyException("Queue empty");
      }

      else
      {
         T remove = front.element;
         front = front.link;
         return remove;
      }
   }

   /*
    * Description: checks if queue is empty
    * Return: true if queue is empty, false otherwise
    */
   public boolean isEmpty()
   {
      return front == null;
   }

   /*
    * Description: unchecked MyException class
    */
   public static class MyException extends RuntimeException
   {
      /*
       * Description: default constructor
       */
      public MyException()
      {
         super();
      }

      /*
       * Description: constructor including a message associated to the exception
       */
      public MyException(String msg)
      {
         super(msg);
      }
   }

   /*
    * Description: Node containing element and link
    */
   private class Node
   {
      T element;
      Node link;
   }
}
