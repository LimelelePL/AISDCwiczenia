package zadanie3;

    public interface IQueue<T>{
        public class EmptyQueueException extends Exception{
        }
        public class FullQueueException extends Exception{
        }

        boolean isEmpty();
        boolean isFull();
        T dequeue() throws EmptyQueueException;
        void enqueue(T elem) throws FullQueueException;
        int size(); // zwraca liczbę elementów w kolejce
        T first() throws EmptyQueueException;
// zwraca element z początku kolejki bez usuwania go


    }

