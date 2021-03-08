package ir.sk.datastructure.queue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CircularQueueTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void enqueue() {
        CircularQueue<Integer> c = new CircularQueue<>(10);
        for (int i = 0; i < 10; i++) {
            c.enqueue(i);
        }

        System.out.println("\nTest dequeue():");
        for (int i = 0; i < 5; i++) {
            System.out.printf("(%d) %s\n", c.dequeue(), c);
        }

        System.out.printf("\nSize: %d, MaxSize: %d\n", c.size(), c.maxSize());

        System.out.println("\nTest enqueue():");
        for (int i = 10; i < 15; i++) {
            c.enqueue(i);
            System.out.printf("(%d) %s\n", i, c);
        }
    }

    @Test
    public void dequeue() {
    }

    @Test
    public void peek() {
    }
}