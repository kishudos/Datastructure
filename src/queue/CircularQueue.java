package queue;

public class CircularQueue {
	private int front, rear;
	private int capacity;
	private int[] queue;

	public CircularQueue(int size) {
		this.front = this.rear = -1;
		this.capacity = size;
		this.queue = new int[this.capacity];
	}

	public boolean isEmpty() {
		return (this.front == this.rear) && this.rear == -1;
	}

	public boolean isFull() {
		return this.front == (this.rear + 1) % this.capacity;
	}
	public void enqueue(int data) {
		if(!isFull()) {
			this.rear = (this.rear+1)%this.capacity;
			this.queue[this.rear] = data;
			if(this.front==-1)
				this.front = 0;
		}else {
			System.out.println("Queue is full");
		}
	}
	public int dequeue() {
		int item = -1;
		if(!isEmpty()) {
			item = this.queue[this.front];
			if(this.front==this.rear) {
				this.front = this.rear = -1;
			}else {
				this.front = (this.front+1)%this.capacity;
			}
		}else {
			System.out.println("Queue is empty");
		}
		return item;
	}
	public int getFront() {
		int item=-1;
		if(!isEmpty()) {
			item = this.queue[this.front];
		}else {
			System.out.println("Empty queue");
		}
		return item;
	}
	public int getRear() {
		int item = -1;
		if(!isEmpty()) {
			item = this.queue[this.rear];
		}else {
			System.out.println("Empty queue");
		}
		return item;
	}
	public static void main(String[] args) {
		CircularQueue cQ = new CircularQueue(5);
		System.out.println("Front - "+cQ.getFront());
		System.out.println("Rear - "+cQ.getRear());
		cQ.enqueue(1);
		System.out.println("Front - "+cQ.getFront());
		System.out.println("Rear - "+cQ.getRear());
		cQ.enqueue(2);
		System.out.println("Front - "+cQ.getFront());
		System.out.println("Rear - "+cQ.getRear());
		cQ.enqueue(3);
		System.out.println("Front - "+cQ.getFront());
		System.out.println("Rear - "+cQ.getRear());
		cQ.enqueue(4);
		System.out.println("Front - "+cQ.getFront());
		System.out.println("Rear - "+cQ.getRear());
		cQ.enqueue(5);
		System.out.println(cQ.dequeue());
		System.out.println("Front - "+cQ.getFront());
		System.out.println("Rear - "+cQ.getRear());
	}
}
