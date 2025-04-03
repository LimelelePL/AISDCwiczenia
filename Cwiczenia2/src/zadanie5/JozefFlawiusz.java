package zadanie5;

import zadanie3.IQueue;
import zadanie3.QueueOfStacks;

public class JozefFlawiusz {

    public static int flawiusz(int n, int k) throws IQueue.EmptyQueueException {
        int index=0;
        QueueOfStacks<Integer> queue = new QueueOfStacks<>();

        for (int i = 1; i <= n; i++) {
            queue.enqueue(i);
        }

        while (queue.size() > 1) {
            queue.printQueue();
            for (int i = 1; i < k; i++) {
                queue.enqueue(queue.dequeue());
            }
            queue.dequeue();
            System.out.println();
        }

        return queue.dequeue();
    }

    public static void main(String[] args) throws IQueue.EmptyQueueException {
        int f= flawiusz(8,3);
        System.out.println(f);
    }

}
