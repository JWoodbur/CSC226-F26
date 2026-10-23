package week5;

public class LinkedQueue<T> implements QueueInterface<T> {
    private LLNode<T> front;
    private LLNode<T> rear;
    public int numElements = 0;

    @Override
    public void enqueue(T element) {
        LLNode<T> newNode = new LLNode<T>(element);
        if (isEmpty()){
            front = newNode;
            rear = front;
        }
        else{
            rear.setNext(newNode);
        }
        numElements++;
    }

    @Override
    public T dequeue() {
        T memory = front.getInfo();
        if (isEmpty()){
            return null;
        }
        if (front.getNext() != null){
        front = front.getNext();
        }
        numElements--;
        return memory;
        

    }

    @Override
    public boolean isFull() {
        throw new UnsupportedOperationException("");
    }

    @Override
    public boolean isEmpty() {
        if (numElements == 0){
        return true;
        }
        else return false;
    }
}