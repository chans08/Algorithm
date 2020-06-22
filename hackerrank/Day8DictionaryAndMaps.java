package hackerrank;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Day8DictionaryAndMaps {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        Map<String, Integer> phoneBook = new HashMap<String, Integer>();

        for(int i = 0; i < n; i++){
            String name = in.next();
            int phone = in.nextInt();
            // Store name, phoneNumber pair to phoneBook
            phoneBook.put(name, phone);
        }
        while(in.hasNext()){
            String s = in.next();
            // find phoneNumber by name
            Integer phoneNumber = phoneBook.get(s);
            if (phoneNumber == null) {
            	System.out.println("Not found");
            	continue;
            }
            System.out.printf("%s=%d\r\n", s, phoneNumber);
        }
        in.close();
	}
}
