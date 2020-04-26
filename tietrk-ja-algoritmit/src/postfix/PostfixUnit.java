package postfix;

public class PostfixUnit {
	private String type;
	private String valueOperator;
	private double valueNum;
	
	public PostfixUnit(String type, String value) {
		this.type = type;
		valueOperator = value;
	}
	public PostfixUnit(String type, double value) {
		this.type = type;
		valueNum = value;
	}
	
	
	private PostfixUnit left;
	public void setLeft(PostfixUnit unit) {
		left = unit;
	}
	public PostfixUnit getLeft(boolean print) {
		if(left!=null)
			System.out.println("Cursor at: " + left.getValue());
		return left;
	}
	public PostfixUnit getLeft() {

		return left;
	}
	
	
	
	private PostfixUnit right;
	public void setRight(PostfixUnit unit) {
		right = unit;
	}
	public PostfixUnit getRight(boolean print) {
		if(right!=null)
			System.out.println("Cursor at: " + right.getValue());
		return right;
	}
	public PostfixUnit getRight() {
		return right;
	}
	
	
	
	public String getValue(){
		if(type.equals("operator"))
			return valueOperator;
		else
			return String.valueOf(valueNum);	
	}
	
	public String getType() {
		return type;
	}
}
