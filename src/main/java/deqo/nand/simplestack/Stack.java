package deqo.nand.simplestack;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class Stack implements SimpleStack {
    /* LIFO */
    private int size;
    private ArrayList<Item> items;

    Stack() {
        size = 0;
        items = new ArrayList<>();
    }

    @Override
    public boolean isEmpty() {
        return (size==0);
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void push(Item item) {
        items.add(item);
        size++;
    }

    @Override
    public Item peek() throws EmptyStackException {
        if(isEmpty()) throw new EmptyStackException();
        return items.get(size-1);
    }

    @Override
    public Item pop() throws EmptyStackException {
        if(isEmpty()) throw new EmptyStackException();
        size--;
        return items.remove(size);
    }
}
