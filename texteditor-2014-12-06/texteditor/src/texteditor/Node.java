package texteditor;
class Node {
	Node next;
	String data;

	void setData(String v) {
		data = v;
	}

	void setNext(Node n) {
		next = n;
	}

	String getData() {
		return data;
	}

	Node getNext() {
		return next;
	}
}

