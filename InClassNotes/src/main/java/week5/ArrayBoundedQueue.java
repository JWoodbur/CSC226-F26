package week5;

public class ArrayBoundedQueue<T> implements QueueInterface<T> {
    @Override
    public void enqueue(T element) {
        if (isFull()){
        throw new UnsupportedOperationException("Not implemented");
    }
        else{
            rear =  (rear+1)%elements.length;
            elements[rear]=element;
            numElements=numElements + 1;
        }
    }

    @Override
    public T dequeue() {
        if(isEmpty()){
        throw new UnsupportedOperationException("Not implemented");
        }
    else{
        T toReturn = elements[front];
        elements[front] = null;
        front = (front + 1)% elements.length;
        numElements = numElements - 1;
        return toReturn; 
    }
    }

    @Override
    public boolean isFull() {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not implemented");
    }
}