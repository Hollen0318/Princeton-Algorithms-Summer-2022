import java.util.*;

public class RandomizedQueue<Item> implements Iterable<Item> {
    public Node<Item> sentinel;
    public int size;
    private int itid = -1;
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

    public RandomizedQueue() {
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

    public void enqueue(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Can't add null item");
        } else {
            this.sentinel.next = new Node<>(item, sentinel.next, sentinel);
            this.sentinel.next.next.before = this.sentinel.next;
            size += 1;
        }
    }

    public Item deque() {
        Random rand = new Random();
        Node<Item> pt = this.sentinel.next;
        int id = rand.nextInt(this.size);
        for (int i = 0; i < size; i += 1) {
            if (i == id) {
                pt.before.next = pt.next;
                pt.next.before = pt.before;
                break;
            }else{
                pt = pt.next;
            }
        }
        pt.next = null;
        pt.before = null;
        size -= 1;
        return pt.item;
    }

    public Item sample() {
        Random rand = new Random();
        Node<Item> pt = this.sentinel.next;
        int id = rand.nextInt(this.size);
        for (int i = 0; i < size; i += 1) {
            if (i == id) {
                break;
            }else{
                pt = pt.next;
            }
        }
        return pt.item;
    }

    private Item getIndex(int id) {
        Node<Item> pt = this.sentinel.next;
        for (int i = 0; i < size; i += 1) {
            if (i == id) {
                break;
            }else{
                pt = pt.next;
            }
        }
        return pt.item;
    }
    private Integer[] createArray(int sz) {
        Integer[] array = new Integer[size];
        for (int i = 0; i < size; i++) {
            array[i] = i;
        }
        List<Integer> list = Arrays.asList(array);
        Collections.shuffle(list);
        list.toArray(array);
//        System.out.println("The array is " + Arrays.toString(array));
        return array;
    }
    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() {
        itid = -1;
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        Integer[] array = createArray(size);
        @Override
        public boolean hasNext() {
            return itid < size-1;
        }
        public void remove(){
            throw new UnsupportedOperationException("Not supported");
        }
        public Item next() {
            itid += 1;
//            System.out.println(Arrays.toString(array));
            if (size == 0) {
                throw new NoSuchElementException("Deque is empty");
            } else {
                return getIndex(array[itid]);
            }
        }
    }

    public static void main(String[] args) {
        RandomizedQueue<Integer> RdQueue = new RandomizedQueue<Integer>();
        RdQueue.enqueue(10);
        RdQueue.enqueue(9);
        RdQueue.enqueue(8);
        RdQueue.enqueue(7);
        RdQueue.enqueue(6);
        for (Integer i : RdQueue) {
            System.out.print(i + " ");
        }
        System.out.println("\nRemove random value of " + RdQueue.deque() + " Empty test is " + RdQueue.isEmpty());
        for (Integer i : RdQueue) {
            System.out.print(i + " ");
        }
        System.out.println("\nRemove random value of " + RdQueue.deque() + " Empty test is " + RdQueue.isEmpty());
        for (Integer i : RdQueue) {
            System.out.print(i + " ");
        }
        System.out.println("\nRemove random value of " + RdQueue.deque() + " Empty test is " + RdQueue.isEmpty());
        for (Integer i : RdQueue) {
            System.out.print(i + " ");
        }
    }
}
