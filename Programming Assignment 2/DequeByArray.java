import java.util.Iterator;
import java.util.NoSuchElementException;

public class DequeByArray<Item> implements Iterable<Item> {
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

    public DequeByArray() {
        sentinel = new Node<>(null, null, null);
        sentinel.next = sentinel;
        sentinel.before = sentinel;
        size = 0;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }
    public int size() {
        return this.size;
    }

    public void addFirst(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Can't add null item");
        }else {
            this.sentinel.next = new Node<>(item, sentinel.next, sentinel);
            this.sentinel.next.next.before = this.sentinel.next;
            size += 1;
        }
    }

    public void addLast(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Can't add null item");
        } else {
            this.sentinel.before = new Node<>(item, sentinel, sentinel.before);
            this.sentinel.before.before.next = this.sentinel.before;
            size += 1;
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
            throw new UnsupportedOperationException("Not supported");
        }
        public Item next() {
            if (size == 0) {
                throw new NoSuchElementException("Deque is empty");
            } else {
                Item it = current.item;
                current = current.next;
                return it;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("hello");
    }

}
