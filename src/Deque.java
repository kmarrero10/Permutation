import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> {

    int size;
    Node first;

    public Deque() {
        first = new Node();

    }

    public boolean isEmpty(){

        if (size == 0) {
            return true;
        } else
            return false;
    }

    public int size() {

        return size;
    }

    public void addFirst(Item item){

    }

    public void addLast(Item item){

    }

    public Item removeFirst() {

        return null;
    }

    public Item removeLast() {
        return null;
    }

    private class Node{
        Item item;
        Node next;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item>{

        private Node current = first;
        public boolean hasNext() { return current != null;}
        public void remove() throws UnsupportedOperationException { }
        public Item next(){
            Item item = current.item;
            current=current.next;
            return item;
        }

    }
}
