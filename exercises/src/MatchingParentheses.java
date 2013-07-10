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

	public static int findMismatchPosition(String testString) {
		Stack<Integer> stack = new Stack<>();
		for(int index=0; index< testString.length(); index++) {
			char ch = testString.charAt(index);
			switch (ch) {
			case '(':
				stack.push(index+1);
				break;
			case ')':
				if(stack.isEmpty()){
					return index +1;
				}
				stack.pop();
				break;
			}
		}
		
		int result = 0;
		while(!stack.empty()){
			result = stack.pop();
		}
		return result;
	}
}
