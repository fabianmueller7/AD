package e2;

import e2.linkedList.Data;
import e2.linkedList.LinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    private LinkedList list;

    @BeforeEach
    void setUp() {
        list = new LinkedList();
        list.add(new Data(10));
        list.add(new Data(15));
        list.add(new Data(13));
        list.add(new Data(11));

    }

    @Test
    void getSize() {
        assertEquals(4, list.getSize());
    }

    @Test
    void add() {
        list.add(new Data(10));
        assertEquals(5, list.getSize());
    }

    @Test
    void getNode() {
        assertEquals(11, list.getNode(0).getData().getDatavalue());
        assertEquals(10, list.getNode(3).getData().getDatavalue());
    }

    @Test
    void removeHead() {
        list.removeHead();
        assertEquals(3, list.getSize());
        assertEquals(13, list.getHead().getData().getDatavalue());
    }

    @Test
    void remove() {
        list.remove(1);
        assertEquals(3, list.getSize());
        assertEquals(15, list.getNode(1).getData().getDatavalue());
    }

    @Test
    void RemoveData() {
        list.remove(new Data(10));
        assertEquals(3, list.getSize());
    }
}