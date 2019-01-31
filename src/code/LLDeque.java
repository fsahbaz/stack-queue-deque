package code;

/* 
 * ASSIGNMENT 2
 * AUTHOR:  <Insert Student Name>
 * Class : LLDeque
 *
 * You are not allowed to use Java containers!
 * You must implement the linked list yourself
 * Note that it should be a doubly linked list
 *
 * MODIFY 
 * 
 * */

import given.iDeque;

import java.util.Iterator;

import given.Util;

//If you have been following the class, it should be obvious by now how to implement a Deque wth a doubly linked list
public class LLDeque<E> implements iDeque<E> {
  
  //Use sentinel nodes. See slides if needed
  private Node<E> header;
  private Node<E> trailer;
  private int  size = 0;
  /*
   * ADD FIELDS IF NEEDED
   */
  
  // The nested node class, provided for your convenience. Feel free to modify
  private  class Node<T> {
    private T element;
    private Node<T> next;
    private Node<T> prev;
    /*
     * ADD FIELDS IF NEEDED
     */
    
   Node(T d, Node<T> n, Node<T> p) {
      element = d;
      next = n;
      prev = p;
    }
    
    T getElement() {
    		return element;
    }
    
    Node<T> getNext() {
    		return next;
    }
    
    void setNext(Node<T> n) {
		next = n;
    }
    
    Node<T> getPrev() {
    		return prev;
    }
    
    void setPrev(Node<T> p) {
    		prev = p;
    }
   
    
    /*
     * ADD METHODS IF NEEDED
     */
  }
  
  
  public LLDeque() {
    //Remember how we initialized the sentinel nodes
    header  = new Node<E>(null, null, header);
    trailer = new Node<E>(null, trailer, header);
    header.next = trailer;
    
    /*
     * ADD CODE IF NEEDED
     */
  }
  
  public String toString() {
	if(isEmpty()) return "";  
    StringBuilder sb = new StringBuilder(1000);
    sb.append("[");
    Node<E> tmp = header.next;
    while(tmp.next != trailer) {
      sb.append(tmp.element.toString());
      sb.append(", ");
      tmp = tmp.next;
    }
    sb.append(tmp.element.toString());
    sb.append("]");
    return sb.toString();
  }
  
  /*
   * ADD METHODS IF NEEDED
   */
  
  private void addBtwn(E e, Node<E> pred, Node<E> suc) {
	  
	  Node<E> newN = new Node<>(e, suc, pred);
	  pred.setNext(newN);
	  suc.setPrev(newN);
	  size++;
	  
  }
  
  private E remove(Node<E> tbr) {
	  
	  Node<E> pred = tbr.getPrev();
	  Node<E> suc = tbr.getNext();
	  pred.setNext(suc);
	  suc.setPrev(pred);
	  size--;
	  return tbr.getElement();
	  
  }
  
  /*
   * Below are the interface methods to be overriden
   */

  @Override
  public int size() {
    // TODO Auto-generated method stub
    //Util.NotImplementedYetSoft();
    return size;
  }

  @Override
  public boolean isEmpty() {
    // TODO Auto-generated method stub
	//Util.NotImplementedYetSoft();
	if(size == 0) {
		return true;
	} else {
		return false;
	}
    
    
  }

  @Override
  public void addFront(E o) {
    // TODO Auto-generated method stub
    //Util.NotImplementedYetSoft();
    addBtwn(o,header,header.getNext());  
  }

  @Override
  public E removeFront() {
    // TODO Auto-generated method stub
    //Util.NotImplementedYetSoft();
    if(isEmpty()) {
    		return null;
    } else {
    		return(remove(header.getNext()));
    }
  }

  @Override
  public E front() {
    // TODO Auto-generated method stub
    //Util.NotImplementedYetSoft();
    if(isEmpty()) {
    		return null;
    } else {
    		return header.getNext().getElement();
    }
  }

  @Override
  public void addBehind(E o) {
    // TODO Auto-generated method stub
    //Util.NotImplementedYetSoft();
    addBtwn(o,trailer.getPrev(),trailer);  
  }

  @Override
  public E removeBehind() {
    // TODO Auto-generated method stub
    //Util.NotImplementedYetSoft();
    if(isEmpty()) {
    		return null;
    } else {
    		return(remove(trailer.getPrev()));
    }
  }

  @Override
  public E behind() {
    // TODO Auto-generated method stub
    //Util.NotImplementedYetSoft();
    if(isEmpty()) {
    		return null; 
    } else {
    		return trailer.getPrev().getElement();
    }
  }
  
  @Override
  public void clear() {
    // TODO Auto-generated method stub
	while(!isEmpty()) {
		remove(header.next);
	} 
}
    
  
  
  @Override
  public Iterator<E> iterator() {
    // TODO Auto-generated method stub
    //Hint: Fill in the LLDequeIterator given below and return a new instance of it
    return new LLDequeIterator();
  }
  
  private final class LLDequeIterator implements Iterator<E> {
    
    /*
     * 
     * ADD A CONSTRUCTOR IF NEEDED
     * Note that you can freely access everything about the outer class!
     * 
     */

	private Node<E> n = header.next;
	private Node<E> rec = null;
	  
    @Override
    public boolean hasNext() {
      if(n == trailer) return false;
      return true;
    }

    @Override
    public E next() {
    		if(!hasNext()) return null;
    		rec = n;
    		n = n.next;
    		return rec.getElement();
    }        
  }
  
}
