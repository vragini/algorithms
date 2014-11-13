
public class StringReversalByWord {
	
	public static void main(String[] args) {
		String str = "The quick brown fox jumped over the lazy dog!";
		str= reverse(str);
		System.out.println(str);
		
	}
	
	
	private static String reverse(String str) {
	      char charArray[] = str.toCharArray();
	    for (int i = 0; i <str.length(); i++){
	        if(charArray[i] == ' ')
	        return reverse(str.substring(i + 1)) + str.substring(0, i) + " ";
	    }
		return str + " ";

	    
	}
}
