package list.circle;

import java.util.LinkedList;
import java.util.List;


/**
 * Circle List contains restricted set of element If added element more than set
 * number it will rewritten element from first position to the end and make
 * second element as a head
 * 
 * If you need to remember only the last N elements. take it  
 * 
 * exmp: size = 5 
 * 0 1 2 3 4
 * 1 2 3 4 5
 * 2 3 4 5 6
 * 3 4 5 6 7 
 * 4 5 6 7 8
 * 5 6 7 8 9
 * 6 7 8 9 10 
 * 
 * @author OTretiak
 * @param <T> type of object
 */
public class CirclListModification<T extends Comparable<T>> {
	/**
	 * Node keeps track of each element information
	 * @author OTretiak
	 * @param <T> type of value 
	 */
	private static class Node<T>{
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
		 * @param T value
		 * @param Node<T> next 
		 */
		private Node(T value, Node<T> next){
			this.value = value;
			this.next = next;
		}
		/**
		 * copy by copy constructor
		 * @return Node<T> ref for head of copy
		 */
		private Node<T> copy(){
			Node<T> next = null;
			if(this.next != null){
				next = this.next.copy();
			}
			return new Node<T>(this.value, next);
		}
	
	}//Node
	/**
	 * make copy of current collection
	 * @return Node<T> ref for new copy head 
	 */
	protected Node<T> CircleNodeListCopy() {
		return this.head.copy();		
	}
	/**
	 * get copy of collection
	 * @return copy of current CirclListModification<T> 
	 */
	public CirclListModification<T> CirclListModificationCopy(){
		CirclListModification<T> copy  = new CirclListModification<T>(this.size);
		copy.head = this.head.copy();
		return copy;
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
	 * count number of created elements
	 */
	private int counter;
	/**
	 * Capacity of collection   
	 */
	private int size;
	/**
	 * init constructor
	 * @param size of the collection
	 */
	public CirclListModification(int size){
		this.size = size;
		this.counter = 0;
	}
	/**
	 * adds a value to the end of the list
	 * @param the value to be added
	 * @return res of operation
	 */
	public boolean add( T value) {
		if (this.head != null) {
			addToEnd(value);
		} else {
			addToHead(value);
		}
		//if counter full stop to add
		if(this.counter < this.size)
		this.counter++;
		//it is always true..yes it is amazing :)
		return true;
	}
	/**
	 * add element to the tail of list.
	 * @param the value to be added
	 * @throws throw RuntimeException if tail = null 
	 */
	private void addToEnd(T value) {
		if (value == null)
			throw new RuntimeException("Null really 0_o ?");
		// replace objects from head to tail and update value. new tail = head /
		// new head = head.next
		if (this.size <= this.counter) {
			Node<T> trash = this.head;
			this.head = this.head.next;
			trash.next = null;
			trash.value = value;
			this.tail.next = trash;
			this.tail = trash;
		}
		// Create new object at first iteration, until size != counter
		// then it will work with existing object
		else {
			Node<T> newNode = new Node<T>(value);
			tail.next = newNode;
			tail = newNode;
		}
	}
	/**
	 * add element to the head of list
	 * @param the value to be added
	 */
	private void addToHead(T item) {
		this.head = new Node<T>(item, head);
		if (this.tail == null)
			this.tail = this.head;
	}
	/**
	 * get equivalent(representation) of the collection as a List
	 * @return List<T> 
	 */
	public List<T> getAsList(){
		return getAsList(new LinkedList<T>(), this.head);		
	}
	/**
	 * 
	 * @param list to insert
	 * @param node element  to start  
	 * @return List<T> res
	 */
	protected List<T> getAsList(List<T> list, Node<T> node){
		if(node == null) return list;
		list.add(node.value);
		return getAsList(list,node.next);
	}
	/**
	 * String representation
	 * @return String representation of the collection 
	 */
	public String toString(){
		return toString(head);
	}
	/**
	 * @param node element to start
	 * @return String representation of collection
	 */
	protected String toString(Node<T> node) {
		if (node == null)
			return "";
		return node.value + " " + toString(node.next);
	}

	// TODO: in process Test -
	public T get(T value) {
		return get(this.head, value).value;
	}

	// TODO: in process Test -
	protected Node<T> get(Node<T> node, T value) {

		if (node != null)
			if (node.value.compareTo(value) == 0) {
				return node;
			} else
				return get(node.next, value);

		return null;
	}

	// TODO: in process Test -
	public boolean contain(T value) {
		return contain(this.head, value);
	}

	// TODO: in process Test -
	protected boolean contain(Node<T> node, T value) {
		if (node.next != null) {
			if (node.value.compareTo(value) == 0) {
				return true;
			} else
				return contain(node.next, value);
		} else
			return false;
	}
	// // TODO: in process Test -
	// public boolean update(){
	//
	// }
	//
	// // TODO: in process Test -
	// public boolean update(Node<T> node, T value) {
	//
	// if()
	//
	// }
}
	

