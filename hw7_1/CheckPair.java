import java.util.Stack;

public class CheckPair {

	private String exp;
	private int expSize;
	private char testCh;
	private char openPair;

	public boolean testPair(String exp) {
		this.exp = exp;
		Stack<Character> stack = new Stack<>();
		expSize = this.exp.length();

		for(int i=0; i<expSize; i++) {
			testCh = this.exp.charAt(i);

			switch(testCh) {
			case'(':
			case'{':
			case'[':
			case'<':
				stack.push(testCh);
				break;
			case')':
			case'}':
			case']':
			case'>':
				if(stack.isEmpty()) {
					return false;
				}
				else {
					openPair = stack.pop();
					if(
							(openPair == ')' ) && (testCh != '(') ||
							(openPair == '}' ) && (testCh != '{') ||
							(openPair == ']' ) && (testCh != '[') ||
							(openPair == '>' ) && (testCh != '<'))
						return false;
					else
						break;

				}
			}
		}

		if(stack.isEmpty())
			return true;
		else
			return false;

	}
}
