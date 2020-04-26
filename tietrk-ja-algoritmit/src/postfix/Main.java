package postfix;

public class Main {
	public static void main(String[] args) {
		int select = 0;
		PostfixCalc pc = new PostfixCalc();
		
		int value;
		String operator;
		
		while(select!=9) {
			System.out.println("**********");
			System.out.println("1. add number");
			System.out.println("2. add operator");
			System.out.println("3. print line");
			System.out.println("4. calculate");
			select = Lue.kluku();
			
			switch(select) {
			case 1: 
				value = Lue.kluku();
				pc.insert(value);
				break;
				
			case 2:
				operator = String.valueOf(Lue.merkki());
				try { pc.insert(operator); } catch (Exception e) { e.printStackTrace();}
				break;
				
			case 3: 
				PostfixUnit unit = pc.first;
				while(unit!=null) {
					System.out.println(unit.getValue() + " ");
					unit = unit.getRight();
				}
				break;
				
			case 4:
				double res = pc.calculate();
				System.out.println(res);
				break;
			}
		}
	}
}
