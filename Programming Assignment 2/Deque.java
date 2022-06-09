import org.w3c.dom.Node;

import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> {
    public Node<Item> sentinel;
    public int size;

    private static class Node<Pokemon>{
        private Pokemon item;
        private Node<Pokemon> next;
        private Node<Pokemon> before;
        private Node (Pokemon i, Node<Pokemon> n, Node<Pokemon> b) {
            this.item = i;
            this.next = n;
            this.before = b;
        }
    }

    // construct an empty deque
    public Deque() {
        sentinel = new Node<>(null, null, null);

        size = 0;
    }

    // is the deque empty?
    public boolean isEmpty() {
        return false;
    }

    // return the number of items on the deque
    public int size() {
        return 0;
    }

    // add the item to the front
    public void addFirst(Item item) {

    }

    // add the item to the back
    public void addLast(Item item) {

    }

    // remove and return the item from the front
    public Item removeFirst() {
        return new Item;
    }

    // remove and return the item from the back
    public Item removeLast() {
        return new Item;
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() {
        return new Iterator<Item>() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public Item next() {
                return null;
            }
        };
    }

    // unit testing (required)
    public static void main(String[] args) {
        System.out.println("hello");
    }

}