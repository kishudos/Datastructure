package linkedlist;

import java.util.Scanner;

public class LinkedListTest {

	private static Scanner sc;

	public static void main(String[] args) {
		LinkedList l1 = new LinkedList();
		sc = new Scanner(System.in);
		System.out.println("Enter elements for linked list");
		int no;
		while ((no = sc.nextInt()) != -1) {
			l1.addAtLast(no);
		}
		l1.printList();
		System.out.println("Enter k to rotate");
		int k = sc.nextInt();
		l1.rotateAntiClockWise(k);
		System.out.println();
		l1.printList();
		/*
		 * LinkedList list = new LinkedList(); list.head = new Node(1); list.head.next =
		 * new Node(2); list.head.next.next = new Node(3); list.head.next.next.next =
		 * new Node(4); list.head.next.next.next.next = new Node(5);
		 * list.head.next.next.next.next.next = new Node(6); //creating loop
		 * list.head.next.next.next.next.next.next = list.head; list.hasLoop();
		 * list.printList();
		 */
	}

}
