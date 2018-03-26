package queue;

public class CircularQueue {
	private int front, rear, capacity;
	private int[] queue = null;

	public CircularQueue(int capacity) {
		this.capacity = capacity;
		this.front = this.rear = -1;
		this.queue = new int[capacity];
	}

	public boolean isFull() {
		return this.front == ((this.rear + 1) % this.capacity);
	}

	public boolean isEmpty() {
		return (this.front == this.rear) && (this.rear == -1);
	}

	public void enQ(int data) {
		if (!this.isFull()) {
			this.rear = (this.rear + 1) % this.capacity;
			this.queue[this.rear] = data;

			if (this.front == -1)
				this.front = 0;
		} else {
			System.out.println("Queue is full");
		}
	}

	public int deQ() {
		int data = -1;
		if (!isEmpty()) {
			data = this.queue[this.front];

			if (this.front == this.rear)
				this.front = this.rear = -1;
			else
				this.front = (this.front + 1) % this.capacity;
		} else {
			System.out.println("Queue is already empty..!");
		}
		return data;
	}

	public int getFront() {
		return this.queue[this.front];
	}

	public int getRear() {
		return this.queue[this.rear];
	}

	public void printQ() {
		int start = this.front, end = this.rear;
		if (start != -1) {
			while (start != end) {
				System.out.print(this.queue[start] + " ");
				start = (start + 1) % this.capacity;
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		CircularQueue q = new CircularQueue(5);
		q.printQ();
		q.deQ();
		q.enQ(1);
		System.out.println("front-" + q.getFront());
		System.out.println("Rear- " + q.getRear());
		q.enQ(2);
		System.out.println("front-" + q.getFront());
		System.out.println("Rear- " + q.getRear());
		q.enQ(3);
		System.out.println("front-" + q.getFront());
		System.out.println("Rear- " + q.getRear());
		q.enQ(4);
		System.out.println("front-" + q.getFront());
		System.out.println("Rear- " + q.getRear());
		q.enQ(5);
		System.out.println("front-" + q.getFront());
		System.out.println("Rear- " + q.getRear());
		q.enQ(6);
		System.out.println("front-" + q.getFront());
		System.out.println("Rear- " + q.getRear());
		System.out.println("Deleted-" + q.deQ());
		System.out.println("front-" + q.getFront());
		System.out.println("Rear- " + q.getRear());
		q.enQ(6);
		System.out.println("front-" + q.getFront());
		System.out.println("Rear- " + q.getRear());
	}
}
