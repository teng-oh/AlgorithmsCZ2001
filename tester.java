import java.util.HashMap;

//import java.util.*;

public class tester{
    public static void main(String[] args) {
        DataGen kvm = new DataGen(10,0.5);
        HashMap<Integer, Integer> kvMap = new HashMap<Integer, Integer>();
        kvMap = kvm.getHash();
        
         for (Integer i : kvMap.keySet()) {
		 	System.out.println("key: " + i + " value: " + kvMap.get(i))	;
         }
            
    }
}