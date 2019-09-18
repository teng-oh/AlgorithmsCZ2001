package closedHashing;

//Using closed address hashing, compare between hash tables of prime and nonprime sizes (Group 2).
import java.util.*;
import java.lang.Iterable;

public class closedHashing {
	private static final int TABLE_SIZE = 2053;
	private static double LOAD_FACTOR = 2;
	private static float comparison = 0;
	private static int numOfTimes = 0;
	private static int numOfData = 0;

	public static class HTnode { // Node structure
		public Integer key;
		public Integer value;
	}

	private static LinkedList<HTnode>[] Ctable = new LinkedList[TABLE_SIZE];
	// Creating a linked list of HTnode

	public closedHashing() {
		// initalize null values in hashtable
		for (int i = 0; i < TABLE_SIZE; i++) {
			Ctable[i] = null;
		}
	}

	public static void addKey(Integer key, Integer value, Integer index) {
		/* int index = key.hashCode() % TABLE_SIZE; */
		LinkedList<HTnode> items = Ctable[index];

		if (items == null) {
			// if nothing at location create LL and add item in
			items = new LinkedList<HTnode>();
			HTnode node = new HTnode();
			node.key = key;
			node.value = value;

			items.add(node);
			Ctable[index] = items;
		} else {
			// add item into existing LL
			HTnode node = new HTnode();
			node.key = key;
			node.value = value;
			items.add(node);
		}
		numOfData++;
	}

	public static Integer search(Integer key, Integer index) {
		boolean status = false;
		LinkedList<HTnode> items = Ctable[index];
		Integer key2 = key;
		numOfTimes++;
		for (HTnode i : items) {
			if (i.key.equals(key)) {
				status = true;
			} else
				comparison++;
		}

		if (status) {
			for (HTnode item : items) {
				if (item.key.equals(key2)) {
					return item.value;
				}
			}
		}
		return -1;
	}

	public static float avgComparisons() {
		float avgComparisons = 0;

		if (numOfTimes == 0)
			return -1;
		avgComparisons = comparison / numOfTimes;

		return avgComparisons;
	}
	
	public static void comparisons_all(HashMap<Integer,Integer> kvMap) {
	    for (Integer i : kvMap.keySet()) {
	      //System.out.println("Postal Code: " + i + " Population Size: " + kvMap.get(i));
	      search(i, IndexOf(i));
	    }
	    System.out.println("Number of Data: " + numOfTimes +  "\nNumber of comparisons: " + comparison+"\nAvg Comparisons: "+ comparison/numOfTimes);
	    return;
	  }

	public static double avgCPUTime(HashMap<Integer, Integer> HashMap) {
		//As the JVM warms up the amount of time taken will vary
		// The second time you run this will always be faster than the first
		//(The first time it has to load classes and call static blocks)
		//After you have run the method 10,000 times it will be faster again 
		long start=0;
		int runs = 10000; // enough to run for 2-10 seconds.
		for (int j = -10000; j < runs; j++) {
			if (j == 0) 
				start = System.nanoTime(); //records time at start of loop
			for (Integer i : HashMap.keySet()) {
				search(i, IndexOf(i)); //searches through entire list of postal codes
			}
		}

		long time = System.nanoTime() - start; //finds time taken to finish loop
		return (time / (runs*numOfData)); //avg time taken to do ONE search
	}

	public static int IndexOf(int key) {
		return (key % TABLE_SIZE);
	}

	public static void main(String[] args) {

		// Generate a key-value pair

		DataGen kvm = new DataGen(TABLE_SIZE, LOAD_FACTOR);
		HashMap<Integer, Integer> kvMap = new HashMap<Integer, Integer>();
		kvMap = kvm.getHash(); // SAVED into kvMap

		for (Integer i : kvMap.keySet()) {
			//System.out.println("Postal Code: " + i + " Population Size: " + kvMap.get(i));
			addKey(i, kvMap.get(i), IndexOf(i));
		}
		System.out.println("Number of Data: " + numOfData);
//		for (int i = 0; i < TABLE_SIZE; i++) {
//			if (Ctable[i] != null) {
//				System.out.println(((Ctable[i].element().getkey())));
//			}
//		}

		// End of KEY Gen
		int choice;
		do {
			Integer key;
			Scanner sc = new Scanner(System.in);
			System.out.println("-------- Example Class 2 Question 2 --------");
			System.out.println("| 1. Search");
			System.out.println("| 2. Add");
			System.out.println("| 3. Display Average CPU time");
			System.out.println("| 4. Display Average Key Comparison");
			System.out.println("| 5. Load Factor");
			System.out.println("| 6. Exit");
			choice = sc.nextInt();
			switch (choice) {
			case 1:// Search
				System.out.println("Please enter your key: ");
				key = sc.nextInt();
				if (search(key, IndexOf(key)) == -1)
					System.out.println("Postal Code not found.");
				else
					System.out.println("The value is: " + search(key, IndexOf(key)));
				break;

			case 2:// Add
				System.out.println("Enter the key: ");
				key = sc.nextInt();
				System.out.println("Enter the value: ");
				Integer value = sc.nextInt();
				addKey(key, value, IndexOf(key));

				// value = sc.NextInt();

			case 3:// Display Average CPU time
				System.out.println("Average CPU time (ns) is: "+avgCPUTime(kvMap));
				break;

			case 4:// Display Average Key Comparison
//				System.out.println("comparisons: " + comparison + " Number of Times: " + numOfTimes);
//				if (avgComparisons() == -1)
//					System.out.println("No Comparisons made yet.");
//				else
//					System.out.printf("Average Key Comparison: %.2f\n", avgComparisons());
				comparisons_all(kvMap);
				break;

			case 5:// Load Factor

				break;

			case 6:// Exit
				System.out.println("Thank you!!");
				break;
			}

		} while (choice < 6);

		/**
		 * Number of keys = tablesize * load factor loop call addkey
		 */

		/**
		 * collect timing collect comparision timings
		 */
	}

}