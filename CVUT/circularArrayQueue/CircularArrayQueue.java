package CVUT.circularArrayQueue;

/**
 * Implementation of the {@link Queue} backed by fixed size array.
 */
public class CircularArrayQueue implements Queue {

	private int rear;
	private int front;
	private int capacity;
	private	String[] arrQueue;
    /**
     * Creates the queue with capacity set to the value of 5.
     */
    public CircularArrayQueue() {
		this.rear = -1;
		this.front = -1;
		this.capacity = 5;
		this.arrQueue = new String[this.capacity];
    }


    /**
     * Creates the queue with given {@code capacity}. The capacity represents maximal number of elements that the
     * queue is able to store.
     * @param capacity of the queue
     */
    public CircularArrayQueue(int capacity) {
		this.rear = -1;
		this.front = -1;
		this.capacity = capacity;
		this.arrQueue = new String[this.capacity];
    }

    @Override
    public int size() {
		int numOfElements = 0;
		for (int i = 0; i < this.capacity; ++i)
			if (this.arrQueue[i] != null)
				numOfElements++;;
        return numOfElements;
    }

    @Override
    public boolean isEmpty() {
		return this.size() == 0;
    }

    @Override
    public boolean isFull() {
        return this.size() == this.capacity;
    }

    @Override
    public boolean enqueue(String obj) {
		if (this.isFull())
			return false;
		if (this.isEmpty())
			front = 0;
		rear = (rear + 1) % capacity;
		this.arrQueue[rear] = obj;
		return true;
    }

    @Override
    public String dequeue() {
		if (this.isEmpty())
			return null;
		String temp = this.arrQueue[this.front];
		if (front == rear)
			front = rear = -1;
		else
			front++;
		return temp;
    }

    @Override
    public void printAllElements() {
		for (int i = 0; i < this.capacity; ++i)
			System.out.printf("%s ",this.arrQueue[i]);
    }
}
