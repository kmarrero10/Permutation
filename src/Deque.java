import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    private int n;
    private Node first, last;

    public Deque() {
        first = null;
        last = null;
        n = 0;
    }

    private class Node {
        Item item;
        Node next;
    }

    public boolean isEmpty() {
        return first==null;
    }

    public int size() {
        return n;
    }

    public void addFirst(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item=item;
        first.next=oldFirst;
        if (isEmpty()){last=first;}

        n++;
    }

    public void addLast(Item item) {
        Node oldLast = last;
        last = new Node();
        last.item=item;
        last.next=null;
        if (isEmpty()) {first = last;}
       //    else oldLast.next=last;
        n++;
    }

    public Item removeFirst() {
        if (isEmpty()) throw new NoSuchElementException("stack underflow");
        Item item = first.item;
        first=first.next;
        n--;
        return item;
    }

    public Item removeLast() {
        if (isEmpty()) throw new NoSuchElementException("stack underflow");
        Item item = last.item;
        last = last.next;
        n--;
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item>{

        private Node current = first;
        public boolean hasNext() { return current != null;}
        public void remove() {throw new UnsupportedOperationException();}
        public Item next(){
            if(!hasNext()) {throw new NoSuchElementException();}
            Item item = current.item;
            current=current.next;
            return item;
        }

    }
}
