public class MyNode {

	private int nodeData;	//node's data
	private MyNode next;	//node's next pointer
	 

    //parameterized constructor
	public MyNode(int data) { 
		nodeData = data;     //initialize nodeData to parameter data
		next = null;		 //initialize next to null
	}

    //getter function to get data from the node
	public int getData() {
		return nodeData;	//return node's data
	}

    //setter function to set nodeData to the given parameter
	public void setData(int data) {
		nodeData = data;	//set node's data
	}

    //getter function to get the next pointer from the node
	public MyNode getNext() {
		return next;	//return node's next pointer
	}

    //setter function to set node's next pointer to the given parameter newnode
	public void setNext(MyNode newnode) {
		next = newnode;	//set node's next pointer
	}
}