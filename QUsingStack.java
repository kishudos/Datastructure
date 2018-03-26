package queue;

import stack.StackUsingLL;

public class QUsingStack {
	StackUsingLL stack1 = null, stack2 = null;

	public QUsingStack() {
		this.stack1 = new StackUsingLL();
		this.stack2 = new StackUsingLL();
	}

	public void enQ(int data) {
		this.stack1.push(data);
	}

	public int deQ() {
		if (this.stack2.isEmpty()) {
			while (!this.stack1.isEmpty())
				this.stack2.push(this.stack1.pop());
		}
		return this.stack2.pop();
	}

	public static void main(String[] args) {
		QUsingStack q = new QUsingStack();
		System.out.println(q.deQ());
		int v = 0;
		if ((v = q.deQ()) == -1)
			System.out.println("Queue Empty");
		else
			System.out.println(v);
		q.enQ(1);
		q.enQ(2);
		q.enQ(3);
		if ((v = q.deQ()) == -1)
			System.out.println("Queue Empty");
		else
			System.out.println(v);
		if ((v = q.deQ()) == -1)
			System.out.println("Queue Empty");
		else
			System.out.println(v);
		if ((v = q.deQ()) == -1)
			System.out.println("Queue Empty");
		else
			System.out.println(v);
		if ((v = q.deQ()) == -1)
			System.out.println("Queue Empty");
		else
			System.out.println(v);

	}
}
