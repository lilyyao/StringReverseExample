public class StringReverseExample {

    public static void main(String args[]) {

        //original string
        String str = "hello";
        System.out.println("Original String: " + str);

        //StringBuffer's reverse method 
        String reverseStr = new StringBuffer(str).reverse().toString();
        System.out.println("Reverse String in Java using StringBuffer: " + reverseStr);

        //iterative method
        reverseStr = reverseIndexIterate(str);
        System.out.println("Reverse String in Java using Iteration: " + reverseStr);

        //recursive method. Using substring - takes too much memory though
        reverseStr = reverseRecursively(str);
        System.out.println("Reverse String in Java using Recursion substring: " + reverseStr);

        System.out.println("Reverse String in Java using Recursion substring: ");
        reverseRecursive(str);
        
        //recursive method.      
		StringBuffer sb = new StringBuffer();
        reverseStr = reverseRecursive(str, sb);
        System.out.println("\nReverse String in Java using Recursion substring + StringBuffer: " + reverseStr);

        //recursive method. No substring, just Index.    
        System.out.println("Reverse String in Java using Recursion index: ");
        reverseRecursive(str, 0);       
        
    }

    public static String reverseIndexIterate(String s) {
        StringBuilder sb = new StringBuilder();
        Character c; 
        
		for (int i=0; i<s.length(); i++) {
			c = s.charAt(s.length()-i-1);
			sb.append(c);
		}

        return sb.toString();
    }


    public static String reverseRecursively(String str) {

        //BASE CASE to handle one char string and empty string
        if (str.length() < 2) {
            return str;
        }

        return reverseRecursively(str.substring(1)) + str.charAt(0);
    }

	public static String reverseRecursive(String s, StringBuffer sb) {
	
		if ( s.length() == 1) {   // STOP 
			sb.append(s);
			return sb.toString();
		}
		
		reverseRecursive(s.substring(1), sb); // REDUCE, 1 at a time, 1 --> substring(0,1) 
			
		sb.append(s.charAt(0)); 		 // LOCATION - action AFTER recursive call for reversed order.
											 // ACTION - add to the output StringBuilder 
		
		return sb.toString();

	}
	
	public static void reverseRecursive(String s) {
		
		if ( s.length() == 1) {   // STOP - BASE CASE. No longer call itself. 
			System.out.print(s);
			return;
		}

		reverseRecursive(s.substring(1)); // RECURSION WITH REDUCTION 
			
		System.out.print(s.charAt(0));    // LOCATION - action AFTER recursive call for reversed order.
										  // ACTION - print out 

	}
	
	public static void reverseRecursive(String s, int pos ) {
		
		if ( s.length()-1 == pos) {   // STOP - base case. reach the end of the string
			System.out.print(s.charAt(pos));
			return;
		}
			
		reverseRecursive(s, ++pos); // REDUCE/MOVING 1 at a time  
		
		System.out.print(s.charAt(pos-1));
	
	}

}