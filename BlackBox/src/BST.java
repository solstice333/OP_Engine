/*
 * @authors: Casey Wu, Kevin Navero   
 * @Assignment name: Project 3
 * @Class and section number: CPE103-04
 */

import java.util.*;

/*
 * Description: Creates binary search trees containing Comparable type objects. Methods to insert,
 * delete, find, and traverse the tree are included.
 */
public class BST<T extends Comparable<? super T>>
{
   /*
    * Description: BSTNode contains one element and two BSTNodes that
    * define the left and right subtrees
    */
   private class BSTNode
   {
      T element;
      BSTNode left;
      BSTNode right;
   }

   /*
    * Description: The root of the tree
    */
   private BSTNode root;

   /*
    * Description: Pre-order traversal using iterator. Implements the Iterator<T> 
    * interface.
    */
   private class PreIter implements Iterator<T>
   {
      /*
       * Description: MyStack object declaration
       */
      public MyStack<BSTNode> stk;

      /*
       * Description: Constructor for a PreIter object. Creates empty stack
       * and pushes root to the stack
       */
      public PreIter()
      {
         stk = new MyStack<BSTNode>();
         if (root != null)
            stk.push(root);
      }
      
      /*
       * Description: Returns true if next element in stack exists, false otherwise.
       * Return: true if stack contains elements, false otherwise
       */
      public boolean hasNext()
      {
         return !stk.isEmpty();
      }

      /*
       * Description: Obtains next element in the traversal order
       * Return: returns top element in stack.
       * Exception: throws NoSuchElementException
       */
      public T next()
      {
         if (!hasNext())
            throw new NoSuchElementException();

         BSTNode answer = stk.pop();

         if (answer.right != null)
            stk.push(answer.right);

         if (answer.left != null)
            stk.push(answer.left);

         return answer.element;
      }

      /*
       * Description: unsupported operation
       * Exception: throws UnsupportedOperationException
       */
      public void remove()
      {
         throw new UnsupportedOperationException();
      }
   }

   /*
    * Description: In order traversal of binary search tree. Implements Iterator<T>.
    */
   private class InIter implements Iterator<T>
   {
      /*
       * Description: MyStack object declaration
       */
      public MyStack<BSTNode> stk;

      /*
       * Description: Constructor for InIter object. Creates an empty MyStack object and pushes
       * root to stack then calles stackUpLefts method.
       */
      public InIter()
      {
         stk = new MyStack<BSTNode>();
         if (root != null)
         {
            stk.push(root);
            stackUpLefts(root);
         }
      }

      /*
       * Description: pushes the elements on the left side of the tree into the stack
       * Parameters: BSTNode x contains the treeroot element of which each element in its left subtree
       * is pushed to the stack
       */
      private void stackUpLefts(BSTNode x)
      {
         while (x.left != null)
         {
            stk.push(x.left);
            x = x.left;
         }
      }

      /*
       * Description: Checks to see if next element exists. Returns true if next element exists, false
       * otherwise.
       * Return: true if stack contains elements, false otherwise
       */
      public boolean hasNext()
      {
         return !stk.isEmpty();
      }

      /*
       * Description: Obtains next element in the traversal order
       * Return: next element in the traversal order
       * Exception: NoSuchElementException is thrown if hasNext() returns false
       */
      public T next()
      {
         if (!hasNext())
            throw new NoSuchElementException();

         else
         {
            BSTNode answer = stk.pop();
            if (answer.right != null)
            {
               stk.push(answer.right);
               stackUpLefts(answer.right);
            }
            return answer.element;
         }
      }

      /*
       * Description: Unsupported operation
       * Exception: throws UnsupportedOperationException
       */
      public void remove()
      {
         throw new UnsupportedOperationException();
      }
   }

   /*
    * Description: Level traveral of binary search tree. Implements Iterator<T> interface.
    */
   private class LevelIter implements Iterator<T>
   {
      /*
       * Description: LQueue<BSTNode> object
       */
      public LQueue<BSTNode> que;

      /*
       * Description: Constructor for LevelIter. Creates empty queue and enqueues root to queue.
       */
      public LevelIter()
      {
         que = new LQueue<BSTNode>();
         if (!isEmpty())
            que.enqueue(root);
      }

      /*
       * Description: Checks to see if next element exists in the queue
       * Return: true if queue contains an element, false otherwise
       */
      public boolean hasNext()
      {
         return !que.isEmpty();
      }

      /*
       * Description: Obtains next element in the queue with respect to the traversal order. 
       * Enqueues the next two BSTNodes.
       * Return: front element in the queue
       */
      public T next()
      {
         if (!hasNext())
            throw new NoSuchElementException();

         BSTNode answer = que.dequeue();

         if (answer.left != null)
            que.enqueue(answer.left);

         if (answer.right != null)
            que.enqueue(answer.right);

         return answer.element;
      }

      /*
       * Description: Unsupported operation
       * Exception: UnsupportedOperationException thrown
       */
      public void remove()
      {
         throw new UnsupportedOperationException();
      }
   }

   /*
    * Description: Custom unchecked exception
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
       * Description: constructor that includes a message regarding the exception
       * Parameter: msg is the message regarding the exception
       */
      public MyException(String msg)
      {
         super(msg);
      }
   }

   /*
    * Description: Constructor for binary search tree. Sets root to null.
    */
   public BST()
   {
      root = null;
   }

   /*
    * Description: inserts T type item into the binary tree and calls private insert method
    * Postcondition: binary tree has one additional element
    */
   public void insert(T item)
   {
      root = insert(item, root);
   }

   /*
    * Description: recursive method that inserts the item into its proper place based on structure properties
    * Parameter: item is the item to be inserted
    * Parameter: treeroot is the root of the subtree to be analyzed
    * Return: treeroot containing the added element item
    */
   private BSTNode insert(T item, BSTNode treeroot)
   {
      if (treeroot == null)
      {
         treeroot = new BSTNode();
         treeroot.element = item;
      }

      else
      {
         if (item.compareTo(treeroot.element) < 0)
            treeroot.left = insert(item, treeroot.left);
         else
            treeroot.right = insert(item, treeroot.right);
      }

      return treeroot;
   }
   
   /*
    * Description: deletes T item from the binary tree if it exists and calls private delete method
    * Postcondition: binary tree has one less element if item to be deleted existed
    */
   public void delete(T item)
   {
      root = delete(item, root);
   }

   /*
    * Description: traverses the binary tree until item is deleted or whole tree is searched
    * Parameters: item is the item to be deleted
    * Parameters: treeroot is the root of the subtree to be analyzed
    * Return: treeroot to be deleted 
    */
   private BSTNode delete(T item, BSTNode treeroot)
   {
      if (treeroot != null)
      {
         if (item.compareTo(treeroot.element) < 0)
            treeroot.left = delete(item, treeroot.left);
         else if (item.compareTo(treeroot.element) > 0)
            treeroot.right = delete(item, treeroot.right);
         else
            treeroot = deleteNode(treeroot);
      }

      return treeroot;
   }

   /*
    * Description: if item is found, delete that node from the tree
    * Parameters: x is the BSTNode to delete from the tree
    * Return: answer is the new treeroot 
    * Postcondition: x subtree is restructured such that x's right subtree's smallest element is found
    * to replace the x treeroot. Any duplicates of the smallest element within the x subtree is deleted.
    */
   private BSTNode deleteNode(BSTNode x)
   {
      BSTNode answer;

      if (x.left != null && x.right != null)
      {
         x.element = successor(x);
         x.right = delete(x.element, x.right);
         answer = x;
      }

      else
      {
         if (x.left != null)
            answer = x.left;
         else if (x.right != null)
            answer = x.right;
         else
            answer = null;
      }

      return answer;
   }

   /*
    * Description: given a subtree x, the smallest element is returned from
    * that subtree.
    * Parameters: x is the subtree to be inspected
    * Return: smallest element in the subtree
    */
   private T successor(BSTNode x)
   {
      BSTNode temp = x.right;
      while (temp.left != null)
      {
         temp = temp.left;
      }

      return temp.element;
   }

   /*
    * Description: find T item within the binary tree
    * Parameters: T item is the item to be found
    * Precondition: item is not null
    * Return: true if item is found, false otherwise
    */
   public boolean find(T item)
   {
      return find(item, root);
   }

   /*
    * Description: recursive traversal to find item within tree
    * Parameters: item is the item to be found
    * Parameters: treeroot is the treeroot or subtree root being inspected
    * Return: true if item is found, false otherwise
    */
   private boolean find(T item, BSTNode treeroot)
   {
      boolean answer;

      if (treeroot == null)
         answer = false;
      else if (item.compareTo(treeroot.element) == 0)
         answer = true;
      else if (item.compareTo(treeroot.element) < 0)
         answer = find(item, treeroot.left);
      else
         answer = find(item, treeroot.right);

      return answer;
   }

   /*
    * Description: checks if tree is empty
    * Return: true if tree is empty, false otherwise
    */
   public boolean isEmpty()
   {
      return root == null;
   }

   /*
    * Description: make tree empty
    * Postconditions: tree becomes empty
    */
   public void makeEmpty()
   {
      root = null;
   }

   /*
    * Description: checks the size of the tree
    * Return: size of the tree
    */
   public int size()
   {
      return size(root, 0);
   }

   /*
    * Description: recursive call to count for the nodes of the tree during a traversal
    * Parameters: treeroot is the root of the subtree
    * Parameters: count is the updated count of the nodes
    * Return: total count of all nodes in the binary tree
    */
   private int size(BSTNode treeroot, int count)
   {
      if (treeroot != null)
      {
         count++;
         count = size(treeroot.left, count);
         count = size(treeroot.right, count);
      }

      return count;
   }

   /*
    * Description: finds the minimum value in the binary tree
    * Return: smallest value in the binary tree
    * Exception: throws MyException if empty case
    */
   public T findMinimum()
   {
      if (isEmpty())
         throw new MyException();
      else
      {
         BSTNode temp = root;
         while (temp.left != null)
         {
            temp = temp.left;
         }
         return temp.element;
      }
   }

   /*
    * Description: finds the maximum value in the binary tree
    * Return: largest value in the binary tree
    * Exception: throws MyException if empty case
    */
   public T findMaximum()
   {
      if (isEmpty())
         throw new MyException();
      else
      {
         BSTNode temp = root;
         while (temp.right != null)
         {
            temp = temp.right;
         }
         return temp.element;
      }
   }

   /*
    * Descripton: public accessor method to create pre-order iterator object
    * Return: preorder iterator object
    */
   public Iterator<T> iteratorPre()
   {
      return new PreIter();
   }

   /*
    * Descripton: public accessor method to create in-order iterator object
    * Return: inorder iterator object
    */
   public Iterator<T> iteratorIn()
   {
      return new InIter();
   }

   /*
    * Descripton: public accessor method to create level-order iterator object
    * Return: level-iterator object
    */
   public Iterator<T> iteratorLevel()
   {
      return new LevelIter();
   }

   /*
    * Descripton: traverses the tree and prints all elements with level indentation. Doesn't use iterator.
    */
   public void testPrint()
   {
      testPrint(root, 0);
   }

   /*
    * Description: recursive call for each node, printing out each node with respective level indentation
    */
   private void testPrint(BSTNode treeroot, int cnt)
   {
      if (treeroot != null)
      {
         for (int i = 0; i < cnt; i++)
         {
            System.out.print("   ");
         }
         System.out.println(treeroot.element);

         testPrint(treeroot.left, ++cnt);
         testPrint(treeroot.right, cnt);
      }
   }
}
