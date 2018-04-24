package stack;

public class TwoStackInArray {
	private int top1, top2, capacity;
	private int[] stack = null;

	public TwoStackInArray(int capacity) {
		this.capacity = capacity;
		this.top1 = -1;
		this.top2 = capacity;
		this.stack = new int[capacity];
	}

	public void push(int item, int stackNo) {

		if (this.top1 < (this.top2 - 1)) {
			if (stackNo == 1)
				this.stack[++this.top1] = item;
			if (stackNo == 2)
				this.stack[--this.top2] = item;
			System.out.println(item + "-Pushed in stack " + stackNo);
		} else {
			System.out.println("Overflow..!! in stack- " + stackNo);
		}
	}

	public int pop(int stackNo) {
		if (stackNo == 1 && this.top1 > -1)
			return this.stack[this.top1--];
		else if (stackNo == 2 && this.top2 < this.capacity )
			return this.stack[this.top2++];
		else{
			System.out.println("UnderFlow...!! in stack- " + stackNo);
			return -1;
		}
	}

	public void printStack(int stackNo) {
		System.out.print("\nStack" + stackNo + "->>> ");
		if (stackNo == 1)
			for (int i = 0; i <= this.top1; i++) {
				System.out.print(this.stack[i] + " ");
			}
		if (stackNo == 2)
			for (int i = this.capacity - 1; i >= this.top2; i--) {
				System.out.print(this.stack[i] + " ");
			}
	}

	public static void main(String[] args) {
		TwoStackInArray stack = new TwoStackInArray(5);
		stack.push(1, 1);// (item, stackno)
		stack.push(9, 1);
		stack.push(63, 1);
		stack.push(64, 1);

		stack.pop(2);
		
		stack.push(12, 2);

		stack.printStack(1);
		stack.printStack(2);
	}
}
