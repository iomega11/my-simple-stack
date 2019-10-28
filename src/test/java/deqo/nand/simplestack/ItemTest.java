package deqo.nand.simplestack;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ItemTest {
    private Item item;
    @Before
    public void setUp(){
        item = new Item(12);
    }

    @Test
    public void getValue() {
        /*
         * Given I have an item with a value 12
         * When I ask for the value
         * Then I should have 12
         */
        assertEquals("getValue() devrait renvoyer 12 mais renvoie " + item.getValue(), item.getValue(), 12);
    }

    @Test
    public void setValue() {
        /*
         * Given I have an item with a value 12
         * When I set the value as 4
         * Then I should have 4 when I want to get it
         */
        item.setValue(4);
        assertEquals("getValue() devrait renvoyer 4 mais renvoie " + item.getValue(), item.getValue(), 4);
    }
}