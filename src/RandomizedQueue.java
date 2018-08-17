import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {

    int n;

    public RandomizedQueue() {

    }

    public boolean isEmpty() {
        return n==0;
    }

    public int size() {
        return n;
    }

    public void enqueue(Item item) {

    }

    public Item dequeue() {
        return;
    }

    public Item sample() {
        return;
    }

    @Override
    public Iterator<Item> iterator() {
        return RandomizedIterator();
    }

    private class RandomizedIterator implements Iterator<Item> {

        public Item next(){
            if(!hasNext()) {throw new NoSuchElementException();}
            Item item = new Item();
            return item;
        }
    }
}
