package week3;

import java.nio.channels.IllegalSelectorException;

public class ArrayBoundedStack<T> implements StackInterface<T> {
    private final int DEFAULTCAP = 100;
    private T[] elements;
    private int topIndex=-1;

    public ArrayBoundedStack(){
        elements = (T[]) new Object[DEFAULTCAP];
    }
    public ArrayBoundedStack(int maxSize){
        elements = (T[]) new Object[maxSize];
    }
    public boolean isEmpty()
    {
        //TODO: how do we determine if the stack is empty? Implement this method
        return false;
    }

    public boolean isFull()
    {
        //TODO: How do we determine if the stack is full? Implement this method
        return false;
    }
    
    public void push(T element)
    {
        // TODO: How do we add an element to the stack? Implement this method
        if (isFull()){
            throw new IllegalStateException("ts full");
        }
       elements[++topIndex] = element;
    }
    
    public void pop()
    {
        if (isEmpty()){
            throw new IllegalStateException("ts empty");
        }
        T element = elements[topIndex];
        elements[topIndex--] = null;
        // How do we remove an element from the stack? Implement this method
        
    }
    
    public T top()
    {
      // How do we return the top element of the stack without removing it? Implement this method
      return elements[topIndex];   
    }
}