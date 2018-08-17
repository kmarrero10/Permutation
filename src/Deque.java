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
        Node prev;
    }

    public boolean isEmpty() {
        return n==0;
    }

    public int size() {
        return n;
    }

    public void addFirst(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item=item;
        first.next=oldFirst;
        first.prev = null;
        if(n>0){oldFirst.prev = first;}
        if (isEmpty()){last = first;}

        n++;
    }

    public void addLast(Item item) {
        Node oldLast = last;
        last = new Node();
        last.item=item;
        last.next=null;
        last.prev = oldLast;
        if (isEmpty()) {first = last;}
           else oldLast.next=last;
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
        last = last.prev;
        if(n==1){first=null;}
        if (n>1){last.next=null;}
        n--;
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    //Issues are that the singly linked list iterator maintains a reference
    //to the instantiated object via first/last variables
    //This may also cause an issue with loitering
    //Check this implementation https://algs4.cs.princeton.edu/13stacks/DoublyLinkedList.java.html

    private class ListIterator implements Iterator<Item>{
        private Node current = first; //last
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
