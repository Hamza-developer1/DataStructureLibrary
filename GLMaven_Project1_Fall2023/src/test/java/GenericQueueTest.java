import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GenericQueueTest {

    GenericQueue<Integer> queue;

    @BeforeEach
    void IntegerSetup() {
        queue = new GenericQueue<Integer>(1);
    }
    @Test
    public void testConstructor() {

        GenericQueue<Integer> queue = new GenericQueue<>(42);

        assertEquals(42, queue.getHead().data);
        assertEquals(1, queue.getLength());
    }

    @Test
    void QueueLength() {
        assertEquals(1, queue.getLength());
    }

    @Test
    void enqueueTest() {
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        assertEquals(1, queue.getHead().data);
        assertEquals(4, queue.getLength());
    }
    @Test
    void addTest() {
        queue.add(2);
        queue.add(3);
        queue.add(4);
        assertEquals(1, queue.getHead().data);
        assertEquals(4, queue.getLength());
    }


    @Test
    void dequeueTest() {
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.dequeue();
        queue.dequeue();
        assertEquals(2, queue.getLength());
        assertEquals(3, queue.getHead().data);
    }

    @Test
    void deleteTest() {
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.delete();
        queue.delete();
        assertEquals(2, queue.getLength());
        assertEquals(3, queue.getHead().data);
    }


    @Test
    void enqueueAndReverseQueue() {
        queue.enqueue(1);
        queue.enqueue(6);
        queue.enqueue(5);
        queue.enqueue(0);
        Iterator<Integer> revIter = queue.descendingIterator();
        for ( Integer each: queue) {
            System.out.println(each);
        }
        while(revIter.hasNext()) {
            System.out.println(revIter.next());
        }
        System.out.println("looool");
        queue.print();
    }

    @Test
    void Iterator() {

        queue.enqueue(2);
        queue.enqueue(3);

        int[] arr = new int[]{1,2, 3};
        int i = 0;

        for (Integer integer : queue){
            assertEquals(arr[i], integer);
            System.out.print(integer + " ");
            i++;
        }
    }

    @Test
    void reverseIterator() {

        queue.enqueue(2);
        queue.enqueue(3);

        int[] arr = new int[]{1, 2, 3};

        int i = 2;
        int actual;
        Iterator<Integer> reverse = queue.descendingIterator();

        while (reverse.hasNext()){
            actual = reverse.next();
            System.out.print(actual + " ");
            assertEquals(arr[i], actual);
            i--;
        }

        System.out.println();
    }


}
