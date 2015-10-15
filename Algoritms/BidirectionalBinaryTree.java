package partof;



public class BidirectionalBinaryTree<T extends Comparable<T>> {
	
	protected Node<T> root = null;
	
	private static class Node<T> {

		private T value;
		private Node<T> left = null;
		private Node<T> right = null;
		private Node<T> previous = null;

		/**
		 * build a node with no subtrees
		 * @param value  to be stored 
		 */
		private Node(T value) {
			this.value = value;
		}

		/**
		 * build a node with param
		 * @param value to be stored 
		 * @param left subtree for this node
		 * @param right subtree for this node
		 */
		private Node(T value, Node<T> left, Node<T> right, Node<T> previous) {
			this.value = value;
			this.left = left;
			this.right = right;
			this.previous = previous;
		}

	}// Node
	
	/**
	 * add a value to the tree
	 * @param value
	 * @return boolean result of operation
	 */
	public boolean insert(T value){
		return insert(root, value);
	}

	
	/**
	 * add a value to the tree
	 * @param node == root the subtree
	 * @param value to be stored 
	 * @return boolean result of operation
	 */
	protected boolean insert(Node<T> node, T value) {

		if (value == null)
			return false;
		if (node == null) {
			root = new Node<T>(value);
			return true;
		}
		if (value.compareTo(node.value) > 0)
			if (node.left != null) {
				return insert(node.left, value);
			} else {
				node.left = new Node<T>(value);
				node.left.previous = node;
				return true;
			}
		else if (value.compareTo(node.value) < 0)
			if (node.right != null) {
				return insert(node.right, value);
			} else {
				node.right = new Node<T>(value);
				node.right.previous = node;
				return true;
			}
		else
			return false;
	}
	/**
	 * find a value in the tree
	 * @param	key identifies the node value
	 * @return	the node value if found, or null if not found
	 */
	public T get(T key) {
		Node<T> node = root;
		while (node != null) {
			if (key.compareTo(node.value) == 0) {
				return node.value;
			} else if (key.compareTo(node.value) < 0) {
				node = node.right;
			} else {
				node = node.left;
			}
		}
		return null;
	}
	
	/**
	 * find a value in the tree
	 * @param	key that identifies the node 
	 * @return	the Node<T> if found by key, or null if not found
	 */
	protected Node<T> getNode(T key) {
		Node<T> node = root;
		while (node != null) {
			if (key.compareTo(node.value) == 0) {
				return node;
			} else if (key.compareTo(node.value) < 0) {
				node = node.right;
			} else {
				node = node.left;
			}
		}
		return null;
	}

	/**
	 * 
	 * @param node to start reverse access
	 * @return string result of reverse process
	 */
	protected String toStringReverse(Node<T> node) {
		if (node.previous == null) {
			return "";
		}
		return node.previous.value.toString() + " "
				+ toStringReverse(node.previous);
	}

	/**
	 * node is the root of the subtree to start represent
	 * @returns the string representation of the tree.
	 */
	protected String toString(Node<T> node) {
		if (node == null) {
			return "";
		}
		return node.value.toString() + " " 
				+ toString(node.left) + " "
				+ toString(node.right);
	}
	
	/**
     * @returns	the string representation of the tree.
     */
	public String toString() {
		return toString(root);
	}
	/**
	 * reverse representation of branch (in the tree)
	 * @param value to start
     * @returns	the string representation .
     */
	public String toString(T value) {
		return toStringReverse(getNode(value));
	}
	
	
}

