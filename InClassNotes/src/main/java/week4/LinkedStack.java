package week4;
import week3.StackInterface;

public class LinkedStack<T> implements StackInterface<T> {
    private LLNode<T> top;

    public LinkedStack(){
        this.top=null;
    }

    public void push(T element){
        Node temp = new Node(x);
        temp.next = top;
        top = temp;
        //Push an element to the top of the stack
    }
    public T pop(){
        if (top == null){
            System.out.println("Stack Underflow");
            return -1;
        }

        Node temp = top;
        top = top.next;
        int val = temp.info;
        temp = null;
        return val;
        //remove an element from the top of the stack
        //note: what preconditions do we care about?
      
    }
    public T top(){
        if (top == null){
            System.out.println("Stack is empty.com");
            return -1;
        }
        //return the data in the element from the top of the stack
        //note: what preconditions do we care about?
        return top.info; // placeholder
    }

    public boolean isEmpty(){
        return top == null;
    }
    public boolean isFull(){
        return true; //placeholder
        //ts will never be full
    }
}