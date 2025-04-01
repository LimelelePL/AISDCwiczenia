package zadanie3;

import java.util.Queue;
import java.util.Stack;

public class QueueOfStacks <T> implements IQueue<T> {
    private Stack<T> inStack = new Stack<>();
    private Stack<T> outStack = new Stack<>();

    @Override
    public boolean isEmpty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public T dequeue() throws EmptyQueueException {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }
        if (outStack.isEmpty()) {
            moveInToOut();
        }
        return outStack.pop();
    }

    @Override
    public void enqueue(T elem) {
        inStack.push(elem);
    }

    private void moveInToOut() {
        while (!inStack.isEmpty()) {
            outStack.push(inStack.pop());
        }
    }


    @Override
    public int size() {
        return inStack.size() + outStack.size();
    }

    @Override
    public T first() throws EmptyQueueException {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }
        if (outStack.isEmpty()) {
            moveInToOut();
        }
        return outStack.peek();
    }

    public void printQueue() {
        if (isEmpty()) {
            System.out.println("(empty)");
            return;
        }

        Stack<T> tempIn = (Stack<T>) inStack.clone();
        Stack<T> tempOut = (Stack<T>) outStack.clone();

        Stack<T> display = new Stack<>();
        while (!tempOut.isEmpty()) {
            display.push(tempOut.pop());
        }

        while (!tempIn.isEmpty()) {
            display.insertElementAt(tempIn.pop(), 0);
        }

        display.forEach(System.out::println);
    }
}
