package zadanie4;

@SuppressWarnings("unchecked")
public class DrowningStack<E> implements IStack<E> {
    private E[] array;
    private int topIndex;
    private int capacity;
    private int size=0;


    public DrowningStack(int capacity ) {
        this.capacity = capacity;
        array=(E[])new Object[capacity];
        topIndex=0;
    }


    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public boolean isFull() {
        return size==array.length;
    }

    @Override
    public E pop() throws EmptyStackException {
        if(isEmpty())
            throw new EmptyStackException();
        return array[--topIndex];
    }


    @Override
    public void push(E elem) throws FullStackException {
        if (isFull()) {
            for (int i = 1; i < capacity; i++) {
                array[i - 1] = array[i];
            }
            array[capacity - 1] = elem;
        } else {
            size++;
            array[topIndex++] = elem;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E top() throws EmptyStackException {
        if (isEmpty())
            throw new EmptyStackException();

        return array[topIndex - 1];
    }

    public void printStack() {
        if (isEmpty()) {
            System.out.println("Stos jest pusty.");
            return;
        }

        System.out.println("Zawartość stosu (od dołu do góry):");
        for (int i = 0; i < topIndex; i++) {
            System.out.println(array[i]);
        }
    }

}
