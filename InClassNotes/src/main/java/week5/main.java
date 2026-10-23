package week5;
import QueueInterface;
public class main {
    public static void main(String[] args) {
        LinkedQueue<Integer> temp = new LinkedQueue<>();
        temp.enqueue(5);
        temp.enqueue(7);
        temp.dequeue();
    }
}
