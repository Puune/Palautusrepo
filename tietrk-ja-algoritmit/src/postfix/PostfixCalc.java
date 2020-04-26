package postfix;

public class PostfixCalc {
	PostfixUnit first;
	PostfixUnit last;
	
	public void insert(int num) {
		if(first==null) {
			first = new PostfixUnit("number", num);
			last = first;
		} else {
			PostfixUnit newUnit = new PostfixUnit("number", num);
			newUnit.setLeft(last);
			last.setRight(newUnit);
			last = last.getRight();
		}
	}
	
	
	public void insert(String operator) throws Exception {
		if(first==null) {
			throw new Exception("Bad input");
		}
		
		PostfixUnit newUnit = new PostfixUnit("operator", operator);
		newUnit.setLeft(last);
		last.setRight(newUnit);
		last = newUnit;
	}
	
	
	PostfixUnit cursor;
	public double calculate() {
		cursor = last;
		System.out.println("Cursor at: " + cursor.getValue());
		return calculateRecursive();
	}
	
	private double calculateRecursive() {
		double value1;
		double value2;
		
		if(cursor.getType().equals("operator")) {
			String operator = cursor.getValue();
			
			cursor = cursor.getLeft(true);
			value1 = calculateRecursive();
			
			cursor = cursor.getLeft(true);
			value2 = calculateRecursive();
			
			System.out.println("calculating " + value2 + " " + operator + " " + value1);
			
			try {
				return calculator(value2, value1, operator);
				
			} catch (Exception e) { }
			
		} else {
			return Double.parseDouble(cursor.getValue());
		}
		
		return 0;
	}
	
	
	private double calculator(double left, double right, String operator) throws Exception {
		char op = operator.charAt(0);
		double result = -1;
		switch(op) {
		case '+':
			result = left + right;
			break;
		
		case '-':
			result = left - right;
			break;
			
		case '*':
			result = left * right;
			break;
			
		case '/': 
			result = left / right;
			break;
			
		default:
			throw new Exception("Bad operator");
		}
		
		return result;
	}
}
