import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> {
    public Node<Item> sentinel;
    public int size;

    private static class Node<Pokemon> {
        private Pokemon item;
        private Node<Pokemon> next;
        private Node<Pokemon> before;
        private Node(Pokemon i, Node<Pokemon> n, Node<Pokemon> b) {
            this.item = i;
            this.next = n;
            this.before = b;
        }
    }

    // construct an empty deque
    public Deque() {
        sentinel = new Node<>(null, null, null);
        sentinel.next = sentinel;
        sentinel.before = sentinel;
        size = 0;
    }

    // is the deque empty?
    public boolean isEmpty() {
        return this.size == 0;
    }

    // return the number of items on the deque
    public int size() {
        return this.size;
    }

    // add the item to the front
    public void addFirst(Item item) {
        this.sentinel.next = new Node<>(item, sentinel.next, sentinel);
        this.sentinel.next.next.before = this.sentinel.next;
        size += 1;
    }

    // add the item to the back
    public void addLast(Item item) {
        this.sentinel.before = new Node<>(item, sentinel, sentinel.before);
        this.sentinel.before.before.next = this.sentinel.before;
        size += 1;
    }

    // remove and return the item from the front
    public Item removeFirst() {
        if (size == 0) {
            return null;
        } else {
            Item first = this.sentinel.next.item;
            this.sentinel.next = this.sentinel.next.next;
            size -= 1;
            return first;
        }
    }

    // remove and return the item from the back
    public Item removeLast() {
        if (size == 0) {
            return null;
        } else {
            Item last = this.sentinel.before.item;
            this.sentinel.before = this.sentinel.before.before;
            size -= 1;
            return last;
        }
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Node<Item> current = sentinel;

        @Override
        public boolean hasNext() {
            return current != null;
        }
        public void remove(){
            /*Not supported*/
        }
        public Item next() {
            Item it = current.item;
            current = current.next;
            return it;
        }
    }

    // unit testing (required)
    public static void main(String[] args) {
        System.out.println("hello");
    }

}
