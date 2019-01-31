package code;

import given.Util;
import given.iDeque;

/* 
 * ASSIGNMENT 2
 * AUTHOR:  <Insert Student Name>
 * Class : Stack
 *
 * You are not allowed to use Java containers!
 * You must implement the linked list yourself
 * Note that it should be a doubly linked list
 *
 * MODIFY 
 * 
 * */

import given.iSimpleContainer;


//Stack Implementation
//E is the element type
//C is the underlying Deque type
public class Stack<C extends iDeque<E>, E> implements iSimpleContainer <E>{
  
//C is generic. It indicates the type of the deque to store the elements
  //E is generic. It indicates the type of data to be stored in the deque


  C deque;
  
  public Stack(C inDeque){
    deque = inDeque;
    /*
     * ADD CODE IF NEEDED
     * 
     */
  }
  
  public String toString() {
    return deque.toString();
  }
  
  
  /*
   * Below are the interface methods to be overriden
   */
  
  @Override
  public void push(E obj) {
    // TODO Auto-generated method stub
    //Util.NotImplementedYetSoft();
	  deque.addBehind(obj);
  }

  @Override
  public E pop() {
    // TODO Auto-generated method stub
    //Util.NotImplementedYetSoft();
    if(deque.isEmpty()) {
    		return null;
    } else {
    		return deque.removeBehind();
    }
  }

  @Override
  public E peek() {
    // TODO Auto-generated method stub
    //Util.NotImplementedYetSoft();
    if(deque.isEmpty()) {
    		return null;
    } else {
    		return deque.behind();
    }
  }

@Override
public int size() {
	return deque.size();
}

@Override
public boolean isEmpty() {
	if(deque.isEmpty()) return true;
	return false;
}

@Override
public void clear() {
	// TODO Auto-generated method stub
	while(!isEmpty()) {
		deque.removeBehind();
	}
	
}

}
