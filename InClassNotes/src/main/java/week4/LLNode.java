package week4;

public class LLNode<T> {
    T info;
    LLNode<T> next;

    public LLNode(T info){
        info = T;
        next = null;
        //constructor for our Node
    }
    public void setNext(T next){
        this.next = next;

        //Setter for the node object
    }
    public LLNode<T> getNext(){
       //get the next node in the chain
       return next; //placeholder 
    }
    public void setInfo(T info){
        this.info = info;
        //set the nodes info
    }
    public T getInfo(){
        //get the nodes info
        return T.info;//placeholder
    }
}