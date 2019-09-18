
//Using closed address hashing, compare between hash tables of prime and nonprime sizes (Group 2).
import java.util.*;
import java.lang.Iterable;

public class closedHashing 
{
	private static final int TABLE_SIZE = 2053;
	private static double LOAD_FACTOR = 0.5;
	
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
	
	public static void addKey(Integer key, Integer value, Integer index) 
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

	public static HTnode search(Integer key,Integer index) {
		boolean status;
		LinkedList<HTnode> items = Ctable[index];
		status = items.contains(key);
		
		if (status) {
			for(HTnode item : items) {
				if(item.key.equals(key))
					return item.value;
			}
		}
		else {
			return null;
		}
		
	}
	
	public static int IndexOf(int key) {
		return (key % TABLE_SIZE);
	}

	public static void main(String[] args) {

		// Generate a key-value pair
		
		DataGen kvm = new DataGen(TABLE_SIZE,LOAD_FACTOR);
		HashMap<Integer, Integer> kvMap = new HashMap<Integer, Integer>();
		kvMap = kvm.getHash();			//SAVED into kvMap
		
		for (Integer i : kvMap.keySet()) {
			System.out.println("key: " + i + " value: " + kvMap.get(i))	;
		}

		// End of KEY Gen
		int choice;
		int key;
		Scanner sc = new Scanner(System.in);
		System.out.println("-------- Example Class 2 Question 2 --------");
		System.out.println("| 1. Search");
		System.out.println("| 2. Add");
		System.out.println("| 3. Display Average CPU time");
		System.out.println("| 4. Display Average Key Comparison");
		System.out.println("| 5. Load Factor");
		System.out.println("| 6. Exit");
		choice = sc.nextInt();
		switch(choice) {
			case 1://Search
				System.out.println("Please enter your key: ");
				key = sc.nextInt();
				System.out.println("The value is: " + search(key, IndexOf(key)));
				break;
				
			case 2://Add
				System.out.println("Enter the key: ");
				key = sc.nextInt();
				System.out.println("Enter the value: ");
				//value = sc.NextInt();
				
						
			case 3://Display Average CPU time
				
				break;
			
			case 4://Display Average Key Comparison
				
				break;
				
			case 5://Load Factor
				
				break;
				
			case 6://Exit
				System.out.println("Thank you!!");
				break;
		}
		
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
