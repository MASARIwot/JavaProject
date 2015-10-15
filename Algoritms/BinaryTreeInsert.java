package partof;

public class BinaryTreeInsert<T extends Comparable<T>> {

	/**
	 * A root in a binary tree
	 */
	protected Node<T> root = null;
	
	/**
	 * A node in a binary tree
	 */
	private static class Node<T> {

		private T value;
		private Node<T> left = null;
		private Node<T> right = null;

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
		private Node(T value, Node<T> left, Node<T> right) {
			this.value = value;
			this.left = left;
			this.right = right;
		}
		/**
		 * Copy Constructor
		 * @return Node<T> root, copy tree
		 */
		protected Node<T> copy() {
	        Node<T> left = null;
	        Node<T> right = null;
	        if (this.left != null) {
	            left = this.left.copy();
	        }
	        if (this.right != null) {
	            right = this.right.copy();
	        }
	        return new Node<T>(value, left, right);
	    }
		

	}// Node

	/**
	 *Copy tree 
	 * @see method Node.copy();
	 * @return copy tree
	 */
	public Node<T> binaryTreeInsert() {

		return root.copy();
	}

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
			if (node.left != null)
				return insert(node.left, value);
			else{
				node.left = new Node<T>(value);
				return true;
			}
		else
		if (value.compareTo(node.value) < 0)
			if (node.right != null)
				return insert(node.right, value);
			else{
				node.right = new Node<T>(value);
				return true;
			}
		else return false;
	}
	public void remove(T value){
		remove(value,this.root);
	} 
//	TODO: comment
	protected void remove(T value, Node<T> node){
		if (node == null)
			return;

		if (value.compareTo(node.value) == 0) {
			// TODO:realization
			if (node.left != null && node.right != null) {
				/* node has two children */
				Node<T> maxFromLeft  = getLeftmost(node.left);
				node.value = maxFromLeft .value;
				remove(maxFromLeft .value, node.left);

			} else if (node.left == null) {

				node = node.left;

			} else if (node.right == null) {

				node = node.right;
			}

		} else {
			if (value.compareTo(node.value) > 0) {
				remove(value, node.left);
			} else {
				remove(value, node.right);
			}
		}

	}
	
//	TODO: comment 
	protected Node<T> getRightmost(Node<T> node) {
		assert (node != null);
		Node<T> right = node.right;
		if (right == null) {
			return node;
		} else {
			return getRightmost(right);
		}
	}
//	TODO: comment
	protected Node<T> getLeftmost(Node<T> node) {
		assert (node != null);
		Node<T> left = node.left;
		if (left == null) {
			return node;
		} else {
			return getRightmost(left);
		}
	}
	 
//		TODO: comment
	 @SuppressWarnings("unused")
	private Node<T> findMax(Node<T> node){
//		 TODO: realization
		 if(node == null) return null;
		 while(node != null){
			 node = node.left;
		 }
		 return node;
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
	 * node is the root of the subtree to start represent
     * @returns	the string representation of the tree.
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

}//thanks
