package deqo.nand.simplestack;

import org.junit.Before;
import org.junit.Test;

import java.util.EmptyStackException;

import static org.junit.Assert.*;

public class StackTest {
    Stack emptyStack;
    Stack oneElementStack;
    Stack twoElementsStack;
    Item one;
    int un = 1;
    Item two;
    int deux = 2;
    int maxvalue = 5;

    @Before
    public void setUp() throws Exception {
        emptyStack = new Stack();
        oneElementStack = new Stack();
        one = new Item(un);
        two = new Item(deux);
        oneElementStack.push(one);
        twoElementsStack = new Stack();
        twoElementsStack.push(one);
        twoElementsStack.push(two);
    }

    @Test
    public void isEmpty() {
        /*
         * Given an empty stack
         * When I ask if the stack is empty
         * Then I should have True
         */
        assertTrue("the stack should be empty.",emptyStack.isEmpty());
        /*
         * Given I have a stack with only one element
         * When I ask if the stack is empty
         * Then I should have False
         */
        assertFalse("the stack should be empty.",oneElementStack.isEmpty());
        /*
         * Given I have a stack with two elements
         * When I ask if the stack is empty
         * Then I should have False
         */
        assertFalse("the stack should be empty.",twoElementsStack.isEmpty());
    }

    @Test
    public void getSize() {
        /*
         * Given an empty stack
         * When I ask for the size of the stack
         * Then I should have 0
         */
        assertEquals("the stack should be empty but is of size " + emptyStack.getSize() + ".", 0, emptyStack.getSize());
        /*
         * Given I have a stack with only one element
         * When I ask for the size of the stack
         * Then I should have 1
         */
        assertEquals("the stack should be of size " + un + " but is of size " + oneElementStack.getSize() + ".", oneElementStack.getSize(), un);
        /*
         * Given I have a stack with two elements
         * When I ask for the size of the stack
         * Then I should have 2
         */
        assertEquals("the stack should be of size " + deux + " but is of size " + twoElementsStack.getSize() + ".", twoElementsStack.getSize(), deux);
    }

    @Test
    public void push() {
        /*
         * Given an empty stack
         * When I push an element
         * Then the size should be 1
         */
        emptyStack.push(one);
        assertEquals("the stack should be of size " + un + ".", emptyStack.getSize(), un);
        /*
         * Given a stack with only one element
         * When I push an element
         * Then the size should be 2
         */
        oneElementStack.push(two);
        assertEquals("the stack should be of size " + deux + ".", oneElementStack.getSize(), deux);
        assertEquals("the first element of the stack should be " + two.getValue() + " but is " + oneElementStack.peek().getValue() + ".", oneElementStack.peek(), two);
        /*
         * Given I have a stack with two elements
         * When I push an element
         * Then the size should be 3
         */
        twoElementsStack.push(one);
        assertEquals("the stack should be of size " + (deux + 1)  + ".", twoElementsStack.getSize(), (deux + 1));
        assertEquals("the first element of the stack should be " + deux + " but is " + twoElementsStack.peek().getValue() + ".", twoElementsStack.peek().getValue(), un);
    }

    @Test (expected = EmptyStackException.class)
    public void peek() {
        /*
         * Given an empty stack
         * When I peek the first element
         * Then an EmptyStackException should be raised
         */
        emptyStack.peek();
        /*
         * Given I have a stack with only one element
         * When I peek the first element
         * Then I should have 1
         */
        assertEquals("the first element of the stack should be " + un + " but is " + oneElementStack.peek().getValue() + ".", oneElementStack.peek().getValue(), un);
        /*
         * Given I have a stack with two elements
         * When I peek the first element
         * Then I should have 1
         */
        assertEquals("the first element of the stack should be " + deux + " but is " + twoElementsStack.peek().getValue() + ".", twoElementsStack.peek().getValue(), deux);
    }

    @Test (expected = EmptyStackException.class)
    public void pop() {
        /*
         * Given an empty stack
         * When I pop the first element
         * Then an EmptyStackException should be raised
         */
        emptyStack.pop();
        /*
         * Given I have a stack with only one element
         * When I pop the first element
         * Then I should have 1
         * And an empty stack
         */
        Item item =  oneElementStack.pop();
        assertEquals("the first element of the stack should be " + un + " but is " + item.getValue() + ".", item.getValue(), un);
        assertTrue("the stack should be empty.",oneElementStack.isEmpty());
        /*
         * Given I have a stack with two elements
         * When I pop the first element
         * Then I should have 1
         */
        Item item2 =  twoElementsStack.pop();
        assertEquals("the first element of the stack should be " + deux + " but is " + item2.getValue() + ".", item2.getValue(), deux);
        assertEquals("the stack should be of size " + un + " but is of size " + twoElementsStack.getSize() + ".", twoElementsStack.getSize(), un);
    }
}