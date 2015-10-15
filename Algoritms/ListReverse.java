package list.circle;

public class ListReverse<T extends Comparable<T>> {

	/**
	 * Node keeps track of each element information
	 * 
	 * @author OTretiak
	 * @param <T>
	 *            type of value
	 */
	private static class Node<T> {
		/**
		 * save it
		 */
		private T value = null;
		/**
		 * ref for next element
		 */
		private Node<T> next = null;

		private Node(T value) {
			this.value = value;
		}

		/**
		 * Copy constructor
		 * 
		 * @param T
		 *            value
		 * @param Node
		 *            <T> next
		 */
		private Node(T value, Node<T> next) {
			this.value = value;
			this.next = next;
		}

		/**
		 * copy by copy constructor
		 * 
		 * @return Node<T> ref for head of copy
		 */
	
		@SuppressWarnings("unused")
		private Node<T> copy() {
			Node<T> next = null;
			if (this.next != null) {
				next = this.next.copy();
			}
			return new Node<T>(this.value, next);
		}
//		TODO: comment
		private Node<T> reverse(Node<T> head){
			 if (head != null) {
				 Node<T> prev = null;
			        while (head.next != null) {
			        	Node<T> next = head.next;
			            head.next = prev;
			            prev = head;
			            head = next;
			        }
			        head.next = prev;
			    }
			return head;
		}
//		TODO: comment
		private Node<T> reverse(){
			 if (this.next == null) return this;
			    // third question - in Lisp this is easy, but we don't have cons
			    // so we grab the second element (which will be the last after we reverse it)
			    Node<T> secondElem = this.next;
			    // bug fix - need to unlink list from the rest or you will get a cycle
			    this.next = null;
			    // then we reverse everything from the second element on
			    Node<T> reverseRest = reverse(secondElem);
			    // then we join the two lists
			    secondElem.next = this;
			return reverseRest;
		}
		
		

	}// Node
//	TODO: comment
	public void reverseRec(){
		this.head = this.head.reverse();
	}
	public void reverse(){
		this.head = this.head.reverse(head);
	}
	
	/**
	 * head of collection
	 */
	private Node<T> head = null;
	/**
	 * last element
	 */
	private Node<T> tail = null;
	/**
	 * Capacity of collection
	 */
	private int size;

	/**
	 * adds a value to the end of the list
	 * 
	 * @param the
	 *            value to be added
	 * @return res of operation
	 */
	public boolean add(T value) {
		if (this.head != null) {
			addToEnd(value);
		} else {
			addToHead(value);
		}
		// if counter full stop to add
		// it is always true..yes it is amazing :)
		return true;
	}

	/**
	 * add element to the tail of list.
	 * 
	 * @param the
	 *            value to be added
	 * @throws throw
	 *             RuntimeException if tail = null
	 */
	private void addToEnd(T value) {
		if (value == null)
			throw new RuntimeException("Null really 0_o ?");

		Node<T> newNode = new Node<T>(value);
		tail.next = newNode;
		tail = newNode;

	}

	/**
	 * add element to the head of list
	 * 
	 * @param the
	 *            value to be added
	 */
	private void addToHead(T item) {
		this.head = new Node<T>(item, head);
		if (this.tail == null)
			this.tail = this.head;
	}

	/**
	 * String representation
	 * 
	 * @return String representation of the collection
	 */
	public String toString() {
		return toString(head);
	}

	/**
	 * @param node
	 *            element to start
	 * @return String representation of collection
	 */
	protected String toString(Node<T> node) {
		if (node == null)
			return "";
		return node.value + " " + toString(node.next);
	}

}
