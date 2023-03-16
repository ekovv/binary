package com.ekov;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class TreeTest {

    @Test
    public void insertInto() {
        Tree tree = new Tree();
        tree.insertAll(1, -1, 10, 5);
        assertEquals(1, tree.getRoot().getValue());
        assertEquals(10, tree.getRoot().getRight().getValue());
    }

    @Test
    public void findValue() {
        Tree tree = new Tree();
        tree.insertAll(1,-1,10,5);
        assertEquals(10, tree.findValue(10).getValue());
    }


    @Test
    public void deleteElement() {
        Tree tree = new Tree();
        tree.insertAll(1,-1,10,5);
        Tree tree2 = new Tree();
        tree2.insertAll(1,-1, 5);
        tree.deleteElement(10);
        assertEquals(tree2, tree);
    }


    @Test
    public void getCount() {
        Tree tree = new Tree();
        tree.insertAll(1, -1, 10, 5, 11);
        assertEquals(2, tree.getCount(1));
        assertEquals(3, tree.getCount(10));
        assertEquals(1, tree.getCount(11));
    }
}