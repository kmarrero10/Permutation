public class Permutation {
    static Deque<String> deque = new Deque<>();

    public static void main(String[] args) {
        deque.addFirst("first");
       deque.addFirst("first2");
       deque.addLast("Last");
//        deque.addLast("LASST");
        //deque.addLast("last");
        //deque.removeLast();
        deque.removeFirst();
        //deque.removeFirst();
        for (String s: deque){
            System.out.println(s);
        }
    }
}
