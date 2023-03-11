package com.ekov;


import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



public class TreeTest {

    @Test
    public void insertInto() {
        Tree ins = new Tree();
        ins.insertAll(1, -1, 10, 5);
        assertEquals(1, ins.getRoot().getValue());
        assertEquals(10, ins.getRoot().getRight().getValue());
    }

    @Test
    public void findValue() {
        Tree node = new Tree();
        node.insertAll(1,-1,10,5);
        assertEquals(10, node.findValue(10).getValue());
    }


    @Test
    public void deleteElement() {
        Tree node1 = new Tree();
        node1.insertAll(1,-1,10,5);
        Tree node2 = new Tree();
        node2.insertAll(1,-1, 5);
        assertEquals(node2, node1.deleteElement(node1, 10));
    }


    @Test
    public void getCount() {
        Tree node = new Tree();
        node.insertAll(1, -1, 10, 5, 11);
        assertEquals(2, node.getCount(1));
        assertEquals(3, node.getCount(10));
        assertEquals(1, node.getCount(11));
    }
}