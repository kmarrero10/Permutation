import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Permutation {

    public static void main(String[] args) {
        RandomizedQueue<String> randomizedQueue = new RandomizedQueue<>();
        Integer input = Integer.parseInt(args[0]);

        for (int i = 0; i < input; i++) {
            randomizedQueue.enqueue(StdIn.readString());
        }

        for (int i = 0; i < input; i++) {
            StdOut.println(randomizedQueue.dequeue());
        }
    }
}
