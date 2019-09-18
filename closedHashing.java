//Using closed address hashing, compare between hash tables of prime and nonprime sizes (Group 2).
import java.util.*;

public class closedHashing 
{
	private static final int TABLE_SIZE = 2053;
	//private static double load_factor = 0.5;
	
	public static class HTnode {		// Node structure
		public Integer key;
		public Integer value;
	}

	private static LinkedList<HTnode>[] Ctable = new LinkedList[TABLE_SIZE];
	// Creating a linked list of HTnode

	public closedHashing() {
		//initalize null values in hashtable
		for (int i = 0; i < TABLE_SIZE; i++) {
			Ctable[i] = null;
		}
	}
	
	public void addKey(Integer key, Integer value, Integer index) 
	{	
		/* int index = key.hashCode() % TABLE_SIZE; */
		LinkedList<HTnode> items = Ctable[index];
		
		if(items==null) {
			//if nothing at location create LL and add item in
			items = new LinkedList<HTnode>();
			HTnode node = new HTnode();
			node.key = key;
			node.value = value;
			
			items.add(node);
		}
		else {
			//add item into existing LL
			HTnode node = new HTnode();
			node.key = key;
			node.value = value;
			items.add(node);
		}
	}

	public HTnode search(Integer key, Integer value,Integer index) {
		LinkedList<HTnode> items = Ctable[index];
		return null ;

		
	}

	public static void main(String[] args) {
		// Generate a key-value pair
		/**
		 * Number of keys = tablesize * load factor
		 * loop
		 * call addkey
		 */

		 /**
		  * collect timing
		  * collect comparision timings
		  */
	}


}