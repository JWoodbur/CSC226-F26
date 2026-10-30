package week9;

class Patient {
    String name;
    int severity;

    Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }

    @Override
    public String toString() {
        return name + "(" + severity + ")";
    }
}

class HeapPQ {
    private Patient[] heap;
    private int lastIndex = -1;

    HeapPQ(int capacity) {
        heap = new Patient[capacity];
    }

    boolean isEmpty() {
        return lastIndex == -1;
    }

    private void swap(int a, int b) {
        Patient copyA = heap[a];
        heap[a] = heap[b];
        heap[b] = copyA;
    }

    // TODO Round 1: insert p in the next open slot, then restore the max-heap.
    void enqueue(Patient p) {
        lastIndex++;
        heap[lastIndex] = p;
        reheapUp(lastIndex);
    }

    // TODO Round 1: swap upward while a patient's severity is greater than its parent's.
    // Parent of i: (i - 1) / 2
    private void reheapUp(int i) {
        if (i > 0) {
            int parentIndex = (i - 1) / 2;
            if (heap[i].severity > heap[parentIndex].severity) {
                swap(i, parentIndex);
                reheapUp(parentIndex);
            }
        }
    }

    // TODO Round 2: save the root, move the last patient to the root, shrink, and restore the heap.
    Patient dequeue() {
        if (isEmpty()) {
            return null;
        }
        Patient root = heap[0];
        heap[0] = heap[lastIndex];
        lastIndex--;
        reheapDown(0);
        return root;
    }

    // TODO Round 2: swap down with the larger child while the max-heap property is broken.
    // Children of i: 2 * i + 1 and 2 * i + 2
    private void reheapDown(int i) {
        if (i*2 + 1 <= lastIndex && i*2 + 2 <= lastIndex){
            if (heap[i*2+1].severity <= heap[i*2 + 2].severity){
                swap(i, i*2+2);
            }
            else{
                swap(i, i*2+1);
            }

        }
        else if(i*2+1<= lastIndex){
            if (i*2+1 >= i){
                swap(i, i*2+1);
            }
        }
        else{
            System.out.println("No children.");
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i <= lastIndex; i++) {
            result.append(heap[i]);
            if (i < lastIndex) {
                result.append(", ");
            }
        }
        return result.append("]").toString();
    }
}

/**
 * Week 9 team activity: ER triage with a max-heap priority queue.
 * Work in pairs: one person drives while the other traces the heap and checks
 * the result. Switch roles after Round 1.
 */
public class ERTriage {
    public static void main(String[] args) {
        HeapPQ er = new HeapPQ(20);
        String[] names = {"Ana", "Ben", "Cruz", "Dee", "Eli", "Fay", "Gus", "Hal"};
        int[] severities = {3, 7, 5, 9, 2, 8, 6, 1};

        for (int i = 0; i < names.length; i++) {
            er.enqueue(new Patient(names[i], severities[i]));
        }

        System.out.println("CHECKPOINT 1: " + er);
        System.out.println("Treating: " + er.dequeue());
        System.out.println("Treating: " + er.dequeue());
        System.out.println("Ambulance arrives: Ivy(10)");
        er.enqueue(new Patient("Ivy", 10));

        while (!er.isEmpty()) {
            System.out.println("Treating: " + er.dequeue());
        }
    }
}
