/*
 * @authors: Casey Wu, Kevin Navero  
 * @Assignment name: Project 3
 * @Class and section number: CPE103-04
 */

import java.util.*;

/*
 * Description: class MyStack<T> is a linked list implementation of stack. 
 * Includes methods push(T value), pop(), peek(), isEmpty().
 */
public class MyStack<T> 
{
   /*
    * Description: starting node for each instance of MyStack
    */
   private Node start;
   
   /*
    * Description: constructor for creating a new empty stack.
    */
   public MyStack()
   {
      start = null;
   }
   
   /*
    * Description: adds an element to the top of the stack
    * Parameters: value contains the element to add to the top of the stack
    * Postconditions: value is added to the top of the stack
    */
   public void push(T value)
   {
      Node temp = new Node();
      temp.element = value;
      temp.link = start;
      start = temp;
   }
   
   /*
    * Description: removes an element from the top of the stack if stack is not empty and returns that element
    * Return value: returns element at the top of the stack
    * Exceptions: EmptyStackException type exception is thrown if the stack is empty
    * Postconditions: if the stack is not empty, the top element is removed
    */
   public T pop()
   {
      if(isEmpty())
         throw new EmptyStackException();
      else
      {
         T temp = start.element;
         start = start.link;
         return temp;
      }  
   }
   
   /*
    * Description: returns the value at the top of the stack without removing it
    * Return value: returns element at the top of the stack
    * Exceptions: EmptyStackException type exception is thrown if stack is empty
    */
   public T peek()
   {
      if(isEmpty())
         throw new EmptyStackException();
      else
         return start.element;
   }
   
   /*
    * Description: checks if the stack is empty. Returns true if stack is empty, false otherwise
    * Return value: returns true if stack is empty, false otherwise
    */
   public boolean isEmpty()
   {
      if(start == null)
         return true;
      else
         return false;
   }
   
   /*
    * Description: Node class defines the properties of a node - element and link.
    */
   private class Node 
   {
      T element;
      Node link;
   }
}
