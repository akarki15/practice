package leet;

import java.util.Stack;

public class QueueUsingStack {
	public static void main(String[] args) {
		MyQueue myQueue = new MyQueue();
		for (int i = 0; i < 50; i++) {
			if (Math.random() > 0.5) {
				myQueue.pop();
			}
			myQueue.push((int) (100 * Math.random()));
		}
	}
}
class MyQueue {
	Stack<Integer> A = new Stack<Integer>();
	Stack<Integer> B = new Stack<Integer>();
	boolean indicator = true; // true indicates stack1 being used

	// Push element x to the back of queue.
	public void push(int x) {
		/* Stack<Integer> s = indicator ? stack1 : stack2; */
		A.push(x);
	}

	// Removes the element from in front of queue.
	public void pop() {
		if (B.size() == 0)
			transfer(A, B);
		B.pop();
	}

	private void transfer(Stack<Integer> A, Stack<Integer> B) {
		while (A.size() != 0) {
			B.push(A.pop());
		}
	}

	// Get the front element.
	public int peek() {
		if (B.size()==0)
		    transfer (A, B);
		return B.peek();
	}

	// Return whether the queue is empty.
	public boolean empty() {
		return (A.size() == 0 && B.size() == 0);
	}
}