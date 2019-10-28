package deqo.nand.simplestack;

public class Item {
    public Item(Object value) {
        this.value = value;
    }

    private Object value;

    public Object getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
