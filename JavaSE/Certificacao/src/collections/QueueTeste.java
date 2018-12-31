package collections;

import java.util.ArrayDeque;
import java.util.Deque;

public class QueueTeste {
	public static void main(String[] args) {
		/*Queue<Integer> queue = new ArrayDeque<>();
		System.out.println(queue.offer(10));
		System.out.println(queue.offer(4));
		System.out.println(queue);
		System.out.println(queue.peek());
		System.out.println(queue.peek());*/
		
		Deque<Integer> stack = new ArrayDeque<>();
		stack.push(10);
		stack.push(4);
		stack.add(20);
		stack.push(5);
		System.out.println(stack.getFirst());
		System.out.println(stack);
		System.out.println(stack.peek());
		System.out.println(stack);
		System.out.println(stack.pop());
		System.out.println(stack);
		System.out.println(stack.remove());
		System.out.println(stack);
		System.out.println(stack.poll());
		System.out.println(stack);
	}
}
