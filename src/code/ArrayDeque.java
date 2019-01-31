package code;

/* 
 * ASSIGNMENT 2
 * AUTHOR:  <Insert Student Name>
 * Class : ArrayDeque
 *
 * You are not allowed to use Java containers!
 * You must implement the Array Deque yourself
 *
 * MODIFY 
 * 
 * */

import given.iDeque;

import java.util.Arrays;
import java.util.Iterator;
import given.Util;


//BARIS: May need to give them some pointers on how an arraydeque works
public class ArrayDeque<E> implements iDeque<E> {

  private E[] A;
  private int f = 0;
  private int size = 0;


  /*
   * ADD FIELDS IF NEEDED
   */
	
	public ArrayDeque() {
		this(1000);
    /*
     * ADD CODE IF NEEDED
     */
	}
	
	public ArrayDeque(int initialCapacity) {
	   if(initialCapacity < 1)
	      throw new IllegalArgumentException();
		A = createNewArrayWithSize(initialCapacity);
		
		/*
		 * ADD CODE IF NEEDED
		 */
	}
	
	// This is given to you for your convenience since creating arrays of generics is not straightforward in Java
	@SuppressWarnings({"unchecked" })
  private E[] createNewArrayWithSize(int size) {
	  return (E[]) new Object[size];
	}
	
	//Bonus: Modify this such that the dequeue prints from front to back!
	
	public String toString() {
	if(isEmpty()) return "";
    StringBuilder sb = new StringBuilder(A.length);
    sb.append("[");
    Iterator<E> iter = iterator();
    while(iter.hasNext()) {
      E e = iter.next();
      if(e == null)
        continue;
      sb.append(e);
      if(!iter.hasNext())
        sb.append("]");
      else
        sb.append(", ");
    }
    return sb.toString();
  }
	
  /*
   * ADD METHODS IF NEEDED
   */
  
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
	  
	if(size == A.length) {
		E temp[] = createNewArrayWithSize(2*A.length);
		for(int i=0; i<size-1;i++) {
			temp[i] = A[i];
		}
		f = 0;
		A = temp;
	} 
	f = ((f - 1 + A.length) % A.length);
	A[f] = o;
	size++;
  }

  @Override
  public E removeFront() {
    // TODO Auto-generated method stub
    //Util.NotImplementedYetSoft();
    if(isEmpty()) {
    		return null;
    } else {
    		E ans = A[f];
    		A[f] = null;
    		f = ((f + 1) % A.length);
    		size--;
    		return ans;
    }
  }

  @Override
  public E front() {
    // TODO Auto-generated method stub
    //Util.NotImplementedYetSoft();
    if(isEmpty()) {
    		return null;
    } else {
    		return A[f];
    }
  }

  @Override
  public void addBehind(E o) {
    // TODO Auto-generated method stub
    //Util.NotImplementedYetSoft();
    if(size == A.length) {
    		E[] temp = createNewArrayWithSize(2*A.length);
    		for(int i=0; i<size-1; i++) {
    			temp[i] = A[i];
    		}
    		f = 0;
    		A = temp;
    }
    A[(f + size) % A.length] = o;
    size++;
    
  }

  @Override
  public E removeBehind() {
    // TODO Auto-generated method stub
    //Util.NotImplementedYetSoft();
    if(isEmpty()) {
    		return null;
    } else {
    		E ans = A[(f + size - 1) % A.length];
    		A[(f + size - 1) % A.length] = null;
    		size--;
    		return ans;
    }
  }

  @Override
  public E behind() {
    // TODO Auto-generated method stub
    //Util.NotImplementedYetSoft();
    if(isEmpty()) {
    		return null;
    } else {
    		return A[(f + size -1) % A.length];
    }
  }
  
  @Override
  public void clear() {
    // TODO Auto-generated method stub
	for(int i=0; i<A.length; i++) {
		A[i] = null;
	}
	size = 0;
	f = 0;
    
  }
  
  //Must print from front to back
  @Override
  public Iterator<E> iterator() {
    // TODO Auto-generated method stub
    //Hint: Fill in the ArrayDequeIterator given below and return a new instance of it
    return new ArrayDequeIterator();
  }
  
  private final class ArrayDequeIterator implements Iterator<E> {
    
    /*
     * 
     * ADD A CONSTRUCTOR IF NEEDED
     * Note that you can freely access everything about the outer class!
     * 
     */

	private int sizeCont = 0;
	private int j = f;
	  
    @Override
    public boolean hasNext() {
    		if(sizeCont < size) return true;
    		return false;
    }

    @Override
    public E next() {
    	
    		if(sizeCont == size) return null;
    		sizeCont++;
    		return A[(j++) % A.length];
    	
    }        
  }  
}


