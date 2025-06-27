class ArrayStack<T>{
	private T[] stack;
	private int top; 
	private int capacity; 
	
	public ArrayStack(int size) {
		capacity= size;
		stack= (T[]) new Object[size];
		top= -1;
	}
	
	public void push(T element) {
		if(top == capacity-1) {
			System.out.println("Stack overflow!");
			return;
		}
		stack[++top]= element;
	}
	
	public T pop() {
		if(top == -1) {
			System.out.println("Stack underflow!");
			return null;
		}
		return stack[top--];
	}
	
	public T peek() {
		if(top == -1) {
			System.out.println("Stack underflow!");
			return null;
		}
		
		return stack[top];
	}
	
	public boolean isEmpty() {
		return top == -1;
	}
}


class LinkedListStack<T>{
	private class Node{
		T data;
		Node next;
		Node(T data){
			this.data= data;
			this.next= null;
		}
	}
	
	private Node top; 
	public LinkedListStack() {
		top= null;
	}
	
	public void push(T element) {
		Node newNode= new Node(element);
		newNode.next= top;
		top= newNode;
	}
	
	public T pop() {
		if(top == null) {
			System.out.println("Stack underflow");
			return null;
		}
		
		T data= top.data; 
		top= top.next;
		return data;
	}
	
	public T peek() {
		if(top == null) {
			System.out.println("Stack underflow");
			return null;
		}
		
		return top.data;
	}
	
	public boolean isEmpty() {
		return top == null;
	}
}
public class DemoStack {
	public static void main(String args[]) {
		System.out.println("Using Array based stack");
		ArrayStack<Integer> intArrayStack= new ArrayStack<>(5);
		intArrayStack.push(10);
		intArrayStack.push(20);
		intArrayStack.push(30);        
		System.out.println("10,20,30");		
		System.out.println("Popped: "+ intArrayStack.pop());
		System.out.println("Peek: "+ intArrayStack.peek());
		
		ArrayStack<String> stringArrayStack= new ArrayStack<>(3);

		stringArrayStack.push("abhi");
		stringArrayStack.push("gun");
		stringArrayStack.push("arun");		
        System.out.println("abhi,gun,arun");
		System.out.println("Popped: "+ stringArrayStack.pop());
		System.out.println("Peek: "+ stringArrayStack.peek());
		
		System.out.println("\nUsing linked list based stack");
		LinkedListStack<Double> doubleLinkedList= new LinkedListStack<>();
		doubleLinkedList.push(10.5);
		doubleLinkedList.push(20.5);
		doubleLinkedList.push(30.5);
		
		System.out.println("Popped: "+ doubleLinkedList.pop());
		System.out.println("Peek: "+ doubleLinkedList.peek());
		
		LinkedListStack<String> strLinkedListStack= new LinkedListStack<>();
		strLinkedListStack.push("Generic");
		strLinkedListStack.push("Stack");
		strLinkedListStack.push("Demo");
		
		System.out.println("Popped: "+ strLinkedListStack.pop());
		System.out.println("Peek: "+ strLinkedListStack.peek());
	}
}
