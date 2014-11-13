package crimson.cache;

import java.util.HashMap;

/**
 * Custom doubly linked list data structure for LRU eviction strategy.
 * @author ragini
 *
 */

public class LRUList {

	Node head;
	Node tail;
	
	HashMap<String, Node> nodeIndex = new HashMap<>();
	
	class Node {
		public Node(String key) {
			this.key = key;
		}
		Node next;
		Node prev;
		String key;
	}

	public Node append(String key) {
		Node node = new Node(key);
		nodeIndex.put(key, node);
		if(head == null) {
			head = node;
			tail = node;
		} else {
			tail.next = node;
			node.prev = tail;
			tail = node;
		}
		return node;
		
	}

	public void pushToTail(String key) {
		Node node = nodeIndex.get(key);
		//
		if(node == tail) {
			return;
		} else if (node == head) {
			head = head.next;
			head.prev = null;
		} else {
			node.prev.next = node.next;
		}
		tail.next = node;
		node.prev = tail;
		tail = node;
		//
		node.next = null;
		
	}

	public String poll() {
		if(head == null) {
			return null;
		}
		String result = head.key;
		head = head.next;
		nodeIndex.remove(result);
		return result;
	};
	
}
