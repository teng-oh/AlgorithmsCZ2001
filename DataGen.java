package closedHashing;

import java.util.*;

public class DataGen {
	private HashMap<Integer, Integer> kvMap = new HashMap<Integer,Integer>();
	//DataGen has 1 attribute attribute 

    public DataGen(int TS,Double LF){
		int noOfEntry = (int) (TS*LF);                   // NO OF ENTRY MULTIPLIED BY THE LOAD FACTOR
		int gen =0;
		while(gen < noOfEntry) {
			this.kvMap.put(generatePostal(), generatePopSize());
            gen++;
		}		
	}

    public static int generatePopSize() {
    	int popSize = 0;
    	do {
        	popSize = (int) (Math.random() * 100);
    	} while(popSize == 0);
    	return popSize;
    }
    
    public static int generatePostal() {
		int firstHalf = 0;
		do {
			firstHalf = (int) (Math.random() * 1000);
		} while (firstHalf <= 100);
		int secondHalf = 0;
		do {
			secondHalf = (int) (Math.random() * 1000);
		} while (secondHalf % 4 != 0 || secondHalf <= 100);
		
		return firstHalf * 1000 + secondHalf;
	}	

	public HashMap getHash()
	{
		return this.kvMap;							// Returns the hashmap
	}
}
	