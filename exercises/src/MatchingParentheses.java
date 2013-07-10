import java.util.Stack;

/**
 * This class solves the following problem.
 * A common problem for compilers and text editors is determining whether the
 * parentheses in a string are balanced and properly nested.
 * For example,the string ((())())() contains properly nested pairs of parentheses, which the
 * strings )()( and ()) do not. Give an algorithm that returns true if a string contains
 * properly nested and balanced parentheses, and false if otherwise. For full credit, identify the position
 * of the first offending parenthesis if the string is not properly
 * nested and balanced.
 * @author ragini
 *
 */

public class MatchingParentheses {

	public static boolean match(String testString) {
		Stack<Character> stack = new Stack<>();
		compareCharacter(testString, stack, '(', ')');
		if(stack.size() > 0) {
			return false;
			
		} else {
			return true;
		}
	}

	private static void compareCharacter(String testString, Stack<Character> stack,
			Character leftParenthesis, Character rightParenthesis) {
		int countIndex=0;
		for(int index=0; index< testString.length(); index++) {
			if(leftParenthesis.equals(testString.charAt(index))) {
				stack.push(testString.charAt(index));
			} 
			if(rightParenthesis.equals(testString.charAt(index))) {
				if(!stack.empty()) {
					stack.pop();
				}
				else {
					countIndex = index + 1;
					System.out.println("String does not have matching parenthesis at: "+countIndex);
				}
			}
		}
	}
}
