package stack;

import linkedlist.LinkedList;

public class StackUsingLL {
	LinkedList l = null;

	public StackUsingLL() {
		l = new LinkedList();
	}

	public void push(int data) {
		l.addAtFirst(data);
	}

	public int pop() {
		return l.removeAtFirst();
	}

	public int peek() {
		return l.getHeadData();
	}

	public void printStack() {
		l.printList();
	}
	public boolean isEmpty(){
		return l.isEmpty();
	}
	public static void main(String[] args) {
		StackUsingLL stack = new StackUsingLL();
		stack.push(1);

		System.out.println(stack.pop());
		stack.printStack();
	}
}
