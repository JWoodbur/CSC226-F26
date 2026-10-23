package medical_action_tracking;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class studentTests{
@Test
void queueTrasitionsBetweenEmptyAndNonEmptyStates() {
    LinkedQueue<String> queue = new LinkedQueue<>();

    assertTrue(queue.isEmpty());
    assertEquals(0, queue.size());
    assertNull(queue.peekFront());
    assertNull(queue.dequeue());

    queue.enqueue("first");
    assertFalse(queue.isEmpty());
    assertEquals(1, queue.size());
    assertEquals("first", queue.peekFront());

    queue.enqueue("second");
    assertEquals(2, queue.size());
    assertEquals("first", queue.peekFront());

    assertEquals("first", queue.dequeue());
    assertEquals(1, queue.size());
    assertEquals("second", queue.peekFront());

    assertEquals("second", queue.dequeue());
    assertTrue(queue.isEmpty());
}

@Test
void sameLanePatientsAreTreatedInFifoOrder() {
    LinkedQueue<String> queue = new LinkedQueue<>();

    queue.enqueue("P001");
    queue.enqueue("P002");
    queue.enqueue("P003");

    assertEquals("P001", queue.dequeue());
    assertEquals("P002", queue.dequeue());
    assertEquals("P003", queue.dequeue());
}

@Test 
void recursiveDisplayDoesNotModifyQueue() {
    LinkedQueue<String> queue = new LinkedQueue<>();
    queue.enqueue("alpha");
    queue.enqueue("beta");
    queue.enqueue("gamma");

    int originalSize = queue.size();

    assertEquals("[alpha, beta, gamma]", queue.toString());
    assertEquals(originalSize, queue.size()); 
    assertEquals("alpha", queue.peekFront());
    assertEquals("alpha", queue.dequeue());
}

@Test 
void stackRemovesItemsInLifoOrder() {
    LinkedStack<String> stack = new LinkedStack<>();

    stack.push("first");
    stack.push("second");
    stack.push("third");

    assertEquals("third", stack.pop());
    assertEquals("second", stack.pop());
    assertEquals("first", stack.pop());
    assertTrue(stack.isEmpty());
}

@Test
void displayHistoryDoesNotModifyStack() {
    LinkedStack<String> stack = new LinkedStack<>();
    stack.push("A");
    stack.push("B");
    stack.push("C");

    int originalSize = stack.size();

    assertEquals("[C, B, A]", stack.toString());
    assertEquals(originalSize, stack.size());
    assertEquals("C", stack.peek());
    assertEquals("C", stack.pop());
}

@Test
void rejectsNullItems() {
    LinkedQueue<String> queue = new LinkedQueue<>();
    LinkedStack<String> stack = new LinkedStack<>();

    assertThrows(IllegalArgumentException.class, () -> queue.enqueue(null));
    assertThrows(IllegalArgumentException.class, () -> stack.push(null));
}
}