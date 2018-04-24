package stack;

public class StackUsingArray {
	private int top;
	private int capacity;
	private int[] stack;

	public StackUsingArray(int size) {
		this.top = -1;
		this.capacity = size;
		this.stack = new int[this.capacity];
	}

	public boolean isEmpty() {
		return this.top == -1;
	}

	public boolean isFull() {
		return (this.top + 1) == this.capacity;
	}

	public void push(int data) {
		if (!isFull()) {
			this.stack[++this.top] = data;
		} else {
			System.out.println("Stack is full, could not pushed into it");
		}
	}

	public int pop() {
		int item = -1;
		if (!isEmpty()) {
			item = this.stack[top--];
		} else {
			System.out.println("Stack is empty");
		}
		return item;
	}

	public int peek() {
		int peek;
		if (!isEmpty()) {
			peek = this.stack[this.top];
		} else {
			System.out.println("Stack is empty");
			peek = -1;
		}
		return peek;
	}
}
