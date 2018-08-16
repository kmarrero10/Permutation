public class Permutation {
    static Deque<String> deque = new Deque<>();
    static Dog f, d = null;


    public static void main(String[] args) {
        deque.addFirst("first");
        deque.addFirst("first2");
        deque.addLast("Last");
        //deque.addLast("last");
        deque.removeLast();
        //deque.removeFirst();
        for (String s: deque){
            System.out.println(s);
        }

//        d = new Dog();
//        f=d;
//        f.color="orange";
//        System.out.println(d.color);
    }

    private static class Dog{
        int height=5;
        String color="yellow";
    }
}
