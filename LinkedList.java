package linkedlist;

//Node class
class Node{
	int data;
	Node next;
	Node(int d){
		data = d;
		next = null;
	}
}
public class LinkedList {
	Node head ;
	
	public boolean addAtFirst(int data){
		try{
			Node newNode = new Node(data);
			newNode.next = head;
			head = newNode;
		}catch(Exception e){
			return false;
		}
		return true;
	}
	public int removeAtFirst(){
		if(head==null){
			return -1;
		}
		Node temp = null;
		temp = head;
		head = head.next;
		return temp.data;
	}
	public void addAtLast(int data){
		Node newNode = new Node(data);
		
		if(head==null){
			head = newNode;
			return;
		}
		Node temp = head;
		
		while(temp.next!=null){
			temp = temp.next;
		}
		temp.next = newNode;
	}
	public void removeAtLast(){
		if(head==null){
			System.out.println("Nothing to delete");
			return;
		}
		Node temp = head;
		if(temp.next==null){
			head = null;
			return;
		}
		
		while(temp.next.next!=null){
			temp = temp.next;
		}
		temp.next = null;
	}
	public void deleteNodeByKey(int key){
		Node temp = head;
		if(temp==null) {
			return;
		}
		if(temp.data==key){
			head = head.next;
			return;
		}
		Node pre = null;
		
		while(temp!=null && temp.data != key){
			pre = temp;
			temp = temp.next;
		}
		if(temp!=null)
			pre.next = temp.next;
		else
			System.out.println("\nKey not found to delete");
		
	}
	public void printList(){

		Node temp = head;
		while(temp!=null){
			System.out.print(temp.data);
			if(temp.next!=null){
				System.out.print("->");
			}
			temp = temp.next;
		}
	}
	public void deleteNodeAtIndex(int index){
		if(head==null){
			return;
		}
		if(index==0){
			head = head.next;
			return;
		}
		Node temp = head;
		int pos = 0;
		
		while(temp!=null && pos < index-1){
			temp = temp.next;
			pos++;
		}
		if(temp==null||temp.next==null){
			System.out.println("Position is not in list range");
			return ;
		}
		temp.next = temp.next.next;
	}
	public int sizeItr(){
		Node temp = head;
		int size = 0;
		while(temp!=null){
			size++;
			temp = temp.next;
		}
		return size;
	}
	private int sizeR(Node node){
		if(node==null){
			return 0;
		}
		return 1+sizeR(node.next);
	}
	public int sizeRec(){
		return sizeR(head);
	}
	public void swapByLink(int x, int y){
		if(x==y){
			System.out.println("Both elements are same can't swap");
			return;
		}
		
		Node preX = null, currX = head;
		while(currX != null && currX.data != x){
			preX = currX;
			currX = currX.next;
		}
		
		Node preY = null, currY = head;
		while(currY != null && currY.data != y){
			preY = currY;
			currY = currY.next;
		}
		
		if(currX==null||currY==null){
			System.out.println("\nCan't swap....Either of two elements are not in list");
			return;
		}
		
		if(preX==null){
			head = currY;
		}else{
			preX.next = currY;
		}
		
		if(preY==null){
			head = currX;
		}else{
			preY.next = currX;
		}
		Node temp = currX.next;
		currX.next = currY.next;
		currY.next = temp;
	}
	public void reverseItr(){
		Node prev = null;
		Node curr = head;
		Node next = null;
		
		while(curr != null){
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		head = prev;
	}
	private Node reverseR(Node head){
		if(head==null)
			return null;
		if(head.next==null)
			return head;
		
		Node rest = head.next;
		
		head.next = null;
		Node revRest = reverseR(rest);
		rest.next = head;
		
		return revRest;
	}
	Node reverseUtil(Node curr, Node prev) {
		if(curr==null)
			return null;
        /* If last node mark it head*/
        if (curr.next == null) {
            head = curr;
 
            /* Update next to prev node */
            curr.next = prev;
            return null;
        }
 
        /* Save curr->next node for recursive call */
        Node next1 = curr.next;
 
        /* and update next ..*/
        curr.next = prev;
 
        reverseUtil(next1, curr);
        return head;
    }
	public void reverseRec(){
		head = reverseR(head);
		//head = reverseUtil(head, null);
	}
	public Node mergeSortedList(Node head1, Node head2){
		if(head1==null) return head2;
		if(head2==null) return head1;
		
		if(head1.data < head2.data){
			head1.next = mergeSortedList(head1.next, head2);
			return head1;
		}else{
			head2.next = mergeSortedList(head2.next, head1);
			return head2;
		}
	}
	Node reverseKNodes(Node head, int k)
    {
       Node current = head;
       Node next = null;
       Node prev = null;
        
       int count = 0;
 
       /* Reverse first k nodes of linked list */
       while (count < k && current != null) 
       {
           next = current.next;
           current.next = prev;
           prev = current;
           current = next;
           count++;
       }
 
       /* next is now a pointer to (k+1)th node 
          Recursively call for the list starting from current.
          And make rest of the list as next of first node */
       if (next != null) 
          head.next = reverseKNodes(next, k);
 
       // prev is now head of input list
       return prev;
    }
	public int getHeadData(){
		return this.head.data;
	}
	public boolean isEmpty(){
		return this.head == null;
	}
	public static void main(String[] args){
		LinkedList l1 = new LinkedList();
		l1.addAtFirst(1);
		l1.addAtLast(5);
		l1.addAtLast(8);
		l1.addAtLast(10);
		l1.addAtLast(11);
		l1.printList();
		l1.reverseRec();
		System.out.println();
		l1.printList();
//		System.out.println();
//		LinkedList l2 = new LinkedList();
//		l2.addAtFirst(2);
//		l2.addAtLast(3);
//		l2.addAtLast(6);
//		l2.addAtLast(7);
//		l2.addAtLast(12);
//		l2.printList();
//		System.out.println();
//		Node newHead = l1.mergeSortedList(l1.head,l2.head);
//		l1.head = newHead;
//		l1.printList();
//		System.out.println();
//		newHead = l1.reverseKNodes(l1.head,3);
//		l1.head = newHead;
//		l1.printList();
		//ll.swapByLink(8, 4);
		//System.out.println();
		/*ll.reverseRec();
		
		ll.printList();
		
		System.out.println();
		ll.reverseItr();
		ll.printList();*/
	}
}
