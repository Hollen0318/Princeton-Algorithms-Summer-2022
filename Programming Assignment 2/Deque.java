import java.util.Iterator;
import java.util.NoSuchElementException;

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
        if (item == null) {
            throw new IllegalArgumentException("Can't add null item");
        }else {
            this.sentinel.next = new Node<>(item, sentinel.next, sentinel);
            this.sentinel.next.next.before = this.sentinel.next;
            size += 1;
        }
    }

    // add the item to the back
    public void addLast(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Can't add null item");
        } else {
            this.sentinel.before = new Node<>(item, sentinel, sentinel.before);
            this.sentinel.before.before.next = this.sentinel.before;
            size += 1;
        }
    }

    // remove and return the item from the front
    public Item removeFirst() {
        if (size == 0) {
            throw new NoSuchElementException("The deque is empty");
        } else {
            Item first = this.sentinel.next.item;
            this.sentinel.next.next.before = this.sentinel;
            this.sentinel.next = this.sentinel.next.next;
            size -= 1;
            return first;
        }
    }

    // remove and return the item from the back
    public Item removeLast() {
        if (size == 0) {
            throw new NoSuchElementException("The deque is empty");
        } else {
            Item last = this.sentinel.before.item;
            this.sentinel.before.before.next = this.sentinel;
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
        private Node<Item> current = sentinel.next;

        @Override
        public boolean hasNext() {
            return current.item != null;
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

    // unit testing (required)
    public static void main(String[] args) {
        Deque<Integer> IntDeque = new Deque<Integer>();
        IntDeque.addFirst(5);
        IntDeque.addFirst(4);
        IntDeque.addFirst(3);
        IntDeque.addFirst(2);
        IntDeque.addFirst(1);
        IntDeque.addLast(6);
        for (Integer a : IntDeque) {
            System.out.print(a+" ");
        }
        System.out.print("\nThe size is " + IntDeque.size() + " And empty is " + IntDeque.isEmpty());
        System.out.println("\nRemove the value of " + IntDeque.removeLast());
        for (Integer a : IntDeque) {
            System.out.print(a+" ");
        }
        System.out.print("\nThe size is " + IntDeque.size() + " And empty is " + IntDeque.isEmpty());
        System.out.println("\nRemove the value of " + IntDeque.removeFirst());
        for (Integer a : IntDeque) {
            System.out.print(a+" ");
        }
        System.out.print("\nThe size is " + IntDeque.size() + " And empty is " + IntDeque.isEmpty());
        System.out.println("\nRemove the value of " + IntDeque.removeFirst());
        for (Integer a : IntDeque) {
            System.out.print(a+" ");
        }
        System.out.print("\nThe size is " + IntDeque.size() + " And empty is " + IntDeque.isEmpty());
        System.out.println("\nRemove the value of " + IntDeque.removeLast());
        for (Integer a : IntDeque) {
            System.out.print(a+" ");
        }
        System.out.print("\nThe size is " + IntDeque.size() + " And empty is " + IntDeque.isEmpty());
        System.out.println("\nRemove the value of " + IntDeque.removeFirst());
        for (Integer a : IntDeque) {
            System.out.print(a+" ");
        }
        System.out.print("\nThe size is " + IntDeque.size() + " And empty is " + IntDeque.isEmpty());
        System.out.println("\nRemove the value of " + IntDeque.removeFirst());
        for (Integer a : IntDeque) {
            System.out.print(a+" ");
        }
        System.out.print("\nThe size is " + IntDeque.size() + " And empty is " + IntDeque.isEmpty());
    }
}
