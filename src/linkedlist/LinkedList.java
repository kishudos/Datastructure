package linkedlist;

//Node class
class Node {
	int data;

	@Override
	public String toString() {
		return "Node [data=" + data + "]";
	}

	Node next;

	Node(int d) {
		data = d;
		next = null;
	}
}

public class LinkedList {
	Node head;

	public boolean addAtFirst(int data) {
		try {
			Node newNode = new Node(data);
			newNode.next = head;
			head = newNode;
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public int removeAtFirst() {
		if (head == null) {
			return -1;
		}
		Node temp = null;
		temp = head;
		head = head.next;
		return temp.data;
	}

	public void addAtLast(int data) {
		Node newNode = new Node(data);

		if (head == null) {
			head = newNode;
			return;
		}
		Node temp = head;

		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = newNode;
	}

	public void removeAtLast() {
		if (head == null) {
			System.out.println("Nothing to delete");
			return;
		}
		Node temp = head;
		if (temp.next == null) {
			head = null;
			return;
		}

		while (temp.next.next != null) {
			temp = temp.next;
		}
		temp.next = null;
	}

	public void deleteNodeByKey(int key) {
		Node temp = head;
		if (temp == null) {
			return;
		}
		if (temp.data == key) {
			head = head.next;
			return;
		}
		Node pre = null;

		while (temp != null && temp.data != key) {
			pre = temp;
			temp = temp.next;
		}
		if (temp != null)
			pre.next = temp.next;
		else
			System.out.println("\nKey not found to delete");

	}

	public void printList() {

		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data);
			if (temp.next != null) {
				System.out.print("->");
			}
			temp = temp.next;
		}
	}

	public void deleteNodeAtIndex(int index) {
		if (head == null) {
			return;
		}
		if (index == 0) {
			head = head.next;
			return;
		}
		Node temp = head;
		int pos = 0;

		while (temp != null && pos < index - 1) {
			temp = temp.next;
			pos++;
		}
		if (temp == null || temp.next == null) {
			System.out.println("Position is not in list range");
			return;
		}
		temp.next = temp.next.next;
	}

	public int sizeItr() {
		Node temp = head;
		int size = 0;
		while (temp != null) {
			size++;
			temp = temp.next;
		}
		return size;
	}

	private int sizeR(Node node) {
		if (node == null) {
			return 0;
		}
		return 1 + sizeR(node.next);
	}

	public int sizeRec() {
		return sizeR(head);
	}

	public void swapByLink(int x, int y) {
		if (x == y) {
			System.out.println("Both elements are same can't swap");
			return;
		}

		Node preX = null, currX = head;
		while (currX != null && currX.data != x) {
			preX = currX;
			currX = currX.next;
		}

		Node preY = null, currY = head;
		while (currY != null && currY.data != y) {
			preY = currY;
			currY = currY.next;
		}

		if (currX == null || currY == null) {
			System.out.println("\nCan't swap....Either of two elements are not in list");
			return;
		}

		if (preX == null) {
			head = currY;
		} else {
			preX.next = currY;
		}

		if (preY == null) {
			head = currX;
		} else {
			preY.next = currX;
		}
		Node temp = currX.next;
		currX.next = currY.next;
		currY.next = temp;
	}

	public void reverseItr() {
		Node prev = null;
		Node curr = head;
		Node next = null;

		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		head = prev;
	}

	private Node reverseR(Node head) {
		if (head == null)
			return null;
		if (head.next == null)
			return head;

		Node rest = head.next;

		head.next = null;
		Node revRest = reverseR(rest);
		rest.next = head;

		return revRest;
	}

	Node reverseUtil(Node curr, Node prev) {
		if (curr == null)
			return null;
		/* If last node mark it head */
		if (curr.next == null) {
			head = curr;

			/* Update next to prev node */
			curr.next = prev;
			return null;
		}

		/* Save curr->next node for recursive call */
		Node next1 = curr.next;

		/* and update next .. */
		curr.next = prev;

		reverseUtil(next1, curr);
		return head;
	}

	public void reverseRec() {
		head = reverseR(head);
		// head = reverseUtil(head, null);
	}

	public Node mergeSortedList(Node head1, Node head2) {
		if (head1 == null)
			return head2;
		if (head2 == null)
			return head1;

		if (head1.data < head2.data) {
			head1.next = mergeSortedList(head1.next, head2);
			return head1;
		} else {
			head2.next = mergeSortedList(head2.next, head1);
			return head2;
		}
	}

	Node reverseKNodes(Node head, int k) {
		Node current = head;
		Node next = null;
		Node prev = null;

		int count = 0;

		/* Reverse first k nodes of linked list */
		while (count < k && current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
			count++;
		}

		/*
		 * next is now a pointer to (k+1)th node Recursively call for the list starting
		 * from current. And make rest of the list as next of first node
		 */
		if (next != null)
			head.next = reverseKNodes(next, k);

		// prev is now head of input list
		return prev;
	}

	public int getHeadData() {
		return this.head.data;
	}

	public boolean isEmpty() {
		return this.head == null;
	}

	public Node nThNodeFromLast(int n) {
		// O(N) complexity, where N = size of linked list
		Node temp = head, nThNode = head;
		int count = 0;
		while (temp != null && count < n) {
			temp = temp.next;
			count++;
		}
		if (temp != null) {
			while (temp != null) {
				temp = temp.next;
				nThNode = nThNode.next;
			}
		}
		return nThNode;
	}

	public void rotateAntiClockWise(int k) {
		if (k == 0)
			return;
		int count = 1;
		Node curr = head;
		
		while (count < k && curr != null) {
			count++;
			curr = curr.next;
		}
		
		if(curr!=null) {
			Node newHead = curr;
			
			while(curr.next!=null) {
				curr = curr.next;
			}
			// curr is at last node
			curr.next = head;
			head = newHead.next;
			newHead.next = null;
		}else {
			System.out.println("Rotation key is more than number of elements in list");
		}
	}

	public boolean hasLoop() {
		Node fast = head;
		Node slow = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				System.out.println("There is a loop in linked list");
				removeLoop(slow);
				return true;
			}
		}
		return false;
	}

	public void removeLoop(Node loopNode) {
		Node ptr1 = loopNode;
		Node ptr2 = loopNode;

		// Count the number of nodes in loop
		int loopCount = 1;
		while (ptr1.next != ptr2) {
			ptr1 = ptr1.next;
			loopCount++;
		}
		// Fix one pointer to head and other pointer to k nodes after head
		ptr1 = head;
		ptr2 = head;

		for (int i = 0; i < loopCount; i++) {
			ptr2 = ptr2.next;
		}

		/*
		 * Move both pointers at the same pace, they will meet at loop starting node
		 */

		while (ptr1 != ptr2) {
			ptr1 = ptr1.next;
			ptr2 = ptr2.next;
		}
		// Getting pointer to the last node in loop
		while (ptr2.next != ptr1) {
			ptr2 = ptr2.next;
		}
		/*
		 * Now ptr1 is at first node of loop and ptr2 is at last node of loop Disconnect
		 * this loop
		 */
		ptr2.next = null;
	}

	/***
	 * This method returns object of middle node
	 * 
	 * @return
	 */
	Node getMiddleNode(Node head) {
		if (head == null)
			return head;

		Node slow = head;
		Node fast = head.next;

		// Move fast by two and slow ptr by one
		// Finally slow will point to middle node
		while (fast != null) {
			fast = fast.next;
			if (fast != null) {
				slow = slow.next;
				fast = fast.next;
			}
		}
		return slow;
	}

	private Node mergeSort(Node head) {
		if (head == null || head.next == null)
			return head;

		// Split current list into two halves
		Node middleNode = getMiddleNode(head);
		Node nextOfMiddleNode = middleNode.next;

		// Disconnect middle node
		middleNode.next = null;

		// Apply mergeSort on left sub-list
		Node leftList = mergeSort(head);
		// Apply mergeSort on right sub-list
		Node rightList = mergeSort(nextOfMiddleNode);

		// Merge both sub-list
		Node sortedList = mergeSortedList(leftList, rightList);
		return sortedList;
	}

	public void sort() {
		head = mergeSort(head);
	}
}
