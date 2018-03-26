package stack;

public class StackUsingArray {
	private int top, capacity;
	private int[] stack = null;

	public StackUsingArray(int capacity) {
		this.capacity = capacity;
		this.stack = new int[capacity];
		this.top = -1;
	}

	public boolean isEmpty() {
		return this.top == -1;
	}

	public boolean isFull() {
		return (this.top == this.capacity - 1);
	}

	public void push(int item) {
		if (!this.isFull()) {
			stack[++top] = item;
			System.out.println("Item pushed");
		} else {
			System.out.println("Stack full.!");
		}
	}

	public int pop() {
		if (!isEmpty()) {
			return stack[top--];
		} else {
			System.out.println("Stack is already empty ..!");
			return -1;
		}
	}

	public int peek() {
		if (!isEmpty()) {
			return this.stack[top];
		} else {
			System.out.println("Stack is already empty ..!");
			return -1;
		}
	}

	public void print() {
		for (int i = 0; i <= this.top; ++i)
			System.out.println(this.stack[i] + " ");
	}

	public static void main(String[] args) {
		StackUsingArray st = new StackUsingArray(1);
		st.pop();
		st.push(1);
		st.push(2);
		st.push(3);
		st.push(4);
		st.print();
		System.out.println("Pop item" + st.pop());
		st.print();
	}
}
