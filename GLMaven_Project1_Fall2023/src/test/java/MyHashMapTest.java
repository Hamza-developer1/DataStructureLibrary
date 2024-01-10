import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyHashMapTest {
    MyHashMap<Integer> map;

    @BeforeEach
    void setUp() {
        map = new MyHashMap<Integer>("Dog", 1);
    }

    @Test
    void constructor() {
        MyHashMap<Integer> ID = new MyHashMap<>("License", 1234);
        assertEquals(1, ID.size());
        assertEquals(1234, ID.get("License"));
    }

    @Test
    void put() {
        map.put("Turtle", 3);
        map.put("Parrot", 4);
        map.put("Fish", 95);
        map.put("Lion", 75);

        assertEquals(5, map.size());
        assertEquals(75, map.get("Lion"));

    }

    @Test
    void putCollisionTest(){
        map.put("Elephant", 1);
        map.put("Tiger", 1);
        assertEquals(3, map.size());
        assertEquals(1, map.get("Tiger"));
    }

    @Test
    void contains() {
        map.put("Hyena", 10);
        map.put("Cheetah", 11);
        map.put("Hippo", 13);


        assertEquals(4, map.size());
        assertTrue(map.contains("Hyena"));
        assertFalse(map.contains("Zebra"));

    }

    @Test
    void get() {
        map.put("Donkey", 6);
        map.put("Horse", 7);
        map.put("Gorilla", 9);

        assertEquals(4, map.size());
        assertEquals(7, map.get("Horse"));
        assertEquals(null, map.get("Zebra"));
    }

    @Test
    void size() {
        map.put("Cat", 2);
        assertEquals(2, map.size());
    }

    @Test
    void isEmpty(){
        map.put("Giraffe", 2);
        assertFalse(map.isEmpty());
    }

    @Test
    void replace(){
        map.put("Spider", 14);
        map.put("Cricket", 15);

        map.replace("Spider", 16);
        map.replace("Cricket", 17);

        assertEquals(16, map.get("Spider"));
        assertEquals(17, map.get("Cricket"));
        assertEquals(null, map.get("Cicada"));

    }

    @Test
    void mapIterator(){

        map.put("Bear", 75);
        map.put("Dolphin", 89);
        map.put("Zebra", 95);

        for (Integer Animals: map){
            System.out.print(Animals + " ");
        }

    }



}