package zadanie4;

public class Main {
    public static void main(String[] args) throws IStack.FullStackException {
        DrowningStack<Integer> stack = new DrowningStack(4);

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);

        stack.printStack();


    }
}
