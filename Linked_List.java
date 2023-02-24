
public class Linked_List {
	private MyNode head;
	
	public Linked_List() {
		head = null; // set head to null
	}
	
	public Linked_List(int value) {
		//put the value into the head of the linked list
		//using the MyNode constructor
		head = new MyNode(value);
	}
	
	//Looks at how big the linked list is and returns it cant use a counter 
	public int size() {
		MyNode walker = head; //Makes the walker the beginning of the list
		return rsize(walker); //Calls the recursive method rsize
	}
	public int rsize(MyNode counter) {
		if(head == null) //Have to look if the size is empty if its empty then just return 
			return 0;
		else if (counter == null) { //We pass through our counter and we set it when it hits the end of the list
			return  0;
		}
		else {
			return 1 + rsize(counter.getNext()); //we are couting how many times until we hit null or the end of the list 
		}
	}
	
	//Looks at the linked list to see if the nodes are empty
	public boolean isEmpty() {
		if(head == null) {//If the head is null that must mean that there is nothing there thus empty
			System.out.println("This list is empty:");
			return true;
			} 
		else { //Prints out if the list is not empty if it isnt empty?
			print();
			System.out.println("This list is not empty");
			return false;
		}
	}
	
	//Guessing that add is like an addLast method?
	public void add(int value) {
		MyNode newNode = new MyNode(value); //Create node
		if(head == null) { //Going back to the is empty method above if it is empty we make a new node at the beginning of the list 
			head = newNode; // makes the new Node the head of the list
			}
		else {
			MyNode walker = head; //Creates a walker to transverse the list
			while(walker.getNext() != null)//go to end of the list since we know that the list has nodes inside then go to where next.getNext() == null;
			{
				walker = walker.getNext(); 
			}
			walker.setNext(newNode); //Now that we are at the end of list we make the next one the newNode
		}
	}
	
	//Adding a value at a given position in the linked list
	public void insert(int value, int pos) {
		MyNode newNode = new MyNode(value); //Create our newNode and walker 
		MyNode walker = head;
		int place = 0; //making a place int
		if(head == null)//if we are at the start of the list put this there no matter what
			head = newNode; //Makes the new Node the head
		else if(pos > rsize(head)) { //if the position is bigger than the list
			while(walker.getNext() != null) { // if we arent at the end of the list
				walker = walker.getNext(); 
			}
			walker.setNext(newNode); //when we hit the end of the list place the node
		}
		else if(place == pos && head == walker) { // if we are at the beginning of the list make the newNode the head
			newNode.setNext(head);
			head = newNode;
		}
		else {
			while(walker != null && place != pos-1) { // if we are before the position then we add the next one
				walker = walker.getNext();
				place++;
				}
				newNode.setNext(walker.getNext());
				walker.setNext(newNode);
		}
		
	}
	
	//Goes through the linked list and finds the value we want then remove the value or node?
	public void remove(int value) {
		MyNode walker = head;
		MyNode temp = null;
		if(head == null){ //if the list is empty say that the list is empty
			System.out.println("This list is empty:");
			return;
		}
		else if(head.getNext() == null && head.getData() != value) { // if we are at the end of the list and the value isnt there we print out that it doesnt exist
			System.out.println("This value does not exist in this list: ");
			return;
		}
		else if(walker == null) { //if we ar at the end of the list say that the value is not in there
			System.out.print("This value does not exist in this list: ");
			return;
		}
		else if(head.getData()== value && head.getNext() != null ) { // if we are at the beginning of the list we delete the node
			temp = head; //save the head as a temp
			head = head.getNext();// get the head with head
			temp.setNext(null);; // delete the temp

		}
		//^^^ Do i have a hanging node here?
		else {
			while(walker != null && walker.getNext()!=null) { // transverse to the end of the list
				if(value == walker.getNext().getData()) { //go until we hit the desired value
					temp = walker.getNext(); // save the walker.getNext to temp;
					walker.setNext(walker.getNext().getNext()); //get the value thats 2 spots away
					temp.setNext(null);  // set temp to null to delete
				}
				walker=walker.getNext(); // keep walking until told not to 
			}
			
		}		
	}
	
	//Deletes a linked list at a given position 
	public  void delete(int pos) {
		MyNode walker = head; // create out walker, temp nodes and out place int
		MyNode temp = null;
		int place =0;
		if(head == null){ //Create our variable
			System.out.println("This list is empty:");
			return;
		}
		else if(head.getNext() == null) { //If there is only one Node in the list see if head.getNext() == null;
			head = null;
		}
		else if(pos > size()) { // if out size is bigger than the list
			System.out.println("[This position is beyond the size of the list] ");
		}
		else if( pos == place && head == walker) { // if we are at the start of the list save the head node and delete the node;
			temp = head; // save head as a temp
			head = head.getNext(); // get the next head and save that as a head
			temp.setNext(null);; // delete the temp
		}
		//^^^ Do i have a hanging node here?
		else {
			while(walker != null && place <= pos) { // get to the desired position and it isnt at the end of the list
				if(place++ == pos-1) { // get to the place before the desired position
					temp = walker.getNext(); //save the walker.next as a temp
					walker.setNext(walker.getNext().getNext()); // set the next with the 2 behind that
					temp.setNext(null);  // get temp to null
			}
			walker=walker.getNext();
		}
		}
	
	}

	//Goes through the Linked List and Displays the values
	//Should i use recursive what would be easier if since i have to do 2 method for recursive since its going to be private
	public void print(){
		MyNode walker = head;
		rprint(walker);
	}
	public void rprint(MyNode walker) {
		if (head == null) { // if the list is empty
			System.out.println("List is empty");
			return;
			}
			//check that the current node is the last node
			else if (walker == null) { 
			System.out.println("");
			return;
			}
			else {
			//print the current node's data
			System.out.print("[ "+walker.getData()+" ] ");
			//pass the next node recursively
			rprint(walker.getNext());
			}
	}
	
	//Main Function to see if LL worked
	public static void main(String[] args) {		
		Linked_List list = new Linked_List();
		System.out.println("Checking is the list Empty or Not:");
		list.isEmpty();
		System.out.println();
		System.out.println("The size of the list is: " + list.size());
		System.out.println();
		
		System.out.print("Checking is the list Empty or Not:");

		list.add(89);
		System.out.println();
		list.isEmpty();
		System.out.println();
		System.out.println("The size of the list is: " + list.size());

		System.out.println();
		System.out.println("Adding Values in list: ");
		list.add(20);
		list.add(40);
		list.add(60);
		list.add(10);
		list.add(15);
		list.add(35);
		list.print();
		System.out.println();
		System.out.println("The size of the list is: " + list.size());

		System.out.println();
		System.out.println("Deleting at position 2 and removing 10 from inside list: ");
		list.delete(2);
		list.remove(10);
		list.remove(35);
		list.delete(0);
		list.print();
		list.delete(10);
		System.out.println();
		System.out.println("The size of the list is: " + list.size());

		System.out.println();
		System.out.println("Inserting a value in the beginning the middle and the end and out of bounds: ");
		list.insert(45,5);
		list.insert(50,10);
		list.insert(99, 0);
		list.insert(120,1);
		list.print();
		System.out.println();
		System.out.print("The size of the list is: " + list.size());
		
		
	}

}
