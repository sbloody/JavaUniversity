package utility.collection;

import java.io.Serializable;

public class ArrayStack<T> implements StackADT<T>, Serializable{
	private static final int DEFAUL_CAPACITY = 100;
	private int top;
	private T[] stack;

	public ArrayStack() {
		this.top = 0;
		stack = (T[]) new Object[DEFAUL_CAPACITY];
	}

	public ArrayStack(int initialCapacity) {
		this.top = 0;
		stack = (T[]) new Object[initialCapacity];
	}

	public String toString() {
		String s = "{";
		for (int i = top - 1; i > 0; i--)
			s += stack[i] + ", ";
		s += stack[0] + "}";
		return s;
	}

	private void expandCapacity() {
		T[] stack1 = (T[]) new Object[2 * stack.length];
		for (int i = 0; i < top - 1; i++) {
			stack1[i] = stack[i];
		}
		stack = (T[]) new Object[stack1.length];
		stack = stack1;
	}

	public void push(T element) {
		if (top >= stack.length) {
			expandCapacity();
		} else {
			stack[top] = element;
			top++;
		}

	}

	public T pop() {
		T element;
		if (top == 0) {
			throw new IllegalStateException("Stack is empty!!!");
		} else {
			element = stack[top - 1];
			stack[top - 1] = null;
			top--;
		}
		return element;
	}

	public T peek() {
		if (top == 0) {
			throw new IllegalStateException("Stack is empty!!!");
		}
		return stack[top - 1];
	}

	public int indexOf(T element) {
		if (element == null) {
			for (int i = top - 1; i >= 0; i--) {
				if (element == (stack[i])) {
					return top - 1 - i;
				}
			}
		} else {
			for (int i = top - 1; i >= 0; i--) {
				if (element.equals(stack[i])) {
					return top - 1 - i;
				}
			}
		}
		return -1;
	}

	public boolean isEmpty() {
		if (top == 0)
			return true;
		return false;
	}

	public int size() {
		return top;
	}

}
