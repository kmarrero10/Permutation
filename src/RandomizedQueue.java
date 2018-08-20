import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private int n;
    private Item[] a;

    public RandomizedQueue() {
        a = (Item[]) new Object[2];
        n = 0;
    }

    private void resize(int capacity) {
        assert capacity >= n;

        // textbook implementation
//        Item[] temp = (Item[]) new Object[capacity];
//        for (int i = 0; i < n; i++) {
//            temp[i] = a[i];
//        }
//        a = temp;
        a = java.util.Arrays.copyOf(a, capacity);
    }

    public boolean isEmpty() {
        return n==0;
    }

    public int size() {
        return n;
    }

    public void enqueue(Item item) {
        n++;
        if (n == a.length) resize(2*a.length);
        a[n++] = item;

    }

    public int randomIndex() {
        return StdRandom.uniform(n-1);
    }

    public Item dequeue() {
        int i = randomIndex();
        Item j = a[i];
        a[i] = a[n-1];
        a[n-1] = null;
        n--;
        if (n > 0 && n == a.length/4) resize(a.length/2);
        return j;
    }

    public Item sample() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        return a[randomIndex()];
    }

    @Override
    public Iterator<Item> iterator() {
        return new RandomizedIterator();
    }

    private class RandomizedIterator implements Iterator<Item> {

        private Item[] j;
        private int i;

        public RandomizedIterator() {
            copy();
            StdRandom.shuffle(a);
        }
        private void copy() {
            j = (Item[]) new Object[n];

            for(int i =0; i<n; i++) {
                j[i] = a[i];
            }
        }
        public boolean hasNext()  { return i < n-1; }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            return j[i++];
        }
    }
}
